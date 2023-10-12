package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ExperienceDao;

public class Experience {
    public static void main(String[] args) {
        ExperienceDao experienceDao= new ExperienceDao();
        experienceDao.getMaxExpYearCandidate().forEach(c->System.out.println(c.toString()));
    }
}
