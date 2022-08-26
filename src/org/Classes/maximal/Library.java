package org.Classes.maximal;

import org.Classes.minimal.Author;
import org.Classes.minimal.Book;

public class Library {
    private Book[] books;

    public Library(Book[] books) {
        this.books = books;
    }

    public String printBookDescription(String name) {
        for (Book book : books) {
            if (book != null) {
                if (book.getName().equals(name)) {
                    return book.getName() + " by " + book.getAuthor().getFirstName() + " " +
                            book.getAuthor().getLastName() + " was published in " + book.getYear();
                }
            }
        }
        return "Книга с таким названием не найдена";
    }

    public boolean setYear(String name, int year) {
        System.out.println("name = " + name);
        System.out.println("year = " + year);
        for (Book book : this.books) {
            if (book != null) {
                System.out.println(book.getName());
                if (book.getName().equals(name)) {
                    book.setYear(year);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean addBook(Book book, Book[] books) {
        if (books[books.length - 1] != null) {
            System.out.println("В массиве нет места");
            return false;
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                books[i] = book;
                return true;
            }
        }
        return false;
    }

    public void printAuthors(Author[] authors) {
        int i = 1;
        for (Author author : authors) {
            System.out.println(i + ": " + author.getLastName());
            i++;
        }
    }

    public void printBooks(Book[] books) {

        for (int i = 0; i < books.length; i++) {
            if (books[i] != null) {
                System.out.println((i + 1) + ": " + books[i].toStringOneLine());
            }
        }
    }
}
