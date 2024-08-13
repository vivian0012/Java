package com.programming.book.service;

import com.programming.book.model.ModelBook;
import com.programming.book.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ServiceBook {

    @Autowired
    private RepositoryBook repositoryBook;


    // CREAT OBJ
    public ModelBook creatObj(ModelBook obj){
        return repositoryBook.save(obj);
    }

    // READ ALL
    public List<ModelBook> readAll(){
        return repositoryBook.findAll();
    }

    // READ By ID
    public ModelBook readById(Long id){
        return repositoryBook.findById(id).get();
    }

    // UPDATE
    public ModelBook updateObj(ModelBook oldObj, Long id) {
            ModelBook newObj = repositoryBook.findById(id).get();
            DataUpdate(newObj, oldObj);
            return newObj;

    }
    private void DataUpdate(ModelBook newObj, ModelBook oldObj) {
        newObj.setName(oldObj.getName());
        newObj.setDescription(oldObj.getDescription());
    }

    // DELETE BY ID
    public void deleteByID(Long id){
        ModelBook deleteId = repositoryBook.findById(id).get();
        repositoryBook.deleteById(deleteId.getIdBook());
    }


}
