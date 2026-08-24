package com.tes.backend.dto;

import com.tes.backend.enums.MetodePembayaran;
import com.tes.backend.enums.StatusTransaksi;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
public class TransaksiRequest {

    private LocalDateTime tanggal;
    private StatusTransaksi status;
    private MetodePembayaran metodePembayaran;
    private String alamatPengiriman;
    private String nomorResi;
    private String catatanPembeli;
    private List<ItemRequest> items;

    @Data
    public static class ItemRequest {
        private Long produkId;
        private Integer jumlah;
        private BigDecimal harga;
    }
}
