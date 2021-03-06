package com.nixCompany.myLibProjekt.repository.impl;

import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.entities.Sex;
import com.nixCompany.myLibProjekt.repository.ILibraryCustomerRetory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class LibraryCustomerRetory implements ILibraryCustomerRetory {

    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryCustomer.class);
    private static List<LibraryCustomer> libraryCustomerList;

    public LibraryCustomerRetory() {
        libraryCustomerList = InitLibCustList();

    }

    @Override
    public List<LibraryCustomer> InitLibCustList() {
        if (libraryCustomerList == null) {
            libraryCustomerList = new ArrayList<>(100);
        }
        return libraryCustomerList;
    }

    @Override
    public List<LibraryCustomer> getLibraryCustomerList() {
        return libraryCustomerList;
    }

    @Override
    public LibraryCustomer getById(int id) {
        for (LibraryCustomer lb : libraryCustomerList) {
            if (lb.getId() == id) {
                return lb;
            }
        }
        System.out.println("There are no Customer with such id");
        return null;
    }

    @Override
    public LibraryCustomer create(int id, String fullName, int age, String email, Sex sex, String country) {
        LibraryCustomer lbCust = new LibraryCustomer(id, fullName, age, email, sex, country);
        LOGGER.info("Customer was created");
        return lbCust;

    }

    @Override
    public LibraryCustomer update(LibraryCustomer libCustomer, int id, String fullName, int age, String email, Sex sex, String country) {
        libCustomer.setId(id);
        libCustomer.setFullName(fullName);
        libCustomer.setAge(age);
        libCustomer.setEmail(email);
        libCustomer.setSex(sex);
        libCustomer.setCountry(country);
        return libCustomer;
    }

    @Override
    public boolean delete(int id) {
        final Iterator<LibraryCustomer> iterator = libraryCustomerList.iterator();
        while (iterator.hasNext()) {
            final LibraryCustomer libraryCustomer = iterator.next();
            if (libraryCustomer.getId() == id) {
                iterator.remove();
                LOGGER.info("Customer was deleted");
                return true;
            }
        }
        LOGGER.info("Customer not found");
        return false;
    }


}
