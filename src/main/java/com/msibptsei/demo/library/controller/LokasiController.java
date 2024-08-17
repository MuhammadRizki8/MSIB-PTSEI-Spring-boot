package com.msibptsei.demo.library.controller;

import com.msibptsei.demo.library.entity.Lokasi;
import com.msibptsei.demo.library.service.LokasiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lokasi")
public class LokasiController {

    @Autowired
    private LokasiService lokasiService;

    @PostMapping
    public Lokasi createLokasi(@RequestBody Lokasi lokasi) {
        return lokasiService.saveLokasi(lokasi);
    }

    @GetMapping
    public List<Lokasi> getAllLokasi() {
        return lokasiService.getAllLokasi();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Lokasi> updateLokasi(@PathVariable Long id, @RequestBody Lokasi lokasiDetails) {
        return lokasiService.getLokasiById(id).map(lokasi -> {
            lokasi.setNamaLokasi(lokasiDetails.getNamaLokasi());
            lokasi.setNegara(lokasiDetails.getNegara());
            lokasi.setProvinsi(lokasiDetails.getProvinsi());
            lokasi.setKota(lokasiDetails.getKota());
            Lokasi updatedLokasi = lokasiService.saveLokasi(lokasi);
            return ResponseEntity.ok(updatedLokasi);
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLokasi(@PathVariable Long id) {
        lokasiService.deleteLokasi(id);
		return new ResponseEntity<>(HttpStatus.OK);
    }    
}