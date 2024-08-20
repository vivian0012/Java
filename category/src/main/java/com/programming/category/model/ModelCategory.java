package com.programming.category.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_category")
public class ModelCategory implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    private String nameCategory;

    @JsonProperty("auxiliaryListList")
    @OneToMany(mappedBy = "modelCategories", cascade = CascadeType.ALL)
    private List<AuxiliaryList> auxiliaryListList = new ArrayList<>(); // ID: 1

    public ModelCategory() {}

    public ModelCategory(Long idCategory, String nameCategory, List<AuxiliaryList> auxiliaryListList) {
        this.idCategory = idCategory;
        this.nameCategory = nameCategory;
        this.auxiliaryListList = auxiliaryListList;
    }

    public Long getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public String getNameCategory() {
        return nameCategory;
    }

    public void setNameCategory(String nameCategory) {
        this.nameCategory = nameCategory;
    }

    public List<AuxiliaryList> getAuxiliaryListList() {
        return auxiliaryListList;
    }

    public void setAuxiliaryListList(List<AuxiliaryList> auxiliaryListList) {
        this.auxiliaryListList = auxiliaryListList;
    }
}
