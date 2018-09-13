package com.eden.mock;

import org.apache.commons.lang3.StringUtils;

public class Login {

    public static String gender = "female";
    private LoginService loginService  = new LoginService("eden", "123");

    String name;
    String pwd;

    public LoginService getLoginService() {
        return loginService;
    }

    public Login() {
        this.name = "invalid user";
        this.pwd = "123";
    }

    static {
        gender = "male";
        System.out.println(gender);
        System.out.println("----static block which will causes mock partial class----");
    }

    boolean doLogin(String name, String pwd) {
        if (StringUtils.isEmpty(name)) {
            throw new RuntimeException();
        }

        if(isValidAccount(name, pwd)) {
            System.out.println("login success!");
            return true;

        }
        System.out.println("login fail!");
        return false;
    }

    private boolean isValidAccount(String name, String pwd) {
        return "eden".equals(name) && "123".equals(pwd);
    }

    public static void main(String[] args) {
        System.out.println("hello world");
    }

    public static boolean isEden(String name) {
        return true;
    }
}
