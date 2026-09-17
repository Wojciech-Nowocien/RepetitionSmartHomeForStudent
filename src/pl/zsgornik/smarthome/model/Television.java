package pl.zsgornik.smarthome.model;

//Telewizor powinien posiadać: channel, volume

//Konstruktor przyjmuje: name, room, power, channel, volume

//Metody
//nextChannel()
//previousChannel()
//Kanał nie może być mniejszy niż 1.

//increaseVolume()
//decreaseVolume()
//Głośność powinna znajdować się w zakresie: 0–100

//Przesłoń:
//showInfo()

public class Television extends Device implements RemoteControllable {
    private int channel;
    private int volume;

    public Television(String name, String room, int power, int channel, int volume) {
        super(name, power, room);
        if (channel < 1) {
            this.channel = 1;
        } else {
            this.channel = channel;
        }

        if (volume < 0) {
            this.volume = 0;
        } else if (volume > 100) {
            this.volume = 100;
        } else {
            this.volume = volume;
        }
    }

    public void nextChannel() {
        channel++;
        System.out.println("Telewizor " + getName() + "gra teraz kanał nr. " + channel + ".");
    }
    public void previousChannel() {
        channel--;
        if (channel < 1) {
            channel=1;
        }
        System.out.println("Telewizor " + getName() + "gra teraz kanał nr. " + channel + ".");
    }

    public void increaseVolume() {
        volume++;
        if (volume > 100) {
            volume = 100;
        }
        System.out.println("Głośność telewizora: " + getName() + " wynosi " + volume);
    }

    public void decreaseVolume() {
       volume--;
        if (volume < 0) {
            volume = 0;
        }
        System.out.println("Głośność telewizora: " + getName() + " wynosi " + volume);
    }

    @Override
    public void control(String command) {
        System.out.println("Zdalne sterowanie urządzenia " + getName() + ":");
        switch (command) {
            case "ON":
                turnOn();
                break;
            case "OFF":
                turnOff();
                break;
            case "NEXT":
                nextChannel();
                break;
            case "PREVIOUS":
                previousChannel();
                break;
            case "INCREASE":
                increaseVolume();
                break;
            case "DECREASE":
                decreaseVolume();
                break;
            default:
                System.out.println("Urządzenie " + getName() + "nie rozpoznaje komendy \"" + command + "\"!");
        }
        System.out.println("Koniec zdalnego sterowania.");
    }

    @Override
    public void showInfo() {
        System.out.println("\n=====================================================");
        System.out.println("Telewizor: " + getName());
        System.out.println("Pomieszczenie: " + getRoom());
        System.out.println("Moc: " + getPower());
        System.out.println("Stan: " + (isOn() ? "włączona" : "wyłączona"));
        System.out.println("Kanał: " + channel + "%");
        System.out.println("Głośność: " + volume);
        System.out.println("=====================================================\n");
    }

    public int getChannel() {
        return channel;
    }

    public int getVolume() {
        return volume;
    }
}