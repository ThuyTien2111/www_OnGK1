package vn.edu.iuh.fit.dao;

import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import org.checkerframework.checker.units.qual.A;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.JobSkill;
import vn.edu.iuh.fit.entity.Skill;

import java.util.ArrayList;
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
    //Tính lương đề xuất
    public Integer calcProposedSalary(Long job_id){
        Integer rs= 0;
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            if(manager.find(Job.class, job_id)==null) rs=0;
            else{
            String sql="SELECT SUM(500*SkillLevel+300) AS Salary FROM job_skill\n" +
                    "WHERE JobID=?";
            Query query= manager.createNativeQuery(sql);
            query.setParameter(1, job_id);
            rs= Integer.parseInt(query.getSingleResult().toString());
            tr.commit();
            }
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return rs;
    }

}
