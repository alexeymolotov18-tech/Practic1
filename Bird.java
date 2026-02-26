// Интерфейс — это "контракт". Он говорит: "Любой, кто меня реализует, обязан уметь летать".
interface Flyable {
    void fly(); // У метода нет тела, это просто декларация возможности.
}

// Базовый класс для всех птиц. Здесь пишем то, что умеют ВООБЩЕ ВСЕ птицы.
class Bird {
    public void eat() {
        // Все птицы едят, поэтому этот метод в базовом классе.
        System.out.println("Я кушаю");
    }
}

// Наследуемся от Bird. Страус — это птица.
// Мы НЕ добавляем сюда Flyable, потому что страусы не летают. Это и есть решение задачи!
class Ostrich extends Bird {
    @Override // Помечаем, что мы меняем поведение стандартного метода eat для страуса.
    public void eat() {
        System.out.println("Страус ест камни для пищеварения");
    }
}

// Воробей — это и птица (extends Bird), и он умеет летать (implements Flyable).
class Sparrow extends Bird implements Flyable {
    @Override // Реализуем контракт интерфейса Flyable.
    public void fly() {
        System.out.println("Я лечу!");
    }
}

// Главный класс, откуда запускается вся программа.
class Main {

    public static void main(String[] args) {

        // Создаем объект типа Bird, но по факту это Страус.
        Bird myOstrich = new Ostrich();
        myOstrich.eat(); // Вызовет метод страуса.

        // Создаем воробья.
        Sparrow mySparrow = new Sparrow();
        mySparrow.fly(); // Воробей умеет летать, у него есть этот метод.
    }
}