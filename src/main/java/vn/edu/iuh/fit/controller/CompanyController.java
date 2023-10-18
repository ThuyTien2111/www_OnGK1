package vn.edu.iuh.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.entity.Company;
import vn.edu.iuh.fit.model.CompanyModel;

import java.io.IOException;

@WebServlet("/companyControl")
public class CompanyController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        try {
            if(actObject!=null){
                String action=actObject.toString();
                if(action.equals("login")){
                    CompanyModel companyModel= new CompanyModel();
                    companyModel.loginCompany(req, resp);
                }
            }else {
                resp.sendRedirect("index.jsp");
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
                if(action.equals("login")){
                    CompanyModel companyModel= new CompanyModel();
                    companyModel.getCompany(req, resp);
                }
            }catch (Exception e){
                throw new RuntimeException();
            }
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
