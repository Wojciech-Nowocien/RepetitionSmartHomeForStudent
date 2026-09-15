package pl.zsgornik.smarthome;

import pl.zsgornik.smarthome.model.Controllable;
import pl.zsgornik.smarthome.model.Device;
import pl.zsgornik.smarthome.model.Schedulable;

import java.util.ArrayList;
import java.util.List;

//Powinna posiadać kolekcję: ArrayList<Device> lub: List<Device>

//Utwórz: addDevice(Device device)
//Utwórz: removeDevice(Device device)

//Wyświetlanie urządzeń
//Utwórz: showAllDevices() - metoda powinna przejść po wszystkich urządzeniach i wywołać: device.showInfo() - (nie używaj tutaj instanceof).

//Dodaj: turnOnAll(), turnOffAll()
//Metody powinny przejść po kolekcji urządzeń.
//Nie twórz osobnych metod: turnOnAllLamps(), turnOnAllTelevisions(), turnOnAllAirConditioners()
//Wykorzystaj wspólny typ: Device

//Utwórz: showControllableDevices()
//Metoda powinna wyświetlić tylko urządzenia implementujące: Controllable

//Utwórz: showSchedulableDevices()
//Metoda powinna wyświetlić tylko urządzenia implementujące: Schedulable

public class SmartHome {
    private List<Device> devices;

    public SmartHome() {
        this.devices = new ArrayList<>();
    }

    public void addDevice(Device device) {
        devices.add(device);
        System.out.println("Dodano urządzenie: " + device.getName());
    }

    public void removeDevice(Device device) {
        if (devices.remove(device)) {
            System.out.println("Usunięto urządzenie: " + device.getName());
        } else {
            System.out.println("Nie znaleziono urządzenia.");
        }
    }

    public void showAllDevices() {
        System.out.println("Wszytskie urządzenia:");
        devices.stream()
                .forEach(Device::showInfo);
        System.out.println("\n \n");
    }

    public void turnOnAll() {
        System.out.println("Włączanie wszytskich urządzen.");
        devices.stream()
                .forEach(Device::turnOn);
        System.out.println("Urządzenia włączone.");
    }

//    public void turnOfAll() {
//        System.out.println("Wyłączanie wszytskich urządzen.");
//        devices.stream()
//                .forEach(Device::turnOff);
//        System.out.println("Urządzenia wyłączone.");
//    }

    public void turnOffAll() {
        System.out.println("Wyłączanie wszytskich urządzen.");
        for (Device device : devices) {
            device.turnOff();
        }
        System.out.println("Urządzenia wyłączone.");
    }

//    public void showControllableDevices() {
//        System.out.println("Urządzenia sterowalne:");
//        devices.stream()
//                .filter(device -> device instanceof Controllable)
//                .forEach(device -> System.out.println(device.getName()));
//        System.out.println();
//    }

    public void showControllableDevices() {
        System.out.println("Urządzenia sterowalne:");
        for (Device device : devices) {
            if (device instanceof Controllable) {
                System.out.println(device.getName());
            }
        }
        System.out.println();
    }

    public void showSchedulableDevices() {
        System.out.println("Urządzenia z harmonogramem:");
        for (Device device : devices) {
            if (device instanceof Schedulable) {
                System.out.println(device.getName());
            }
        }
        System.out.println();
    }

    public List<Device> getDevices() {
        return devices;
    }
}