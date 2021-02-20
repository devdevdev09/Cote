package com.exam;

public class Solution0828 {

    public String solution(String p){
        String answer = "";

        if(p.equals("")){
            return "";
        }

        if(isCorrect(p)){
            return p;
        }

        answer = testAll(p);

        return answer;
    }

    public String testAll(String p){
        if(p.equals("")){
            return "";
        }

        String[] sArr = splitUV(p);
        
        String u = sArr[0];
        String v = sArr[1];

        if(isCorrect(u)){
            return u + testAll(v);
        }else{
            return "(" + testAll(v)+ ")" +  fn3(u);
        }
    }

    public boolean isCorrect(String s){        
        int left = 0;
        int right = 0;

        for(char c : s.toCharArray()){
            if(c == '(') left++;
            if(c == ')') right++;

            if(right > left){
                return false;
            }
        }
        return true;
    }

    public String[] splitUV(String s){
        int left = 0;
        int right = 0;
        int idx = 0;
        String[] result = new String[2];
        
        for(char c : s.toCharArray()){
            if(c == '(') left++;
            if(c == ')') right++;
            
            idx++;

            if(left == right && left > 0){
                result[0] = s.substring(0,idx);
                result[1] = s.substring(idx);
                return result;
            }
        }
        
        return result;
    }

    public String fn3(String s){
        int len = s.length();

        String str = s.substring(1, len-1);
        String revers = "";

        for(char c : str.toCharArray()){
            char tmp;
            if(c == '('){
                tmp = ')';
            }else{
                tmp = '(';
            }
            revers += Character.toString(tmp);
        }

        return revers;
    }

    public String revers(String s){
        char[] a = s.toCharArray();
        String temp = "";
        
        for(int i = a.length; i > 0; i--){
            temp += Character.toString(a[i]);
        }

        return temp;
    }
}