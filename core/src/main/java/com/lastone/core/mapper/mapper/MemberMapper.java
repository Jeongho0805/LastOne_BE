package com.lastone.core.mapper.mapper;

import com.lastone.core.domain.member.Day;
import com.lastone.core.domain.member.Member;
import com.lastone.core.dto.member.MemberDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import java.util.Arrays;
import java.util.List;



@Mapper(componentModel = "spring")
public interface MemberMapper extends GenericMapper<MemberDto, Member> {


    @Mapping(target = "workoutDay", source = "workoutDay", qualifiedByName = "toWorkoutDayAsList")
    @Override
    MemberDto toDto(Member member);

    @Mapping(target = "workoutDay", source = "workoutDay", qualifiedByName = "toWorkoutDayListAsString")
    @Override
    Member toEntity(MemberDto dto);

    @Override
    List<MemberDto> toDto(List<Member> e);

    @Named("toWorkoutDayAsList")
    default List<String> toWorkoutDaysList(String workoutDay) {
        return Arrays.asList(workoutDay.split(" "));
    }

    @Named("toWorkoutDayListAsString")
    default String toWorkoutDayListAsString(List<String> workoutDays) {
        return Day.sortListToString(workoutDays);
    }
}
