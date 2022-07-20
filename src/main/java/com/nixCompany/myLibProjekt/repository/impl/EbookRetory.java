package com.nixCompany.myLibProjekt.repository.impl;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.repository.IEbookRetory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class EbookRetory implements IEbookRetory {

    private static List<Ebook> ebookList;
    public EbookRetory() {
        ebookList = createListOfEbooks();
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
    public Optional<Ebook> getById(int id) {
        for (Ebook book : ebookList) {
            if (book.getId() == id) {
                return Optional.of(book);
            }
        }
        System.out.println("There are no Ebook with such id");
        return Optional.empty();
    }

    @Override
    public Ebook create(int id, String name, String author, String language, int numberOfPages) {
        return new Ebook(id, name, author, language, numberOfPages);
    }

    @Override
    public Ebook update(Ebook ebook, int id, String name, String author, String language, int numberOfPages) {
        ebook.setId(id);
        ebook.setName(name);
        ebook.setAuthor(author);
        ebook.setLanguage(language);
        ebook.setNumberOfPages(numberOfPages);
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
