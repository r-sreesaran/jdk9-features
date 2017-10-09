package org.wildcraft.jpms.versioning.api.impl;

import org.wildcraft.jpms.versioning.api.ServiceProviderSelector;
import org.wildcraft.jpms.versioning.api.Version;

import java.util.ServiceLoader;

public class ServiceProviderSelectorImpl implements ServiceProviderSelector {

    private static final ServiceProviderSelector INSTANCE = new ServiceProviderSelectorImpl();
    private ServiceProviderSelectorImpl() {

    }

    public static ServiceProviderSelector getInstance() {
        return INSTANCE;
    }

    @Override
    public <T> ServiceLoader.Provider<T> selectServiceProvider(Class<T> clazz) {
        System.out.printf("Class Name: "+clazz.getName());
        ServiceLoader<T> userServiceProviders = ServiceLoader.load(clazz);
        ServiceLoader.Provider<T> provider = userServiceProviders.stream().max((o1, o2) -> {
            Version v1 = ServiceProviderSelector.getLatestVersionObject(o1.getClass());
            Version v2 = ServiceProviderSelector.getLatestVersionObject(o2.getClass());
            if(v1.minor()==v2.minor() && v1.major()==v2.major()) {
                return 0;
            }
            if((v1.minor()>v2.minor() && v1.major()==v2.major())
                    || (v1.major() > v2.major())) {
                return 1;
            } else {
                return -1;
            }}).get();
        return provider;
    }
}
