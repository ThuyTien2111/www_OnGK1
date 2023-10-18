package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.JobSkill;
import vn.edu.iuh.fit.entity.Skill;

import java.util.ArrayList;
import java.util.List;

public class JobDao {
    private EntityManager manager;

    public JobDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public List<Job> getAll(){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            return manager.createQuery("select j from Job j", Job.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }

}
