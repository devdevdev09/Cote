package com.exam.s0917;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] s = {"cdcd","baabaa"};
        int[] a = {0,1};
        
        Solution sol = new Solution();
        int idx = 0;

        for(String str : s){
            int result = 0;
            result = sol.solution(str);
            
            if(result == a[idx++]){
                System.out.println(idx + " : success");
            }else{
                System.out.println(idx + " : fail");
            }
        }
    }

    public int solution(String s) {
        int answer = 0;

        return answer;
    }
}
