package com.msibptsei.demo.library.controller;

import com.msibptsei.demo.library.dto.ProyekDTO;
import com.msibptsei.demo.library.entity.Lokasi;
import com.msibptsei.demo.library.entity.Proyek;
import com.msibptsei.demo.library.service.ProyekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/proyek")
public class ProyekController {

    @Autowired
    private ProyekService proyekService;

    @PostMapping
    public ResponseEntity<ProyekDTO> createProyek(@RequestBody Proyek proyek) {
        Proyek savedProyek = proyekService.saveProyek(proyek);
        ProyekDTO proyekDTO = new ProyekDTO(
                savedProyek.getId(),
                savedProyek.getNamaProyek(),
                savedProyek.getClient(),
                savedProyek.getTglMulai(),
                savedProyek.getTglSelesai(),
                savedProyek.getPimpinanProyek(),
                savedProyek.getKeterangan(),
                savedProyek.getCreatedAt(),
                savedProyek.getLokasi() != null ? savedProyek.getLokasi().getId() : null
        );
        return ResponseEntity.ok(proyekDTO);
    }

    @GetMapping
    public List<Proyek> getAllProyek() {
        return proyekService.getAllProyek();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Proyek> getProyekById(@PathVariable Long id) {
        return proyekService.getProyekById(id)
                .map(proyek -> ResponseEntity.ok(proyek))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProyekDTO> updateProyek(@PathVariable Long id, @RequestBody Proyek proyekDetails) {
        return proyekService.getProyekById(id).map(proyek -> {
            proyek.setNamaProyek(proyekDetails.getNamaProyek());
            proyek.setClient(proyekDetails.getClient());
            proyek.setTglMulai(proyekDetails.getTglMulai());
            proyek.setTglSelesai(proyekDetails.getTglSelesai());
            proyek.setPimpinanProyek(proyekDetails.getPimpinanProyek());
            proyek.setKeterangan(proyekDetails.getKeterangan());
            proyek.setLokasi(proyekDetails.getLokasi());
            Proyek updatedProyek = proyekService.saveProyek(proyek);
            ProyekDTO proyekDTO = new ProyekDTO(
                    updatedProyek.getId(),
                    updatedProyek.getNamaProyek(),
                    updatedProyek.getClient(),
                    updatedProyek.getTglMulai(),
                    updatedProyek.getTglSelesai(),
                    updatedProyek.getPimpinanProyek(),
                    updatedProyek.getKeterangan(),
                    updatedProyek.getCreatedAt(),
                    updatedProyek.getLokasi() != null ? updatedProyek.getLokasi().getId() : null
            );
            return ResponseEntity.ok(proyekDTO);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProyek(@PathVariable Long id) {
        proyekService.deleteProyek(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
