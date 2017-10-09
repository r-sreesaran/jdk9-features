package org.wildcraft.jpms.implicit.usergroup.api.resources;

import org.wildcraft.jpms.implicit.user.api.UserAPI;
import org.wildcraft.jpms.implicit.user.api.resources.User;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class UserGroup {

    private UUID userGroupId;

    private String name;

    private List<User> users = new ArrayList<>();

    private UserAPI userAPI = UserAPI.service();

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public UUID getUserGroupId() {
        return userGroupId;
    }

    public void addUser(User user)
    {
        if(userAPI.getUserByID(user.getUserId())!=null) {
            users.add(user);
        }
    }

    public void removeUser(User user)
    {
        users.remove(user);
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof UserGroup)) {
            return false;
        }
        UserGroup that = (UserGroup)obj;
        if(this.userGroupId == that.userGroupId){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return name+","+users;
    }
}
