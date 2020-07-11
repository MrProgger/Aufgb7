package a;

public class Produktablageprozess extends Thread {
    private Signale signale;

    public Produktablageprozess(Signale signale) {
        this.signale = signale;
    }

    private void legeProduktAb() throws InterruptedException {
        /* 5. Produktablage simulieren analog zum Vorfahren des Kartons */
        sleep(1000); //5.1
    }

    private void legeProduktAbFallsErlaubt() throws InterruptedException {
        /* 6. Auf Signal zum Ablegen warten */
        signale.WarteProduktablageErlaubt(); //6.1
        System.out.println("-2- Produkt wird abgelegt");
        legeProduktAb();
        /* Relevante a.Signale (zurueck) setzen */
        signale.setProduktablageErlaubt(false);
        signale.setProduktAbgelegt(true);
    }

    public void run() {
        while (true) {
            try {
                legeProduktAbFallsErlaubt();
            } catch (InterruptedException e) {
                System.out.println("Unzulaessige Unterbrechung");
                System.exit(0);
            }
        }
    }
}
