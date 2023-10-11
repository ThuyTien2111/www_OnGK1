package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Candidate;

public class CandidateDao {
    private EntityManager manager;

    public CandidateDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean logIn(long cand_id, String pass){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            Candidate candidate=manager.find(Candidate.class, cand_id);
            //lấy phone làm pass
            if(candidate.getPhone().equalsIgnoreCase(pass))
                return true;
            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }
        return false;
    }

}
