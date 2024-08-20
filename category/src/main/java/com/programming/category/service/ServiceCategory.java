package com.programming.category.service;


import com.programming.book.model.ModelBook;
import com.programming.category.model.AuxiliaryList;
import com.programming.category.model.ModelCategory;
import com.programming.category.repository.RepositoryCategory;
import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCategory {

    @Autowired
    private RepositoryCategory repositoryCategory;

    // IMPLEMENTS WEB CLIENT CONSTRUCTOR
    private final WebClient webClientConfig;

    public ServiceCategory(WebClient.Builder webClientBuilder) {
        this.webClientConfig = webClientBuilder.build();
    }

    Mono<ModelBook> modelCategoryMono(Long idBook){
        return webClientConfig
                .get()
                .uri("http://localhost:2000/api/book/readById/" + idBook)
                .retrieve()
                .bodyToMono(ModelBook.class);
    }

    // PUT HERE WEB CLIENT
    public ModelCategory creatObj(ModelCategory obj){
        List<AuxiliaryList> newListToCategory = new ArrayList<>();

        for(AuxiliaryList list : obj.getAuxiliaryListList() ) {
            ModelBook modeBookGet = modelCategoryMono(list.getIdBooks()).block(); // ID referenciado vindo do ModelCategory obj

            if(modeBookGet != null) {
                System.out.println("Testando:" + modeBookGet.getName());
                AuxiliaryList auxiliary = new AuxiliaryList();
                auxiliary.setIdBooks(modeBookGet.getIdBook());
                auxiliary.setName(modeBookGet.getName());
                auxiliary.setModelCategories(obj);
                newListToCategory.add(auxiliary);
            } else {
                return null;
            }
        }
        obj.setAuxiliaryListList(newListToCategory);
        return repositoryCategory.save(obj);
    }
    // TESTE
    public ModelCategory testando (ModelCategory obj){
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
