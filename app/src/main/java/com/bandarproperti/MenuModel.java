package com.bandarproperti;

public class MenuModel {

    private String judul;
    private String gambar;
    private String fasilitas;
    private String harga;
    private String lokasi;
    private String kategori_lokasi;
    private String id_properti;
    private String kamar_tidur;
    private String kamar_mandi;
    private String garasi;
    private String luas_area;
    private String luas_bangunan;
    private String deskripsi;
    private String fitur;
    private String map;

    public MenuModel(String judul, String gambar, String fasilitas,String harga, String lokasi,
                     String kategori_lokasi, String id_properti, String kamar_tidur,
                     String kamar_mandi,String garasi, String luas_area, String luas_bangunan,
                     String deskripsi, String fitur, String map) {

        this.judul = judul;
        this.gambar = gambar;
        this.fasilitas = fasilitas;
        this.harga = harga;
        this.lokasi = lokasi;
        this.kategori_lokasi = kategori_lokasi;
        this.id_properti = id_properti;
        this.kamar_tidur = kamar_tidur;
        this.kamar_mandi = kamar_mandi;
        this.garasi = garasi;
        this.luas_area = luas_area;
        this.luas_bangunan = luas_bangunan;
        this.deskripsi = deskripsi;
        this.fitur = fitur;
        this.map = map;

    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getFasilitas() {
        return fasilitas;
    }

    public void setFasilitas(String fasilitas) {
        this.fasilitas = fasilitas;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getLokasi() {
        return lokasi;
    }

    public void setLokasi(String lokasi) {
        this.lokasi = lokasi;
    }

    public String getKategori_lokasi() {
        return kategori_lokasi;
    }

    public void setKategori_lokasi(String kategori_lokasi) {
        this.kategori_lokasi = kategori_lokasi;
    }

    public String getId_properti() {
        return id_properti;
    }

    public void setId_properti(String id_properti) {
        this.id_properti = id_properti;
    }

    public String getKamar_tidur() {
        return kamar_tidur;
    }

    public void setKamar_tidur(String kamar_tidur) {
        this.kamar_tidur = kamar_tidur;
    }

    public String getKamar_mandi() {
        return kamar_mandi;
    }

    public void setKamar_mandi(String kamar_mandi) {
        this.kamar_mandi = kamar_mandi;
    }

    public String getGarasi() {
        return garasi;
    }

    public void setGarasi(String garasi) {
        this.garasi = garasi;
    }

    public String getLuas_area() {
        return luas_area;
    }

    public void setLuas_area(String luas_area) {
        this.luas_area = luas_area;
    }

    public String getLuas_bangunan() {
        return luas_bangunan;
    }

    public void setLuas_bangunan(String luas_bangunan) {
        this.luas_bangunan = luas_bangunan;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getFitur() {
        return fitur;
    }

    public void setFitur(String fitur) {
        this.fitur = fitur;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
