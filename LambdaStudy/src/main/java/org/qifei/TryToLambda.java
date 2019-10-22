package org.qifei;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: org.qifei
 * @Author: QiFei
 * @CreateTime: 2019-10-21 10:03
 * @Description:
 */
public class TryToLambda {

    @Test
    public void noArguments(){
        Thread thread = new Thread(new Runnable(){

            @Override
            public void run() {
                System.out.println("显式声明-" + Thread.currentThread().getName());
            }
        });
        thread.start();

        //函数式编程
        Thread thread1 = new Thread(() -> System.out.println("函数式编程Lambda-" + Thread.currentThread().getName()));
        thread1.start();
    }

    @Test
    public void finalParams(){
        String name1 = "Leo";
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("显式声明-" + Thread.currentThread().getName() + " -- " + name1);
            }
        });
        thread1.start();

        //String name2 = "Azir";
        final String name2 = "Azir";
        Thread thread2 = new Thread(() -> System.out.println("函数式编程Lambda-" + Thread.currentThread().getName() + " -- " + name2));
        thread2.start();


    }


    @Test
    public void innerClass(){
        ArrayList<String> strings = new ArrayList<String>(){
            {
                add("1");
                add("2");
                System.out.println(this.hashCode());
            }
        };
        System.out.println(strings.hashCode());
    }

    @Test
    public void innerPerson(){
        Person person = new Person(){
            {
              setAge(1);
              setName("Tomas");
            }
        };

        System.out.println(person.toString());  //Person{name='Tomas', age=1}

        //final String name = person.getName();   隐含用fianl修饰
        String name = person.getName();
        //name = "323";  Lambda中使用外部变量需final,jdk1.8以后可以不用显式声明，但是是既成的事实，所有就无法再对变量进行修改
        Thread thread2 = new Thread(() -> System.out.println("函数式编程Lambda-" + Thread.currentThread().getName() + " -- " + name));
        thread2.start();

        String name1 = person.getName();
        //name1 = "232"; 同样的，jdk1.8放宽了匿名内部类的对外部变量final的声明，实际上仍是final修饰的变量；
        Thread thread1 = new Thread(new Runnable(){
            @Override
            public void run() {
                System.out.println("显式声明-" + Thread.currentThread().getName() + " -- " + name1);
            }
        });
        thread1.start();
    }
}
