package com.nixCompany.myLibProjekt.services.impl;

import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.entities.Sex;
import com.nixCompany.myLibProjekt.repository.impl.LibraryCustomerRetory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class LibraryCustomerRetoryTest {
    private LibraryCustomerRetory target;
    private LibraryCustomer libraryCustomer;

    @BeforeEach
    void setUp() {
        target = new LibraryCustomerRetory();
        libraryCustomer = new LibraryCustomer
                (1,"Tom Kruz", 47, "tomandjeri@gmail.com", Sex.MALE, "Zimbabve");
    }

    @Test
    void create_One() {
        Assertions.assertEquals(libraryCustomer, new LibraryCustomer
                (1,"Tom Kruz", 47, "tomandjeri@gmail.com", Sex.MALE, "Zimbabve"));
    }

    @Test
    void update_One() {
        target.update(libraryCustomer, 15,"Tarja Turunen", 50, "fajnatarja@gmil.com",Sex.FEMALE,"Finland");
        Assertions.assertEquals(new LibraryCustomer(15,"Tarja Turunen", 50, "fajnatarja@gmil.com",Sex.FEMALE,"Finland"),libraryCustomer);
    }

    @Test
    void getAll() {
        final List<LibraryCustomer> actual = target.getLibraryCustomerList();
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(0, actual.size());
    }

}