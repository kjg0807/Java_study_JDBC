package com.naver.countries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.naver.regions.RegionsDTO;
import com.naver.util.DBConnetor_login;

public class CountriesDAO
{
	public void getList(String search) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection con = DBConnetor_login.getConnection();
		// 2. DB 데이터 가져오기
		String sql = "select * from countries where country_name like '%'||?||'%'"; // '%'||?||'%' -> 이렇게 하고 st.setString없어도 됨
		// '%검색어%' 를 만들면 됨
		// 3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// ? 있으면 세팅
		st.setString(1, search); // -> '%'||?||'%' 안쓰면 search 앞뒤에 "%" 더하기
		// 4. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		while (rs.next())
		{
			// country_id, name, region_id
			CountriesDTO countriesDTO1 = new CountriesDTO();
			countriesDTO1.setCountry_id(rs.getString("country_id"));
			countriesDTO1.setCountry_name(rs.getString("country_name"));
			countriesDTO1.setRegion_id(rs.getInt("region_id"));

			// System.out.println("Region_id" + " " + "Country_id" + " " + "Country_name");
			// System.out.println(id + "\t\t" + cid + "\t" + cname);
		}
		// 6. 자원해제
		DBConnetor_login.disConnect(rs, st, con);

	}

	// getDetail : countries_id
	public ArrayList<CountriesDTO> getDetail(String country_id) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection con = DBConnetor_login.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "select * from countries where country_id = ?";
		// 3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 의 값 세팅
		// parameterIndex(오라클 index는 1부터 시작), int x에 parameterIndex를 넣음
		st.setString(1, country_id);
		// 5. 최종 전송 후 결과를 처리
		ResultSet rs = st.executeQuery();

		ArrayList<CountriesDTO> ar = new ArrayList();
		// CountriesDTO countriesDTO = null;
		if (rs.next())
		{
			// String CId = rs.getString("country_id"); // 오라클은 1번부터 시작 - 컬럼
			// String name = rs.getString("country_name");
			// int rid = rs.getInt("region_id");
			CountriesDTO countriesDTO = new CountriesDTO();
			countriesDTO.setCountry_id(rs.getString("country_id"));
			countriesDTO.setCountry_name(rs.getString("country_name"));
			countriesDTO.setRegion_id(rs.getInt("region_id"));
			ar.add(countriesDTO);

			// System.out.println("Country_id: " + CId + ", Country_name: " + name + ", Region_id: " + rid);
		}
		// 6. 자원해제
		DBConnetor_login.disConnect(rs, st, con);

		return ar;
	}

	public int setCountry(CountriesDTO countriesDTO) throws Exception
	{
		// 1. DB연결 - 로그인
		Connection con = DBConnetor_login.getConnection();
		// 2. regions의 데이터 가져오기
		String sql = "insert into countries values(?, ?, ?)";
		// 3. Query문 미리 전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ? 의 값 세팅
		st.setString(1, countriesDTO.getCountry_id());
		st.setString(2, countriesDTO.getCountry_name());
		st.setInt(3, countriesDTO.getRegion_id());
		// 5. 최종 전송 후 결과를 처리
		int rs = st.executeUpdate();

		// 6. 자원해제
		DBConnetor_login.disConnect(st, con);

		return rs;
	}
}
