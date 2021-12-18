package co.devskills.app.repository;

import co.devskills.app.model.Account;
import co.devskills.app.model.Activity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class BankRepository{
    @PersistenceContext
    private EntityManager em;

    public Activity saveTransaction(Activity trans) {
        em.persist(trans);
        return trans;
    }

    public Account saveAccount(Account account) {
        em.persist(account);
        return account;
    }

    public Account getAccount(UUID accountId) {
        return em.find(Account.class, accountId.toString());
    }

    public Activity getTransaction(UUID transactionId) {
        return em.find(Activity.class, transactionId.toString());
    }
    public List<Activity> getAllTransactions(){
        return (List<Activity>)em.createQuery("Select a from Activity a").getResultList();
    }
    public List<Activity> getAllTransactions(UUID accountId){
        return (List<Activity>)em.createQuery("Select a from Activity where a.account.account_id = :accountKey ").setParameter("accountKey",accountId).getResultList();
    }
}
