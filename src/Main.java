import enums.Gender;
import enums.Genre;
import enums.Language;
import model.Book;
import model.User;
import service.BookService;
import service.serviceImpl.BookServiceImpl;
import service.serviceImpl.UserServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Бардык Id лер уникальный болуш керек. Эгер уникальный болбосо озубуз тузгон UniqueConstraintException класс ыргытсын.
        // User дин email адресси уникальный болуш керек жана @ болуусу керек. Эгер уникальный болбосо UniqueConstraintException класс,
        // @ болбосо озубуз тузгон BadRequestException класс ыргытсын.
        // User дин телефон номери +996 дан башталып 13 символдон турсун. Болбосо BadRequestException класс ыргытсын.
        // Китептин баасы терс сан болбошу керек. Болбосо NegativeNumberException ыргытсын.
        // Китептин чыккан жылы келечек убакыт болбошу керек.Болбосо DateTimeException ыргытсын.
        // Китептин автору бош болбошу керек. Болбосо EmptyStackException ыргытсын.

        List<Book> books = new ArrayList<>(List.of(
                new Book((long) 2,"Summer", Genre.DETECTIVE, BigDecimal.valueOf(12),"Chyngyz Aitmatov ", Language.KYRGYZ, LocalDate.of(2000,3,22)),
                new Book((long) 3,"Samurai", Genre.FANTASY, BigDecimal.valueOf(12),"Alykul Osmonov", Language.KYRGYZ, LocalDate.of(2000,3,22)),
                new Book((long) 4,"Adam bol!", Genre.DETECTIVE, BigDecimal.valueOf(12),"Kuban Kelsinbekov", Language.ENGLISH, LocalDate.of(2000,3,22)),
                new Book((long) 5,"Summer", Genre.ROMANCE, BigDecimal.valueOf(12),"Muhammed Kurbanov ", Language.RUSSIAN, LocalDate.of(2000,3,22)),
                new Book((long) 6,"Summer", Genre.HISTORICAL, BigDecimal.valueOf(12),"Oroz Jigitali uulu ", Language.ENGLISH, LocalDate.of(2000,3,22))
        ));

        List<User> users  = new ArrayList<>(List.of(
                new User((long) 7,"Omur","Ahmatov","omur.@gmail.com","+99648373483", Gender.MALE,BigDecimal.valueOf(100), books ),
                new User((long) 7,"Mirlan","Jenishov","mir.@gmail.com","+99694543483", Gender.MALE,BigDecimal.valueOf(100), books ),
                new User((long) 7,"Nur","Akimov","nur.@gmail.com","+996435683", Gender.MALE,BigDecimal.valueOf(100), books )
        ));
        UserServiceImpl userService = new UserServiceImpl();
        System.out.println("1 method");
        System.out.println(userService.createUser(users));
        System.out.println("2 method");
        System.out.println(userService.findAllUsers());
        System.out.println("3 method");
        long id = new Scanner(System.in).nextLong();
        System.out.println(userService.findUserById(id));
        System.out.println("4 method");
        String name = new Scanner(System.in).nextLine();
        System.out.println(userService.removeUserByName(name));
        System.out.println("5 method");
        long id2 = new Scanner(System.in).nextLong();
        userService.updateUser(id2);
        System.out.println("6 method");
        userService.groupUsersByGender();
        System.out.println("6 method");
        String  name1 = new Scanner(System.in).nextLine();
        System.out.println(userService.buyBooks(name1, books));
        BookServiceImpl bookService = new BookServiceImpl();


        System.out.println(" 1 method");
        System.out.println(bookService.createBooks(books));
        System.out.println("2 Method");
        System.out.println(bookService.getAllBooks());
        System.out.println("3 method");
        String genre = new Scanner(System.in).nextLine();
        System.out.println(bookService.getBooksByGenre(genre));
        System.out.println("4 method");
        long id1 = new Scanner(System.in).nextLong();
        System.out.println(bookService.removeBookById(id1));
        System.out.println("5 method");



    }
}