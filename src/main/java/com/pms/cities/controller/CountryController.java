package com.pms.cities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pms.cities.model.Country;
import com.pms.cities.service.ICountryService;

@RestController
public class CountryController {

	
	 @Autowired
	    private ICountryService countryService;

	    @RequestMapping("/countries")
	    public List<Country> listCountries() {
	        
	        return countryService.findAll();
	    }
}
