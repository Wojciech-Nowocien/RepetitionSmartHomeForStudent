package pl.zsgornik.smarthome.model;

//Lampa powinna posiadać dodatkowe pole: brightness - oznaczające jasność w procentach. Zakres jasności: 0–100

//Konstruktor powinien przyjmować: name, room, power, brightness i odpowiednio zainicjalizować obiekt.

//Metody
//Zaimplementuj wymagane metody interfejsu Controllable.
//Przy zwiększaniu jasności zmieniaj ją o: 10%
//Przy zmniejszaniu również o: 10%
//Nie pozwól przekroczyć zakresu 0–100.

//Przesłoń metodę: showInfo(). Powinna wyświetlać informacje o lampie.

public class Lamp extends Device implements Controllable, RemoteControllable {

    private int brightness;

    public Lamp(String name, int power, String room, int brightness) {
        super(name, power, room);
        if (brightness < 0) {
            brightness = 0;
        } else if (brightness > 100) {
            brightness = 100;
        }else  {
            this.brightness = brightness;
        }
    }


    @Override
    public void increasePower() {
        brightness += 10;
        if (brightness > 100) {
            brightness = 100;
        }
        System.out.println("Zwiększono moc (jasność) urządzenia  " + getName() + " o 10. Obecna wartość to " + brightness + "%.");
    }

    @Override
    public void decreasePower() {
        brightness -= 10;
        if (brightness < 0) {
            brightness = 0;
        }
        System.out.println("Zmniejszono moc (jasność) urządzenia  " + getName() + " o 10. Obecna wartość to " + brightness + "%.");
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

    @Override
    public void showInfo() {
        System.out.println("Lampa: "+ getName());
        System.out.println("Pomieszczenie: "+ getRoom());
        System.out.println("Moc: "+ getPower());
        System.out.println("Stan: "+( isOn() ? "włączona" : "wyłączona") + ".");
        System.out.println("Jasność: " + brightness +"%.");
    }

    public int getBrightness() {
        return brightness;
    }
}