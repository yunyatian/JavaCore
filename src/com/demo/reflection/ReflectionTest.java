package com.demo.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

public class ReflectionTest {
    public static void main(String args[]) throws ClassNotFoundException {
        String name;
        if(args.length > 0){
            name = args[0];
        }else {
            Scanner scanner = new Scanner(System.in);
            System.out.println("输入类名：");
            name = scanner.next();
            scanner.close();
        }
        Class cl = Class.forName(name);
        Class supercl = cl.getSuperclass();
        System.out.println("包名："+cl.getPackage());
        System.out.println(cl.getModifiers());
        String modifiers = Modifier.toString(cl.getModifiers());
        if (modifiers.length() > 0 ){
            System.out.print(modifiers+" ");
        }
        System.out.print("class "+name+" ");
        if(supercl !=null && supercl != Object.class){
            System.out.print("extend "+supercl.getName());
        }
        System.out.print("\n{\n");
        System.out.println("修饰符 类名/类型名/返回值  方法名 参数类型");
        printConstructors(cl);
        System.out.println();
        printMethods(cl);
        System.out.println();
        printFields(cl);
        System.out.println("}");

    }

    public static void printConstructors(Class cl){
        Constructor constructors[] = cl.getDeclaredConstructors();

        for (Constructor c: constructors) {
            String name = c.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(c.getModifiers());
            if(modifiers.length() > 0){
                System.out.print("构造器修饰符："+modifiers+" ");
            }
            System.out.print("构造器名称："+name+" 参数类型列表：(");
            Class paramTypes[] = c.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++){
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printMethods(Class cl){
        Method methods[] = cl.getDeclaredMethods();

        for (Method m: methods) {
            Class retType = m.getReturnType();
            String name = m.getName();

            System.out.print("    ");
            String modifiers = Modifier.toString(m.getModifiers());
            if (modifiers.length() > 0){
                System.out.print("方法修饰符："+modifiers+" ");
            }
            System.out.print("返回值类型："+retType.getName()+" 方法名："+name+" 参数列表：(");
            Class paramTypes[] = m.getParameterTypes();
            for (int i = 0; i < paramTypes.length; i++) {
                System.out.print(paramTypes[i].getName());
            }
            System.out.println(");");
        }
    }

    public static void printFields(Class cl){
        Field fields[] = cl.getFields();
        for (Field f: fields) {
            Class type = f.getType();
            String name = f.getName();
            System.out.print("    ");
            String modifiers = Modifier.toString(f.getModifiers());
            if (modifiers.length() > 0){
                System.out.print("field修饰符："+modifiers+" ");
            }
            System.out.println("field类型名："+type.getName()+" field名："+name);
        }
    }
}
