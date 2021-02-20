package com.exam.s0924_1_O;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        int[][] priorities = {
            {2, 1, 3, 2},
            {1, 1, 9, 1, 1, 1}
        };
        
        int[] location = {2, 0};
        int[] result = {1, 5};;
        
        for(int i = 0 ; i < location.length; i++){
            int test = sol.solution(priorities[i], location[i]);
            if(result[i] == test){
                System.out.println("success");
            }else{
                System.out.println("fail : "+ test);
            }
        }
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());

        while(list.size() > 0){
            if(isTopPrior(list)){
                ++answer;
                list = pop(list);
                if(location == 0) break;
            }else{
                list = swap(list);
            }
            location = moveLocation(list, location);
        }

        return answer;
    }
    
    public int moveLocation(List<Integer> list, int location){
        location -= 1;
        if(location < 0) location = list.size() - 1;
        return location;
    }

    public List<Integer> swap(List<Integer> list){
        list.add(list.get(0));
        list.remove(0);

        return list;
    }

    public boolean isTopPrior(List<Integer> list){
        int first = list.get(0);

        for(int i = 1; i < list.size(); i++){
            if(first < list.get(i)){
                return false;
            }
        }
        return true;
    }

    public List<Integer> pop(List<Integer> list){
        list.remove(0);

        return list;
    }
}
