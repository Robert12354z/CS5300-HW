package Homework5.Decorator;

public class Main {

    public static void main(String[] args) {
        Food burger = new ConcreteFood(10.0);
        System.out.println("Base price: $" + burger.getPrice());

        burger = new Topping(burger, 2.0);
        System.out.println("Price after adding topping: $" + burger.getPrice());

        burger = new Topping(burger, 3.0);
        System.out.println("Price after adding another topping: $" + burger.getPrice());

        CustomerLoyalty loyalty = new CustomerLoyalty(0.15,false);

        System.out.println("Loyalty status: " + loyalty.getLoyal());
        System.out.println("Loyalty discount: " + loyalty.getDiscount()*100 + "%");
        Order order = new Order(loyalty);
        order.addFood(burger);
        System.out.println("Total price: $" + order.calculateTotal());


    }
    
}
