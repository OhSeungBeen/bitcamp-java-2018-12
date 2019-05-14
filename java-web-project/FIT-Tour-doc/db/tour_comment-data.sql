--sample--
insert into tour_comment(member_id, tour_id, ranking, level, content, created_date)
values(101, 1, 1, 1, '내용입니다.' ,'2019-02-15 10:22:24');

insert into tour_comment(member_id, tour_id, ranking, level, content, created_date)
values(102, 2, 1, 1, '내용입니다2.' ,'2019-02-15 10:22:24');

insert into tour_comment(member_id, tour_id, ranking, level, content, created_date)
values(103, 3, 1, 1, '내용입니다3.' ,'2019-02-15 10:22:24');

insert into tour_comment(member_id, tour_id, ranking, level, content, created_date)
values(104, 4, 1, 1, '내용입니다4.' ,'2019-02-15 10:22:24');

insert into tour_comment(member_id, tour_id, ranking, level, content, created_date)
values(105, 5, 1, 1, '내용입니다5.' ,'2019-02-15 10:22:24');


--parent comment--
select * from tour_comment where tour_id=1;

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(1, 101, 1, 0, 0, '1' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(2, 101, 1, 0, 0, '2' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(3, 101, 1, 0, 0, '3' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(4, 101, 1, 0, 0, '4' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(5, 101, 1, 0, 0, '5' ,'2019-02-15 10:22:24');

--child comment--
select * from tour_comment where tour_id=1;

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(6, 101, 1, 1, 1, '1' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(7, 101, 1, 1, 1, '2' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(8, 101, 1, 1, 1, '3' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(9, 101, 1, 1, 1, '4' ,'2019-02-15 10:22:24');

insert into tour_comment(tour_comment_id, member_id, tour_id, parent_id, level, content, created_date)
values(10, 101, 1, 1, 1, '5' ,'2019-02-15 10:22:24');
