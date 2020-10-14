package exam.basic.optional;

import java.lang.StackWalker.Option;
import java.util.Optional;

public class OptionalExam {
    public static void main(String[] args) {
        OptionalExam oe = new OptionalExam();
        oe.oe1();
    }

    public void oe1(){
        Optional<String> opt = Optional.of("java 옵셔날 object");
        System.out.println(opt);;

        Optional<String> opt2 = Optional.ofNullable("java 옵셔널 object");

        if(opt2.isPresent()){
            System.out.println(opt2.get());
        }

        Optional opt3 = Optional.empty();

        System.out.println("opt3");
        System.out.println(opt3);

        System.out.println();
    }
}
