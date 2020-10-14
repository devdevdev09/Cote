package exam.basic.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalExam {
    public static void main(String[] args) {
        OptionalExam oe = new OptionalExam();
        oe.oe1();
    }

    public void oe1(){
        Optional<String> op1 = Optional.empty();

        Optional<String> op2 = Optional.of("OP2");

        Optional<String> op3 = Optional.ofNullable("OP3");

        Optional<String> op4 = Optional.ofNullable(null);
    }

    public void oe2(String param){
        String str = Optional.ofNullable(param).orElse("OTHER");
    }
}
