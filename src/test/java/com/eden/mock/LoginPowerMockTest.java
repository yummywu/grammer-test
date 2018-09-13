package com.eden.mock;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.core.classloader.annotations.SuppressStaticInitializationFor;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.reflect.Whitebox;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.powermock.api.mockito.PowerMockito.mockStatic;
import static org.powermock.api.mockito.PowerMockito.when;
import static org.powermock.api.support.membermodification.MemberMatcher.*;
import static org.powermock.api.support.membermodification.MemberModifier.suppress;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Login.class})
@SuppressStaticInitializationFor("com.eden.mock.Login")
public class LoginPowerMockTest {

    @Test
    public void mockStaticMethodInClass() throws Exception {
        mockStatic(Login.class);
        when(Login.isEden("123")).thenReturn(false);

        boolean isEden = Login.isEden("eden");
        assertEquals(isEden, isEden);
    }

    @Test
    public void invokePrivateMethod() throws Exception {
        boolean isValidAccount = Whitebox.invokeMethod(new Login(), "isValidAccount", "eden", "123");

        assertEquals(true, isValidAccount);
    }

    @Test
    public void invokeStaticMethod() throws Exception {
        Whitebox.invokeMethod(Login.class, "main", any());
    }

    @Test
    public void suppressConstructorMethod() throws Exception {
        suppress(constructor(Login.class));
        Login login = new Login();
        boolean isLoginSuccess = login.doLogin("eden", "123");

        assertEquals(true, isLoginSuccess);
    }

    @Test
    public void suppressConstructorMethodWithWhitebox() throws Exception {
        Login login = Whitebox.newInstance(Login.class);
        boolean isLoginSuccess = login.doLogin("eden", "123");

        assertEquals(true, isLoginSuccess);
    }

    @Test
    public void suppressPrivateMethod() throws Exception {
        suppress(method(Login.class, "isValidAccount"));

        Login login = new Login();
        boolean isLoginSuccess = login.doLogin("eden", "123");

        assertEquals(false, isLoginSuccess);
    }

    @Test
    public void suppressStaticInitializer() throws Exception {
        /*
        * need annotation @SuppressStaticInitializationFor
        * */
        Login login = new Login();
        boolean isLoginSuccess = login.doLogin("eden", "123");

        assertEquals(true, isLoginSuccess);
    }

    @Test
    public void suppressClassField() throws Exception {
        /*
        * actually will still new the object, but will return null when need get it
        * not very useful
        * */
        suppress(field(Login.class, "loginService"));

        Login login = new Login();

        assertEquals(null, login.getLoginService());
    }



}