-- 함수(FUNCTION) : 컬럼의 값을 읽어서 계산한 결과 리턴
-- 단일 행 함수 : 컬럼에 기록된 N개의 값을 읽어 N개의 결과 리턴
-- 그룹 함수 : 컬럼에 기록된 N개의 값을 읽어 1개의 결과 리턴


-- 단일 행 함수
-- 문자 관련 함수
-- LENGTH, LENGTHB
SELECT LENGTH('오라클'), LENGTHB('오라클') 
FROM DUAL; -- 가상 테이블(DUMMY TABLE)

SELECT EMAIL, LENGTH(EMAIL), LENGTHB(EMAIL) FROM EMPLOYEE;

-- INSTR : 해당 문자열 위치
SELECT INSTR('AABAACAABBAA', 'B'), INSTR('AABAACAABBAA', 'A'),
        INSTR('AABAACAABBAA', 'Z') -- 0
FROM DUAL;

SELECT INSTR('AABAACAABBAA', 'B', 1), --세 번째 인자 : 몇 번째서부터 읽기 시작할 것이냐
        INSTR('AABAACAABBAA', 'B', 7),
        INSTR('AABAACAABBAA', 'B', -1),
        INSTR('AABAACAABBAA', 'A', -3)
FROM DUAL;

SELECT INSTR('AABAACAABBAA', 'B', 1, 2) --  네 번째 인자 : N번째로 나오는 글자 읽기
FROM DUAL;

-- EMPLOYEE테이블에서 이메일의 @ 위치
SELECT EMAIL, INSTR(EMAIL, '@') FROM EMPLOYEE;

--  LPAD/RPAD(비어있는 공간 채우기 그 방향으로)
SELECT LPAD(EMAIL, 20, '#'), RPAD(EMAIL, 20) FROM EMPLOYEE;
--     sun_di@kh.or.kr
--sun_di@kh.or.kr     

--LTRIM/RTRIM/TRIM(공백 채우기)
SELECT LTRIM('  KH  ') A, RTRIM('  KH  ') B FROM DUAL;
SELECT LTRIM('  KH  ',' ') A, RTRIM('  KH  ', ' ') B FROM DUAL;
--                    이 인자 넣는 거 지워줌
SELECT LTRIM('000123456', '0'), RTRIM('123456000', '0') FROM DUAL;
SELECT LTRIM('123123KH123', '123'), RTRIM('123KH123123', '123') FROM DUAL;
SELECT LTRIM('ACABACCKH', 'ABC'), RTRIM('KHACABACC', 'ABC')FROM DUAL;-         
--                           뭉텅이로 보는 게 아니라
SELECT LTRIM('2132153447KH', '0123456789') FROM DUAL;
SELECT TRIM('  KH  ') A FROM DUAL;
SELECT TRIM('Z' FROM 'ZZZKHZZZ') FROM DUAL;
SELECT TRIM('ABC' FROM 'ABCKHABC') FROM DUAL; --트림 설정은 하나 문자만 가지고 있어야 합니다
SELECT TRIM(LEADING 'Z' FROM 'ZZZKHZZZ'),
        TRIM(TRAILING '3' FROM '333KH333'),
        TRIM(BOTH '@' FROM '@@@KH@@@') FROM DUAL;
        
--SUBSTR
SELECT SUBSTR('HELLOMYGOODFRIENDS', 7),
        SUBSTR('HELLOMYGOODFRIENDS', 5, 2),
        SUBSTR('HELLOMYGOODFRIENDS', 5, 0),
        SUBSTR('HELLOMYGOODFRIENDS', -8, 3)FROM DUAL;

-- EMPLOYEE테이블에서 이름, 이메일, @이후를 제외한 아이디 조회
SELECT EMP_NAME, EMAIL, SUBSTR(EMAIL, 1, INSTR(EMAIL, '@')-1)
FROM EMPLOYEE;

--주민등록번호를 이용하여 남/녀 판단
--EMPLOYEE테이블에서 이름과 주민번호에서 성별을 나타내는 부분 조회
SELECT EMP_NAME, EMP_NO,  SUBSTR(EMP_NO, 8, 1) 성별 FROM EMPLOYEE;
SELECT EMP_NAME, EMP_NO, SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) 성별 FROM EMPLOYEE;

SELECT EMP_NAME, '남자' 성별
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) = 1;

SELECT EMP_NAME, '여자' 성별
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) != 1;

--LOWER/UPPER/INITCAP
SELECT LOWER('Welcome To My World'),
        UPPER('Welcome To My World'),
        INITCAP('welcome to my world') FROM DUAL;
        
--CONCAT
SELECT CONCAT('가나다라', 'ABCD'),
        '가나다라' || 'ABCD'
FROM DUAL;

--REPLACE
SELECT REPLACE('서울시 강남구 역삼동', '역삼동', '삼성동') FROM DUAL;
SELECT REPLACE('박신우강사님은 현재 어지럽습니다.', '강사님', '선생님') FROM DUAL;
SELECT REPLACE('박신우강사님은 502강의장 강사님입니다.', '강사님', '선생님') FROM DUAL;

-- EMPLOYEE테이블에서 사원 명, 주민번호 조회
-- 단, 주민번호는 생년월일만 보이게 하고 '-' 다음은 '*'로 변경
-- EX. 260223-*******
SELECT EMP_NAME, EMP_NO, INSTR(EMP_NO, '-'), RPAD(RTRIM(EMP_NO, 1234567890), 14, '*') 주민번호1,
                                                RPAD(SUBSTR(EMP_NO, 1, 7), 14, '*') 주민번호2
                                                FROM EMPLOYEE;
SELECT EMP_NAME, SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')) || '********' 주민번호
FROM EMPLOYEE;
SELECT EMP_NAME, CONCAT(SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')), '********') 주민번호
FROM EMPLOYEE;

SELECT EMP_NAME, RPAD(SUBSTR(EMP_NO, 1, INSTR(EMP_NO, '-')),LENGTH(EMP_NO), '*') 주민번호
FROM EMPLOYEE;

SELECT EMP_NAME, REPLACE(EMP_NO, SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1), '********') 주민번호
FROM EMPLOYEE;

-- 숫자 관련 함수
--ABS : 절댓값
SELECT ABS(10.9), ABS(-10.9), ABS(10), ABS(-10) FROM DUAL;

--MOD : 나머지
SELECT MOD(10, 3), MOD(-10, 3), MOD(10.9, 3), MOD(-10.9, 3),
        MOD(10, -3), MOD(-10, -3)
FROM DUAL;

--ROUND, FLOOR, TRUNC, CEIL
SELECT ROUND(123.456), ROUND(123.678, 0), ROUND(123.456, 1), ROUND(123.456, 2),
        ROUND(123.456, -2) -- 반올림
FROM DUAL;

SELECT FLOOR(123.456), FLOOR(123.678) FROM DUAL; -- 수학적 내림(위치지정 불가)
SELECT TRUNC(123.456), TRUNC(123.678) FROM DUAL; -- 절삭
SELECT FLOOR(-1.1), TRUNC(-1.1) FROM DUAL;
SELECT TRUNC(123.456, 0), TRUNC(123.456, 1), TRUNC(123.456, 2), TRUNC(123.456, -1)
FROM DUAL;

SELECT CEIL(123.456), CEIL(123.678) FROM DUAL; --(위치지정 불가)올림

-- 날짜 관련 함수
SELECT SYSDATE FROM DUAL;

--MONTHS_BETWEEN : 개월 수의 차이를 숫자로 리턴
--EMPLOYEE테이블에서 사원의 이름, 입사일, 근무 개월 수 조회
SELECT EMP_NAME, HIRE_DATE, MONTHS_BETWEEN (SYSDATE, HIRE_DATE) FROM EMPLOYEE;
SELECT EMP_NAME, HIRE_DATE, CEIL(ABS(MONTHS_BETWEEN (HIRE_DATE, SYSDATE))) 개월차
FROM EMPLOYEE;

-- ADD_MONTHS : 날짜에 숫자만큼 개월 수를 더하여 날짜 리턴
SELECT ADD_MONTHS(SYSDATE, 5), ADD_MONTHS(SYSDATE, 12) FROM DUAL;

--NEXT_DAY : 기준 날짜에서 구하려는 요일에 가장 가까운 날짜 리턴
SELECT SYSDATE, NEXT_DAY(SYSDATE, '목요일'),
                NEXT_DAY(SYSDATE, 5),
                NEXT_DAY(SYSDATE, '목'),
                NEXT_DAY(SYSDATE, '월급 세 배로 줘') --맨 앞에 '월' 시작
FROM DUAL;

SELECT SYSDATE, NEXT_DAY(SYSDATE, 'THURSDAY') FROM DUAL; -- THU, THU~~~
ALTER SESSION SET NLS_LANGUAGE = AMERICAN; --영어 체인지
ALTER SESSION SET NLS_LANGUAGE = KOREAN;

-- LAST_DAY : 해당 달의 마지막 날짜 리턴
SELECT SYSDATE, LAST_DAY(SYSDATE) FROM DUAL;

-- EMPLOYEE테이블에서 사원 명, 입사일-오늘, 오늘-입사일 조회
-- 단 별칭은 '근무일수1', '근무일수2'로 하고 모두 정수처리(내림)하여 양수가 되도록 처리
SELECT EMP_NAME, FLOOR(ABS(HIRE_DATE - SYSDATE)) 근무일수1 , FLOOR(ABS(SYSDATE - HIRE_DATE)) 근무일수2
FROM EMPLOYEE;

-- EMPLOYEE테이블에서 근무년수가 20년 이상인 직원 정보 조회 (여러 개 나올 수 있으므로 다 해보기)
SELECT *
FROM EMPLOYEE
--WHERE (SYSDATE - HIRE_DATE)/365 >= 20;
--WHERE MONTHS_BETWEEN(SYSDATE, HIRE_DATE)/12 >= 20;
WHERE ADD_MONTHS(HIRE_DATE, 240) <= SYSDATE;

-- EMPLOYEE테이블에서 사원 명, 입사일, 입사한 월의 근무 일수 조회
SELECT EMP_NAME, HIRE_DATE , LAST_DAY(HIRE_DATE) - HIRE_DATE
FROM EMPLOYEE;

-- EXTRACT : 년, 월, 일 정보 추출
-- EXTRACT(YEAR FROM 날짜), EXTRACT(MONTH FROM 날짜), EXTRACT(DAY FROM 날짜)
-- EMPLOYEE테이블에서 사원의 이름, 입사 년, 입사 월, 입사 일 조회
SELECT EMP_NAME 이름, 
        EXTRACT(YEAR FROM HIRE_DATE) "입사 년",
        EXTRACT(MONTH FROM HIRE_DATE) "입사 월",
        EXTRACT(DAY FROM HIRE_DATE) "입사 일"
FROM EMPLOYEE;

-- 형변환 함수 4 : 00
-- TO_CHAR : 날짜/숫자 데이터를 문자 데이터로 변경
SELECT 1234 AAAAAAA, TO_CHAR(1234) FROM DUAL;
SELECT TO_CHAR(1234) + 4321 FROM DUAL;
SELECT TO_CHAR(1234, '99999'), TO_CHAR(1234, '00000'), TO_CHAR(1234, 'L99999')
FROM DUAL;
SELECT TO_CHAR(1234, 'FM99999'), TO_CHAR(1234, 'FM00000'), TO_CHAR(1234, 'FML99999')
FROM DUAL; --FM : 앞 공간 삭제
SELECT TO_CHAR(1234, '$99999'), TO_CHAR(1234, 'FM$99999'),
        TO_CHAR(1234, '99,999'), TO_CHAR(1234, '00,000'), TO_CHAR(1234, '999')
FROM DUAL;

SELECT TO_CHAR(SYSDATE, 'PM HH24:MI:SS') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY'), TO_CHAR(SYSDATE, 'YY'), TO_CHAR(SYSDATE, 'YEAR') FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'MM'), TO_CHAR(SYSDATE, 'MONTH'),
        TO_CHAR(SYSDATE, 'MON'), TO_CHAR(SYSDATE, 'RM') --RM : 로마숫자
FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'DDD'), TO_CHAR(SYSDATE, 'DD'), TO_CHAR(SYSDATE, 'D') FROM DUAL;
                        --년 기준 몇 일 지낫는지     --달 기준              -- 주 기준
SELECT TO_CHAR(SYSDATE, 'Q'), TO_CHAR(SYSDATE, 'DAY'), TO_CHAR(SYSDATE, 'DY') FROM DUAL;
                    --분기                       -
--EMPLOYEE테이블에서 이름, 입사일 조회
-- 2026년 02월 23일 (월)
SELECT EMP_NAME,
        TO_CHAR(HIRE_DATE, 'YYYY"년" MM"월" DD"일" (DY)')
FROM EMPLOYEE;

-- TO_DATE : 문자/숫자 데이터를 날짜 데이터로 변환
SELECT TO_DATE('20100101', 'YYYYMMDD'), TO_DATE(20100101, 'YYYYMMDD'), TO_DATE(20100101) FROM DUAL;
SELECT TO_CHAR(TO_DATE('20100101', 'YYYYMMDD'), 'YYYY, MON') FROM DUAL;
SELECT TO_CHAR(TO_DATE('041030 143000', 'YYMMDD HH24MISS'), 'DD-MON-YY HH:MI:SS PM') FROM DUAL;

-- Y를 적용하면 무조건 현재 세기 적요
-- R을 적용하면 연도가 50이상일 때는 이전 세기, 미만일 때는 현재 세기
SELECT TO_CHAR(TO_DATE('980630', 'YYMMDD'), 'YYYYMMDD') CASE1, 
        TO_CHAR(TO_DATE('140918', 'YYMMDD'), 'YYYYMMDD') CASE2,
        TO_CHAR(TO_DATE('980630', 'RRMMDD'), 'YYYYMMDD') CASE3, 
        TO_CHAR(TO_DATE('140918', 'RRMMDD'), 'YYYYMMDD') CASE4
FROM DUAL;
-- TO_NUMBER : 문자를 숫자로 변환
SELECT TO_NUMBER('12345') FROM DUAL;
SELECT '123' + '321',
        '1,000,000' + '4,000,000' FROM DUAL;
SELECT TO_NUMBER('1,000,000', '999,999,999')
        + TO_NUMBER('4,000,000', '999,999,999')
FROM DUAL;

-- NULL처리 함수 : 컬럼 값이 NULL일 때 바꿀 값의 자료형은 컬럼의 자료형을 따라감
SELECT EMP_NAME, SALARY*(1+BONUS)*12 FROM EMPLOYEE;
SELECT BONUS, NVL(BONUS, 0) FROM EMPLOYEE;
SELECT EMP_NAME, SALARY*(1+NVL(BONUS, 0))*12 FROM EMPLOYEE;


-- 선택 함수
-- DECODE(계산식|컬럼명, 조건값1, 선택값1, 조건값2, 선택값2, ...)
-- 비교하고자 하는 값 또는 컬럼이 조건식과 같으면 결과 값 반환
SELECT EMP_ID, EMP_NAME, EMP_NO, 
        DECODE(SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1), '1', '남', '2', '여') 성별1,
        DECODE(SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1), '1', '남', '여') 성별2 -- 인자 빼먹은거는 그 외 나머지
FROM EMPLOYEE;

--직원의 급여를 인상하고자 한다
--직급코드가 J7인 직원은 급여의 10%, 직급코드가 J6인 직원은 급여의 15%,
--직급코드가 J5인 직원은 급여의 20%, 그 외 직급은 급여의 5%를 인상한다.
--EMPLOYEE테이블에서 직원 명, 직급코드, 급여, 인상급여(위 조건) 조회
SELECT EMP_NAME, JOB_CODE, SALARY, 
        DECODE(JOB_CODE, 'J7', SALARY*1.1, 
                        'J6', SALARY*1.15, 
                        'J5', SALARY*1.2, 
                        SALARY*1.05) 인상급여,
        SALARY*(1 + DECODE(JOB_CODE, 'J7', 0.1, 'J6', 0.15, 'J5', 0.2, 0.05)) 인상급여2
FROM EMPLOYEE;

-- CASE WHEN 조건식 THEN 결과값
--      WHEN 조건식 THEN 결과값
--      ELSE 결과값
-- END
SELECT EMP_ID, EMP_NAME, EMP_NO, 
        CASE WHEN SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) = 1 THEN '남자'
            ELSE '여자'
        END 성별,
        CASE SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) WHEN '1' THEN '남자'
            ELSE '여자'
        END 성별2
FROM EMPLOYEE;

--직급에 따른 급여 인상
SELECT EMP_NAME, JOB_CODE,SALARY,
        CASE JOB_CODE WHEN 'J7' THEN SALARY*1.1
                      WHEN 'J6' THEN SALARY*1.15
                      WHEN 'J5' THEN SALARY*1.2
                      ELSE SALARY*1.05
        END 급여인상
FROM EMPLOYEE;

SELECT EMP_NAME, JOB_CODE,SALARY,
        CASE WHEN JOB_CODE = 'J7' THEN SALARY*1.1
             WHEN JOB_CODE = 'J6' THEN SALARY*1.15
             WHEN JOB_CODE = 'J5' THEN SALARY*1.2
             ELSE SALARY*1.05
        END 급여인상
FROM EMPLOYEE;

-- 그룹 함수
-- SUM
-- EMPLOYEE테이블에서 전 사원의 급여 총합 조회
SELECT SUM(SALARY) FROM EMPLOYEE;

--EMPLOYEE테이블에서 남자 사원의 급여 총합 조회
SELECT SUM(SALARY) "남자 사원 급여"
FROM EMPLOYEE
WHERE SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) = 1;   
--EMPLOYEE테이블에서 부서코드가 D5인 직원의 보너스 포함 연봉 합계 조회
SELECT SUM((SALARY+ (SALARY*NVL(BONUS, 0)))*12)
FROM EMPLOYEE
WHERE DEPT_CODE = 'D5';

-- AVG : 평균 (NULL제외하고 평균)
-- EMPLOYEE테이블에서 전 사원의 급여 평균 조회
SELECT AVG(SALARY)
FROM EMPLOYEE;

-- EMPLOYEE테이블에서 전 사원의 보너스 평균 조회
SELECT AVG(BONUS) FROM EMPLOYEE;
SELECT AVG(NVL(BONUS, 0)) FROM EMPLOYEE;

--COUNT : 세줌 (NULL제외)
--EMPLOYEE테이블에서 전체 사원 수 조회
SELECT COUNT(*), COUNT(EMP_NAME) FROM EMPLOYEE;
SELECT COUNT(BONUS) FROM EMPLOYEE;

-- MIN/MAX : 한글, 영어도 가능 (빠른 순, 느린 순으로)
SELECT MIN(SALARY), MIN(EMP_NAME), MIN(EMAIL), MIN(HIRE_DATE)
FROM EMPLOYEE;

SELECT MAX(SALARY), MAX(EMP_NAME), MAX(EMAIL), MAX(HIRE_DATE)
FROM EMPLOYEE;












