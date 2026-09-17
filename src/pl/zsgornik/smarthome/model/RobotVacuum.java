package pl.zsgornik.smarthome.model;

//Robot powinien posiadać:
//batteryLevel
//scheduledTime
//Poziom baterii: 0–100%

//Konstruktor przyjmuje: name, room, power, batteryLevel

//Metoda schedule() zapamiętuje godzinę rozpoczęcia sprzątania.

//Metoda showInfo() wyświetla:
//    •	nazwę,
//    •	pomieszczenie,
//    •	moc,
//    •	stan,
//    •	poziom baterii,
//    •	zaplanowaną godzinę sprzątania.

public class RobotVacuum extends Device implements Schedulable, RemoteControllable {
    private int batteryLevel;
    private String scheduledTime;

    public RobotVacuum(String name, String room, int power, int batteryLevel) {
        super(name, power, room);
        if (batteryLevel < 0) {
            this.batteryLevel = batteryLevel;
        } else if (batteryLevel > 100) {
            this.batteryLevel = batteryLevel;
        } else {
            this.batteryLevel = batteryLevel;
        }
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
            default:
                System.out.println("Urządzenie " + getName() + "nie rozpoznaje komendy \"" + command + "\"");
        }
    }

    @Override
    public void showInfo() {
        System.out.println("Robot: " + getName());
        System.out.println("Pomieszczenie: " + getRoom());
        System.out.println("Moc: " + getPower());
        System.out.println("Stan: " + (isOn() ? "włączona" : "wyłączona") + ".");
        System.out.println("Poziom baterii: " + batteryLevel + "%.");
        System.out.println("Sprzątanie zaplanowano na: " + scheduledTime + ".");
    }

    @Override
    public void schedule(String time) {
        this.scheduledTime = time;
        System.out.println("Sprzątanie robotem " + getName() + " zaplanowano na: " + time);
    }

    public int getBatteryLevel() {
        return batteryLevel;
    }

    public String getScheduledTime() {
        return scheduledTime;
    }
}