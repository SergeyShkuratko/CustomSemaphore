public class Ware {
    private int count = 0;

    private String type = "";

    public Ware(String type) {
        this.type = type;
    }

    public void addCount(int count) {
        this.count = this.count + count;
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Current count of " + type + " " + this.count);
    }
}
