package pl.zsgornik.smarthome.model;

//Klimatyzator powinien posiadać:
//temperature
//scheduledTime typu String, który przechowuje godzinę uruchomienia.

//Temperatura początkowa jest przekazywana w konstruktorze.
//Konstruktor powinien przyjmować: name, room, power, temperature

//Controllable
//Metoda: increasePower() powinna zwiększać temperaturę o 1°C.
//Metoda: decreasePower() powinna zmniejszać temperaturę o 1°C.

//Schedulable
//Metoda: schedule(String time) powinna zapamiętać godzinę uruchomienia.
//showInfo() Wyświetl:
//    •    nazwę,
//    •    pomieszczenie,
//    •    moc,
//    •    stan,
//    •    temperaturę,
//    •    zaplanowaną godzinę, jeśli została ustawiona.

public class AirConditioner extends Device implements Controllable, Schedulable, RemoteControllable {
    private int temperature;
    private String scheduledTime;

    public AirConditioner(String name, String room, int power, int temperature) {
        super(name, power, room);
        this.temperature = temperature;
    }


    @Override
    public void showInfo() {
        System.out.println("Klimatyzacja " + getName());
        System.out.println("Pomieszczenie: " + getRoom());
        System.out.println("Moc" + getPower());
        System.out.println("Stan: " + (isOn() ? "Włączona" : "Wyłączona"));
        System.out.println("Obecna temperatura" + temperature);
        System.out.println("Czas włącznia to: " + scheduledTime);
    }

    @Override
    public void schedule(String time) {
        scheduledTime = time;
        System.out.println("Oczekiwany czas to: " + scheduledTime);
    }

    @Override
    public void increasePower() {
        this.temperature++;
        System.out.println("Zwiększono moc o 1 stopień, moc wynosi " + temperature);
    }

    @Override
    public void decreasePower() {
        this.temperature--;
        System.out.println("Zmniejszono moc o 1 stopień, moc wynosi " + temperature);
    }

    @Override
    public void control(String command) {
        switch (command) {
            case "ON":
                turnOn();
                break;
            case "OFF":
                turnOff();
                break;
            case "INCREASE":
                increasePower();
                break;
            case "DECREASE":
                decreasePower();
                break;
            default:
                System.out.println("Urządzenie " + getName() + "nie rozpoznaje komendy \"" + command + "\"");
        }
    }

    public int getTemperature() {
        return temperature;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }
}