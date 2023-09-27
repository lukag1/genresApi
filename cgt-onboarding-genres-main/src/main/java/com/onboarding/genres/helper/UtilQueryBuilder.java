package com.onboarding.genres.helper;

import org.springframework.stereotype.Component;

@Component
public class UtilQueryBuilder {
    private static final String genresTableName = "genresdb.genres";

    public String getGenresTableName(){
        return genresTableName;
    }

    public String getSelectInitialQuery(){
        return "SELECT * FROM ";
    }
}
