package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Company;

public class CompanyDao {
    private EntityManager manager;

    public CompanyDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean logIn(long comp_id, String pass){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            Company company=manager.find(Company.class, comp_id);
            //lấy phone làm pass
            if(company.getPhone().equalsIgnoreCase(pass))
                return true;
            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }
        return false;
    }
}
