package com.myself01;

import java.util.Objects;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/9 13:43
 */
public class Dog {
private  String dName;

    public Dog(String dName) {
        this.dName = dName;
    }

    public Dog() {
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Dog dog = (Dog) o;
        return Objects.equals(dName, dog.dName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(dName);
    }
}
