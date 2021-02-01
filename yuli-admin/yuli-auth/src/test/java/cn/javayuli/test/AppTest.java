package cn.javayuli.test;

import cn.javayuli.cloud.auth.YuLiAuthApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {YuLiAuthApplication.class})
public class AppTest {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    public void genPassword() {
        System.out.println(passwordEncoder.encode("123456"));
    }
}
