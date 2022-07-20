package com.nixCompany.myLibProjekt.services;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.repository.impl.EbookRetory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class EbookService {

    private final EbookRetory ebookRetory;
    private static final Logger LOGGER = LoggerFactory.getLogger(Ebook.class);

    public EbookService(EbookRetory ebookRetory){
        this.ebookRetory = ebookRetory;
    }
    public List<Ebook> fillAndGetEbookList(){
        List<Ebook> ebookList = ebookRetory.getAll();
        ebookList.add(new Ebook(1,"Java quick start","Chan J", "English", 272));
        ebookList.add(new Ebook(2,"On java 8","Bryus Ekkel","English", 1778));
        ebookList.add(new Ebook(3,"Algorithms on java", "Robert Sedzhvik", "English",843));
        ebookList.add(new Ebook(4,"Stylish java", "Marko Faela", "English", 352));
        ebookList.add(new Ebook(5,"Java Concurrency in practice", "Tem Payerls","English", 464));
        ebookList.add(new Ebook(6,"Moder Java","Ken Kouzen", "English", 275));
        ebookList.add(new Ebook(7,"Java library professional volume 1", "Horstmann Kay", "English", 866));
        LOGGER.info("List was filed");
        return ebookList;
    }
    public void deleteSeveralByIds(int... intIds) {
        List<Ebook> ebookList = ebookRetory.getAll();
        Iterator<Ebook> iterator = ebookList.iterator();
        while (iterator.hasNext()) {
            final Ebook ebook = iterator.next();
            for (int i = 0; i < intIds.length; i++) {
                if (intIds[i] == ebook.getId()) {
                    iterator.remove();
                    LOGGER.info(ebook.getName() + " was deleted");
                }
            }
        }
    }


    public void printListOffEbooks() {
        for (Ebook ebook : ebookRetory.getAll()) {
            System.out.println(ebook);
        }
    }

    public void hasEbookwithId(int id){
        Optional<Ebook> isIn = ebookRetory.getById(id);
        System.out.println(isIn);
    }


}
