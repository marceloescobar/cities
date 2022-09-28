package com.pms.cities.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.pms.cities.model.Country;
import com.pms.cities.service.ICityService;
import com.pms.cities.service.ICountryService;

@Controller
public class CityController {

	@Autowired
	private ICityService cityService;

	@Autowired
	private ICountryService countryService;

	@GetMapping("/showCities")
	public String findCities(Model model) {

		model.addAttribute("cities", cityService.findAll());

		return "showCities";
	}
	
	@GetMapping("/countries/{pageNo}/{pageSize}")
    public List<Country> getPaginatedCountries(@PathVariable int pageNo, 
            @PathVariable int pageSize) {

        return countryService.findPaginated(pageNo, pageSize);
    }
}
