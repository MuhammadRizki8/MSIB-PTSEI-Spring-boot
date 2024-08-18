package com.msibptsei.demo.library.service;

import com.msibptsei.demo.library.entity.Proyek;
import com.msibptsei.demo.library.repository.ProyekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProyekService {

    @Autowired
    private ProyekRepository proyekRepository;


    public Proyek saveProyek(Proyek proyek) {
        return proyekRepository.save(proyek);
    }

    public List<Proyek> getAllProyek() {
        return proyekRepository.findAll();
    }

    public Optional<Proyek> getProyekById(Long id) {
        return proyekRepository.findById(id);
    }

    public void deleteProyek(Long id) {
        proyekRepository.deleteById(id);
    }
}
