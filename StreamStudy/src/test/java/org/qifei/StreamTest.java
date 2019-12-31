package org.qifei;

import org.junit.Test;

import java.util.*;
import java.util.stream.Stream;

import static java.lang.Character.isDigit;
import static java.util.Arrays.asList;
import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.qifei.Person.getResult;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: org.qifei
 * @Author: QiFei
 * @CreateTime: 2019-10-23 10:00
 * @Description:
 */
public class StreamTest {

    @Test
    public void firstTryStream(){
        Person p1 =new Person(){ {setName("Leo"); setFrom("London");} };
        Person p2 =new Person(){ {setName("Azir"); setFrom("America");} };
        Person p3 =new Person(){ {setName("Jin"); setFrom("London");} };
        Person p4 =new Person(){ {setName("Laxes"); setFrom("China");} };
        ArrayList<Person> list = new ArrayList<Person>(){
            {
                add(p1);
                add(p2);
                add(p3);
                add(p4);
            }
        };
        int count = 0;
        //迭代器方式--外部迭代
        System.out.println("迭代器方式--外部迭代");
        Iterator<Person> iterator = list.iterator();
        while(iterator.hasNext()){
            Person next = iterator.next();
            if(next.isFrom("London")){
                System.out.println(count + ": " + next.getName());
                count++;
            }
        }

        //内部迭代--Stream操作 ,实际上将集合进行循环遍历，然后再讲满足条件的元素选出
        //可以看成两步，先循环过滤 再计算个数
        //Leo
        //Azir
        //Jin
        //Laxes
        //2
        System.out.println("内部迭代--Stream操作--及早求值");
        long count1 = list.stream()
                .filter(person -> {
                    System.out.println(person.getName());
                    return person.isFrom("London");
                }).count();

        //System.out.println(count1);

        System.out.println("惰性求值");
        Stream<Person> stream = list.stream()
                .filter(person -> {
                    System.out.println(person.getName());
                    return person.isFrom("London");
                });
    }

    //常用的流操作  --- collect
    @Test
    public void streamOperator1(){
        List<String> collected = Stream.of("a", "b", "c") //1.生成新的stream对象
                .collect(toList());    //2.通过collect方法生成list
        System.out.println(collected);

        assertEquals(asList("a","b","c"),collected);

    }

    //常用的流操作  --- map
    @Test
    public void streamOperator2(){
        ArrayList<String> collected = new ArrayList<>();
        for (String string : asList("a","b","hello")) {
            String upperCaseString = string.toUpperCase();
            collected.add(upperCaseString);
        }
        assertEquals(asList("A","B","HELLO"),collected);
        getResult();  //直接使用，无须 类名.方法名 使用


        //使用map 将字符串转换为大写的stream 操作
        List<String> collector = Stream.of("a", "b", "hello")
                .map(string -> string.toUpperCase())
                .collect(toList());
        assertEquals(asList("A","B","HELLO"),collector);

        List<Integer> collect = Stream.of(1, 3, 5, 7)
                .map(param -> param + 1)
                .collect(toList());

        System.out.println(collect);

        List<Integer> collectList = Stream.of(1, 3, 5, 7)
                .map(param -> {
                    if(param > 5){
                       return param * 2;
                    }
                    return param;
                })
                .collect(toList());

        System.out.println(collectList);

        Person p = new Person();
        List<String> list = Stream.of(1, 3, 5, 7)
                .map(param -> param.toString())
                .collect(toList());

        System.out.println(list);
        System.out.println(Arrays.asList("1", "3", "5", "7"));
    }

    //常用的流操作  --- filter
    @Test
    public void streamOperator3(){
        //一般情况 ,选出字符串的第一个字符是数字的字符串
        ArrayList<String> beginningWithNumbers = new ArrayList<>();
        for (String value : asList("a","1abc","acb1")) {
            if(isDigit(value.charAt(0))){
                beginningWithNumbers.add(value);
            }
        }

        assertEquals(asList("1abc"),beginningWithNumbers);

        //使用stream操作
        List<String> collect = Stream.of("a", "1abc", "acb1")
                .filter(string -> isDigit(string.charAt(0)))
                .collect(toList());
        assertEquals(asList("1abc"),collect);
    }

    //常用的流操作 --- flatMap
    @Test
    public void streamOperator4(){
        List<String> list1 = Arrays.asList("hello");
        List<String> list2 = Arrays.asList("world");
        List<String> list = Stream.of(list1, list2).flatMap(word -> word.stream()).collect(toList());
        System.out.println(list);

    }

    //常用的流操作 --- max/min
    @Test
    public void streamOperator5(){
        Person p1 = new Person(){
            {
                setName("Azir");
                setAge(1500);
            }
        };
        Person p2 = new Person(){
            {
                setName("Zelasia");
                setAge(1030);
            }
        };
        Person p3 = new Person(){
            {
                setName("Leketon");
                setAge(1030);
            }
        };

        List<Person> list = Arrays.asList(p1, p2, p3);
        Person person1 = list.stream().max(Comparator.comparing(person -> person.getAge())).get();
        System.out.println(person1);
        Person person2 = list.stream().min(Comparator.comparing(person -> person.getAge())).get();
        System.out.println(person2);


    }

    // stream常用的流操作 --- reduce
    @Test
    public void streamOperator6(){
        //使用reduce达到max，min ,count 的效果
        Person p1 = new Person(){
            {
                setName("Azir");
                setAge(1500);
            }
        };
        Person p2 = new Person(){
            {
                setName("Zelasia");
                setAge(1030);
            }
        };
        Person p3 = new Person(){
            {
                setName("Leketon");
                setAge(1030);
            }
        };

        List<Person> list = Arrays.asList(p1, p2, p3);
        //求和
        Integer totalAge = list.stream().map(person -> person.getAge()).reduce(0, (sum, age) -> sum + age);
        System.out.println(totalAge);

        //求max,同min
        Optional<Person> personMaxAge = list.stream().reduce((person1, person2) -> person1.getAge() - person2.getAge() >= 0 ? person1 : person2);
        System.out.println(personMaxAge);

    }

    //stream 整合练习 -- 找出长度大于8的科目
    @Test
    public void streamOperator7(){
        Person p1 = new Person(){
            {
                setName("Azir");
                setAge(1500);
                setSubject(new ArrayList<Subject>(){
                    {
                        add(new Subject(){
                            {
                                setSubjectId(1);
                                setSubjectName("Math");
                            }
                        });
                        add(new Subject(){
                            {
                                setSubjectId(2);
                                setSubjectName("English");
                            }
                        });
                        add(new Subject(){
                            {
                                setSubjectId(3);
                                setSubjectName("Chinese");
                            }
                        });
                    }
                });
            }
        };
        Person p2 = new Person(){
            {
                setName("Zelasia");
                setAge(1030);
                setSubject(new ArrayList<Subject>(){
                    {
                        add(new Subject(){
                            {
                                setSubjectId(4);
                                setSubjectName("Physical");
                            }
                        });
                        add(new Subject(){
                            {
                                setSubjectId(5);
                                setSubjectName("Geography");
                            }
                        });
                    }
                });
            }
        };
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.forEach(person -> {
            person.getSubject().forEach(subject -> {
                if(subject.getSubjectName().length() > 8) {
                    String subjectName = subject.getSubjectName();
                    System.out.println(subjectName);
                }
            });
        });

        //优化
        list.forEach(person -> {
           person.getSubject().stream().filter(subject -> subject.getSubjectName().length() > 8).map(Subject::getSubjectName).forEach(System.out::println);
        });

        //优化
        list.stream().flatMap(person -> person.getSubject().stream()).filter(subject -> subject.getSubjectName().length() > 8).map(Subject::getSubjectName).forEach(System.out::println);



    }

    @Test
    public void lambdaTest(){
        String name = null;
        Thread t = new Thread(() -> {});
    }



}
