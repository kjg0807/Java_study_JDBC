package com.naver.test;

import com.naver.countries.CoutriesDAO;
import com.naver.regions.RegionsDAO;
import com.naver.util.DBConnetor_login;

public class TestMain
{
	public static void main(String[] args)
	{
		DBConnetor_login db = new DBConnetor_login();
		RegionsDAO rd = new RegionsDAO();
		CoutriesDAO cd = new CoutriesDAO();
		try
		{
//			DBConnetor_login.getConnection();
//			rd.getList();
			cd.getList();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
