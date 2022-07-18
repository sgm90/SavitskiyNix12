package com.nixCompany.myLibProjekt.services;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.repository.impl.EbookRetory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;

import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EbookServiceTest {
    private EbookService target;
    private static EbookRetory ebookRetory;


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
        Mockito.when(ebookRetory.createListOfEbooks()).thenThrow(new  IllegalArgumentException("somesing was wrong"));
//        ebookRetory.createListOfEbooks();
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
                }
            }
        }
    }

    @Test
    public void isEnglish() {
        ArgumentMatcher argumentMatcher = new ArgumentMatcher() {
            @Override
            public boolean matches(Object o) {
                Ebook ebook = (Ebook) o;
                if (ebook.getLanguage().equals("English")) {
                    return true;
                }
                return false;
            }
        };
        Ebook ebook = new Ebook(2, "On java 8", "Bryus Ekkel", "English", 1778);
        argumentMatcher.matches(ebook);
    }


    @Test
    public void printListOffEbooks_Test() {
        Mockito.when(ebookRetory.createListOfEbooks()).thenCallRealMethod();
        List<Ebook> ebookList = ebookRetory.createListOfEbooks();
        ebookList.add(new Ebook(1, "Java quick start", "Chan J", "English", 272));
        ebookList.add(new Ebook(2, "On java 8", "Bryus Ekkel", "English", 1778));
        Mockito.when(ebookRetory.getAll()).thenReturn(ebookList);
        target.printListOffEbooks();

    }

    @Test
    public void ArgCupTest() {

        EbookService ebookService = Mockito.mock(EbookService.class);
        List<Ebook> ebookLis = ebookService.fillAndGetEbookList();
        ebookService.deleteSeveralByIds(1,2);
        ArgumentCaptor<Integer> captor = ArgumentCaptor.forClass(Integer.class);
        Mockito.verify(ebookService, Mockito.atLeastOnce()).deleteSeveralByIds(captor.capture());
        List<Integer> capturedList = captor.getAllValues();
        System.out.println(capturedList);


    }






}