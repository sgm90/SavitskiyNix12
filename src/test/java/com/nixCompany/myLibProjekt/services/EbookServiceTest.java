package com.nixCompany.myLibProjekt.services;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.repository.impl.EbookRetory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Array;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EbookServiceTest {
    private EbookService target;
    private EbookRetory ebookRetory;

    @BeforeEach
    void setUp() {

        ebookRetory = Mockito.mock(EbookRetory.class);
        target = new EbookService(ebookRetory);
    }

    @Test
    void fillAndGetEbookList_Test() {
        List<Ebook> ebookList = ebookRetory.getAll();
        ebookList.add(new Ebook(1, "Java quick start", "Chan J", "English", 272));
        ebookList.add(new Ebook(2, "On java 8", "Bryus Ekkel", "English", 1778));
        ebookList.add(new Ebook(3, "Algorithms on java", "Robert Sedzhvik", "English", 843));
        ebookList.add(new Ebook(4, "Stylish java", "Marko Faela", "English", 352));
        ebookList.add(new Ebook(5, "Java Concurrency in practice", "Tem Payerls", "English", 464));
        ebookList.add(new Ebook(6, "Moder Java", "Ken Kouzen", "English", 275));
        ebookList.add(new Ebook(7, "Java library professional volume 1", "Horstmann Kay", "English", 866));
        Boolean verify = Mockito.verify(ebookList.size() == 7);
        Assertions.assertTrue(verify);

    }

    @Test
    void deleteSeveralByIds_TwoIdsDeleting() throws Exception {
        int[] intIds = {1, 4};
        List<Ebook> ebookList = ebookRetory.getAll();
        Iterator<Ebook> iterator = ebookList.iterator();
        while (iterator.hasNext()) {
            final Ebook ebook = iterator.next();
            for (int i = 0; i < intIds.length; i++) {
                if (intIds[i] == ebook.getId()) {
                    iterator.remove();
                    Mockito.times(2);
                }
            }
        }
    }

    @Test
    public void printListOffEbooks_Test() {
        List<Ebook> ebookList = ebookRetory.createListOfEbooks();
        ebookList.add(new Ebook(1, "Java quick start", "Chan J", "English", 272));
        ebookList.add(new Ebook(2, "On java 8", "Bryus Ekkel", "English", 1778));
        Mockito.when(ebookRetory.getAll()).thenReturn(ebookList);
        target.printListOffEbooks();

    }


}