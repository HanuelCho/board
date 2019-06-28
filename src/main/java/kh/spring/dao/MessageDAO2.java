package kh.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;
@Component
public class MessageDAO2 {
	@Autowired
	private JdbcTemplate jdbc;
	public int insert(MessageDTO dto) {
		String sql = "insert into message values(?,?,Message_seq.nextVal)";
		try {
		return jdbc.update(sql,dto.getName(),dto.getMessage());
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	public List<MessageDTO> select() {
		String sql = "select * from message";
		return jdbc.query(sql,new RowMapper<MessageDTO>() {

			@Override
			public MessageDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MessageDTO dto = new MessageDTO();
				dto.setName(rs.getString(1));
				dto.setMessage(rs.getString(2));
				dto.setSeq(rs.getInt(3));
				return dto;
			}
		});
	}
}
