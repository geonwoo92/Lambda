package com.erich.api.account;

import com.erich.api.common.AbstractService;
import com.erich.api.common.Member;
import com.erich.api.enums.Messenger;
import com.erich.api.user.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;


public class AccountServiceImpl extends AbstractService<Account> implements AccountService {
    private static AccountServiceImpl instance = new AccountServiceImpl();
    List<Account> accounts;
    Map<String, Member> users;
    private AccountServiceImpl(){
        this.accounts = new ArrayList<>();
    }
    public static AccountServiceImpl getInstance(){return instance;}

    @Override
    public String deposit(Account account) {
        return null;
    }

    @Override
    public String withdraw(Account account) {
        return null;
    }

    @Override
    public String getBalance(String accountNumber) {
        return null;
    }

    @Override
    public Messenger save(Account account) {
        return null;
    }

    @Override
    public List<Account> findAll() {
        return null;
    }

    @Override
    public Optional<Account> findById(long id) {
        return Optional.empty();
    }


    @Override
    public String count() {
        return null;
    }

    @Override
    public Optional<Account> getOne(String id) {
        return Optional.empty();
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<?> getUserList() {
        return null;
    }

    @Override
    public String delete(Account account) {
        return null;
    }

    @Override
    public Boolean existsById(long id) {
        return null;
    }


}
