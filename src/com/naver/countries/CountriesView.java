package com.naver.countries;

import java.util.ArrayList;

import com.naver.regions.RegionsDTO;

public class CountriesView
{
	public void view(ArrayList<CountriesDTO> ar)
	{
		for (CountriesDTO countriesDTO : ar)
		{
			System.out.println("Country_id: " + countriesDTO.getCountry_id() + ", Country_name: " + countriesDTO.getCountry_name() + ", Region_id: "
					+ countriesDTO.getRegion_id());
		}
	}
	
	public void view(CountriesDTO countriesDTO) throws Exception
	{
		// country_id, name, region_id
		System.out.println("Country_id: " + countriesDTO.getCountry_id() + ", Country_name: " + countriesDTO.getCountry_name() + ", Region_id: "
				+ countriesDTO.getRegion_id());
	}
}
