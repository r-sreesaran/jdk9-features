package org.wildcraft.jpms.versioning.api.provider.impl;

import org.wildcraft.jpms.versioning.api.ServiceProviderSelector;
import org.wildcraft.jpms.versioning.api.impl.ServiceProviderSelectorImpl;
import org.wildcraft.jpms.versioning.api.provider.ServiceProviderSelectorProvider;

public class ServiceProviderSelectorProviderImpl implements ServiceProviderSelectorProvider {

    private static final ServiceProviderSelectorProvider INSTANCE = new ServiceProviderSelectorProviderImpl();

    @Override
    public ServiceProviderSelector getServiceProviderSelector() {
        return ServiceProviderSelectorImpl.getInstance();
    }

    public static ServiceProviderSelectorProvider provider() {
        return INSTANCE;
    }
}
