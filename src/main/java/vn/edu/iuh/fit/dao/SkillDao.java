package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillDao {
    private EntityManager manager;

    public SkillDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public boolean add(Skill skill){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            manager.persist(skill);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean update(Skill skill){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            manager.merge(skill);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean delete(long id){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            Skill skill=manager.find(Skill.class, id);
            skill.setSkill_type(0);
            manager.merge(skill);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public boolean active(long id){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            Skill skill=manager.find(Skill.class, id);
            skill.setSkill_type(1);
            manager.merge(skill);
            tr.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return false;
    }
    public Skill get(long id){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            return manager.find(Skill.class,id);
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public List<Skill> getAll(){
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            return manager.createQuery("select s from Skill s", Skill.class).getResultList();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return null;
    }
    public List<Skill> getSkillsForJob(long jobID){
        List<Skill> list= new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT skill.SkillID, skill.Description, skill.SkillName, skill.Type FROM job \n" +
                    "INNER JOIN job_skill ON job.JobID=job_skill.JobID\n" +
                    "INNER JOIN skill ON skill.SkillID=job_skill.SkillID\n" +
                    "WHERE job.JobID=?";
            Query query= manager.createNativeQuery(sql, Skill.class);
            query.setParameter(1, jobID);
            list=query.getResultList();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }

}
