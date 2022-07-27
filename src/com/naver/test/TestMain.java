package com.naver.test;

import com.naver.util.DBConnetor_login;

public class TestMain
{
	public static void main(String[] args)
	{
		DBConnetor_login db = new DBConnetor_login();

		try
		{
			db.getConnection();
		}
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
