package com.nixCompany.myLibProjekt.services.impl;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.services.EbookService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ImplEbookService implements EbookService {

    private static List<Ebook> ebookList;

    public List<Ebook> ImplEbookService() {
        ebookList = createListOfEbooks();
        return ebookList;
    }

    @Override
    public List<Ebook> createListOfEbooks() {
        if (ebookList == null) {
            ebookList = new ArrayList<Ebook>(100);
        }
        return ebookList;
    }

    @Override
    public List<Ebook> getAll() {
        return ebookList;
    }

    @Override
    public Ebook getById(int id) {
        for (Ebook book : ebookList) {
            if (book.getId() == id) {
                return book;
            } else {
                System.out.println("There are no Ebook with such id");
            }
        }
        return null;
    }

    @Override
    public boolean create(int id, String name, String author, String language, int numberOfPages, LocalDate dateOfRelease) {
        Ebook book = new Ebook(id, name, author, language, numberOfPages, dateOfRelease);
        if (book == null){
            return false;
        }
        return true;
    }

    @Override
    public Ebook update(Ebook ebook,int id, String name, String author, String language, int numberOfPages, LocalDate dateOfRelease) {
        ebook.setId(id);
        ebook.setName(name);
        ebook.setAuthor(author);
        ebook.setLanguage(language);
        ebook.setNumberOfPages(numberOfPages);
        ebook.setDateOfRelease(dateOfRelease);
        return ebook;
    }

    @Override
    public boolean delete(int id) {
        final Iterator<Ebook> iterator = ebookList.iterator();
        while (iterator.hasNext()){
            final Ebook ebook = iterator.next();
            if (ebook.getId() == id){
                iterator.remove();
                return true;
            }
        }
        return false;
    }
}
