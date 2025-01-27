package org.example.Storage;

import org.example.Entities.Book;
import org.example.Entities.Catalog;
import org.example.Entities.Prestito;
import org.example.Entities.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

public class Storage {
    private EntityManager entityManager;

    public Storage(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void saveElement(Book book1) {

    }
    public void saveUser(User user1) {

    }

    public Catalog getElemById(long id) {
        return entityManager.find(Catalog.class, id);
    }

    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    public Prestito getPrestitoById(long id) {
        return entityManager.find(Prestito.class, id);

    }

    public void delete(Catalog e) {
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
    }

    public void saveElement(Catalog e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public void saveUtente (User e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public void savePrestito(Prestito e) {
        entityManager.getTransaction().begin();
        entityManager.persist(e);
        entityManager.getTransaction().commit();
    }

    public void deleteElemByIsbn(String isbn) {
        Query query = entityManager.createQuery("SELECT e FROM Catalog e HERE e.ison = :isbn");
        query.setParameter("isbn", isbn);
        Catalog e = (Catalog) query.getSingleResult();
        entityManager.getTransaction().begin();
        entityManager.remove(e);
        entityManager.getTransaction().commit();
        System.out.println("Book with isbn: " + isbn + "deleted!");
    }
    public Catalog findByIsbn(String isbn) {
        Query query = entityManager.createQuery("SELECT e FROM Catalog e WHERE e.ison isbn");
        query.setParameter("isbn", isbn);
        System.out.println("Book with isbn: " + isbn + "found");
        return (Catalog) query.getSingleResult();
    }
    public List<Catalog> findByYear(int year) {
        Query query = entityManager.createQuery("SELECT e FROM Catalog e MHERE e.pubblicationYear year");
        query.setParameter("anno", year);
        System.out.println("Books with pubblication year " + year + ":");
        return query.getResultList();
    }
    public List<Catalog> findByAuthor(String authoreName) {
        Query query = entityManager.createQuery("SELECT e FROM Catalog e WHERE e.author = :authorName AND TYPE(e) = Book");
        System.out.println("Books written by: " + authoreName + "found!");
        return query.getResultList();
    }
    public List<Catalog> findByTitle(String title) {
        Query query = entityManager.createQuery("SELECT e FROM Catalog e WHERE e.title LIKE : title");
        query.setParameter("title", "%" + title + "%");
        System.out.println("Books that contains the word:" + title + "in the title");
        return query.getResultList();
    }

    public List<Catalog> findElwithNumber(long number) {
        Query query = entityManager.createQuery("SELECT e FROM Prestito p JOIN p.Prestiti e WHERE p.user.number = :number AND p.dataRestituzioneEffettiva IS NULL");
        query.setParameter("number", number);
        System.out.println("Books that are with: " + number);
        return query.getResultList();
     }


    public List<Prestito> findPrestitoNotReturned() {
        LocalDate today = LocalDate.now();
        Query query =entityManager.createQuery("SELECT p FROM Prestito p WHERE p.dataRestituzioneEffettiva IS NULL AND p.dataRestituzionePrevista <:today");
        query.setParameter("today", today);
        System.out.println("Prestito not returned: " );
        return query.getResultList();
    }
}
