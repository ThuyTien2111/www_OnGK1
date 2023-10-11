package vn.edu.iuh.fit.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.JobSkill;
import vn.edu.iuh.fit.entity.Skill;

import java.util.List;

public class JobSkillDao {
    private EntityManager manager;

    public JobSkillDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean addJobSkill(Job job, List<JobSkill> jobSkills) {
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            manager.persist(job);
            for (JobSkill js:jobSkills) {
                js.setJob(job); //set id của jobskill=job
                manager.persist(js);
            }
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }

        return false;
    }
}
