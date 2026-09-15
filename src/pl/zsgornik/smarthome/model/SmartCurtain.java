package pl.zsgornik.smarthome.model;

/**
 * Inteligentna zasłona/roleta.
 * <p>
 * Klasa dziedziczy po Device, ponieważ jest urządzeniem.
 * Implementuje Schedulable, ponieważ można zaplanować
 * jej automatyczne działanie.
 * pola własne: openingLevel i scheduledTime;
 * <p>
 * Konstruktor powinien:
 * ustawić poziom otwarcia,
 * zabezpieczyć wartość openingLevel przed wyjściem poza zakres 0–100,
 * ustawić scheduledTime na null.
 * <p>
 * otwarcie i zamknięcie co 10%
 */
public class SmartCurtain extends Device implements Schedulable {
    int openingLevel;

    String scheduledTime;

    public SmartCurtain(String name, int power, String room, int openingLevel) {
        super(name, power, room);

        if (openingLevel > 100) {
            this.openingLevel = 100;
        } else if (openingLevel < 0) {
            this.openingLevel = 0;
        } else {
            this.openingLevel = openingLevel;
        }
        scheduledTime = null;
    }

    public void open() {
        openingLevel += 10;
        if (openingLevel > 100) {
            this.openingLevel = 100;
        }
        System.out.println("Poziom otwarcia wynosi: " + openingLevel + "%.");
    }

    public void close() {
        openingLevel -= 10;
        if (openingLevel < 0) {
            this.openingLevel = 0;
        }
        System.out.println("Poziom otwarcia wynosi: " + openingLevel + "%.");
    }

    @Override
    public void showInfo() {
        System.out.println("Robot: " + getName());
        System.out.println("Pomieszczenie: " + getRoom());
        System.out.println("Moc: " + getPower());
        System.out.println("Stan: " + (isOn() ? "włączona" : "wyłączona") + ".");
        System.out.println("Poziom otwarcia: " + openingLevel + "%.");
        System.out.println("Sprzątanie zaplanowano na: " + scheduledTime + ".");
    }

    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
        System.out.println("Działanie rolety " + getName() + " zaplanowano na: " + time);
    }
}