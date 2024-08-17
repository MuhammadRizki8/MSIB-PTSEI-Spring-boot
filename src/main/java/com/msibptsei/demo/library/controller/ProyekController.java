package com.msibptsei.demo.library.controller;

import com.msibptsei.demo.library.entity.Proyek;
import com.msibptsei.demo.library.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public Proyek createProyek(@RequestBody Proyek proyek) {
        return proyekService.saveProyek(proyek);
    }

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekService.getAllProyek();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Proyek> updateProyek(@PathVariable Long id, @RequestBody Proyek proyekDetails) {
        return proyekService.getProyekById(id).map(proyek -> {
            proyek.setNamaProyek(proyekDetails.getNamaProyek());
            proyek.setClient(proyekDetails.getClient());
            proyek.setTglMulai(proyekDetails.getTglMulai());
            proyek.setTglSelesai(proyekDetails.getTglSelesai());
            proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
            proyek.setKeterangan(proyekDetails.getKeterangan());
            proyek.setLokasi(proyekDetails.getLokasi());
            Proyek updatedProyek = proyekService.saveProyek(proyek);
            return ResponseEntity.ok(updatedProyek);
        }).orElse(ResponseEntity.notFound().build());
    }

    // @DeleteMapping("/{id}")
    // public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
    //     return proyekService.getProyekById(id).map(proyek -> {
    //         proyekService.deleteProyek(id);
    //         return ResponseEntity.ok().build();
    //     }).orElse(ResponseEntity.notFound().build());
    // }
}