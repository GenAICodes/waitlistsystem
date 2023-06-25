
package com.waitlistsystem.service.impl;

import com.waitlistsystem.model.User;
import com.waitlistsystem.service.WaitlistService;
import com.waitlistsystem.notification.EmailScheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WaitlistServiceImpl implements WaitlistService {

    private final JdbcTemplate jdbcTemplate;
    private final EmailScheduler emailScheduler;

    @Autowired
    public WaitlistServiceImpl(JdbcTemplate jdbcTemplate, EmailScheduler emailScheduler) {
        this.jdbcTemplate = jdbcTemplate;
        this.emailScheduler = emailScheduler;
    }

    @Override
    public void addUser(String name, String email, String phone) {
        String sql = "INSERT INTO users (name, email, phone) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, name, email, phone);
        int userId = jdbcTemplate.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);
        emailScheduler.scheduleWaitlistNotificationEmail(email, name, getPosition(userId), LocalDateTime.now());
    }

    @Override
    public void removeUser(int userId) {
        String sql = "DELETE FROM waitlist WHERE user_id = ?";
        jdbcTemplate.update(sql, userId);
        sql = "DELETE FROM users WHERE id = ?";
        jdbcTemplate.update(sql, userId);
    }

    @Override
    public List<User> getUsers() {
        String sql = "SELECT * FROM users";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new User(rs.getInt("id"), rs.getString("name"), rs.getString("email"), rs.getString("phone")));
    }

    @Override
    public int getPosition(int userId) {
        String sql = "SELECT COUNT(*) FROM waitlist WHERE position < (SELECT position FROM waitlist WHERE user_id = ?)";
        return jdbcTemplate.queryForObject(sql, Integer.class, userId) + 1;
    }
}
