package co.devskills.app.repository;

import co.devskills.app.dto.AccountResponse;
import co.devskills.app.dto.TransactionRequest;
import co.devskills.app.dto.TransactionResponse;
import co.devskills.app.model.Account;
import co.devskills.app.model.Activity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class BankService {
    @Autowired
    BankRepository repository;

    @Transactional
    public Activity saveTransaction(TransactionRequest trans){

        Account acc = repository.getAccount(trans.getAccount_id());
        if(acc == null){
            repository.saveAccount(new Account(trans.getAccount_id().toString(),0));
            acc = repository.getAccount(trans.getAccount_id());
        }
        Activity transaction = repository.saveTransaction(new Activity(acc,trans.getAmount()));
        acc.setBalance(acc.getBalance() + trans.getAmount());
        repository.saveAccount(acc);
        return transaction;
    }
    @Transactional
    public Account getAccount(UUID accountId){
       //List<Transaction> allTransactions = repository.getAllTransactions(accountId);
        //account.setBalance(allTransactions.stream().mapToInt(Transaction::getAmount).sum());

        return repository.getAccount(accountId);
    }

    @Transactional
    public Activity getTransaction(UUID transactionId){
        return repository.getTransaction(transactionId);
    }

    @Transactional
    public List<Activity> getAllTransactions(){
        return repository.getAllTransactions();
    }
}
