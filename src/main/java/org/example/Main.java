package org.example;

import com.github.javafaker.Cat;
import org.example.Entities.*;
import org.example.Enumeration.Periodicity;
import org.example.Storage.Storage;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static EntityManagerFactory enMF = Persistence.createEntityManagerFactory("catalog");
    private static EntityManagerFactory entityManager = entityManager.createEntityManager();
    public static void main( String[] args ) {
        Storage storage = new Storage(entityManager);

        Catalog book1 = new Book("123456789", "Harry Potter", 1946, 1500, "Morante", "ygbh");
        Catalog book2 = new Book("987456321", "Harry Potter", 1946, 1500, "Moravia", "ygbh");
        Catalog book3 = new Book("987456133", "Harry Potter", 1946, 1500, "Pasolini", "ygbh");
        Catalog book4 = new Book("8765453155", "Harry Potter", 1946, 1500, "Tolstoj", "ygbh");
        Catalog book5 = new Book("1239554789", "Harry Potter", 1946, 1500, "Dostoievski", "ygbh");
        Catalog magazine1 = new Magazines("789456123963", "Architectural digest", 2012, 36, Periodicity.MONTHLY);
        Catalog magazine2 = new Magazines("789456123963", "Architectural digest", 2012, 36, Periodicity.MONTHLY);
        Catalog magazine3 = new Magazines("789456123963", "Architectural digest", 2012, 36, Periodicity.MONTHLY);
        Catalog magazine4 = new Magazines("789456123963", "Architectural digest", 2012, 36, Periodicity.MONTHLY);
        Catalog magazine5 = new Magazines("789456123963", "Architectural digest", 2012, 36, Periodicity.MONTHLY);

        Storage.saveElement(book1);
        Storage.saveElement(book2);
        Storage.saveElement(book3);
        Storage.saveElement(book4);
        Storage.saveElement(book5);
        Storage.saveElement(magazine1);
        Storage.saveElement(magazine2);
        Storage.saveElement(magazine3);
        Storage.saveElement(magazine4);
        Storage.saveElement(magazine5);

        User user1 = new User("Maria", "Rossi", LocalDate.of(1999, 6, 12), 1245678);
        User user2 = new User("Maria", "Rossi", LocalDate.of(1999, 6, 12), 1245678);
        User user3 = new User("Maria", "Rossi", LocalDate.of(1999, 6, 12), 1245678);
        User user4 = new User("Maria", "Rossi", LocalDate.of(1999, 6, 12), 1245678);

        Storage.saveUser(user1);
        Storage.saveUser(user2);
        Storage.saveUser(user3);
        Storage.saveUser(user4);

        List<Catalog> prestitiUser1 = new ArrayList<>();
        List<Catalog> prestitiUser2 = new ArrayList<>();
        List<Catalog> prestitiUser3 = new ArrayList<>();
        List<Catalog> prestitiUser4 = new ArrayList<>();
        prestitiUser1.add(Storage.getElemById(1));
        prestitiUser1.add(Storage.getElemById(2));
        prestitiUser2.add(Storage.getElemById(3));
        prestitiUser2.add(Storage.getElemById(4));
        prestitiUser3.add(Storage.getElemById(5));
        prestitiUser3.add(Storage.getElemById(6));
        prestitiUser4.add(Storage.getElemById(7));
        prestitiUser4.add(Storage.getElemById(8));

        Prestito prestito1 = new Prestito(Storage.getUserById(1), prestitiUser1, LocalDate.of(2025, 1, 2));
        Prestito prestito2 = new Prestito(Storage.getUserById(2), prestitiUser2, LocalDate.of(2025, 1, 2));
        Prestito prestito3 = new Prestito (Storage.getUserById(3), prestitiUser3, LocalDate.of(2025, 1, 2));
        Prestito prestito4 = new Prestito(Storage.getUserById(3), prestitiUser4, LocalDate.of(2023, 12, 8));
        Storage.savePrestito (prestito1);
        Storage.savePrestito (prestito2);
        Storage.savePrestito (prestito3);
        Storage.savePrestito (prestito4);
/*

        Storage.deleteElemByIsbn("123456789");

        Catalog search =  Storage.findByIsbn("123456789");
        System.out.println(search);

        List<Catalog> year= Storage.findByYear(1946);
        year.forEach(System.out::printin);

        List<Catalog> author = Storage.findByAuthor("Morante");
        author.forEach(System.out::printin);

        List<Catalog> title = Storage.findByTitle("Harry Potter");
        title.forEach(System.out::printin);

        List<Catalog> number = Storage.findElwithNumber (1245678);
        number.forEach(System.out::printin);

        List<Prestito> prestitiNotReturned =  Storage.findPrestitoNotReturned();
        prestitiNotReturned.forEach(System.out::printin);
*/
        entityManager.close();
        enMF.close();
    }
}
