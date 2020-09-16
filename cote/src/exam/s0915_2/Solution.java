package exam.s0915_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TestCase {
   String[] words;
   String[] queries; 
   int[] result;
}

public class Solution {
    public static void main(String[] args) {
        Solution sol = new Solution();

        TestCase tc1 = new TestCase();
        tc1.words = new String[]{"frodo", "front", "frost", "frozen", "frame", "kakao"};
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
        Map<String,Object> map = new HashMap<String,Object>();
        List<String> list = new ArrayList<String>(Arrays.asList(queries));
        Arrays.sort(words);
        Integer[] arr = list.parallelStream().map(s->match2(s,words, map)).toArray(Integer[]::new);

        return Arrays.stream(arr).mapToInt(i->i).toArray();
    }

    public int match2(String query, String[] words, Map<String, Object> map){
        if(map.containsKey(query)){return (int)map.get(query);}
        int first = query.indexOf("?");
        int last = query.lastIndexOf("?");
        int cnt = 0;
        String s1 = query.replaceAll("\\?", "");

        for(int i = 0; i < words.length; i++){
            if(query.length() != words[i].length()) continue;
            if(matchTest(words[i], s1, first, last)){
                cnt++;
            }
        }

        map.put(query, cnt);

        return cnt;
    }

    public boolean matchTest(String s2, String s1, int first, int last){
        if(first > 0){
            s2 = s2.substring(0, first);
        }else{
            s2 = s2.substring(last+1);
        }
        
        return s1.equals(s2);
    }
    
}
