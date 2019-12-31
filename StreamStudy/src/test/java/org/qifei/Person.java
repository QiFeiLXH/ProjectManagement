package org.qifei;

import java.util.List;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: org.qifei
 * @Author: QiFei
 * @CreateTime: 2019-10-23 10:16
 * @Description:
 */
public class Person {
    private String name;
    private Integer age;
    private String from;
    private List<Subject> subject;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public boolean isFrom(String place){
        return this.from.equals(place);
    }

    public static void getResult(){
        System.out.println("直接使用，无须 类名.方法名 使用");
    }

    public List<Subject> getSubject() {
        return subject;
    }

    public void setSubject(List<Subject> subject) {
        this.subject = subject;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", from='" + from + '\'' +
                ", subject=" + subject +
                '}';
    }
}
