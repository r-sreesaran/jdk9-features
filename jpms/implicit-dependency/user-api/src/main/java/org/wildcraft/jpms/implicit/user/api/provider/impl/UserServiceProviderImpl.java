package org.wildcraft.jpms.implicit.user.api.provider.impl;

import org.wildcraft.jpms.implicit.user.api.UserAPI;
import org.wildcraft.jpms.implicit.user.api.impl.UserService;
import org.wildcraft.jpms.implicit.user.api.provider.UserServiceProvider;

public class UserServiceProviderImpl implements UserServiceProvider {

    private static final UserServiceProvider INSTANCE = new UserServiceProviderImpl();

    private UserServiceProviderImpl() {
    }

    public static UserServiceProvider provider(){
        return INSTANCE;
    }

    @Override
    public UserAPI getUserService() {
        return UserService.getInstance();
    }
}
