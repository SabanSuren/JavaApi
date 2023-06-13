package com.javacourse.project.hibernateAndJpa.Dataacsess;
import java.util.List;

import com.javacourse.project.hibernateAndJpa.Entities.City;

public interface IcityDal {
	List<City> GetAll();
	void add(City city);
	void update(City city);
	void delete(City city);
	City getById(int id);
	
	

}
