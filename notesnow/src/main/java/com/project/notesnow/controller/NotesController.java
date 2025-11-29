package com.project.notesnow.controller;

import com.project.notesnow.dto.NotesDto;
import com.project.notesnow.dto.AddNotesDto;
import com.project.notesnow.services.NotesService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin("*")
public class NotesController {
    private final NotesService notesService;

    public NotesController(NotesService notesService) {
        this.notesService = notesService;
    }

    @GetMapping("/notesAll")
    public ResponseEntity<List<NotesDto>> getAllNotes (){
        return ResponseEntity.ok(notesService.getAllDTO());
    }

    @GetMapping("/notes/{id}")
    public ResponseEntity<NotesDto> getNotesByID(@PathVariable Long id){
//        return new NotesDto(4,"Note1","HI how are you");
        return ResponseEntity.ok(notesService.getNotesById(id));
    }

    @PostMapping("/notes")
    public ResponseEntity<NotesDto> createNotes (@RequestBody @Valid AddNotesDto addNotesDto){
//        return notesService.createNotes(notesDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(notesService.createNotes(addNotesDto));
    }

    @PutMapping("/notes/{id}")
    public ResponseEntity<NotesDto> updateAll (@PathVariable Long id ,@RequestBody @Valid AddNotesDto addNotesDto){
        return ResponseEntity.status(HttpStatus.OK).body(notesService.updateAll(id, addNotesDto));
    }

    @PatchMapping("/notes/{id}")
    public ResponseEntity<NotesDto> updatePartial (@PathVariable Long id, @RequestBody Map<String, Object> updates){
<<<<<<< HEAD
        return ResponseEntity.status(HttpStatus.OK).body(notesService.updatePartial (id, updates));
=======
        return ResponseEntity.ok(notesService.updatePartial (id, updates));
>>>>>>> fce19c064da9224a8541da43785beaf1244dec04
    }

    @DeleteMapping("/notes/{id}")
    public ResponseEntity<Void> deleteNotes(@PathVariable Long id){
        notesService.deleteNotes(id);
        return ResponseEntity.noContent().build();
    }

}
