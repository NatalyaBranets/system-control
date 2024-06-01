package com.aurosks.system.control.repository;

import com.aurosks.system.control.domain.KPac;
import com.aurosks.system.control.domain.KPacSet;
import com.aurosks.system.control.domain.KPacSetSaveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Repository
public class KPacSetDAOImpl implements KPacSetDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insert;

    public KPacSetDAOImpl(DataSource dataSource) {
        this.insert = new SimpleJdbcInsert(dataSource)
                .withTableName("k_pac_set")
                .usingGeneratedKeyColumns("id");
    }

    @Override
    public void save(KPacSetSaveRequest request) {
        MapSqlParameterSource map = new MapSqlParameterSource()
                .addValue("title", request.getTitle());
        Number id = this.insert.executeAndReturnKey(map);

        if (request.getKPacIds() != null && request.getKPacIds().length > 0) {
            this.insertKPacsToKPacSet(id.intValue(), request.getKPacIds());
        }
    }

    @Override
    public void deleteById(int id) {
        String sql = "DELETE FROM k_pac_set WHERE id = ?";
        this.jdbcTemplate.update(sql, id);
    }

    @Override
    public List<KPacSet> getAll() {
        String sql = "SELECT * FROM k_pac_set";
        return this.jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(KPacSet.class));
    }

    @Override
    public KPacSet getById(int id) {
        String sql = "SELECT * FROM k_pac_set WHERE id = ?";
        KPacSet kPacSet = this.jdbcTemplate.queryForObject(sql, new Object[]{id}, BeanPropertyRowMapper.newInstance(KPacSet.class));
        return getKPacsByKPacSet(kPacSet);
    }

    private KPacSet getKPacsByKPacSet(KPacSet kPacSet) {
        String sql = "SELECT k_pac.* " +
                "FROM k_pac_set_k_pac " +
                "JOIN k_pac ON k_pac_set_k_pac.k_pac_id = k_pac.id " +
                "WHERE k_pac_set_k_pac.k_pac_set_id = ?";
        List<KPac> kPacs = this.jdbcTemplate.query(sql, new Object[] {kPacSet.getId()}, BeanPropertyRowMapper.newInstance(KPac.class));
        kPacSet.setKPacs(new HashSet<>(kPacs));
        return kPacSet;
    }

    private void insertKPacsToKPacSet(Integer kPacSetId, Integer[] kPacIds) {
        String sql = "INSERT INTO k_pac_set_k_pac (k_pac_set_id, k_pac_id) VALUES (?,?)";
        Arrays.asList(kPacIds).forEach(kPacId -> {
                    this.jdbcTemplate.update(sql, kPacSetId, kPacId);
                }
        );
    }
}
