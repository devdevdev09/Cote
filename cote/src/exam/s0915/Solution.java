package exam.s0915;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestCase{
    int n;
    int[] arr1;
    int[] arr2;
    String[] result;
}

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();
        List<TestCase> testList = new ArrayList<TestCase>();
        Integer.toBinaryString(10);
        TestCase tc1 = new TestCase();
        tc1.n = 5;
        tc1.arr1 = new int[]{0, 20, 28, 18, 11};
        tc1.arr2 = new int[]{0, 1, 21, 17, 28};
        tc1.result = new String[]{"#####","# # #", "### #", "#  ##", "#####"};

        TestCase tc2 = new TestCase();
        tc2.n = 6;
        tc2.arr1 = new int[]{0, 33, 33 ,22, 31, 50};
        tc2.arr2 = new int[]{27 ,56, 19, 14, 14, 10};
        tc2.result = new String[]{"######", "###  #", "##  ##", " #### ", " #####", "### # "};

        testList.add(tc1);
        testList.add(tc2);

        for(TestCase tc : testList){
            String[] result = sol.solution(tc.n, tc.arr1, tc.arr2);

            if(Arrays.equals(tc.result, result)){   
                System.out.println("정답");
            }else{
                System.out.println("오답");
            }
        }
    }

    public String[] solution(int n, int[] arr1, int[] arr2) {
        Solution sol = new Solution();
        String[] answer = new String[n];

        for(int i = 0; i < n; i++){
            String[] s1 = sol.toBinary(n, arr1[i]).split("");
            String[] s2 = sol.toBinary(n, arr2[i]).split("");

            String temp = "";
            
            for(int j = 0 ; j < n; j++){
                if(s1[j].equals("1") || s2[j].equals("1")){
                    temp += "#";
                }else{
                    temp += " ";
                }
            }

            answer[i] = temp;
            temp = "";
        }

        return answer;
    }

    public String toBinary(int n, int num){
        String s = Integer.toBinaryString(num);
        while(s.length() < n){
            s = "0" + s;
        }
        return s;
    }
}

