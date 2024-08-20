package com.programming.category.controller;

import com.programming.book.model.ModelBook;
import com.programming.category.model.ModelCategory;
import com.programming.category.service.ServiceCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ControllerCategory {

    @Autowired
    private ServiceCategory serviceCategory;


    @PostMapping("/category/creatObj")
    public ResponseEntity<ModelCategory> creat(@RequestBody ModelCategory obj){
        ModelCategory model = serviceCategory.creatObj(obj);
        return ResponseEntity.ok().body(model);
    }
}
