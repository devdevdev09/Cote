package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution0830 {
    public int[] solution(String msg){
        List<String> indexList = new ArrayList<String>(
            Arrays.asList(
                "A","B","C","D","E","F","G","H","I","J",
                "K","L","M","N","O","P","Q","R","S","T",
                "U","V","W","X","Y","Z"));

        List<String> msgList = new ArrayList<String>(Arrays.asList(msg.split("")));

        List<Integer> result = new ArrayList<Integer>();

        for(String s : msg.split("")){
            if(indexList.indexOf(s) > -1){
                System.out.println("출력 : " + s);
                result.add(indexList.indexOf(s) + 1);
            }else{
                indexList.add(s);
            }
        }
        

        // 결과
        int[] answer = new int[result.size()];
        int idx = 0;
        for(int num : result){
            answer[idx++] = num;
        }
        // return result.stream().mapToInt(i->i).toArray();
        return answer;
    }

    public String getW(String msg, List<String> indexList){
        String[] sArr = msg.split("");
        
        if(indexList.indexOf(msg) > -1){
            System.out.println("출력 : " + msg);
        }else{

        }

        return "";
    }

    
}