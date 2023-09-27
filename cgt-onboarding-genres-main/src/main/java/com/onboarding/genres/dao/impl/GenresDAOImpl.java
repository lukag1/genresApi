package com.onboarding.genres.dao.impl;

import com.onboarding.genres.dao.GenresDAO;
import com.onboarding.genres.exception.InternalServerErrorException;
import com.onboarding.genres.exception.ResourceNotFoundException;
import com.onboarding.genres.helper.Helper;
import com.onboarding.genres.helper.UtilQueryBuilder;
import com.onboarding.genres.model.entity.GenresEntity;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GenresDAOImpl implements GenresDAO {

    @Autowired
    UtilQueryBuilder utilQueryBuilder;

    @Autowired
    NamedParameterJdbcTemplate namedJdbcTemplate;

    @Autowired
    Helper helper;

    private static final Logger logger = LogManager.getLogger(GenresDAOImpl.class);

    @Override
    public GenresEntity getGenreById(Integer genreId) {
        String sql = utilQueryBuilder.getSelectInitialQuery() + utilQueryBuilder.getGenresTableName() + " WHERE genre_id = :genreId";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("genreId", genreId);
        try {
            return namedJdbcTemplate.queryForObject(sql, namedParameters,
                    BeanPropertyRowMapper.newInstance(GenresEntity.class));
        } catch (EmptyResultDataAccessException ex) {
            logger.error("EmptyResultDataAccessException exception occurred -> " + helper.convertObjectToString(ex));
            throw new ResourceNotFoundException("Genre with ID " + genreId + " does not exist");
        } catch (DataAccessException e) {
            logger.error("DataAccessException exception occurred -> " + helper.convertObjectToString(e));
            throw new InternalServerErrorException("Problem with database");
        }
    }

    @Override
    public GenresEntity getGenreByName(String genreName) {
        String sql = utilQueryBuilder.getSelectInitialQuery() + utilQueryBuilder.getGenresTableName() + " WHERE genre_name = :genreName";
        SqlParameterSource namedParameters = new MapSqlParameterSource().addValue("genreName", genreName);
        try {
            return namedJdbcTemplate.queryForObject(sql, namedParameters,
                    BeanPropertyRowMapper.newInstance(GenresEntity.class));
        } catch (EmptyResultDataAccessException ex) {
            logger.error("EmptyResultDataAccessException exception occurred -> " + helper.convertObjectToString(ex));
            throw new ResourceNotFoundException("Genre with name " + genreName + " does not exist");
        } catch (DataAccessException e) {
            logger.error("DataAccessException exception occurred -> " + helper.convertObjectToString(e));
            throw new InternalServerErrorException("Problem with database");
        }
    }

    @Override
    public List<GenresEntity> getGenres() {
        String sql = utilQueryBuilder.getSelectInitialQuery() + utilQueryBuilder.getGenresTableName();
        try {
            return namedJdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(GenresEntity.class));
        } catch (DataAccessException e) {
            logger.error("DataAccessException exception occurred -> " + helper.convertObjectToString(e));
            throw new InternalServerErrorException("Problem with database");
        }
    }
}
