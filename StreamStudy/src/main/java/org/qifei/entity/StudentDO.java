package org.qifei.entity;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: org.qifei.entity
 * @Author: QiFei
 * @CreateTime: 2019-12-26 09:34
 * @Description:
 */
public class StudentDO {
    private String name;
    private Integer age;
    private Integer graduated;
    private Boolean isLearning;     //不能使用isXXXX命名Entity属性；

    public StudentDO() {
    }

    public StudentDO(String name) {
        System.out.println(1);
        this.name = name;
    }

    {
        System.out.println(2);
    }
    private void init(){
        System.out.println(1111);
    }

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

    public Integer getGraduated() {
        return graduated;
    }

    public void setGraduated(Integer graduated) {
        this.graduated = graduated;
    }

    public Boolean getLearning() {
        return isLearning;
    }

    public void setLearning(Boolean learning) {
        isLearning = learning;
    }
}
