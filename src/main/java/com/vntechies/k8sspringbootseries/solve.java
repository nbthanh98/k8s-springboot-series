package com.vntechies.k8sspringbootseries;

import java.util.*;
import java.util.stream.Collectors;

public class solve {

//    public static void main(String[] args) {
//        sol(14);
//        sol(10);
//        sol(99);
//    }
//
//    public static int sol(int N) {
//        int sum = sumNumbers(N);
//        int tempNum = N;
//        while (sumNumbers(tempNum) != (2 * sum)) {
//            tempNum = N += 1;
//        }
//        System.out.println(tempNum);
//        return tempNum;
//    }
//
//    private static int sumNumbers(int number) {
//        int sum = 0;
//        while (number != 0) {
//            int lastNum = number % 10;
//            sum += lastNum;
//            number = number / 10;
//        }
//        return sum;
//    }

    public static void main(String[] args) {
        System.out.println(sol(new int[]{1, 3, 2, 1}, new int[]{4, 2, 5, 3, 2}));
        System.out.println(solution(new int[]{2, 1}, new int[]{3, 3}));
    }

    public static int solution(int[] A, int[] B) {
        Set<Integer> seen = new HashSet<>();
        for (int num : A) {
            seen.add(num);
        }
        int min = Integer.MAX_VALUE;
        for (int num : B) {
            if (seen.contains(num) && num < min) {
                min = num;
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private static int sol(int[] a, int[] b) {
        List<Integer> numsArrA = Arrays.stream(a).boxed().collect(Collectors.toList());
        List<Integer> numsArrB = Arrays.stream(b).boxed().collect(Collectors.toList());

        return numsArrA.size() >= numsArrB.size()
                ? findNum(numsArrA, numsArrB)
                : findNum(numsArrB, numsArrA);
    }

    private static int findNum(List<Integer> arrLargeLength, List<Integer> arrSmallLength) {
        Collections.sort(arrSmallLength);
        for (Integer numOfArrSmallLength : arrSmallLength) {
            if (arrLargeLength.contains(numOfArrSmallLength)) {
                return numOfArrSmallLength;
            }
        }
        return -1;
    }
}
