package org.Classes.minimal;

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
                "\n     Автор: " + getAuthor().toStringOneLine() +
                "\n     Год издания: " + getYear();
    }

    public String toStringOneLine() {
        return getAuthor().toStringOneLine() + ": " +
                getName() + ": " +  getYear();
    }
}
