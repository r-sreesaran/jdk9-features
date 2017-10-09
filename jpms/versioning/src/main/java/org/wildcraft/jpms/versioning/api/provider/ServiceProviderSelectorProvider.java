package org.wildcraft.jpms.versioning.api.provider;

import org.wildcraft.jpms.versioning.api.ServiceProviderSelector;

import java.util.ServiceLoader;

public interface ServiceProviderSelectorProvider {
    ServiceProviderSelector getServiceProviderSelector();
}
