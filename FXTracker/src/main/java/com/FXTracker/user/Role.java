package com.FXTracker.user;

public enum Role {

    ADMIN("Admin"),
    CLIENT("Client");
    final String description;

    Role(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }


}
