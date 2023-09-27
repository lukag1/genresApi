package com.onboarding.genres;

import com.onboarding.genres.helper.Helper;
import com.onboarding.genres.model.dto.GenresDTO;
import com.onboarding.genres.service.GenresService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(produces = "application/json", value = "/genres")
public class GenresResource {

    @Autowired
    GenresService genresService;

    @Autowired
    Helper helper;

    private static final Logger logger = LogManager.getLogger(GenresResource.class);

    @GetMapping
    public ResponseEntity<List<GenresDTO>> getGenres(@RequestHeader("Transaction-ID") Optional<String> transactionId) {
        logger.info("Method getGenres started! ");

        List<GenresDTO> genresDTOList = genresService.getGenres();
        logger.info("API response - getGenres -> " + helper.convertObjectToString(genresDTOList));

        logger.info("Method getGenres finished! ");
        return new ResponseEntity<>(genresDTOList, HttpStatus.OK);
    }

    @GetMapping(value = "/{genreId:[0-9]+}")
    public ResponseEntity<GenresDTO> getGenreById(@RequestHeader("Transaction-ID") Optional<String> transactionId,
                                                        @PathVariable("genreId") Integer genreId) {
        logger.info("Method getGenre by ID " + genreId + " started! ");

        GenresDTO genreDTO = genresService.getGenreById(genreId);
        logger.info("API response - getGenreById -> " + helper.convertObjectToString(genreDTO));

        logger.info("Method getGenre by ID " + genreId + " finished! ");
        return new ResponseEntity<>(genreDTO, HttpStatus.OK);
    }

    @GetMapping(value = "/{genreName:[A-Za-z]+}")
    public ResponseEntity<GenresDTO> getGenreByName(@RequestHeader("Transaction-ID") Optional<String> transactionId,
                                                  @PathVariable("genreName") String genreName) {
        logger.info("Method getGenreByName by genreName " + genreName + " started! ");

        GenresDTO genreDTO = genresService.getGenreByName(genreName);
        logger.info("API response - getGenreByName -> " + helper.convertObjectToString(genreDTO));

        logger.info("Method getGenreByName by genreName " + genreName + " finished! ");
        return new ResponseEntity<>(genreDTO, HttpStatus.OK);
    }

}
