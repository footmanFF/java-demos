package com.fm.java.java8;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * @author footmanff on 2017/8/21.
 */
public class MethodReferrance {

    public static void main(StringTest[] args) {
        Person[] persons = new Person[10];

        /**
         * 引用静态方法 : ContainingClass::staticMethodName
         */
        Stream.of(persons)
              .sorted((o1, o2) -> Person.compareByAge(o1, o2));
        Stream.of(persons)
              .sorted(Person::compareByAge);

        /**
         * 引用某个对象的实例方法 : containingObject::instanceMethodName
         */
        ComparisonProvider provider = new ComparisonProvider();
        Stream.of(persons)
              .sorted((o1, o2) -> provider.compareByAge(o1, o2));
        Stream.of(persons)
              .sorted(provider::compareByAge);

        /**
         * 引用某个类型的任意对象的实例方法 : ContainingType::methodName
         */
        Arrays.asList("A", "B", "C")
              .sort((o1, o2) -> o1.compareTo(o2));
        Arrays.asList("A", "B", "C")
              .sort(String::compareTo);

        /**
         * 引用构造方法 : ClassName::new
         */
        transferElements(Arrays.asList(persons), () -> new HashSet<>());
        transferElements(Arrays.asList(persons), HashSet::new);
    }

    static class Person {
        public Person(Date birthday) {
            this.birthday = birthday;
        }

        Date birthday;

        public static int compareByAge(Person a, Person b) {
            return a.birthday.compareTo(b.birthday);
        }

        public Date getBirthday() {
            return birthday;
        }
    }

    static class ComparisonProvider {

        public int compareByAge(Person a, Person b) {
            return a.getBirthday()
                    .compareTo(b.getBirthday());
        }

    }

    /**
     * 将一个集合实例的类型替换成supplier返回的集合类型
     *
     * @param from
     * @param supplier
     * @param <T>
     * @param <FROM>
     * @param <TO>
     * @return
     */
    public static <T, FROM extends Collection<T>, TO extends Collection<T>>
    TO transferElements(FROM from, Supplier<TO> supplier) {
        TO result = supplier.get();
        for (T t : from) {
            result.add(t);
        }
        return result;
    }


}
