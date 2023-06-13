package com.javacourse.project.hibernateAndJpa.Dataacsess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.javacourse.project.hibernateAndJpa.Entities.City;

import jakarta.persistence.EntityManager;

@Repository
public class HibernateCityDal implements IcityDal {
	
	private EntityManager entityManager;
	
	@Autowired
	public HibernateCityDal(EntityManager entityManager) {
	    this.entityManager = entityManager;
	}

	@Override
	@Transactional
	public List<City> GetAll() {
	    Session session = entityManager.unwrap(Session.class);
	    List<City> cities = session.createQuery("FROM City", City.class).getResultList();
	    return cities;
	}

	@Override
	@Transactional
	public void add(City city) {
		 Session session = entityManager.unwrap(Session.class);
		 session.persist(city);
	}

	@Override
	@Transactional
	public void update(City city) {
		 Session session = entityManager.unwrap(Session.class);
		 session.merge(city);
	}

	@Override
	@Transactional
	public void delete(City city) {
		 Session session = entityManager.unwrap(Session.class);
		 session.remove(city);
	}

	@Override
	@Transactional
	public City getById(int id) {
		 Session session = entityManager.unwrap(Session.class);
		 City city = session.get(City.class, id);
		 return city;
	}
}
