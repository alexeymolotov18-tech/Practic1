// 1. Создаем абстракцию. Кнопке всё равно, КТО это будет.
// Ей важно, чтобы устройство умело реагировать на команду turnOn.
interface SwitchableDevice {
    void turnOn();
}

// 2. Лампа теперь "подписывается" на этот стандарт.
class ConcreteLamp implements SwitchableDevice {
    @Override
    public void turnOn() {
        System.out.println("Лампа: Свет горит");
    }
}

// 3. Добавим Вентилятор, чтобы доказать, что кнопка теперь универсальна.
class Fan implements SwitchableDevice {
    @Override
    public void turnOn() {
        System.out.println("Вентилятор: Лопасти крутятся");
    }
}

// 4. ГЛАВНЫЙ МОМЕНТ: Кнопка больше не создает лампу сама!
class Button {
    // Мы создаем поле типа интерфейса, а не конкретного класса.
    private SwitchableDevice device;

    // Конструктор: мы "подсовываем" кнопке любое устройство в момент создания.
    // Это называется Dependency Injection (Внедрение зависимости).
    public Button(SwitchableDevice device) {
        this.device = device;
    }

    public void poll() {
        // Кнопка просто просит устройство включиться. Она не знает, лампа это или фен.
        device.turnOn();
    }
}

// Класс для проверки
class Main4 {
    public static void main(String[] args) {
        // Создаем лампу и даем её кнопке
        Button lampButton = new Button(new ConcreteLamp());
        lampButton.poll();

        // Создаем вентилятор и даем его ТАКОЙ ЖЕ кнопке
        Button fanButton = new Button(new Fan());
        fanButton.poll();
    }
}