package com.nixCompany.myLibProjekt.entities;

import com.nixCompany.myLibProjekt.repository.IEbookRetory;

public class Manual extends Ebook{
    private String directionOfKnowledge;

    public Manual(int id, String name, String author, String language, int numberOfPages, String directionOfKnowledge) {
        super(id, name, author, language, numberOfPages);
        this.directionOfKnowledge = directionOfKnowledge;
    }

    public String getDirectionOfKnowledge() {
        return directionOfKnowledge;
    }

    public void setDirectionOfKnowledge(String directionOfKnowledge) {
        this.directionOfKnowledge = directionOfKnowledge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Manual manual = (Manual) o;

        return getDirectionOfKnowledge().equals(manual.getDirectionOfKnowledge());
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + getDirectionOfKnowledge().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Manual{" +
                "directionOfKnowledge='" + directionOfKnowledge + '\'' +
                '}';
    }
}
