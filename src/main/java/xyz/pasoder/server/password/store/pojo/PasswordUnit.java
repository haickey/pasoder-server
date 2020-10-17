package xyz.pasoder.server.password.store.pojo;

import lombok.Data;

@Data
public class PasswordUnit {
    private long passwordUnitId;
    private String ip;
    private String name;
    private String enCryPassword;
    private String deCryPassword;
    private String password;
    private String description;

//    public String getEnCryPassword() {
//        return password;
//    }
//
//    public void setEnCryPassword(final String enCryPassword) {
//        this.password = enCryPassword;
//    }
//
//    public String getDeCryPassword() {
//        return password;
//    }
//
//    public void setDeCryPassword(final String deCryPassword) {
//        this.password = deCryPassword;
//    }
}
