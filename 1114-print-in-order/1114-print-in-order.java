class Foo {

    public Foo() {
        
    }
    Semaphore firstSemaphore = new Semaphore(1);
    Semaphore secondSemaphore = new Semaphore(0);
    Semaphore thirdSemaphore = new Semaphore(0);

    public void first(Runnable printFirst) throws InterruptedException {
        
        // printFirst.run() outputs "first". Do not change or remove this line.
        firstSemaphore.acquire(); // firstSemaphore--
        printFirst.run();
        secondSemaphore.release(); // secondSemaphore++ 
    }

    public void second(Runnable printSecond) throws InterruptedException {
        
        // printSecond.run() outputs "second". Do not change or remove this line.
        secondSemaphore.acquire(); // secondSemaphore--
        printSecond.run();
        thirdSemaphore.release(); // thirdSemaphore++
    }

    public void third(Runnable printThird) throws InterruptedException {
        
        // printThird.run() outputs "third". Do not change or remove this line.
        thirdSemaphore.acquire(); // thirdSemaphore--
        printThird.run();
    }
}