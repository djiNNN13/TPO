package Task_5;

public class Sync {
    private boolean permission;
    private int symbolsCount;
    private int linesCount;
    private boolean stopFlag;

    public Sync() {
        permission = true;
        symbolsCount = 0;
        linesCount = 0;
        stopFlag = false;
    }

    public synchronized boolean getPermission() {
        return permission;
    }

    public synchronized boolean isStopFlag() {
        return stopFlag;
    }

    public synchronized void waitAndChange(boolean controlValue, char symbol) {
        while (getPermission() != controlValue) {
            try {
                wait();
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        }
        if(stopFlag){
            notifyAll();
            return;
        }
        System.out.print(symbol);
        permission = !permission;
        symbolsCount++;
        if (symbolsCount == 100) {
            symbolsCount = 0;
            System.out.println();
            linesCount++;
        }
        if (linesCount == 100) {
            stopFlag = true;
        }
        notifyAll();
    }
}
