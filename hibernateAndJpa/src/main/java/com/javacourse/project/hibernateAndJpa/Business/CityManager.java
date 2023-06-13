package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Dataacsess.IcityDal;
import com.javacourse.project.hibernateAndJpa.Entities.City;


@Service
public class CityManager implements ICityService {
	
	private IcityDal cityDal;
	
	@Autowired
	public CityManager(IcityDal cityDal) {
		this.cityDal = cityDal;
	}

	@Override
	@Transactional
	public List<City> GetAll() {
		
		return this.cityDal.GetAll();
	}

	@Override
	@Transactional
	public void add(City city) {
		// business
		this.cityDal.add(city);
		
	}

	@Override
	@Transactional
	public void update(City city) {
		this.cityDal.update(city);
		
		//this.cityDal.update(city);
		
	}

	@Override
	@Transactional
	public void delete(City city) {
		this.cityDal.delete(city);
		
	}

	@Override
	
	public City getById(int id) {
		return this.cityDal.getById(id);
	}

}
