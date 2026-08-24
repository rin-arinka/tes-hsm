package com.tes.backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

@RestController
@RequestMapping("/dummy")
public class DummyController {

    @GetMapping("/produk")
    public List<Map<String, Object>> produk() {
        return List.of(
            Map.ofEntries(
                entry("id", 1),
                entry("nama", "Sepatu Lari Nike Air Max"),
                entry("deskripsi", "Sepatu lari ringan dengan teknologi Air Max untuk kenyamanan maksimal."),
                entry("harga", 1250000),
                entry("stok", 42),
                entry("kategori", "Sepatu"),
                entry("gambarUrl", "https://placehold.co/400x400?text=Sepatu+Nike"),
                entry("berat", 0.8),
                entry("aktif", true),
                entry("createdAt", "2026-08-01T09:00:00"),
                entry("updatedAt", "2026-08-20T14:30:00")
            ),
            Map.ofEntries(
                entry("id", 2),
                entry("nama", "Kaos Polos Cotton Combed 30s"),
                entry("deskripsi", "Kaos polos bahan cotton combed 30s, adem dan nyaman dipakai sehari-hari."),
                entry("harga", 85000),
                entry("stok", 150),
                entry("kategori", "Pakaian"),
                entry("gambarUrl", "https://placehold.co/400x400?text=Kaos+Polos"),
                entry("berat", 0.2),
                entry("aktif", true),
                entry("createdAt", "2026-08-02T10:00:00"),
                entry("updatedAt", "2026-08-22T08:00:00")
            ),
            Map.ofEntries(
                entry("id", 3),
                entry("nama", "Tas Ransel Laptop 15 Inch"),
                entry("deskripsi", "Tas ransel anti air dengan kompartemen laptop 15 inch dan port USB charging."),
                entry("harga", 320000),
                entry("stok", 28),
                entry("kategori", "Tas"),
                entry("gambarUrl", "https://placehold.co/400x400?text=Tas+Ransel"),
                entry("berat", 0.9),
                entry("aktif", true),
                entry("createdAt", "2026-08-03T11:00:00"),
                entry("updatedAt", "2026-08-21T16:00:00")
            ),
            Map.ofEntries(
                entry("id", 4),
                entry("nama", "Smartwatch Xiaomi Band 9"),
                entry("deskripsi", "Smartwatch dengan monitor detak jantung, SpO2, dan baterai tahan 14 hari."),
                entry("harga", 499000),
                entry("stok", 0),
                entry("kategori", "Elektronik"),
                entry("gambarUrl", "https://placehold.co/400x400?text=Smartwatch"),
                entry("berat", 0.05),
                entry("aktif", false),
                entry("createdAt", "2026-08-05T13:00:00"),
                entry("updatedAt", "2026-08-23T09:00:00")
            ),
            Map.ofEntries(
                entry("id", 5),
                entry("nama", "Kopi Arabika Gayo 250gr"),
                entry("deskripsi", "Biji kopi arabika single origin dari dataran tinggi Gayo, Aceh. Roast level medium."),
                entry("harga", 75000),
                entry("stok", 80),
                entry("kategori", "Makanan & Minuman"),
                entry("gambarUrl", "https://placehold.co/400x400?text=Kopi+Gayo"),
                entry("berat", 0.3),
                entry("aktif", true),
                entry("createdAt", "2026-08-10T07:00:00"),
                entry("updatedAt", "2026-08-24T06:00:00")
            )
        );
    }

    @GetMapping("/transaksi")
    public List<Map<String, Object>> transaksi() {
        return List.of(
            Map.ofEntries(
                entry("id", 1),
                entry("tanggal", "2026-08-20T10:30:00"),
                entry("total", 1420000),
                entry("status", "SELESAI"),
                entry("metodePembayaran", "GOPAY"),
                entry("alamatPengiriman", "Jl. Sudirman No. 12, Karet Tengsin, Jakarta Pusat 10250"),
                entry("nomorResi", "JNE2026082012345"),
                entry("catatanPembeli", "Tolong dibungkus bubble wrap"),
                entry("createdAt", "2026-08-20T10:30:00"),
                entry("updatedAt", "2026-08-23T15:00:00"),
                entry("items", List.of(
                    Map.of("id", 1, "jumlah", 1, "harga", 1250000,
                        "produk", Map.of("id", 1, "nama", "Sepatu Lari Nike Air Max", "gambarUrl", "https://placehold.co/400x400?text=Sepatu+Nike")),
                    Map.of("id", 2, "jumlah", 2, "harga", 85000,
                        "produk", Map.of("id", 2, "nama", "Kaos Polos Cotton Combed 30s", "gambarUrl", "https://placehold.co/400x400?text=Kaos+Polos"))
                ))
            ),
            Map.ofEntries(
                entry("id", 2),
                entry("tanggal", "2026-08-22T14:00:00"),
                entry("total", 320000),
                entry("status", "DIKIRIM"),
                entry("metodePembayaran", "TRANSFER_BANK"),
                entry("alamatPengiriman", "Jl. Gatot Subroto Kav. 51-53, Kuningan, Jakarta Selatan 12950"),
                entry("nomorResi", "SICEPAT2026082267890"),
                entry("catatanPembeli", ""),
                entry("createdAt", "2026-08-22T14:00:00"),
                entry("updatedAt", "2026-08-23T09:00:00"),
                entry("items", List.of(
                    Map.of("id", 3, "jumlah", 1, "harga", 320000,
                        "produk", Map.of("id", 3, "nama", "Tas Ransel Laptop 15 Inch", "gambarUrl", "https://placehold.co/400x400?text=Tas+Ransel"))
                ))
            ),
            Map.ofEntries(
                entry("id", 3),
                entry("tanggal", "2026-08-24T08:15:00"),
                entry("total", 574000),
                entry("status", "MENUNGGU_PEMBAYARAN"),
                entry("metodePembayaran", "QRIS"),
                entry("alamatPengiriman", "Jl. Raya Bogor Km 30, Cibinong, Bogor 16914"),
                entry("nomorResi", ""),
                entry("catatanPembeli", "Pilih warna hitam jika ada"),
                entry("createdAt", "2026-08-24T08:15:00"),
                entry("updatedAt", "2026-08-24T08:15:00"),
                entry("items", List.of(
                    Map.of("id", 4, "jumlah", 2, "harga", 75000,
                        "produk", Map.of("id", 5, "nama", "Kopi Arabika Gayo 250gr", "gambarUrl", "https://placehold.co/400x400?text=Kopi+Gayo")),
                    Map.of("id", 5, "jumlah", 1, "harga", 320000,
                        "produk", Map.of("id", 3, "nama", "Tas Ransel Laptop 15 Inch", "gambarUrl", "https://placehold.co/400x400?text=Tas+Ransel")),
                    Map.of("id", 6, "jumlah", 1, "harga", 85000,
                        "produk", Map.of("id", 2, "nama", "Kaos Polos Cotton Combed 30s", "gambarUrl", "https://placehold.co/400x400?text=Kaos+Polos"))
                ))
            )
        );
    }
}
