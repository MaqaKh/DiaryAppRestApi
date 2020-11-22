package com.diary.app.controller;

import com.diary.app.entity.Note;
import com.diary.app.entity.User;
import com.diary.app.repository.NoteRepository;
import com.diary.app.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/note")
public class NoteController {

    private final NoteRepository noteRepository;

    private final UserRepository userRepository;

    public NoteController(NoteRepository noteRepository, UserRepository userRepository) {
        this.noteRepository = noteRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<Note> find() {
        return noteRepository.findAll();
    }

    @GetMapping("/user/{userId}")
    public List<Note> findByUser(@PathVariable Long userId) {
        System.out.println("userId = " + userId);
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NullPointerException("User does not exist"));
        return noteRepository.findByUser(user);
    }

    @PostMapping
    public void save(@RequestBody Note note) {
        noteRepository.save(note);
    }

    @PutMapping
    public void update(@RequestBody Note note) {
        noteRepository.save(note);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        noteRepository.deleteById(id);
    }

    public void findAll() {
    }

}
