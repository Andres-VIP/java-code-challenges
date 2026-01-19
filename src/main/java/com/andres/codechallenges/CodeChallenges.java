package com.andres.codechallenges;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CodeChallenges {

    /*
     * Challenge: Calculate the sum of all even numbers in a list of integers.
     * Time Complexity: O(n)
     */
    public static int sumEvenNumbers(List<Integer> list) {
        return list.stream()
                .filter(n -> n % 2 == 0)
                .mapToInt(Integer::intValue)
                .sum();
    }

    /*
     * Challenge: Convert all strings in a list to uppercase.
     * Time Complexity: O(n)
     */
    public static List<String> toUpperCase(List<String> list) {
        return list.stream()
                .map(String::toUpperCase)
                .toList();
    }

    /*
     * Challenge: Remove duplicate elements from a list of integers.
     * Time Complexity: O(n)
     */
    public static List<Integer> removeDuplicates(List<Integer> list) {
        return list.stream()
                .distinct()
                .toList();
    }

    /*
     * Challenge: Find the second largest number in a list.
     * Time Complexity: O(n)
     */
    public static int findSecondLargest(List<Integer> list) {
        Set<Integer> distinct = new LinkedHashSet<>(list);
        if (distinct.size() < 2) {
            throw new IllegalArgumentException("List must contain at least two distinct values");
        }
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : distinct) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second) {
                second = num;
            }
        }
        return second;
    }

    /*
     * Challenge: Check if a string is a palindrome.
     * Time Complexity: O(n)
     */
    public static boolean isPalindrome(String value) {
        String normalized = value.toLowerCase().replaceAll("\\s+", "");
        return IntStream.range(0, normalized.length() / 2)
                .allMatch(i -> normalized.charAt(i) == normalized.charAt(normalized.length() - 1 - i));
    }

    /*
     * Challenge: Calculate the sum of digits of an integer.
     * Time Complexity: O(d)
     */
    public static int sumDigits(int number) {
        return String.valueOf(Math.abs(number))
                .chars()
                .map(Character::getNumericValue)
                .sum();
    }

    /*
     * Challenge: Calculate factorial of a number.
     * Time Complexity: O(n)
     */
    public static long factorial(int n) {
        long result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }

    /*
     * Challenge: Calculate the nth Fibonacci number (iterative).
     * Time Complexity: O(n)
     */
    public static long fibonacci(int n) {
        long a = 0, b = 1;
        for (int i = 0; i < n; i++) {
            long temp = a;
            a = b;
            b = temp + b;
        }
        return a;
    }

    /*
     * Challenge: Return all prime numbers up to n.
     * Time Complexity: O(n * sqrt(n))
     */
    public static List<Integer> primesUpTo(int n) {
        return java.util.stream.IntStream.rangeClosed(2, n)
                .filter(i -> java.util.stream.IntStream.rangeClosed(2, (int) Math.sqrt(i))
                        .allMatch(j -> i % j != 0))
                .boxed()
                .toList();
    }

    /*
     * Challenge: Calculate the greatest common divisor (GCD).
     * Time Complexity: O(log n)
     */
    public static int gcd(int a, int b) {
        return b == 0 ? Math.abs(a) : gcd(b, a % b);
    }

    /*
     * Challenge: Find the intersection of two lists.
     * Time Complexity: O(n + m)
     */
    public static List<Integer> intersection(List<Integer> a, List<Integer> b) {
        Set<Integer> set = new HashSet<>(a);
        return b.stream()
                .filter(set::contains)
                .distinct()
                .toList();
    }

    /*
     * Challenge: Count character occurrences in a string.
     * Time Complexity: O(n)
     */
    public static Map<Character, Long> countCharacters(String value) {
        return value.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    /*
     * Challenge: Check if two strings are anagrams.
     * Time Complexity: O(n log n)
     */
    public static boolean areAnagrams(String a, String b) {
        char[] x = a.toCharArray();
        char[] y = b.toCharArray();
        Arrays.sort(x);
        Arrays.sort(y);
        return Arrays.equals(x, y);
    }

    /*
     * Challenge: Binary search in a sorted list.
     * Time Complexity: O(log n)
     */
    public static int binarySearch(List<Integer> list, int target) {
        int left = 0, right = list.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (list.get(mid) == target) return mid;
            if (list.get(mid) < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

    /*
     * Challenge: Sort strings by length.
     * Time Complexity: O(n log n)
     */
    public static List<String> sortByLength(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    /*
     * Challenge: Find the longest string in a list.
     * Time Complexity: O(n)
     */
    public static String longestString(List<String> list) {
        return list.stream()
                .max(Comparator.comparingInt(String::length))
                .orElse("");
    }

    /*
     * Challenge: Reverse a list of integers.
     * Time Complexity: O(n)
     */
    public static List<Integer> reverseList(List<Integer> list) {
        return IntStream.range(0, list.size())
                .mapToObj(i -> list.get(list.size() - 1 - i))
                .toList();
    }

    /*
     * Challenge: Calculate the average of a list of integers.
     * Time Complexity: O(n)
     */
    public static double average(List<Integer> list) {
        return list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0);
    }

    /*
     * Challenge: Find the missing number from 1 to n.
     * Time Complexity: O(n)
     */
    public static int findMissingNumber(List<Integer> list, int n) {
        int expectedSum = n * (n + 1) / 2;
        int actualSum = list.stream().mapToInt(Integer::intValue).sum();
        return expectedSum - actualSum;
    }

    /*
     * Challenge: Find the first non-repeating character in a string.
     * Time Complexity: O(n)
     */
    public static Character firstNonRepeatingCharacter(String value) {
        Map<Character, Long> charCount = value.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        return charCount.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .findFirst()
                .orElse(null);
    }

    /*
     * Challenge: Find pairs of numbers in a list that sum to a target value.
     * Time Complexity: O(n)
     */
    public static List<List<Integer>> findPairsThatSum(List<Integer> list, int target) {
        Set<Integer> seen = new HashSet<>();
        return list.stream()
                .filter(num -> {
                    int complement = target - num;
                    if (seen.contains(complement)) {
                        return true;
                    }
                    seen.add(num);
                    return false;
                })
                .map(num -> List.of(target - num, num))
                .toList();
    }

    /*
     * Challenge: Group strings by their length.
     * Time Complexity: O(n)
     */
    public static Map<Integer, List<String>> groupStringsByLength(List<String> list) {
        return list.stream()
                .collect(Collectors.groupingBy(String::length));
    }

    /*
     * Challenge: Check if a number is prime.
     * Time Complexity: O(sqrt(n))
     */
    public static boolean isPrime(int n) {
        if (n < 2) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        return IntStream.rangeClosed(3, (int) Math.sqrt(n))
                .filter(i -> i % 2 != 0)
                .noneMatch(i -> n % i == 0);
    }

    /*
     * Challenge: Find the most frequent element in a list of integers.
     * Time Complexity: O(n)
     */
    public static int findMostFrequentElement(List<Integer> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List cannot be empty");
        }
        return list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.<Integer, Long>comparingByValue()
                        .thenComparing(Map.Entry.comparingByKey()))
                .map(Map.Entry::getKey)
                .orElseThrow();
    }
}