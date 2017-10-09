package org.wildcraft.jpms.implicit.ums.client;

import org.wildcraft.jpms.implicit.user.api.UserAPI;
import org.wildcraft.jpms.implicit.user.api.resources.User;
import org.wildcraft.jpms.implicit.usergroup.api.UserGroupAPI;
import org.wildcraft.jpms.implicit.usergroup.api.resources.UserGroup;

import java.util.UUID;

public class UmsClient {
    public static void main(String[] args) {
        UserAPI userAPI = UserAPI.service();
        User user = new User();
        user.setName("Ragu");
        user.setUserId(new UUID(1l, 1l));
        userAPI.addUser(user);


        UserGroupAPI userGroupAPI = UserGroupAPI.service();
        UserGroup userGroup = new UserGroup();
        userGroup.setName("QA");
        userGroup.addUser(user);

        System.out.printf("userGroup: "+userGroup);
    }
}
