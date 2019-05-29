package com.unpad.trashcare;

public class User {
    String alamat, nama, no_telp, password;

    public User(String alamat, String nama, String no_telp, String password) {
        this.alamat = alamat;
        this.nama = nama;
        this.no_telp = no_telp;
        this.password = password;
    }

    public String getAlamat() {
        return alamat;
    }

    public String getNama() {
        return nama;
    }

    public String getNo_telp() {
        return no_telp;
    }

    public String getPassword() {
        return password;
    }
}
