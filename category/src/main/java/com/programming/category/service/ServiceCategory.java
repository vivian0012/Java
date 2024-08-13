package com.programming.category.service;


import com.programming.category.model.ModelCategory;
import com.programming.category.repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceCategory {

    @Autowired
    private RepositoryCategory repositoryCategory;


    // PUT HERE WEB CLIENT
    public ModelCategory creatObj(ModelCategory obj){
        return repositoryCategory.save(obj);
    }

    // READ ALL
    public List<ModelCategory> readAll(){
        return repositoryCategory.findAll();
    }

    // READ By ID
    public ModelCategory readById(Long id){
        return repositoryCategory.findById(id).get();
    }

    // UPDATE
    public ModelCategory updateObj(ModelCategory oldObj, Long id) {
        ModelCategory newObj = repositoryCategory.findById(id).get();
        DataUpdate(newObj, oldObj);
        return newObj;

    }
    private void DataUpdate(ModelCategory newObj, ModelCategory oldObj) {
        newObj.setNameCategory(oldObj.getNameCategory());
    }

    // DELETE BY ID
    public void deleteByID(Long id){
        ModelCategory deleteId = repositoryCategory.findById(id).get();
        repositoryCategory.deleteById(deleteId.getIdCategory());
    }

}
