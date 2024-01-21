use revisionHelper;

select * from revision_request where topic = "Tree";

SELECT * FROM revision_request  WHERE topic = "tree";

insert into revision_request (question_id, question_name, source, tags, topic) values (1,'sample', 'leetcode', 'tree', 'tree') ;

select * from hibernate_sequence;

select * from revision_request;


create table topics (topic_id int NOT NULL, topic_name varchar(255), PRIMARY KEY(topic_id));

select * from topics;

insert into topics (topic_id, topic_name) values(2, "Graph");


create table topic_tag (topic_id int, tag varchar(255));


select * from topic_tag where topic_id = 1;

insert into topic_tag (topic_id, tag) values(1, "zig zag");

select t.tag from t topic_tags;

SELECT topic_id FROM topics WHERE topic_name ="Tree";

delete from topics where topic_id = 0;