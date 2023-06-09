## Last One 🏋

<div align="center">
  
  ![image](https://github.com/Jeongho0805/demotest/assets/96610382/90ba03e8-8c38-4b20-9538-a02e261a6349)
  ###  마지막 한 세트를 위한 헬스 메이트 찾기 Last One

</div>
  


<br/>

- **프로젝트 명 : LastOne(라스트원)**
- **프로젝트 기간 : 2023.02.15 ~ 2023.05.15**
- **수정 & 리팩토리 기간 : 2023.05.16 ~ (진행중)**
- **배포 링크 : [https://lastoneapp.vercel.app](https://last-one-front-end.vercel.app/)**

<br/>

## :information_desk_person: 소개

- 운동 메이트 없이 혼자 헬스하기 지겨우신가요?
- 운동 보조가 있으면 근성장이 될 것 같은 생각이 드시나요?
- 그렇다면 LastOne에서 나만의 헬스 파트너를 찾아보세요!

<br/>

## 👀 주요 기능 미리보기


</br>
</br>

## 👨‍👨‍👧‍👧팀원 


|                                           Backend                                           |                                           Backend                                           |                                          Designer                                          |                                           Frontend                                         |                                                          Frontend                                                         |                                                          Frontend                                                          |
|:-------------------------------------------------------------------------------------------:|:-------------------------------------------------------------------------------------------:|:------------------------------------------------------------------------------------------:|:-----------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------:|:--------------------------------------------------------------------------------------------------------------------------:|
| <img src="https://github.com/Jeongho0805/demotest/blob/main/img/jeongho.png" width=400px /> | <img src="https://github.com/Jeongho0805/demotest/blob/main/img/Kyuhyun.png" width=400px /> | <img src="https://github.com/Jeongho0805/demotest/blob/main/img/gyuwon.png" width=400px /> | <img src="https://github.com/Jeongho0805/demotest/blob/main/img/beomsu.png" width=400px /> | <img src="https://github.com/Jeongho0805/demotest/assets/96610382/be84e7d3-e4ad-4207-b03c-fd0b43c29d0b.png" width=400px /> | <img src="https://github.com/Jeongho0805/demotest/assets/96610382/7fe6822a-174e-4b92-8c26-b7b0571a359c.png" width=400px /> | 
|                            [박정호](https://github.com/Jeongho0805)                            |                             [황규현](https://github.com/beetrbgus)                        |                      [조규원](https://www.behance.net/ku_oni/moodboards)                    |                              [배범수](https://github.com/Bsfla)                            |                                             [이하람](https://github.com/HalamLee)                                           |                                             [김태영](https://github.com/overtae)                                           |





</br>
</br>

## 👨‍💻 아키텍처

<img src="https://github.com/Jeongho0805/demotest/blob/main/img/architecture.jpg" />

<br/>
</br>

## 📃 API 명세서 [링크](https://six-skirt-6ca.notion.site/19f4bc4659d840a1a295bb571da01b7f?v=e3b86639da3143fd96d74c89b500e8df&pvs=4)

<div align="center">
  
  <img src = "https://github.com/Jeongho0805/LastOne_BE/assets/96610382/2e86f2ef-6e66-4ce6-8fe7-a0d3d471bc63.jpg" height=800px />

</div>


<br/>
<br/>

## 📈 쿼리 성능 개선 목록

### ✔️ 마이페이지 조회 

**100만 건 데이터 기준 쿼리 성능 0.01sec** [링크](https://tough-echinacea-3e3.notion.site/fc6ea7fc87b14e77b340184e3fd59f27?pvs=4)

<br/>

### ✔️ 모집글 목록조회

**조건이 없을 경우 : (3.959sec ➡ 0.141sec) 3초 가량 단축** (FetchJoin 및 BatchSize 활용) [링크](https://tough-echinacea-3e3.notion.site/0d76058a9a674e3ab861653b932bb828?pvs=4)

**조건이 있을 경우 : (6.240sec ➡ 0.22sec) 6초 가량 단축** (날짜 역순 인덱스 및 ngram 방식 Full Text Index 활용) [링크](https://tough-echinacea-3e3.notion.site/01310350921244e5a4339e4d9f3505ff?pvs=4)

<br/>

### ✔️ 모집글 상세 조회

**100만 건 데이터 기준 쿼리 성능 (0.03sec ➡️ 0.002sec) 0.028초 가량 단축** (DTO 조회 방식에서 Entity 조회 방식으로 변경, Fetch Join 활용) [링크](https://tough-echinacea-3e3.notion.site/b6df147dd39248a0935fa2e04b063f5c?pvs=4)











