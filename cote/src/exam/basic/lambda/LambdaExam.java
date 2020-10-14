package exam.basic.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class LambdaExam {
    public static void main(String[] args) {
        LambdaExam le = new LambdaExam();
        le.lam1();        
    }

    public void lam1(){
        Calulator cal = n ->{return n+1;};
        
        int n = cal.calc(4);

        System.out.println("n : " + n);
    }
}

@FunctionalInterface
interface Calulator{
    public int calc(int n);
}
