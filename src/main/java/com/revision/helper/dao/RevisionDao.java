package com.revision.helper.dao;

import com.revision.helper.model.exchange.AddTopic;
import com.revision.helper.model.exchange.RevisionRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RevisionDao {

    final JdbcTemplate jdbcTemplate;

    @Autowired
    public RevisionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void addTopic(final AddTopic topic) {
        final String sql = "insert into topics (topic_id, topic_name) values(?, ?)";
        jdbcTemplate.update(sql, topic.getTopicId(), topic.getTopicName());
    }

    public List<String> getAllTopic(){
        final String sql = "select distinct(topic_name) from topics";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<String> getTagsByTopic(String topic) {
        String getTopicSql = "SELECT topic_id FROM topics WHERE topic_name = ?";
        Integer topicId = jdbcTemplate.queryForObject(getTopicSql, Integer.class, topic);

        String getTagSql = "SELECT distinct(tag) FROM topic_tag WHERE topic_id = ?";
        return jdbcTemplate.queryForList(getTagSql, String.class, topicId);
    }

    public void addTags(RevisionRequest request){
        String addTagSql = "INSERT INTO topic_tag (topic_id, tag) values(?, ?)";
        jdbcTemplate.update(addTagSql, request.getTopic_id(), request.getTags());
    }

    public Integer fetchTopicId(RevisionRequest request){
        String getTopicIdSql = "SELECT topic_id from topics where topic_name = ?";
        return jdbcTemplate.queryForObject(getTopicIdSql, Integer.class, request.getTopic());
    }

}
