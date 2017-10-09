package org.wildcraft.jpms.spi.vendor;

import org.wildcraft.jpms.spi.agent.api.CoffeeService;

public class CoffeeServiceImpl implements CoffeeService {

    @Override
    public String serveCoffee() {
        return "Cafe Day's Coffee";
    }
}
