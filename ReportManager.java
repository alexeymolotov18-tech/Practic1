import java.io.PrintWriter;

// 1. Класс-калькулятор. Его единственная забота — математика.
class Calculator {
    public double calculateData() {
        // Здесь только логика расчетов
        return 500.0 * 1.2;
    }
}

// 2. Класс-форматировщик. Он отвечает только за внешний вид текста.
class ReportFormatter {
    public String formatReport(double data) {
        // Здесь мы решаем, как будет выглядеть отчет (строка, JSON, HTML и т.д.)
        return "Отчет: " + data;
    }
}

// 3. Класс-хранитель. Его задача — просто записать готовую строку в файл.
class FileSaver {
    public void saveToFile(String filename, String content) {
        // Здесь только работа с файловой системой
        try (PrintWriter out = new PrintWriter(filename)) {
            out.println(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// 4. Теперь ReportManager просто "дирижирует" этими классами.
class ReportManager {
    public void processReport() {
        // Создаем инструменты
        Calculator calculator = new Calculator();
        ReportFormatter formatter = new ReportFormatter();
        FileSaver saver = new FileSaver();

        // Поэтапно выполняем работу
        double data = calculator.calculateData();       // Считаем
        String report = formatter.formatReport(data);    // Оформляем
        saver.saveToFile("report.txt", report);        // Сохраняем
    }
}

// Класс для запуска, чтобы ты мог проверить результат в IDEA
 class Main3 {
    public static void main(String[] args) {
        ReportManager manager = new ReportManager();
        manager.processReport();
        System.out.println("Отчет успешно создан!");
    }
}