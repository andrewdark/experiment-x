package ua.pp.darknsoft.models;

public enum AuthorityName {
    ROLE_USER, ROLE_ADMIN;

    @Override
    public String toString() {
        return name();
    }
}
