package vn.edu.iuh.fit.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.edu.iuh.fit.model.JobModel;

import java.io.IOException;

@WebServlet("/jobControl")
public class JobController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object actObject=req.getParameter("action");
        if(actObject!=null){
            String action=actObject.toString();
            if(action.equals("addJob")){
                JobModel jobModel=new JobModel();
                jobModel.addJob(req, resp);
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
            if(action.equals("addJob")){
                JobModel jobModel=new JobModel();
                jobModel.getCompany(req, resp);
            }
        }else {
            resp.sendRedirect("index.jsp");
        }
    }
}
