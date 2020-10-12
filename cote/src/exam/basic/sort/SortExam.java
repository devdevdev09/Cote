package exam.basic.sort;

import java.util.Arrays;
import java.util.Comparator;

public class SortExam {
    public static void main(String[] args) {
        SortExam se = new SortExam();
        se.sortExam1();
    }

    public void sortExam1(){
        String[] strs = new String[]{"tesd0", "tesb2", "testc3", "tesa4", "testc1", "tesa2"};

        // 원본 데이터 출력
        print(strs, "원본 데이터");

        String[] arr = Arrays.stream(strs).sorted().toArray(String[]::new);

        // 정렬1
        print(arr, "정렬1");

        arr = Arrays.stream(strs).sorted(new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return s2.compareTo(s1);
            }
        }).toArray(String[]::new);

        // 역순 정렬1
        print(arr, "역순 정렬1");

        // 역순 정렬2
        arr = Arrays.stream(strs).sorted(Comparator.reverseOrder()).toArray(String[]::new);
        print(arr, "역순 정렬2");

        // comparator 생성
        Comparator<String> comp = new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                // 문자와 숫자 구분하기
                String str1 = o1.replaceAll("[0-9]", "");
                int num1 = Integer.parseInt(o1.replaceAll("[^0-9]", ""));

                String str2 = o2.replaceAll("[0-9]", "");
                int num2 = Integer.parseInt(o2.replaceAll("[^0-9]", ""));

                return str1.equals(str2) ? num1 - num2 : str1.compareTo(str2);
            }
        };

        arr = Arrays.stream(strs).sorted(comp).toArray(String[]::new);
        print(arr, "new comp 생성 - 문자열 비교 같으면 숫자비교");
    }

    public void print(Object[] arr, String name){
        System.out.println(name);
        for(Object obj : arr){
            System.out.print(obj +" ");
        }
        System.out.println();
    }
    
}