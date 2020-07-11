package b;

public class TicketAnbieter {
    private int VerfuegbareTickets;
    TicketAnbieter (int n) {
        VerfuegbareTickets = n;
    }
    synchronized boolean TicketsVerfuegbar() {// II => synchronized
        return VerfuegbareTickets > 0;
    }
    synchronized int TicketVerkauf() {// II => synchronized
        int nr = VerfuegbareTickets;
        VerfuegbareTickets = VerfuegbareTickets - 1;
        return nr;
    }
}

