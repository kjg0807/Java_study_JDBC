package com.naver.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.naver.util.DBConnetor_login;

public class RegionsDAO
{
	// 1. regions의 모든 데이터 가져오기
	public void getList() throws Exception
	{
		// 1. DB연결 - 로그인
		Connection DBConn = DBConnetor_login.getConnection();

		// 2. regions의 데이터 가져오기
		String sql = "SELECT * FROM regions";

		// 3. Query문 미리 전송
		PreparedStatement st = DBConn.prepareStatement(sql);

		// 4. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		while (rs.next())
		{
			int id = rs.getInt("Region_id");
			String name = rs.getString("Region_name");
			
			System.out.println(id);
			System.out.println(name);
		}
	}
}
