package com.eden.spring.example_3;

public class A {
    private B b;

    public void methodOfA() {
        b.methodOfB();
    }

    public A(B b) {
        this.b = b;
    }

}
