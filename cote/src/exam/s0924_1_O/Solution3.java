package exam.s0924_1_O;

import java.util.ArrayList;
import java.util.List;

public class Solution3 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        // 2	10	[7,4,5,6]	                    8
        // 100	100	[10]	                        101
        // 100	100	[10,10,10,10,10,10,10,10,10,10]	110
        
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};
        int result = 8;

        if(result == sol.solution(bridge_length, weight, truck_weights)){
            System.out.println("success");
        }else{
            System.out.println("fail");
        }
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
    }
}

class Bridge{
    int weight = 0;
    boolean isFull = false;
    List<Truck> list = new ArrayList<Truck>();
}

class Truck{
    final int SPEED = 1;

    boolean isEnd   = false;
    boolean isStart = false;
    int goal = 0;
    int weight = 0;
    int current = 0;

    public Truck(int goal, int weight){
        this.goal = goal;
        this.weight = weight;
    }

    public void move(){
        current += SPEED;
    }

    public boolean check(int goal){
        if(goal < current){
            return true;
        }else{
            return false;
        }
    }
}
