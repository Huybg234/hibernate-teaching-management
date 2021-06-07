package service;

import entity.Subject;
import repository.SubjectDao;

import java.util.List;

public class SubjectService {

    SubjectDao subjectDao = new SubjectDao();

    public List<Subject> getListSubject() {
        return subjectDao.getAllSubject();
    }

    public boolean insert(Subject subject) {
        List<Subject> subjects = subjectDao.getAllSubject();
        subjects.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = subjects.get(0).getId() + 1;

        subject.setId(id);
        if (subject.getName() == null) {
            return false;
        }
        if (subject.getTotalLesson() <= 0){
            return false;
        }
        if (subject.getTheoryLesson() <=0){
            return false;
        }
        if (subject.getUnitTheoryCost() <=0){
            return false;
        }
        return subjectDao.insert(subject);
    }

    public boolean update(Subject subject) {
        if(subject.getId() <= 0){
            return false;
        }
        if (subject.getName() == null) {
            return false;
        }
        if (subject.getTotalLesson() <= 0){
            return false;
        }
        return subjectDao.update(subject);
    }

    public boolean removeSubject(int id) {
        return subjectDao.removeSubject(id);
    }
}
