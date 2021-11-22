## Ezen Rentcar 2조 TEAM
<details>
<summary>Click</summary>
<div markdown="1">
  
- 렌트카 서비스의 구축을 목표로 잡았습니다.
- 차량등록과 예약시스템이 렌트카 서비스의 핵심..
  
</div>
</details>

## 주제 
<details>
<summary>Click</summary>
<div markdown="1">
  
- 렌트카 예약 관리 시스템 
  
</div>
</details>

## 프로젝트 소개
<details>
<summary>Click</summary>
<div markdown="1">
  
<p>사용자와 관리자의 서비스를 기반으로 한 렌트카 예약 관리 시스템을 구축할 것 입니다. </p>
<p>관리자와 사용자간의 편리한 서비스를 구축하기위해 차량관리, 예약관리, 사용자와 관리자간의 소통시스템을 위주로 설계하였습니다.</p>

</div>
</details>

## 환경


<details>
<summary>Click</summary>
<div markdown="1">
  
  
![사용 가능 스택](https://user-images.githubusercontent.com/61840067/141501552-a8794837-9fed-4b3a-b191-fb57eaa6070c.PNG)
- jdk11
- JavaFx 
- raspberrypi (rasbian) debian linux
- MariaDB(server)<br>
- Git<br>
- Eclipse<br>

</div>
</details>

## 서비스 설계 
<details>
<summary>Click</summary>
<div markdown="1">
  
![Rent_11_05 요구사항 기능](https://user-images.githubusercontent.com/61840067/140478880-b6c64bdd-ea4e-45a0-ad89-d6e1c6421d12.JPG)
</div>
</details>

## 프로젝트 기간
> 11_05 ~ 11_22(22일 발표)

## 개발일정 

<details>
<summary>Click</summary>
<div markdown="1">
  
|날짜|내용|
|----|----|
|2021.11.05|주제 선정 및 화면 목업 및 로고 제작 및 주요기능 세부 설정 및 서비스 기능 설계|
|2021.11.08|Database 설계 초안, 메인폰트 및 화면규격, 메인 색상 테마 결정 |
|2021.11.09|Database 설계 완성, 화면 관계도 초안 작성 |
|2021.11.10|화면 관계도 [완료]|
|2021.11.11|DB 외부 서버 연동(라즈베리파아 마리아 DB 연동), 씬빌더 FXML 제작 , 로그인 페이지 서버연동 확인|
|2021.11.12 ~ 2021.11.16|개인 작업|
|2021.11.17 ~ 2021.11.21|프로젝트 연결 및 오류 수정|
|2021.11.22|프로젝트 발표|

</div>
</details>

## 역할 분담
> 김태호 : 설계 / Reservation / FXML<br>
> 조지훈 : Member / Board <br>
> 최병호 : Car / Reservation / Admin / 발표

## 주요 기능
<details>
<summary>Click</summary>
<div markdown="1">
  
> 손님
  1. 회원가입 
  2. 로그인
  3. 아이디 찾기
  4. 비밀번호 찾기
  5. 예약하기

> 관리자
  1. 차량관리 ( 차량등록/조회/삭제 등)
  2. 예약리스트 
  3. 예약관리
  
> 예약시스템
  1. 예약 (날짜선택 / 차량선택)
  2. 예약확인 (차량리스트 / 예약등록(팝업) )
  3. 예약취소
  
</div>
</details>

## [프론트 설계 규격]

<details>
<summary>Click</summary>
<div markdown="1">

<h3>1. 화면 규격</h3>
  <p><h4>1280 x 720</h4></p>
  
<h3>2. 메인 폰트</h3><br> 
  
  <img src="https://user-images.githubusercontent.com/61840067/141503419-d5e5f12e-58c6-420b-859e-f131bbddcdd2.png"  width="400" height="200"/>
  
<h3>3. 메인 색상 테마</h3><br> 
  
  <img src="https://user-images.githubusercontent.com/61840067/141503065-27d27c9e-8bfd-48ef-b5f1-98f530d32637.png"  width="400" height="200"/>

<h3>4. 로고</h3><br>
  
  <img src="https://user-images.githubusercontent.com/61840067/141504200-7af136e7-561a-45d7-8901-d591a37ec9f6.png"  width="400" height="200"/>
  
</div>
</details>

## 목업 (프로토 타입)
<details>
<summary>Click</summary>
<div markdown="1">
  
![asd drawio](https://user-images.githubusercontent.com/61840067/140482872-9e33d121-18b2-45b6-a30c-e6db083a6606.png)
  
</div>
</details>

## [DB설계]
<details>
<summary>Click</summary>
<div markdown="1">
  
![2021_11_10_11](https://user-images.githubusercontent.com/61840067/141075556-f27d0112-2603-4c38-be8f-52868a439a04.png)

</div>
</details>

## 관계도(depth) Controller구조
<details>
<summary>Click</summary>
<div markdown="1">
  
![2021_11_10_17 (관계도 당일날짜 재정리) drawio](https://user-images.githubusercontent.com/61840067/141075388-9e2518fb-fb97-452b-9356-bb09f054e52e.png)

</div>
</details>

## presentation - 21/11/22 
<details>
<summary>Click</summary>
<div markdown="1">
  
  <div>■ 발표자 : 최병호</div>
  <hr>
  <div>
    ■ 발표자료
[211122-발표자료.pdf](https://github.com/cbh1124/Ezen_newrent/files/7579010/211122-.pdf)

  </div>
  <hr>
  <div>■ 주요 메소드 및 기능1개 소개</div>
   1. 날짜선택 (렌트일/ 반납일) 
   2. 검색 및 카테고리 선택 후 search 
   3. 차량리스트 선택 및 선택하기 
   4. 예약하기 >> 팝업창 >> SQL DB반영 

  <hr>
  <br>
  
  <div>■ 보완할 점
    <p> 1. 게시판 미완성</p>
    <p> 2. 예약시스템의 반납여부의 부재</p>
    <p> 3. 소통의 중요성</p>
    <p> 4. DB 설계 (자동차와 예약자간의 pk fk 간의 문제점) </p>
    <p> 5. home controller 미완성 </p>
  </div>
  
  
  <hr>
  <br>
  <div>■ 느낀점, 힘들었던점, 힘들었을때 해결했던 방법</div>
  <ul>
    <br>
    <p> >> 조지훈</p>
    <li> 느낀점 : 새로 배운 fx를 사용하는 프로젝트라 어려우면서도 재미있게 작업을 하였습니다.</li>
    <li> 힘들었던 점 : 제가 담당한 부분은 주로 수업시간에 진행했던 회원 부분과 게시판 부분이었는데, 수업시간에 배운 부분이지만, 조금 더 다른 부분을 추가하려고 하면 구현이 되지 않는 부분들이 생겨서 시간을 많이 소비한 부분이 아쉬웠습니다.</li>
    <li> 해결방법 : 제가 모르는 부분을 팀원들과의 소통으로 많은 부분을 해결할 수 있었습니다.</li>
    <br>
    <p> >> 최병호</p>
    <li> 느낀점 : 이번 프로젝트를 진행하면서 안되는 부분을 해결하면서 많이 배웠습니다. 프로젝트를 진행하는 실무적인 활동이 저에게 이해가 안되는 퍼즐들을 맞춰주었습니다.  </li>
        <li> 힘들었던 점 : 설계와 소통 화합이 가장 어려웠습니다. 초기설계의 중요성과 소통의 중요성을 다시 한번 더 알게되는 좋은 계기가 되었는데 팀원들과 다른 관점으로 바라보는 설계와 코드를 짜면서 진행하는 소통의 부재가 후에 많은 후회를 주었습니다.   </li>
    <li> 해결방법 : 제일 중요한건 소통인것 같습니다. 한번씩 제가 해결이 안될때마다 누군가와 같이 코드를 짜거나 설계를 짠다는것이 저의 관점에서 막힌점을 다른점으로 볼 수 있어서 그런 부분이 가장 중요했던것 같습니다.    </li>
    <br>
    <p> >> 김태호</p>
    <li> 느낀점 : 콘솔프로젝트랑 다르게 fxml을 토대로 코드를 따오고, 화면시각적인 모습을 같이 구현해보니 보다 흥미롭게 작업을 진행할 수 있었습니다. </li>
    <li> 힘들었던 점 : 주요메인인 예약메소드가 후반부에 작업이 진행되어 구현하는데 진행이 더디게 된점이 아쉬웠고, 수업시간 이외에 이용하는 코드들을 많이 찾아보았지만, 구현하는데 어려움이 있었습니다.</li>
    <li> 해결방법 : 서로 모르는 것들과 충분한 토의를 통하여서 각자 맡은 할일을 묵묵히 수행해준 덕분에 구현하는데 큰 힘이 된 거 같습니다.</li>
  </ul>


</div>
</details>







