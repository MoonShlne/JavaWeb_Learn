package com.myself01;

import java.util.Objects;

/**
 * @author polar
 * @version 1.0
 * @since 2025/3/9 13:43
 */
public class Friends {
    private  String fName;

    public Friends(String fName) {
        this.fName = fName;
    }

    public Friends() {
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Friends friends = (Friends) o;
        return Objects.equals(fName, friends.fName);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(fName);
    }


}
