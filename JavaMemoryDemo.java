import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class JavaMemoryDemo {
    static class Big {
        byte[] data;
        Big(int sizeMB) { data = new byte[sizeMB * 1024 * 1024]; }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Total memory: " + Runtime.getRuntime().totalMemory()/1024/1024 + " MB");

        List<Big> list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(new Big(10)); 
            System.out.println("Allocated " + (i+1)*10 + "MB");
            Thread.sleep(250);
        }

        WeakReference<Big> weak = new WeakReference<>(list.get(0));
        list = null;              
        System.gc();          
        Thread.sleep(1000);
        System.out.println("Weak ref cleared? " + (weak.get() == null));
    }
}
