package com.pms.cities.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pms.cities.model.Country;
import com.pms.cities.repository.CountryRepository;
import com.pms.cities.service.ICountryService;

@Service
public class CountryService implements ICountryService {

	  @Autowired
	    private CountryRepository repository;
	  
	@Override
	public List<Country> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Country> pagedResult = repository.findAll(paging);

        return pagedResult.toList();
	}

	@Override
	public List<Country> findAll() {
		return (List<Country>) repository.findAll();
	}

}
