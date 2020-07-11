package a;

public class Verpackungsprozess {
    public static void main(String[] args) {
        Signale signale = new Signale();

       /* 4. die Prozesse a.Kartonzufuhrprozess, a.Produktablageprozess und
          Kartonatransportprozess Objekte erstellen und ,signale, übergeben */
        Kartonzufuhrprozess kzf = new Kartonzufuhrprozess(signale);
        Produktablageprozess pap = new Produktablageprozess(signale);
        Kartonabtransportprozess kap = new Kartonabtransportprozess(signale);

        /* 5. die Prozesse a.Kartonzufuhrprozess, a.Produktablageprozess und
          Kartonatransportprozess starten */
        kzf.start();
        pap.start();
        kap.start();

    }
}
