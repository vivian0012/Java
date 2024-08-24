package com.programming.category.controller;

import com.programming.category.model.ModelCategory;
import com.programming.category.service.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ControllerCategory {

    @Autowired
    private ServiceCategory serviceCategory;

    // READ ALL
    @GetMapping("/category/readALL")
    public ResponseEntity<List<ModelCategory>> readAllObj(){
        List<ModelCategory> ModelCategory = serviceCategory.readAll();
        return ResponseEntity.ok().body(ModelCategory);
    }

    // READ BY ID
    @GetMapping("/category/readById/{id}")
    public ResponseEntity<ModelCategory> readId(@PathVariable Long id){
        ModelCategory idModelCategory = serviceCategory.readById(id);
        return ResponseEntity.ok().body(idModelCategory);
    }

    @PostMapping("/category/creatObj")
    public ResponseEntity<ModelCategory> creat(@RequestBody ModelCategory obj){
        ModelCategory model = serviceCategory.creatObj(obj);
        return ResponseEntity.ok().body(model);
    }

    // UPDATE OBJ
    @PutMapping("/category/updateObj/{id}")
    public ResponseEntity<ModelCategory> update(@RequestBody ModelCategory objBook, @PathVariable Long id){
        ModelCategory model = serviceCategory.updateObj(objBook, id);
        return ResponseEntity.ok().body(model);
    }

    // DELETE
    @DeleteMapping("/category/{id}")
    public void deleteUsingId(@PathVariable Long id){
        serviceCategory.deleteByID(id);
    }
}
