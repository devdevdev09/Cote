package test1010;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test1010 {
    public static void main(String[] args) {
        String[] votes = {"test4", "test", "test2", "test3", "test", "test2"};
        int k = 2;

        Test1010 test = new Test1010();
        test.getCount(votes, k);
    }

    public List<Map<String, String>> getCount(String[] votes, int k){
        List<Map<String, String>> list = new ArrayList<Map<String, String>>();

        String[] arr = Arrays.stream(votes).distinct().toArray(String[]::new);

        for(String str : arr){
            Map<String, String> data = new HashMap<String,String>();

            int count = (int)Arrays.stream(votes).filter(s->s.equals(str)).count();
            data.put("key", str);
            data.put("count", String.valueOf(count));
            list.add(data);
        }

        Collections.sort(list, new Comparator<Map<String,String>>(){
            @Override
            public int compare(Map<String, String> o1, Map<String,String> o2){
                return (Integer.parseInt((String)o1.get("count")) == Integer.parseInt((String)o2.get("count"))) ? 
                    o1.get("key").compareTo(o2.get("key")) : Integer.parseInt((String)o2.get("count")) - Integer.parseInt((String)o1.get("count"));
            }
        });

        int lastCount = 0;

        for(int i = 0 ; i < k; i++){
            lastCount += Integer.parseInt(list.get(i).get("count"));
        }

        int temp = 0;
        String name = "";
        for(int i = list.size() - 1; i >= 0; i--){
            temp += Integer.parseInt(list.get(i).get("count"));
            if(temp > lastCount){
                name = list.get(i+1).get("key");
            }
        }

        System.out.println("name : " + name);

        return list;
    }

}
