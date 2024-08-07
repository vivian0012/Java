package com.programming.book.repository;

import com.programming.book.model.EntityBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryBook extends JpaRepository<EntityBook, Long> {
}
