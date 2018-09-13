package com.eden.mock;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class LoginMockitoTest {

    @Test
    public void doLoginWithVerify()  {
        /*
        * 调用mock方法的时候，被mock类的静态变量，静态代码块都会先执行；
        * 而其他的东西都被mock掉，即使后面去call也不会真正调用；
        * 所以如果mock类的静态代码块或者静态变量初始化要调用其他资源（比如连接db，读取配置文件），
        * 相当于只mock了部分的类， 一样会引起UT 变成IT 的问题
        * */
        Login mockLogin = mock(Login.class);
        mockLogin.doLogin("eden", "123");

        verify(mockLogin).doLogin("eden", "123");
        verify(mockLogin, times(1)).doLogin("eden", "123");
    }

    @Test
    public void doLoginWithWhen() {
        Login mockLogin = mock(Login.class);
        when(mockLogin.doLogin(any(),any())).thenReturn(true);

        boolean isLoginSuccess = mockLogin.doLogin("invalid user", "123");

        assertEquals(true, isLoginSuccess);
    }

    @Test
    public void doLoginWithCallRealMethod() {
        Login mockLogin = mock(Login.class);
        when(mockLogin.doLogin(any(),any())).thenCallRealMethod();

        boolean isLoginSuccess = mockLogin.doLogin("eden", "123");

        assertEquals(true, isLoginSuccess);
    }

    @Test
    public void doLoginWithSpy() {
        /*
        * same as ：
        * Login spyLogin = spy(new Login());
        * */
        Login spyLogin = spy(Login.class);

        boolean isLoginSuccess = spyLogin.doLogin("eden", "123");

        assertEquals(true, isLoginSuccess);
    }
}