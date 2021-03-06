package com.nixCompany.myLibProjekt.repository;

import com.nixCompany.myLibProjekt.entities.Ebook;

import java.util.List;

public interface IEbookRetory {

    List<Ebook> createListOfEbooks();
    List<Ebook> getAll();
    Ebook getById(int id);
    Ebook create(int id, String name, String author, String language, int numberOfPages);

    Ebook update(Ebook ebook, int id, String name, String author, String language, int numberOfPages);

    boolean delete(int id);


}
