package com.nixCompany.myLibProjekt.services;
import com.nixCompany.myLibProjekt.entities.Ebook;
import com.nixCompany.myLibProjekt.repository.IEbookRetory;

import java.util.Iterator;
import java.util.List;
import java.util.Optional;


public abstract class AbstractEbookService{
      private IEbookRetory ebookRetory;

      public void deleteSeveralByIds(int... intIds) {
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
      public void hasEbookWithId(int id){
            Optional<? extends Ebook> isIn = ebookRetory.getById(id);
            System.out.println(isIn.get());
      }

      public abstract void printMyEbook(Ebook t);

      public void showType(Ebook t) {
            System.out.println( t.getClass().getName());
      }


}
