package com.exam.s0917_X;

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

    public int solution(String s)
    {
        int answer = 1;

        String tmp = s;
        while(answer > 0){
            tmp = getString(tmp);
            if(tmp.equals("")){
                return 1;
            }

            if(s.equals(tmp)){
                return 0;
            }

            answer = tmp.length();
        }

        if(s.length() == 0){
            return 1;
        }

        return 0;
    }

    public String getString(String s){

        for(int i = 0 ; i < s.toCharArray().length-1; i++){
            if(s.charAt(i) == s.charAt(i+1)){
                return s.substring(0, i) + s.substring(i+2);
            }
        }

        return s;
    }
}
