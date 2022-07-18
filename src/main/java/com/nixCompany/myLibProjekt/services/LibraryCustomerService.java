package com.nixCompany.myLibProjekt.services;

import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.entities.Sex;
import com.nixCompany.myLibProjekt.repository.impl.LibraryCustomerRetory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Iterator;
import java.util.List;

public class LibraryCustomerService {

    private final LibraryCustomerRetory libraryCustomerRetory;
    private static final Logger LOGGER = LoggerFactory.getLogger(LibraryCustomer.class);

    public LibraryCustomerService(LibraryCustomerRetory libraryCustomerRetory) {
        this.libraryCustomerRetory = libraryCustomerRetory;
    }


    public List<LibraryCustomer> FillAndGetLibraryCustomerList() {
        List<LibraryCustomer> myLibCustomerList = libraryCustomerRetory.getLibraryCustomerList();
        myLibCustomerList.add(new LibraryCustomer(1, "Tom Kruz", 47, "tomandjeri@gmail.com", Sex.MALE, "Zimbabve"));
        myLibCustomerList.add(new LibraryCustomer(2, "Adriana Chechik", 35, "chotkachika@gmail.com", Sex.FEMALE, "Czech"));
        myLibCustomerList.add(new LibraryCustomer(3, "Biba Bobov", 34, "bibob@gmail.com", Sex.MALE, "England"));
        myLibCustomerList.add(new LibraryCustomer(4, "Abdurahman ibn Hatab", 34, "padloybudyabdyla@gmai.com", Sex.MALE, "Turkish"));
        myLibCustomerList.add(new LibraryCustomer(5, "Robin Betmanov", 35, "shifrezadov@gmail.com", Sex.MALE, "India"));
        LOGGER.info("List was filed");
        return myLibCustomerList;
    }

    public void deleteSeveralByIds(int... intIds) {

        List<LibraryCustomer> libraryCustomerList = libraryCustomerRetory.getLibraryCustomerList();
        Iterator<LibraryCustomer> iterator = libraryCustomerList.iterator();
        while (iterator.hasNext()) {
            final LibraryCustomer libraryCustomer = iterator.next();
            for (int i = 0; i < intIds.length; i++) {
                if (intIds[i] == libraryCustomer.getId()) {
                    iterator.remove();
                    LOGGER.info(libraryCustomer.getFullName()+" was deleted");
                }
            }
        }
    }

    public void printListOffLibraryCustomers() {
        for (LibraryCustomer libraryCustomer : libraryCustomerRetory.getLibraryCustomerList()) {
            System.out.println(libraryCustomer);
        }
    }

    public LibraryCustomer getLibraryCustomerByFullName(LibraryCustomerRetory libraryCustomerRetory, String name){
        for (LibraryCustomer libCust : libraryCustomerRetory.getLibraryCustomerList()) {
            if (name.equals(libCust.getFullName())){
                return libCust;
            }
        }
        System.out.println("There is no libraryCustomer with that name fuck off");
        return null;
    }
}
