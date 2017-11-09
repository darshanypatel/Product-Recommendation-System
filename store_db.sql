-- phpMyAdmin SQL Dump
-- version 4.2.7.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 19, 2015 at 04:12 PM
-- Server version: 5.6.20
-- PHP Version: 5.5.15

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `store_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `item_details`
--

CREATE TABLE IF NOT EXISTS `item_details` (
`i_id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL,
  `price` int(11) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=16 ;

--
-- Dumping data for table `item_details`
--

INSERT INTO `item_details` (`i_id`, `name`, `price`) VALUES
(1, 'hp Pavilion Series', 45000),
(2, 'hp Pavilion2 Series', 55000),
(3, 'Toshiba''s Laptop', 38500),
(4, 'Asus Laptop', 36000),
(5, 'hp Touch Screen', 61800),
(6, 'hp Ultimate Series', 75500),
(7, 'Skullcandy Headphones', 2330),
(8, 'Boss Headphones', 1890),
(9, 'Headphones by JVC', 2700),
(10, 'Windows 8 Tablet', 15100),
(11, 'Samsung Tablet', 18600),
(12, 'Apple ipad', 23450),
(13, 'Samsung Galaxy A7', 27310),
(14, 'Samsung S6 Edge', 58000),
(15, 'Apple iphone 7', 65500);

-- --------------------------------------------------------

--
-- Table structure for table `register`
--

CREATE TABLE IF NOT EXISTS `register` (
`t_id` int(11) NOT NULL,
  `date_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `c_id` int(11) NOT NULL,
  `items_purchased` varchar(15) NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=24 ;

--
-- Dumping data for table `register`
--

INSERT INTO `register` (`t_id`, `date_time`, `c_id`, `items_purchased`) VALUES
(19, '2015-04-19 13:58:39', 1, '6 7 13 '),
(20, '2015-04-19 14:00:13', 1, '5 8 12 15 '),
(23, '2015-04-19 14:07:27', 1, '5 8 12 ');

-- --------------------------------------------------------

--
-- Table structure for table `related_items`
--

CREATE TABLE IF NOT EXISTS `related_items` (
`itemset_id` int(11) NOT NULL,
  `itemset` text NOT NULL
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=3 ;

--
-- Dumping data for table `related_items`
--

INSERT INTO `related_items` (`itemset_id`, `itemset`) VALUES
(1, '5 8 12');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `item_details`
--
ALTER TABLE `item_details`
 ADD PRIMARY KEY (`i_id`);

--
-- Indexes for table `register`
--
ALTER TABLE `register`
 ADD PRIMARY KEY (`t_id`);

--
-- Indexes for table `related_items`
--
ALTER TABLE `related_items`
 ADD PRIMARY KEY (`itemset_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `item_details`
--
ALTER TABLE `item_details`
MODIFY `i_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=16;
--
-- AUTO_INCREMENT for table `register`
--
ALTER TABLE `register`
MODIFY `t_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=24;
--
-- AUTO_INCREMENT for table `related_items`
--
ALTER TABLE `related_items`
MODIFY `itemset_id` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=3;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
