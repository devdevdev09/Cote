package exam.s0915_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TestCase {
   String[] words;
   String[] queries; 
   int[] result;
}

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        TestCase tc1 = new TestCase();
        tc1.words = new String[]{"frodo", "fron", "frost", "frozen", "frame", "kakao"};
        tc1.queries = new String[]{"fro??", "????o", "fr???", "fro???", "pro?"};
        tc1.result = new int[]{3, 2, 4, 1, 0};

        List<TestCase> testList = new ArrayList<>();
        testList.add(tc1);

        for(TestCase tc : testList){
            int[] result = sol.solution(tc.words, tc.queries);

            if(Arrays.equals(result, tc.result)){
                System.out.println("success");
            }else{
                System.out.println("fail");
            }
        }
    }

    public int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for(int i = 0; i < queries.length; i++){
            String query = queries[i];
            int cnt = 0;
            // int first = query.indexOf("?");
            // int last = query.lastIndexOf("?");
            
            // int position = (first > 0) ? 1 : -1;

            for(int j = 0 ; j < words.length; j++){
                String word = words[i];
                if(query.length() != word.length()) break;

                if(query.equals(word)){ // todo::상세 비교
                    cnt++;
                }

            }
            answer[i] = cnt;
            cnt = 0;
        }

        return answer;
    }
}
