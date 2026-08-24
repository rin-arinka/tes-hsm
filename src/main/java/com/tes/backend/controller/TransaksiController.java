package com.tes.backend.controller;

import com.tes.backend.dto.TransaksiRequest;
import com.tes.backend.entity.Transaksi;
import com.tes.backend.service.TransaksiService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/transaksi")
@RequiredArgsConstructor
public class TransaksiController {

    private final TransaksiService service;

    @GetMapping
    public List<Transaksi> findAll() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Transaksi findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping
    public Transaksi create(@RequestBody TransaksiRequest req) {
        return service.create(req);
    }

    @PutMapping("/{id}")
    public Transaksi update(@PathVariable Long id, @RequestBody TransaksiRequest req) {
        return service.update(id, req);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
