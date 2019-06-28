package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kh.spring.dto.MessageDTO;

@Component
public class MessageDAO {
	@Autowired
	private DataSource ds;
	public int insert(MessageDTO dto) {
		String sql = "insert into message values(?,?,Message_seq.nextVal)";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			pstat.setString(1,dto.getName());
			pstat.setString(2,dto.getMessage());
			
			int result = pstat.executeUpdate();
			con.commit();
			return result;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return-1;
		
	}
	
	public List<MessageDTO> select() throws Exception{
		String sql = "select * from message";
		try(
				Connection con = ds.getConnection();
				PreparedStatement pstat = con.prepareStatement(sql);
				){
			try(ResultSet rs = pstat.executeQuery()){
				List<MessageDTO> result = new ArrayList<>();
				while(rs.next()) {
					MessageDTO dto = new MessageDTO();
					dto.setSeq(rs.getInt(3));
					dto.setName(rs.getString(1));
					dto.setMessage(rs.getString(2));
					result.add(dto);
				}
				return result;
			}
		}
		
	}
	
}
