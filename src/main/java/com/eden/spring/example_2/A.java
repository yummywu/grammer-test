package com.eden.spring.example_2;

public class A {

    private B b;

    public void methodOfA() {
        b.methodOfB();
    }

    public void setB(B b){
        this.b = b;
    }

}
