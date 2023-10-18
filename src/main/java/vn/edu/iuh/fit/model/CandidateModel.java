package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entity.Candidate;
import vn.edu.iuh.fit.entity.CandidateSkill;
import vn.edu.iuh.fit.service.CandidateService;
import vn.edu.iuh.fit.service.CandidateSkillService;

import java.io.IOException;

public class CandidateModel {
    private final CandidateService candidateService=new CandidateService();
    public void loginCandidate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long candID=Long.parseLong(request.getParameter("candID"));
        String pass=request.getParameter("pass");
        boolean login=candidateService.logInCandidate(candID, pass);
        if(login){
            response.sendRedirect("candidateControl?action=login&candID="+candID);
        }else {
            String errorMessage="Đăng nhập không thành công. Vui lòng kiểm tra lại thông tin đăng nhập";
            request.setAttribute("error", errorMessage);
            request.getRequestDispatcher("candidate-login.jsp").forward(request, response);
        }
    }
    public void getCandidate(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long candID=Long.parseLong(request.getParameter("candID"));
        request.setAttribute("candID", candID);
        request.getRequestDispatcher("job-for-candidate.jsp").forward(request, response);
    }
}
