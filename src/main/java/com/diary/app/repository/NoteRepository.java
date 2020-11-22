package com.diary.app.repository;

import com.diary.app.entity.Note;
import com.diary.app.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends JpaRepository<Note, Long> {

    List<Note> findByUser(User user);
}
