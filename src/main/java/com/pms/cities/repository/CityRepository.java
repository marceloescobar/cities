package com.pms.cities.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;
import org.springframework.stereotype.Repository;

import com.pms.cities.model.City;

@Repository
public interface CityRepository extends CrudRepository<City, Long>, QueryByExampleExecutor<City>, QuerydslPredicateExecutor<City> {

	List<City> findAllOrderedByNameDescending();
	
	 @Query("FROM City ORDER BY population ASC")
	    List<City> findAllOrderByPopulationAsc();

	    @Query("FROM City")
	    List<City> findAllOrderByNameAsc(Sort sort);
	    
	    List<City> findByNameEndingWith(String ending);
	    List<City> findByPopulationLessThan(int population);
}
