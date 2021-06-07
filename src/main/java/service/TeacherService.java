package service;

import entity.Teacher;
import repository.TeacherDao;

import java.util.List;

public class TeacherService {

    TeacherDao teacherDao = new TeacherDao();

    public List<Teacher> getListTeacher() {
        return teacherDao.getAllTeacher();
    }

    public boolean insert(Teacher teacher) {
        List<Teacher> teachers = teacherDao.getAllTeacher();
        teachers.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = teachers.get(0).getId() + 1;

        teacher.setId(id);
        if (teacher.getName() == null) {
            return false;
        }
        if (teacher.getAddress() == null) {
            return false;
        }
        if (teacher.getPhoneNumber() == null) {
            return false;
        }
        if (teacher.getLevel() == null) {
            return false;
        }
        return teacherDao.insert(teacher);
    }

    public boolean removeTeacher(int id) {
        return teacherDao.removeTeacher(id);
    }

    public boolean update(Teacher teacher) {
        if(teacher.getId() <= 0){
            return false;
        }
        if (teacher.getName() == null) {
            return false;
        }
        if (teacher.getAddress() == null){
            return false;
        }
        if (teacher.getPhoneNumber() == null){
            return false;
        }
        if (teacher.getLevel() == null){
            return false;
        }
        return teacherDao.update(teacher);
    }
}
