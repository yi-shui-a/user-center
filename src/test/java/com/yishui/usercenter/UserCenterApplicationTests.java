package com.yishui.usercenter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@SpringBootTest
class  UserCenterApplicationTests {

    @Test
    void testDigest() throws NoSuchAlgorithmException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] bytes = md5.digest("abcd".getBytes(StandardCharsets.UTF_8));
        String result = new String(bytes);
        System.out.println(result);
    }

    @Test
    void contextLoads() {
    }

}
