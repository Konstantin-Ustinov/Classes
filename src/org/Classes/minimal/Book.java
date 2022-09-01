package org.Classes.minimal;

import java.util.Objects;

public class Book {
    private String name;
    private Author author;
    private int year;

    public Book(String name, Author author, int year) {
        this.name = name;
        this.author = author;
        this.year = year;
    }

    public String getName() {
        return this.name;
    }

    public Author getAuthor() {
        return this.author;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int newYear) {
        this.year = newYear;
    }

    @Override
    public String toString() {
        return "    Название книги: " + getName() +
                "\n     Автор: " + getAuthor().toString() +
                "\n     Год издания: " + getYear();
    }

    public String toStringOneLine() {
        return getAuthor().toString() + ": " +
                getName() + ": " +  getYear();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return year == book.year && name.equals(book.name) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, year);
    }
}
