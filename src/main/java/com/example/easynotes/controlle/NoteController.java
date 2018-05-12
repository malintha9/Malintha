package com.example.easynotes.controlle;

import com.example.easynotes.model.Note;
import com.example.easynotes.repository.NoteRepository;
import org.aspectj.weaver.ast.Not;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.expression.ExpressionException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by malinthamadusanka on 5/12/18.
 */
@RestController
@RequestMapping("/api")
public class NoteController {

    @Autowired
    private NoteRepository noteRepository;

    @GetMapping("/notes")
    public List<Note> getAllNotes() {

        return noteRepository.findAll();

    }

    @PostMapping("/notes")
    public Note createNote(@Valid @RequestBody Note note) {

        return noteRepository.save(note);
    }

    public Note getNoteById(@PathVariable(value = "id") Long noteId) {
        return noteRepository.findById(noteId).orElseThrow(()-> new ExpressionException("aa"));
    }
}
