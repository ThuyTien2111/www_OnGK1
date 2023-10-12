package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.JobSkillDao;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.JobSkill;

import java.util.List;

public class JobSkillService {
    private JobSkillDao jobSkillDao;

    public JobSkillService() {
        jobSkillDao= new JobSkillDao();
    }
    public boolean addJobSkill(Job job, List<JobSkill> jobSkills) {
        for (JobSkill js:jobSkills) {
            if((js.getSkill_level()!=0)&&(js.getSkill_level()!=1)&&(js.getSkill_level()!=2))
                return false;
        }
        return addJobSkill(job, jobSkills);
    }
    public Integer calcProposedSalary(Long job_id){
        return jobSkillDao.calcProposedSalary(job_id);
    }

    }
