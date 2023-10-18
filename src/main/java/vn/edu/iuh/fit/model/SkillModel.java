package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entity.Skill;
import vn.edu.iuh.fit.service.SkillService;

import java.io.IOException;

public class SkillModel {
    private final SkillService skillService=new SkillService();
    public void addSkill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id= Long.parseLong(request.getParameter("skillID"));
        String name=request.getParameter("skillName");
        String des=request.getParameter("skillDes");
        int type=Integer.parseInt(request.getParameter("skillType"));
        skillService.addSkill(new Skill(id, name, des, type));
        response.sendRedirect("skill.jsp");
    }
    public void deleteSkill(HttpServletRequest request, HttpServletResponse response) throws IOException {
        long id= Long.parseLong(request.getParameter("skillID"));
        skillService.deleteSkill(id);
        response.sendRedirect("skill.jsp");
    }
    public void getSkill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id= Long.parseLong(request.getParameter("skillID"));
        Skill skill= skillService.getSkillByID(id);
        request.setAttribute("skill", skill);
        request.getRequestDispatcher("update-skill.jsp").forward(request, response);
    }
    public void updateSkill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id= Long.parseLong(request.getParameter("skillID"));
        String name=request.getParameter("skillName");
        String des=request.getParameter("skillDes");
        int type=Integer.parseInt(request.getParameter("skillType"));
        skillService.updateSkill(new Skill(id, name, des, type));
        response.sendRedirect("skill.jsp");
    }
    public void activeSkill(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long id= Long.parseLong(request.getParameter("skillID"));
        skillService.activeSkill(id);
        response.sendRedirect("skill.jsp");
    }
}
