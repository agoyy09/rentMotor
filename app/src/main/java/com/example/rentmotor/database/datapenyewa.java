package com.example.rentmotor.database;


public class datapenyewa {

    String id;
    String Nama;
    String Jidentitas;
    String Jpem;
    String Alamat;
    String Notelp;
    String TglPesan;
    String Jk;


    public datapenyewa() {
    }

    public datapenyewa(String id, String Nama, String Jidentitas, String  Jpem, String Alamat, String Notelp, String TglPesan, String Jk) {
        this.id = id;
        this.Nama = Nama;
        this.Jidentitas = Jidentitas;
        this. Jpem =  Jpem;
        this.Alamat = Alamat;
        this.Notelp = Notelp;
        this.TglPesan = TglPesan;
        this.Jk = Jk;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return Nama;
    }

    public void setNama(String Nama) {
        this.Nama = Nama;
    }

    public String getJidentitas() {
        return Jidentitas;
    }

    public void setJidentitas(String Jidentitas) {
        this.Jidentitas = Jidentitas;
    }

    public String getJpem() {
        return Jpem;
    }

    public void setJpem(String Jpem) {
        this.Jpem = Jpem;
    }

    public String getAlamat() {
        return Alamat;
    }

    public void setAlamat(String Alamat) {
        this.Alamat = Alamat;
    }

    public String getNotelp() {
        return Notelp;
    }

    public void setNotelp(String Notelp) {
        this.Notelp = Notelp;
    }

    public String getTglPesan() {
        return TglPesan;
    }

    public void setTglPesan(String TglPesan) {
        this.TglPesan = TglPesan;
    }

    public String getJk() {
        return Jk;
    }

    public void setJk(String Jk) {
        this.Jk = Jk;
    }
}

