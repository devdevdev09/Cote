package com.exam.s0915_2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

        String s = String.join(",", tc1.words);
        s = "," + s;

        int idx = 0;

        int[] answer = new int[tc1.queries.length];
        for(String query : tc1.queries){
            int first = query.indexOf("?");
            int last = query.lastIndexOf("?");
            int term = last + 1 -first;
            String str = query.replaceAll("\\?", "");

            String temp = "";
            if(first > 0){
                temp = s.replaceAll(str + "[a-z]{" + term + "}","1");
            }else{
                temp = s.replaceAll("[a-z]{" + term + "}" + str,"1");
            }
            
            answer[idx++] = (int)Arrays.stream(temp.split(",")).filter(st->st.length()==1).count();
        }
        
        System.out.println(s);
        //testList.add(tc1);

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
        List<String> list = new ArrayList<String>(Arrays.asList(queries));
        Integer[] arr = list.parallelStream().map(s->match2(s,words)).toArray(Integer[]::new);

        return Arrays.stream(arr).mapToInt(i->i).toArray();
    }

    Map<String, Integer> map = new HashMap<String, Integer>();
    public int match2(String query, String[] words){
        if(map.containsKey(query)){return map.get(query);}    
        int cnt = 0;
        String s1 = query.replaceAll("\\?", "");
        int qLen = query.length();
        
        String[] a = Arrays.stream(words).filter(s->qLen == s.length()).toArray(String[]::new);

        Pattern pattern = Pattern.compile("[a-z]{1," + qLen + "}");
        
        for(String word : a){
            Matcher matcher = pattern.matcher(word);
            if(s1.equals("")){
                cnt = a.length;
                break;
            }

            if(matcher.matches()){
                cnt++;
            }
            // if(matchTest(word, s1, first, last)){
            //     cnt++;
            // }
        }

        map.put(query, cnt);

        return cnt;
    }

    public boolean matchTest(String s2, String s1, int first, int last){
        if(first > 0){
            s2 = s2.subSequence(0, first).toString();
        }else{
            s2 = s2.subSequence(last+1, s2.length()).toString();
        }
        
        return s1.equals(s2);
    }
    
}
