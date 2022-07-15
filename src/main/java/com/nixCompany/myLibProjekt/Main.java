package com.nixCompany.myLibProjekt;

import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.entities.LibraryCustomer;
import com.nixCompany.myLibProjekt.repository.impl.EbookRetory;
import com.nixCompany.myLibProjekt.repository.impl.LibraryCustomerRetory;
import com.nixCompany.myLibProjekt.services.EbookService;
import com.nixCompany.myLibProjekt.services.LibraryCustomerService;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        LibraryCustomerRetory libraryCustomerRetory = new LibraryCustomerRetory();
        LibraryCustomerService myLibCustServ = new LibraryCustomerService(libraryCustomerRetory);
        libraryCustomerRetory.InitLibCustList();
        List<LibraryCustomer> myLibCustList = myLibCustServ.FillAndGetLibraryCustomerList();
        myLibCustServ.printListOffLibraryCustomers();
        myLibCustServ.deleteSeveralByIds(1, 4 );
        myLibCustServ.printListOffLibraryCustomers();

        EbookRetory ebookRetory = new EbookRetory();
        EbookService ebookService = new EbookService(ebookRetory);
        ebookRetory.createListOfEbooks();
        List<Ebook> myEbookList = ebookService.fillAndGetEbookList();
        ebookService.printListOffEbooks();
        ebookService.deleteSeveralByIds(2, 5);
        ebookService.printListOffEbooks();






    }
}
