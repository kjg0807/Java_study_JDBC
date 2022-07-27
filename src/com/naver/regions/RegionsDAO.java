package com.naver.regions;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.naver.util.DBConnetor_login;

public class RegionsDAO
{
	// 1. regions의 모든 데이터 가져오기
	public RegionsDTO getList() throws Exception
	{
		// 1. DB연결 - 로그인
		Connection con = DBConnetor_login.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "SELECT * FROM regions";
		// 3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		RegionsDTO regionsDTO = null;
		while (rs.next())
		{
			regionsDTO = new RegionsDTO();
			regionsDTO.setRegion_id(rs.getInt("Region_id"));
			regionsDTO.setRegion_name(rs.getString("Region_name"));
			// int id = rs.getInt("Region_id");
			// String name = rs.getString("Region_name");

			// System.out.println(id);
			// System.out.println(name);
		}
		// 6. 자원해제
		DBConnetor_login.disConnect(rs, st, con);

		return regionsDTO;
	}

	// 2. regions에서 하나의 결과(row, 가로줄)
	public RegionsDTO getDetail(int region_id) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection con = DBConnetor_login.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "select * from regions where region_id = ?";
		// 3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 의 값 세팅
		// where num between ?(1) and ?(2)
		st.setInt(1, region_id); // parameterIndex(오라클 index는 1부터 시작), int x에 parameterIndex를 넣음
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		RegionsDTO regionsDTO = null;
		if (rs.next())
		{
			regionsDTO = new RegionsDTO();
			regionsDTO.setRegion_id(rs.getInt("region_id"));
			regionsDTO.setRegion_name(rs.getString("region_name"));
			// int rId = rs.getInt(1); // 오라클은 1번부터 시작 - 컬럼
			// String name = rs.getString(2);

			// System.out.println("Region_id: " + rId + ", Region_name: " + name);
		}
		// 6. 자원해제
		DBConnetor_login.disConnect(rs, st, con);

		return regionsDTO;
	}
}
