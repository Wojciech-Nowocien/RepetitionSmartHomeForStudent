package pl.zsgornik.smarthome;

//Utwórz obiekt: SmartHome home = new SmartHome();
//Następnie utwórz co najmniej:
//    2 × Lamp
//    1 × AirConditioner
//    1 × Television
//    1 × RobotVacuum
//Przykładowe dane dobierz samodzielnie.
//Następnie dodaj wszystkie urządzenia do SmartHome.

//Program powinien przetestować wszystkie przygotowane funkcjonalności.
//A. Wyświetl wszystkie urządzenia: home.showAllDevices();
//B. Włącz wszystkie urządzenia: home.turnOnAll();
//C. Ponownie wyświetl urządzenia: sprawdź, czy zmienił się ich stan.
//D. Przetestuj lampę: zwiększ i zmniejsz jej jasność.
//E. Przetestuj klimatyzator: zwiększ i zmniejsz temperaturę.
//F. Przetestuj telewizor: zmień kanał i głośność.
//G. Przetestuj harmonogram: Ustaw godzinę dla: AirConditioner i RobotVacuum
//H. Wyświetl urządzenia sterowalne: home.showControllableDevices();
//I. Wyświetl urządzenia z harmonogramem: home.showSchedulableDevices();
//J. Wyłącz wszystkie urządzenia: home.turnOffAll();

import pl.zsgornik.smarthome.model.AirConditioner;
import pl.zsgornik.smarthome.model.Lamp;
import pl.zsgornik.smarthome.model.RobotVacuum;
import pl.zsgornik.smarthome.model.SmartCurtain;
import pl.zsgornik.smarthome.model.Television;

public class Main {
    public static void main(String[] args) {
        var home = new SmartHome();

        var lamp1 = new Lamp("Lampa sufitowa", 40, "salon", 50);
        var lamp2 = new Lamp("Lampa nocna", 15, "sypialnia", 20);
        var airConditioner = new AirConditioner("Klimatyzator ścienny", "salon", 1500, 22);
        var television = new Television("Telewizor w salonie", "salon", 120, 1, 25);
        var robotVacuum = new RobotVacuum("Robot sprzątający", "korytarz", 50, 80);
        var smartCurtain = new SmartCurtain("Roleta okienna", 30, "sypialnia", 40);

        home.addDevice(lamp1);
        home.addDevice(lamp2);
        home.addDevice(airConditioner);
        home.addDevice(television);
        home.addDevice(robotVacuum);
        home.addDevice(smartCurtain);

        home.showAllDevices();

        home.turnOnAll();

        home.showAllDevices();

        lamp1.increasePower();
        lamp1.increasePower();
        lamp1.decreasePower();

        airConditioner.increasePower();
        airConditioner.increasePower();
        airConditioner.decreasePower();

        television.nextChannel();
        television.previousChannel();
        television.increaseVolume();
        television.decreaseVolume();

        airConditioner.schedule("14:30");
        robotVacuum.schedule("09:00");
        smartCurtain.schedule("07:00");

        home.showControllableDevices();

        home.showSchedulableDevices();

        home.turnOffAll();

        System.out.println("Zużycie energii (" + television.getName() + ", 5h): " + television.calculatePowerConsumption(5f) + " kWh");
        System.out.println("Zużycie energii (" + airConditioner.getName() + ", 8h): " + airConditioner.calculatePowerConsumption(8f) + " kWh");

        System.out.println("Pobranie jasności lampy: " + lamp1.getBrightness() + "%");
        System.out.println("Pobranie temperatury klimatyzatora: " + airConditioner.getTemperature() + "°C");
        System.out.println("Pobranie zaplanowanego czasu klimatyzatora: " + airConditioner.getScheduledTime());
        System.out.println("Pobranie kanału telewizora: " + television.getChannel());
        System.out.println("Pobranie głośności telewizora: " + television.getVolume());
        System.out.println("Pobranie poziomu baterii robota: " + robotVacuum.getBatteryLevel() + "%");
        System.out.println("Pobranie zaplanowanego czasu robota: " + robotVacuum.getScheduledTime());

        smartCurtain.open();
        smartCurtain.close();

        lamp1.control("ON");
        lamp1.control("INCREASE");
        lamp1.control("OFF");

        airConditioner.control("ON");
        airConditioner.control("INCREASE");
        airConditioner.control("DECREASE");

        television.control("ON");
        television.control("NEXT");
        television.control("INCREASE");

        robotVacuum.control("ON");
        robotVacuum.control("OFF");

        smartCurtain.control("OPEN");
        smartCurtain.control("CLOSE");

        television.control("MUTE");

        System.out.println("\nCały dom zużyje " + home.calculatePowerConsumption(1.5f) + " kWh przez 1.5 godziny.");
    }
}