package com.exam;

import java.util.ArrayList;
import java.util.List;

public class Solution0901 {
    public static void main(String[] args) {
        Solution0901 solution0901 = new Solution0901();
        solution0901.solution("TOBEORNOTTOBE");
    }

    public int[] solution(String msg){
        List<Integer> resultList = new ArrayList<>();
        List indexList = new ArrayList<>();
        indexList = init(indexList);
        String str = msg;

        while(true){
            String w = getW(str, indexList);
            String c = getC(str, w);
            str = str.substring(str.indexOf(w) + w.length());

            resultList.add(indexList.indexOf(w)+1);
            
            if("".equals(c)){
                break;
            }else{
                indexList.add(w+c);
            }
        }

        int[] answer = toArray(resultList);
        return answer;
    }

    public int[] toArray(List<Integer> list){
        // int[] arr = new int[list.size()];
        // int idx = 0;
        
        // for(Integer num : list){
        //     arr[idx++] = num;
        // }

        //return list.toArray(new int[list.size()]);
        return list.stream().mapToInt(i->i).toArray();
    }

    public List init(List list){
        for(char i = 'A' ; i <= 'Z'; i++){
            list.add(i + "");
        }

        return list;
    }

    public String getW(String msg, List indexList){
        String result = "";

        for(int i = msg.length(); i > 0; i--){
            String temp = msg.substring(0, i);
            if(indexList.indexOf(temp) > -1){
                result = temp;
                break;
            }
        }

        return result;
    }

    public String getC(String msg, String w){
        if(msg.length() == w.length()){
            return "";
        }

        int idx = msg.indexOf(w) + w.length();
        return msg.substring(idx,idx+1);
    }

}