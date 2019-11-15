-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 07 Des 2018 pada 06.47
-- Versi server: 10.1.37-MariaDB
-- Versi PHP: 7.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_sakumahasiswa`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `event`
--

CREATE TABLE `event` (
  `username` varchar(25) NOT NULL,
  `namaEvent` varchar(25) DEFAULT NULL,
  `budget` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `event`
--

INSERT INTO `event` (`username`, `namaEvent`, `budget`) VALUES
('test', '1', 0),
('tubes', 'jalan', 111),
('qw', '12', 0),
('qw', 'qwe', 0),
('qw', 'qweqwe', 0),
('faisalridwan', 'qw', 0);

-- --------------------------------------------------------

--
-- Struktur dari tabel `historievent`
--

CREATE TABLE `historievent` (
  `username` varchar(25) DEFAULT NULL,
  `kategoriEvent` varchar(25) NOT NULL,
  `namaEvent` varchar(25) NOT NULL,
  `namaPemaPengEvent` varchar(25) NOT NULL,
  `kategoriPengeluaranE` varchar(25) NOT NULL,
  `tanggal` varchar(15) DEFAULT NULL,
  `jam` varchar(15) DEFAULT NULL,
  `pemasukanEvent` int(11) DEFAULT NULL,
  `pengeluaranEvent` int(11) DEFAULT NULL,
  `sisaBudget` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `historievent`
--

INSERT INTO `historievent` (`username`, `kategoriEvent`, `namaEvent`, `namaPemaPengEvent`, `kategoriPengeluaranE`, `tanggal`, `jam`, `pemasukanEvent`, `pengeluaranEvent`, `sisaBudget`) VALUES
('tubes ', 'Pemasukan', 'null', 'qwq', '-', '21-08-2018', '10:13:56', 123, 0, 123),
('tubes ', 'Pemasukan', 'jalan', 'qwe', '-', '21-08-2018', '10:17:19', 123, 0, 123),
('tubes ', 'Pengeluaran', 'jalan', 'qweq', 'Makanan & Minuman', '07-12-2018', '10:17:24', 0, 12, 111);

-- --------------------------------------------------------

--
-- Struktur dari tabel `historiharian`
--

CREATE TABLE `historiharian` (
  `username` varchar(25) DEFAULT NULL,
  `nama` varchar(25) DEFAULT NULL,
  `tanggal` varchar(15) DEFAULT NULL,
  `jam` varchar(15) DEFAULT NULL,
  `kategoriHarian` varchar(25) DEFAULT NULL,
  `kategoriPengeluaranH` varchar(25) DEFAULT NULL,
  `pemasukan` int(11) DEFAULT NULL,
  `pengeluaran` int(11) DEFAULT NULL,
  `sisaSaldo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `historiharian`
--

INSERT INTO `historiharian` (`username`, `nama`, `tanggal`, `jam`, `kategoriHarian`, `kategoriPengeluaranH`, `pemasukan`, `pengeluaran`, `sisaSaldo`) VALUES
('tubes ', 'uang jajan', '07-12-2018', '10:10:56', 'Pemasukan', '-', 2000000, 0, 2000000),
('tubes ', 'beli nasi uduk', '07-12-2018', '10:11:09', 'Pengeluaran', 'Makanan & Minuman', 0, 10000, 1990000),
('tubes ', 'dikasih orang', '07-12-2018', '10:11:24', 'Pemasukan', '-', 10000, 0, 2000000),
('tubes ', 'beli sepeda', '07-12-2018', '10:11:35', 'Pengeluaran', 'Hiburan', 0, 200000, 1800000),
('qw ', 'qwe', '07-12-2018', '10:23:19', 'Pemasukan', '-', 12, 0, 12),
('qw ', 'qw', '07-12-2018', '10:23:24', 'Pengeluaran', 'Makanan & Minuman', 0, 12, 0),
('qw ', 'qw', '07-12-2018', '10:23:49', 'Pemasukan', '-', 12, 0, 12),
('qw ', '21', '07-12-2018', '10:23:54', 'Pengeluaran', 'Makanan & Minuman', 0, 1, 11);

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemasukanevent`
--

CREATE TABLE `pemasukanevent` (
  `username` varchar(25) DEFAULT NULL,
  `namaEvent` varchar(25) DEFAULT NULL,
  `namaPemasukanEvent` varchar(25) DEFAULT NULL,
  `budget` int(11) DEFAULT NULL,
  `tanggalPemasukan` varchar(25) DEFAULT NULL,
  `jamPemasukan` varchar(15) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pemasukanevent`
--

INSERT INTO `pemasukanevent` (`username`, `namaEvent`, `namaPemasukanEvent`, `budget`, `tanggalPemasukan`, `jamPemasukan`) VALUES
('tubes', 'null ', 'qwq ', 123, '21-08-2018', '10:13:56'),
('tubes', 'jalan ', 'qwe ', 123, '21-08-2018', '10:17:19');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pemasukanharian`
--

CREATE TABLE `pemasukanharian` (
  `username` varchar(25) DEFAULT NULL,
  `namaPemasukan` varchar(25) DEFAULT NULL,
  `besarPemasukan` int(11) DEFAULT NULL,
  `tanggalPemasukan` varchar(15) DEFAULT NULL,
  `jamPemasukan` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pemasukanharian`
--

INSERT INTO `pemasukanharian` (`username`, `namaPemasukan`, `besarPemasukan`, `tanggalPemasukan`, `jamPemasukan`) VALUES
('tubes', 'uang jajan ', 2000000, '07-12-2018', '10:10:56'),
('tubes', 'dikasih orang ', 10000, '07-12-2018', '10:11:24'),
('qw', 'qwe ', 12, '07-12-2018', '10:23:19'),
('qw', 'qw ', 12, '07-12-2018', '10:23:49');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaranevent`
--

CREATE TABLE `pengeluaranevent` (
  `username` varchar(25) DEFAULT NULL,
  `namaEvent` varchar(25) NOT NULL,
  `namaPengeluaranEvent` varchar(25) DEFAULT NULL,
  `besarPengeluaran` int(11) NOT NULL,
  `kategoriPengeluaranEvent` varchar(20) DEFAULT NULL,
  `tglPengeluaranEvent` varchar(15) DEFAULT NULL,
  `jamPengeluaran` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengeluaranevent`
--

INSERT INTO `pengeluaranevent` (`username`, `namaEvent`, `namaPengeluaranEvent`, `besarPengeluaran`, `kategoriPengeluaranEvent`, `tglPengeluaranEvent`, `jamPengeluaran`) VALUES
('tubes', 'jalan', 'qweq', 12, 'Makanan & Minuman', '07-12-2018', '10:17:24');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengeluaranharian`
--

CREATE TABLE `pengeluaranharian` (
  `username` varchar(25) DEFAULT NULL,
  `namaPengeluaran` varchar(25) DEFAULT NULL,
  `besarPengeluaran` int(11) DEFAULT NULL,
  `tanggalPengeluaran` varchar(15) DEFAULT NULL,
  `jamPengeluaran` varchar(15) NOT NULL,
  `kategoriPengeluaranH` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengeluaranharian`
--

INSERT INTO `pengeluaranharian` (`username`, `namaPengeluaran`, `besarPengeluaran`, `tanggalPengeluaran`, `jamPengeluaran`, `kategoriPengeluaranH`) VALUES
('tubes', 'beli nasi uduk', 1990000, '07-12-2018', '10:11:09', 'Makanan & Minuman'),
('tubes', 'beli sepeda', 1800000, '07-12-2018', '10:11:35', 'Hiburan'),
('qw', 'qw', 0, '07-12-2018', '10:23:24', 'Makanan & Minuman'),
('qw', '21', 11, '07-12-2018', '10:23:54', 'Makanan & Minuman');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `username` varchar(25) NOT NULL,
  `password` varchar(15) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `tanggalLahir` varchar(15) NOT NULL,
  `phoneNumber` varchar(12) NOT NULL,
  `address` varchar(50) NOT NULL,
  `saldo` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`username`, `password`, `nama`, `tanggalLahir`, `phoneNumber`, `address`, `saldo`) VALUES
('faisalridwan', '1234', 'Faisal Ridwan Siregar', '21-06-1999', '082275007855', 'Jl. Bukit Kotapinang', 800001),
('qw', 'qw', 'qw', '13-12-2018', 'ew', 'qwe', 11),
('test', '123', 'test', '08-12-2018', '08123456789', 'jl.test', 1000000),
('tubes', '12', 'tugas kecil', '14-12-2018', '082275007855', 'jl. tubes', 1800000);

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `event`
--
ALTER TABLE `event`
  ADD KEY `event_FK` (`username`);

--
-- Indeks untuk tabel `historievent`
--
ALTER TABLE `historievent`
  ADD KEY `historievent_FK` (`username`);

--
-- Indeks untuk tabel `historiharian`
--
ALTER TABLE `historiharian`
  ADD KEY `historiharian_FK` (`username`);

--
-- Indeks untuk tabel `pemasukanevent`
--
ALTER TABLE `pemasukanevent`
  ADD KEY `pemasukanevent_FK` (`username`);

--
-- Indeks untuk tabel `pemasukanharian`
--
ALTER TABLE `pemasukanharian`
  ADD KEY `pemasukanharian_FK` (`username`);

--
-- Indeks untuk tabel `pengeluaranevent`
--
ALTER TABLE `pengeluaranevent`
  ADD KEY `pengeluaranevent_FK` (`username`);

--
-- Indeks untuk tabel `pengeluaranharian`
--
ALTER TABLE `pengeluaranharian`
  ADD KEY `pengeluaranharian_FK` (`username`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`username`),
  ADD UNIQUE KEY `username` (`username`);

--
-- Ketidakleluasaan untuk tabel pelimpahan (Dumped Tables)
--

--
-- Ketidakleluasaan untuk tabel `event`
--
ALTER TABLE `event`
  ADD CONSTRAINT `event_FK` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Ketidakleluasaan untuk tabel `historievent`
--
ALTER TABLE `historievent`
  ADD CONSTRAINT `historievent_FK` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Ketidakleluasaan untuk tabel `historiharian`
--
ALTER TABLE `historiharian`
  ADD CONSTRAINT `historiharian_FK` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Ketidakleluasaan untuk tabel `pemasukanevent`
--
ALTER TABLE `pemasukanevent`
  ADD CONSTRAINT `pemasukanevent_FK` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Ketidakleluasaan untuk tabel `pemasukanharian`
--
ALTER TABLE `pemasukanharian`
  ADD CONSTRAINT `pemasukanharian_FK` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Ketidakleluasaan untuk tabel `pengeluaranevent`
--
ALTER TABLE `pengeluaranevent`
  ADD CONSTRAINT `pengeluaranevent_FK` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);

--
-- Ketidakleluasaan untuk tabel `pengeluaranharian`
--
ALTER TABLE `pengeluaranharian`
  ADD CONSTRAINT `pengeluaranharian_FK` FOREIGN KEY (`username`) REFERENCES `pengguna` (`username`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
