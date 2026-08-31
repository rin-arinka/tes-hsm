# Tes Backend Marketplace

Halo! Ini adalah hasil pengerjaan untuk Tugas 1 dan Tugas 2 (Backend Engineer).

## Stack yang dipakai
- Java 21
- Spring Boot 3
- MySQL
- JWT (JSON Web Token)
- Docker & Docker Compose

## Fitur yang udah diselesaikan
1. **Endpoint Produk & Transaksi**: Udah dilanjutin sesuai kontrak awal yang diminta.
2. **Auth & User**:
    - Register (`/api/auth/register`) defaultnya bakal dapet role `USER`.
    - Login (`/api/auth/login`) buat dapetin token JWT.
    - Password aman karena udah di-hash pake bcrypt.
3. **Integrasi Relasi Transaksi**:
    - Tiap bikin order/transaksi baru, otomatis nyambung ke user yang lagi login.
    - Kalo login sebagai `USER`, cuma bisa liat transaksi milik sendiri (difilter). Kalo login pake `SUPERADMIN` bisa liat semua data.
4. **Proteksi Akses (Role-based)**:
    - Produk: public bisa liat katalog. Tapi buat nambah/edit/hapus cuma bisa dilakuin sama `SUPERADMIN`. Kalo user biasa maksa nembak endpointnya bakal kena `403 Forbidden`.
    - Transaksi: Wajib login. User biasa cuma bisa bikin order, dan cuma admin yang berhak ngapus transaksi.

## Cara Run (Pake Docker) - Rekomendasi
Project ini udah aku setup pake multi-stage build Docker (build maven + run JRE). Buat ngerun, cukup ketik ini di terminal:

```bash
docker compose up --build -d
```

Tungguin bentar sampe image mysql dan app-nya kelar dibuild. Kalo udah, langsung aja buka Swagger UI-nya di:
[http://localhost:8055/swagger-ui.html](http://localhost:8055/swagger-ui.html)

*(Kalo mau matiin tinggal ketik `docker compose down`)*

## Cara Run (Manual via Local)
Kalo mau dites manual di local tanpa docker, bisa juga:
1. Nyalain MySQL local (misal XAMPP/Laragon).
2. Bikin database kosong namanya `tes_backend`.
3. Jalanin perintah ini:
   ```bash
   ./mvnw clean spring-boot:run
   ```

## Catatan Tambahan
Buat ngetes fitur khusus admin (`SUPERADMIN`), bisa bikin user baru dulu via endpoint register. Setelah itu, ubah rolenya langsung dari tabel `user` di database dari `USER` jadi `SUPERADMIN`. Kalo udah, tinggal login ulang buat dapetin token JWT yang baru.
