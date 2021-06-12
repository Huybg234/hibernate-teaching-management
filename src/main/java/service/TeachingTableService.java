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

        if (teachingTable.getTeacherId() <= 0) {
            return false;
        }
        if (teachingTable.getSubjectId() <= 0) {
            return false;
        }
        if (teachingTable.getClassTotal() <= 0) {
            return false;
        }
        return teachingTableDao.insert(teachingTable);
    }

    public boolean removeTeachingTable(TeachingTable teachingTable) {
        return teachingTableDao.removeTeachingTable(teachingTable);
    }

    public boolean update(TeachingTable teachingTable) {

        if (teachingTable.getTeacherId() <= 0) {
            return false;
        }
        if (teachingTable.getSubjectId() <= 0) {
            return false;
        }
        if (teachingTable.getClassTotal() <= 0) {
            return false;
        }
        return teachingTableDao.update(teachingTable);
    }
}
