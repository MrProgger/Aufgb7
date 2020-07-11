package b;

public class Test {
    public static void main(String [] argv) {
        TicketAnbieter ta = new TicketAnbieter(4);
        new Reisebuero("Reiseland", ta).start();
        new Reisebuero("Happy Travel", ta).start();
    }
}

/*
* I) Sollten beide Reisebüro Threads gleichzeitig (möglich, da nicht synchronized))
* die anbieter.TicketVerkauf()-Methode aufrufen,
* könnte es zu dem Fall kommen, dass beide Reisbüros das Ticket 3 verkaufen.
* Dafür müsste die Zufallszahl beider Threads mehrmals ähnlich sein,
* was zwar sehr unwahrscheinlich, aber möglich ist.
*
* II) Sollte ein Thread hier Rechenzeit entzogen bekommen und ein anderer Thread
* die Schleife betreten, kommt es vor, dass, sollte nur noch ein Ticket verfügbar sein,
* ein Thread das Ticket 1 und der Andere das Ticked 0 bekommt.
* */

