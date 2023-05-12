package Task_5;

public class Main {
    public static void main(String[] args) {
        boolean isSynchronized = true;
        Thread thread1;
        Thread thread2;
        if(isSynchronized) {
            Sync synchronizer = new Sync();
            thread1 = new Thread(new SymbolPrinterSync('-', synchronizer, true));
            thread2 = new Thread(new SymbolPrinterSync('|', synchronizer, false));
        }
        else{
            thread1 = new Thread(new SymbolPrinterAsync('-'));
            thread2 = new Thread(new SymbolPrinterAsync('|'));
        }
        thread1.start();
        thread2.start();
    }
}
