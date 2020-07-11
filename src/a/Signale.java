package a;

public class Signale {// 1. Ausgangssituation true - false - false => Karton kann zur Befüllung rangeführt werden
    private boolean ablageposFrei = true;
    private boolean produktablageErlaubt = false;
    private boolean produktAbgelegt = false;

    // 3. Darauf warten, dass Signa1 auf ,true, gesetzt wird (mit der While-Schleife den Wait Zustand hervorufen, solange der 'value' auf falsch gesetzt ist)
    public synchronized void WarteAblageposFrei() throws InterruptedException {
        while(!ablageposFrei) {
            wait();
        }

    }

    public synchronized void WarteProduktablageErlaubt() throws InterruptedException {
        while(!produktablageErlaubt) {
            wait();
        }
    }

    public synchronized void WarteProduktAbgelegt() throws InterruptedException {
        while(!produktAbgelegt) {
            wait();
        }
    }

    // 2. Signalzustand auf ,value, setzen (,value, der entsprechenden privaten Variable zugewiesen + notify() )
    public synchronized void setAblageposFrei (boolean value) {
        ablageposFrei = value;
        notify();
    }

    // 2. Signalzustand auf ,value, setzen (,value, der entsprechenden privaten Variable zugewiesen)
    public synchronized void setProduktablageErlaubt(boolean value) {
        produktablageErlaubt = value;
        notify();
    }

    // 2. Signalzustand auf ,value, setzen (,value, der entsprechenden privaten Variable zugewiesen)
    public synchronized void setProduktAbgelegt (boolean value) {
        produktAbgelegt = value;
        notify();
    }
}
