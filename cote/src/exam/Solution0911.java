package exam;

import java.util.ArrayList;
import java.util.List;

public class Solution0911 {
    public static void main(String[] args) {
        List<Testcase> testList = new ArrayList<Testcase>();
        Testcase tc1 = new Testcase(5, new int[]{2, 1, 2, 6, 2, 4, 3, 3},new int[]{3,4,2,1,5});
        Testcase tc2 = new Testcase(4, new int[]{4,4,4,4,4},new int[]{4,1,2,3});

        testList.add(tc1);
        testList.add(tc2);

        Solution0911 solution = new Solution0911();
    }

    public int[] solution(int N, int[] stages){
        int[] answer = {};
        return answer;
    }
}

class Testcase{
    int N;
    int[] stages;
    int[] result;

    public Testcase(int N, int[] stages, int[] result){
        this.N = N;
        this.stages = stages;
        this.result = result;
    }
}
