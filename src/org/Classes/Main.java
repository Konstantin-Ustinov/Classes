package org.Classes;

import org.Classes.maximal.Library;
import org.Classes.minimal.Author;
import org.Classes.minimal.Book;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Author safonov = new Author("Дмитрий", "Сафонов");
        Author horstmann = new Author("Cay", "Horstmann");
        Book bashnya = new Book("Башня", safonov, 2016);
        Book coreJava = new Book("Core Java", horstmann, 2020);

        System.out.println("Книги в наличии:");
        System.out.println(bashnya.toString());
        System.out.println(coreJava.toString());

        delimiter();
        System.out.println("Меняем год выпуска у книги: " + bashnya.getName());
        bashnya.setYear(2018);
        System.out.println(bashnya.toString());

        delimiter();
        System.out.println("Создаем массив с книгами");
        Book[] books = new Book[5];
        books[0] = bashnya;
        books[1] = coreJava;

        Library library = new Library(books);

        Author[] authors = new Author[2];
        authors[0] = safonov;
        authors[1] = horstmann;

        delimiter();
        System.out.println("Создаем новую книгу");
        System.out.println("Введите название книги:");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Введите год издания:");
        int year = enterYear(scanner);
        System.out.println("Введите номер автора книги из списка:");
        library.printAuthors(authors);
        int authorNum = enterNumByArray(authors, scanner);
        Book newBook = new Book(name, authors[authorNum - 1], year);

        delimiter();
        System.out.println("Добавляем книгу в массив");
        if (library.addBook(newBook, books)) {
            System.out.println("Книга успешна добавлена!");
        } else {
            System.out.println("Книга не добавлена!");
        }

        delimiter();
        System.out.println("Введите номер книги из списка для просмотра описания:");
        library.printBooks(books);
        System.out.println(library.printBookDescription(books[enterNumByArray(books, scanner) - 1].getName()));

        delimiter();
        System.out.println("У какой книги нужно поменять год выпуска? (введите номер)");
        library.printBooks(books);
        int bookNum = -1;
        while (bookNum == -1) {
            try {
                bookNum = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                scanner.next(); // Очищаем поток ввода что бы не было зацикливания
            }
        }
        System.out.println("Введите год издания:");
        year = enterYear(scanner);

        if (library.setYear(books[bookNum - 1].getName(), year)){
            System.out.println("Год успешно изменен!");
        } else {
            System.out.println("Год не изменен. Ошибка.");
        }

        delimiter();
        library.printBooks(books);
    }

    private static void delimiter() {
        System.out.println("-----------------------------");
    }

    private static int enterNumByArray(Object[] array, Scanner scanner) {
        int num = 0;
        while (num == 0) {
            try {
                num = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                scanner.next(); // Очищаем поток ввода что бы не было зацикливания
            }
            if (num < 1 && array.length <= num) {
                num = 0;
                System.out.println("Введите число от 1 до " + array.length);
            }
        }
        return num;
    }

    private static int enterYear(Scanner scanner) {
        int newYear = -1;
        while (newYear == -1) {
            try {
                newYear = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Введите число");
                scanner.next(); // Очищаем поток ввода что бы не было зацикливания
            }
        }
        return newYear;
    }
}
