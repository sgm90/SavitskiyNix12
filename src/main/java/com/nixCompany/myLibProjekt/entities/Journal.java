package com.nixCompany.myLibProjekt.entities;

public class Journal extends Ebook{

    private String periodicity;

    public Journal(int id, String name, String author, String language, int numberOfPages, String periodicity) {
        super(id, name, author, language, numberOfPages);
        this.periodicity = periodicity;
    }

    public String getPeriodicity() {
        return periodicity;
    }

    public void setPeriodicity(String periodicity) {
        this.periodicity = periodicity;
    }

    @Override
    public String toString() {
        return super.toString() +"Journal{" +
                "periodicity='" + periodicity + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Journal journal = (Journal) o;

        return getPeriodicity().equals(journal.getPeriodicity());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getPeriodicity().hashCode();
        return result;
    }
}
