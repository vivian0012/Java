package com.programming.category.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_category")
public class ModelCategory implements Serializable {

    private static final long SerialUIDVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategory;

    private String nameCategory;

    private List<AuxiliaryList> auxiliaryListList = new ArrayList<>();

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
