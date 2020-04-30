# UC20 - 예약관리(Reservation Management)

관리자가 회원의 예약을 조회, 변경 하는 유스케이스이다.

## 주 액터(Primary Actor)

- 관리자

## 보조 액터(Secondary Actor)

- 없음

## 사전 조건(Preconditions)

- 관리자로 로그인 되어 있다.


## 종료 조건(Postconditions)


- 회원의 예약 조회하였다.
- 회원의 예약 상태를 변경하였다.

## 시나리오(Flow of Evnets)

### 예약 조회하기

1. 액터는 예약 관리 메뉴를 클릭한다.
- 시스템은 예약 목록(예약일, 예약번호, 상품명, 예약방법, 예약금액, 예약자, 예약 상태, 기능)을 출력한다.

### 예외 흐름(Exception Flows) 
1. 예약건이 존재하지 않는다면,
- 시스템은 예약이 존재하지 않는다는 내용을 출력한다.

### 예약 상태 변경하기

1. 액터는 예약 관리 메뉴 화면에서 변경할 회원의 예약상태를 카테고리중에 선택 후 변경 버튼을 누른다.
- 시스템은 예약상태를 변경한 후 '예약 조회하기' 유스케이스의 2번으로 간다.

### 예외 흐름(Exception Flows) 
1. 예약건이 존재 하지 않는다면,
- 시스템은 예약이 존재하지 않는다는 내용을 출력한다.

## UI 프로토타입

### 예약 목록
![회원 목록](./images/uc002-list.png)

