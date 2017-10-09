package org.wildcraft.jpms.spi.agent.service;

import org.wildcraft.jpms.spi.agent.api.CoffeeService;
import org.wildcraft.jpms.spi.agent.api.CoffeeServiceProvider;

public class AgentCoffeeProviderImpl implements CoffeeServiceProvider {

    private long rating;

    public AgentCoffeeProviderImpl(long rating) {
        this.rating = rating;
    }

    public static CoffeeServiceProvider provider() {
        return new AgentCoffeeProviderImpl(3);
    }

    @Override
    public double rating() {
        return rating;
    }

    @Override
    public CoffeeService getCoffeeServiceVendor() {
        return new DefaultServiceImpl();
    }
}
