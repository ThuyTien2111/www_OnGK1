package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entity.Company;
import vn.edu.iuh.fit.entity.Job;
import vn.edu.iuh.fit.entity.JobSkill;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.service.JobService;
import vn.edu.iuh.fit.service.JobSkillService;
import vn.edu.iuh.fit.service.SkillService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobModel {
    private final JobSkillService jobSkillService=new JobSkillService();
    public void getCompany(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id= Long.parseLong(request.getParameter("compID"));
        request.setAttribute("compID", id);
        request.getRequestDispatcher("add-job.jsp").forward(request,response);
    }
    public void addJob(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long compID= Long.parseLong(request.getParameter("compID"));
        long jobID= Long.parseLong(request.getParameter("jobID"));
        String jobName=request.getParameter("jobName");
        String jobDes=request.getParameter("jobDes");
        int level=Integer.parseInt(request.getParameter("skillLevel"));
        String more=request.getParameter("moreInfo");

        //Xử lý mảng skill
        List<String> selectedSkills = List.of(request.getParameterValues("skills"));
        List<JobSkill> jobSkills=new ArrayList<>();
        for (String s:selectedSkills) {
            long skillID=Long.parseLong(s);
            jobSkills.add(new JobSkill(new Skill(skillID), more, level));
        }
        jobSkillService.addJobSkill(new Job(jobID, jobName, jobDes, new Company(compID)), jobSkills);
        response.sendRedirect("companyControl?action=getCompany&compID="+compID);
    }

}
