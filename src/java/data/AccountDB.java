
package data;

import business.User;
import business.Account;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;


public class AccountDB {
    public static void insert(Account accou) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(accou);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
     public static void update(Account accou) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();       
        try {
            em.merge(accou);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
//Method
     
public static Account selectAccount(User user, String account){
    EntityManager em = DBUtil.getEmFactory().createEntityManager();
    String qString = "SELECT a FROM Account a " + 
            "WHERE a.user = :user AND a.accountType= :ACCOUNT";
    TypedQuery<Account> q = em.createQuery(qString, Account.class);
    q.setParameter("user", user);
    q.setParameter("ACCOUNT", account);
    try {
        Account a = q.getSingleResult();
        return a;
    } catch (NoResultException e){
        return null;
    } finally {
        em.close();
    }
}
}