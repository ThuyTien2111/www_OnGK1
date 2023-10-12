package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.CandidateDao;

public class CandidateDaoTest {
    public static void main(String[] args) {
        CandidateDao candidateDao= new CandidateDao();
//        System.out.println(candidateDao.logIn(2,"987-654-3210"));
        /*candidateDao.getCandByYearBorn().entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + "\n So luong:"+ entry.getValue());
        });*/
        /*candidateDao.getTotalSkillByCand().entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + "\n So luong:"+ entry.getValue());
        });*/
        candidateDao.getTotalJobSkillByCand().entrySet().forEach(entry ->{
            System.out.println(entry.getKey() + "\n So luong:"+ entry.getValue());
        });
    }
}
