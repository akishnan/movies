package com.cinemas.movies.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cinemas.movies.entity.Theater;
import com.cinemas.movies.entity.impl.TheaterImpl;
import com.cinemas.movies.repository.TheaterRepository;

@Repository
public class TheaterRepositoryImpl implements TheaterRepository {
	
	@Autowired
    private SessionFactory sessionFactory;


	@Override
	public long addTheater(Theater aTheater) {
		// TODO Auto-generated method stub
		return (Long) this.sessionFactory.getCurrentSession().save(aTheater);
	}

	@Override
	public Theater getTheaterById(long theaterId) {
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class, theaterId);
	}

	@Override
	public Theater getTheaterByName(String theaterName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class);
		if(!StringUtils.isEmpty(theaterName)){
			crit.add(Restrictions.like("theaterName", "%"+theaterName+"%"));
		}
		List<Theater> searchResult = crit.list();
		if (searchResult.size() > 0) {
			return searchResult.get(0);
		}
		return null;
	}

	@Override
	public List<Theater> getTheaters() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class);
		List<Theater> searchResult = crit.list();
		return searchResult;
	}

}
