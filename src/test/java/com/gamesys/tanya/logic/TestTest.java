package com.gamesys.tanya.logic;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by tanya.powell on 24/02/16.
 */
public class TestTest {
    @Test
    public void foo(){
        Member member = new Member();
        member.setAge(55);


        Member member2 = new Member();
        member2.setAge(55);


        Assert.assertEquals(member.getAge(), member2.getAge());
    }

    @Test
    public void compareStrings() {
        String a = "maurice";
        String b = "maurice";

        Assert.assertTrue(a == b);
//        Assert.assertEquals(a, b);
    }

}
