package vn.edu.iuh.fit.service;

import vn.edu.iuh.fit.dao.SkillDao;
import vn.edu.iuh.fit.entity.Skill;

import java.util.List;

public class SkillService {
    private SkillDao skillDao;

    public SkillService() {
        skillDao=new SkillDao();
    }
    public boolean addSkill(Skill skill){
        if((skill.getSkill_type()>=0)&&(skill.getSkill_type()<=2)) return skillDao.add(skill);
        return false;
    }
    public boolean updateSkill(Skill skill){
        if((skill.getSkill_type()>=0)&&(skill.getSkill_type()<=2)) return skillDao.update(skill);
        return false;
    }
    public boolean deleteSkill(long id){
        return skillDao.delete(id);
    }
    public boolean activeSkill(long id){
        return skillDao.active(id);
    }
    public Skill getSkillByID(long id){
        return skillDao.get(id);
    }
    public List<Skill> getAllSkill(){
        return skillDao.getAll();
    }
    public List<Skill> getSkillsForJob(long jobID){
        return skillDao.getSkillsForJob(jobID);
    }

}
