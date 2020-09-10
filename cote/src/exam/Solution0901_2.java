package exam;

public class Solution0901_2 {

    public static void main(String[] args) {
        Solution0901_2 solution = new Solution0901_2();

        String str = "abababaaaaaaaa";
        int result = solution.solution(str);
        System.out.println(str + " : result = " + result);
    }

    public int solution(String s){
        if(s.length() == 1) return 1;
        int min = 9999;

        for(int i = 1 ; i < s.length(); i++){
            String[] arr = getArrByNum(s, i);    
            int cnt = getPressCount(arr);

            if(min > cnt && cnt > 0) min = cnt;
        }

        return min;
    }

    public int getPressCount(String[] arr){
        int cnt = 1;
        String result = "";
        
        for(int i = 0; i < arr.length-1; i++){
           if(arr[i].equals(arr[i+1])){
                cnt++;
           }else{
                result += (cnt == 1) ? arr[i] : Integer.toString(cnt) + arr[i];
                cnt = 1;
           }

           if(i+1 == arr.length-1){
                if(arr[i].equals(arr[i+1])){
                    result += Integer.toString(cnt) + arr[i];
                }else{
                    result += (cnt == 1) ? arr[i+1] : Integer.toString(cnt) + arr[i+1];
                }
           }
        }

        return result.length();
    }

    public String[] getArrByNum(String s, int num){
        int SIZE = 0;
        int len = s.length();

        SIZE = (len%num == 0) ? len/num : len/num + 1;

        String[] result = new String[SIZE];

        for(int i = 0 ; i < result.length; i++){
            int start = i*num;
            
            if(i == result.length - 1){
                result[i] = s.substring(start);    
            }else{
                int end = start + num;
                result[i] = s.substring(start, end);
            }

        }

        return result;
    }
}