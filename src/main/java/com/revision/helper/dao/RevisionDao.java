package com.revision.helper.dao;

import com.revision.helper.model.exchange.AddTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

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

}
