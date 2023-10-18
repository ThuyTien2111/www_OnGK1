package vn.edu.iuh.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.model.SkillModel;

import java.io.IOException;

@WebServlet("/skillControl")
public class SkillController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        try {
            if(actObject!=null){
                String action=actObject.toString();
                if(action.equals("addSkill")){
                    SkillModel skillModel=new SkillModel();
                    skillModel.addSkill(req, resp);
                } else if (action.equals("updateSkill")) {
                    SkillModel skillModel=new SkillModel();
                    skillModel.updateSkill(req, resp);
                } else if (action.equals("deleteSkill")) {
                    SkillModel skillModel=new SkillModel();
                    skillModel.deleteSkill(req, resp);
                } else if (action.equals("activeSkill")) {
                    SkillModel skillModel=new SkillModel();
                    skillModel.activeSkill(req, resp);
                }
            }else {
                resp.sendRedirect("job-manager.jsp");
            }
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        if(actObject!=null){
            try {
                String action=actObject.toString();
                if(action.equals("updateSkill")){
                    SkillModel skillModel=new SkillModel();
                    skillModel.getSkill(req, resp);
                }else if(action.equals("deleteSkill")){
                    SkillModel skillModel=new SkillModel();
                    skillModel.deleteSkill(req, resp);
                } else if (action.equals("activeSkill")) {
                    SkillModel skillModel=new SkillModel();
                    skillModel.activeSkill(req, resp);
                }
            }catch (Exception e){
                throw new RuntimeException();
            }
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
