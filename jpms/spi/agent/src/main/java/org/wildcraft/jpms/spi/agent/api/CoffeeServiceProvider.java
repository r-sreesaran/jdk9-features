package org.wildcraft.jpms.spi.agent.api;

import org.wildcraft.jpms.spi.agent.api.CoffeeService;

public interface CoffeeServiceProvider {
    double rating();
    CoffeeService getCoffeeServiceVendor();
}
