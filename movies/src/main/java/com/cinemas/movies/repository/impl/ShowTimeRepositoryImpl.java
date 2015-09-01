package com.cinemas.movies.repository.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.ShowTime;
import com.cinemas.movies.entity.impl.ShowTimeImpl;
import com.cinemas.movies.repository.ShowTimeRepository;


@Repository
public class ShowTimeRepositoryImpl implements ShowTimeRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public ShowTime getShowTimeById(long showTimeId) {
		return (ShowTime) this.sessionFactory.getCurrentSession().get(ShowTimeImpl.class, showTimeId);
	}

	@Override
	public List<ShowTime> getTheatersPlayingMovie(long movieId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowTimeImpl.class)
				.add(Restrictions.eq("movie.id", movieId));		
		List<ShowTime> showTimes = crit.list();
		return showTimes;
	}

	@Override
	public List<ShowTime> getMoviesPlayingInTheater(long theaterId) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowTimeImpl.class)
				.add(Restrictions.eq("theater.id", theaterId));		
		List<ShowTime> showTimes = crit.list();
		return showTimes;
	}

	@Override
	public ShowTime getShowTime(long movieId, long theaterId, long screenId, Date showTime) {
		
		ShowTime aShowTime = null;
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowTimeImpl.class);
		crit.add(Restrictions.eq("movie.id", movieId));
		crit.add(Restrictions.eq("theater.id", theaterId));
		crit.add(Restrictions.eq("screenId", screenId));	
		crit.add(Restrictions.eq("showTime", showTime));
		List<ShowTime> showTimes = crit.list();
		if (showTimes.size() > 0) {
			return showTimes.get(0);
		}
		return null;
	}

}
