@SuppressWarnings("ALL")
public class Summator {
    private volatile int breadPermit = 1;
    private volatile int milkPermit = 1;
    private volatile int beerPermit = 1;

    private final Ware breadWare = new Ware("Bread");
    private final Ware milkWare = new Ware("Milk");
    private final Ware beerWare = new Ware("Beer");

    void addProduct(int breadCount, int milkCount, int beerCount) {
        if (breadCount != 0) {
            tryAddBread(breadCount);
        }

        if (milkCount != 0) {
            tryAddMilk(milkCount);
        }

        if (beerCount != 0) {
            tryAddBeer(beerCount);
        }
    }

    private void tryAddBeer(int beerCount) {
        System.out.println("Try add beer " + beerCount + ". Current beer permit " + beerPermit);
        if (beerPermit == 1) {
            System.out.println("Start add beer");
            beerPermit--;
            beerWare.addCount(beerCount);
            System.out.println("Finish add beer");
            beerPermit++;
            synchronized (beerWare) {
                beerWare.notifyAll();
            }
        }
        if (beerPermit == 0) {
            synchronized (beerWare) {
                try {
                    beerWare.wait();
                    tryAddBeer(beerCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void tryAddMilk(int milkCount) {
        System.out.println("Try add milk " + milkCount + ". Current milk permit " + milkPermit);
        if (milkPermit == 1) {
            System.out.println("Start add milk");
            milkPermit--;
            milkWare.addCount(milkCount);
            System.out.println("Finish add milk");
            milkPermit++;
            synchronized (milkWare) {
                milkWare.notifyAll();
            }
        }
        if (milkPermit == 0) {
            synchronized (milkWare) {
                try {
                    milkWare.wait();
                    tryAddMilk(milkCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void tryAddBread(int breadCount) {
        System.out.println("Try add bread " + breadCount + ". Current bread permit " + breadPermit);
        if (breadPermit == 1) {
            System.out.println("Start add bread");
            breadPermit--;
            breadWare.addCount(breadCount);
            System.out.println("Finish add bread");
            breadPermit++;
            synchronized (breadWare) {
                breadWare.notifyAll();
            }
        }

        if (breadPermit == 0) {
            synchronized (breadWare) {
                try {
                    breadWare.wait();
                    tryAddBread(breadCount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
