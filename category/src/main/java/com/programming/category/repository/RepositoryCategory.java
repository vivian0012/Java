package com.programming.category.repository;

import com.programming.category.model.ModelCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCategory extends JpaRepository<ModelCategory, Long> {
}
