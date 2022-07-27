package com.naver.regions;

import java.util.ArrayList;

public class RegionsView
{
	public void view(ArrayList<RegionsDTO> ar)
	{
		for (RegionsDTO regionsDTO : ar)
		{
			System.out.println("Region_id: " + regionsDTO.getRegion_id() + ", Region_name: " + regionsDTO.getRegion_name());
		}
	}

	public void view(RegionsDTO regionsDTO) throws Exception
	{
		System.out.println("Region_id: " + regionsDTO.getRegion_id() + ", Region_name: " + regionsDTO.getRegion_name());
	}
}
