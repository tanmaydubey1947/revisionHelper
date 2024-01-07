use revisionHelper;

select * from revision_request where topic = "Tree";

truncate revision_request;

SELECT * FROM revision_request  WHERE topic = "tree";

insert into revision_request (question_id, question_name, source, tags, topic) values (1,'sample', 'leetcode', 'tree', 'tree') 