package vn.edu.iuh.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.model.CandidateModel;
import vn.edu.iuh.fit.model.CandidateSkillModel;

import java.io.IOException;

@WebServlet("/candidateControl")
public class CandidateController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("login")){
                CandidateModel candidateModel=new CandidateModel();
                candidateModel.loginCandidate(req, resp);
            }
        }else {
            resp.sendRedirect("index.jsp");
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("login")){
                CandidateModel candidateModel=new CandidateModel();
                candidateModel.getCandidate(req, resp);
            } else if (action.equals("findCandidate")) {
                CandidateSkillModel candidateSkillModel=new CandidateSkillModel();
                candidateSkillModel.getCandidateOrderBySkill(req, resp);
            } else if (action.equals("learnSkill")) {
                CandidateSkillModel candidateSkillModel=new CandidateSkillModel();
                candidateSkillModel.getSkillNotHaveToLearn(req, resp);
            }
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
