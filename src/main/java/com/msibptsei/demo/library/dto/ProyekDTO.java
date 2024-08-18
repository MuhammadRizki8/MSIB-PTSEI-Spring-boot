package com.msibptsei.demo.library.dto;

import java.time.LocalDateTime;

public class ProyekDTO {

    private Long id;
    private String namaProyek;
    private String client;
    private LocalDateTime tglMulai;
    private LocalDateTime tglSelesai;
    private String pimpinanProyek;
    private String keterangan;
    private LocalDateTime createdAt;
    private Long lokasiId; // Only ID of the lokasi

    // Constructors, getters, and setters
    public ProyekDTO() {}

    public ProyekDTO(Long id, String namaProyek, String client, LocalDateTime tglMulai, LocalDateTime tglSelesai,
                     String pimpinanProyek, String keterangan, LocalDateTime createdAt, Long lokasiId) {
        this.id = id;
        this.namaProyek = namaProyek;
        this.client = client;
        this.tglMulai = tglMulai;
        this.tglSelesai = tglSelesai;
        this.pimpinanProyek = pimpinanProyek;
        this.keterangan = keterangan;
        this.createdAt = createdAt;
        this.lokasiId = lokasiId;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNamaProyek() { return namaProyek; }
    public void setNamaProyek(String namaProyek) { this.namaProyek = namaProyek; }

    public String getClient() { return client; }
    public void setClient(String client) { this.client = client; }

    public LocalDateTime getTglMulai() { return tglMulai; }
    public void setTglMulai(LocalDateTime tglMulai) { this.tglMulai = tglMulai; }

    public LocalDateTime getTglSelesai() { return tglSelesai; }
    public void setTglSelesai(LocalDateTime tglSelesai) { this.tglSelesai = tglSelesai; }

    public String getPimpinanProyek() { return pimpinanProyek; }
    public void setPimpinanProyek(String pimpinanProyek) { this.pimpinanProyek = pimpinanProyek; }

    public String getKeterangan() { return keterangan; }
    public void setKeterangan(String keterangan) { this.keterangan = keterangan; }

    public LocalDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }

    public Long getLokasiId() { return lokasiId; }
    public void setLokasiId(Long lokasiId) { this.lokasiId = lokasiId; }
}