package com.lastone.core.dto.mypage;

import com.lastone.core.dto.gym.GymDto;
import com.lastone.core.dto.gym.GymUpdateDto;
import com.lastone.core.dto.member.MemberUpdateDto;
import com.lastone.core.dto.sbd.SbdDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.List;

@Getter
@Setter
public class MyPageUpdateDto {

    @Valid
    private MemberUpdateDto member;

    @Valid
    private List<GymDto> gyms;

    @Valid
    private SbdDto sbd;

}
