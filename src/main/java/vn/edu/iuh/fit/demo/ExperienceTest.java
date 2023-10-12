package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.ExperienceDao;

public class ExperienceTest {
    public static void main(String[] args) {
        ExperienceDao experienceDao= new ExperienceDao();
//        experienceDao.getMaxExpYearCandidate().forEach(c->System.out.println(c.toString()));
        experienceDao.getNotHaveExpCandidate().forEach(c->System.out.println(c.toString()));

    }
}
