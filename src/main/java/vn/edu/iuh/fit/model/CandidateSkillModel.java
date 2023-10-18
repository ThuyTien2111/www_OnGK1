package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.service.CandidateSkillService;

import java.io.IOException;
import java.util.List;

public class CandidateSkillModel {
    private final CandidateSkillService candidateSkillService=new CandidateSkillService();
    public void getCandidateOrderBySkill(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long skillID= Long.parseLong(request.getParameter("skillID"));
        List<Candidate> candidates=candidateSkillService.getCandidateOrderBySkill(skillID);
        request.setAttribute("cadidates", candidates);
        request.getRequestDispatcher("candidate-for-skill.jsp").forward(request, response);

    }
    public void getSkillNotHaveToLearn(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        long id= Long.parseLong(request.getParameter("candID"));
        List<Skill> skills=candidateSkillService.getSkillNotHaveToLearn(id);
        request.setAttribute("skills",skills);
        request.getRequestDispatcher("skill-to-learn.jsp").forward(request, response);
    }


}
