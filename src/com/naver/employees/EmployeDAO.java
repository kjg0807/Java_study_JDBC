package com.naver.employees;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.naver.util.DBConnetor_login;

public class EmployeDAO
{
	public ArrayList<EmployeDTO> getList() throws Exception
	{
		Connection con = DBConnetor_login.getConnection(); // DB 연결
		String sql = "select * from employees"; // SQL문
		PreparedStatement st = con.prepareStatement(sql); // 값 미리 전송
		ResultSet rs = st.executeQuery(); // 최종 전송 후 결과 처리

		ArrayList<EmployeDTO> ar = new ArrayList();
		while (rs.next())
		{
			// employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commossion_pct, manager_id,
			// department_id
			EmployeDTO employeDTO = new EmployeDTO();
			employeDTO.setEmployee_id(rs.getInt("employee_id"));
			employeDTO.setFirst_name(rs.getString("first_name"));
			employeDTO.setLast_name(rs.getString("last_name"));
			employeDTO.setEmail(rs.getString("email"));
			employeDTO.setPhone_number(rs.getInt("phone_number"));
			employeDTO.setHire_date(rs.getInt("hire_date"));
			employeDTO.setJob_id(rs.getString("job_id"));
			employeDTO.setSalary(rs.getInt("salary"));
			employeDTO.setCommossion_pct(rs.getDouble("commossion_pct"));
			employeDTO.setManager_id(rs.getInt("manager_id"));
			ar.add(employeDTO);
		}
		DBConnetor_login.disConnect(rs, st, con);

		return ar;
	}

	public void getSalaryinfo() throws Exception
	{
		// 1. DB연결
		Connection con = DBConnetor_login.getConnection();
		// 2. SQL문 작성
		String sql = "select sum(salary) as sum, avg(salary) as avg, max(salary) as max, min(salary) as min from employees";
		// 3. 미리전송
		PreparedStatement st = con.prepareStatement(sql);
		// 4. ?가 있으면 값 세팅
		// 5. 최종 전송 후 결과 처리
		ResultSet rs = st.executeQuery();

		if (rs.next())
		{
			int sum = rs.getInt("sum");
			double avg = rs.getDouble("avg");
			int max = rs.getInt("max");
			int min = rs.getInt("min");

			System.out.println(sum);
			System.out.println(avg);
			System.out.println(max);
			System.out.println(min);
		}

		// 6. 자원처리
		DBConnetor_login.disConnect(rs, st, con);
	}
}
