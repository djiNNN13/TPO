package Task_5;

public class SymbolPrinterSync extends Thread{
    private final char symbol;
    private final Sync sync;
    private final boolean isTurnOn;

    public SymbolPrinterSync(char symbol, Sync sync, boolean isTurnOn){
        this.symbol = symbol;
        this.sync = sync;
        this.isTurnOn = isTurnOn;
    }

    @Override
    public void run(){
        while (true){
            sync.waitAndChange(isTurnOn, symbol);
            if(sync.isStopFlag())
                return;
        }
    }
}
