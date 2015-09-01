package com.cinemas.movies.repository.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.cinemas.movies.entity.Movie;
import com.cinemas.movies.entity.impl.MovieImpl;
import com.cinemas.movies.repository.MovieRepository;

@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public long addMovie(Movie aMovie) {
		return (Long) this.sessionFactory.getCurrentSession().save(aMovie);
	}

	@Override
	public Movie getMovieById(long movieId) {
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class, movieId);
	}

	@Override
	public Movie getMovieByName(String movieName) {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class);
		if(!StringUtils.isEmpty(movieName)){
			crit.add(Restrictions.like("movieName", "%"+movieName+"%"));
		}
		List<Movie> searchResult = crit.list();
		if (searchResult.size() > 0) {
			return searchResult.get(0);
		}
		return null;
	}

	@Override
	public List<Movie> getMovies() {
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class);
		List<Movie> searchResult = crit.list();
		return searchResult;
	}

}
