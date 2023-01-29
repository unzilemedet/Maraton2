package org.example.repository;


import org.example.entitiy.Musteri;
import org.example.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import java.util.List;

public class MusteriRepository {
    private Session session = null;


    public List<Musteri> getAll() {
    List<Musteri> list = null;

        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
        session.beginTransaction();
        list = session.createQuery("select musteri from Musteri musteri").list();
        session.getTransaction().commit();
    } catch (Exception e) {
        System.out.println(e.getMessage());
    }
        return list;
}

}
