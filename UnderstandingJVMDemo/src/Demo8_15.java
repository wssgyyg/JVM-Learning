import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

public class Demo8_15 {

    class GrandFather{
        void thinking(){
            System.out.println("I am grandfather");
        }
    }

    class Father extends GrandFather{
        @Override
        void thinking(){
            System.out.println("I am father");
        }
    }

    class Son extends Father{
        @Override
        void thinking(){
            MethodType methodType = MethodType.methodType(void.class);
            try {
                //Last argument must be same as the current class.
                //Using methodhandle to simulate the invokespecial instruction can only access to super class of the special caller.
                MethodHandle methodHandle = MethodHandles.lookup().findSpecial(GrandFather.class, "thinking", methodType, getClass());
                methodHandle.invoke(this);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Demo8_15().new Son().thinking();
    }

}
