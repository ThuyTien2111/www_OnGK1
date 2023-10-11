package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Skill;

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

}
