package com.wzf.service.serviceImpl;

import org.junit.Test;

import static org.junit.Assert.*;

public class PasswordUtilTest {

    @Test
    public void encodePwd() {
        System.out.println(PasswordUtil.encodePwd("b"));
    }
}