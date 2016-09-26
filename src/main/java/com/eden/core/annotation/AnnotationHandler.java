package com.eden.core.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationHandler {

    public static void main(String[] args) {
        Method[] methods = TestAnnotation.class.getMethods();
        for (Method method : methods) {
            Annotation[] a = method.getAnnotations();
            MyAnnotation myAnnotation = method.getAnnotation(MyAnnotation.class);
            if (myAnnotation != null) {
                String id = myAnnotation.id();
                String name = myAnnotation.name();
                int revision = myAnnotation.revision();
                System.out.println(id + ":" + name + ":" + revision );
            }
        }
    }

}
