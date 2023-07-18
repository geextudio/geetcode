//package io.geextudio.javasyntaxlab;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        var normalObject = new NormalClass();
    }
}

class NormalClass {
    
    public NormalClass() { /*TODO: placeholder*/ }
    
    // write a method that can calculate add and subtract.
    @MethodAnnotationLab //(addMonitor = 0)
    public static int add(int a, int b) {
        return a + b;
    }

    public static int subtract(int a, int b) {
        return a - b;
    }

}

// write an annotation in Java.
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MethodAnnotationLab {

    // 每一个方法实际上是声明了一个配置参数, 方法的名称就是参数的名称
    // 返回值类型就是参数的类型（返回值只能是基本类型,Class , String , enum ).√可以通过default来声明参数的默认值
    public int[] addMonitor() default {0,0};
    
    public String version() default "1.0";
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface DefaultMethodAnnotation {
    // 如果只有一个参数成员，一般参数名为value
    public String value() default "This is a default annotation info.";
}