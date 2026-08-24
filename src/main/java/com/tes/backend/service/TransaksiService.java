package com.tes.backend.service;

import com.tes.backend.dto.TransaksiRequest;
import com.tes.backend.entity.Produk;
import com.tes.backend.entity.Transaksi;
import com.tes.backend.entity.TransaksiItem;
import com.tes.backend.repository.ProdukRepository;
import com.tes.backend.repository.TransaksiRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransaksiService {

    private final TransaksiRepository transaksiRepo;
    private final ProdukRepository produkRepo;

    public List<Transaksi> findAll() {
        return transaksiRepo.findAll();
    }

    public Transaksi findById(Long id) {
        return transaksiRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Transaksi tidak ditemukan: " + id));
    }

    @Transactional
    public Transaksi create(TransaksiRequest req) {
        Transaksi transaksi = new Transaksi();
        mapFields(transaksi, req);
        return transaksiRepo.save(transaksi);
    }

    @Transactional
    public Transaksi update(Long id, TransaksiRequest req) {
        Transaksi transaksi = findById(id);
        transaksi.getItems().clear();
        mapFields(transaksi, req);
        return transaksiRepo.save(transaksi);
    }

    public void delete(Long id) {
        transaksiRepo.deleteById(id);
    }

    private void mapFields(Transaksi transaksi, TransaksiRequest req) {
        transaksi.setTanggal(req.getTanggal());
        transaksi.setStatus(req.getStatus());
        transaksi.setMetodePembayaran(req.getMetodePembayaran());
        transaksi.setAlamatPengiriman(req.getAlamatPengiriman());
        transaksi.setNomorResi(req.getNomorResi());
        transaksi.setCatatanPembeli(req.getCatatanPembeli());

        List<TransaksiItem> items = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;

        for (TransaksiRequest.ItemRequest itemReq : req.getItems()) {
            Produk produk = produkRepo.findById(itemReq.getProdukId())
                    .orElseThrow(() -> new RuntimeException("Produk tidak ditemukan: " + itemReq.getProdukId()));

            TransaksiItem item = new TransaksiItem();
            item.setTransaksi(transaksi);
            item.setProduk(produk);
            item.setJumlah(itemReq.getJumlah());
            item.setHarga(itemReq.getHarga());

            total = total.add(itemReq.getHarga().multiply(BigDecimal.valueOf(itemReq.getJumlah())));
            items.add(item);
        }

        transaksi.setTotal(total);
        if (transaksi.getItems() == null) {
            transaksi.setItems(items);
        } else {
            transaksi.getItems().addAll(items);
        }
    }
}
