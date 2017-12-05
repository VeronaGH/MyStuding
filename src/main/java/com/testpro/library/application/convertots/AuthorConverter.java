package com.testpro.library.application.convertots;

import com.testpro.library.application.dto.AuthorDTO;
import com.testpro.library.domain.model.Author;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for entity Author
 */
@Component
public class AuthorConverter {

    /**
     * Convert  Author object to AuthorDTO object
     *
     * @param author Author
     * @return AuthorDTO
     */
    public AuthorDTO convertToAuthorDTO(Author author) {
        if (author == null) {
            return null;
        }
        return new AuthorDTO(
                author.getName(),
                author.getSurname(),
                author.getYearOfBirth(),
                author.getCitizenship(),
                author.getBiography(),
                author.isStillAlive());
    }

    /**
     * Convert  AuthorDTO object to Author object
     *
     * @return Author
     */
    public Author convertToAuthor(AuthorDTO authorDTO) {
        return new Author(
                0,
                authorDTO.getName(),
                authorDTO.getSurname(),
                authorDTO.getYearOfBirth(),
                authorDTO.getCitizenship(),
                authorDTO.getBiography(),
                authorDTO.isStillAlive());
    }

    /**
     * Convert  List<Author> object to List<AuthorDTO> object
     *
     * @param authorList List<Author>
     * @return List<AuthorDTO>
     */
    public List<AuthorDTO> convertToAuthorDTOList(List<Author> authorList) {
        List<AuthorDTO> authorDTOList = new ArrayList<AuthorDTO>();
        for (Author author : authorList) {
            authorDTOList.add(convertToAuthorDTO(author));
        }
        return authorDTOList;
    }
}
