package com.tes.backend.controller;

import com.tes.backend.entity.Produk;
import com.tes.backend.service.ProdukService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produk")
@RequiredArgsConstructor
public class ProdukController {

    private final ProdukService service;

    @GetMapping
    public List<Produk> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Produk findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Produk create(@RequestBody Produk produk) {
        return service.save(produk);
    }

    @PutMapping("/{id}")
    public Produk update(@PathVariable Long id, @RequestBody Produk produk) {
        return service.update(id, produk);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
