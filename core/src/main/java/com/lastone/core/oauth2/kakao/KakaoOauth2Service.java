package com.lastone.core.oauth2.kakao;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lastone.core.domain.member.Member;
import com.lastone.core.oauth2.Oauth2Service;
import com.lastone.core.repository.member.MemberRepository;
import com.lastone.core.security.jwt.TokenResponse;
import com.lastone.core.security.jwt.JwtProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.util.Map;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class KakaoOauth2Service implements Oauth2Service {

    private final MemberRepository memberRepository;
    private final RedisTemplate<String, String> redisTemplate;
    private final KakaoConfig kakaoConfig;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    private final JwtProvider jwtProvider;


    @Transactional(rollbackFor = Exception.class)
    public TokenResponse createToken(String code, String requestURI) throws JsonProcessingException {
        String token = getToken(code);
        KakaoOauth2UserInfo profile = getProfile(token);
        Optional<Member> member = memberRepository.findByEmail(profile.getEmail());
        if(member.isEmpty()) {
            memberRepository.save(Member.builder()
                    .email(profile.getEmail())
                    .gender(profile.getGender())
                    .build());
        }
        TokenResponse tokens = jwtProvider.createToken(profile.getEmail(), requestURI);
        redisTemplate.opsForValue()
                .set("refresh_token:" + profile.getEmail(), tokens.getRefreshToken(), jwtProvider.getRefreshTokenDuration(), TimeUnit.MILLISECONDS);
        return tokens;
    }

    private String getToken(String authCode) throws JsonProcessingException {
        HttpHeaders header = new HttpHeaders();
        header.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(kakaoConfig.getTokenParams(authCode), header);

        ResponseEntity<String> response = restTemplate.postForEntity(kakaoConfig.getTokenUrl(), request, String.class);
        KakaoToken kakaoToken = objectMapper.readValue(response.getBody(), KakaoToken.class);

        return kakaoToken.getAccess_token();
    }

    private KakaoOauth2UserInfo getProfile(String token) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.set("Authorization", "Bearer " + token);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate.postForEntity(kakaoConfig.getUserInfoUri(), request, String.class);

        if(response.getStatusCode() != HttpStatus.OK) {
            throw new IllegalArgumentException("유저 정보 업로드 실패");
        }
        Map<String,Object> kakaoOAuthResponseDto = objectMapper.readValue(response.getBody(), Map.class);
        return new KakaoOauth2UserInfo(kakaoOAuthResponseDto);
    }
}
