package com.example.hello.dao;

import com.example.hello.domain.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
public class UserDao {
    private final JdbcTemplate jdbcTemplate;

    public UserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    RowMapper<User> rowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("id"),
                    rs.getString("name"),
                    rs.getString("passwrod"));
            return user;
        }
    };


    public void add(final User user) {
        this.jdbcTemplate.update("INSERT INTO user(id, name, password) VALUES(?,?,?);",
                user.getId(), user.getName(), user.getPassword());
    }

    public User findById(String id) {
        String sql = "select * from user where id =?";
        return this.jdbcTemplate.queryForObject(sql, rowMapper, id);
    }

    public void deleteAll() {
        this.jdbcTemplate.update("delete from user");
    }

    public int getCount() {
        return this.jdbcTemplate.queryForObject("select count(*) from user;", Integer.class);
    }

    public List<User> getAll() {
        String sql = "select * from user oder by id;";
        return this.jdbcTemplate.query(sql, rowMapper);
    }

    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = userDao.findById("6");
        System.out.println(user.getName());

    }
}
