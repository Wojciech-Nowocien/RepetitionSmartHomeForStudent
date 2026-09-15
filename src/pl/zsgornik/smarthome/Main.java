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
import pl.zsgornik.smarthome.model.Television;

import java.time.Instant;

public class Main {
    public static void main(String[] args) {
        var home = new SmartHome();
        var lamp1 = new Lamp("Glowna lampa", 30, "salon",  50);
        var lamp2 = new Lamp("Nocna lampa", 10,"sypialnia",  15);
        var airConditioner = new AirConditioner("Klimatyzacja Peugot", "salon", 400, 22);
        var television = new Television("Telewizor LG", "kuchnia", 120, 1, 20);
        var robotVacuum = new RobotVacuum("Dyson", "kuchnia", 50, 67);

        home.addDevice(lamp1);
        home.addDevice(lamp2);
        home.addDevice(airConditioner);
        home.addDevice(television);
        home.addDevice(robotVacuum);

        home.showAllDevices();

        home.turnOnAll();

        home.showAllDevices();

        lamp1.increasePower();
        lamp1.increasePower();
        lamp1.increasePower();
        lamp2.decreasePower();

        airConditioner.increasePower();
        airConditioner.increasePower();
        airConditioner.decreasePower();
        airConditioner.decreasePower();
        airConditioner.decreasePower();
        airConditioner.decreasePower();

        television.nextChannel();
        television.decreaseVolume();

        airConditioner.schedule(Instant.now().plusMillis(1 * 60 * 60 * 1000).toString());
        robotVacuum.schedule(Instant.now().plusMillis(6 * 60 * 60 * 1000).toString());

        home.showControllableDevices();

        home.showSchedulableDevices();

        home.turnOffAll();

        home.showAllDevices();
    }
}