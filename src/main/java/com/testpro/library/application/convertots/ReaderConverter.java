package com.testpro.library.application.convertots;

import com.testpro.library.application.dto.ReaderDTO;
import com.testpro.library.domain.model.Reader;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Converter class for entity Reader
 */
@Component
public class ReaderConverter {

    /**
     * Convert ReaderDTO object to Reader
     *
     * @return Reader class
     */
    public Reader convertToReader(ReaderDTO readerDTO) {
        return new Reader(
                0,
                readerDTO.getName(),
                readerDTO.getSurname(),
                readerDTO.getAddress(),
                readerDTO.getState());
    }

    /**
     * Convert Reader object to ReaderDTO
     *
     * @param reader Reader class
     * @return ReaderDTO class
     */
    public ReaderDTO convertToReaderDTO(Reader reader) {
        if (reader == null) {
            return null;
        }
        return new ReaderDTO(
                reader.getName(),
                reader.getSurname(),
                reader.getAddress(),
                reader.getState());
    }

    /**
     * Convert List<Reader> object to List<ReaderDTO>
     *
     * @param readerList Reader class
     * @return ReaderDTOList class
     */
    public List<ReaderDTO> convertToReaderDTOList(List<Reader> readerList) {
        List<ReaderDTO> readerDTOList = new ArrayList<ReaderDTO>();
        for (Reader reader : readerList) {
            readerDTOList.add(convertToReaderDTO(reader));
        }
        return readerDTOList;
    }


}
