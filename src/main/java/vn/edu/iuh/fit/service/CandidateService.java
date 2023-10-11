package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.CandidateDao;

public class CandidateService {
    private CandidateDao candidateDao;

    public CandidateService() {
        candidateDao = new CandidateDao();
    }

    public boolean logInCandidate(long cand_id, String pass) {
        return candidateDao.logIn(cand_id, pass);
    }

}