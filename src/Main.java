public class Main {

    public static void main(String[] args) {
        Runnable control = new Controller();
        Thread t = new Thread(control);
        t.start();
    }
}
