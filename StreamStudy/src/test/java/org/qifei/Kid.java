package org.qifei;

import java.time.LocalDateTime;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: org.qifei
 * @Author: QiFei
 * @CreateTime: 2019-12-06 09:40
 * @Description:
 */
public class Kid {
    private Integer age;
    private String name;
    private LocalDateTime birthday;

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDateTime birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Kid{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", birthday=" + birthday +
                '}';
    }
}
