package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.CandidateSkillDao;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.Skill;

import java.util.List;

public class CandidateSkillService {
    private CandidateSkillDao candidateSkillDao;

    public CandidateSkillService() {
        candidateSkillDao=new CandidateSkillDao();
    }
    public List<Job> getJobForCandidateOrderBySkill(long cand_id){
        return candidateSkillDao.getJobForCandidateOrderBySkil(cand_id);
    }
    public List<Skill> getSkillNotHaveToLearn(long cand_id){
        return candidateSkillDao.getSkillNotHaveToLearn(cand_id);
    }
    public List<Candidate> getCandidateOrderBySkill(long skill_id){
        return candidateSkillDao.getCandidateOrderBySkill(skill_id);
    }


}
