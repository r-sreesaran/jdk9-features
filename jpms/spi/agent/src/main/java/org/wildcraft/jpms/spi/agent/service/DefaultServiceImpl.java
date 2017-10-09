package org.wildcraft.jpms.spi.agent.service;

import org.wildcraft.jpms.spi.agent.api.CoffeeService;

public class DefaultServiceImpl implements CoffeeService {

    @Override
    public String serveCoffee() {
        return "Agent Coffee House!!!";
    }
}
