/**
 * Главный класс для демонстрации работы системы
 */
public class ComputerSystem {
    public static void main(String[] args) {
        // Создаем компоненты компьютера
        SystemUnit systemUnit = new SystemUnit("Dell PowerEdge", 500);
        Monitor monitor = new Monitor("LG UltraHD", 24.0);
        Keyboard keyboard = new Keyboard("Logitech K120", "мембранная");
        Mouse mouse = new Mouse("Logitech M90", "оптическая");
        
        // Создаем компьютер
        Computer computer = new Computer(101, "Аудитория 305", 
                                      systemUnit, monitor, keyboard, mouse);
        
        // Демонстрируем работу всех компонентов
        computer.displayComputerInfo();
        computer.performWorkCycle();
    }
}

/**
 * Класс, представляющий компьютер
 */
class Computer {
    private final int id;
    private final String room;
    private final SystemUnit systemUnit;
    private final Monitor monitor;
    private final Keyboard keyboard;
    private final Mouse mouse;
    
    public Computer(int id, String room, SystemUnit systemUnit, 
                   Monitor monitor, Keyboard keyboard, Mouse mouse) {
        this.id = id;
        this.room = room;
        this.systemUnit = systemUnit;
        this.monitor = monitor;
        this.keyboard = keyboard;
        this.mouse = mouse;
    }
    
    /**
     * Выводит информацию о компьютере
     */
    public void displayComputerInfo() {
        System.out.println("\n=== Информация о компьютере ===");
        System.out.println("ID: " + id);
        System.out.println("Аудитория: " + room);
        System.out.println("Системный блок: " + systemUnit.getModel());
        System.out.println("Монитор: " + monitor.getModel());
        System.out.println("Клавиатура: " + keyboard.getModel());
        System.out.println("Мышь: " + mouse.getModel());
    }
    
    /**
     * Демонстрирует полный цикл работы компьютера
     */
    public void performWorkCycle() {
        System.out.println("\n=== Рабочий цикл компьютера ===");
        
        // Включение системы
        systemUnit.powerOn();
        monitor.turnOn();
        
        // Работа с устройствами ввода
        String program = keyboard.input("public class Main { public static void main(String[] args) { System.out.println(\"Hello World!\"); } }");
        mouse.click();
        mouse.move(100, 200);
        
        // Обработка данных
        systemUnit.process(program);
        
        // Отображение результата
        monitor.display("Hello World!");
        
        // Выключение системы
        systemUnit.powerOff();
        monitor.turnOff();
    }
    
    // Геттеры для всех полей
    public int getId() { return id; }
    public String getRoom() { return room; }
    public SystemUnit getSystemUnit() { return systemUnit; }
    public Monitor getMonitor() { return monitor; }
    public Keyboard getKeyboard() { return keyboard; }
    public Mouse getMouse() { return mouse; }
}

/**
 * Класс, представляющий системный блок
 */
class SystemUnit {
    private final String model;
    private final int power;
    private boolean isPoweredOn;
    
    public SystemUnit(String model, int power) {
        this.model = model;
        this.power = power;
        this.isPoweredOn = false;
    }
    
    public void powerOn() {
        isPoweredOn = true;
        System.out.println("Системный блок " + model + " включен");
    }
    
    public void powerOff() {
        isPoweredOn = false;
        System.out.println("Системный блок " + model + " выключен");
    }
    
    public void process(String program) {
        if (!isPoweredOn) {
            System.out.println("Ошибка: системный блок выключен!");
            return;
        }
        System.out.println("Системный блок " + model + " обрабатывает программу...");
        System.out.println("Задействовано " + (power / 2) + "W мощности");
    }
    
    // Геттеры
    public String getModel() { return model; }
    public int getPower() { return power; }
    public boolean isPoweredOn() { return isPoweredOn; }
}

/**
 * Класс, представляющий монитор
 */
class Monitor {
    private final String model;
    private final double size;
    private boolean isTurnedOn;
    
    public Monitor(String model, double size) {
        this.model = model;
        this.size = size;
        this.isTurnedOn = false;
    }
    
    public void turnOn() {
        isTurnedOn = true;
        System.out.println("Монитор " + model + " включен");
    }
    
    public void turnOff() {
        isTurnedOn = false;
        System.out.println("Монитор " + model + " выключен");
    }
    
    public void display(String message) {
        if (!isTurnedOn) {
            System.out.println("Ошибка: монитор выключен!");
            return;
        }
        System.out.println("Монитор " + model + " (" + size + "\"): " + message);
    }
    
    // Геттеры
    public String getModel() { return model; }
    public double getSize() { return size; }
    public boolean isTurnedOn() { return isTurnedOn; }
}

/**
 * Класс, представляющий клавиатуру
 */
class Keyboard {
    private final String model;
    private final String type;
    
    public Keyboard(String model, String type) {
        this.model = model;
        this.type = type;
    }
    
    public String input(String text) {
        System.out.println("Клавиатура " + model + " (" + type + ") получила ввод:");
        System.out.println(text);
        return text;
    }
    
    // Геттеры
    public String getModel() { return model; }
    public String getType() { return type; }
}

/**
 * Класс, представляющий мышь
 */
class Mouse {
    private final String model;
    private final String type;
    private int x;
    private int y;
    
    public Mouse(String model, String type) {
        this.model = model;
        this.type = type;
        this.x = 0;
        this.y = 0;
    }
    
    public void click() {
        System.out.println("Мышь " + model + " (" + type + ") кликнула в точке (" + x + "," + y + ")");
    }
    
    public void move(int newX, int newY) {
        this.x = newX;
        this.y = newY;
        System.out.println("Мышь " + model + " перемещена в позицию (" + x + "," + y + ")");
    }
    
    // Геттеры
    public String getModel() { return model; }
    public String getType() { return type; }
    public int getX() { return x; }
    public int getY() { return y; }
}