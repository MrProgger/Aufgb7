package a;

public class Kartonabtransportprozess extends Thread {
    private Signale signale;

    public Kartonabtransportprozess(Signale signale) {
        this.signale = signale;
    }

    private void fahreKartonWeg() throws InterruptedException {
        /* 4. Wegfahren des Kartons simulieren analog zum Vorfahren des Kartons */
        sleep(1000); // 4.1 Verfahrzeit bis zur nächsten Kartonablage
    }

    private void fahreKartonVonAblageposWeg() throws InterruptedException {
      /* Auf Signal warten, das signalisiert, dass Produkt
         abgelegt und damit der Karton weggefahren werden kann */
        signale.WarteProduktAbgelegt();
        System.out.println("-3- Karton wird weggefahren");
        fahreKartonWeg();
        /* Relevante a.Signale (zurueck) setzen */
        signale.setProduktAbgelegt(false);
        signale.setAblageposFrei(true);
    }

    public void run() {
        while (true) {
            try {
                fahreKartonVonAblageposWeg();
            } catch (InterruptedException e) {
                System.out.println("Unzulaessige Unterbrechung");
                System.exit(0);
            }
        }
    }
}
