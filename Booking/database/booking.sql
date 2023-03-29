-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 29, 2023 at 06:08 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `booking`
--

-- --------------------------------------------------------

--
-- Table structure for table `bokking_details`
--

CREATE TABLE `bokking_details` (
  `booking_id` int(30) NOT NULL,
  `location_id` varchar(50) NOT NULL,
  `drone_shot_id` varchar(50) NOT NULL,
  `booking_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `Customer_id` int(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `Customer_id` int(30) NOT NULL,
  `Customer_name` varchar(50) NOT NULL,
  `Customer_email` varchar(100) NOT NULL,
  `Customer_number` bigint(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`Customer_id`, `Customer_name`, `Customer_email`, `Customer_number`) VALUES
(1, 'Naseem ahamad', 'naseemahamad165@gmail.com', 123),
(2, 'Sarvej', 'sarvej@123', 787817502),
(4, 'zara khan', 'zara@gmail.com', 123456789),
(5, 'Naseem ahamad', 'naseemahamad165@gmail.com', 894910884),
(6, 'Naseem ahamad', 'naseemahamad165@gmail.com', 2147483647),
(7, 'Naseem ahamad', 'naseemahamad165@gmail.com', 8949108848),
(9, 'Naseem ahamad', 'naseemahamad165@gmail.com', 894910884);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bokking_details`
--
ALTER TABLE `bokking_details`
  ADD PRIMARY KEY (`booking_id`),
  ADD KEY `Customer_id` (`Customer_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`Customer_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bokking_details`
--
ALTER TABLE `bokking_details`
  MODIFY `booking_id` int(30) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `Customer_id` int(30) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `bokking_details`
--
ALTER TABLE `bokking_details`
  ADD CONSTRAINT `bokking_details_ibfk_1` FOREIGN KEY (`booking_id`) REFERENCES `customer` (`Customer_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
