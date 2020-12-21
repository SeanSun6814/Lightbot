public class Delay {
    public Delay() {
        this(750);
    }

    public Delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
        }
    }
}
