package com.gamesys.tanya.logic;

/**
 * Created by tanya.powell on 24/02/16.
 */
public class Member {
    public int getAge() {
        return age;
    }

    private int age;

    public void setAge(int age) {
        this.age = age;
    }



    @Override
    public String toString() {
        return "" + age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Member member = (Member) o;

        return age == member.age;

    }

    @Override
    public int hashCode() {
        return age;
    }
}
