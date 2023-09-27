package com.onboarding.genres.model.entity;

import org.springframework.data.relational.core.mapping.Column;

public class GenresEntity {

    @Column("genre_id")
    private Integer genreId;
    @Column("genre_name")
    private String genreName;

    public String getGenreName() {
        return genreName;
    }

    public Integer getGenreId() {
        return genreId;
    }

    public void setGenreName(String genreName) {
        this.genreName = genreName;
    }

    public void setGenreId(Integer genreId) {
        this.genreId = genreId;
    }
}
