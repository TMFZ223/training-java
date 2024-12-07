package Homework1;

class Main {
    public static void main(String[] args) {
        Product   product1 = new Product(5, 5075.231, 0.75); // Первый объект класса Product
        System.out.println("Информация о первом товаре:");
        product1.calculateAmount();
        Product product2 = new Product(10, 10000, 42.575); // Второй объект класса Product
        System.out.println("Информация о втором товаре:");
        product2.calculateAmount();
        Product product3 = new Product(3, 7240.940, 59.1); // Третий объект класса Product
        System.out.println("Информация о третьем товаре:");
        product3.calculateAmount();
    }
}