# money-dist
https://github.com/drivers81-code/money-dist

springboot 2.3.6

1. 뿌리기 : 지정된 액수를 대화방 인원수에서 1을 뺀 값으로 나눈다. 
           총액에서 나눈 값을 순차적으로 소거하고 마지막 할당은 나머지 금액을 할당 받는다.
2. 받기 : 받기를 요청한 순서대로 뿌리기 건을 할당 한다.
3. 조회 : 지정된 조건대로 조회 한다.

db 는 mariadb 를 사용하고 mybatis 로 연동하였습니다.
/sql/homework.sql 파일에는 테이블 및 데이터 정보 첨부하였습니다.

테스트는 제약조건별로 작성하지는 못했습니다.
