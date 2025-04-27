package org.example.backend.enums;

public enum UserRole {
    TRAVELER, ADMIN;

    public String getAuthority() {
        return "ROLE_" + this.name();
    }
}
