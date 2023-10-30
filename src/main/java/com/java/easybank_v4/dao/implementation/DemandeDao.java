package com.java.easybank_v4.dao.implementation;

import com.java.easybank_v4.Config.HibernateUtil;
import com.java.easybank_v4.Entities.DemanderCredit;
import com.java.easybank_v4.dao.Interfaces.DemandeI;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;
import java.util.Optional;

public class DemandeDao implements DemandeI {

    @Override
    public Optional<DemanderCredit> ajoute(DemanderCredit demande) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.persist(demande);
            tx.commit();
            return Optional.of(demande);
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            e.printStackTrace();
            return Optional.empty();
        }
    }

    @Override
    public int supprime(Integer id) {
        return 0;
    }

    @Override
    public Optional<DemanderCredit> modifier(DemanderCredit demanderCredit) {
        return Optional.empty();
    }

    @Override
    public Optional<DemanderCredit> chercherParId(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<DemanderCredit> afficher() {

        List<DemanderCredit> demandes;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            demandes = session.createQuery("FROM DemanderCredit").list();
        }
        return demandes;
    }


    @Override
    public boolean changerEtat(int demandeId,String etat) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();

            DemanderCredit demande = session.get(DemanderCredit.class, demandeId);
            if (demande != null) {
                demande.setEtat(etat);
                session.update(demande);

                transaction.commit();
                return true;
            }
       } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return false;
    }


}
