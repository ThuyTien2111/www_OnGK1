package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Candidate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    //Thong ke so ứng viên theo năm sinh
    public Map<Integer, Long> getCandByYearBorn(){
        Map<Integer, Long> map= new HashMap<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql= "SELECT YEAR(Dob) AS YearBorn, COUNT(*) AS Total\n" +
                    "FROM candidate\n" +
                    "GROUP BY YEAR(Dob)";
            List<Object[]> objects= manager.createNativeQuery(sql, "CandByYearBorn").getResultList();
            for (Object[] obj:objects) {
                map.put((Integer) obj[0],(Long) obj[1]);
            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return map;
    }
    //Thong ke so luong skill của ứng viên
    public Map<Candidate, Long> getTotalSkillByCand(){
        Map<Candidate, Long> map= new HashMap<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT CandidateID, COUNT(*) AS TotalSkill\n" +
                    "FROM candidate_skill\n" +
                    "GROUP BY CandidateID";
            List<Object[]> objects= manager.createNativeQuery(sql, "SkillByCand").getResultList();
            for (Object[] obj:objects) {
                map.put(manager.find(Candidate.class,(Long) obj[0]), (Long) obj[1]);
            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return map;
    }
    //Thong ke so luong job phù hợp với skill của từng ứng viên
    public Map<Candidate, Long> getTotalJobSkillByCand(){
        Map<Candidate, Long> map= new HashMap<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql= "SELECT CandidateID, COUNT(*) AS TotalJob \n" +
                    "FROM candidate_skill\n" +
                    "INNER JOIN skill ON skill.SkillID=candidate_skill.SkillID\n" +
                    "INNER JOIN job_skill ON job_skill.SkillID=skill.SkillID\n" +
                    "GROUP BY CandidateID";
            List<Object[]> objects= manager.createNativeQuery(sql,"obSkillByCand").getResultList();
            for (Object[] obj:objects) {
                map.put(manager.find(Candidate.class, obj[0]), (Long) obj[1]);

            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return map;
    }



}
