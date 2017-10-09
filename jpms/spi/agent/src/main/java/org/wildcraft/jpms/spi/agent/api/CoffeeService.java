package org.wildcraft.jpms.spi.agent.api;

import java.util.Iterator;
import java.util.ServiceLoader;

public interface CoffeeService {
    String serveCoffee();

    static CoffeeService getVendor() {
        ServiceLoader<CoffeeServiceProvider> coffeeServiceProviders = ServiceLoader.load(CoffeeServiceProvider.class);
        // load, reload & caching the object can be done
        // Every consumer will anyway will get its separate spi impl object
        Iterator<CoffeeServiceProvider> iterator = coffeeServiceProviders.iterator();
        if(!iterator.hasNext()) {
            throw new RuntimeException("No Service Providers found!!!");
        }
        CoffeeServiceProvider coffeeServiceProvider = coffeeServiceProviders.stream().min((o1, o2) -> {if(o1.get().rating()==o2.get().rating()) {
            return 0;
        } else if(o1.get().rating()<o2.get().rating()) {
            return -1;
        } else {
        return  1;
        }
        }).map(o->o.get()).orElse(null);

        //CoffeeServiceProvider coffeeServiceProvider = iterator.next();
        return coffeeServiceProvider.getCoffeeServiceVendor();
    }
}
