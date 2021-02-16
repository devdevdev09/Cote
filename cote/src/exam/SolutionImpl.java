package exam;

public class SolutionImpl implements Solution{

    @Override
    public void test() {
        Solv sov = new Solv();
        sov.test1();

    }

    @Override
    public void solution() {
        // TODO Auto-generated method stub

    }
    
}

class Solv{
    public int test1(){
        System.out.println("test1");
        return 0;
    }
}
