-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jun 14, 2023 at 10:35 AM
-- Server version: 5.7.32
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `riskque`
--

-- --------------------------------------------------------

--
-- Table structure for table `dplk`
--

CREATE TABLE `dplk` (
  `id` int(11) NOT NULL,
  `tanggal` varchar(45) NOT NULL,
  `merek` varchar(45) NOT NULL,
  `dplk` varchar(45) NOT NULL,
  `tipe_risiko` enum('Konservatif','Moderat','Agresif') NOT NULL,
  `saham` float DEFAULT NULL,
  `pasar_uang/kas` float DEFAULT NULL,
  `obligasi/sbn/sukuk` float DEFAULT NULL,
  `total_invest` float DEFAULT NULL,
  `1_bulan` float DEFAULT NULL,
  `3_bulan` float DEFAULT NULL,
  `6_bulan` float DEFAULT NULL,
  `1_tahun` float DEFAULT NULL,
  `3_tahun` float DEFAULT NULL,
  `5_tahun` float DEFAULT NULL,
  `aum` float DEFAULT NULL,
  `link_fundfact` varchar(256) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `dplk`
--

INSERT INTO `dplk` (`id`, `tanggal`, `merek`, `dplk`, `tipe_risiko`, `saham`, `pasar_uang/kas`, `obligasi/sbn/sukuk`, `total_invest`, `1_bulan`, `3_bulan`, `6_bulan`, `1_tahun`, `3_tahun`, `5_tahun`, `aum`, `link_fundfact`) VALUES
(1, 'Januari 2023', 'Allianz', 'DPLK_Equity_Fund', 'Agresif', 88.98, 11.02, 0, 100, 1.73, -2.37, -2.6, 0.68, 16.83, 8.18, 213.42, ''),
(2, 'Februari 2023', 'Allianz', 'DPLK_Equity_Fund', 'Agresif', 90.68, 9.32, 0, 100, -0.22, -3.86, -4.75, -1.7, 26.03, 7.81, 214.6, ''),
(3, 'Maret 2023', 'Allianz', 'DPLK_Equity_Fund', 'Agresif', 87.87, 12.13, 0, 100, -0.2, 1.29, -2.69, -7.8, 56.38, 13.69, 215.06, ''),
(4, 'April 2023', 'Allianz', 'DPLK_Equity_Fund', 'Agresif', 92.74, 7.26, 0, 100, 2.07, 1.63, -0.78, -9.54, 52.17, 20.39, 219.19, ''),
(5, 'Januari 2023', 'Allianz', 'DPLK_PPUKP_Equity_Fund', 'Agresif', 88.97, 11.03, 0, 100, 1.66, -2.43, -2.5, 0.48, 14.31, 3.02, 35.63, ''),
(6, 'Februari 2023', 'Allianz', 'DPLK_PPUKP_Equity_Fund', 'Agresif', 91.17, 8.83, 0, 100, -0.24, -3.9, -4.91, -2.07, 23.23, 2.75, 35.56, ''),
(7, 'Maret 2023', 'Allianz', 'DPLK_PPUKP_Equity_Fund', 'Agresif', 89.14, 10.86, 0, 100, -0.21, 1.22, -2.79, -8.06, 54.98, 8.44, 35.04, ''),
(8, 'April 2023', 'Allianz', 'DPLK_PPUKP_Equity_Fund', 'Agresif', 93.15, 6.85, 0, 100, 2.02, 1.57, -0.91, -9.81, 50.56, 15.04, 35.34, ''),
(9, 'Januari 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang', 'Agresif', 50.47, 44.75, 4.78, 100, 0.27, -2.25, 0.21, 3.33, 8.59, 10.6, 0, ''),
(10, 'Februari 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang', 'Agresif', 49.5, 44.78, 5.72, 100, 0.24, -1.62, -1.4, 2.36, 12.7, 10.51, 0, ''),
(11, 'Maret 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang', 'Agresif', 49.28, 44.74, 5.98, 100, 0.76, 1.28, -0.63, 0.14, 24.07, 14.63, 0, ''),
(12, 'April 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang', 'Agresif', 49.5, 44.78, 5.72, 100, 1.38, 2.39, 0.14, -0.81, 23.64, 17.07, 0, ''),
(13, 'Januari 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang_Syariah', 'Agresif', 50.35, 29.77, 19.89, 100.01, -0.24, -0.78, -0.52, 2.12, 12.24, 15.51, 0, ''),
(14, 'Februari 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang_Syariah', 'Agresif', 49.47, 31.79, 18.74, 100, 0.66, -0.68, -0.32, 2.5, 16.39, 16.11, 0, ''),
(15, 'Maret 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang_Syariah', 'Agresif', 49.22, 31.81, 18.97, 100, -0.47, -0.04, 0.16, 0.35, 23.04, 18.66, 0, ''),
(16, 'April 2023', 'BNI', 'FFS_BNI_Simponi_Berimbang_Syariah', 'Agresif', 49.47, 31.79, 18.74, 100, 0.85, 1.04, 0.26, -0.26, 19.92, 19.43, 0, ''),
(17, 'Januari 2023', 'BNI', 'FFS_BNI_Simponi_Progresif', 'Agresif', 50.23, 4.68, 45.09, 100, 0.41, -0.9, 1.09, 3.69, 13.12, 15.51, 0, ''),
(18, 'Februari 2023', 'BNI', 'FFS_BNI_Simponi_Progresif', 'Agresif', 49.59, 0.98, 49.43, 100, 0.1, -1.31, -0.83, 2.49, 17.12, 15.44, 0, ''),
(19, 'Maret 2023', 'BNI', 'FFS_BNI_Simponi_Progresif', 'Agresif', 49.31, 1.55, 49.14, 100, 0.93, 1.44, 0.41, 0.69, 29.1, 19.67, 0, ''),
(20, 'April 2023', 'BNI', 'FFS_BNI_Simponi_Progresif', 'Agresif', 49.59, 0.98, 49.43, 100, 1.52, 2.55, 1.64, 0.4, 28.66, 22.33, 0, ''),
(21, 'Januari 2023', 'Generali', 'DPLK_Generali_Equity', 'Agresif', 92.49, 7.51, 0, 100, 0.67, -6.23, 0, -3.82, 0, 0, 65.04, ''),
(22, 'Februari 2023', 'Generali', 'DPLK_Generali_Equity', 'Agresif', 88.7, 11.3, 0, 100, 0.98, -3.91, 0, -4.97, 0, 0, 68.35, ''),
(23, 'Maret 2023', 'Generali', 'DPLK_Generali_Equity', 'Agresif', 99.25, 0.75, 0, 100, -2.94, -1.33, 0, -11.5, 0, 0, 64.46, ''),
(24, 'April 2023', 'Generali', 'DPLK_Generali_Equity', 'Agresif', 96.67, 3.33, 0, 100, 1.48, -0.54, 0, -12.68, 0, 0, 67.11, ''),
(25, 'Januari 2023', 'Manulife', 'GRO_Dana_Saham', 'Agresif', 95.94, 4.06, 0, 100, 1, -11.34, -9.81, -8.35, -3.78, -3.71, 1310, ''),
(26, 'Februari 2023', 'Manulife', 'GRO_Dana_Saham', 'Agresif', 96.75, 3.25, 0, 100, -1.03, -8.01, -12.89, -12.04, -1.35, -3.76, 1290, ''),
(27, 'Maret 2023', 'Manulife', 'GRO_Dana_Saham', 'Agresif', 95.91, 4.09, 0, 100, -0.33, -0.37, -11.91, -14.59, 9.67, -2.36, 1300, ''),
(28, 'April 2023', 'Manulife', 'GRO_Dana_Saham', 'Agresif', 97.3, 2.7, 0, 100, 1.51, 0.14, -11.22, -17.21, 9.3, -1.35, 1340, ''),
(29, 'Januari 2023', 'Muamalat', 'Paket C', 'Agresif', 19.23, 80.77, 0, 100, -0.14, -2.83, -1.6, 1.35, -4.75, -17.03, 88.06, ''),
(30, 'Februari 2023', 'Muamalat', 'Paket C', 'Agresif', 19.33, 80.67, 0, 100, 0.5, -1.72, -3.64, 0.1, 6.24, -15.72, 88.06, ''),
(31, 'Maret 2023', 'Muamalat', 'Paket C', 'Agresif', 20.01, 79.99, 0, 100, 0.37, 0.73, -1.67, -0.35, 21.62, -7.51, 85.19, ''),
(32, 'April 2023', 'Muamalat', 'Paket C', 'Agresif', 23.14, 76.85, 0, 99.99, 0.75, 1.62, -1.21, -4.68, 15.38, -5.92, 85.19, ''),
(33, 'Januari 2023', 'Allianz', 'DPLK_Money_Market_Fund', 'Konservatif', 0, 99.99, 0.01, 100, 0.44, 1.22, 2.05, 3.48, 13.63, 30.7, 1323.96, ''),
(34, 'Februari 2023', 'Allianz', 'DPLK_Money_Market_Fund', 'Konservatif', 0, 98.37, 1.63, 100, 0.42, 1.28, 2.21, 3.71, 13.57, 30.58, 1260.58, ''),
(35, 'Maret 2023', 'Allianz', 'DPLK_Money_Market_Fund', 'Konservatif', 0, 96.63, 3.37, 100, 0.47, 1.33, 2.43, 3.91, 13.46, 30.51, 1292.05, ''),
(36, 'April 2023', 'Allianz', 'DPLK_Money_Market_Fund', 'Konservatif', 0, 92.43, 7.57, 100, 0.42, 1.31, 2.55, 4.12, 13.36, 30.32, 1298.3, ''),
(37, 'Januari 2023', 'Allianz', 'DPLK_PPUKP_Money_Market_Fund', 'Konservatif', 0, 97.97, 2.03, 100, 0.47, 1.22, 2.03, 3.44, 13.46, 30.22, 991.66, ''),
(38, 'Februari 2023', 'Allianz', 'DPLK_PPUKP_Money_Market_Fund', 'Konservatif', 0, 96.91, 3.09, 100, 0.41, 1.29, 2.19, 3.66, 13.37, 30.11, 1006.99, ''),
(39, 'Maret 2023', 'Allianz', 'DPLK_PPUKP_Money_Market_Fund', 'Konservatif', 0, 88.03, 11.97, 100, 0.48, 1.37, 2.44, 3.88, 13.28, 30.07, 998.26, ''),
(40, 'April 2023', 'Allianz', 'DPLK_PPUKP_Money_Market_Fund', 'Konservatif', 0, 81.27, 18.73, 100, 0.42, 1.32, 2.55, 4.09, 13.18, 29.88, 989.97, ''),
(41, 'Januari 2023', 'BNI', 'FFS_BNI_Simponi_Likuid', 'Konservatif', 1, 90.01, 9, 100.01, 0.44, 1.2, 1.99, 3.55, 13.77, 28.46, 0, ''),
(42, 'Februari 2023', 'BNI', 'FFS_BNI_Simponi_Likuid', 'Konservatif', 1, 88.38, 11, 100.38, 0.46, 1.3, 2.2, 3.74, 13.65, 28.35, 0, ''),
(43, 'Maret 2023', 'BNI', 'FFS_BNI_Simponi_Likuid', 'Konservatif', 1, 87.85, 11, 99.85, 0.47, 1.36, 2.43, 3.94, 13.54, 28.27, 0, ''),
(44, 'April 2023', 'BNI', 'FFS_BNI_Simponi_Likuid', 'Konservatif', 1, 88.38, 11, 100.38, 0.43, 1.35, 2.55, 4.12, 13.39, 28.16, 0, ''),
(45, 'Januari 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Plus', 'Konservatif', 1, 69.77, 30.68, 101.45, 0.5, 1.87, 2.43, 3.73, 16.04, 30.91, 0, ''),
(46, 'Februari 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Plus', 'Konservatif', 1, 66.88, 33.55, 101.43, 0.39, 1.45, 2.48, 3.81, 15.86, 30.82, 0, ''),
(47, 'Maret 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Plus', 'Konservatif', 1, 66.75, 33.7, 101.45, 0.55, 1.44, 2.95, 4.21, 16.05, 30.79, 0, ''),
(48, 'April 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Plus', 'Konservatif', 1, 66.88, 33.55, 101.43, 0.49, 1.43, 3.3, 4.72, 15.9, 30.79, 0, ''),
(49, 'Januari 2023', 'Generali', 'DPLK_Generali_Money Market', 'Konservatif', 0, 100, 0, 100, 0.36, 0.96, 0, 3.16, 0, 0, 310.01, ''),
(50, 'Februari 2023', 'Generali', 'DPLK_Generali_Money Market', 'Konservatif', 0, 100, 0, 100, 0.33, 1.1, 0, 3.28, 0, 0, 330.15, ''),
(51, 'Maret 2023', 'Generali', 'DPLK_Generali_Money Market', 'Konservatif', 0, 100, 0, 100, 0.39, 1.08, 0, 3.41, 0, 0, 334.24, ''),
(52, 'April 2023', 'Generali', 'DPLK_Generali_Money Market', 'Konservatif', 0, 100, 0, 100, 0.34, 1.06, 0, 3.54, 0, 0, 337.58, ''),
(53, 'Januari 2023', 'Manulife', 'GRO_Dana_Pasar_Uang', 'Konservatif', 0, 100, 0, 100, 0.41, 1.02, 1.82, 3.35, 4.43, 5.56, 9340, ''),
(54, 'Februari 2023', 'Manulife', 'GRO_Dana_Pasar_Uang', 'Konservatif', 0, 100, 0, 100, 0.39, 1.14, 1.94, 3.53, 4.38, 5.54, 9380, ''),
(55, 'Maret 2023', 'Manulife', 'GRO_Dana_Pasar_Uang', 'Konservatif', 0, 100, 0, 100, 0.46, 1.27, 2.16, 3.71, 4.35, 5.52, 9430, ''),
(56, 'April 2023', 'Manulife', 'GRO_Dana_Pasar_Uang', 'Konservatif', 0, 100, 0, 100, 0.42, 1.28, 2.31, 3.91, 4.33, 5.51, 9460, ''),
(57, 'Januari 2023', 'Manulife', 'GRO_Dana_Pendapatan_Tetap', 'Konservatif', 0, 12.74, 87.26, 100, 1.75, 6.08, 5.41, 5.24, 6.85, 6.7, 2100, ''),
(58, 'Februari 2023', 'Manulife', 'GRO_Dana_Pendapatan_Tetap', 'Konservatif', 0, 10.04, 89.97, 100.01, -0.15, 2.56, 4.09, 4.64, 6.88, 6.97, 2100, ''),
(59, 'Maret 2023', 'Manulife', 'GRO_Dana_Pendapatan_Tetap', 'Konservatif', 0, 12.57, 87.43, 100, 0.85, 2.46, 6.34, 6.49, 8.95, 6.98, 2190, ''),
(60, 'April 2023', 'Manulife', 'GRO_Dana_Pendapatan_Tetap', 'Konservatif', 0, 4.77, 95.23, 100, 0.97, 1.68, 7.86, 8.24, 8.86, 7.37, 2240, ''),
(61, 'Januari 2023', 'Manulife', 'GRO_Dana_Syariah', 'Konservatif', 0, 100, 0, 100, 0.46, 1.13, 1.9, 3.36, 4.3, 5.36, 628.85, ''),
(62, 'Februari 2023', 'Manulife', 'GRO_Dana_Syariah', 'Konservatif', 0, 100, 0, 100, 0.41, 1.24, 2.05, 3.58, 4.27, 5.35, 637.21, ''),
(63, 'Maret 2023', 'Manulife', 'GRO_Dana_Syariah', 'Konservatif', 0, 100, 0, 100, 0.46, 1.33, 2.27, 3.77, 4.25, 5.34, 649.72, ''),
(64, 'April 2023', 'Manulife', 'GRO_Dana_Syariah', 'Konservatif', 0, 100, 0, 100, 0.41, 1.28, 2.42, 3.96, 4.22, 5.33, 664.39, ''),
(65, 'Januari 2023', 'Manulife', 'GRO_Dana_US_Dollar', 'Konservatif', 0, 100, 0, 100, -4.29, -3.81, 0.03, 3.39, 4.91, 4.2, 11.49, ''),
(66, 'Februari 2023', 'Manulife', 'GRO_Dana_US_Dollar', 'Konservatif', 0, 100, 0, 100, 2.08, -2.85, 2.93, 5.77, 4.03, 4.23, 75.04, ''),
(67, 'Maret 2023', 'Manulife', 'GRO_Dana_US_Dollar', 'Konservatif', 0, 100, 0, 100, -1.24, -3.53, -1.12, 4.85, -1.24, 3.87, 75.84, ''),
(68, 'April 2023', 'Manulife', 'GRO_Dana_US_Dollar', 'Konservatif', 0, 100, 0, 100, -2.3, -1.51, -5.12, 1.93, 0.51, 3.2, 75.35, ''),
(69, 'Januari 2023', 'Muamalat', 'Paket A', 'Konservatif', 0, 85.17, 14.83, 100, 0.53, 1.5, 2.58, 4.42, 17.41, 32.7, 893.86, ''),
(70, 'Februari 2023', 'Muamalat', 'Paket A', 'Konservatif', 0, 88.88, 11.12, 100, 0.43, 1.35, 2.64, 4.61, 17.43, 32.5, 890.35, ''),
(71, 'Maret 2023', 'Muamalat', 'Paket A', 'Konservatif', 0, 92.57, 7.43, 100, 0.51, 1.47, 2.83, 4.7, 17.13, 32.51, 917.88, ''),
(72, 'April 2023', 'Muamalat', 'Paket A', 'Konservatif', 0, 89.54, 10.46, 100, 0.45, 1.39, 2.89, 4.92, 16.99, 32.36, 935.28, ''),
(73, 'Januari 2023', 'SimasJaya', 'Siji_Pensiun_Bahagia', 'Konservatif', 1.14, 6.4, 92.46, 100, 1.15, 4.02, 5.34, 8.37, 0, 0, 67, ''),
(74, 'Februari 2023', 'SimasJaya', 'Siji_Pensiun_Bahagia', 'Konservatif', 1.15, 5.23, 93.62, 100, 0.17, 1.99, 3.98, 7.33, 0, 0, 106.39, ''),
(75, 'Maret 2023', 'SimasJaya', 'Siji_Pensiun_Bahagia', 'Konservatif', 1.08, 6.12, 92.8, 100, 0.84, 2.16, 4.69, 7.95, 0, 0, 110.89, ''),
(76, 'April 2023', 'SimasJaya', 'Siji_Pensiun_Bahagia', 'Konservatif', 1.21, 6.49, 92.31, 100.01, 0.98, 10.52, 6.09, 9.17, 0, 0, 111.76, ''),
(77, 'Januari 2023', 'SimasJaya', 'Siji_Pensiun_Sejahtera', 'Konservatif', 0, 7.96, 92.04, 100, 1.04, 4.2, 4.72, 8.6, 0, 0, 125, ''),
(78, 'Februari 2023', 'SimasJaya', 'Siji_Pensiun_Sejahtera', 'Konservatif', 0, 3.94, 96.06, 100, 0.27, 1.84, 3.43, 7.58, 0, 0, 202.66, ''),
(79, 'Maret 2023', 'SimasJaya', 'Siji_Pensiun_Sejahtera', 'Konservatif', 0, 5.19, 94.81, 100, 0.7, 2.02, 4.87, 8.32, 0, 0, 200.85, ''),
(80, 'April 2023', 'SimasJaya', 'Siji_Pensiun_Sejahtera', 'Konservatif', 0, 8.07, 91.93, 100, 0.8, 10.53, 6.05, 9.47, 0, 0, 230.27, ''),
(81, 'Januari 2023', 'Allianz', 'DPLK_Fixed_Income', 'Moderat', 0, 5.49, 94.51, 100, 1.36, 5.48, 4.93, 5.16, 22.17, 39.93, 246.37, ''),
(82, 'Februari 2023', 'Allianz', 'DPLK_Fixed_Income', 'Moderat', 0, 4.13, 95.87, 100, -0.08, 2.16, 3.94, 4.57, 22.58, 41.39, 246.84, ''),
(83, 'Maret 2023', 'Allianz', 'DPLK_Fixed_Income', 'Moderat', 0, 3.14, 96.86, 100, 1.01, 2.31, 6.11, 6.3, 29.63, 41.99, 252.23, ''),
(84, 'April 2023', 'Allianz', 'DPLK_Fixed_Income', 'Moderat', 0, 7.11, 92.89, 100, 1.04, 1.99, 7.57, 8.27, 29.2, 44.49, 254.71, ''),
(85, 'Januari 2023', 'Allianz', 'DPLK_PPUKP_Fixed_Income_Fund', 'Moderat', 0, 2.97, 97.03, 100, 1.34, 5.46, 4.83, 4.42, 21.56, 37.09, 727.98, ''),
(86, 'Februari 2023', 'Allianz', 'DPLK_PPUKP_Fixed_Income_Fund', 'Moderat', 0, 2.02, 97.98, 100, -0.12, 2.07, 3.76, 3.91, 22.16, 39.09, 708.56, ''),
(87, 'Maret 2023', 'Allianz', 'DPLK_PPUKP_Fixed_Income_Fund', 'Moderat', 0, 2.02, 97.98, 100, 1, 2.23, 5.9, 5.73, 29.63, 39.23, 711.04, ''),
(88, 'April 2023', 'Allianz', 'DPLK_PPUKP_Fixed_Income_Fund', 'Moderat', 0, 3.73, 96.27, 100, 0.99, 1.88, 7.45, 7.87, 28.77, 41.68, 713.72, ''),
(89, 'Januari 2023', 'Allianz', 'DPLK_Syariah_Fund', 'Moderat', 0, 6.98, 93.02, 100, 0.62, 2.05, 2.31, 2.74, 19.94, 36.61, 125.24, ''),
(90, 'Februari 2023', 'Allianz', 'DPLK_Syariah_Fund', 'Moderat', 0, 3.36, 96.64, 100, 0.09, 0.88, 1.75, 2.43, 19.73, 37.29, 126.43, ''),
(91, 'Maret 2023', 'Allianz', 'DPLK_Syariah_Fund', 'Moderat', 0, 3.4, 96.6, 100, 0.87, 1.59, 3.06, 3.23, 23.78, 37.8, 130.03, ''),
(92, 'April 2023', 'Allianz', 'DPLK_Syariah_Fund', 'Moderat', 0, 4.38, 95.62, 100, 0.69, 1.65, 3.74, 4.5, 23.33, 40.16, 132.06, ''),
(93, 'Januari 2023', 'Allianz', 'DPLK_USD_Fund', 'Moderat', 0, 5.87, 94.13, 100, -4.05, -0.41, -0.92, -0.58, 3.95, 13.59, 0.0063, ''),
(94, 'Februari 2023', 'Allianz', 'DPLK_USD_Fund', 'Moderat', 0, 2.7, 97.3, 100, 0.51, -3.26, 0.88, 1.2, 1.82, 14.07, 6.3, ''),
(95, 'Maret 2023', 'Allianz', 'DPLK_USD_Fund', 'Moderat', 0, 3.6, 96.4, 100, 0.65, -2.94, 2.85, 2.42, -7.91, 13.86, 6.4, ''),
(96, 'April 2023', 'Allianz', 'DPLK_USD_Fund', 'Moderat', 0, 4.14, 95.86, 100, -0.66, 0.49, 0.08, 3.74, -4.83, 12.59, 6.4, ''),
(97, 'Januari 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Syariah', 'Moderat', 0, 59.95, 40.06, 100.01, 0.56, 1.75, 2.31, 3.48, 20.1, 35.74, 0, ''),
(98, 'Februari 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Syariah', 'Moderat', 0, 62.91, 37.09, 100, 0.43, 1.29, 2.44, 3.55, 19.87, 35.47, 0, ''),
(99, 'Maret 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Syariah', 'Moderat', 0, 62.65, 37.35, 100, 0.61, 1.6, 3.03, 4.07, 19.86, 35.43, 0, ''),
(100, 'April 2023', 'BNI', 'FFS_BNI_Simponi_Likuid_Syariah', 'Moderat', 0, 62.91, 37.09, 100, 0.54, 1.57, 3.32, 4.62, 19.77, 35.35, 0, ''),
(101, 'Januari 2023', 'BNI', 'FFS_BNI_Simponi_Moderat', 'Moderat', 0, 49.59, 50.41, 100, 0.57, 2.54, 2.87, 3.92, 18.31, 33.36, 0, ''),
(102, 'Februari 2023', 'BNI', 'FFS_BNI_Simponi_Moderat', 'Moderat', 0, 45.31, 54.69, 100, 0.31, 1.61, 2.77, 3.87, 18.06, 33.29, 0, ''),
(103, 'Maret 2023', 'BNI', 'FFS_BNI_Simponi_Moderat', 'Moderat', 0, 45.58, 54.42, 100, 0.64, 1.53, 3.47, 4.49, 18.57, 33.31, 0, ''),
(104, 'April 2023', 'BNI', 'FFS_BNI_Simponi_Moderat', 'Moderat', 0, 45.31, 54.69, 100, 0.56, 1.51, 4.05, 5.32, 18.41, 33.42, 0, ''),
(105, 'Januari 2023', 'Generali', 'DPLK_Generali_Fixed Income', 'Moderat', 0, 29.44, 70.56, 100, 1.49, 4.67, 0, 6.71, 0, 0, 80.11, ''),
(106, 'Februari 2023', 'Generali', 'DPLK_Generali_Fixed Income', 'Moderat', 0, 17.38, 82.62, 100, 0.23, 2.34, 0, 6.54, 0, 0, 85.03, ''),
(107, 'Maret 2023', 'Generali', 'DPLK_Generali_Fixed Income', 'Moderat', 0, 8.29, 91.71, 100, 0.86, 2.6, 0, 7.32, 0, 0, 88.51, ''),
(108, 'April 2023', 'Generali', 'DPLK_Generali_Fixed Income', 'Moderat', 0, 2.36, 97.64, 100, 1.08, 2.19, 0, 8.82, 0, 0, 93.31, ''),
(109, 'Januari 2023', 'Muamalat', 'Paket B', 'Moderat', 0, 24.86, 75.15, 100.01, 0.78, 2.86, 3.22, 4.21, 21.23, 41.07, 520.96, ''),
(110, 'Februari 2023', 'Muamalat', 'Paket B', 'Moderat', 0, 24.41, 75.59, 100, 0.01, 0.85, 2.25, 3.36, 21.81, 40.53, 524.52, ''),
(111, 'Maret 2023', 'Muamalat', 'Paket B', 'Moderat', 0, 37.37, 62.63, 100, 0.75, 1.54, 3.5, 4.15, 25.94, 40.44, 521.29, ''),
(112, 'April 2023', 'Muamalat', 'Paket B', 'Moderat', 0, 35.83, 64.17, 100, 0.69, 1.45, 4.31, 4.91, 25.03, 40.41, 521.29, '');

-- --------------------------------------------------------

--
-- Table structure for table `role`
--

CREATE TABLE `role` (
  `id` int(11) NOT NULL,
  `role` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `role`
--

INSERT INTO `role` (`id`, `role`) VALUES
(1, 'admin'),
(2, 'user');

-- --------------------------------------------------------

--
-- Table structure for table `session`
--

CREATE TABLE `session` (
  `user_id` varchar(100) NOT NULL,
  `token` text NOT NULL,
  `token_exp` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `session`
--

INSERT INTO `session` (`user_id`, `token`, `token_exp`) VALUES
('1490622023', 'XHQFeFZAL/Ho11Zpp7gxrUYRgSaeQk/f0YKG7bvgKL4ICzkG9T3gVF2GKo4PB5oH2q6DLOQfP0IPAfXhXHqguw==', '2024-06-14 09:56:28');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(100) NOT NULL,
  `username` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `nama` varchar(45) NOT NULL,
  `role_id` int(11) NOT NULL,
  `tipe_risiko` enum('Konservatif','Moderat','Agresif') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `username`, `email`, `password`, `nama`, `role_id`, `tipe_risiko`) VALUES
(1, 'admin', 'admin@gmail.com', 'admin123', 'Admin', 1, NULL),
(1490622023, 'ferdian', 'ferdian@gmail.com', 'U2FsdGVkX185/EmiRAzMoXojNKtlOutI5K84kVitAS8=', 'Ferdiany', 2, NULL);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dplk`
--
ALTER TABLE `dplk`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`user_id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `username_UNIQUE` (`username`),
  ADD UNIQUE KEY `email_UNIQUE` (`email`),
  ADD KEY `role_id_idx` (`role_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dplk`
--
ALTER TABLE `dplk`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=113;

--
-- AUTO_INCREMENT for table `role`
--
ALTER TABLE `role`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=1490622024;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `users`
--
ALTER TABLE `users`
  ADD CONSTRAINT `role_id` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
