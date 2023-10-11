package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.CompanyDao;

public class CompanyService {
    private CompanyDao companyDao;

    public CompanyService() {
        companyDao=new CompanyDao();
    }
    public boolean logInCompany(long comp_id, String pass){
        return companyDao.logIn(comp_id, pass);
    }


}
