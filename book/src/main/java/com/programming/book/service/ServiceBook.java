package com.programming.book.service;

import com.programming.book.model.ModelBook;
import com.programming.book.repository.RepositoryBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ModelBook updateObj(ModelBook newObj, Long idObj){
        ModelBook oldObj = repositoryBook.getReferenceById(idObj);
        UpdateData(oldObj, newObj);
        return oldObj;
    }
    private void UpdateData(ModelBook oldObj, ModelBook newObj) {
        oldObj.setName(newObj.getName());
        oldObj.setDescription(newObj.getDescription());
        oldObj.setLinkToSell(newObj.getLinkToSell());
    }

    // DELETE BY ID
    public void deleteByID(Long id){
        ModelBook deleteId = repositoryBook.findById(id).get();
        repositoryBook.deleteById(deleteId.getIdBook());
    }


}
