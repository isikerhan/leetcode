class FooBar {
    private int n;
    private AtomicInteger counter = new AtomicInteger(0);

    public FooBar(int n) {
        this.n = n;
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            synchronized(counter) {
                while (counter.get() % 2 != 0) {
                    counter.wait();
                }
                counter.incrementAndGet();
        	    printFoo.run();
                counter.notify();
            }
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
        	synchronized(counter) {
                while (counter.get() % 2 != 1) {
                    counter.wait();
                }
                counter.incrementAndGet();
        	    printBar.run();
                counter.notify();
            }
        }
    }
}