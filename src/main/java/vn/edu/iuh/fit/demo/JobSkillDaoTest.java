package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.JobSkillDao;
import vn.edu.iuh.fit.entity.Company;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.JobSkill;
import vn.edu.iuh.fit.entity.Skill;

import java.util.ArrayList;
import java.util.List;

public class JobSkillDaoTest {
    public static void main(String[] args) {
        JobSkillDao jobSkillDao= new JobSkillDao();
        List<JobSkill> jobSkills= new ArrayList<>();
        jobSkills.add(new JobSkill(new Skill(6),"Quality assurance expertise is essential for this role",4 ));
        jobSkills.add(new JobSkill(new Skill(7),"Financial analysis skills and reporting are a requirement",3 ));

//        System.out.println(jobSkillDao.addJobSkill(new Job(30, "Quality Assurance Engineer", "Ensure the quality of software products.", new Company(3)),jobSkills ));
        System.out.println(jobSkillDao.calcProposedSalary(30L));
    }
}
