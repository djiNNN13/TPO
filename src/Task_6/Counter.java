package Task_6;

public class Counter implements ICounter {
    private int value = 0;

    @Override
    public int getCounter() {
        return this.value;
    }

    @Override
    public void increment() {
        value++;
    }

    @Override
    public void decrement() {
        value--;
    }
}