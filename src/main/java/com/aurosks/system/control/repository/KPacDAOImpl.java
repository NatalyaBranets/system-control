package com.aurosks.system.control.repository;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSaveRequest;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.time.LocalDate;
import java.util.List;

@Repository
public class KPacDAOImpl implements KPacDAO {

    private final JdbcTemplate jdbcTemplate;

    public KPacDAOImpl(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void save(KPacSaveRequest request) {
        String sql = "INSERT INTO k_pac (title, description, creation_date) VALUES (?, ?, ?)";
        this.jdbcTemplate.update(sql, request.getTitle(), request.getDescription(), LocalDate.now());
    }

    @Override
    public KPac getById(int id) {
        String sql = "SELECT * FROM k_pac WHERE id = " + id;
        return this.jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(KPac.class));
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM k_pac WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }

    @Override
    public List<KPac> getAll() {
        String sql = "SELECT * FROM k_pac";
        return this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(KPac.class));
    }
}
