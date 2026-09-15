package pl.zsgornik.smarthome.model;
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

public class Main {

    public static void main(String[] args) {
        SmartHome home = new SmartHome();
        Lamp lamp1 = new Lamp("Lampa główna", 50,"Salon", 100);
        Lamp lamp2 = new Lamp("Lampa nocna", 20, "Sypialnia", 30);
        AirConditioner airConditioner = new AirConditioner("Hisens", "Salon", 2500, 25);
        Television television = new Television("Samsung", "Sypialnia", 150,  21, 23);
        RobotVacuum robotVacuum = new RobotVacuum("Rumba", "Łaznieka", 100, 68);

        home.addDevice(lamp1);
        home.addDevice(lamp2);
        home.addDevice(airConditioner);
        home.addDevice(television);
        home.addDevice(robotVacuum);

        home.showAllDevices();
        home.turnOnAll();
        home.showAllDevices();
        System.out.println("Test Controllable");
        lamp2.incrasePower();
        lamp2.incrasePower();
        lamp2.incrasePower();
        lamp2.incrasePower();
        airConditioner.incrasePower();
        airConditioner.incrasePower();
        airConditioner.incrasePower();
        airConditioner.incrasePower();
        airConditioner.incrasePower();
    }
}