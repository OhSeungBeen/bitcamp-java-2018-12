# UC05 -자주 묻는 질문(FrequentlyAskedQuestions)
관리자는 등록, 조회, 변경, 삭제 를 할수 있고
회원 및 비회원은 조회 하는 유스케이스이다.

## 주 액터(Primary Actor)
- 비회원
- 회원
- 관리자

## 보조 액터(Secondary Actor)
- 없음

## 사전 조건(Preconditions)
- 등록,변경,삭제 할 경우
관리자로 로그인 되어 있어야 한다.

## 종료 조건(Postconditions)
- 자주묻는질문이 등록하였다.
- 자주묻는질문이 수정하였다.
- 자주묻는질문이 삭제하였다.

## 시나리오(Flow of Evnets)

### 자주묻는질문 조회하기

1. 액터는 고객센터 메뉴를 클릭한다.
- 시스템은 고객센터 폼(대표전화,1:1문의,고객센터 운영시간,공지사항,자주묻는질문)을 출력한다.
- 시스템은 고객센터 목록(제목,내용,작성일)을 출력한다.
2. 액터는 자주묻는질문에서 글제목을 클릭한다.
- 시스템은 자주묻는질문 상세 정보(제목,내용)를 출력한다.


### 자주묻는질문 등록하기 

1. 관리자는 자주묻는 질문관리 메뉴를 클릭한다.
- 시스템은 자주묻는 질문관리 등록 폼을 출력한다.
2. 관리자는 (글제목,내용)을 입력하고, 상세분류를(여행예약,결제/할인/요금,취소/변경,사이트이용안내) 
    분류별로 설정을 하고 등록 버튼을 클릭한다.
- 시스템은 게시글 정보를 저장한 후 '질문관리 메뉴' 유스케이스로 간다.


### 자주묻는질문 변경하기

1. 관리자는 자주묻는 질문관리 메뉴를 클릭한다.
1. 관리자는 자주묻는질문 변경하기 버튼 클릭한다.
2. 관리자는 자주묻는질문 상세 정보 화면에서 (글제목,내용) 혹은 
   상세분류를(여행예약,결제/할인/요금,취소/변경,사이트이용안내) 분류별로 변경하고 변경버튼을 클릭한다.
- 시스템은 자주묻는질문(글제목,내용)를 변경한 후 '자주묻는질문관리' 유스케이스로 간다.
 

### 자주묻는질문 삭제하기

1. 관리자는 '자주묻는질문관리' 메뉴를 클릭한다.
2. 관리자는 삭제 버튼을 클릭한다.
- 시스템은 해당 게시물을 삭제한 후 '자주묻는질문관리' 유스케이스로 간다.
 


## UI 프로토타입


###




