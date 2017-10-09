package org.wildcraft.jpms.spi.vendorwithprovider;

import org.wildcraft.jpms.spi.agent.api.CoffeeServiceProvider;

public class MadrasCoffeeProviderFactory {

    public static CoffeeServiceProvider provider() {
        return MadrasCoffeeProvider.getInstance();
    }
}
