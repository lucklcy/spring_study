package com.itheima.ui;

import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
        IAccountService accountService = new AccountServiceImpl();
        accountService.saveAccount();
    }
}
