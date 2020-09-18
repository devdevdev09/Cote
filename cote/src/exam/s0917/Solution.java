package exam.s0917;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String[] s = {"cdcd","baabaa"};
        int[] a = {0,1};
        
        Solution sol = new Solution();
        int idx = 0;

        for(String str : s){
            int result = 0;
            result = sol.solution(str);
            
            if(result == a[idx++]){
                System.out.println(idx + " : success");
            }else{
                System.out.println(idx + " : fail");
            }
        }
    }

    public int solution(String s) {
        String[] sArr = Arrays.stream(s.split("")).distinct().toArray(String[]::new);

        String tmp = s;
        while(!tmp.equals("")) {
            String pre = "";

            for(int i = 0; i < sArr.length; i++) {
                pre = tmp;
                tmp = pre.replaceAll("[" + sArr[i] + "]{2}", "");
                if(tmp.length() == 0) return 1;
            }
            if(pre.equals(tmp)) return 0;
            if(tmp.equals(s)) return 0;
        }

        if(tmp.length() == 0) return 1;
        else return 0;
    }
}
