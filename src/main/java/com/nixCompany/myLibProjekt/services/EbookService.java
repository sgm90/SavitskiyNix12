package com.nixCompany.myLibProjekt.services;

import com.nixCompany.myLibProjekt.entities.Ebook;

import java.time.LocalDate;
import java.util.List;

public interface EbookService {

    List<Ebook> createListOfEbooks();
    List<Ebook> getAll();
    Ebook getById(int id);
    boolean create(int id, String name, String author, String language, int numberOfPages, LocalDate dateOfRelease);
    Ebook update(Ebook ebook, int id, String name, String author, String language, int numberOfPages, LocalDate dateOfRelease);
    boolean delete(int id);


}
