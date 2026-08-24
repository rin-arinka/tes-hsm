package com.tes.backend.service;

import com.tes.backend.entity.Produk;
import com.tes.backend.repository.ProdukRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProdukService {

    private final ProdukRepository repo;

    public List<Produk> findAll() {
        return repo.findAll();
    }

    public Produk findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan: " + id));
    }

    public Produk save(Produk produk) {
        return repo.save(produk);
    }

    public Produk update(Long id, Produk data) {
        Produk existing = findById(id);
        existing.setNama(data.getNama());
        existing.setDeskripsi(data.getDeskripsi());
        existing.setHarga(data.getHarga());
        existing.setStok(data.getStok());
        existing.setKategori(data.getKategori());
        existing.setGambarUrl(data.getGambarUrl());
        existing.setBerat(data.getBerat());
        existing.setAktif(data.getAktif());
        return repo.save(existing);
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
