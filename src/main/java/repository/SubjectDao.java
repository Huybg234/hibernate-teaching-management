package repository;

import entity.Subject;
import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import util.HibernateUtil;

import java.util.List;

public class SubjectDao {

    Logger logger = Logger.getLogger(SubjectDao.class);

    public List<Subject> getAllSubject() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Subject").list();
        } catch (HibernateException e) {
            logger.error(e);
        }
        return null;
    }

    public boolean insert(Subject subject) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.save(subject);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error(e);
        }
        return false;
    }


    public boolean removeSubject(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            Subject subject = session.load(Subject.class, id);
            session.delete(subject);
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

    public boolean update(Subject subject) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.update(subject);
            session.getTransaction().commit();
            return true;
        } catch (HibernateException e) {
            logger.error(e);
        }
        return false;
    }
}
