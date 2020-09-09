package exam;

import java.util.ArrayList;
import java.util.List;

public class Solution0901_2 {

// 제한사항
// s의 길이는 1 이상 1,000 이하입니다.
// s는 알파벳 소문자로만 이루어져 있습니다.

// "aabbaccc"	7
// "ababcdcdababcdcd"	9
// "abcabcdede"	8
// "abcabcabcabcdededededede"	14
// "xababcdcdababcdcd"	17

    public static void main(String[] args) {
        Solution0901_2 solution = new Solution0901_2();

        String str = "xababcdcdababcdcd";
        int result = solution.solution(str);
        System.out.println(str + " : result = " + result);
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

    // len : 5, i=[0,1,2,3,4] > i=3,
    // ex a,b,c,d,d => 1a1b1c2d
    // ex a,b,c,d,d,e => 1a1b1c2d1e

    public int getPressCount(String[] arr){
        String temp = "";
        int cnt = 1;
        String result = "";
        
        for(int i = 0; i < arr.length-1; i++){
           if(arr[i].equals(arr[i+1])){
                cnt++;
           }else{
                result += Integer.toString(cnt) + arr[i];
                cnt = 1;
           }

           if(i+1 == arr.length-1){
                if(arr[i].equals(arr[i+1])){
                    result += Integer.toString(cnt+1) + arr[i];
                }else{
                    result += Integer.toString(cnt) + arr[i+1];
                }
           }
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
                if(!"".equals(s.substring(start))){
                    list.add(s.substring(start));    
                }
                break;
            }
            
            list.add(s.substring(start, start+num));
            start += num;
        }

        return list.toArray(new String[list.size()]);
    }
}