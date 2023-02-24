package com.github.yck.pattern.prototype.shallowcopping;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

public class ShallowCopyTestTest {
    Person p1;
    Person dolly;
    @BeforeEach
    public void prepare() {
        Address address = new Address("TJ",
                new HashMap<String, String>() {{
                    put("located", "China");
                    put("food", "salty");
                }});
        p1 = new Person("yck",
                18,'M',address,new int[]{1,2,3}
        );

        try {
            dolly = (Person) p1.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Test
    @DisplayName("得出各个成员变量的 Hashcode，证明指向统一地址")
    public void test1() throws CloneNotSupportedException {

        assertAll("测试不同数据类型",
                // 字符串
                () -> assertSame(dolly.getName(), p1.getName(), "String 类型指向的统一数据类型"),

                () -> assertSame("yck", "yck", "这里源代码直接近常量池"),
                () -> assertNotSame("yck", new String("yck"), "只要是 new 的就不一样"),
                () -> assertNotSame(new String("yck"), new String("yck"), "只要是 new 的就不一样"),
                () -> assertNotSame(new String("yck"), new String("yck"), "只要是 new 的就不一样"),

                () -> assertNotSame(dolly.getName(), new String("yck"), "证明两个值一样的 String 是两个对象"),
                () -> assertSame(dolly.getName().intern(), "yck", "intern() 后肯定一样"),
                // Address
                () -> assertSame(dolly.getAddress(), p1.getAddress(), "Address 一样"),
                () -> assertSame(dolly.getAge(), p1.getAge(), "Integer 一样")
        );
    }
    @Test
    @DisplayName("改变p1的Address，dolly 也会改变，这就是浅拷贝的问题")
    public void test2(){
        assertAll("P1修改之前",
                () -> assertEquals(dolly.getName(),"yck","姓名"),
                () ->assertEquals(dolly.getAge(),18,"年龄"),
                () ->assertEquals(dolly.getSex(),'M',"性别"),

                () ->assertEquals(dolly.getAddress().getAddressName(),"TJ","注意，" +
                        "等于TJ")

        );
        p1.setName("wsn");
        p1.setAge(15);
        p1.setSex('F');
        p1.getAddress().setAddressName("Canada");

        assertAll("P1修改之后，基本数据类型与包装类都不影响，但是类影响了",
                () -> assertEquals(dolly.getName(),"yck","姓名"),
                () ->assertEquals(dolly.getAge(),18,"年龄"),
                () ->assertEquals(dolly.getSex(),'M',"性别"),

                () ->assertNotEquals(dolly.getAddress().getAddressName(),"TJ","注意，" +
                        "不等于TJ了"),
                () ->assertEquals(dolly.getAddress().getAddressName(),"Canada","注意，" +
                        "等于 Canada 了")
        );


    }
}