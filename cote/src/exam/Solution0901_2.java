package exam;

import java.util.ArrayList;
import java.util.List;

public class Solution0901_2 {

    public static void main(String[] args) {
        Solution0901_2 solution = new Solution0901_2();
        solution.solution("abcabcdede");
    }

    public int solution(String s){
        int min = 1000;

        for(int i = 1 ; i < s.length(); i++){
            String[] arr = getArrByNum(s, i);    
            int cnt = getPressCount(arr);

            if(min > cnt && cnt > 0){
                min = cnt;
            }
        }

        return min;
    }

    public int getPressCount(String[] arr){
        String temp = "";
        int cnt = 1;
        String result = "";
        
        for(int i = 1; i < arr.length; i++){
            temp = arr[i-1];
            if(temp.equals(arr[i])){
                cnt++;
                result += Integer.toString(cnt) + arr[i];
            }else{
                result += Integer.toString(cnt) + arr[i]; 
                cnt = 1;
            }

            // if(i+1 == arr.length-1){
            //     if(temp.equals(arr[i+1])){
            //         result += Integer.toString(cnt) + arr[i]; 
            //     }else{
            //        result += Integer.toString(1) + arr[i+1]; 
            //     }
            // }
        }

        int count = result.replaceAll("1", "").length();

        return count;
    }

    public String[] getArrByNum(String s, int num){
        List<String> list = new ArrayList<String>();

        int start = 0;
        int end = 0;

        while(true){
            end = start + num;
            if(start > s.length()){
                break;
            }

            if(end > s.length()){
                list.add(s.substring(start));    
                break;
            }
            
            list.add(s.substring(start, start+num));
            start += num;
        }

        return list.toArray(new String[list.size()]);
    }
    
}