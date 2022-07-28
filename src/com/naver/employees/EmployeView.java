package com.naver.employees;

public class EmployeView
{
	// employee_id, first_name, last_name, email, phone_number, hire_date, job_id, salary, commossion_pct, manager_id,
	// department_id
	public void view(EmployeDTO employeDTO) throws Exception
	{
		System.out.println("employee_id" + "  first_name" + "  last_name" + "  email" + "  phone_number" + "  hire_date" + "  job_id" + "  salary"
				+ "  commossion_pct" + "  manager_id" + "  department_id");
		System.out.println(employeDTO.getEmployee_id() + "" + employeDTO.getFirst_name() + "" + employeDTO.getLast_name() + "" + employeDTO.getEmail()
				+ "" + employeDTO.getPhone_number() + "" + employeDTO.getHire_date() + "" + employeDTO.getJob_id() + "" + employeDTO.getSalary() + ""
				+ employeDTO.getCommossion_pct() + "" + employeDTO.getManager_id() + "" + employeDTO.getDepartment_id());
	}
}
