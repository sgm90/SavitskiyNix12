package com.nixCompany.myLibProjekt.services;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.repository.impl.EbookRetory;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

public class OptionalService {

    private final EbookRetory ebookRetory = new EbookRetory();
    private final EbookService ebookService;
    private final List<Ebook> myListOfBooks;

    private Optional<Ebook> ebookOptional;
    final Ebook defEbook = new Ebook(1, "Java quick start", "Chan J", "English", 272);


    public OptionalService() {
        ebookRetory.createListOfEbooks();
        ebookService = new EbookService(ebookRetory);
        myListOfBooks = ebookService.fillAndGetEbookList();
    }


//    public void optionalExamples() {
//      int id = 5;
//
//        isPresent(id);
//        ifPresent(id);
//        orElse(id);
//        orElseThrow(id);
//        or(id);
//        orElseGet(id);
//        filter(id);
//        map(id);
//        ifPresentOrElse(id);
//    }

    void isPresent(int id){
        if (ebookRetory.getById(id).isPresent()){
            System.out.println("Yap, it is hear");
        }
    }

    void ifPresent(int id) {
        ebookRetory.getById(id).ifPresent(ebook -> {
            System.out.println(ebook.getName());
        });
    }

    void orElse(int id) {
        ebookRetory.getById(4).orElse(ebookRetory.create(7, "Java library professional volume 1",
                "Horstmann Kay", "English", 866));
    }


    void orElseGet() {
        ebookRetory.getById(3).orElseGet(() -> {
            System.out.println(ebookRetory.getAll());
            return defEbook;
        });
    }


    void map(int id) {
        ebookRetory.getById(id).map(ebook -> {
            String str = ebook.getName();
            return str;
        });
    }

    void ifPresentOrElse(int id) {
        ebookRetory.getById(id).ifPresentOrElse(ebook -> {
            System.out.println("hell yeah");
        }, () -> {
            System.out.println(" Cannot find ebook with id ");
        });
    }

    boolean filter(int id) {
        return ebookRetory.getById(id).filter(Predicate.isEqual(myListOfBooks.get(id))).isPresent();
    }
    void orElseThrow(int id){
        final  Ebook ebook = ebookRetory.getById(id).orElseThrow(() ->new IllegalArgumentException("Cannot find auto with id " + id));
    }
    void or(int id){
        final Optional<Ebook> ebookOptional1 = ebookRetory.getById(id).or(() ->{
            System.out.println("ups, i do not have it");
            return Optional.empty();
        });
    }

}