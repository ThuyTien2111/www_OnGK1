package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.CandidateDao;
import vn.edu.iuh.fit.entity.Candidate;

import java.util.Map;

public class CandidateService {
    private CandidateDao candidateDao;

    public CandidateService() {
        candidateDao = new CandidateDao();
    }

    public boolean logInCandidate(long cand_id, String pass) {
        return candidateDao.logIn(cand_id, pass);
    }

    public Map<Integer, Long> getCandByYearBorn(){
        return candidateDao.getCandByYearBorn();
    }
    public Map<Candidate, Long> getTotalSkillByCand(){
        return candidateDao.getTotalSkillByCand();
    }
    public Map<Candidate, Long> getTotalJobSkillByCand(){
        return candidateDao.getTotalJobSkillByCand();
    }

}