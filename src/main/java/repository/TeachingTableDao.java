package repository;

import entity.TeachingTable;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.List;

public class TeachingTableDao {

    Logger logger = Logger.getLogger(TeacherDao.class);

    public List<TeachingTable> getAllTeaching() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from TeachingTable ").list();
        } catch (HibernateException e) {
            logger.error(e);
        }
        return null;
    }

    public boolean insert(TeachingTable teachingTable) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(teachingTable);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error(e);
        }
        return false;
    }

    public boolean removeTeachingTable(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            TeachingTable teachingTable = session.load(TeachingTable.class, id);
            session.delete(teachingTable);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            session.getTransaction().rollback();
            logger.error(e);
        } finally {
            session.close();
        }
        return false;
    }

    public boolean update(TeachingTable teachingTable) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(teachingTable);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error(e);
        }
        return false;
    }
}
