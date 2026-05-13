-- SUBQUERY : 메인 쿼리를 위해 보조 역할을 하는 쿼리문 (소괄호로 감싸야됨)
-- = 하나의 SQL문 안에 포함된 또다른 SQL문

-- 부서코드가 노옹철 사원과 같은 소속의 직원 명단 조회
-- 1) 노옹철 사원의 부서 코드
SELECT DEPT_CODE FROM EMPLOYEE WHERE EMP_NAME = '노옹철'; -- D9

-- 2) 부서코드가 D9인 직원 명단 조회
SELECT EMP_NAME FROM EMPLOYEE WHERE DEPT_CODE = 'D9'; -- 선동일, 송종기, 노옹철

-- 1) + 2)
SELECT EMP_NAME -- SUBQUERY의 개수도 같고 타입도 같아야됨
FROM EMPLOYEE
WHERE DEPT_CODE = (SELECT DEPT_CODE
                   FROM EMPLOYEE
                   WHERE EMP_NAME = '노옹철');
-- 서브쿼리 규칙 1. 반드시 소괄호로 감싸주어야 함
-- 서브쿼리 규칙 2. 비교할 메인 쿼리의 컬럼과 개수, 자료형 일치
            
--전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여 조회
--1) 전 직원의 평균 급여
SELECT AVG(SALARY) FROM EMPLOYEE; --3047662.60869565217391304347826086956522
--2) 3047662.60869565217391304347826086956522보다 많이 받는 직원 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > 3047662.60869565217391304347826086956522; --선종노유정심대전
-- 1) + 2)
SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT AVG(SALARY) FROM EMPLOYEE);

-- 단일행 서브쿼리 : 서브쿼리의 조회 결과 행 개수가 1개
-- 노옹철 사원의 급여보다 많이 받는 직원의 사번, 이름, 부서코드, 직급코드, 급여 조회
-- 1) 노옹철 사원의 급여
SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철'; --3700000
-- 2) 3700000보다 많이 받는 사원 정보 조회

-- 1) + 2)
SELECT EMP_ID, EMP_NAME, DEPT_CODE, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY > (SELECT SALARY FROM EMPLOYEE WHERE EMP_NAME = '노옹철');

-- 전 직원의 급여 평균보다 적은 급여를 받은 직원의 이름, 직급코드, 부서코드, 급여 조회
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY < (SELECT AVG(SALARY) FROM EMPLOYEE); 

-- 가장 적은 급여를 받는 직원의 사번, 이름, 직급코드, 부서코드, 급여, 입사일 조회
SELECT EMP_ID, EMP_NAME, JOB_CODE, DEPT_CODE, SALARY, HIRE_DATE
FROM EMPLOYEE
WHERE SALARY = (SELECT MIN(SALARY) FROM EMPLOYEE);

-- 부서 별 급여 합계 중 가장 큰 부서의 부서 명, 급여 합계 조회
-- 서브쿼리는 SELECT, WHERE, HAVING, FROM절에 사용될 수 있음
-- 1) 부서 별 급여 합계
SELECT SUM(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2) 부서 별 급여 합계 중 가장 큰 급여 합계
SELECT MAX(SUM(SALARY))
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 3) 부서 별 급여 합계가 17700000인 부서 명, 급여 합계
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     JOIN DEPARTMENT ON (DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = 17700000;

-- 1)+2)+3)
SELECT DEPT_TITLE, SUM(SALARY)
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
GROUP BY DEPT_TITLE
HAVING SUM(SALARY) = (SELECT MAX(SUM(SALARY))
                      FROM EMPLOYEE
                      GROUP BY DEPT_CODE);

-- 다중행 서브쿼리 : 서브쿼리의 조회 결과 값의 개수가 여러 개
-- IN/NOT IN : 여러 개의 결과 값 중 한 개라도 일치하는 값이 있다면/없다면
-- > ANY, > ANY : 여러 개의 결과 값 중에서 하나라도 큰/작은 경우
--                = 가장 작은 값보다 크냐 / 가장 큰 값보다 작냐
-- > ALL, > ALL : 모든 값보다 큰/작은 경우
--                =  가장 큰 값보다 크냐 / 가장 작은 값보다 작냐

-- 부서 별 최고 급여를 받는 직원의 이름, 직급코드, 부서 코드, 급여 조회
-- 1) 부서 별 최고 급여
SELECT MAX(SALARY)
FROM EMPLOYEE
GROUP BY DEPT_CODE;

-- 2)
SELECT EMP_NAME, JOB_CODE, DEPT_CODE, SALARY
FROM EMPLOYEE
WHERE SALARY IN(SELECT MAX(SALARY)
                FROM EMPLOYEE
                GROUP BY DEPT_CODE);

-- 관리자와 일반 직원에 해당하는 사원 정보 추출
-- 사번, 이름, 부서명, 직급, 구분(관리자/직원)
-- 1) 관리자에 해당하는 사원 번호 조회
SELECT DISTINCT MANAGER_ID
FROM EMPLOYEE
WHERE MANAGER_ID IS NOT NULL;

-- 2) 관리자 직원 정보
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '관리자' 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE  
                WHERE MANAGER_ID IS NOT NULL);

-- 3) 일반 직원 정보
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '직원' 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE  
                WHERE MANAGER_ID IS NOT NULL);

-- 2)+3)
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '관리자' 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE  
                WHERE MANAGER_ID IS NOT NULL)
UNION
SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME, '직원' 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE)
WHERE EMP_ID NOT IN(SELECT DISTINCT MANAGER_ID
                FROM EMPLOYEE  
                WHERE MANAGER_ID IS NOT NULL);
                
                

SELECT EMP_ID, EMP_NAME, DEPT_TITLE, JOB_NAME,
        CASE WHEN EMP_ID IN(SELECT DISTINCT(MANAGER_ID)
                            FROM EMPLOYEE
                            WHERE MANAGER_ID IS NOT NULL) THEN '관리자'
             ELSE '직원'
        END 구분
FROM EMPLOYEE
     LEFT JOIN DEPARTMENT ON(DEPT_CODE = DEPT_ID)
     JOIN JOB USING(JOB_CODE);

-- 대리 직급의 직원들 중 과장 직급의 최소 급여보다 많이 받는 직원의 사번, 이름, 직급, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
      AND SALARY > (SELECT MIN(SALARY)
                    FROM EMPLOYEE
                         JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '과장');
--ANY 쓴 거
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '대리'
      AND SALARY > ANY(SELECT SALARY
                    FROM EMPLOYEE
                         JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '과장');

-- 차장 직급의 급여의 가장 큰 값보다 많이 받는 과장 직급의 사번, 이름, 직급, 급여 조회
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
      AND SALARY > (SELECT MAX(SALARY)
                    FROM EMPLOYEE
                         JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '차장');

-- ALL 쓴 거
SELECT EMP_ID, EMP_NAME, JOB_NAME, SALARY
FROM EMPLOYEE
     JOIN JOB USING(JOB_CODE)
WHERE JOB_NAME = '과장'
      AND SALARY > ALL(SELECT SALARY
                    FROM EMPLOYEE
                         JOIN JOB USING(JOB_CODE)
                    WHERE JOB_NAME = '차장');
                    
-- 다중 열 서브쿼리 : 서브쿼리 SELECT절에 나열된 항목 수가 여러 개
-- 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 사원의 이름, 직급 코드, 부서코드, 입사일 조회
SELECT DEPT_CODE, JOB_CODE
FROM EMPLOYEE
WHERE ENT_YN = 'Y'
      AND SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) = 2;

SELECT EMP_NAME, JOB_CODE, DEPT_CODE, HIRE_DATE
FROM EMPLOYEE
                          --(IN)
WHERE (DEPT_CODE, JOB_CODE ) = (SELECT DEPT_CODE, JOB_CODE
                                FROM EMPLOYEE
                                WHERE ENT_YN = 'Y'
                                      AND SUBSTR(EMP_NO, INSTR(EMP_NO, '-')+1, 1) = 2);
-- 다음 주 시험~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
-- 다중 행 다중 열 서브쿼리
-- 자기 직급의 평균 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여 조회
-- 단, 급여 평균은 십만원단위로 계산(TRUNC(컬럼명, -5))

SELECT JOB_CODE, TRUNC(AVG(SALARY), -5)
FROM EMPLOYEE
GROUP BY JOB_CODE;

SELECT EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, TRUNC(AVG(SALARY), -5)
                            FROM EMPLOYEE
                            GROUP BY JOB_CODE);

-- ROWNUM : 조회된 순서대로 1부터 번호 매김
SELECT ROWNUM, EMP_ID, EMP_NAME, JOB_CODE, SALARY
FROM EMPLOYEE
WHERE (JOB_CODE, SALARY) IN (SELECT JOB_CODE, TRUNC(AVG(SALARY), -5)
                            FROM EMPLOYEE
                            GROUP BY JOB_CODE);

-- 전 직원 중 급여가 높은 상위 5명의 순위, 이름, 급여 조회 : 선 송 정 대 노
SELECT ROWNUM,EMP_NAME, SALARY
FROM EMPLOYEE
WHERE ROWNUM <= 5
ORDER BY SALARY DESC;
-- FROM절(판 깔아줌) 기준으로 ROWNUM이 생성
-- FROM절 -> WHERE절 -> -> -> FROM절 ->ORDER BY절

-- INLINE VIEW : FROM절에 서브쿼리 = 원하는 판으로 구성 가능
SELECT ROWNUM, EMP_NAME, SALARY
FROM (SELECT * 
      FROM  EMPLOYEE 
      ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

SELECT ROWNUM, EMP_NAME, SALARY, EMAIL -- FROM절에 있는 판은 EMP_NAME, SALARY만 존재하므로 EMAIL 추출 불가
FROM (SELECT EMP_NAME, SALARY 
      FROM  EMPLOYEE 
      ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

SELECT ROWNUM, 이름, 급여 -- FROM절에 이름이 바뀌면 무조건 FROM절 기준!!!
FROM (SELECT EMP_NAME 이름, SALARY 급여
      FROM  EMPLOYEE 
      ORDER BY SALARY DESC)
WHERE ROWNUM <= 5;

-- RANK() OVER/DENSE_RANK() OVER : 중복 등수 다음에 매기는 순위가 달라짐 DENSE_RANK는 바로 따라옴
SELECT RANK() OVER(ORDER BY SALARY DESC) R, 
        DENSE_RANK() OVER(ORDER BY SALARY DESC)DR,
        EMP_NAME, SALARY
FROM EMPLOYEE;





















