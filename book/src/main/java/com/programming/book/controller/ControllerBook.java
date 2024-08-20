package com.programming.book.controller;

import com.programming.book.model.ModelBook;
import com.programming.book.service.ServiceBook;
import net.sf.jsqlparser.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ClientHttpResponseDecorator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@RestController
public class ControllerBook {

    @Autowired
    private ServiceBook serviceBook;

    // READ ALL
    @GetMapping("/book/readALL")
    public ResponseEntity<List<ModelBook>> readAllObj(){
        List<ModelBook> modelBook = serviceBook.readAll();
        return ResponseEntity.ok().body(modelBook);
    }

    // READ BY ID
    @GetMapping("/book/readById/{id}")
    public ResponseEntity<ModelBook> readId(@PathVariable Long id){
        ModelBook idModelBook = serviceBook.readById(id);
        return ResponseEntity.ok().body(idModelBook);
    }

    // CREAT OBJ
    @PostMapping("/book/creatObj")
    public ResponseEntity<ModelBook> creat(@RequestBody ModelBook obj){
        ModelBook modelBook = serviceBook.creatObj(obj);
        return ResponseEntity.ok().body(modelBook);
    }

    // UPDATE OBJ
        @PutMapping("/book/updateObj/{id}")
    public ResponseEntity<ModelBook> update(@RequestBody ModelBook objBook, @PathVariable Long id){
        ModelBook modelBook = serviceBook.updateObj(objBook, id);
        return ResponseEntity.ok().body(modelBook);
    }

    // DELETE
    @DeleteMapping("/book/{id}")
    public void deleteUsingId(@PathVariable Long id){
        serviceBook.deleteByID(id);
    }
}
