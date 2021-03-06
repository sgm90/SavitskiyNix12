package com.nixCompany.myLibProjekt.services.impl;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.repository.impl.EbookRetory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;

import java.util.List;

class EbookRetoryTest {

    private EbookRetory target;
    private Ebook ebook;

    @BeforeEach
    void setUp() {
        target = new EbookRetory();
        ebook = new Ebook(1,"Java quick start","Chan J", "English", 272);
    }


    @Test
    void getById_findOne() {
        target.getAll().add(ebook);
        final Ebook actual = target.getById(1);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(ebook, actual);
    }
    @Test
    void getById_notFound() {
        target.getAll().add(ebook);
        final Ebook actual = target.getById(1231);
        Assertions.assertNull(actual);
    }

    @Test
    void create_One() {
        Assertions.assertEquals(ebook, new Ebook
                (1,"Java quick start","Chan J", "English", 272));
    }

    @Test
    void update_One() {
        target.update(ebook, 1,"new name","updatedAuthor", "English", 341);
        Assertions.assertEquals(new Ebook
                ( 1,"new name","updatedAuthor", "English", 341),ebook);
    }


    @Test
    void delete_One_byId() {
        List<Ebook> ebookList = target.getAll();
        target.delete(1);
        Assertions.assertTrue(null == target.getById(1));
    }
    @Test
    void deleteOneById_notFound() {
        List<Ebook> ebookList = target.getAll();
        target.delete(1);
        Assertions.assertFalse(target.delete(2342342));
    }
    @Test
    void getAll(){
        final List<Ebook> actual = target.getAll();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(0,actual.size());
    }

}