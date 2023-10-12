package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.ExperienceDao;
import vn.edu.iuh.fit.entity.Candidate;

import java.util.List;

public class ExperienceService {
    private ExperienceDao experienceDao;

    public ExperienceService() {
        experienceDao=new ExperienceDao();
    }
    public List<Candidate> getMaxExpYearCandidate(){
        return experienceDao.getMaxExpYearCandidate();
    }
    public List<Candidate> getNotHaveExpCandidate(){
        return experienceDao.getNotHaveExpCandidate();
    }
}
