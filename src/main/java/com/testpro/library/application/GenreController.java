package com.testpro.library.application;

import com.testpro.library.application.dto.GenreDTO;
import com.testpro.library.domain.model.Genre;
import com.testpro.library.domain.service.GenreService;
import com.testpro.library.domain.service.IdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for processing incoming json contains Genre data
 */
@RestController
@RequestMapping(value = "/library/v1/genres")
public class GenreController {
    private GenreService genreService;
    private IdService idService;

    @Autowired
    public GenreController(GenreService genreService, IdService idService) {
        this.genreService = genreService;
        this.idService = idService;
    }

    /**
     * Save method of controller, asses method 'POST'
     *
     * @param genreDTO class
     * @return genreDTO
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity storeGenre(@RequestBody final GenreDTO genreDTO) {
        if (genreDTO.getName() != null) {
            Genre genre = new Genre(
                    idService.incIdGenre(),
                    genreDTO.getName(),
                    genreDTO.getDescription());
            return ResponseEntity.status(HttpStatus.CREATED).contentType(MediaType.APPLICATION_JSON).body(
                    new GenreDTO().convertToGenreDTO(genreService.storeGenre(genre)));
        }
        return ResponseEntity.status(HttpStatus.PARTIAL_CONTENT).contentType(MediaType.APPLICATION_JSON).body(genreDTO);
    }

    /**
     * This method delete all documents which contains incoming name
     *
     * @param genreDTO class
     * @return List<genreDTO>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity deleteGenre(@RequestBody final GenreDTO genreDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new GenreDTO().convertToGenreDTO(genreService.deleteGenre(genreDTO.convertToGenre())));
    }

    /**
     * This method return document which contains appropriate name or return all
     * documents, if parameters not defined.
     *
     * @return List<GenreDTO>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity searchGenre(
            @RequestParam(value = "name", required = false) final String name,
            @RequestParam(value = "description", required = false) final String description) {
        if (name != null) {
            return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                    new GenreDTO().convertToGenreDTO(genreService.findByName(new Genre(0, name, description))));
        }
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new GenreDTO().convertToGenreDTOList(genreService.findAll()));
    }

    /**
     * This method updates appropriate entity in DB if find single entity by name, else returns the list of entity
     *
     * @param genreDTO class
     * @return List<GenreDTO>
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.PUT)
    public ResponseEntity updateGenre(@RequestBody final GenreDTO genreDTO) {
        return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.APPLICATION_JSON).body(
                new GenreDTO().convertToGenreDTO(genreService.updateGenre(genreDTO.convertToGenre())));
    }
}
