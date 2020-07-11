package b;

public class Reisebuero extends Thread {
    private final String name;
    private final TicketAnbieter anbieter;

    Reisebuero(String name, TicketAnbieter anbieter) {
        this.name = name;
        this.anbieter = anbieter;
    }

    void warteAufKunde() {
        try {
            Thread.sleep(Math.round(1000 * Math.random()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        warteAufKunde();
        while (anbieter.TicketsVerfuegbar()) {
            /*try {//Sleep zur Simulierung von Rechenzeit Entzug um das Ticket 0 herauszufordern.
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/

            synchronized(anbieter) {//synchronized Block damit maximal ein Thread die Abfrage ausführen kann.
                //Zeite Prüfung, um dem Ticket 0 Problem zu entgehen.
                if (anbieter.TicketsVerfuegbar()) {
                    int nr = anbieter.TicketVerkauf();
                    System.out.println(name + " verkauft Ticket " + nr);
                    warteAufKunde();
                }
            }
        }
    }
}
