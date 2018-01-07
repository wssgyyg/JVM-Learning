package hello;

public class FinallyTest {

    public static class Inner{

    }

    public static int test() {
        int x;
        try{
            System.out.println("try part");
            x = 2;
            return x;

        }catch (Exception e){
            System.out.println("catch part");
            x = 4;
            return x;
        }finally {
            x = 3;
            System.out.println("finally part");
        }

    }

    public static void main(String[] args) {
        int x = test();
        System.out.println("the value of x is " + x);
    }
}
