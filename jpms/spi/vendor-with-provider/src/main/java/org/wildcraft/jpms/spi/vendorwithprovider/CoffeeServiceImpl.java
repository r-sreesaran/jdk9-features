package org.wildcraft.jpms.spi.vendorwithprovider;


import org.wildcraft.jpms.spi.agent.api.CoffeeService;

public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public String serveCoffee() {
        return "Madras Coffee !!!";
    }
}
