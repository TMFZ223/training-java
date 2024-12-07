package Homework1;

public class Product {
/*
Задание №1.
Класс содержит следующие поля: количество, стоимость, скидка.
В классе реализован метод для подсчёта суммы без скидки и суммы со скидкой.
В следующем классе вызываются 3 объекта класса товара, где показывается сумма без скидки и сумма со скидкой.
*/
    private int quantity; // Количество товаров
    private double cost; // Цена товара
    private double discount; // Скидка на товар

    public Product(int quantity, double cost, double discount) {
        this.quantity = quantity;
        this.cost = cost;
        this.discount = discount;
    }

    public void calculateAmount() {
        double amountWithoutDiscount = quantity * cost; // Расчёт суммы без скидки
        double amountWithDiscount = amountWithoutDiscount * (1 - discount / 100); // Расчёт суммы со скидкой
        System.out.printf("Сумма без скидки: %.2f%n", amountWithoutDiscount);
        System.out.printf("Сумма со скидкой: %.2f%n", amountWithDiscount);
    }
}