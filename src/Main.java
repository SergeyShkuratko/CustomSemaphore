public class Main {

    public static void main(String[] args) {
        Summator summator = new Summator();




        new Thread(() -> {
            summator.addProduct(1, 0, 0);
        }).start();
        new Thread(() -> {
            summator.addProduct(2, 0, 0);
        }).start();
        new Thread(() -> {
            summator.addProduct(0, 2, 0);
        }).start();
        new Thread(() -> {
            summator.addProduct(0, 5, 0);
        }).start();
        new Thread(() -> {
            summator.addProduct(7, 0, 0);
        }).start();
        new Thread(() -> {
            summator.addProduct(4, 0, 0);
        }).start();
    }
}
