package com.myself01;

import java.util.Objects;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/9 13:41
 */
public class Person {
    private String name;
    private int age;
    Dog dog;
    Friends[] friend;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    public Friends[] getFriend() {
        return friend;
    }

    public void setFriend(Friends[] friend) {
        this.friend = friend;
    }

    public Person(String name, int age, Dog dog, Friends[] friend) {
        this.name = name;
        this.age = age;
        this.dog = dog;
        this.friend = friend;
    }



    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(dog, person.dog) && Objects.equals(friend, person.friend);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, dog, friend);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", dog=" + dog +
                ", friend=" + friend +
                '}';
    }
}
