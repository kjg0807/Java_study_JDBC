package com.naver.test;

import java.util.ArrayList;

import com.naver.countries.CountriesDAO;
import com.naver.countries.CountriesDTO;
import com.naver.countries.CountriesView;
import com.naver.regions.RegionsDAO;
import com.naver.regions.RegionsDTO;
import com.naver.regions.RegionsView;
import com.naver.util.DBConnetor_login;

public class TestMain
{
	public static void main(String[] args)
	{
		DBConnetor_login db = new DBConnetor_login();

		RegionsDAO rd = new RegionsDAO();
		RegionsDTO regionsDTO = new RegionsDTO();
		RegionsView regionsView = new RegionsView();

		CountriesDAO cd = new CountriesDAO();
		CountriesDTO coutriesDTO = new CountriesDTO();
		CountriesView coutriesView = new CountriesView();

		try
		{
			// DBConnetor_login.getConnection();
			// rd.getList();
			// cd.getList();
			// cd.getDetail("AU");
//			regionsDTO = rd.getDetail(2);
//			regionsView.view(regionsDTO);
			RegionsDTO ar = rd.getList();
			regionsView.view(ar);

//			coutriesDTO = cd.getDetail("AU");
//			coutriesView.view(coutriesDTO);
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
