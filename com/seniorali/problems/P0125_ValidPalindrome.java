package com.seniorali.problems;

/**
 * Problem: <a href="https://leetcode.com/problems/valid-palindrome/">125. Valid Palindrome</a><br/>
 * Difficulty: {@code Two Pointers} {@code String}
 * <p>
 * Topics: {@code Array}, {@code Math}, {@code Dynamic Programming}, {@code Prefix Sum}, {@code Game Theory}
 */
public class P0125_ValidPalindrome {
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            if (leftChar >= 'A' && leftChar <= 'Z') {
                leftChar = (char) (leftChar + 32);
            }
            if (!((leftChar >= 'a' && leftChar <= 'z') || (leftChar >= '0' && leftChar <= '9'))) {
                left++;
                continue;
            }

            char rightChar = s.charAt(right);
            if (rightChar >= 'A' && rightChar <= 'Z') {
                rightChar = (char) (rightChar + 32);
            } else if (!((rightChar >= 'a' && rightChar <= 'z') || (rightChar >= '0' && rightChar <= '9'))) {
                right--;
                continue;
            }

            if (rightChar != leftChar) return false;

            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("0P"));

        char a = 'A';
        char lower = (char) (a + 32);
        System.out.println(lower);
    }
}
