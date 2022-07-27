package com.naver.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.naver.util.DBConnetor_login;

public class CoutriesDAO
{
	public void getList() throws Exception
	{
		// 1. DB연결 - 로그인
		Connection con = DBConnetor_login.getConnection();
		// 2. DB 데이터 가져오기
		String sql = "select * from countries";
		// 3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		while (rs.next())
		{
			// country_id, name, region_id
			int id = rs.getInt("Region_id");
			String cid = rs.getString("Country_id");
			String cname = rs.getString("Country_name");

			System.out.println("Region_id" + "  " + "Country_id" + "  " + "Country_name");
			System.out.println(id + "\t\t" + cid + "\t" + cname);
		}
	}
}
