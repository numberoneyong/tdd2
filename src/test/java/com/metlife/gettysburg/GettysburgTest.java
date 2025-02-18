package com.metlife.gettysburg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class GettysburgTest {

    private String sample = "동해물과 백두산이 마르고 닳도록 하느님이 보우하사 우리나라 만세. 무궁화 삼천리 화려강산 대한 사람 대한으로 길이 보전하세.";

    private Wrapper wrapper;

    @BeforeEach
    void setUp() {
        wrapper = new Wrapper();
    }

    @Test
    void 문자열_길에_맞게_자르기() {
        assertWrapped("동해물과", 4, "동해물과");
    }

    @Test
    void 문자열_길에_맞게_자르기2() {
        assertWrapped("동해물과 백두산이", 7, "동해물과\n백두산이");
        assertWrapped("동해물과 백두산이", 6, "동해물과\n백두산이");
    }

    @Test
    void 문자열_길에_맞게_자르기3() {
        assertWrapped("동해물과 백두산이 마르고 닳도록", 9, "동해물과 백두산이\n마르고 닳도록");
        assertWrapped("동해물과 백두산이", 6, "동해물과\n백두산이");
    }

    @Test
    void 문자열_길이에_맞게_자르기_최종() {
        assertWrapped(sample, 15,
            "동해물과 백두산이 마르고\n닳도록 하느님이 보우하사\n우리나라 만세. 무궁화\n삼천리 화려강산 대한 사람\n대한으로 길이 보전하세.");
    }

    @Test
    void wrappingTest() {
        assertWrapped("x", 1, "x");
        assertWrapped("xx", 1, "x\nx");
        assertWrapped("xxx", 1, "x\nx\nx");
        assertWrapped("xxxx", 1, "x\nx\nx\nx");
    }

    @Test
    void wrappingTest2() {
        assertWrapped("x x", 1, "x\nx");
        assertWrapped("x x x", 1, "x\nx\nx");
        assertWrapped("x x x x", 1, "x\nx\nx\nx");
    }

    @Test
    void wrappingTest3() {
        assertWrapped("xx xx", 2, "xx\nxx");
        assertWrapped("xx xx", 3, "xx\nxx");
        assertWrapped("xx xx", 4, "xx\nxx");
        assertWrapped("xx xx", 5, "xx xx");
    }

    @Test
    void wrappingTest4() {
        assertWrapped("xxx xxx", 2, "xx\nx\nxx\nx");
        assertWrapped("xxx xxx xxx", 3, "xxx\nxxx\nxxx");
        assertWrapped("xxxx xxxx", 7, "xxxx\nxxxx");
        assertWrapped("xx xx", 5, "xx xx");
    }

    private void assertWrapped(String text, int width, String expected) {
        assertEquals(expected, wrapper.wrap(text, width));
    }
}
