# Petunjuk Test — Backend Marketplace

Selamat datang. Dokumen ini berisi tugas teknis sesuai posisi yang dilamar.

Baca seluruh petunjuk sebelum memulai.

---

## Tugas 1 & 2 — Backend Engineer

### Persiapan

1. Fork repository ini
2. Sesuaikan `application.properties` dengan konfigurasi database lokal kamu
3. Jalankan aplikasi:
   ```bash
   ./mvnw spring-boot:run
   ```
4. Swagger UI: `http://localhost:8055/swagger-ui.html`

---

### Tugas 1 — Lanjutkan Endpoint yang Sudah Ada

**Fork** repository ini, lalu lanjutkan pengembangan di atas kode yang sudah ada. Endpoint berikut sudah tersedia dan **tidak boleh diubah kontraknya**:

#### Produk — `/api/produk`

| Method | Path | Deskripsi |
|--------|------|-----------|
| GET | `/api/produk` | Ambil semua produk |
| GET | `/api/produk/{id}` | Ambil produk by ID |
| POST | `/api/produk` | Tambah produk baru |
| PUT | `/api/produk/{id}` | Update produk |
| DELETE | `/api/produk/{id}` | Hapus produk |

Field produk: `id`, `nama`, `deskripsi`, `harga`, `stok`, `kategori`, `gambarUrl`, `berat`, `aktif`, `createdAt`, `updatedAt`

#### Transaksi — `/api/transaksi`

| Method | Path | Deskripsi |
|--------|------|-----------|
| GET | `/api/transaksi` | Ambil semua transaksi |
| GET | `/api/transaksi/{id}` | Ambil transaksi by ID |
| POST | `/api/transaksi` | Buat transaksi baru |
| PUT | `/api/transaksi/{id}` | Update transaksi |
| DELETE | `/api/transaksi/{id}` | Hapus transaksi |

Field transaksi: `id`, `tanggal`, `total`, `status`, `metodePembayaran`, `alamatPengiriman`, `nomorResi`, `catatanPembeli`, `createdAt`, `updatedAt`, `items[]`

Nilai enum `status`: `MENUNGGU_PEMBAYARAN`, `DIBAYAR`, `DIPROSES`, `DIKIRIM`, `SELESAI`, `DIBATALKAN`

Nilai enum `metodePembayaran`: `TRANSFER_BANK`, `COD`, `KARTU_KREDIT`, `GOPAY`, `OVO`, `DANA`, `QRIS`

Jalankan app untuk melihat kontrak lengkap via Swagger: `http://localhost:8055/swagger-ui.html`

---

### Tugas 2 — Autentikasi, User, dan Deployment

#### 2.1 Entity & Autentikasi User

- Buat entity `User` dengan minimal: `id`, `nama`, `email`, `password`, `role`, `createdAt`
- Role: `SUPERADMIN`, `USER`
- Endpoint auth:
  - `POST /api/auth/register` — registrasi (role default: `USER`)
  - `POST /api/auth/login` — login, response JWT token
- Password disimpan ter-hash (bcrypt)

#### 2.2 Integrasi User ke Transaksi

- Transaksi memiliki relasi ke `User` sebagai pembeli
- Saat membuat transaksi, user yang sedang login otomatis menjadi pembeli
- `GET /api/transaksi` untuk role `USER` hanya menampilkan transaksi milik sendiri
- `GET /api/transaksi` untuk role `SUPERADMIN` menampilkan semua transaksi

#### 2.3 Proteksi Endpoint

Role `SUPERADMIN` berperan sebagai **admin toko** yang mengelola katalog produk. Role `USER` adalah pembeli yang hanya bisa berbelanja.

**Produk:**
- `GET /api/produk`, `GET /api/produk/{id}` — publik, tidak perlu login
- `POST /api/produk` — hanya `SUPERADMIN` (tambah produk baru)
- `PUT /api/produk/{id}` — hanya `SUPERADMIN` (edit produk)
- `DELETE /api/produk/{id}` — hanya `SUPERADMIN` (hapus produk)
- Role `USER` yang mencoba akses endpoint di atas wajib mendapat response `403 Forbidden`

**Transaksi:**
- Semua endpoint wajib login
- `POST /api/transaksi` — hanya `USER` (pembeli yang membuat order)
- `DELETE /api/transaksi/{id}` — hanya `SUPERADMIN`

#### 2.4 Deployment via Docker Desktop

- Buat `Dockerfile` dengan multi-stage build (build Maven → run JRE)
- Buat atau update `docker-compose.yml` dengan dua service: `db` (MySQL) dan `app` (Spring Boot)
- Service `app` menunggu `db` siap (health check)
- Semua konfigurasi DB menggunakan environment variable
- Setelah `docker compose up`: aplikasi berjalan di `http://localhost:8055`, Swagger UI dapat diakses

---

## Tugas 3 — Frontend Engineer

### Persiapan

Kamu akan diberikan file JAR yang sudah siap jalan. Tidak perlu install Java SDK atau Maven — cukup jalankan:

```bash
java -jar backend.jar
```

Pastikan Java 21 terinstall (`java -version`). Jika belum, download di [adoptium.net](https://adoptium.net).

### Endpoint yang Digunakan

Gunakan dua endpoint berikut. Tidak perlu login, tidak perlu database.

| Method | URL | Deskripsi |
|--------|-----|-----------|
| GET | `http://localhost:8055/dummy/produk` | Daftar 5 produk dummy |
| GET | `http://localhost:8055/dummy/transaksi` | Daftar 3 transaksi dummy |

### Yang Harus Dibuat

#### Halaman Daftar Produk

Tampilkan semua produk dengan informasi:
- Gambar produk (`gambarUrl`)
- Nama produk
- Deskripsi
- Harga (format rupiah, contoh: `Rp 1.250.000`)
- Stok tersedia
- Kategori
- Badge status aktif / nonaktif

#### Halaman Daftar Transaksi

Tampilkan semua transaksi dengan informasi:
- ID dan tanggal transaksi
- Total harga (format rupiah)
- Status dengan badge berwarna (contoh: hijau = SELESAI, kuning = MENUNGGU_PEMBAYARAN)
- Metode pembayaran
- Alamat pengiriman
- Nomor resi (jika ada)
- Detail item: nama produk, gambar, jumlah, harga satuan

### Ketentuan Teknis

- Gunakan salah satu framework yang disebutkan (React, Next.js)
- Sertakan cara menjalankan project di README atau komentar
- Fokus pada kelengkapan data yang ditampilkan

---

## Cara Pengumpulan

### Backend Engineer

1. **Fork** repository ini
2. Push seluruh project Spring Boot kamu ke fork tersebut
3. Buat **Pull Request** dari fork kamu ke repository ini dengan format nama PR:
   ```
   NAMA_BACKEND
   ```
   Contoh: `DIONISIUSNP_BACKEND`

### Frontend Engineer

1. Buat repository GitHub baru dengan format nama repo:
   ```
   NAMA_FRONTEND
   ```
   Contoh: `DIONISIUSNP_FRONTEND`
2. Push seluruh project frontend kamu ke repository tersebut
3. Invite akun **dionisiusn1@gmail.com** atau username **dionisiusnp** sebagai collaborator
4. Jalankan project di local, lalu expose URL menggunakan tools seperti [ngrok](https://ngrok.com) atau [localtunnel](https://theboroer.github.io/localtunnel-www/):
   ```bash
   # Contoh menggunakan ngrok
   ngrok http 3000
   ```
5. Kirimkan **URL hasil expose** beserta **link repository** melalui email atau channel yang sudah ditentukan

---

## Catatan Umum

- Kerjakan hanya tugas sesuai posisi yang dilamar
- Jangan ubah kontrak API yang sudah ada — hanya boleh menambah
- Sertakan langkah menjalankan solusimu jika ada langkah tambahan di README

Selamat mengerjakan.
