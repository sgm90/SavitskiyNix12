package com.nixCompany.myLibProjekt.entities;

public class LibraryCustomer {
    private int id;
    private String fullName;
    private int age;
    private String email;
    private Sex sex;
    private String country;

    public LibraryCustomer(int id, String fullName, int age, String email, Sex sex, String country) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.email = email;
        this.sex = sex;
        this.country = country;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LibraryCustomer that = (LibraryCustomer) o;

        if (getId() != that.getId()) return false;
        if (getAge() != that.getAge()) return false;
        if (!getFullName().equals(that.getFullName())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        if (getSex() != that.getSex()) return false;
        return getCountry().equals(that.getCountry());
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getFullName().hashCode();
        result = 31 * result + getAge();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getSex().hashCode();
        result = 31 * result + getCountry().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "LibraryCustomer{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", sex=" + sex +
                ", country='" + country + '\'' +
                '}';
    }


}
