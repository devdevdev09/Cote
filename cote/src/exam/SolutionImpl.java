package exam;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SolutionImpl implements Solution{

    @Override
    public void test() {


    }

    @Override
    public void solution() {
        Solv sov = new Solv();
        int[] scovile = {1, 2, 3, 9, 10, 12};
        int k = 7;
        int result = 2;
        int exp = sov.solution(scovile, k);
        if( result == exp){
            System.out.println("success : " + exp);
        }else{
            System.out.println("fail : " + exp);
        }

    }
    
}

class Solv {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int[] arr3 = scoville;
        
        List<Integer> list = convert(scoville);
        list = sort(list);
        
        while(true){
            int[] arr1 = getMinSco2(list);
            list = getMinSco3(list);

            ++answer;
            
            int num = sumScovile(arr1[0], arr1[1]);
            arr3 = null;
            list = concat(list, num);            
            
            boolean result = check(list, K);
            if(result)
                return answer;
            
            if(list.size() == 1 && result)
                return -1;
        }
    }
    
    public List<Integer> convert(int[] arr){
        return  Arrays.stream(arr).boxed().collect(Collectors.toList());
    }
    
    public List<Integer> sort(List<Integer> list){
        Collections.sort(list);
        return list;
    }
    
    public boolean check(List<Integer> list, int k){

        List<Integer> result = new ArrayList<>(); 
        result.addAll(list);
        result.removeIf(i->(i>=k));
        
        if(result.size() == 0){
            return true;
        }
        
        return false;
    }
    
    
    public int sumScovile(int sco1, int sco2) {
        return sco1 + (sco2*2);
    }
    
    public int[] getMinSco2(List<Integer> scoville) {
        int[] arr = new int[2];
        arr[0] = scoville.get(0);
        arr[1] = scoville.get(1);
        return arr;
    }
    
    public List<Integer> getMinSco3(List<Integer> scoville) {
        scoville.remove(0);
        scoville.remove(0);
        return scoville;
        
    }
    
    public List<Integer> concat(List<Integer> list, int num){
        list.add(num);
        Collections.sort(list);
        return list;
    }
}
