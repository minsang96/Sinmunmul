# 빅데이터 신문 분석 서비스 "신문물"
![header](https://capsule-render.vercel.app/api?type=waving&color=0:9e9e9e,45:EFECEA,70:8d8d8d,100:eeeeee&height=300&section=header&text=신%20문%20물&fontColor=343a40&fontSize=120)

## 프로젝트 소개
### 🗞 신문물
- 신문물은 hadoop을 사용해 뉴스기사를 저장하고 읽어서 토큰화하여 분석하는 서비스입니다.
<br/>

### :star2: 특징
- 시간별(실시간, 주별, 월별) 이슈 키워드 정보를 제공합니다.
- 기사 검색 서비스를 제공합니다.
- 검색 키워드 연관어 정보를 제공합니다.
- 사용자 추천 기사 서비스를 제공합니다.
<br/>

### :gift_heart: 주요 기능
    * 회원 관리 (회원가입, 로그인, 수정)
    * 오늘의 키워드
    * 키워드 검색
    * 스크랩 기능
<br/>

### ⚙️ 주요 기술
    * Scrapy
      => 네이버 뉴스의 기사를 수집하기 위해 크롤러로 사용합니다.
    * KoBERT
      => 관심사별 뉴스를 추천하기 위해 KoBERT 모델로 뉴스의 감정을 분석합니다.
    * Spring Security / JWT Authentication
      => 사용자의 간편 로그인과 보안을 위해 Spring Security를 통해 사용자 정보를 암호화 합니다.
    * JPA
      => 빠른 개발을 위해 JPA를 통해 데이터를 조작합니다.
    * REST API
      => Server와 Frontend와의 효율적인 협업을 위해 REST API방식으로 통신합니다.
<br/>

### 💎 참조 리소스
    * Bootstrap : 디자인 전반 적용
    * Chart.js : 데이터 시각화
    * vue-number-animation : 애니메이션 파일. 디자인 포인트로 사용
    * KoBERT : 감정 분석을 위해 사용
<br/>

<br/>

## 팀원 소개 
<table>
  <tr height="100px">
    <td align="center" width="15%">
      <img src="https://user-images.githubusercontent.com/69743476/162619498-df8d14a9-ea18-4063-a847-aac9d78b9da2.jpg"/></a>
    </td>
    <td align="center" width="15%">
      <img src="https://user-images.githubusercontent.com/69743476/162619504-f3d9925a-e322-4992-8fff-79b47646b149.jpg"/></a>
    </td>
    <td align="center" width="15%">
      <img src="https://user-images.githubusercontent.com/69743476/162619507-6f50c96e-082e-4c1f-8f47-698b6db345a6.jpg"/></a>
    </td>
    <td align="center" width="15%">
      <img src="https://user-images.githubusercontent.com/69743476/162619509-e9c39a07-4539-4ce0-b664-618aee56af3e.jpg"/></a>
    </td>
    <td align="center" width="15%">
      <img src="https://user-images.githubusercontent.com/69743476/162619511-8a80063c-ff75-4fb6-8e45-f2ab441d32cc.jpg"/></a>
    </td>
    <td align="center" width="15%">
      <img src="https://user-images.githubusercontent.com/69743476/162619513-7b4e18a3-1381-4673-a01d-032e64ae546a.jpg"/></a>
    </td>
  </tr>
  <tr height="70px">
    <td align="center" width="15%">
      👑 임재현(팀장)
      <br /><br />
      프론트엔드 개발<br />Jira 관리
    </td>
    <td align="center" width="15%">
      김하영
      <br /><br />
      프론트엔드 개발<br />발표
    </td>
    <td align="center" width="15%">
      배용한
      <br /><br />
      프론트엔드 개발<br />UCC 제작
    </td>
    <td align="center" width="15%">
      손수연
      <br /><br />
      백엔드 개발
    </td>
    <td align="center" width="15%">
      유민상
      <br /><br />
      백엔드 개발
    </td>
    <td align="center" width="15%">
      허은아
      <br /><br />
      백엔드 개발<br />AWS, CI/CD 담당
    </td>
  </tr>
</table>
<br/>
<br/>

## 프로젝트 상세 설명
### ⚙️ 개발 환경
- JIRA : 애자일 및 소프트웨어 개발 프로젝트를 기획, 트래킹 및 관리 협업 툴
- Gitlab : 깃 저장소 및 CI/CD, 이슈 추적, 보안성 테스트 등의 기능을 갖춘 웹 기반의 데브옵스 플랫폼
- Visual Studio Code : JavaScript 및 웹 개발을 위한 소스 코드 편집기, 다양한 확장 기능 제공
- SpringToolSuite : Spring 기반 엔터프라이즈 애플리케이션 개발을 위한 지원을 제공하는 통합 개발 환경
<br/>

### 🔨 기술 스택
- Vue.js 3.0.0
- JavaScript
- Bootstrap 5
- Java (Open JDK 1.8.0)
- Spring Boot 2.5.6
- FastAPI 0.75.0
- MySQL 8.0.27
- Ubuntu 20.04

### And Our Basic Skills 🛠️
<img src="https://img.shields.io/badge/JAVA-007396?style=flat-square&logo=java&logoColor=white"> <img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=Spring&logoColor=white">
<img src="https://img.shields.io/badge/mysql-4479A1?style=flat-square&logo=mysql&logoColor=white">
<img src="https://img.shields.io/badge/python-F6C73B?style=flat-square&logo=python&logoColor=white">
<br/>
<img src="https://img.shields.io/badge/html-E34F26?style=flat-square&logo=html5&logoColor=white">
<img src="https://img.shields.io/badge/css-1572B6?style=flat-square&logo=css3&logoColor=white">
<img src="https://img.shields.io/badge/javascript-F7DF1E?style=flat-square&logo=javascript&logoColor=black">
<img src="https://img.shields.io/badge/jquery-0769AD?style=flat-square&logo=jquery&logoColor=white&">
<img src="https://img.shields.io/badge/bootstrap-7952B3?style=flat-square&logo=bootstrap&logoColor=white">
<br/>
<br/>

### 🚩 시스템 구성도!
![SYSTEM.png](https://user-images.githubusercontent.com/69743476/162619542-3dfa6313-1b72-46bb-b9f5-54d6bd3e2724.png)
<br/><br/>

### 🎫 ERD 
  * 사용자 정보를 저장한 user 테이블
  * 사용자의 관심분야를 저장한 interest 테이블
  * 관심분야 분류를 위해 공통코드 대분류를 저장한 common_code_group 테이블
  * 관심분야 분류를 위해 공통코드 소분류를 저장한 common_code 테이블
  * 뉴스 정보를 저장한 news 테이블
  * 뉴스 분류를 위해 뉴스 토픽을 저장한 news_topic 테이블
  * 사용자별 뉴스 추천을 위한 recommand 테이블
  * 관심사별 뉴스 추천을 위한 news_recommend 테이블
  * 워드클라우드를 저장한 news_wordcloud 테이블
  * 사용자의 뉴스 스크랩을 저장한 scrap 테이블

![ERD_TABEL.png](https://user-images.githubusercontent.com/69743476/162619553-fd0708a0-932a-46a5-ac62-78de311ca599.png)
<br/><br/>

### 🥊 프로젝트 차별점/독창성 (기술관점)  
1. 크론탭을 활용하여 실시간으로 뉴스 데이터 수집
2. FULL TEXT SEARCH 인덱스를 적용하고 쿼리문 개선으로 조회 속도 40초 → 2초로 단축
3. 실시간으로 이루어지는 연관어 분석의 빠른 처리를 위해 FastAPI를 도입하고 형태소 분석기 Mecab을 사용하여 분석 속도 단축
4. tf-idf 알고리즘으로 주요 키워드 산출 정확도 증가
5. 좋은 데이터로 학습된 95% 정확도의 KoBERT 모델로 감정 분석
<br/>

### 🧩 파일 구조

```bash
S06P22A406
├── backend
│   └── README.md
├── frontend
│   └── README.md
└── README.md
```
<br/>
