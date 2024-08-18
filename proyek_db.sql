-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Waktu pembuatan: 18 Agu 2024 pada 13.42
-- Versi server: 8.0.30
-- Versi PHP: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `proyek_db`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `lokasi`
--

CREATE TABLE `lokasi` (
  `id` int NOT NULL,
  `nama_lokasi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `negara` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `provinsi` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `kota` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `lokasi`
--

INSERT INTO `lokasi` (`id`, `nama_lokasi`, `negara`, `provinsi`, `kota`, `created_at`) VALUES
(3, 'Ciwidey', 'Indonesia', 'Jawa Barat', 'Bandung', '2024-08-17 17:18:10'),
(5, 'Pantai Air Manis', 'Indonesia', 'Sumatera Barat', 'Padang', '2024-08-18 04:38:34'),
(14, 'Jalan Kebon Kawung', 'Indonesia', 'Jawa Barat', 'Bandung', '2024-08-18 04:20:19'),
(16, 'Jalan Halmahera', 'Indonesia', 'Jawa Barat', 'Bandung', '2024-08-18 04:24:22'),
(19, 'Jalan Linggawastu, RT bla bla RW Blabla', 'Indonesia', 'Jawa Barat', 'Bandung', '2024-08-18 06:22:15');

-- --------------------------------------------------------

--
-- Struktur dari tabel `proyek`
--

CREATE TABLE `proyek` (
  `id` bigint NOT NULL,
  `nama_proyek` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `client` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `tgl_mulai` datetime NOT NULL,
  `tgl_selesai` datetime NOT NULL,
  `pimpinan_proyek` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  `keterangan` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `lokasi_id` int DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `proyek`
--

INSERT INTO `proyek` (`id`, `nama_proyek`, `client`, `tgl_mulai`, `tgl_selesai`, `pimpinan_proyek`, `keterangan`, `created_at`, `lokasi_id`) VALUES
(1, 'Proyek Test', 'Client Test', '2024-08-18 00:00:00', '2024-08-19 00:00:00', 'Pimpinan Test', 'Keterangan Test', '2024-08-17 17:24:49', 5),
(17, 'Proyek cobaan', 'Client coba', '2024-08-18 00:00:00', '2024-08-20 00:00:00', 'Pimpinan Updated', 'Keterangan Updated', '2024-08-18 12:31:35', 3);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `lokasi`
--
ALTER TABLE `lokasi`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `proyek`
--
ALTER TABLE `proyek`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_lokasi` (`lokasi_id`);

--
-- AUTO_INCREMENT untuk tabel yang dibuang
--

--
-- AUTO_INCREMENT untuk tabel `lokasi`
--
ALTER TABLE `lokasi`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT untuk tabel `proyek`
--
ALTER TABLE `proyek`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `proyek`
--
ALTER TABLE `proyek`
  ADD CONSTRAINT `fk_lokasi` FOREIGN KEY (`lokasi_id`) REFERENCES `lokasi` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
