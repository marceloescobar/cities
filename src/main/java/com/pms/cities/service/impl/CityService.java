package com.pms.cities.service.impl;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.pms.cities.model.City;
import com.pms.cities.repository.CityRepository;
import com.pms.cities.service.ICityService;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;

@Service
public class CityService implements ICityService {

	 @Autowired
	    private CityRepository repository;
	 
	 @PersistenceContext
	    private EntityManager entityManager;
	 
	@Override
	public List<City> findAll() {
		List<City> cities = (List<City>) repository.findAll();

        return cities;
	}

	@Override
	public List<City> findByNameEnding(String ending) {
		City city = new City();
        city.setName(ending);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.endsWith())
                .withIgnorePaths("population");

        Example<City> example = Example.of(city, matcher);
        return (List<City>) repository.findAll(example);
	}

	@Override
	public List<City> findByName(String name) {
		City city = new City();
        city.setName(name);

        ExampleMatcher matcher = ExampleMatcher.matching()
                .withMatcher("name", match -> match.exact())
                .withIgnorePaths("population");

        Example<City> example = Example.of(city, matcher);
        return (List<City>) repository.findAll(example);
	}
	
	 public List<City> findAllOrderedByNameDescending() {

	        return (List<City>) repository.findAllOrderedByNameDescending();
	    }

	@Override
	public Optional<City> findById(Long id) {
		 return repository.findById(id);
	}
	
	
	
	public void teste() {
		/*
		 * City qCity = new City(); JPAQuery<City> query = new
		 * JPAQuery<City>(entityManager);
		 * 
		 * query.from(null).from(qCity)
		 * 
		 * query.from(qCity).where(qCity.getName().equals("Bratislava")).distinct(); var
		 * c1 = query.fetch();
		 * 
		 * BooleanExpression booleanExpression = qCity.getPopulation().goe;
		 * OrderSpecifier<String> orderSpecifier = qCity.name.asc(); var cities2 =
		 * cityRepository.findAll(booleanExpression, orderSpecifier);
		 */	}

	@Override
	public List<City> findAllOrderByPopulationAsc() {
		return repository.findAllOrderByPopulationAsc();
	}

	@Override
	public List<City> findAllOrderByNameAsc() {
		Sort sort = Sort.by(Sort.Direction.ASC, "name");;
		
		
		
        return repository.findAllOrderByNameAsc(sort);
	}

	 @Override
	    public List<City> findByNameEndingWith(String ending) {
	        return repository.findByNameEndingWith(ending);
	    }

	    @Override
	    public List<City> findByPopulationLessThan(int population) {
	        return repository.findByPopulationLessThan(population);
	    }
}
