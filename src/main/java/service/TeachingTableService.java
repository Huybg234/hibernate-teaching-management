package service;

import entity.TeachingTable;
import repository.TeachingTableDao;

import java.util.List;

public class TeachingTableService {
    TeachingTableDao teachingTableDao = new TeachingTableDao();

    public List<TeachingTable> getListTeaching() {
        return teachingTableDao.getAllTeaching();
    }

    public boolean insert(TeachingTable teachingTable) {
        List<TeachingTable> teachingTables = teachingTableDao.getAllTeaching();
        teachingTables.sort((o1, o2) -> o1.getId() < o2.getId() ? 1 : -1);
        int id = teachingTables.get(0).getId() + 1;

        teachingTable.setId(id);
        if (teachingTable.getId() <= 0) {
            return false;
        }
        if (teachingTable.getTeacherId() <=0) {
            return false;
        }
        if (teachingTable.getSubjectId() <=0) {
            return false;
        }
        if (teachingTable.getClassTotal() <=0) {
            return false;
        }
        return teachingTableDao.insert(teachingTable);
    }

    public boolean removeTeacher(int id) {
        return teachingTableDao.removeTeachingTable(id);
    }

    public boolean update(TeachingTable teachingTable) {
        if (teachingTable.getId() <= 0) {
            return false;
        }
        if (teachingTable.getTeacherId() <=0) {
            return false;
        }
        if (teachingTable.getSubjectId() <=0) {
            return false;
        }
        if (teachingTable.getClassTotal() <=0) {
            return false;
        }
        return teachingTableDao.update(teachingTable);
    }
}
