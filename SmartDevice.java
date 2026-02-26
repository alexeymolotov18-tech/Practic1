// 1. Создаем узкоспециализированный интерфейс для управления питанием.
interface Switchable {
    void turnOn(); // Метод только для включения/выключения
}

// 2. Создаем отдельный интерфейс для управления замками.
interface Lockable {
    void openDoor(); // Метод только для дверей/замков
}

// 3. Лампочка теперь "подписывается" только на Switchable.
// Она больше не обязана уметь открывать двери!
class LightBulb implements Switchable {
    @Override
    public void turnOn() {
        System.out.println("Лампочка: Свет включен");
    }
}

// 4. А это пример устройства, которое может и то, и другое (например, умная панель).
class SmartLock implements Lockable, Switchable {
    @Override
    public void turnOn() {
        System.out.println("Замок: Питание подано");
    }

    @Override
    public void openDoor() {
        System.out.println("Замок: Дверь открыта");
    }
}

// 5. Проверка в деле
 class Main5 {
    public static void main(String[] args) {
        LightBulb lamp = new LightBulb();
        lamp.turnOn(); // Работает! И никаких лишних методов.

        SmartLock lock = new SmartLock();
        lock.openDoor(); // Работает!
    }
}