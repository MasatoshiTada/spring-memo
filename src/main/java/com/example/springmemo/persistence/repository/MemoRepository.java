package com.example.springmemo.persistence.repository;

import com.example.springmemo.persistence.entity.Memo;
import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MemoRepository {
    
    private static final String SQL_FIND_ALL = """
            SELECT id, content, created_at
            FROM memo
            ORDER BY id
            """;
    
    private static final String SQL_ADD = """
            INSERT INTO memo(content) VALUES(:content)
            """;
    
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public MemoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }
    
    public List<Memo> findAll() {
        List<Memo> memoList = namedParameterJdbcTemplate.query(SQL_FIND_ALL, new DataClassRowMapper<>(Memo.class));
        // ↓でもOK
//        List<Memo> memoList = namedParameterJdbcTemplate.query(SQL_FIND_ALL,
//                (rs, rowNum) -> new Memo(rs.getLong("id"), rs.getString("content"), rs.getObject("created_at", LocalDateTime.class)));
        return memoList;
    }
    
    public Memo add(Memo unregisteredMemo) {
        MapSqlParameterSource params = new MapSqlParameterSource("content", unregisteredMemo.content());
        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameterJdbcTemplate.update(SQL_ADD, params, keyHolder, new String[]{"id"});
        long newId = keyHolder.getKey().longValue();
        Memo registeredMemo = unregisteredMemo.withNewId(newId);
        return registeredMemo;
    }
}
