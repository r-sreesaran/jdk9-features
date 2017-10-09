package org.wildcraft.jpms.versioning.api;

import org.wildcraft.jpms.versioning.api.impl.ServiceProviderSelectorImpl;
import org.wildcraft.jpms.versioning.api.provider.ServiceProviderSelectorProvider;

import java.util.ServiceLoader;

public interface ServiceProviderSelector {
    <T> ServiceLoader.Provider<T> selectServiceProvider(Class<T> clazz);

    static ServiceProviderSelector getServiceProvider() {
        ServiceLoader<ServiceProviderSelectorProvider> serviceProviderSelectorProvider = ServiceLoader.load(ServiceProviderSelectorProvider.class);
        ServiceProviderSelectorProvider provider = serviceProviderSelectorProvider.stream().findFirst().map(o->o.get()).orElseThrow(IllegalStateException::new);
        ServiceProviderSelector serviceProviderSelector = provider.getServiceProviderSelector();
        return serviceProviderSelector;
        //return new ServiceProviderSelectorImpl();
    }

    /*static <T> ServiceLoader.Provider<T> selectProvider(Class<T> clazz) {
        System.out.printf("Class Name: "+clazz.getName());
        ServiceLoader<T> userServiceProviders = ServiceLoader.load(clazz);
        ServiceLoader.Provider<T> provider = userServiceProviders.stream().max((o1, o2) -> {
            Version v1 = getLatestVersionObject(o1.getClass());
            Version v2 = getLatestVersionObject(o2.getClass());
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
    }*/

    static <T> Version getLatestVersionObject(Class<T> clazz){
        Module m = clazz.getModule();
        Version v = m.getAnnotation(Version.class);
        if(v == null) {
            throw new IllegalStateException();
        }
        return v;
    }
}
