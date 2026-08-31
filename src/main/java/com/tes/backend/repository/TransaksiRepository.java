package com.tes.backend.repository;

import com.tes.backend.entity.Transaksi;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TransaksiRepository extends JpaRepository<Transaksi, Long> {
    List<Transaksi> findByPembeliId(Long userId);
}
