## Last One 🏋

<div align="center">
  
  ![image](https://github.com/Jeongho0805/demotest/assets/96610382/90ba03e8-8c38-4b20-9538-a02e261a6349)
  ###  마지막 한 세트를 위한 헬스 메이트 찾기 Last One

</div>
  


<br/>

- **프로젝트 명 : LastOne(라스트원)**
- **프로젝트 기간 : 2023.02.15 ~ 2023.05.15**
- **수정 & 리팩토리 기간 : 2023.05.16 ~ (진행중)**
- **배포 링크 : https://lastoneapp.vercel.app**

<br/>

## 소개 :information_desk_person:

- 운동 메이트 없이 혼자 헬스하기 지겨우신가요?
- 운동 보조가 있으면 근성장이 될 것 같은 생각이 드시나요?
- 그렇다면 LastOne에서 나만의 헬스 파트너를 찾아보세요!

<br/>

## 주요 기능 미리보기 👀


</br>
</br>

## 팀원 👨‍👨‍👧‍👧

|                                           Backend                                           |                                              Backend                                                             |                                                                       Frontend                            |                                                              Designer                                                     |
|:-------------------------------------------------------------------------------------------:|:----------------------------------------------------------------------------------------------------------------:|:---------------------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/Jeongho0805/demotest/blob/main/img/jeongho.png" width=300px /> |        <img src="https://github.com/Jeongho0805/demotest/blob/main/img/Kyuhyun.png" width=300px />               |              <img src="https://github.com/Jeongho0805/demotest/blob/main/img/beomsu.png" width=300px />   |          <img src="https://github.com/Jeongho0805/demotest/blob/main/img/gyuwon.png" width=300px />                       |
|                            [박정호](https://github.com/Jeongho0805)                          |                                  [황규현](https://github.com/beetrbgus)                                         |                                           [배범수](https://github.com/Bsfla)                               |                                               [조규원](https://www.behance.net/ku_oni/moodboards)                         |


</br>
</br>

## 아키텍처 👨‍💻

<img src="https://github.com/Jeongho0805/demotest/blob/main/img/architecture.jpg" />

<br/>
</br>

## API 명세서 📃

<div align="center">
  
  **[ API 명세서 링크](https://www.notion.so/19f4bc4659d840a1a295bb571da01b7f?v=e3b86639da3143fd96d74c89b500e8df)**

  <img src = "https://github.com/Jeongho0805/demotest/blob/main/img/api.jpg" height=800px />

</div>


<br/>
<br/>

## 쿼리 성능 개선 목록 📈

[마이페이지 조회](https://www.notion.so/fc6ea7fc87b14e77b340184e3fd59f27) 

100만 건 데이터 기준 쿼리 성능 0.01sec

<br/>

[모집글 목록 조회](https://www.notion.so/0d76058a9a674e3ab861653b932bb828) 

### 더미 데이터 목록 </br>
100,000 건의 모집글 데이터 (검색 조건 반영하여 각각의 칼럼 분기 처리하여 생성) </br>
300,000 건의 모집글 이미지 데이터 </br>
17,000 건의  회원 데이터 </br>
10,000 건의 헬스장 데이터 </br>


조건이 없을 경우 :  (3.959sec ➡️ 0.141sec) 3초 가량 단축 (FetchJoin 및 BatchSize 활용)









