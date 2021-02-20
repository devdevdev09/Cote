package com.exam.s0924_1_O;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        // int[] numbers = {2, 1, 3, 4, 1};
        // int[] result = {2, 3, 4, 5, 6, 7};

        int[] numbers = {5, 0, 2, 7};
        int[] result = {2, 5, 7, 9, 12};

        Solution sol = new Solution();
        
        if(result.equals(sol.solution(numbers))){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }

    public int[] solution(int[] numbers) {
        List<Integer> result = new ArrayList<Integer>();

        for(int  i = 0 ; i < numbers.length - 1; i++){
            for(int j = i + 1; j < numbers.length; j++){
                if(i == j ) continue;
                int temp = numbers[i] + numbers[j];
                
                if(!result.contains(temp)){
                    result.add(temp);
                }
            }
        }

        Collections.sort(result);

        return result.stream().mapToInt(i->i).toArray();
    }
}
