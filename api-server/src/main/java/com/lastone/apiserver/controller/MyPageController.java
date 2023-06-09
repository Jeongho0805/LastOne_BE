package com.lastone.apiserver.controller;

import com.lastone.apiserver.service.mypage.MyPageService;
import com.lastone.core.common.response.CommonResponse;
import com.lastone.core.common.response.SuccessCode;
import com.lastone.core.dto.mypage.MyPageDto;
import com.lastone.core.dto.mypage.MyPageUpdateDto;
import com.lastone.core.security.principal.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/mypage")
public class MyPageController {

    private final MyPageService myPageService;

    @GetMapping("{memberId}")
    public ResponseEntity<Object> getMyPageByMemberId(@PathVariable Long memberId) {
        MyPageDto myPage = myPageService.getMyPage(memberId);
        return ResponseEntity.ok().body(CommonResponse.success(myPage, SuccessCode.INQUIRE_MYPAGE.getMessage()));
    }

    @GetMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> getMyPageByToken(@AuthenticationPrincipal UserDetailsImpl userDetails) {
        MyPageDto myPagedto = myPageService.getMyPage(userDetails.getId());
        return ResponseEntity.ok().body(CommonResponse.success(myPagedto, SuccessCode.INQUIRE_MYPAGE.getMessage()));
    }

    @PutMapping
    @PreAuthorize("isAuthenticated()")
    public ResponseEntity<Object> updateMyPage(@AuthenticationPrincipal UserDetailsImpl userDetails,
                                               @RequestPart(required = false) @Validated MyPageUpdateDto myPage,
                                               @RequestPart(required = false) MultipartFile profileImg) throws IOException {
        Long memberId = userDetails.getId();
        myPageService.updateMyPage(memberId, myPage, profileImg);
        return ResponseEntity.ok().body(CommonResponse.success(SuccessCode.UPDATE_MYPAGE.getMessage()));
    }
}
