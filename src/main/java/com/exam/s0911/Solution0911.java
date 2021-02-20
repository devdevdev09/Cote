package com.exam.s0911;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution0911 {
    public static void main(String[] args) {
        List<Testcase> testList = new ArrayList<Testcase>();
        Testcase tc1 = new Testcase(
                                5, 
                                new int[]{2, 1, 2, 6, 2, 4, 3, 3},
                                new int[]{3, 4, 2, 1, 5}
                            );

        Testcase tc2 = new Testcase(
                                1, 
                                new int[]{2},
                                new int[]{4, 1, 2, 3}
                            );

        testList.add(tc1);
        testList.add(tc2);

        Solution0911 solution = new Solution0911();
        for(Testcase tc : testList){
            int[] result = solution.solution(tc.N, tc.stages);
            if(Arrays.equals(tc.result, result)){
                System.out.println("정답");
            }else{
                System.out.println("오답");
            }
        }
        

    }

    public int[] solution(int N, int[] stages){
        int[] answer = new int[N];
        int[] temp = new int[N];

        for(int num : stages){
            if(num > N) continue;
            temp[num-1] += 1;
        }

        Double[] percent = new Double[N];
        int index = 0;
        int pare = stages.length;

        for(int num : temp){
            percent[index++] = getPercent(num, pare);
            pare -= num;
        }

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        
        for(int i = 0; i < N; i++){
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("stage", i+1);
            map.put("data", percent[i]);
            list.add(map);
        }

        Collections.sort(list, new Comparator<Map<String,Object>>(){

            @Override
            public int compare(Map<String, Object> o1, Map<String, Object> o2) {
                double d1 = (double)o1.get("data");
                double d2 = (double)o2.get("data");

                return d1 == d2 ? 
                (int)o1.get("stage") - (int)o2.get("stage")
                : d1 - d2 > 0 ? -1 : 1;
            }
        });

        index = 0;
        for(Map<String,Object> obj : list){
            answer[index++] = (int)obj.get("stage");
        }

        return answer;
    }

    public double getPercent(int num1, int num2){
        if(num2 == 0) return 0.0;
        double d1 = Double.valueOf(num1);
        double d2 = Double.valueOf(num2);
        
        double per = d1/d2;

        return per;
    }
}

class Testcase{
    int N;
    int[] stages;
    int[] result;

    public Testcase(final int N, final int[] stages, final int[] result){
        this.N = N;
        this.stages = stages;
        this.result = result;
    }
}
