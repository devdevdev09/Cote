package com.exam;

public class Solution0901_2 {

    public static void main(String[] args) {
        Solution0901_2 solution = new Solution0901_2();

        String[][] tcArr = {
            {"ababcdcdababcdcd", "9"},
            {"aabbaccc", "7"},
            {"abcabcdede", "8"},
            {"abcabcabcabcdededededede", "14"},
            {"xababcdcdababcdcd", "17"}
        };

        double cnt = 0;
        double correct = 0;
        double incorrect = 0;

        for(String[] tc : tcArr){
            cnt++;

            String input  = tc[0];
            int    output = Integer.parseInt(tc[1]);
            
            int    result       = solution.solution(input);
            String resultString = "input : " + input + ", output : " + result + ", result : " + output;
            
            if(result == output){
                correct++;
            }else{
                incorrect++;
                System.out.print(resultString);
                System.out.println("\tincorrect");
            }
        }

        System.out.printf("\n수행 : %d, 정답 : %d/%d(%.2f%%)", (int)cnt, (int)correct,(int)cnt, correct/cnt*100);
    }

    public int solution(String s){
        if(s.length() == 1) return 1;
        int min = 9999;

        for(int i = 1 ; i < s.length(); i++){
            int cnt = getPressCount(s,0,1,i,1).length();

            if(min > cnt) min = cnt;
        }

        return min;
    }

    public String getPressCount(String str, int peek, int next, int devide, int count){
        int currend = (peek*devide + devide > str.length()) ? str.length() : peek*devide + devide;
        String currStr = str.substring(peek*devide, currend);
        
        if(next > str.length()/devide){
            return String.valueOf(count == 1 ? "" : count) + currStr;
        }else{
            int nextEnd = (peek*devide + 2*devide > str.length())? str.length() :peek*devide + 2*devide;
            String nextStr = str.substring(peek*devide + devide, nextEnd);
            if(currStr.equals(nextStr)){
                return getPressCount(str, ++peek, ++next, devide, ++count);
            }else{
                return String.valueOf(count == 1 ? "" : count) + currStr + getPressCount(str, ++peek, ++next, devide, 1);
            }
        }
    }

    public int getPressCount(String[] arr, int peek, int next){
        int cnt = 1;
        String result = "";
        
        for(int i = 0; i < arr.length-1; i++){
           if(arr[i].equals(arr[i+1])){
                cnt++;
           }else{
                result += (cnt == 1) ? arr[i] : Integer.toString(cnt) + arr[i];
                cnt = 1;
           }

           if(i+1 == arr.length-1){
                if(arr[i].equals(arr[i+1])){
                    result += Integer.toString(cnt) + arr[i];
                }else{
                    result += (cnt == 1) ? arr[i+1] : Integer.toString(cnt) + arr[i+1];
                }
           }
        }

        return result.length();
    }

    public String[] getArrByNum(String s, int num){
        int SIZE = 0;
        int len = s.length();

        SIZE = (len%num == 0) ? len/num : len/num + 1;

        String[] result = new String[SIZE];

        for(int i = 0 ; i < result.length; i++){
            int start = i*num;
            
            if(i == result.length - 1){
                result[i] = s.substring(start);    
            }else{
                int end = start + num;
                result[i] = s.substring(start, end);
            }

        }

        return result;
    }
}