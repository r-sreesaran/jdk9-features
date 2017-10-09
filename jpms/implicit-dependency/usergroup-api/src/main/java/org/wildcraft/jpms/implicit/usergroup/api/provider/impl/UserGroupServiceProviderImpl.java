package org.wildcraft.jpms.implicit.usergroup.api.provider.impl;

import org.wildcraft.jpms.implicit.usergroup.api.UserGroupAPI;
import org.wildcraft.jpms.implicit.usergroup.api.impl.UserGroupService;
import org.wildcraft.jpms.implicit.usergroup.api.provider.UserGroupServiceProvider;

public class UserGroupServiceProviderImpl implements UserGroupServiceProvider {

    private static final UserGroupServiceProvider INSTANCE = new UserGroupServiceProviderImpl();

    private UserGroupServiceProviderImpl(){

    }

    @Override
    public UserGroupAPI getUserGroupService() {
        return UserGroupService.getInstance();
    }

    public static UserGroupServiceProvider provider() {
        return INSTANCE;
    }
}
