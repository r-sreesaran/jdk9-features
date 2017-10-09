package org.wildcraft.jpms.spi.vendor;


import org.wildcraft.jpms.spi.agent.api.CoffeeService;
import org.wildcraft.jpms.spi.agent.api.CoffeeServiceProvider;

public class CafeDayCoffeeProvider implements CoffeeServiceProvider {

    @Override
    public double rating() {
        return 4;
    }

    @Override
    public CoffeeService getCoffeeServiceVendor() {
        return new CoffeeServiceImpl();
    }
}
