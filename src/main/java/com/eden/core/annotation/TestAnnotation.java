package com.eden.core.annotation;

public class TestAnnotation {
    
    @MyAnnotation(id = "001")
    @MyAnotherAnnotation
    public void test() {
        System.out.println("test function");
    }
}
