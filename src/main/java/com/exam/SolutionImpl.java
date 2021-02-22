package com.exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class SolutionImpl implements Solution{

    @Override
    public void test() {
        test1(new int[]{1,2,3}, "test");
        test1(new int[]{1,2,3}, "test", 3);

        List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.forEach(i->{
            System.out.println("i :" + i);
        });

        list.forEach(System.out::println);

        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(0, "one");
        map.put(1, "two");

        map.forEach((k,v)->{
            System.out.println(k + " : " + v);
        });

        int[] arr = {1,2,3};
        Arrays.stream(arr).forEach(i->{
            System.out.println(" i : " + i);
        });
        
    }

    @Override
    public void solution() {
        Solv sov = new Solv();
        int[] scovile = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int result = 2;
        int exp = sov.solution(scovile, k);
        if( result == exp){
            System.out.println("success : " + exp);
        }else{
            System.out.println("fail : " + exp);
        }

    }

    @Override
    public void test1(Object... args) {
        // TODO Auto-generated method stub

    }
}

class Solv {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue<Integer> list = new PriorityQueue<>();

        for(int n : scoville){
            list.add(n);
        }
        
        while(!list.isEmpty()){
            ++answer;

            int num1 = list.poll();
            int num2 = list.poll();

            int sum = num1 + (num2*2);
            list.add(sum);

            if(list.peek() >= K){
                return answer;
            }

            if(list.size() == 1 && list.peek() < K){
                return -1;
            }
        }
        return answer;
    }
    
}
