package repository;

import entity.Teacher;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class TeacherDao {

    Logger logger = Logger.getLogger(TeacherDao.class);

    public List<Teacher> getAllTeacher() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Teacher").list();
        } catch (HibernateException e) {
            logger.error(e);
        }
        return null;
    }

    public boolean insert(Teacher teacher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(teacher);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error(e);
        }
        return false;
    }


    public boolean removeTeacher(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Teacher teacher = session.load(Teacher.class, id);
            session.delete(teacher);
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

    public boolean update(Teacher teacher) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(teacher);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error(e);
        }
        return false;
    }
}
