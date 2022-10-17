package cn.soft.engine.study.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 一个测试用的bean
 */
@Component("myBean")
public class TestBean {

    private int counter;

    @Value("${greeting}")
    private String say;

    public String saySomething(String body) {
        return String.format("%s I am invoked %d times", say, ++counter);
    }
}
