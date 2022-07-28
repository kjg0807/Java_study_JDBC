package com.naver.test;

import java.util.ArrayList;

import com.naver.countries.CountriesDAO;
import com.naver.countries.CountriesDTO;
import com.naver.countries.CountriesView;
import com.naver.employe.EmployeDAO;
import com.naver.employe.EmployeDTO;
import com.naver.employe.EmployeView;
import com.naver.regions.RegionsDAO;
import com.naver.regions.RegionsDTO;
import com.naver.regions.RegionsView;
import com.naver.util.DBConnetor_login;

public class TestMain
{
	public static void main(String[] args)
	{
		DBConnetor_login db = new DBConnetor_login();

		RegionsDAO regionsDAO = new RegionsDAO();
		RegionsDTO regionsDTO = new RegionsDTO();
		RegionsView regionsView = new RegionsView();

		CountriesDAO countriesDAO = new CountriesDAO();
		CountriesDTO coutriesDTO = new CountriesDTO();
		CountriesView coutriesView = new CountriesView();

		EmployeDAO employeDAO = new EmployeDAO();
		EmployeDTO employeDTO = new EmployeDTO();
		EmployeView employeView = new EmployeView();

		try
		{
			// DBConnetor_login.getConnection();
			// rd.getList();
			// cd.getList();
			// cd.getDetail("AU");
			// regionsDTO = rd.getDetail(2);
			// regionsView.view(regionsDTO);

			// ArrayList<RegionsDTO> ar = rd.getList();
			// regionsView.view(ar);
			ArrayList<RegionsDTO> ar = regionsDAO.getList();
			regionsView.view(ar);

			// coutriesDTO = cd.getDetail("AU");
			// coutriesView.view(coutriesDTO);

			// ArrayList<EmployeDTO> ar = employeDAO.getList();
			// employeView.view(ar);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
