-- SELECT : 데이터 조회
-- SELECT구문으로 데이터를 조회한 결과물을 RESULT SET이라고 함(반환된 행들의 집합)

--EMPLOYEE테이블의 사번, 이름, 급여 조회
SELECT EMP_ID, EMP_NAME, SALARY 
FROM EMPLOYEE;

select emp_id, emp_name, salary
from employee; -- 대소문자 구분 안 함

select ent_yn
from employee
where ent_yn = 'N'; -- 리터럴은 ''감싸서 사용, 리터럴 대소문자 구분

--EMPLOYEE테이블의 모든 정보 조회



SELECT *
FROM EMPLOYEE;

--JOB 테이블의 모든 정보 조회
SELECT *
FROM JOB;
--JOB 테이블의 직급 이름 조회
SELECT JOB_NAME
FROM JOB;
--DEPARTMENT테이블의 모든 정보 조회
SELECT *
FROM DEPARTMENT;
--EMPLOYEE테이블의 직원 명, 이메일, 전화번호, 고용일 조회
SELECT EMP_NAME, EMAIL, PHONE, HIRE_DATE
FROM EMPLOYEE;
--EMPLOYEE테이블의 고용일, 사원 이름, 월급 조회
SELECT HIRE_DATE, EMP_NAME, SALARY
FROM EMPLOYEE;

--컬럼 값 산술 연산 : 컬럼명 입력 부분에 계산식을 넣어 결과 조회 가능
--EMPLOYEE테이블에서 직원 명, 연봉 조회(연봉 = 급여*12)
SELECT EMP_NAME, SALARY*12
FROM EMPLOYEE;

-- EMPLYEE테이블에서 직원의 직원 명, 연봉, 보너스를 추가한 연봉 조회
SELECT EMP_NAME, SALARY*12, SALARY*12*(1 + BONUS)
FROM EMPLOYEE;


-- EMPLOYEE테이블에서 이름, 고용일, 근무일수(오늘날짜(SYSDATE) - 고용일) 조회
SELECT EMP_NAME, HIRE_DATE, SYSDATE - HIRE_DATE
FROM EMPLOYEE;

-- 컬럼 별칭
-- 컬럼명 AS 별칭 / 컬럼명 "별칭" / 컬럼명 AS "별칭" / 컬럼명 별칭
-- 별칭에 띄어쓰기,  특수문자가 들어갈 경우 "" 써야 함
-- 별칭 맨 앞이 숫자로 시작할 경우 "" 써야 함

SELECT EMP_NAME AS 이름, SALARY*12 "연봉"
FROM EMPLOYEE;

SELECT EMP_NAME "직원 이름", SALARY*12 연봉, SALARY*12*(1 + BONUS) "보너스가 들어간 연봉2"
FROM EMPLOYEE;

SELECT EMP_NAME 이름, HIRE_DATE "입사일", SYSDATE - HIRE_DATE "근무 일수"
FROM EMPLOYEE;

-- SELECT절에 리터럴 사용
-- EMPLOYEE 테이블에서 사번, 사원 명, 급여, 단위(원) 조회
SELECT EMP_ID, EMP_NAME, SALARY, '원' 단위
FROM EMPLOYEE;

-- DISTINCT : 컬럼에 포함된 중복값을 한 번만 표시하고자 할 때 사용
SELECT JOB_CODE FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE FROM EMPLOYEE;
--SELECT DISTINCT JOB_CODE, DISTINCT DEFT_COD FROM EMPLOYEE;
SELECT DISTINCT JOB_CODE, DEPT_CODE FROM EMPLOYEE;

-- wHERE절 : 조회할 테이블에서 조건이 맞는 값을 가진 행을 골라냄
-- > 크냐, < 작냐, >= 크거나 같냐, <= 작거나 같냐
-- = 같냐, != ^= <> 같지 않냐
-- EMPLOYEE테이블에서 부서코드가 D9인 직원의 이름, 부서코드 조회
SELECT EMP_NAME, DEPT_CODE 
FROM EMPLOYEE 
WHERE DEPT_CODE = 'D9';

--EMPLOYEE테이블에서 급여가 4000000 이상인 직원의 이름, 급여 조회
SELECT EMP_NAME, SALARY
FROM EMPLOYEE
WHERE SALARY >= 4000000;
--EMPLOYEE테이블에서 부서코드가 D9가 아닌 사원의 사번, 이름, 부서코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE != 'D9';
--EMPLOYEE테이블에서 퇴사여부가 N인 직원의 사번, 이름, 고용일, 근무여부 조회
--근무 여부는 재직중으로 표시
SELECT EMP_ID, EMP_NAME, HIRE_DATE, '재직중' "근무 여부"
FROM EMPLOYEE
WHERE ENT_YN = 'N';

-- EMPLOYEE테이블에서 월급이 3000000 이상인 사원의 이름, 월급, 고용일 조회
SELECT EMP_NAME, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY >= 3000000;
-- EMPLOYEE테이블에서 SAL_LEVEL이 S1인 사원의 이름, 월급, 고용일, 연락처 조회
SELECT EMP_NAME, SALARY, HIRE_DATE, PHONE
FROM EMPLOYEE
WHERE SAL_LEVEL = 'S1';
-- EMPLOYEE테이블에서 실수령액이 5천만원 이상인 사원의 이름, 월급, 실수령액, 고용일 조회
-- 실수령액 : 총수령액 - (연봉*세금 3%)
-- 총수령액 : 보너스가 포함된 연봉
SELECT EMP_NAME, SALARY, SALARY*12*(1+BONUS) - (SALARY*12*0.03) "실수령액", HIRE_DATE
FROM EMPLOYEE
WHERE SALARY*12*(1+BONUS) - (SALARY*12*0.03) >= 50000000;

-- 실수령액 수식이 길어 별칭으로 대체하려 했지만 WHERE에서 별칭 사용 불가
-- SELECT문에는 6개 절은 실행 순서가 정해져있음
-- 작성 순서 : SELECT - FROM - WHERE - GROUP BY - HAVING - ORDER BY
-- 실행 순서 : FROM - WHERE - GROUP BY - HAVING - SELECT - ORDER BY
-- 실행 순서때문에 별칭을 WHERE에서 사용할 수 없음
SELECT EMP_NAME, SALARY, SALARY*12*(1+BONUS) - (SALARY*12*0.03) "실수령액", HIRE_DATE
FROM EMPLOYEE
WHERE "실수령액" >= 50000000;

-- 논리 연산자(AND,OR)
-- EMPLOYEE테이블에서 부서코드가 D6이고 급여를 3백만보다 많이 받는 직원 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' AND SALARY > 3000000;
-- EMPLOYEE테이블에서 부서코드가 D6이거나 급여를 3백만보다 많이 받는 직원 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE DEPT_CODE = 'D6' OR SALARY > 3000000;
-- EMPLOYEE테이블에서 급여를 350만 이상 600만 이하를 받는 직원의 사번, 이름, 부서코드, 직급코드 조회
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE SALARY >= 3500000 AND SALARY <= 60000000;

-- EMPLOYEE테이블에 월급이 400만 이상이고 JOB_CODE가 J2인 사원의 전체 내용 조회
SELECT *
FROM EMPLOYEE
WHERE SALARY >= 4000000 AND JOB_CODE = 'J2';
-- EMPLOYEE테이블에 부서코드가 D9이거나 D5인 사원 중
-- 고용일이 02년 1월 1일보다 빠른 사원의 이름, 부서코드, 고용일 조회
SELECT EMP_NAME, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
WHERE (DEPT_CODE = 'D9' OR DEPT_CODE = 'D5') AND HIRE_DATE < '02/01/01';

--컬럼명 BETWEEN X AND Y : 컬럼명이 X값 이상 Y값 이하
--급여가 350만 이상이고 600만 이하
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
--WHERE SALARY >= 3500000 AND SALARY <= 60000000;
WHERE SALARY BETWEEN 3500000 AND 6000000;

--급여가 350만 미만이거나 600만 초과
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE
FROM EMPLOYEE
--WHERE SALARY NOT BETWEEN 3500000 AND 6000000;
WHERE NOT SALARY BETWEEN 3500000 AND 6000000;

-- EMPLOYEE테이블에 고용일이 90/01/01~01/01/01인 사원의 전체 내용 조회
SELECT * FROM EMPLOYEE
WHERE HIRE_DATE BETWEEN '90/01/01' AND '01/01/01';

-- LIKE : 비교하려는 값이 지정한 특정 패턴을 만족하는지 검사
-- 컬럼명 LIKE '문자패턴'
-- 문자 패턴 구성 : %, _
-- % : 0글자 이상
-- '글자%' (글자로 시작하는 값) : 글자, 글자, 글자라나라머리머리, 글(X)
-- '%글자' (글자로 끝나는 값) : 글자, 비글자, 한글자
-- '글%자' (글로 시작해서 자로 끝나는 값) : 글자, 글을 읽자
-- '%글자%' (글자가 포함된 값) : 글자. 글자수, 한글자두글자세글자, 한글자랑 (띄어쓰기는 안됨 : 한글 자랑)


-- _ : 1글자
-- '_' (1글자) : 꿈, 감, 용, 집
-- '__' (2글자) : 글자, 수업, 만세
-- '___' (3글자) : 오라클, 금요일, 졸리다

-- EMPLOYEE테이블에서 성이 전씨인 사원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '전%';

-- EMPLOYEE테이블에서 이름이 '하'가 포함된 직원의 이름, 주민번호, 부서코드 조회
SELECT EMP_NAME, EMP_NO, DEPT_CODE
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%하%';
-- EMPLOYEE테이블에서 전화번호 4번째 자리가 9로 시작하는 사원의 사번, 이름, 전화번호 조회
SELECT EMP_ID, EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE LIKE '___9%';
-- EMPLOYEE테이블에서 이메일 중 _의 앞 글자가 3자리인 이메일 주소를 가진 사원의 사번, 이름, 이메일 조회
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '____%';

-- ESCAPE OPTION : 문자 패턴과 일반 문자를 구분 시킴(한글 X)
SELECT EMP_ID, EMP_NAME, EMAIL
FROM EMPLOYEE
WHERE EMAIL LIKE '___ _%' ESCAPE ' ';

-- EMPLOYEE테이블에서 김씨 성이 아닌 직원의 사번, 이름, 고용일 조회
SELECT EMP_ID, EMP_NAME, HIRE_DATE
FROM EMPLOYEE
--WHERE EMP_NAME NOT LIKE '김%';
WHERE NOT EMP_NAME LIKE '김%';

-- EMPLOYEE테이블에서 이름 끝이 연으로 끝나는 사원의 이름 조회
SELECT EMP_NAME
FROM EMPLOYEE
WHERE EMP_NAME LIKE '%연';
-- EMPLOYEE테이블에서 전화번호 처음 3자리가 010이 아닌 사원의 이름, 전화번호 조회
SELECT EMP_NAME, PHONE
FROM EMPLOYEE
WHERE PHONE NOT LIKE '010%';
-- EMPLOYEE테이블에서 이메일 주소 _의 앞이 4자이면서 DEPT_CODE가 D9 또는 D6이고
-- 고용일이 90/01/01~00/12/01이고, 급여가 270만 이상인 사원 전체 조회
SELECT *
FROM EMPLOYEE
WHERE EMAIL LIKE '____ _%' ESCAPE ' '
        AND (DEPT_CODE = 'D9' OR DEPT_CODE = 'D6')
        AND (HIRE_DATE BETWEEN '90/01/01' AND '00/12/01') 
        AND SALARY >= 2700000;

-- IS NULL / IS NOT NULL (NOT IS NULL)
-- EMPLOYEE테이블에서 보너스를 받지 않는 사원의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS = NULL;
WHERE BONUS IS NULL;

-- EMPLOYEE테이블에서 보너스를 받는 사원의 사번, 이름, 급여, 보너스 조회
SELECT EMP_ID, EMP_NAME, SALARY, BONUS
FROM EMPLOYEE
--WHERE BONUS != NULL;
--WHERE BONUS IS NOT NULL;
WHERE NOT BONUS IS NULL;

-- EMPLOYEE테이블에서 관리자도 없고 부서 배치도 받지 않은 직원의 이름, 관리자 번호, 부서코드 조회
SELECT EMP_NAME, MANAGER_ID, DEPT_CODE
FROM EMPLOYEE
WHERE MANAGER_ID IS NULL 
        AND DEPT_CODE IS NULL;
-- EMPLOYEE테이블에서 부서 배치를 받지 않았지만 보너스를 지급 받는 직원의 이름, 보너스, 부서코드 조회
SELECT EMP_NAME, BONUS, DEPT_CODE
FROM EMPLOYEE
WHERE DEPT_CODE IS NULL AND BONUS IS NOT NULL;

-- IN : 목록에 일치하는 값이 있으면
-- 컬럼명 IN (값1, 값2, 값3, ...)
-- D6부서와 D9부서원들의 이름, 부서코드, 급여 조회
SELECT EMP_NAME, DEPT_CODE, SALARY
FROM EMPLOYEE
--WHERE (DEPT_CODE = 'D6' OR DEPT_CODE = 'D9');
WHERE DEPT_CODE IN ('D6', 'D9');

-- 직급코드가 J1, J2, J3, J4인 사람들의 이름, 직급코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
--WHERE JOB_CODE = 'J1' 
--       OR JOB_CODE = 'J2'     
--        OR JOB_CODE = 'J3'     
--        OR JOB_CODE = 'J4';
WHERE JOB_CODE IN('J1', 'J2', 'J3', 'J4');

-- 연결 연산자 ||
-- EMPLOYEE테이블에서 사번, 이름, 급여를 연결하여 조회
SELECT EMP_ID || EMP_NAME || SALARY
FROM EMPLOYEE;

--EMPLOYEE테이블에서 '사원 명의 월급은 급여원입니다' 형식으로 조회
SELECT EMP_NAME || '의 월급은 ' || SALARY || '원입니다'
FROM EMPLOYEE;

SELECT EMP_NAME AS 이름, SALARY AS 급여,
        SALARY*12 || '원' AS 연봉,
        (SALARY*(BONUS+1))*12 || '원' "총수령액(보너스포함)",
        SALARY*(BONUS+1)*12 - SALARY*12*0.3 || '원' AS "실수령액"
FROM EMPLOYEE
WHERE BONUS IS NOT NULL;















































