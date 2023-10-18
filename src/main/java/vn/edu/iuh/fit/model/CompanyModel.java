package vn.edu.iuh.fit.model;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.service.CompanyService;

import java.io.IOException;

public class CompanyModel {
    private final CompanyService companyService=new CompanyService();
    public void loginCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long compID= Long.parseLong(request.getParameter("compID"));
        String pass= request.getParameter("pass");
        boolean login=companyService.logInCompany(compID,pass);
        if(login){
            response.sendRedirect("companyControl?action=login&compID=" + compID);
        }else {
            String errorMessage = "Đăng nhập không thành công. Vui lòng kiểm tra thông tin đăng nhập.";
            request.setAttribute("errorMessage", errorMessage);
            request.getRequestDispatcher("company-login.jsp").forward(request, response);
        }
    }
    public void getCompany(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        long compID= Long.parseLong(request.getParameter("compID"));
        request.setAttribute("compID", compID);
        request.getRequestDispatcher("job-manager.jsp").forward(request, response);
    }
}
