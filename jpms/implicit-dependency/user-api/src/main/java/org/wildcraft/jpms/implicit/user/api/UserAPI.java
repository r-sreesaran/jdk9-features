package org.wildcraft.jpms.implicit.user.api;

import org.wildcraft.jpms.implicit.user.api.provider.UserServiceProvider;
import org.wildcraft.jpms.implicit.user.api.resources.User;
import org.wildcraft.jpms.versioning.api.ServiceProviderSelector;
import org.wildcraft.jpms.versioning.api.Version;

import java.util.List;
import java.util.ServiceLoader;
import java.util.UUID;

public interface UserAPI {

    static <T> ServiceLoader.Provider<T> selectProvider(Class<T> clazz) {
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
    }

    static <T> Version getLatestVersionObject(Class<T> clazz){
        Module m = clazz.getModule();
        Version v = m.getAnnotation(Version.class);
        if(v == null) {
            throw new IllegalStateException();
        }
        return v;
    }

    static UserAPI service() {

        /*ServiceLoader<UserServiceProvider> userServiceProviders = ServiceLoader.load(UserServiceProvider.class);
        UserServiceProvider provider = userServiceProviders.stream().findFirst().map(o->o.get()).orElseThrow(IllegalStateException::new);
        return provider.getUserService();*/

        //ServiceProviderSelector serviceProviderSelector = ServiceProviderSelector.getServiceProvider();
        ServiceLoader.Provider<UserServiceProvider> serviceProvider = selectProvider(UserServiceProvider.class);
        UserServiceProvider userServiceProvider = serviceProvider.get();
        return userServiceProvider.getUserService();
    }

    List<User> listUsers();
    User getUserByID(UUID userId);
    void addUser(User user);
    void updateUser(User user);
    void deleteUser(UUID userId);
}
