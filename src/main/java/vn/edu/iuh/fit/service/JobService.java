package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.JobDao;
import vn.edu.iuh.fit.entity.Job;

import java.util.List;

public class JobService {
    private JobDao jobDao;

    public JobService() {
        jobDao= new JobDao();
    }
    public List<Job> getAllJob(){
        return jobDao.getAll();
    }
}
