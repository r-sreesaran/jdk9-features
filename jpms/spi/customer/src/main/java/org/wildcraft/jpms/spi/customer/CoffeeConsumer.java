package org.wildcraft.jpms.spi.customer;


import org.wildcraft.jpms.spi.agent.api.CoffeeService;

public class CoffeeConsumer {

    public static void main(String[] args) {
        CoffeeService coffeeService = CoffeeService.getVendor();
        System.out.println(coffeeService.serveCoffee());
    }

}
