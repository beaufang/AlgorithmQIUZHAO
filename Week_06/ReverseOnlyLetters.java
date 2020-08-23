package com.beau.leetcode.week6;

import org.junit.Test;

/**
 * @author BeauFang
 * Date: 2020/8/20
 * 917 https://leetcode-cn.com/problems/reverse-only-letters/
 */
public class ReverseOnlyLetters {


    public String reverseOnlyLetters(String S) {
        char[] chs = S.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (!Character.isLetter(chs[i])) {
                i++;
            } else if (!Character.isLetter(chs[j])) {
                j--;
            } else {
                char temp = chs[i];
                chs[i++] = chs[j];
                chs[j--] = temp;
            }
        }
        return new String(chs);
    }



    public String reverseOnlyLetters2(String S) {
        char[] chs = S.toCharArray();
        int i = 0, j = chs.length - 1;
        while (i < j) {
            if (!((chs[i] >= 65 && chs[i] <= 90) || (chs[i] >= 97 && chs[i] <= 122))) {
                i++;
            } else if (!((chs[j] >= 65 && chs[j] <= 90) || (chs[j] >= 97 && chs[j] <= 122))) {
                j--;
            } else {
                char temp = chs[i];
                chs[i++] = chs[j];
                chs[j--] = temp;
            }
        }
        return new String(chs);
    }

    @Test
    public void test() {
        System.out.println(reverseOnlyLetters("a-bC-dEf-ghIj"));
        System.out.println(reverseOnlyLetters("Test1ng-Leet=code-Q!"));
        System.out.println(reverseOnlyLetters("7_28]"));
    }

    @Test
    public void test2() {
        System.out.println((int)'_');
        System.out.println((int)']');
        System.out.println((int)'a');
        System.out.println((int)'z');
        System.out.println((int)'A');
        System.out.println((int)'Z');
    }

}
