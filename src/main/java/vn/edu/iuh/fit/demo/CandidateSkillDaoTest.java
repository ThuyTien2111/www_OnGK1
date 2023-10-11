package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.CandidateSkillDao;

public class CandidateSkillDaoTest {
    public static void main(String[] args) {
        CandidateSkillDao candidateSkillDao= new CandidateSkillDao();
//        candidateSkillDao.getJobForCandidateOrderBySkil(2).
//                forEach(j->System.out.println(j.toString()));
        candidateSkillDao.getSkillNotHaveToLearn(200).
                forEach(j->System.out.println(j.toString()));
//        candidateSkillDao.getCandidateOrderBySkill(2).
//                forEach(j->System.out.println(j.toString()));
    }
}
