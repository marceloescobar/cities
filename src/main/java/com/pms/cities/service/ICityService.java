package com.pms.cities.service;

import java.util.List;
import java.util.Optional;

import com.pms.cities.model.City;

public interface ICityService {

	List<City> findAll();
	
	 List<City> findByNameEnding(String ending);
	 
	 List<City> findByName(String name);
	 
	 List<City> findAllOrderedByNameDescending();
	 
	 Optional<City> findById(Long id);
	 
	 List<City> findAllOrderByPopulationAsc();
	    List<City> findAllOrderByNameAsc();
	    
	    List<City> findByNameEndingWith(String ending);
	    List<City> findByPopulationLessThan(int population);
}
