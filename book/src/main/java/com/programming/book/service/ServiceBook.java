package com.programming.book.service;

import com.programming.book.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceBook {

    @Autowired
    private RepositoryBook repositoryBook;

}
