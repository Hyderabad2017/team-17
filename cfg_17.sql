-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 15, 2017 at 04:38 PM
-- Server version: 10.1.25-MariaDB
-- PHP Version: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `cfg_17`
--

-- --------------------------------------------------------

--
-- Table structure for table `events`
--

CREATE TABLE `events` (
  `event_id` int(10) NOT NULL,
  `event_req_id` int(10) NOT NULL,
  `event_vol_id` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `req_id` int(10) NOT NULL,
  `stu_name` varchar(50) NOT NULL,
  `stu_exam` varchar(100) NOT NULL,
  `stu_date_exam` date NOT NULL,
  `stu_location` varchar(50) NOT NULL,
  `stu_gender` varchar(2) NOT NULL,
  `stu_primary` int(10) DEFAULT NULL,
  `stu_secondary` int(10) DEFAULT NULL,
  `stu_backup` int(10) DEFAULT NULL,
  `stu_mobile` bigint(13) NOT NULL,
  `stu_language` varchar(20) NOT NULL,
  `stu_req_status` varchar(20) DEFAULT NULL,
  `stu_email` varchar(40) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`req_id`, `stu_name`, `stu_exam`, `stu_date_exam`, `stu_location`, `stu_gender`, `stu_primary`, `stu_secondary`, `stu_backup`, `stu_mobile`, `stu_language`, `stu_req_status`, `stu_email`) VALUES
(1, 'brett lee', 'ssc', '2017-07-20', 'sec', 'm', NULL, NULL, NULL, 9700326300, 'telugu', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `volunteer`
--

CREATE TABLE `volunteer` (
  `vol_id` int(20) NOT NULL,
  `vol_name` varchar(30) NOT NULL,
  `vol_gender` varchar(2) NOT NULL,
  `vol_qualification` varchar(30) NOT NULL,
  `vol_location` varchar(50) NOT NULL,
  `vol_status` varchar(20) NOT NULL,
  `vol_mobile` bigint(13) NOT NULL,
  `vol_email` varchar(40) DEFAULT NULL,
  `vol_language` varchar(30) NOT NULL,
  `vol_pswd` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `volunteer`
--

INSERT INTO `volunteer` (`vol_id`, `vol_name`, `vol_gender`, `vol_qualification`, `vol_location`, `vol_status`, `vol_mobile`, `vol_email`, `vol_language`, `vol_pswd`) VALUES
(55, 'nve', 'm', '', 'hyderabad', 'available', 10, 'mr.naveen8@gmail.com', 'english', 'abcd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `events`
--
ALTER TABLE `events`
  ADD PRIMARY KEY (`event_id`);

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`req_id`);

--
-- Indexes for table `volunteer`
--
ALTER TABLE `volunteer`
  ADD PRIMARY KEY (`vol_id`),
  ADD UNIQUE KEY `vol_mobile` (`vol_mobile`),
  ADD UNIQUE KEY `vol_mobile_2` (`vol_mobile`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `events`
--
ALTER TABLE `events`
  MODIFY `event_id` int(10) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `req_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT for table `volunteer`
--
ALTER TABLE `volunteer`
  MODIFY `vol_id` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=56;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
