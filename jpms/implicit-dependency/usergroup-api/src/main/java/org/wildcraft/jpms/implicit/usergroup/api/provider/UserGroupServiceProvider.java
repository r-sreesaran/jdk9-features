package org.wildcraft.jpms.implicit.usergroup.api.provider;

import org.wildcraft.jpms.implicit.usergroup.api.UserGroupAPI;

public interface UserGroupServiceProvider {
    UserGroupAPI getUserGroupService();
}
