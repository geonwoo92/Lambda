-- 001.전체 축구팀 목록을 팀이름 오름차순으로 출력하시오
select *
from team
order by team_name ASC;
-- 002.플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 빈공간으로 두시오
select DISTINCT POSITION
from player;

-- 003 플레이어의 포지션 종류를 나열하시오. 단 중복은 제거하고, 포지션이 없으면 '신입'으로 기재하시오
UPDATE player
set POSITION= ''
where POSITION = '신입';
select DISTINCT POSITION
from player;

-- 004- 수원팀에서 골키퍼(GK)의 이름을 모두 출력하시오. 단 수원팀 ID는 K02 입니다.
select *
from player
where position = 'GK'
  AND team_id = (select team_id from team t where t.region_name = '수원');
-- 005- 수원팀에서 성이 고씨이고 키가 170 이상인 선수를 출력하시오. 단 수원팀 ID는 K02 입니다.
select *
from player
where height >= 170
  AND team_id = 'KO2'
  AND player_name LIKE '고 %';

select team_id
from team t
where t.region_name = '수원';

-- 문제 6
-- 다음 조건을 만족하는 선수명단을 출력하시오
-- 소속팀이 삼성블루윙즈이거나
-- 드래곤즈에 소속된 선수들이어야 하고,
--    AND team_name = '드래곤즈'
-- 포지션이 미드필더(MF:Midfielder)이어야 한다.
--   POSITION = 'MF'
-- 키는 170 센티미터 이상이고 180 이하여야 한다.

select * from team;
SELECT player_name from player
WHERE (height between 170 AND 180)
  AND POSITION = 'MF'
  AND (team_id=(SELECT team_id FROM team WHERE team_name ='드래곤즈' )
  OR team_id=(SELECT team_id FROM team WHERE team_name ='삼성블루윙즈'));

select * from team;
SELECT player_name from player
WHERE team_id IN (SELECT team_id FROM team WHERE team_name ='드래곤즈' OR team_name = '삼성블루윙즈' )
AND POSITION = 'MF'
   AND height between 170 AND 180;


-- 문제 7-- 수원을 연고지로 하는 골키퍼는 누구인가?
SELECT player_name from player WHERE POSITION = 'GK'AND team_id =(select team_id from team where region_name = '수원');

 -- 문제 8-- 서울팀 선수들 이름, 키, 몸무게 목록으로 출력하시오-- 키와 몸무게가 없으면 "0" 으로 표시하시오-- 키와 몸무게는 내림차순으로 정렬하시오
select player_name, if(height='',0,player.height), if(weight='',0,weight) from player where team_id=(select team_id from team where team_name = 'FC서울')order by weight,height DESC ;

-- 문제 9-- 서울팀 선수들 이름과 포지션과-- 키(cm표시)와 몸무게(kg표시)와  각 선수의 BMI지수를 출력하시오-- 단, 키와 몸무게가 없으면 "0" 표시하시오--BMI는 "NONE" 으로 표시하시오(as bmi)-- 최종 결과는 이름내림차순으로 정렬하시오

SELECT COUNT(*) as count
FROM player p
   JOIN team t ON t.team_id = p.team_id
   JOIN stadium s ON t.stadium_id = s.stadium_id
   JOIN schedule sch ON sch.stadium_id = s.stadium_id;

SELECT COUNT(*) as count
FROM stadium s
    join team t ON s.stadium_id = t.stadium_id
    join player p ON t.team_id = p.team_id
    join schedule sc ON s.stadium_id = sc.stadium_id
;
-- 문제 10
-- 수원팀(K02) 과 대전팀(K10) 선수들 중 포지션이 골키퍼(GK) 인
-- 선수를 출력하시오
-- 단 , 팀명, 선수명 오름차순 정렬하시오

SELECT player_name, team_name
FROM player s
    join team t ON s.team_id = t.team_id
WHERE s.team_id IN ('K02','K10')
AND POSITION = 'GK'
ORDER BY 1,2
;


-- 문제 11
-- 팀과 연고지를 연결해서 출력하시오
-- [팀 명]             [홈구장]
-- 수원[ ]삼성블루윙즈 수원월드컵경기장
SELECT * FROM schedule;
SELECT concat(t.region_name,'',t.team_name ) '팀 명',s.stadium_name as '홈 구 장'
FROM team t
    JOIN stadium s ON t.stadium_id = s.stadium_id
WHERE t.team_id = (t.region_name = t.team_name)
;

-- 문제 12
-- 수원팀(K02) 과 대전팀(K10) 선수들 중
-- 키가 180 이상 183 이하인 선수들
-- 키, 팀명, 사람명 오름차순
SELECT p.height 키,t.team_name 팀,p.player_name 이름
FROM player p
     JOIN team t ON p.team_id = t.team_id
WHERE p.team_id IN ('K02','K10')
AND p.height between 180 AND 183
ORDER BY 1,2,3
;
-- 문제 13
-- 모든 선수들 중 포지션을 배정 받지 못한 선수들의
-- 팀명과 선수이름 출력 둘다 오름차순
-- 스칼라와 조인사용
SELECT team_name,player_name
FROM player p
     JOIN team t ON p.team_id = t.team_id
WHERE p.POSITION= ''
ORDER BY 1,2
;
 -- 문제 14
-- 팀과 스타디움, 스케줄을 조인하여
-- 2012년 3월 17일에 열린 각 경기의
-- 팀이름, 스타디움, 어웨이팀 이름 출력
-- 다중테이블 join 을 찾아서 해결하시오.
SELECT t.team_name 홈팀 , s.stadium_name 경기장,(select t.team_name from team where t.team_id= sc.awayteam_id) 어웨이팀
FROM stadium s
     JOIN schedule sc ON s.stadium_id = sc.stadium_id
     JOIN team t ON s.stadium_id = t.stadium_id
WHERE sche_date ='20120317'
;
-- 문제 15
-- 2012년 3월 17일 경기에
-- 포항 스틸러스 소속 골키퍼(GK)
-- 선수, 포지션,팀명 (연고지포함),
-- 스타디움, 경기날짜를 구하시오
-- 연고지와 팀이름은 간격을 띄우시오(수원[]삼성블루윙즈)
SELECT p.player_name, p.POSITION ,concat(t.region_name, ' ' ,t.team_name) '팀 이름',
       s.stadium_name,sc.sche_date
FROM stadium s
    JOIN team t On s.stadium_id = t.stadium_id
    JOIN player p on t.team_id = p.team_id
    JOIN schedule sc ON s.stadium_id = sc.stadium_id
WHERE sc.sche_date = '20120317' AND p.POSITION = 'GK' AND t.team_name = '스틸러스'
;

SELECT (select p.player_name, p.POSITION from player p where p.POSITION = 'GK') ,stadium_name
    , sc.sche_date
FROM stadium s
    JOIN schedule sc USING (stadium_id)

;


select * from schedule;
-- 문제 16
-- 홈팀이 3점이상 차이로 승리한 경기의
-- 경기장 이름, 경기 일정
-- 홈팀 이름과 원정팀 이름을
-- 구하시오
SELECT s.stadium_name '경 기 장' ,sc.sche_date 날짜, t.team_name HOME_TEAM, (select team_name from team t where team_id= awayteam_id)AWAY_TEAM
FROM stadium s
JOIN schedule sc ON s.stadium_id = sc.stadium_id
JOIN team t ON s.stadium_id = t.stadium_id
WHERE sc.home_score - sc.away_score>=3
;
-- 문제 17
-- STADIUM 에 등록된 운동장 중에서
-- 홈팀이 없는 경기장까지 전부 나오도록
-- 카운트 값은 19
-- 힌트 : LEFT JOIN 사용해야함
-- 경기장 이름 , 홈팀
SELECT * FROM stadium;
;
SELECT stadium_name,
       (SELECT t.team_name FROM team t where t.stadium_id= st.stadium_id) HOME_TEAM
FROM stadium st;

SELECT s.stadium_name, team_name
FROM stadium s LEFT JOIN team t USing(stadium_id);




-- 문제 18 플레이어 테이블에서 최상단 5개 로우를 출력
SELECT *
FROM player limit 5;

-- 문제 19 (그룹바이: 집계함수 - 딱 5개 min, max, count, sum, avg)
-- 평균키가 인천 유나이티스팀('K04')의 평균키  보다 작은 팀의
-- 팀ID, 팀명, 평균키 추출
-- 인천 유나이티스팀의 평균키 -- 176.59
-- 키와 몸무게가 없는 칸은 0 값으로 처리한 후 평균값에
-- 포함되지 않도록 하세요.
select avg(height)
FROM  player;
SELECT t.team_id, t.team_name, ROUND((AVG(p.height)),2) '평균 키'
FROM player p
JOIN team t USING (team_id)
GROUP BY
    t.team_id
HAVING
    AVG(p.height) < (SELECT AVG(height) FROM player WHERE team_id = 'K04');

select * from player;
SELECT t.team_id 팀, t.team_name 이름, ROUND(AVG(p.height),2) '평균 키'
FROM team t
JOIN player p USING (team_id)
group by t.team_id
HAVING avg(height) <= 176.59;

SELECT t.team_id, t.team_name, ROUND(AVG(p.height))
FROM team t
         JOIN player p USING (team_id)
group by t.team_id
HAVING avg(height) <= 176.59;
-- 문제 20
-- 포지션이 MF 인 선수들의 소속팀명 및  선수명, 백넘버 출력
SELECT t.team_name, p.player_name, p.back_no
FROM team t
 JOIN player p USING (team_id)
WHERE POSITION = 'MF'
;

-- 문제 21
-- 가장 키큰 선수 5명 소속팀명 및  선수명, 백넘버 출력,
-- 단 키  값이 없으면 제외
SELECT t.team_name,p.player_name,p.back_no
FROM team t
JOIN player p USING (team_id)
order by p.height desc
limit 5;

;
-- 문제 22
-- 선수 자신이 속한 팀의 평균키보다 작은  선수 정보 출력
-- (select round(avg(height),2) from player)
SEl
-- 문제 23
-- 2012년 5월 한달간 경기가 있는 경기장  조회