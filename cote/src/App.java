import exam.Solution;
import exam.Solution0828;
import exam.Solution0830;

public class App {
    public static void main(String[] args) throws Exception {
        // Solution sol = new Solution();
        // String dartResult = "1D*2S#10S";
        // sol.solution4(dartResult);

        
        // Solution0828 sol0828 = new Solution0828();
        // String result = "";
        // result = sol0828.solution("(()())()");
        // result = sol0828.solution(")(");
        // result = sol0828.solution("()))((()");
        // result = sol0828.solution("()))((");

        Solution0830 solution0830 = new Solution0830();
        
        int[] result = solution0830.solution("KAKAO");

        for(int num : result){
            System.out.print(" " + num);
        }
    }
}
