package com.programming.book.model;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "tb_books")
public class ModelBook implements Serializable {

    private static final long SerialUIDVersion = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBook;
    private String name;
    private String description;
    private String linkToSell;

    public ModelBook(){}

    public ModelBook(Long idBook, String name, String description, String linkToSell) {
        this.idBook = idBook;
        this.name = name;
        this.description = description;
        this.linkToSell = linkToSell;
    }

    public Long getIdBook() {
        return idBook;
    }

    public void setIdBook(Long idBook) {
        this.idBook = idBook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLinkToSell() {
        return linkToSell;
    }

    public void setLinkToSell(String linkToSell) {
        this.linkToSell = linkToSell;
    }
}
