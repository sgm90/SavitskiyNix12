package com.nixCompany.myLibProjekt.repository;

import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.entities.Sex;

import java.util.List;

public interface ILibraryCustomerRetory {

    List<LibraryCustomer> InitLibCustList();
    List<LibraryCustomer> getLibraryCustomerList();
    LibraryCustomer getById(int id);
    LibraryCustomer create(int id, String fullName, int age, String email, Sex sex, String country);

    LibraryCustomer update(LibraryCustomer libCustomer, int id, String fullName, int age, String email, Sex sex, String country);

    boolean delete(int id);

}


