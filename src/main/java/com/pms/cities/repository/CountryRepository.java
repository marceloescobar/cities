package com.pms.cities.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.pms.cities.model.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long> {

}
