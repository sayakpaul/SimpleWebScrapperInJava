create table words_scrapper (words varchar (255));

insert into words_scrapper(words) values ('hi');

select words, count(words) from words_scrapper group by words order by words asc;

truncate table words_scrapper;

create index words_index on words_scrapper(words);

ALTER TABLE words_scrapper DROP INDEX words_index;

drop table words_scrapper;

select count(words) from words_scrapper;

SELECT MAX(Total) FROM (SELECT COUNT(words) AS Total FROM words_scrapper GROUP BY words) AS Results;

select MAX(Total) from words_scrapper where Total in (select count(words) as Total from words_scrapper group by words) ;

select count(words) from words_scrapper where words = 'dept';

SELECT *
FROM (
  SELECT words, occurrences, @rownum := @rownum + 1 AS position
  FROM (
    SELECT words, COUNT(*) AS occurrences
    FROM words_scrapper
    GROUP BY words
    ORDER BY occurrences
    ) a
  JOIN (
    SELECT @rownum := 0
    ) r
  ) b
WHERE words = 'dept'