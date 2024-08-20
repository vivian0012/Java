package com.programming.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;

@Entity
@Table(name = "auxiliary_list")
public class AuxiliaryList implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idBooks; // Receberá o ID do obj.
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_Book")
    @JsonIgnore
    private ModelCategory modelCategories;

    public AuxiliaryList(){
    }

    public AuxiliaryList(String name, ModelCategory modelCategories) {
        this.name = name;
        this.modelCategories = modelCategories;
    }

    public AuxiliaryList(Long idBooks) {
        this.idBooks = idBooks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ModelCategory getModelCategories() {
        return modelCategories;
    }

    public void setModelCategories(ModelCategory modelCategories) {
        this.modelCategories = modelCategories;
    }

    public Long getIdBooks() {
        return idBooks;
    }

    public void setIdBooks(Long idBooks) {
        this.idBooks = idBooks;
    }
}
