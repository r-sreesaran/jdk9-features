package org.wildcraft.jpms.implicit.user.api.provider;

import org.wildcraft.jpms.implicit.user.api.UserAPI;

public interface UserServiceProvider {
    UserAPI getUserService();
}
