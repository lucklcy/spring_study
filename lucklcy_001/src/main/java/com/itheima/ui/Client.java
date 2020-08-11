package com.itheima.ui;

import com.itheima.factory.BeanFactory;
import com.itheima.service.IAccountService;
import com.itheima.service.impl.AccountServiceImpl;

public class Client {
    public static void main(String[] args) {
//        IAccountService accountService = new AccountServiceImpl();
        IAccountService accountService = (IAccountService) BeanFactory.getBean("accountService");
        for (int i = 0 ; i < 5 ; i++){
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
