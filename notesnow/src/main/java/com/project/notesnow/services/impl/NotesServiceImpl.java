package com.project.notesnow.services.impl;

import com.project.notesnow.dto.AddNotesDto;
import com.project.notesnow.dto.NotesDto;
import com.project.notesnow.entity.Notes;
import com.project.notesnow.repository.NotesRepository;
import com.project.notesnow.services.NotesService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class NotesServiceImpl implements NotesService {

    private final NotesRepository notesRepository;

    public NotesServiceImpl(NotesRepository notesRepository) {
        this.notesRepository = notesRepository;
    }

    @Override
    public List<NotesDto> getAllDTO() {
        List<Notes> notes = notesRepository.findAll();

        return notes
                .stream()
                .map((note -> new NotesDto(note.getId(), note.getHeading(), note.getContent())))
                .toList();
    }

    @Override
    public NotesDto getNotesById(Long id) {
        Notes notes = notesRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("No notes id  " + id));

        return new NotesDto(
                notes.getId(),
                notes.getHeading(),
                notes.getContent()
        );

    }

    @Override
    public NotesDto createNotes(AddNotesDto addNotesDto) {
        Notes notes = new Notes();
        notes.setHeading(addNotesDto.getHeading());
        notes.setContent(addNotesDto.getContent());

        // Save the entity
        Notes savedNotes = notesRepository.save(notes);

        // Return the saved entity as DTO
        return new NotesDto(savedNotes.getId(), savedNotes.getHeading(), savedNotes.getContent());
    }

    @Override
    public NotesDto updateAll(Long id, AddNotesDto addNotesDto) {
        Notes existing = notesRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));

        existing.setHeading(addNotesDto.getHeading());
        existing.setContent(addNotesDto.getContent());

        Notes savedNotes = notesRepository.save(existing);

        return new NotesDto(savedNotes.getId(), savedNotes.getHeading(), savedNotes.getContent());
    }

    @Override
    public NotesDto updatePartial(Long id, Map<String, Object> updates) {
        Notes existing = notesRepository.findById(id).orElseThrow(() -> new RuntimeException("Note not found"));

        if (updates.containsKey("heading")) {
            existing.setHeading((String) updates.get("heading"));
        }
        if (updates.containsKey("content")) {
            existing.setContent((String) updates.get("content"));
        }

        Notes savedNotes = notesRepository.save(existing);

        return new NotesDto(savedNotes.getId(), savedNotes.getHeading(), savedNotes.getContent());
    }

    @Override
    public void deleteNotes(Long id) {
        if (!notesRepository.existsById(id)) {
            throw new RuntimeException("ID not found");
        }
        notesRepository.deleteById(id);
    }
}
