package com.nixCompany.myLibProjekt.entities;

import java.time.LocalDate;

public class Ebook {
    private int id;
    private String name;
    private String author;
    private String language;
    private int numberOfPages;
    LocalDate dateOfRelease;

    public Ebook(int id, String name, String author, String language, int numberOfPages, LocalDate dateOfRelease) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.language = language;
        this.numberOfPages = numberOfPages;
        this.dateOfRelease = dateOfRelease;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public LocalDate getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(LocalDate dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ebook ebook = (Ebook) o;

        if (getId() != ebook.getId()) return false;
        if (getNumberOfPages() != ebook.getNumberOfPages()) return false;
        if (!getName().equals(ebook.getName())) return false;
        if (!getAuthor().equals(ebook.getAuthor())) return false;
        if (!getLanguage().equals(ebook.getLanguage())) return false;
        return getDateOfRelease().equals(ebook.getDateOfRelease());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getAuthor().hashCode();
        result = 31 * result + getLanguage().hashCode();
        result = 31 * result + getNumberOfPages();
        result = 31 * result + getDateOfRelease().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Ebook{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", language='" + language + '\'' +
                ", numberOfPages=" + numberOfPages +
                ", dateOfRelease=" + dateOfRelease +
                '}';
    }
}
