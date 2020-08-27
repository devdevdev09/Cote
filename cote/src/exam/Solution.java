package exam;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public int solution(String dartResult){
        Pattern pattern = Pattern.compile("([0-9]{1,2})(S|D|T){1}(\\*|\\#){0,1}");
        Matcher matcher = pattern.matcher(dartResult);
        List<String> list = new ArrayList<String>();

        while(matcher.find()){
            System.out.println("group(0) : " + matcher.group());
            System.out.println(matcher.group(1) + " : " + matcher.group(2) + " : " + matcher.group(3));
            // System.out.println(matcher.group(1) + " : " + matcher.group(2));
            list.add(matcher.group(1));
            list.add(matcher.group(2));
            if(matcher.group(3) != null){
                list.add(matcher.group(3));
            }
        }

        for(String str4 : list){
            System.out.println("str : " + str4);
        }

        // 앞에서부터 문자열 자르기
        // String str2 = "10test2ttt3";
        // Pattern pattenr2 = Pattern.compile("[0-9]{1,2}");
        // Matcher matcher2 = pattenr2.matcher(str2);

        // while(matcher2.find()){
        //     // System.out.println("start : " + matcher2.start());
        //     String str3 = str2.substring(matcher2.start(), matcher2.end());
        //     System.out.println("substr : " + str3);
        //     // System.out.println("end : " + matcher2.end());
        // }

        int[] point = new int[3];
        int idx = -1;
        int cnt = -1;

        for(String s : list){
            ++cnt;
            Pattern nPattern = Pattern.compile("[0-9]{1,2}");
            Matcher nMatcher = nPattern.matcher(s);

            if(nMatcher.matches()){
                point[++idx] = Integer.parseInt(s);
                continue;
            }

            if("S".equals(s)){
                point[idx] = (int)Math.pow(point[idx], 1);
                continue;
            }

            if("D".equals(s)){
                point[idx] = (int)Math.pow(point[idx], 2);
                continue;
            }

            if("T".equals(s)){
                point[idx] = (int)Math.pow(point[idx], 3);
                continue;
            }

            if("*".equals(s)){
                if(idx > 0){
                    point[idx - 1] *= 2;
                }
                point[idx] *= 2;
            }

            if("#".equals(s)){
                point[idx] = point[idx]*-1;
                continue;
            }
        }

        int answer = point[0] + point[1] + point[2];

        System.out.println("answer : " + answer);
        return answer;
    }

    public int solution2(String dartResult){
        int[] point = new int[3];
        int idx = -1;
        int cnt = -1;
        String temp = "";
        for(Character c : dartResult.toCharArray()){
            ++cnt;
            String tmp = Character.toString(c);
            
            if(Character.isDigit(c)){
                temp += Character.toString(c);
                
                continue;
            }else{
                point[++idx] = Integer.parseInt(temp);
                temp = "";
            }

            if("S".equals(tmp)){
                point[idx] = (int)Math.pow(point[idx], 1);
                continue;
            }

            if("D".equals(tmp)){
                point[idx] = (int)Math.pow(point[idx], 2);
                continue;
            }

            if("T".equals(tmp)){
                point[idx] = (int)Math.pow(point[idx], 3);
                continue;
            }

            if("*".equals(tmp)){
                // for(int i = idx ; i >= 0; i--){
                //     point(idx)
                // }
                if(idx > 0){
                    point[idx - 1] *= 2;
                }
                point[idx] *= 2;
            }

            if("#".equals(tmp)){
                point[idx] += point[idx]*-1;
                continue;
            }

        }
        int answer = point[0] + point[1] + point[2];
        return answer;
    }

    
    // public int solution3(String dartResult){
    //     String[] reg = {"[0-9]{1,2}", "[S|D|T]", "[\\*|\\#]"};

    //     for(int i = 0 ; i < 3; i++){
    //         Pattern pattern = Pattern.compile(reg[i]);
    //         Matcher matcher = pattern.matcher(dartResult);
    //         System.out.println("Test : " + matcher.group());
    //     }

    //     return 0;
    // }
}