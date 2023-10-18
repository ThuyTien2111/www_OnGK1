package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.JobDao;
import vn.edu.iuh.fit.dao.SkillDao;
import vn.edu.iuh.fit.entity.Job;

import java.util.List;

public class JobTest {
    public static void main(String[] args) {
        JobDao jobDao=new JobDao();
        SkillDao skillDao= new SkillDao();
//        jobDao.getAll().forEach(j->System.out.println(j.toString()));
        List<Job> jobs= jobDao.getAll();
        for (Job j:jobs) {
            System.out.println(j.toString());
            System.out.println("Skills:");
            skillDao.getSkillsForJob(j.getJob_id()).forEach(s->System.out.println(s.toString()));
        }
        //Lỗi transaction active thì chuyển phương thức đó sang lớp dao khác
    }

}
