package org.wildcraft.jpms.implicit.user.api.resources;

import java.util.UUID;

public class User {

    private UUID userId;

    private String name;

    public String getName() {
        return name;
    }

    public UUID getUserId() {
        return userId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User modifyUser(User user) {
        this.name = user.getName();
        return this;
    }

    public void setUserId(UUID userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return name;
    }
}
