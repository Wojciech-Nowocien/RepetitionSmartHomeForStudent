package pl.zsgornik.smarthome.model;

//Każde urządzenie powinno posiadać:
//name       – nazwa urządzenia
//room       – pomieszczenie
//power      – moc w watach
//isOn       – informacja, czy urządzenie jest włączone

//Wymagania
//Pola powinny być prywatne.
//Utwórz konstruktor przyjmujący: String name, String room, int power
//Urządzenie w momencie utworzenia powinno być wyłączone.

//Dodaj metody:
//turnOn()
//turnOff()
//oraz abstrakcyjną metodę: showInfo()

public abstract class Device {
    private String name;
    private String room;
    private int power;
    private boolean isOn;

    public Device(String name, int power, String room) {
        this.name = name;
        this.power = power;
        this.room = room;
        isOn = false;
    }

    public float calculatePowerConsumption(float hours) {
        return (power * hours) / 1000;
    }

    public void turnOn() {
        System.out.println("Włączono " + name + "urządzenie.");
        isOn = true;
    }

    public void turnOff() {
        System.out.println("Wyłączono " + name + "urządzenie.");
        isOn = false;
    }

    public abstract void showInfo();

    public String getName() {
        return name;
    }

    public String getRoom() {
        return room;
    }

    public int getPower() {
        return power;
    }

    public boolean isOn() {
        return isOn;
    }
}