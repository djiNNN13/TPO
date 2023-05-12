package Task_6;


public class CounterThread extends Thread {
        private boolean increment;
        private ICounter counter;

        public CounterThread(boolean increment, ICounter counter) {
            this.increment = increment;
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 100000; i++) {
                if (this.increment) {
                    this.counter.increment();
                } else {
                    this.counter.decrement();
                }
            }
        }
    }

