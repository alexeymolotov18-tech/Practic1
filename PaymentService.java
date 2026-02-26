// 1. Создаем интерфейс. Это "общий стандарт" для всех способов оплаты.
interface PaymentMethod {
    void pay(double amount); // Каждый способ оплаты обязан иметь метод pay
}

// 2. Реализуем оплату картой.
class CreditCardPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " р. через Credit Card");
    }
}

// 3. Реализуем оплату через PayPal.
class PayPalPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Оплачено " + amount + " р. через PayPal");
    }
}

// 4. Теперь PaymentService стал "универсальным".
class PaymentService {
    // Вместо строки "type", мы принимаем объект, который ГАРАНТИРОВАННО умеет платить.
    public void processPayment(PaymentMethod method, double amount) {
        // Нам больше не нужны if (type == "...")!
        // Мы просто вызываем метод pay, не зная, карта это или PayPal.
        method.pay(amount);
    }
}

// 5. Проверяем в Main
class Main2 {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();

        // Захотели оплатить картой:
        service.processPayment(new CreditCardPayment(), 100.0);

        // Захотели через PayPal:
        service.processPayment(new PayPalPayment(), 500.0);
    }
}