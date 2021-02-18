package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.stream.Collectors;

public class SolutionImpl implements Solution{

    @Override
    public void test() {


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
}

class Solv {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        
        Queue list = new PriorityQueue<>();

        for(int n : scoville){
            list.add(n);
        }
        
        while(!list.isEmpty()){
            ++answer;

            int num1 = (int)list.poll();
            int num2 = (int)list.poll();

            int sum = num1 + (num2*2);
            list.add(sum);

            if((int)list.peek() >= K){
                return answer;
            }

            if(list.size() == 1 && (int)list.peek() < K){
                return -1;
            }
        }
        return answer;
    }
    
}
