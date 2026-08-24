package com.tes.backend.entity;

import com.tes.backend.enums.MetodePembayaran;
import com.tes.backend.enums.StatusTransaksi;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class Transaksi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime tanggal;

    @Column(nullable = false)
    private BigDecimal total;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTransaksi status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private MetodePembayaran metodePembayaran;

    @Column(columnDefinition = "TEXT")
    private String alamatPengiriman;

    private String nomorResi;

    @Column(columnDefinition = "TEXT")
    private String catatanPembeli;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @OneToMany(mappedBy = "transaksi", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TransaksiItem> items;
}
