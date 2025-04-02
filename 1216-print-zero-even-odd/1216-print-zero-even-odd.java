class ZeroEvenOdd {
    private Semaphore sz;
    private Semaphore so;
    private Semaphore se;
    private int n;
    
    public ZeroEvenOdd(int n) {
        this.n = n;
        this.sz = new Semaphore(1);
        this.so = new Semaphore(0);
        this.se = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= this.n; i++){
            sz.acquire();
            printNumber.accept(0);
            if(i % 2 == 0){
                se.release();
            }
            else{
                so.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for(int i = 2; i <= this.n; i+=2){
            se.acquire();
            printNumber.accept(i);
            sz.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= this.n; i+=2){
            so.acquire();
            printNumber.accept(i);
            sz.release();
        }
    }
}