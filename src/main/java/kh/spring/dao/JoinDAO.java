package kh.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import kh.spring.dto.JoinDTO;
@Component
public class JoinDAO {
	@Autowired
	private JdbcTemplate jdbc;
	@Autowired
	private HttpSession session;
	@Autowired
	private DataSource ds;
	@Autowired
	private SqlSessionTemplate sst;
	public int insert(JoinDTO dto) {
		return sst.insert("member_mapper.insert",dto);
	}
	public int login(JoinDTO dto) {
		int result=0;
		try {		
			result=sst.selectOne("member_mapper.login",dto);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	public int idcheck(String id) {

		int result=0;
		try {
			result = sst.selectOne("member_mapper.idch",id);
			System.out.println(id);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}


	public JoinDTO memberInfo(String id){
		return sst.selectOne("member_mapper.memberInfo",id);

	}
	
}

