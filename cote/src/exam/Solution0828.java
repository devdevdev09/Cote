package exam;

public class Solution0828 {

    public String solution(String p){
        String answer = "";

        if(p.equals("")){
            return "";
        }

        String[] sArr = splitUV(p);
        
        String u = sArr[0];
        String v = sArr[0];

        if(isCorrect(u)){
            answer += u + solution(v);
        }else{
            answer = solution(v);
            answer = fn3(answer);
        }

        return answer;
    }

    // 올바른 괄화문자열인지 확인
    // 문자열을 u,v로 분리

    public boolean isCorrect(String s){        
        int left = 0;
        int right = 0;

        for(char c : s.toCharArray()){
            if(c == '(') left++;
            if(c == ')') right++;

            if(right > left){
                return false;
            }
        }
        return true;
    }

    public String[] splitUV(String s){
        int left = 0;
        int right = 0;
        int idx = 0;
        String[] result = new String[2];
        
        for(char c : s.toCharArray()){
            if(c == '(') left++;
            if(c == ')') right++;
            
            idx++;

            if(left == right && left > 0){
                result[0] = s.substring(0,idx);
                result[1] = s.substring(idx);
                return result;
            }
        }
        
        return result;
    }

    public String fn3(String s){
        int len = s.length();

        String str = s.substring(1, len-1);
        String revers = "";
        
        for(int i = str.length() - 1 ; i > 0 ; i--){
            revers += Character.toString(str.charAt(i));
        }

        return revers;
    }
}