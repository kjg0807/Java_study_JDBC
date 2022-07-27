package com.naver.employe;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.naver.util.DBConnetor_login;

public class EmployeDAO
{
	public ArrayList<EmployeDTO> getList() throws Exception
	{
		Connection con = DBConnetor_login.getConnection();
		String sql = "select * from employees";
		PreparedStatement st = con.prepareStatement(sql);
		ResultSet rs = st.executeQuery();

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
}
