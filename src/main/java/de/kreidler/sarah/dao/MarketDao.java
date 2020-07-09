package de.kreidler.sarah.dao;

import de.kreidler.sarah.HibernateUtil;
import de.kreidler.sarah.domain.Mapping;
import de.kreidler.sarah.domain.Price;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class MarketDao {

    public List<Mapping> save(List<Mapping> mappings) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(mappings.get(1));

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return mappings;
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


    public List<Price> savePrice(List<Price> prices) {

        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction
            transaction = session.beginTransaction();
            session.save(prices.get(0));

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return prices;

    }

    public List<Price> getPrices() {

        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // start a transaction

            return session.createQuery("from Price", Price.class).list();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }

}
