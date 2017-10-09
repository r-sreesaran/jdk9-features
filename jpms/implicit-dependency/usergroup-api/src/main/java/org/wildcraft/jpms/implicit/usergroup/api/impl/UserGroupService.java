package org.wildcraft.jpms.implicit.usergroup.api.impl;

import org.wildcraft.jpms.implicit.usergroup.api.UserGroupAPI;
import org.wildcraft.jpms.implicit.usergroup.api.resources.UserGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserGroupService implements UserGroupAPI {

    private static final UserGroupAPI INSTANCE = new UserGroupService();

    private List<UserGroup> userGroups = new CopyOnWriteArrayList<>();

    public static UserGroupAPI getInstance() {
        return INSTANCE;
    }

    private UserGroupService(){

    }

    @Override
    public List<UserGroup> listGroups() {
        return userGroups;
    }

    @Override
    public void createGroup(UserGroup userGroup) {
        userGroups.add(userGroup);
    }

    @Override
    public void updateGroup(UserGroup userGroup) {
        userGroups.remove(userGroup);
        userGroups.add(userGroup);
    }

    @Override
    public void deleteGroup(UserGroup userGroup) {
        userGroups.remove(userGroup);
    }
}
