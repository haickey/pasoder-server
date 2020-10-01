package xyz.pasoder.server.password.store.pojo;

import lombok.Data;

@Data
public class PasswordUnit {
    private long passwordUnitId;
    private String ip;
    private String name;
    private String password;
    private String description;
}
