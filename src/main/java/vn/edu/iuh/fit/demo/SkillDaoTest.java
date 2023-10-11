package vn.edu.iuh.fit.demo;

import vn.edu.iuh.fit.dao.SkillDao;
import vn.edu.iuh.fit.entity.Skill;

public class SkillDaoTest {
    public static void main(String[] args) {
        SkillDao skillDao=new SkillDao();
//        System.out.println(skillDao.get(2));
        skillDao.getAll().forEach(s->System.out.println(s.toString()));
//        System.out.println(skillDao.add(new Skill(30,"Skill 30", "Skill 30 description", 2)));
//        System.out.println(skillDao.update(new Skill(30,"Skill 30 update", "Skill 30 description", 2)));
//        System.out.println(skillDao.delete(30));

    }
}
