package de.kreidler.sarah.dao;

import de.kreidler.sarah.HibernateUtil;
import de.kreidler.sarah.domain.Mapping;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MarketDao {


    public void save(List<Mapping> mappings) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            // save the student objects
            session.save(mappings.get(0));

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public List<Mapping> getMappings() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction

            return session.createQuery("from Mapping", Mapping.class).list();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
