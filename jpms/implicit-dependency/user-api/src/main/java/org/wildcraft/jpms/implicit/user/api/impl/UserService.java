package org.wildcraft.jpms.implicit.user.api.impl;

import org.wildcraft.jpms.implicit.user.api.UserAPI;
import org.wildcraft.jpms.implicit.user.api.resources.User;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class UserService implements UserAPI {

    public static final UserAPI INSTANCE = new UserService();

    private UserService(){

    }

    public static UserAPI getInstance() {
        return INSTANCE;
    }

    private List<User> users = new CopyOnWriteArrayList<>();

    @Override
    public List<User> listUsers() {
        return users;
    }

    @Override
    public User getUserByID(final UUID userId) {
        return users.stream().filter(o->o.getUserId().equals(userId)).findFirst().orElse(null);
    }

    @Override
    public void addUser(User user) {
        users.add(user);
    }

    @Override
    public void updateUser(User user) {
        users.remove(user);
        users.add(user);
    }

    @Override
    public void deleteUser(UUID userId) {
        User user = users.stream().filter(o->o.getUserId().equals(userId)).findFirst().orElse(null);
        users.remove(user);
    }
}
