package com.project.notesnow.services;

import com.project.notesnow.dto.AddNotesDto;
import com.project.notesnow.dto.NotesDto;

import java.util.List;
import java.util.Map;

public interface NotesService {

    List<NotesDto> getAllDTO();

    NotesDto getNotesById(Long id);

    NotesDto createNotes(AddNotesDto addNotesDto);

    NotesDto updateAll (Long id, AddNotesDto addNotesDto);

    NotesDto updatePartial (Long id, Map<String, Object> updates);

    void deleteNotes(Long id);

}
