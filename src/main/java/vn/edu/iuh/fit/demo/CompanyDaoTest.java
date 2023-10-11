package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.CompanyDao;

public class CompanyDaoTest {
    public static void main(String[] args) {
        CompanyDao companyDao= new CompanyDao();
        System.out.println(companyDao.logIn(3, "555-123-4567"));
    }
}
