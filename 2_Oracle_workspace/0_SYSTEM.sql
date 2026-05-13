--한 줄 주석
/*
여러 줄
주석*/

--관리자 계정 : 데이터베이스 생성과 관리를 담당하는 슈퍼 유저 계정
--              오브젝트 생성, 변경, 삭제 등 작업 가능
--              데이터베이스에 대한 모든 권한과 책임을 갖는 계정
--사용자 계정 : 데이터베이스에 대하여 질의(Query), 갱신, 보고서 작성 등 작업을 수행할 수 있는 계정
--              일반 계정은 보안을 위해 "업무에 필요한 최소한의 권한만" 가지는 것을 원칙으로 함

--새로운 계정 생성(사용자 계정) -> 오직 관리자만 할 수 있음
--계정 생성 명령어 ~11g vs 12c~
CREATE USER KH IDENTIFIED BY KH; -- ~11g
CREATE USER C##KH IDENTIFIED BY KH; -- 12C~
DROP USER C##KH; -- C##KH 계정 삭제

-- C##을 붙이지 않고도 계정 생성할 수 있는 설정
ALTER SESSION SET "_ORACLE_SCRIPT" = TRUE;

--CREATE USER KH IDENTIFIED BY KH;

--권한 부여
--GRANT CONNECT TO KH;
-- 권한 부여 (지원)
--grant resource to kh;
grant connect, resource to kh;


























