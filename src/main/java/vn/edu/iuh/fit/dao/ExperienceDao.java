package vn.edu.iuh.fit.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import vn.edu.iuh.fit.db.Connect;
import vn.edu.iuh.fit.entity.Candidate;

import java.util.ArrayList;
import java.util.List;

public class ExperienceDao {
    private EntityManager manager;

    public ExperienceDao() {
        manager= Connect.getInstance().getEntityManagerFactory().createEntityManager();
    }
    //Ds ứng viên có kinh nghiệm lâu năm nhất
    public List<Candidate> getMaxExpYearCandidate(){
        List<Candidate> list= new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql= "SELECT candidate.CandidateID, (YEAR(experience.ToDate) - YEAR(experience.FromDate)) AS ExpYear\n" +
                    "FROM candidate\n" +
                    "INNER JOIN experience ON experience.CandidateID = candidate.CandidateID\n" +
                    "WHERE (YEAR(experience.ToDate) - YEAR(experience.FromDate)) = (\n" +
                    "    SELECT MAX(YEAR(experience.ToDate) - YEAR(experience.FromDate))\n" +
                    "    FROM candidate\n" +
                    "    INNER JOIN experience ON experience.CandidateID = candidate.CandidateID\n" +
                    ")";
            List<Object[]> objects=manager.createNativeQuery(sql,"SkillByCand").getResultList();
            for (Object[] obj:objects) {
                list.add(manager.find(Candidate.class,(Long)obj[0]));
            }
            tr.commit();
        }catch (Exception e){
            e.printStackTrace();
            tr.rollback();
        }
        return list;
    }
    //Ds ứng viên chưa có kinh nghiệm
    public List<Candidate> getNotHaveExpCandidate(){
        List<Candidate> list= new ArrayList<>();
        EntityTransaction tr= manager.getTransaction();
        tr.begin();
        try {
            String sql="SELECT * FROM candidate\n" +
                    "WHERE candidate.CandidateID NOT IN(\n" +
                    "SELECT DISTINCT CandidateID FROM experience\n" +
                    ")";
            list=manager.createNativeQuery(sql, Candidate.class).getResultList();
            tr.commit();
        }catch (Exception e){
            tr.rollback();
        }

        return list;
    }

}
