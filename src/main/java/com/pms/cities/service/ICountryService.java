package com.pms.cities.service;

import java.util.List;

import com.pms.cities.model.Country;

public interface ICountryService {

	 List<Country> findPaginated(int pageNo, int pageSize);
	 
	 public List<Country> findAll();
}
