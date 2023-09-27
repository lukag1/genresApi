package com.onboarding.genres.service;

import com.onboarding.genres.dao.GenresDAO;
import com.onboarding.genres.mapper.ObjectUtilMapper;
import com.onboarding.genres.model.dto.GenresDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenresService {

    @Autowired
    GenresDAO genresDAO;

    @Autowired
    ObjectUtilMapper mapper;

    public List<GenresDTO> getGenres() {
        return mapper.mapList(genresDAO.getGenres(), GenresDTO.class);
    }

    public GenresDTO getGenreById(Integer genreId) {
        return mapper.map(genresDAO.getGenreById(genreId), GenresDTO.class);
    }

    public GenresDTO getGenreByName(String genreName) {
        return mapper.map(genresDAO.getGenreByName(genreName), GenresDTO.class);
    }

}
