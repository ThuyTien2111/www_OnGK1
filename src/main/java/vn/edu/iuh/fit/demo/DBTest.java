package vn.edu.iuh.fit.demo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connect;

public class DBTest {
    public static void main(String[] args) {
        EntityManager entityManager = Connect.getInstance().
                getEntityManagerFactory().
                createEntityManager();
        EntityTransaction tr= entityManager.getTransaction();
        tr.begin();
        try {
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
    }
}
