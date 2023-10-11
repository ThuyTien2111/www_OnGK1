package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.Skill;

import java.util.ArrayList;
import java.util.List;

public class CandidateSkillDao {
    private EntityManager manager;

    public CandidateSkillDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    public List<Job> getJobForCandidateOrderBySkil(long cand_id){
        List<Job> list= new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String relativeQuery="SELECT DISTINCT job.JobID, job.Description, job.JobName, job.CompanyID \n" +
                    "FROM job\n" +
                    "INNER JOIN job_skill ON job.JobID=job_skill.JobID\n" +
                    "WHERE job_skill.SkillID IN (\n" +
                    "SELECT SkillID FROM candidate_skill\n" +
                    "WHERE CandidateID=? \n" +
                    ")";
            Query query=manager.createNativeQuery(relativeQuery, Job.class);
            query.setParameter(1, cand_id);
            list=query.getResultList();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
    public List<Skill> getSkillNotHaveToLearn(long cand_id){
        List<Skill> list= new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            if(manager.find(Candidate.class,cand_id)==null) return list;
            String sql="SELECT *\n" +
                    "FROM skill\n" +
                    "WHERE skill.SkillID NOT IN (\n" +
                    "SELECT SkillID FROM candidate_skill\n" +
                    "WHERE CandidateID=?\n" +
                    ")";
            Query query=manager.createNativeQuery(sql, Skill.class);
            query.setParameter(1, cand_id);
            list=query.getResultList();
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
    public List<Candidate> getCandidateOrderBySkill(long skill_id){
        List<Candidate> list= new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT candidate.CandidateID, candidate.DOB, candidate.Email, candidate.FullName, candidate.Phone, candidate.AddressID\n" +
                    "FROM candidate\n" +
                    "INNER JOIN candidate_skill ON candidate_skill.CandidateID= candidate.CandidateID\n" +
                    "WHERE candidate_skill.SkillID=?";
            Query query=manager.createNativeQuery(sql, Candidate.class);
            query.setParameter(1, skill_id);
            list=query.getResultList();
            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }
        return list;
    }
}
