-- 1. 문제 정의
-- 2022년 10월에 작성된 내용을 함께 보여주는 것.
-- 댓글 작성일 오름차순, 게시글 제목 오름차순

-- 2. 접근 방식
-- INNER JOIN 이용
-- 1. FROM 절
-- 2. WHERE 절
-- 3. SELECT 절
-- 4. ORDER BY 절

SELECT
    ugb.TITLE AS "TITLE",
    ugb.BOARD_ID AS "BOARD_ID",
    ugr.REPLY_ID AS "REPLY_ID",
    ugr.WRITER_ID AS "WRITER_ID",
    ugr.CONTENTS AS "CONTENTS",
    DATE_FORMAT(ugr.CREATED_DATE, '%Y-%m-%d') AS "CREATED_DATE"
FROM USED_GOODS_BOARD ugb
INNER JOIN USED_GOODS_REPLY ugr
ON ugb.BOARD_ID = ugr.BOARD_ID
WHERE DATE_FORMAT(ugb.CREATED_DATE, '%Y%m') = '202210'
ORDER BY ugr.CREATED_DATE ASC, ugb.TITLE ASC;