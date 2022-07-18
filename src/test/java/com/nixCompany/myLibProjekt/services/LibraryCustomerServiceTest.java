package com.nixCompany.myLibProjekt.services;

import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.entities.Sex;
import com.nixCompany.myLibProjekt.repository.impl.LibraryCustomerRetory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class LibraryCustomerServiceTest {
    private LibraryCustomerService target;
    private LibraryCustomerRetory libraryCustomerRetory;

    @BeforeEach
    void setup(){
        libraryCustomerRetory = mock(LibraryCustomerRetory.class);
        target = new LibraryCustomerService(libraryCustomerRetory);
    }


    @Test
    void fillAndGetLibraryCustomerList_Test() {

        List<LibraryCustomer> myLibCustomerList = libraryCustomerRetory.getLibraryCustomerList();
        Mockito.verify(libraryCustomerRetory).getLibraryCustomerList();
        myLibCustomerList.add(new LibraryCustomer(1, "Tom Kruz", 47, "tomandjeri@gmail.com", Sex.MALE, "Zimbabve"));
        myLibCustomerList.add(new LibraryCustomer(2, "Adriana Chechik", 35, "chotkachika@gmail.com", Sex.FEMALE, "Czech"));
        myLibCustomerList.add(new LibraryCustomer(3, "Biba Bobov", 34, "bibob@gmail.com", Sex.MALE, "England"));
        myLibCustomerList.add(new LibraryCustomer(4, "Abdurahman ibn Hatab", 34, "padloybudyabdyla@gmai.com", Sex.MALE, "Turkish"));
        myLibCustomerList.add(new LibraryCustomer(5, "Robin Betmanov", 35, "shifrezadov@gmail.com", Sex.MALE, "India"));
        Assertions.assertTrue(myLibCustomerList.size() == 5);
    }

    @Test
    void deleteSeveralByIds_Test() {
        LibraryCustomerRetory libraryCustomerRetory = new LibraryCustomerRetory();
        LibraryCustomerService libraryCustomerService = new LibraryCustomerService(libraryCustomerRetory);
        List<LibraryCustomer> myLibCustomerList = libraryCustomerRetory.getLibraryCustomerList();
        libraryCustomerService.FillAndGetLibraryCustomerList();
        libraryCustomerService.deleteSeveralByIds(1,4);
        Mockito.times(2);
        Assertions.assertTrue(myLibCustomerList.size() == 3);

    }
}