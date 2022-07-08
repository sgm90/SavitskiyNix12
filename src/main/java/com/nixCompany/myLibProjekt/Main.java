package com.nixCompany.myLibProjekt;

import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.entities.Sex;
import com.nixCompany.myLibProjekt.services.impl.ImplEbookService;
import com.nixCompany.myLibProjekt.services.impl.ImplLibraryCustomerService;
import com.nixCompany.myLibProjekt.entities.Ebook;


import java.time.LocalDate;
import java.util.List;


public class Main {



    public static void main(String[] args) {


        ImplEbookService myEbookService = new ImplEbookService();
        myEbookService.createListOfEbooks();

        List<Ebook> ebookList = myEbookService.getAll();
        ebookList.add(new Ebook(1,"Java quick start","Chan J", "English", 272, LocalDate.now()));
        ebookList.add(new Ebook(2,"On java 8","Bryus Ekkel","English", 1778,LocalDate.now()));
        ebookList.add(new Ebook(3,"Algorithms on java", "Robert Sedzhvik", "English",843,LocalDate.now()));
        ebookList.add(new Ebook(4,"Stylish java", "Marko Faela", "English", 352,LocalDate.now() ));
        ebookList.add(new Ebook(5,"Java Concurrency in practice", "Tem Payerls","English", 464, LocalDate.now()));
        ebookList.add(new Ebook(6,"Moder Java","Ken Kouzen", "English", 275, LocalDate.now()));
        ebookList.add(new Ebook(7,"Java library professional volume 1", "Horstmann Kay", "English", 866,LocalDate.now() ));


        ImplLibraryCustomerService myLibraryCustomerService = new ImplLibraryCustomerService();
        myLibraryCustomerService.createListOfCustomers();
        List<LibraryCustomer> myLibCustomerList = myLibraryCustomerService.createListOfCustomers();
        myLibCustomerList.add(new LibraryCustomer(1,"Tom Kruz", 47, "tomandjeri@gmail.com", Sex.MALE, "Zimbabve"));
        myLibCustomerList.add(new LibraryCustomer(2,"Adriana Chechik", 35, "chotkachika@gmail.com", Sex.FEMALE, "Czech"));
        myLibCustomerList.add(new LibraryCustomer(3,"Biba Bobov", 34, "bibob@gmail.com", Sex.MALE, "England"));
        myLibCustomerList.add(new LibraryCustomer(4,"Abdurahman ibn Hatab", 34,"padloybudyabdyla@gmai.com", Sex.MALE, "Turkish"));
        myLibCustomerList.add(new LibraryCustomer(5,"Robin Betmanov", 35, "shifrezadov@gmail.com", Sex.MALE, "India"));


        for (LibraryCustomer lc: myLibCustomerList) {
            System.out.println(lc);
        }

        myLibraryCustomerService.delete(1);
        myLibraryCustomerService.delete(4);

        for (LibraryCustomer lc: myLibCustomerList) {
            System.out.println(lc);
        }


    }
}
