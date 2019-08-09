package org.qifei.testForOptional;

import org.junit.Before;
import org.junit.Test;
import org.qifei.pojo.Person;

import java.util.Optional;

/**
 * @BelongsProject: ProjectManagement
 * @BelongsPackage: org.qifei.testForOptional
 * @Author: QiFei
 * @CreateTime: 2019-06-03 11:30
 * @Description: 对Optional方法的测试
 */
public class OptionalTest {
    @Test
    public void OptionalMethodsTest() {
        Person person = new Person();
        Person p1 = new Person("Lee",18,"female");
        Person p2 = new Person("Tomson",20,"male");
        Person p3 = new Person("Azir",33333,"NotPerosn");

        //通过构造方法创建泛型类optional对象---构造私有
        // Optional<Person> personOptional = new Optional<>(p3);
        // System.out.println(personOptional);

        //.empty() 返回一个空的Optional实例
        Optional<Object> optional = Optional.empty();
        System.out.println(optional);  //Optional.empty

        //.of(T value)  返回具有 Optional的当前非空值的Optional对象 value不能为null，否则报错
        Optional<Person> optional1 = Optional.of(p1);  //Optional[Person{name='null', age=null, gender='null'}]
        System.out.println(optional1);  //Optional[Person{name='Lee', age=18, gender='female'}]

        //.ofNullable(T value)  返回一个 Optional指定值的Optional，如果非空，则返回一个空的 Optional ，value可为空。
        Optional<Person> optional2 = Optional.ofNullable(null);  //Optional.empty
        System.out.println(optional2);  //Optional[Person{name='Lee', age=18, gender='female'}]

        //.get()  如果 Optional中存在值，则返回值，否则抛出 NoSuchElementException 。
        Person person1 = (Person)optional1.get();
        System.out.println(person1);  //Person{name='Lee', age=18, gender='female'}

        //.isPresent()  如果存在值，则返回 true ，否则为 false 。
        boolean present = optional2.isPresent();
        System.out.println(present);

        //.map()  如果存在值，则应用提供的映射函数，如果结果不为空，则返回一个Optional结果的Optional 。 否则返回一个空的Optional
        Optional<String> stringOptional = Optional.ofNullable("zhangsan");
        String s = stringOptional.map(e -> e.toUpperCase()).orElse("it's wrong");
        System.out.println(s);

        //.filterMap()  如果一个值存在，应用提供的Optional映射函数给它，返回该结果，否则返回一个空的Optional 。 这种方法类似于map(Function) ，但是提供的映射器是一个结果已经是Optional映射器，如果被调用， flatMap不会用额外的Optional
        String s1 = stringOptional.flatMap(e -> Optional.ofNullable("lisi")).orElse("So, it's wrong again");
        System.out.println(s1);

        stringOptional = Optional.empty();
        Object o = stringOptional.flatMap(e -> Optional.ofNullable(null)).orElse("well,i don't wanner see you ");
        System.out.println(o);
    }
}
