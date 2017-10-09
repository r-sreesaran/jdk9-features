package org.wildcraft.jpms.spi.vendorwithprovider;


import org.wildcraft.jpms.spi.agent.api.CoffeeService;
import org.wildcraft.jpms.spi.agent.api.CoffeeServiceProvider;

public class MadrasCoffeeProvider implements CoffeeServiceProvider {

    public static final MadrasCoffeeProvider INSTANCE = new MadrasCoffeeProvider();

    private MadrasCoffeeProvider() {

    }

    public static MadrasCoffeeProvider getInstance() {
        return INSTANCE;
    }

    @Override
    public double rating() {
        return 4.5;
    }

    @Override
    public CoffeeService getCoffeeServiceVendor() {
        return new CoffeeServiceImpl();
    }
}
