package com.onboarding.genres.dao;

import com.onboarding.genres.model.entity.GenresEntity;

import java.util.List;

public interface GenresDAO {

    GenresEntity getGenreById(Integer genreId);

    GenresEntity getGenreByName(String genreName);

    List<GenresEntity> getGenres();
}
