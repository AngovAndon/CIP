package com.example.demo1.command;

import com.example.demo1.service.LibraryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class LibraryCommand implements CommandLineRunner {
    private LibraryService libraryService;
    private Scanner scanner = new Scanner(System.in);

    public LibraryCommand(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Override
    public void run(String... args) throws Exception {
        while (true) {
            System.out.println("Library Menu: ");
            System.out.println("Choose an option: ");
            System.out.println("1. Get Available Books");
            System.out.println("2. Add new Book");
            System.out.println("3. Reserve Book");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    libraryService.getAvailableBooks().forEach(book -> System.out.println("Book " + book.getTitle() + " by " + book.getAuthor() ));
                    break;
                case 2:
                    System.out.println("Enter book title: ");
                    String title = scanner.nextLine();
                    System.out.println("Enter book author: ");
                    String author = scanner.nextLine();
                    libraryService.addBook(title, author);
                    break;
                case 3:
                    System.out.println("Enter book title: ");
                    String titleBook = scanner.nextLine();
                    if (libraryService.reserveBook(titleBook)){
                        System.out.println("Book Reserved");
                    }else{
                        System.out.println("Book doesn't exist or is already reserved");
                    }
                    break;
                case 4:
                    System.out.println("Exiting!");
                    return;
                default:
                    System.out.println("No such operation!");
            }

        }
    }
}
