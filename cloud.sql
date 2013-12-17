-- MySQL dump 10.13  Distrib 5.5.34, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: cloud
-- ------------------------------------------------------
-- Server version	5.5.34-0ubuntu0.13.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `account`
--

DROP TABLE IF EXISTS `account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_name` varchar(100) DEFAULT NULL COMMENT 'an account name set by the creator of the account, defaults to username for single accounts',
  `uuid` varchar(40) DEFAULT NULL,
  `type` int(1) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned DEFAULT NULL,
  `state` varchar(10) NOT NULL DEFAULT 'enabled',
  `removed` datetime DEFAULT NULL COMMENT 'date removed',
  `cleanup_needed` tinyint(1) NOT NULL DEFAULT '0',
  `network_domain` varchar(255) DEFAULT NULL,
  `default_zone_id` bigint(20) unsigned DEFAULT NULL,
  `default` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if account is default',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_account__uuid` (`uuid`),
  KEY `i_account__removed` (`removed`),
  KEY `fk_account__default_zone_id` (`default_zone_id`),
  KEY `i_account__cleanup_needed` (`cleanup_needed`),
  KEY `i_account__account_name__domain_id__removed` (`account_name`,`domain_id`,`removed`),
  KEY `i_account__domain_id` (`domain_id`),
  CONSTRAINT `fk_account__default_zone_id` FOREIGN KEY (`default_zone_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_account__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account`
--

LOCK TABLES `account` WRITE;
/*!40000 ALTER TABLE `account` DISABLE KEYS */;
INSERT INTO `account` VALUES (1,'system','4e6d3d8b-3e05-11e3-a27a-14109fdfd297',1,1,'enabled',NULL,0,NULL,NULL,1),(2,'admin','4e6d441c-3e05-11e3-a27a-14109fdfd297',1,1,'enabled',NULL,0,NULL,NULL,1);
/*!40000 ALTER TABLE `account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `account_details`
--

DROP TABLE IF EXISTS `account_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'account id',
  `name` varchar(255) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_account_details__account_id` (`account_id`),
  CONSTRAINT `fk_account_details__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_details`
--

LOCK TABLES `account_details` WRITE;
/*!40000 ALTER TABLE `account_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `account_netstats_view`
--

DROP TABLE IF EXISTS `account_netstats_view`;
/*!50001 DROP VIEW IF EXISTS `account_netstats_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `account_netstats_view` (
  `account_id` tinyint NOT NULL,
  `bytesReceived` tinyint NOT NULL,
  `bytesSent` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `account_network_ref`
--

DROP TABLE IF EXISTS `account_network_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_network_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'account id',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network id',
  `is_owner` smallint(1) NOT NULL COMMENT 'is the owner of the network',
  PRIMARY KEY (`id`),
  KEY `fk_account_network_ref__account_id` (`account_id`),
  KEY `fk_account_network_ref__networks_id` (`network_id`),
  CONSTRAINT `fk_account_network_ref__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_account_network_ref__networks_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_network_ref`
--

LOCK TABLES `account_network_ref` WRITE;
/*!40000 ALTER TABLE `account_network_ref` DISABLE KEYS */;
INSERT INTO `account_network_ref` VALUES (1,1,200,1),(2,1,201,1),(3,1,202,1),(4,1,203,1);
/*!40000 ALTER TABLE `account_network_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `account_view`
--

DROP TABLE IF EXISTS `account_view`;
/*!50001 DROP VIEW IF EXISTS `account_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `account_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `cleanup_needed` tinyint NOT NULL,
  `network_domain` tinyint NOT NULL,
  `default` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `bytesReceived` tinyint NOT NULL,
  `bytesSent` tinyint NOT NULL,
  `vmLimit` tinyint NOT NULL,
  `vmTotal` tinyint NOT NULL,
  `runningVms` tinyint NOT NULL,
  `stoppedVms` tinyint NOT NULL,
  `ipLimit` tinyint NOT NULL,
  `ipTotal` tinyint NOT NULL,
  `ipFree` tinyint NOT NULL,
  `volumeLimit` tinyint NOT NULL,
  `volumeTotal` tinyint NOT NULL,
  `snapshotLimit` tinyint NOT NULL,
  `snapshotTotal` tinyint NOT NULL,
  `templateLimit` tinyint NOT NULL,
  `templateTotal` tinyint NOT NULL,
  `vpcLimit` tinyint NOT NULL,
  `vpcTotal` tinyint NOT NULL,
  `projectLimit` tinyint NOT NULL,
  `projectTotal` tinyint NOT NULL,
  `networkLimit` tinyint NOT NULL,
  `networkTotal` tinyint NOT NULL,
  `cpuLimit` tinyint NOT NULL,
  `cpuTotal` tinyint NOT NULL,
  `memoryLimit` tinyint NOT NULL,
  `memoryTotal` tinyint NOT NULL,
  `primaryStorageLimit` tinyint NOT NULL,
  `primaryStorageTotal` tinyint NOT NULL,
  `secondaryStorageLimit` tinyint NOT NULL,
  `secondaryStorageTotal` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `account_vlan_map`
--

DROP TABLE IF EXISTS `account_vlan_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_vlan_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'account id. foreign key to account table',
  `vlan_db_id` bigint(20) unsigned NOT NULL COMMENT 'database id of vlan. foreign key to vlan table',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `i_account_vlan_map__account_id` (`account_id`),
  KEY `i_account_vlan_map__vlan_id` (`vlan_db_id`),
  CONSTRAINT `fk_account_vlan_map__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_account_vlan_map__vlan_id` FOREIGN KEY (`vlan_db_id`) REFERENCES `vlan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_vlan_map`
--

LOCK TABLES `account_vlan_map` WRITE;
/*!40000 ALTER TABLE `account_vlan_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_vlan_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `account_vmstats_view`
--

DROP TABLE IF EXISTS `account_vmstats_view`;
/*!50001 DROP VIEW IF EXISTS `account_vmstats_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `account_vmstats_view` (
  `account_id` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `vmcount` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `account_vnet_map`
--

DROP TABLE IF EXISTS `account_vnet_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `account_vnet_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) DEFAULT NULL,
  `vnet_range` varchar(255) NOT NULL COMMENT 'dedicated guest vlan range',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'account id. foreign key to account table',
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'physical network id. foreign key to the the physical network table',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `i_account_vnet_map__physical_network_id` (`physical_network_id`),
  KEY `i_account_vnet_map__account_id` (`account_id`),
  CONSTRAINT `fk_account_vnet_map__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_account_vnet_map__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `account_vnet_map`
--

LOCK TABLES `account_vnet_map` WRITE;
/*!40000 ALTER TABLE `account_vnet_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `account_vnet_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affinity_group`
--

DROP TABLE IF EXISTS `affinity_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affinity_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `type` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `description` varchar(4096) DEFAULT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `acl_type` varchar(15) NOT NULL COMMENT 'ACL access type. can be Account/Domain',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`,`account_id`),
  UNIQUE KEY `uc_affinity_group__uuid` (`uuid`),
  KEY `fk_affinity_group__account_id` (`account_id`),
  KEY `fk_affinity_group__domain_id` (`domain_id`),
  CONSTRAINT `fk_affinity_group__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_affinity_group__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affinity_group`
--

LOCK TABLES `affinity_group` WRITE;
/*!40000 ALTER TABLE `affinity_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `affinity_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `affinity_group_domain_map`
--

DROP TABLE IF EXISTS `affinity_group_domain_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affinity_group_domain_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain id',
  `affinity_group_id` bigint(20) unsigned NOT NULL COMMENT 'affinity group id',
  `subdomain_access` int(1) unsigned DEFAULT '1' COMMENT '1 if affinity group can be accessible from the subdomain',
  PRIMARY KEY (`id`),
  KEY `fk_affinity_group_domain_map__domain_id` (`domain_id`),
  KEY `fk_affinity_group_domain_map__affinity_group_id` (`affinity_group_id`),
  CONSTRAINT `fk_affinity_group_domain_map__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_affinity_group_domain_map__affinity_group_id` FOREIGN KEY (`affinity_group_id`) REFERENCES `affinity_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affinity_group_domain_map`
--

LOCK TABLES `affinity_group_domain_map` WRITE;
/*!40000 ALTER TABLE `affinity_group_domain_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `affinity_group_domain_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `affinity_group_view`
--

DROP TABLE IF EXISTS `affinity_group_view`;
/*!50001 DROP VIEW IF EXISTS `affinity_group_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `affinity_group_view` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  `description` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `acl_type` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `vm_id` tinyint NOT NULL,
  `vm_uuid` tinyint NOT NULL,
  `vm_name` tinyint NOT NULL,
  `vm_state` tinyint NOT NULL,
  `vm_display_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `affinity_group_vm_map`
--

DROP TABLE IF EXISTS `affinity_group_vm_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `affinity_group_vm_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `affinity_group_id` bigint(20) unsigned NOT NULL,
  `instance_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_agvm__group_id` (`affinity_group_id`),
  KEY `fk_affinity_group_vm_map___instance_id` (`instance_id`),
  CONSTRAINT `fk_agvm__group_id` FOREIGN KEY (`affinity_group_id`) REFERENCES `affinity_group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_affinity_group_vm_map___instance_id` FOREIGN KEY (`instance_id`) REFERENCES `user_vm` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `affinity_group_vm_map`
--

LOCK TABLES `affinity_group_vm_map` WRITE;
/*!40000 ALTER TABLE `affinity_group_vm_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `affinity_group_vm_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `alert`
--

DROP TABLE IF EXISTS `alert`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `alert` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `type` int(1) unsigned NOT NULL,
  `cluster_id` bigint(20) unsigned DEFAULT NULL,
  `pod_id` bigint(20) unsigned DEFAULT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `subject` varchar(999) DEFAULT NULL COMMENT 'according to SMTP spec, max subject length is 1000 including the CRLF character, so allow enough space to fit long pod/zone/host names',
  `sent_count` int(3) unsigned NOT NULL,
  `created` datetime DEFAULT NULL COMMENT 'when this alert type was created',
  `last_sent` datetime DEFAULT NULL COMMENT 'Last time the alert was sent',
  `resolved` datetime DEFAULT NULL COMMENT 'when the alert status was resolved (available memory no longer at critical level, etc.)',
  `archived` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_alert__uuid` (`uuid`),
  KEY `i_alert__last_sent` (`last_sent`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alert`
--

LOCK TABLES `alert` WRITE;
/*!40000 ALTER TABLE `alert` DISABLE KEYS */;
INSERT INTO `alert` VALUES (1,'bc24abef-81d8-428e-8ac1-cbc2a3757f8c',14,NULL,0,0,'Management network CIDR is not configured originally. Set it default to 192.168.3.0/24',1,'2013-10-26 06:30:26','2013-10-26 06:30:26',NULL,0),(2,'ea84dc62-e8b5-480a-b9c8-e686e6f1a455',14,NULL,0,0,'Management server node 127.0.0.1 is up',1,'2013-10-26 06:30:29','2013-10-26 06:30:29',NULL,0);
/*!40000 ALTER TABLE `alert` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `async_job`
--

DROP TABLE IF EXISTS `async_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `async_job` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `instance_type` varchar(64) DEFAULT NULL COMMENT 'instance_type and instance_id work together to allow attaching an instance object to a job',
  `instance_id` bigint(20) unsigned DEFAULT NULL,
  `job_cmd` varchar(255) DEFAULT NULL,
  `job_cmd_info` text COMMENT 'command parameter info',
  `job_cmd_ver` int(1) DEFAULT NULL COMMENT 'command version',
  `job_status` int(1) DEFAULT NULL COMMENT 'general job execution status',
  `job_process_status` int(1) DEFAULT NULL COMMENT 'job specific process status for asynchronize progress update',
  `job_result_code` int(1) DEFAULT NULL COMMENT 'job result code, specify error code corresponding to result message',
  `job_result` text COMMENT 'job result info',
  `job_init_msid` bigint(20) DEFAULT NULL COMMENT 'the initiating msid',
  `job_complete_msid` bigint(20) DEFAULT NULL COMMENT 'completing msid',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `last_updated` datetime DEFAULT NULL COMMENT 'date created',
  `last_polled` datetime DEFAULT NULL COMMENT 'date polled',
  `removed` datetime DEFAULT NULL COMMENT 'date removed',
  `uuid` varchar(40) DEFAULT NULL,
  `related` char(40) NOT NULL,
  `job_type` varchar(32) DEFAULT NULL,
  `job_dispatcher` varchar(64) DEFAULT NULL,
  `job_executing_msid` bigint(20) DEFAULT NULL,
  `job_pending_signals` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_async__uuid` (`uuid`),
  KEY `i_async_job__removed` (`removed`),
  KEY `i_async__user_id` (`user_id`),
  KEY `i_async__account_id` (`account_id`),
  KEY `i_async__instance_type_id` (`instance_type`,`instance_id`),
  KEY `i_async__job_cmd` (`job_cmd`),
  KEY `i_async__created` (`created`),
  KEY `i_async__last_updated` (`last_updated`),
  KEY `i_async__last_poll` (`last_polled`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `async_job`
--

LOCK TABLES `async_job` WRITE;
/*!40000 ALTER TABLE `async_job` DISABLE KEYS */;
INSERT INTO `async_job` VALUES (1,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.network.CreatePhysicalNetworkCmd','{\"id\":\"200\",\"response\":\"json\",\"cmdEventType\":\"PHYSICAL.NETWORK.CREATE\",\"ctxUserId\":\"2\",\"zoneid\":\"aa661d8d-0abd-4494-92a5-aa91d2ed59eb\",\"name\":\"eth0\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"7\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"dnIDsrB8KnKvyTCqkji8yM8jEwc\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.PhysicalNetworkResponse/physicalnetwork/{\"id\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"name\":\"eth0\",\"broadcastdomainrange\":\"ZONE\",\"zoneid\":\"aa661d8d-0abd-4494-92a5-aa91d2ed59eb\",\"state\":\"Disabled\"}',22061634278039,22061634278039,'2013-10-26 06:35:27','2013-10-26 06:35:27','2013-10-26 06:35:27',NULL,'70e30d28-d88c-4a25-bdf2-77fbb6009686','49fe52a4-3eca-4646-80e6-49121fd87036',NULL,'ApiAsyncJobDispatcher',NULL,0),(2,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.usage.AddTrafficTypeCmd','{\"id\":\"1\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"response\":\"json\",\"cmdEventType\":\"TRAFFIC.TYPE.CREATE\",\"ctxUserId\":\"2\",\"traffictype\":\"Management\",\"xennetworklabel\":\"Pool-wide network associated with eth0\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"11\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"hSTpxMJP174NIbss+AZCOi9z3eE\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.TrafficTypeResponse/traffictype/{\"id\":\"97797fb8-2342-4527-b01e-64311f461078\",\"traffictype\":\"Management\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"xennetworklabel\":\"Pool-wide network associated with eth0\"}',22061634278039,22061634278039,'2013-10-26 06:35:27','2013-10-26 06:35:27','2013-10-26 06:35:32',NULL,'af919024-ecd5-487a-a9cb-6d4538d51f25','73528188-f787-4744-a888-a42242f9919c',NULL,'ApiAsyncJobDispatcher',NULL,0),(3,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.usage.AddTrafficTypeCmd','{\"id\":\"2\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"response\":\"json\",\"cmdEventType\":\"TRAFFIC.TYPE.CREATE\",\"ctxUserId\":\"2\",\"traffictype\":\"Guest\",\"xennetworklabel\":\"Pool-wide network associated with eth0\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"15\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"Ugu4C8NEPsN5MWMkfAyNjS4TZi4\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.TrafficTypeResponse/traffictype/{\"id\":\"d102a472-2204-42d0-aa70-79e9a51c2b71\",\"traffictype\":\"Guest\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"xennetworklabel\":\"Pool-wide network associated with eth0\"}',22061634278039,22061634278039,'2013-10-26 06:35:32','2013-10-26 06:35:32','2013-10-26 06:35:37',NULL,'2c742065-95ce-446a-b663-7a716ace4369','fdc99f6f-ac6a-4049-a81f-933cc32ccd11',NULL,'ApiAsyncJobDispatcher',NULL,0),(4,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.usage.AddTrafficTypeCmd','{\"id\":\"3\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"response\":\"json\",\"cmdEventType\":\"TRAFFIC.TYPE.CREATE\",\"ctxUserId\":\"2\",\"traffictype\":\"Public\",\"xennetworklabel\":\"Pool-wide network associated with eth0\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"19\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"70EG637ig+wLLvHZVrB9S3t8CtQ\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.TrafficTypeResponse/traffictype/{\"id\":\"c4707703-949a-444c-a0e6-9f7ccf8d7b81\",\"traffictype\":\"Public\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"xennetworklabel\":\"Pool-wide network associated with eth0\"}',22061634278039,22061634278039,'2013-10-26 06:35:37','2013-10-26 06:35:37','2013-10-26 06:35:42',NULL,'eec64d23-cfb4-4c05-94ed-8b4b8e47fb95','6c50cadc-dbb4-45fe-9ca2-a3b8b4b83386',NULL,'ApiAsyncJobDispatcher',NULL,0),(5,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.router.ConfigureVirtualRouterElementCmd','{\"response\":\"json\",\"id\":\"39d1140d-9235-481c-89c0-3dd92b8e85c9\",\"enabled\":\"true\",\"cmdEventType\":\"NETWORK.ELEMENT.CONFIGURE\",\"ctxUserId\":\"2\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"23\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"7hTdW6g88GOiWzEIm29DQLCuH4Q\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.VirtualRouterProviderResponse/virtualrouterelement/{\"id\":\"39d1140d-9235-481c-89c0-3dd92b8e85c9\",\"nspid\":\"696de5bd-a643-4271-a87d-b26a779797bb\",\"enabled\":true}',22061634278039,22061634278039,'2013-10-26 06:35:42','2013-10-26 06:35:42','2013-10-26 06:35:42',NULL,'2b90fe16-a3aa-4802-8600-3213ef3f66d6','a1c86c52-bd5f-4b79-9b20-7b012acfc80f',NULL,'ApiAsyncJobDispatcher',NULL,0),(6,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.network.UpdateNetworkServiceProviderCmd','{\"id\":\"696de5bd-a643-4271-a87d-b26a779797bb\",\"response\":\"json\",\"cmdEventType\":\"SERVICE.PROVIDER.UPDATE\",\"ctxUserId\":\"2\",\"state\":\"Enabled\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"24\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"ZbU1hm6IqRrb7737B24Fkfr1K5A\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.ProviderResponse/networkserviceprovider/{\"name\":\"VirtualRouter\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"state\":\"Enabled\",\"id\":\"696de5bd-a643-4271-a87d-b26a779797bb\",\"servicelist\":[\"Vpn\",\"Dhcp\",\"Dns\",\"Gateway\",\"Firewall\",\"Lb\",\"SourceNat\",\"StaticNat\",\"PortForwarding\",\"UserData\"]}',22061634278039,22061634278039,'2013-10-26 06:35:42','2013-10-26 06:35:42','2013-10-26 06:35:47',NULL,'52b0aaa1-d5a6-407e-b1c0-54999e8c4744','3711fb50-237a-4b0c-8c4d-ba49729a7f23',NULL,'ApiAsyncJobDispatcher',NULL,0),(7,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.router.ConfigureVirtualRouterElementCmd','{\"response\":\"json\",\"id\":\"b7b4eb62-98b0-41b0-a18e-6de5d5051308\",\"enabled\":\"true\",\"cmdEventType\":\"NETWORK.ELEMENT.CONFIGURE\",\"ctxUserId\":\"2\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"27\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"nYZL+xTAPxaf/d8eEtlZzpFCptI\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.VirtualRouterProviderResponse/virtualrouterelement/{\"id\":\"b7b4eb62-98b0-41b0-a18e-6de5d5051308\",\"nspid\":\"cd7fcabe-1cf5-4bb4-8303-f99b7773a358\",\"enabled\":true}',22061634278039,22061634278039,'2013-10-26 06:35:47','2013-10-26 06:35:47','2013-10-26 06:35:47',NULL,'155884e7-01fd-4209-a826-213cf0358b5d','b39f171c-6b20-4927-a4a9-06d6145a0619',NULL,'ApiAsyncJobDispatcher',NULL,0),(8,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.network.UpdateNetworkServiceProviderCmd','{\"id\":\"cd7fcabe-1cf5-4bb4-8303-f99b7773a358\",\"response\":\"json\",\"cmdEventType\":\"SERVICE.PROVIDER.UPDATE\",\"ctxUserId\":\"2\",\"state\":\"Enabled\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"28\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"hvDOFPzDu2PcTia0mZaOETpVbEw\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.ProviderResponse/networkserviceprovider/{\"name\":\"VpcVirtualRouter\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"state\":\"Enabled\",\"id\":\"cd7fcabe-1cf5-4bb4-8303-f99b7773a358\",\"servicelist\":[\"Vpn\",\"Dhcp\",\"Dns\",\"Gateway\",\"Lb\",\"SourceNat\",\"StaticNat\",\"PortForwarding\",\"UserData\"]}',22061634278039,22061634278039,'2013-10-26 06:35:47','2013-10-26 06:35:47','2013-10-26 06:35:52',NULL,'5a7e1d0e-364c-490a-af8b-519a9b0f10c3','b5cf1a67-8e26-480f-b25f-3563e3a3aada',NULL,'ApiAsyncJobDispatcher',NULL,0),(9,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.internallb.ConfigureInternalLoadBalancerElementCmd','{\"response\":\"json\",\"id\":\"027fb8c1-9443-4c0b-8190-a00f3c39eec1\",\"enabled\":\"true\",\"cmdEventType\":\"NETWORK.ELEMENT.CONFIGURE\",\"ctxUserId\":\"2\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"31\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"Y1zM9X1jNv9RZ7BpuZhvOK10MlU\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.InternalLoadBalancerElementResponse/internalloadbalancerelement/{\"id\":\"027fb8c1-9443-4c0b-8190-a00f3c39eec1\",\"nspid\":\"0b6218e0-b4e5-4cb5-b895-fc89a401b2c5\",\"enabled\":true}',22061634278039,22061634278039,'2013-10-26 06:35:52','2013-10-26 06:35:52','2013-10-26 06:35:52',NULL,'bb42f620-314c-4441-94b3-b669212ba3b0','0d4e5e51-2720-4e45-a5ae-8b5c7ae84163',NULL,'ApiAsyncJobDispatcher',NULL,0),(10,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.network.UpdateNetworkServiceProviderCmd','{\"id\":\"0b6218e0-b4e5-4cb5-b895-fc89a401b2c5\",\"response\":\"json\",\"cmdEventType\":\"SERVICE.PROVIDER.UPDATE\",\"ctxUserId\":\"2\",\"state\":\"Enabled\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"32\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"H3XtRv/4CpGueyp9crSLY+4cZPU\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.ProviderResponse/networkserviceprovider/{\"name\":\"InternalLbVm\",\"physicalnetworkid\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"state\":\"Enabled\",\"id\":\"0b6218e0-b4e5-4cb5-b895-fc89a401b2c5\",\"servicelist\":[\"Lb\"]}',22061634278039,22061634278039,'2013-10-26 06:35:52','2013-10-26 06:35:52','2013-10-26 06:35:57',NULL,'3551fe84-393b-4826-94a7-d951442d2205','cb4a0870-759e-45db-87bd-6763fa2a62b5',NULL,'ApiAsyncJobDispatcher',NULL,0),(11,2,2,NULL,NULL,'org.apache.cloudstack.api.command.admin.network.UpdatePhysicalNetworkCmd','{\"response\":\"json\",\"id\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"cmdEventType\":\"PHYSICAL.NETWORK.UPDATE\",\"ctxUserId\":\"2\",\"state\":\"Enabled\",\"vlan\":\"3900-4000\",\"httpmethod\":\"GET\",\"ctxAccountId\":\"2\",\"ctxStartEventId\":\"35\",\"apiKey\":\"XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA\",\"signature\":\"G31JBnIAiHgEVJqVI27st0WfXC4\\u003d\"}',0,1,0,0,'org.apache.cloudstack.api.response.PhysicalNetworkResponse/physicalnetwork/{\"id\":\"443034f1-1c8c-4ebc-bdb0-d37329264651\",\"name\":\"eth0\",\"broadcastdomainrange\":\"ZONE\",\"zoneid\":\"aa661d8d-0abd-4494-92a5-aa91d2ed59eb\",\"state\":\"Enabled\",\"vlan\":\"3900-4000\"}',22061634278039,22061634278039,'2013-10-26 06:35:57','2013-10-26 06:35:57','2013-10-26 06:36:02',NULL,'d4a4cb1d-1272-4a3f-98c1-7dbb91f16d6a','b0d49e80-a6e0-4d22-aa35-f6c6f493d201',NULL,'ApiAsyncJobDispatcher',NULL,0);
/*!40000 ALTER TABLE `async_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `async_job_join_map`
--

DROP TABLE IF EXISTS `async_job_join_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `async_job_join_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `job_id` bigint(20) unsigned NOT NULL,
  `join_job_id` bigint(20) unsigned NOT NULL,
  `join_status` int(11) NOT NULL,
  `join_result` varchar(1024) DEFAULT NULL,
  `join_msid` bigint(20) DEFAULT NULL,
  `complete_msid` bigint(20) DEFAULT NULL,
  `sync_source_id` bigint(20) DEFAULT NULL COMMENT 'upper-level job sync source info before join',
  `wakeup_handler` varchar(64) DEFAULT NULL,
  `wakeup_dispatcher` varchar(64) DEFAULT NULL,
  `wakeup_interval` bigint(20) NOT NULL DEFAULT '3000' COMMENT 'wakeup interval in seconds',
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `next_wakeup` datetime DEFAULT NULL,
  `expiration` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `fk_async_job_join_map__join` (`job_id`,`join_job_id`),
  KEY `i_async_job_join_map__join_job_id` (`join_job_id`),
  KEY `i_async_job_join_map__created` (`created`),
  KEY `i_async_job_join_map__last_updated` (`last_updated`),
  KEY `i_async_job_join_map__next_wakeup` (`next_wakeup`),
  KEY `i_async_job_join_map__expiration` (`expiration`),
  CONSTRAINT `fk_async_job_join_map__job_id` FOREIGN KEY (`job_id`) REFERENCES `async_job` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_async_job_join_map__join_job_id` FOREIGN KEY (`join_job_id`) REFERENCES `async_job` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `async_job_join_map`
--

LOCK TABLES `async_job_join_map` WRITE;
/*!40000 ALTER TABLE `async_job_join_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `async_job_join_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `async_job_journal`
--

DROP TABLE IF EXISTS `async_job_journal`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `async_job_journal` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `job_id` bigint(20) unsigned NOT NULL,
  `journal_type` varchar(32) DEFAULT NULL,
  `journal_text` varchar(1024) DEFAULT NULL COMMENT 'journal descriptive informaton',
  `journal_obj` varchar(1024) DEFAULT NULL COMMENT 'journal strutural information, JSON encoded object',
  `created` datetime NOT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  KEY `fk_async_job_journal__job_id` (`job_id`),
  CONSTRAINT `fk_async_job_journal__job_id` FOREIGN KEY (`job_id`) REFERENCES `async_job` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `async_job_journal`
--

LOCK TABLES `async_job_journal` WRITE;
/*!40000 ALTER TABLE `async_job_journal` DISABLE KEYS */;
/*!40000 ALTER TABLE `async_job_journal` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `async_job_view`
--

DROP TABLE IF EXISTS `async_job_view`;
/*!50001 DROP VIEW IF EXISTS `async_job_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `async_job_view` (
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `user_id` tinyint NOT NULL,
  `user_uuid` tinyint NOT NULL,
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `job_cmd` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_process_status` tinyint NOT NULL,
  `job_result_code` tinyint NOT NULL,
  `job_result` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `instance_type` tinyint NOT NULL,
  `instance_id` tinyint NOT NULL,
  `instance_uuid` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `autoscale_policies`
--

DROP TABLE IF EXISTS `autoscale_policies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autoscale_policies` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `duration` int(10) unsigned NOT NULL,
  `quiet_time` int(10) unsigned NOT NULL,
  `action` varchar(15) DEFAULT NULL,
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_autoscale_policies__uuid` (`uuid`),
  KEY `fk_autoscale_policies__domain_id` (`domain_id`),
  KEY `fk_autoscale_policies__account_id` (`account_id`),
  KEY `i_autoscale_policies__removed` (`removed`),
  CONSTRAINT `fk_autoscale_policies__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_policies__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoscale_policies`
--

LOCK TABLES `autoscale_policies` WRITE;
/*!40000 ALTER TABLE `autoscale_policies` DISABLE KEYS */;
/*!40000 ALTER TABLE `autoscale_policies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autoscale_policy_condition_map`
--

DROP TABLE IF EXISTS `autoscale_policy_condition_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autoscale_policy_condition_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `policy_id` bigint(20) unsigned NOT NULL,
  `condition_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_autoscale_policy_condition_map__condition_id` (`condition_id`),
  KEY `i_autoscale_policy_condition_map__policy_id` (`policy_id`),
  CONSTRAINT `fk_autoscale_policy_condition_map__policy_id` FOREIGN KEY (`policy_id`) REFERENCES `autoscale_policies` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_policy_condition_map__condition_id` FOREIGN KEY (`condition_id`) REFERENCES `conditions` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoscale_policy_condition_map`
--

LOCK TABLES `autoscale_policy_condition_map` WRITE;
/*!40000 ALTER TABLE `autoscale_policy_condition_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `autoscale_policy_condition_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autoscale_vmgroup_policy_map`
--

DROP TABLE IF EXISTS `autoscale_vmgroup_policy_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autoscale_vmgroup_policy_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vmgroup_id` bigint(20) unsigned NOT NULL,
  `policy_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_autoscale_vmgroup_policy_map__policy_id` (`policy_id`),
  KEY `i_autoscale_vmgroup_policy_map__vmgroup_id` (`vmgroup_id`),
  CONSTRAINT `fk_autoscale_vmgroup_policy_map__vmgroup_id` FOREIGN KEY (`vmgroup_id`) REFERENCES `autoscale_vmgroups` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_vmgroup_policy_map__policy_id` FOREIGN KEY (`policy_id`) REFERENCES `autoscale_policies` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoscale_vmgroup_policy_map`
--

LOCK TABLES `autoscale_vmgroup_policy_map` WRITE;
/*!40000 ALTER TABLE `autoscale_vmgroup_policy_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `autoscale_vmgroup_policy_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autoscale_vmgroups`
--

DROP TABLE IF EXISTS `autoscale_vmgroups`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autoscale_vmgroups` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `zone_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `load_balancer_id` bigint(20) unsigned NOT NULL,
  `min_members` int(10) unsigned DEFAULT '1',
  `max_members` int(10) unsigned NOT NULL,
  `member_port` int(10) unsigned NOT NULL,
  `interval` int(10) unsigned NOT NULL,
  `profile_id` bigint(20) unsigned NOT NULL,
  `state` varchar(255) NOT NULL COMMENT 'enabled or disabled, a vmgroup is disabled to stop autoscaling activity',
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_autoscale_vmgroups__uuid` (`uuid`),
  KEY `fk_autoscale_vmgroup__autoscale_vmprofile_id` (`profile_id`),
  KEY `fk_autoscale_vmgroups__domain_id` (`domain_id`),
  KEY `fk_autoscale_vmgroups__account_id` (`account_id`),
  KEY `fk_autoscale_vmgroups__zone_id` (`zone_id`),
  KEY `i_autoscale_vmgroups__removed` (`removed`),
  KEY `i_autoscale_vmgroups__load_balancer_id` (`load_balancer_id`),
  CONSTRAINT `fk_autoscale_vmgroup__autoscale_vmprofile_id` FOREIGN KEY (`profile_id`) REFERENCES `autoscale_vmprofiles` (`id`),
  CONSTRAINT `fk_autoscale_vmgroup__load_balancer_id` FOREIGN KEY (`load_balancer_id`) REFERENCES `load_balancing_rules` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_vmgroups__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_vmgroups__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_vmgroups__zone_id` FOREIGN KEY (`zone_id`) REFERENCES `data_center` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoscale_vmgroups`
--

LOCK TABLES `autoscale_vmgroups` WRITE;
/*!40000 ALTER TABLE `autoscale_vmgroups` DISABLE KEYS */;
/*!40000 ALTER TABLE `autoscale_vmgroups` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `autoscale_vmprofiles`
--

DROP TABLE IF EXISTS `autoscale_vmprofiles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `autoscale_vmprofiles` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `zone_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `autoscale_user_id` bigint(20) unsigned NOT NULL,
  `service_offering_id` bigint(20) unsigned NOT NULL,
  `template_id` bigint(20) unsigned NOT NULL,
  `other_deploy_params` varchar(1024) DEFAULT NULL COMMENT 'other deployment parameters that is in addition to zoneid,serviceofferingid,domainid',
  `destroy_vm_grace_period` int(10) unsigned DEFAULT NULL COMMENT 'the time allowed for existing connections to get closed before a vm is destroyed',
  `counter_params` varchar(1024) DEFAULT NULL COMMENT 'the parameters for the counter to be used to get metric information from VMs',
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_autoscale_vmprofiles__uuid` (`uuid`),
  KEY `fk_autoscale_vmprofiles__domain_id` (`domain_id`),
  KEY `fk_autoscale_vmprofiles__account_id` (`account_id`),
  KEY `fk_autoscale_vmprofiles__autoscale_user_id` (`autoscale_user_id`),
  KEY `i_autoscale_vmprofiles__removed` (`removed`),
  CONSTRAINT `fk_autoscale_vmprofiles__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_vmprofiles__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_autoscale_vmprofiles__autoscale_user_id` FOREIGN KEY (`autoscale_user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autoscale_vmprofiles`
--

LOCK TABLES `autoscale_vmprofiles` WRITE;
/*!40000 ALTER TABLE `autoscale_vmprofiles` DISABLE KEYS */;
/*!40000 ALTER TABLE `autoscale_vmprofiles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baremetal_dhcp_devices`
--

DROP TABLE IF EXISTS `baremetal_dhcp_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baremetal_dhcp_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `nsp_id` bigint(20) unsigned DEFAULT NULL COMMENT 'Network Service Provider ID',
  `pod_id` bigint(20) unsigned DEFAULT NULL COMMENT 'Pod id where this dhcp server in',
  `device_type` varchar(255) DEFAULT NULL COMMENT 'type of the external device',
  `physical_network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'id of the physical network in to which external dhcp device is added',
  `host_id` bigint(20) unsigned DEFAULT NULL COMMENT 'host id coresponding to the external dhcp device',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_dhcp_devices_nsp_id` (`nsp_id`),
  KEY `fk_external_dhcp_devices_host_id` (`host_id`),
  KEY `fk_external_dhcp_devices_physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_external_dhcp_devices_physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_dhcp_devices_host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_dhcp_devices_nsp_id` FOREIGN KEY (`nsp_id`) REFERENCES `physical_network_service_providers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baremetal_dhcp_devices`
--

LOCK TABLES `baremetal_dhcp_devices` WRITE;
/*!40000 ALTER TABLE `baremetal_dhcp_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `baremetal_dhcp_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baremetal_pxe_devices`
--

DROP TABLE IF EXISTS `baremetal_pxe_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `baremetal_pxe_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `nsp_id` bigint(20) unsigned DEFAULT NULL COMMENT 'Network Service Provider ID',
  `pod_id` bigint(20) unsigned DEFAULT NULL COMMENT 'Pod id where this pxe server in, for pxe per zone this field is null',
  `device_type` varchar(255) DEFAULT NULL COMMENT 'type of the pxe device',
  `physical_network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'id of the physical network in to which external pxe device is added',
  `host_id` bigint(20) unsigned DEFAULT NULL COMMENT 'host id coresponding to the external pxe device',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_pxe_devices_nsp_id` (`nsp_id`),
  KEY `fk_external_pxe_devices_host_id` (`host_id`),
  KEY `fk_external_pxe_devices_physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_external_pxe_devices_physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_pxe_devices_host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_pxe_devices_nsp_id` FOREIGN KEY (`nsp_id`) REFERENCES `physical_network_service_providers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baremetal_pxe_devices`
--

LOCK TABLES `baremetal_pxe_devices` WRITE;
/*!40000 ALTER TABLE `baremetal_pxe_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `baremetal_pxe_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cluster`
--

DROP TABLE IF EXISTS `cluster`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cluster` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT 'name for the cluster',
  `uuid` varchar(40) DEFAULT NULL COMMENT 'uuid is different with following guid, while the later one is generated by hypervisor resource',
  `guid` varchar(255) DEFAULT NULL COMMENT 'guid for the cluster',
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod id',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center id',
  `hypervisor_type` varchar(32) DEFAULT NULL,
  `cluster_type` varchar(64) DEFAULT 'CloudManaged',
  `allocation_state` varchar(32) NOT NULL DEFAULT 'Enabled' COMMENT 'Is this cluster enabled for allocation for new resources',
  `managed_state` varchar(32) NOT NULL DEFAULT 'Managed' COMMENT 'Is this cluster managed by cloudstack',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `owner` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `lastUpdated` datetime DEFAULT NULL COMMENT 'last updated',
  `engine_state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'the engine state of the zone',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `guid` (`guid`),
  UNIQUE KEY `i_cluster__pod_id__name` (`pod_id`,`name`),
  UNIQUE KEY `uc_cluster__uuid` (`uuid`),
  KEY `fk_cluster__data_center_id` (`data_center_id`),
  KEY `i_cluster__allocation_state` (`allocation_state`),
  KEY `i_cluster__removed` (`removed`),
  CONSTRAINT `fk_cluster__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_cluster__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cluster`
--

LOCK TABLES `cluster` WRITE;
/*!40000 ALTER TABLE `cluster` DISABLE KEYS */;
INSERT INTO `cluster` VALUES (1,'testcluster','956242a3-bba4-4446-8a63-0a4bedd8993b','a8c2e08b-b0a3-cdd5-c827-3cad43ae5fff',1,1,'XenServer','CloudManaged','Enabled','Managed',NULL,NULL,NULL,NULL,'Disabled');
/*!40000 ALTER TABLE `cluster` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cluster_details`
--

DROP TABLE IF EXISTS `cluster_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cluster_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `cluster_id` bigint(20) unsigned NOT NULL COMMENT 'cluster id',
  `name` varchar(255) NOT NULL,
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cluster_details__cluster_id` (`cluster_id`),
  CONSTRAINT `fk_cluster_details__cluster_id` FOREIGN KEY (`cluster_id`) REFERENCES `cluster` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cluster_details`
--

LOCK TABLES `cluster_details` WRITE;
/*!40000 ALTER TABLE `cluster_details` DISABLE KEYS */;
INSERT INTO `cluster_details` VALUES (1,1,'memoryOvercommitRatio','1.0'),(2,1,'cpuOvercommitRatio','1.0');
/*!40000 ALTER TABLE `cluster_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cluster_vsm_map`
--

DROP TABLE IF EXISTS `cluster_vsm_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cluster_vsm_map` (
  `cluster_id` bigint(20) unsigned NOT NULL,
  `vsm_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`cluster_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cluster_vsm_map`
--

LOCK TABLES `cluster_vsm_map` WRITE;
/*!40000 ALTER TABLE `cluster_vsm_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `cluster_vsm_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cmd_exec_log`
--

DROP TABLE IF EXISTS `cmd_exec_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cmd_exec_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id of the system VM agent that command is sent to',
  `instance_id` bigint(20) unsigned NOT NULL COMMENT 'instance id of the system VM that command is executed on',
  `command_name` varchar(255) NOT NULL COMMENT 'command name',
  `weight` int(11) NOT NULL DEFAULT '1' COMMENT 'command weight in consideration of the load factor added to host that is executing the command',
  `created` datetime NOT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  KEY `i_cmd_exec_log__host_id` (`host_id`),
  KEY `i_cmd_exec_log__instance_id` (`instance_id`),
  CONSTRAINT `fk_cmd_exec_log_ref__inst_id` FOREIGN KEY (`instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cmd_exec_log`
--

LOCK TABLES `cmd_exec_log` WRITE;
/*!40000 ALTER TABLE `cmd_exec_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `cmd_exec_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `conditions`
--

DROP TABLE IF EXISTS `conditions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `conditions` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `counter_id` bigint(20) unsigned NOT NULL COMMENT 'Counter Id',
  `threshold` bigint(20) unsigned NOT NULL COMMENT 'threshold value for the given counter',
  `relational_operator` char(2) DEFAULT NULL COMMENT 'relational operator to be used upon the counter and condition',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain the Condition belongs to',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner of this Condition',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `created` datetime NOT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_conditions__uuid` (`uuid`),
  KEY `fk_conditions__counter_id` (`counter_id`),
  KEY `fk_conditions__account_id` (`account_id`),
  KEY `fk_conditions__domain_id` (`domain_id`),
  KEY `i_conditions__removed` (`removed`),
  CONSTRAINT `fk_conditions__counter_id` FOREIGN KEY (`counter_id`) REFERENCES `counter` (`id`),
  CONSTRAINT `fk_conditions__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_conditions__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `conditions`
--

LOCK TABLES `conditions` WRITE;
/*!40000 ALTER TABLE `conditions` DISABLE KEYS */;
/*!40000 ALTER TABLE `conditions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `configuration`
--

DROP TABLE IF EXISTS `configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `configuration` (
  `category` varchar(255) NOT NULL DEFAULT 'Advanced',
  `instance` varchar(255) NOT NULL,
  `component` varchar(255) NOT NULL DEFAULT 'management-server',
  `name` varchar(255) NOT NULL,
  `value` varchar(4095) DEFAULT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `default_value` varchar(4095) DEFAULT NULL COMMENT 'Default value for a configuration parameter',
  `updated` datetime DEFAULT NULL COMMENT 'Time this was updated by the server. null means this row is obsolete.',
  `scope` varchar(255) DEFAULT NULL COMMENT 'Can this parameter be scoped',
  `is_dynamic` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Can the parameter be change dynamically without restarting the server',
  PRIMARY KEY (`name`),
  KEY `i_configuration__instance` (`instance`),
  KEY `i_configuration__name` (`name`),
  KEY `i_configuration__category` (`category`),
  KEY `i_configuration__component` (`component`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `configuration`
--

LOCK TABLES `configuration` WRITE;
/*!40000 ALTER TABLE `configuration` DISABLE KEYS */;
INSERT INTO `configuration` VALUES ('Advanced','DEFAULT','management-server','account.cleanup.interval','86400','The interval (in seconds) between cleanup for removed accounts',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','agent.lb.enabled','false','Enable agent load balancing between management server nodes','false','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','management-server','agent.load.threshold','0.7','What percentage of the agents can be held by one management server before load balancing happens','0.7','2013-10-26 06:30:24',NULL,1),('Alert','DEFAULT','management-server','alert.email.addresses',NULL,'Comma separated list of email addresses used for sending alerts.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','alert.email.sender',NULL,'Sender of alert email (will be in the From header of the email).',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','alert.purge.delay','0','Alerts older than specified number days will be purged. Set this value to 0 to never delete alerts','0',NULL,NULL,0),('Advanced','DEFAULT','management-server','alert.purge.interval','86400','The interval (in seconds) to wait before running the alert purge thread','86400',NULL,NULL,0),('Alert','DEFAULT','management-server','alert.smtp.host',NULL,'SMTP hostname used for sending out email alerts.',NULL,NULL,NULL,0),('Secure','DEFAULT','management-server','alert.smtp.password',NULL,'Password for SMTP authentication (applies only if alert.smtp.useAuth is true).',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','alert.smtp.port','465','Port the SMTP server is listening on.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','alert.smtp.useAuth',NULL,'If true, use SMTP authentication when sending emails.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','alert.smtp.username',NULL,'Username for SMTP authentication (applies only if alert.smtp.useAuth is true).',NULL,NULL,NULL,0),('Advance','DEFAULT','AgentManager','alert.wait','1800','Seconds to wait before alerting on a disconnected agent','1800','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','TemplateManager','allow.public.user.templates','true','If false, users will not be able to create public templates.','true','2013-10-26 06:30:24','Account',1),('Advanced','DEFAULT','NetworkManager','allow.subdomain.network.access','true','Allow subdomains to use networks dedicated to their parent domain(s)',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','allow.user.create.projects','true','If regular user can create a project; true by default',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','api.throttling.cachesize','50000','Account based API count cache size','50000',NULL,NULL,0),('Advanced','DEFAULT','management-server','api.throttling.enabled','false','Enable/Disable Api rate limit','false',NULL,NULL,0),('Advanced','DEFAULT','management-server','api.throttling.interval','1','Time interval (in seconds) to reset API count','1',NULL,NULL,0),('Advanced','DEFAULT','management-server','api.throttling.max','25','Max allowed number of APIs within fixed interval','25',NULL,NULL,0),('Advanced','DEFAULT','management-server','apply.allocation.algorithm.to.pods','false','If true, deployment planner applies the allocation heuristics at pods first in the given datacenter during VM resource allocation',NULL,NULL,NULL,0),('Storage','DEFAULT','StorageManager','backup.snapshot.wait','21600','In second, timeout for BackupSnapshotCommand',NULL,NULL,NULL,0),('Advanced','DEFAULT','VpcManager','blacklisted.routes',NULL,'Routes that are blacklisted, can not be used for Static Routes creation for the VPC Private Gateway',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','capacity.check.period','300000','The interval in milliseconds between capacity checks',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','capacity.skipcounting.hours','3600','Time (in seconds) to wait before release VM\'s cpu and memory when VM in stopped state',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','check.pod.cidrs','true','If true, different pods must belong to different CIDR subnets.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','cloud.dns.name',NULL,'DNS name of the cloud for the GSLB service',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','cloud.identifier','9c01dd3e-c869-424d-8766-2ed1f95b424f','A unique identifier for the cloud.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','cluster.cpu.allocated.capacity.disablethreshold','0.85','Percentage (as a value between 0 and 1) of cpu utilization above which allocators will disable using the cluster for low cpu available. Keep the corresponding notification threshold lower than this to be notified beforehand.',NULL,NULL,NULL,0),('Alert','DEFAULT','AlertManager','cluster.cpu.allocated.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of cpu utilization above which alerts will be sent about low cpu available.','0.75','2013-10-26 06:30:24','Cluster',1),('management-server','DEFAULT','ClusterManager','cluster.heartbeat.interval','1500','Interval to check for the heart beat between management server nodes','1500','2013-10-26 06:30:24','Global',0),('management-server','DEFAULT','ClusterManager','cluster.heartbeat.threshold','150000','Threshold before self-fence the management server','150000','2013-10-26 06:30:24','Global',1),('Alert','DEFAULT','management-server','cluster.localStorage.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of local storage utilization above which alerts will be sent about low local storage available.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','cluster.memory.allocated.capacity.disablethreshold','0.85','Percentage (as a value between 0 and 1) of memory utilization above which allocators will disable using the cluster for low memory available. Keep the corresponding notification threshold lower than this to be notified beforehand.',NULL,NULL,NULL,0),('Alert','DEFAULT','AlertManager','cluster.memory.allocated.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of memory utilization above which alerts will be sent about low memory available.','0.75','2013-10-26 06:30:24','Cluster',1),('Advanced','DEFAULT','management-server','cluster.message.timeout.seconds','300','Time (in seconds) to wait before a inter-management server message post times out.',NULL,NULL,NULL,0),('Alert','DEFAULT','AlertManager','cluster.storage.allocated.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of allocated storage utilization above which alerts will be sent about low storage available.','0.75','2013-10-26 06:30:24','Cluster',1),('Alert','DEFAULT','AlertManager','cluster.storage.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of storage utilization above which alerts will be sent about low storage available.','0.75','2013-10-26 06:30:24','Cluster',1),('Advanced','DEFAULT','management-server','concurrent.snapshots.threshold.perhost',NULL,'Limit number of snapshots that can be handled concurrently; default is NULL - unlimited.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','console.cpu.mhz','100',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','console.ram.size','100',NULL,NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.capacity.standby','10','The minimal number of console proxy viewer sessions that system is able to serve immediately(standby capacity)',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.capacityscan.interval','30000','The time interval(in millisecond) to scan whether or not system needs more console proxy to ensure minimal standby capacity',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.cmd.port','8001','Console proxy command port that is used to communicate with management server',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.disable.rpfilter','true','disable rp_filter on console proxy VM public interface',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.launch.max','10','maximum number of console proxy instances per zone can be launched',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.loadscan.interval','10000','The time interval(in milliseconds) to scan console proxy working-load info',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.management.state','Auto','console proxy service management state',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.management.state.last','Auto','last console proxy service management state',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.restart','true','Console proxy restart flag, defaulted to true',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','consoleproxy.service.offering',NULL,'Uuid of the service offering used by console proxy; if NULL - system offering will be used',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.session.max','50','The max number of viewer sessions console proxy is configured to serve for',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.session.timeout','300000','Timeout(in milliseconds) that console proxy tries to maintain a viewer session before it times out the session for no activity',NULL,NULL,NULL,0),('Console Proxy','DEFAULT','AgentManager','consoleproxy.url.domain','realhostip.com','Console proxy url domain',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','control.cidr','169.254.0.0/16','Changes the cidr for the control network traffic.  Defaults to using link local.  Must be unique within pods',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','control.gateway','169.254.0.1','gateway for the control network traffic',NULL,NULL,NULL,0),('Storage','DEFAULT','StorageManager','copy.volume.wait','10800','In second, timeout for copy volume command',NULL,NULL,NULL,0),('Advanced','DEFAULT','CapacityManager','cpu.overprovisioning.factor','1.0','Used for CPU overprovisioning calculation; available CPU will be (actualCpuCapacity * cpu.overprovisioning.factor)','1.0','2013-10-26 06:30:24','Cluster',1),('Storage','DEFAULT','UserVmManager','create.private.template.from.snapshot.wait','10800','In second, timeout for CreatePrivateTemplateFromSnapshotCommand',NULL,NULL,NULL,0),('Storage','DEFAULT','UserVmManager','create.private.template.from.volume.wait','10800','In second, timeout for CreatePrivateTemplateFromVolumeCommand',NULL,NULL,NULL,0),('Storage','DEFAULT','StorageManager','create.volume.from.snapshot.wait','10800','In second, timeout for creating volume from snapshot',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','custom.diskoffering.size.max','1024','Maximum size in GB for custom disk offering',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','custom.diskoffering.size.min','1','Minimum size in GB for custom disk offering',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','default.page.size','500','Default page size for API list* commands',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','detail.batch.query.size','2000','Default entity detail batch query size for listing','2000',NULL,NULL,0),('Advanced','DEFAULT','management-server','developer','true',NULL,'true',NULL,NULL,0),('Advance','DEFAULT','AgentManager','direct.agent.load.size','16','How many agents to connect to in each round','16','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','management-server','direct.agent.pool.size','500','Default size for DirectAgentPool','500',NULL,NULL,0),('Advanced','DEFAULT','management-server','direct.agent.scan.interval','90','Interval between scans to load agents','90','2013-10-26 06:30:24',NULL,0),('Advanced','DEFAULT','management-server','direct.attach.network.externalIpAllocator.enabled','false','Direct-attach VMs using external DHCP server',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','direct.attach.network.externalIpAllocator.url',NULL,'Direct-attach VMs using external DHCP server (API url)',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','direct.network.no.default.route','false','Direct Network Dhcp Server should not send a default route',NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','direct.network.stats.interval','86400','Interval (in seconds) to collect stats from Traffic Monitor',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','disable.extraction','false','Flag for disabling extraction of template, isos and volumes',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','eip.use.multiple.netscalers','false','Should be set to true, if there will be multiple NetScaler devices providing EIP service in a zone','false',NULL,NULL,0),('Advanced','DEFAULT','management-server','enable.baremetal.securitygroup.agent.echo','false','After starting provision process, periodcially echo security agent installed in the template. Treat provisioning as success only if echo successfully','false',NULL,NULL,0),('Advanced','DEFAULT','management-server','enable.dynamic.scale.vm','false','Enables/Diables dynamically scaling a vm','false','2013-10-26 06:30:24',NULL,1),('Advanced','DEFAULT','management-server','enable.ec2.api','true',NULL,NULL,NULL,NULL,0),('Storage','DEFAULT','management-server','enable.ha.storage.migration','true','Enable/disable storage migration across primary storage during HA','true','2013-10-26 06:30:24',NULL,1),('Advanced','DEFAULT','management-server','enable.s3.api','true',NULL,NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','enable.usage.server','true','Flag for enabling usage',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','encode.api.response','false','Do URL encoding for the api response, false by default',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','endpointe.url','http://localhost:8080/client/api','Endpointe Url',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','event.purge.delay','15','Events older than specified number days will be purged. Set this value to 0 to never delete events',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','event.purge.interval','86400','The interval (in seconds) to wait before running the event purge thread',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','execute.in.sequence.hypervisor.commands','false','If set to true, StartCommand, StopCommand, CopyCommand will be synchronized on the agent side. If set to false, these commands become asynchronous. Default value is false.','false',NULL,NULL,0),('Advanced','DEFAULT','management-server','execute.in.sequence.network.element.commands','false','If set to true, DhcpEntryCommand, SavePasswordCommand, UserDataCommand, VmDataCommand will be synchronized on the agent side. If set to false, these commands become asynchronous. Default value is false.','false',NULL,NULL,0),('Advanced','DEFAULT','management-server','expunge.delay','60',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','expunge.interval','60',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','expunge.workers','3',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','external.baremetal.resource.classname',NULL,'class name for handling external baremetal resource',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','external.baremetal.system.url',NULL,'url of external baremetal system that CloudStack will talk to',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','external.firewall.default.capacity','50','default number of networks permitted per external load firewall device',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','external.lb.default.capacity','50','default number of networks permitted per external load balancer device',NULL,NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','external.network.stats.interval','300','Interval (in seconds) to report external network statistics.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','extract.url.cleanup.interval','7200','The interval (in seconds) to wait before cleaning up the extract URL\'s ',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','extract.url.expiration.interval','14400','The life of an extract URL after which it is deleted ',NULL,NULL,NULL,0),('Network','DEFAULT','NetworkOrchestrationService','guest.domain.suffix','cloud.internal','Default domain name for vms inside virtualized networks fronted by router','cloud.internal','2013-10-26 06:30:24','Zone',1),('Network','DEFAULT','management-server','guest.vlan.bits','12','The number of bits to reserve for the VLAN identifier in the guest subnet.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ha.tag',NULL,'HA tag defining that the host marked with this tag can be used for HA purposes only',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','ha.workers','5','Number of ha worker threads.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','healthcheck.update.interval','600','Time Interval to fetch the LB health check states (in sec)','600',NULL,NULL,0),('Advanced','DEFAULT','ClusterManager','host','localhost','The ip address of management server','localhost','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','management-server','host.capacityType.to.order.clusters','CPU','The host capacity type (CPU or RAM) is used by deployment planner to order clusters during VM resource allocation',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','host.reservation.release.period','300000','The interval in milliseconds between host reservation release checks','300000',NULL,NULL,0),('Advanced','DEFAULT','AgentManager','host.retry','2','Number of times to retry hosts for creating a volume',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','host.stats.interval','60000','The interval (in milliseconds) when host stats are retrieved from agents.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','hypervisor.list','Hyperv,KVM,XenServer,VMware,BareMetal,Ovm,LXC','The list of hypervisors that this deployment will use.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','incorrect.login.attempts.allowed','5','Incorrect login attempts allowed before the user is disabled',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','init','true',NULL,'false',NULL,NULL,0),('Advanced','DEFAULT','AgentManager','instance.name','VM','Name of the deployment instance.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','integration.api.port','8096',NULL,'8096',NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','internallbvm.service.offering',NULL,'Uuid of the service offering used by internal lb vm; if NULL - default system internal lb offering will be used',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','interval.baremetal.securitygroup.agent.echo','10','Interval to echo baremetal security group agent, in seconds','10',NULL,NULL,0),('Advanced','DEFAULT','HighAvailabilityManager','investigate.retry.interval','60','Time (in seconds) between VM pings when agent is disconnected',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','job.cancel.threshold.minutes','60','Time (in minutes) for async-jobs to be forcely cancelled if it has been in process for long','60','2013-10-26 06:30:24',NULL,1),('Advanced','DEFAULT','management-server','job.expire.minutes','1440','Time (in minutes) for async-jobs to be kept in system','1440','2013-10-26 06:30:24',NULL,1),('Advanced','DEFAULT','management-server','json.content.type','text/javascript','Http response content type for .js files (default is text/javascript)',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','kvm.guest.network.device',NULL,'Specify the private bridge on host for private network',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','kvm.private.network.device',NULL,'Specify the private bridge on host for private network',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','kvm.public.network.device',NULL,'Specify the public bridge on host for public network',NULL,NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','kvm.snapshot.enabled','false','whether snapshot is enabled for KVM hosts','false',NULL,NULL,0),('Advanced','DEFAULT','management-server','kvm.ssh.to.agent','true','Specify whether or not the management server is allowed to SSH into KVM Agents','true',NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.basedn',NULL,'Sets the basedn for LDAP',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.bind.password',NULL,'Specifies the password to use for binding to LDAP',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.bind.principal',NULL,'Specifies the bind principal to use for bind to LDAP',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.email.attribute','mail','Sets the email attribute used within LDAP','mail',NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.firstname.attribute','givenname','Sets the firstname attribute used within LDAP','givenname',NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.lastname.attribute','sn','Sets the lastname attribute used within LDAP','sn',NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.search.group.principle',NULL,'Sets the principle of the group that users must be a member of',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.truststore',NULL,'Sets the path to the truststore to use for LDAP SSL',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.truststore.password',NULL,'Sets the password for the truststore',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.user.object','inetOrgPerson','Sets the object type of users within LDAP','inetOrgPerson',NULL,NULL,0),('Advanced','DEFAULT','management-server','ldap.username.attribute','uid','Sets the username attribute used within LDAP','uid',NULL,NULL,0),('Advanced','DEFAULT','management-server','linkLocalIp.nums','10','The number of link local ip that needed by domR(in power of 2)',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','management.network.cidr','192.168.3.0/24','The cidr of management server network',NULL,NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.cpus','40','The default maximum number of cpu cores that can be used for an account','40',NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.memory','40960','The default maximum memory (in MiB) that can be used for an account','40960',NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.networks','20','The default maximum number of networks that can be created for an account',NULL,NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.primary.storage','200','The default maximum primary storage space (in GiB) that can be used for an account','200',NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.public.ips','20','The default maximum number of public IPs that can be consumed by an account',NULL,NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.secondary.storage','400','The default maximum secondary storage space (in GiB) that can be used for an account','400',NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.snapshots','20','The default maximum number of snapshots that can be created for an account',NULL,NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.templates','20','The default maximum number of templates that can be deployed for an account',NULL,NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.user.vms','20','The default maximum number of user VMs that can be deployed for an account',NULL,NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.volumes','20','The default maximum number of volumes that can be created for an account',NULL,NULL,NULL,0),('Account Defaults','DEFAULT','management-server','max.account.vpcs','20','The default maximum number of vpcs that can be created for an account',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.cpus','40','The default maximum number of cpu cores that can be used for a project','40',NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.memory','40960','The default maximum memory (in MiB) that can be used for a project','40960',NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.networks','20','The default maximum number of networks that can be created for a project',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.primary.storage','200','The default maximum primary storage space (in GiB) that can be used for a project','200',NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.public.ips','20','The default maximum number of public IPs that can be consumed by a project',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.secondary.storage','400','The default maximum secondary storage space (in GiB) that can be used for a project','400',NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.snapshots','20','The default maximum number of snapshots that can be created for a project',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.templates','20','The default maximum number of templates that can be deployed for a project',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.user.vms','20','The default maximum number of user VMs that can be deployed for a project',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.volumes','20','The default maximum number of volumes that can be created for a project',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','max.project.vpcs','20','The default maximum number of vpcs that can be created for a project',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','max.template.iso.size','50','The maximum size for a downloaded template or ISO (in GB).',NULL,NULL,NULL,0),('Advanced','DEFAULT','CapacityManager','mem.overprovisioning.factor','1.0','Used for memory overprovisioning calculation','1.0','2013-10-26 06:30:24','Cluster',1),('Network','DEFAULT','management-server','midonet.apiserver.address','http://localhost:8081','Specify the address at which the Midonet API server can be contacted (if using Midonet)','http://localhost:8081',NULL,NULL,0),('Network','DEFAULT','management-server','midonet.providerrouter.id','d7c5e6a3-e2f4-426b-b728-b7ce6a0448e5','Specifies the UUID of the Midonet provider router (if using Midonet)','d7c5e6a3-e2f4-426b-b728-b7ce6a0448e5',NULL,NULL,0),('Advanced','DEFAULT','HighAvailabilityManager','migrate.retry.interval','120','Time (in seconds) between migration retries',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','migratewait','3600','Time (in seconds) to wait for VM migrate finish',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','mount.parent','/mnt','The mount point on the Management Server for Secondary Storage.',NULL,NULL,NULL,0),('Network','DEFAULT','NetworkManager','network.dhcp.nondefaultnetwork.setgateway.guestos','Windows','The guest OS\'s name start with this fields would result in DHCP server response gateway information even when the network it\'s on is not default network. Names are separated by comma.','Windows',NULL,NULL,0),('Network','DEFAULT','management-server','network.disable.rpfilter','true','disable rp_filter on Domain Router VM public interfaces.',NULL,NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','network.dns.basiczone.updates','all','This parameter can take 2 values: all (default) and pod. It defines if DHCP/DNS requests have to be send to all dhcp servers in cloudstack, or only to the one in the same pod',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','network.gc.interval','600','Seconds to wait before checking for networks to shutdown','600','2013-10-26 06:30:24',NULL,1),('Advanced','DEFAULT','management-server','network.gc.wait','600','Time (in seconds) to wait before shutting down a network that\'s not in used','600','2013-10-26 06:30:24',NULL,0),('Network','DEFAULT','NetworkManager','network.guest.cidr.limit','22','size limit for guest cidr; can\'t be less than this value',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.ipv6.search.retry.max','10000','The maximum number of retrying times to search for an available IPv6 address in the table','10000',NULL,NULL,0),('Advanced','DEFAULT','management-server','network.loadbalancer.basiczone.elb.enabled','false','Whether the load balancing service is enabled for basic zones',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','network.loadbalancer.basiczone.elb.gc.interval.minutes','30','Garbage collection interval to destroy unused ELB vms in minutes. Minimum of 5',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','network.loadbalancer.basiczone.elb.network','guest','Whether the elastic load balancing service public ips are taken from the public or guest network',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','network.loadbalancer.basiczone.elb.vm.cpu.mhz','128','CPU speed for the elastic load balancer vm',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','network.loadbalancer.basiczone.elb.vm.ram.size','128','Memory in MB for the elastic load balancer vm',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','network.loadbalancer.basiczone.elb.vm.vcpu.num','1','Number of VCPU  for the elastic load balancer vm',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.loadbalancer.haproxy.max.conn','4096','Load Balancer(haproxy) maximum number of concurrent connections(global max)','4096',NULL,NULL,0),('Secure','DEFAULT','management-server','network.loadbalancer.haproxy.stats.auth','admin1:AdMiN123','Load Balancer(haproxy) authetication string in the format username:password',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.loadbalancer.haproxy.stats.port','8081','Load Balancer(haproxy) stats port number.',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.loadbalancer.haproxy.stats.uri','/admin?stats','Load Balancer(haproxy) uri.',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.loadbalancer.haproxy.stats.visibility','global','Load Balancer(haproxy) stats visibilty, the value can be one of the following six parameters : global,guest-network,link-local,disabled,all,default',NULL,NULL,NULL,0),('Network','DEFAULT','NetworkOrchestrationService','network.lock.timeout','600','Lock wait timeout (seconds) while implementing network','600','2013-10-26 06:30:24','Global',1),('Network','DEFAULT','management-server','network.securitygroups.defaultadding','true','If true, the user VM would be added to the default security group by default',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.securitygroups.work.cleanup.interval','120','Time interval (seconds) in which finished work is cleaned up from the work table',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.securitygroups.work.lock.timeout','300','Lock wait timeout (seconds) while updating the security group work queue',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.securitygroups.work.per.agent.queue.size','100','The number of outstanding security group work items that can be queued to a host. If exceeded, work items will get dropped to conserve memory. Security Group Sync will take care of ensuring that the host gets updated eventually',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','network.securitygroups.workers.pool.size','50','Number of worker threads processing the security group update work queue',NULL,NULL,NULL,0),('Network','DEFAULT','NetworkOrchestrationService','network.throttling.rate','200','Default data transfer rate in megabits per second allowed in network.','200','2013-10-26 06:30:24','Zone',1),('Hidden','DEFAULT','management-server','ovm.guest.network.device',NULL,'Specify the private bridge on host for private network',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','ovm.private.network.device',NULL,'Specify the private bridge on host for private network',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','ovm.public.network.device',NULL,'Specify the public bridge on host for public network',NULL,NULL,NULL,0),('Advance','DEFAULT','AgentManager','ping.interval','60','Interval to send application level pings to make sure the connection is still working','60','2013-10-26 06:30:24','Global',0),('Advance','DEFAULT','AgentManager','ping.timeout','2.5','Multiplier to ping.interval before announcing an agent has timed out','2.5','2013-10-26 06:30:24','Global',1),('Alert','DEFAULT','management-server','pod.privateip.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of private IP address space utilization above which alerts will be sent.',NULL,NULL,NULL,0),('Advance','DEFAULT','AgentManager','port','8250','Port to listen on for remote agent connections.','8250','2013-10-26 06:30:24','Global',0),('Storage','DEFAULT','TemplateManager','primary.storage.download.wait','10800','In second, timeout for download template to primary storage',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','project.email.sender',NULL,'Sender of project invitation email (will be in the From header of the email)',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','project.invite.required','false','If invitation confirmation is required when add account to project. Default value is false',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','project.invite.timeout','86400','Invitation expiration time (in seconds). Default is 1 day - 86400 seconds',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','project.smtp.host',NULL,'SMTP hostname used for sending out email project invitations',NULL,NULL,NULL,0),('Secure','DEFAULT','management-server','project.smtp.password',NULL,'Password for SMTP authentication (applies only if project.smtp.useAuth is true)',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','project.smtp.port','465','Port the SMTP server is listening on',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','project.smtp.useAuth',NULL,'If true, use SMTP authentication when sending emails',NULL,NULL,NULL,0),('Project Defaults','DEFAULT','management-server','project.smtp.username',NULL,'Username for SMTP authentication (applies only if project.smtp.useAuth is true)',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','recreate.systemvm.enabled','false','If true, will recreate system vm root disk whenever starting system vm','false','2013-10-26 06:30:24',NULL,1),('Network','DEFAULT','RemoteAccessVpnService','remote.access.vpn.client.iprange','10.1.2.1-10.1.2.8','The range of ips to be allocated to remote access vpn clients. The first ip in the range is used by the VPN server','10.1.2.1-10.1.2.8','2013-10-26 06:30:24','Account',0),('Network','DEFAULT','AgentManager','remote.access.vpn.psk.length','24','The length of the ipsec preshared key (minimum 8, maximum 256)',NULL,NULL,NULL,0),('Network','DEFAULT','AgentManager','remote.access.vpn.user.limit','8','The maximum number of VPN users that can be created per account',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','resourcecount.check.interval','0','Time (in seconds) to wait before retrying resource count check task. Default is 0 which is to never run the task',NULL,NULL,NULL,0),('Advanced','DEFAULT','HighAvailabilityManager','restart.retry.interval','600','Time (in seconds) between retries to restart a vm',NULL,NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.check.interval','30','Interval (in seconds) to report redundant router status.',NULL,NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.check.poolsize','10','Numbers of threads using to check redundant router status.','10',NULL,NULL,0),('Advanced','DEFAULT','management-server','router.cpu.mhz','100',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.extra.public.nics','2','specify extra public nics used for virtual router(up to 5)',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','router.ram.size','100',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.stats.interval','300','Interval (in seconds) to report router statistics.',NULL,NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.template.hyperv','SystemVM Template (HyperV)','Name of the default router template on Hyperv.','SystemVM Template (HyperV)',NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.template.kvm','SystemVM Template (KVM)','Name of the default router template on KVM.','SystemVM Template (KVM)',NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.template.lxc','SystemVM Template (LXC)','Name of the default router template on LXC.','SystemVM Template (LXC)',NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.template.vmware','SystemVM Template (vSphere)','Name of the default router template on Vmware.','SystemVM Template (vSphere)',NULL,NULL,0),('Advanced','DEFAULT','NetworkManager','router.template.xen','SystemVM Template (XenServer)','Name of the default router template on Xenserver.','SystemVM Template (XenServer)',NULL,NULL,0),('Advanced','DEFAULT','management-server','s3.rrs.enabled','false','enable s3 reduced redundancy storage','false',NULL,NULL,0),('Advanced','DEFAULT','management-server','s3.singleupload.max.size','5','The maximum size limit for S3 single part upload API(in GB). If it is set to 0, then it means always use multi-part upload to upload object to S3. If it is set to -1, then it means always use single-part upload to upload object to S3.','5',NULL,NULL,0),('Advanced','DEFAULT','management-server','scale.retry','2','Number of times to retry scaling up the vm','2',NULL,NULL,0),('Network','DEFAULT','management-server','sdn.ovs.controller','false','Enable/Disable Open vSwitch SDN controller for L2-in-L3 overlay networks',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','sdn.ovs.controller.default.label','cloud-public','Default network label to be used when fetching interface for GRE endpoints',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','secondary.storage.vm','true','Deploys a VM per zone to manage secondary storage if true, otherwise secondary storage is mounted on management server',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','secstorage.allowed.internal.sites',NULL,'Comma separated list of cidrs internal to the datacenter that can host template download servers, please note 0.0.0.0 is not a valid site',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','secstorage.capacity.standby','10','The minimal number of command execution sessions that system is able to serve immediately(standby capacity)',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','secstorage.cmd.execution.time.max','30','The max command execution time in minute',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','secstorage.copy.password','bU5ycabbskyteae','Password used to authenticate zone-to-zone template copy requests',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','secstorage.encrypt.copy','true','Use SSL method used to encrypt copy traffic between zones',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','secstorage.proxy',NULL,'http proxy used by ssvm, in http://username:password@proxyserver:port format',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','secstorage.service.offering',NULL,'Service offering used by secondary storage; if NULL - system offering will be used',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','secstorage.session.max','50','The max number of command execution sessions that a SSVM can handle',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','secstorage.ssl.cert.domain','realhostip.com','SSL certificate used to encrypt copy traffic between zones',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','secstorage.vm.mtu.size','1500','MTU size (in Byte) of storage network in secondary storage vms',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','security.encryption.iv',NULL,'base64 encoded IV data',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','security.encryption.key',NULL,'base64 encoded key data',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','security.hash.key',NULL,'for generic key-ed hash',NULL,NULL,NULL,0),('Secure','DEFAULT','management-server','security.singlesignon.key','O08iny0e2ExxZgrD690HyyJMKRD__Rkksmebvoz18tnES3H-sTb3-ZLY6bSjOF1MlpQMEfHSYmb8VOdNddrfJw','A Single Sign-On key used for logging into the cloud',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','security.singlesignon.tolerance.millis','300000','The allowable clock difference in milliseconds between when an SSO login request is made and when it is received.',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','site2site.vpn.customergateway.subnets.limit','10','The maximum number of subnets per customer gateway',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','site2site.vpn.vpngateway.connection.limit','4','The maximum number of VPN connection per VPN gateway',NULL,NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','snapshot.backup.rightafter','true','backup snapshot right after snapshot is taken','true',NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','snapshot.delta.max','16','max delta snapshots between two full snapshots.',NULL,NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','snapshot.max.daily','8','Maximum daily snapshots for a volume',NULL,NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','snapshot.max.hourly','8','Maximum hourly snapshots for a volume',NULL,NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','snapshot.max.monthly','8','Maximum monthly snapshots for a volume',NULL,NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','snapshot.max.weekly','8','Maximum weekly snapshots for a volume',NULL,NULL,NULL,0),('Snapshots','DEFAULT','SnapshotManager','snapshot.poll.interval','300','The time interval in seconds when the management server polls for snapshots to be scheduled.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','sortkey.algorithm','false','Sort algorithm for those who use sort key(template, disk offering, service offering, network offering), true means ascending sort while false means descending sort',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','ssh.privatekey','-----BEGIN RSA PRIVATE KEY-----\nMIIEpAIBAAKCAQEArMUMqJDAYgMtl3UuXbleQh6DpeiKPoyyukB0BjrHZcg+EqMM\nNZ8LoJIdeMFMIMgKPJIA/BNpLWLSlTJbm+TMXxzujfg0pQdE8efJxR+DJTHf22D7\ndCjcI/6aDVxhQ7MuPoVrWHoRptsetygM2HQJ8qG5PiH17C732eBUwHQb3Nsu6wmx\nUeSEdenzzUXLhixHgLM080ywY3XEkTYjYdDjpyOXRUqGU+Gs1wKHb5CEy7tF0VxR\nNofiOqWwBfaQQiZWwRdtc2eWlpXsBV4ZZckr92T+oOU+gRvBqc8rPPQxdPWcQFFM\natepxzV4NnCkp6KvhByEq0x2Wdr8Mw7uKfFGzQIDAQABAoIBAGA0wh3DrT1m46Zp\nXE5YgMJ01341hXXbR1MrvPATHyHwZZBfNtdNH15kvwCVMt02R2z/KIk2DeV2GCl4\nh0bCG4QDSlvIERiseZnzJoocSB0YLr2svZkrf5qTlhlGjerzBhdOmD4Gi3nMnsgD\nB1QpGbkAkXSl2JmSdfXfU5JvlWxfvhVX58ETxuwOQvTqabmIKOM3g4JIm3Ml4k7x\nl6cEwaGywV6GLsvdpX4C4JUxNap8RM2IrlZnqsx3oabujY5LDZ1fXH6MfljNsU0Z\ne8jGBngRCy2AjlHUb02r2vniylEUVXSL7dyGKhBBmcYH7q9Go7SurFmylORR4S2U\nAl44/wECgYEA5djTDBpheYAR/YNAVg3jfGaKck3ZqAnpCjIBb/CdI/zuJRKIYibR\nmZo49jQuxoIyi+AB/y5FOkukev8VeroJPzcQ0z/HeIFcJc0drtkPp9i/drCjouPT\nnVCYvnKehot+ICBk+Ycu/u7XS8O407VFn7QVxABaaZQMIZvBVefqIO0CgYEAwG2h\njtxSdTyLhWlzyLHHZPv+F0ZehedBIDGU+4zzNR5NRmqn5YFHrerWWB3WMqbYmjkX\nHnrBuoWjfOWnzCLpwgZvMdlvgyhnbRyNLjhdiuxo3zMNtpc+Zb19IU/4HbtjfSDw\nBlcNkJtQHZt2XNQUAJErr4G/bTTgMrckZ2elYWECgYEAxkzhGIoSGt9RpiT89sGY\nyJU3URK1fHLAahlmgAtZp9jqJXXt0LCpGRqjllbDHGTr8x3a2ywyce8dAzjccTvc\nCnwZughGskL5G2vx9g4zoZ4w4dfX9gsVYZ5NidIdzvq+YD1SoK3u7+dkPGuqJI06\nemTGeonLd1dReBWHIfSqXKkCgYAWAPNGaL8tFL1HhiVtP5bzXzVQ6AUK/sSdr82/\nbgCphEuFz9BfGAdgRcg4z0CdDiMaj4irPZJFh96H+6LSXvOn8iBo7Nopf0dEXM1w\nCZX4usvLKgVZabYC4EYctw5CKBlaR5fqwa2VaY0htZM1TjLzVaZPLWD8Vd2FLxgE\nkv+AQQKBgQCCSWo+lIv/IH+j0Uz8hJ2VUsCA9dxsUM3kZOi3Y+u6nTD6ZC1QYweB\nkDv2A9TURfWBdmr5QSYIvd0I7oOjOD3iS6uJ6JGgKPm5xg8vSgWrwGnNJZz3i606\nG9ldTQTGXOaTKllbfwHgWJB9FcxD5kvHCapVvAP2vBpJhRPS+QJ1Dg==\n-----END RSA PRIVATE KEY-----','Private key for the entire CloudStack',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','ssh.publickey','ssh-rsa AAAAB3NzaC1yc2EAAAADAQABAAABAQCsxQyokMBiAy2XdS5duV5CHoOl6Io+jLK6QHQGOsdlyD4Soww1nwugkh14wUwgyAo8kgD8E2ktYtKVMlub5MxfHO6N+DSlB0Tx58nFH4MlMd/bYPt0KNwj/poNXGFDsy4+hWtYehGm2x63KAzYdAnyobk+IfXsLvfZ4FTAdBvc2y7rCbFR5IR16fPNRcuGLEeAszTzTLBjdcSRNiNh0OOnI5dFSoZT4azXAodvkITLu0XRXFE2h+I6pbAF9pBCJlbBF21zZ5aWlewFXhllySv3ZP6g5T6BG8Gpzys89DF09ZxAUUxq16nHNXg2cKSnoq+EHISrTHZZ2vwzDu4p8UbN darren@mymbp','Public key for the entire CloudStack',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ssvm.cpu.mhz','100',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','ssvm.ram.size','100',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','VirtualMachineManager','start.retry','10','Number of times to retry create and start commands','10','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','HighAvailabilityManager','stop.retry.interval','600','Time in seconds between retries to stop or destroy a vm',NULL,NULL,NULL,0),('Storage','DEFAULT','management-server','storage.cache.replacement.enabled','true','enable or disable cache storage replacement algorithm.','true',NULL,NULL,0),('Storage','DEFAULT','management-server','storage.cache.replacement.interval','86400','time interval between cache replacement threads (in seconds).','86400',NULL,NULL,0),('Storage','DEFAULT','management-server','storage.cache.replacement.lru.interval','30','time interval for unused data on cache storage (in days).','30',NULL,NULL,0),('Advanced','DEFAULT','StorageManager','storage.cleanup.enabled','true','Enables/disables the storage cleanup thread.',NULL,NULL,NULL,0),('Advanced','DEFAULT','StorageManager','storage.cleanup.interval','86400','The interval (in seconds) to wait before running the storage cleanup thread.',NULL,NULL,NULL,0),('Storage','DEFAULT','management-server','storage.max.volume.size','2000','The maximum size for a volume (in GB).','2000','2013-10-26 06:30:24',NULL,1),('Storage','DEFAULT','management-server','storage.max.volume.upload.size','500','The maximum size for a uploaded volume(in GB).',NULL,NULL,NULL,0),('Storage','DEFAULT','management-server','storage.pool.max.waitseconds','3600','Timeout (in seconds) to synchronize storage pool operations.',NULL,NULL,NULL,0),('Storage','DEFAULT','management-server','storage.stats.interval','60000','The interval (in milliseconds) when storage stats (per host) are retrieved from agents.',NULL,NULL,NULL,0),('Storage','DEFAULT','management-server','storage.template.cleanup.enabled','true','Enable/disable template cleanup activity, only take effect when overall storage cleanup is enabled',NULL,NULL,NULL,0),('Advanced','DEFAULT','VirtualMachineManager','sync.interval','60','Cluster Delta sync interval in seconds','60','2013-10-26 06:30:24','Global',0),('Advanced','DEFAULT','management-server','system.vm.auto.reserve.capacity','true','Indicates whether or not to automatically reserver system VM standby capacity.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','system.vm.default.hypervisor',NULL,'Hypervisor type used to create system vm',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','system.vm.random.password','false','Randomize system vm password the first time management server starts',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','system.vm.use.local.storage','true',NULL,NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','task.cleanup.retry.interval','600','Time (in seconds) to wait before retrying cleanup of tasks if the cleanup failed previously.  0 means to never retry.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','timeout.baremetal.securitygroup.agent.echo','3600','Timeout to echo baremetal security group agent, in seconds, the provisioning process will be treated as a failure','3600',NULL,NULL,0),('Storage','DEFAULT','AgentManager','total.retries','4','The number of times each command sent to a host should be retried in case of failure.',NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','traffic.sentinel.exclude.zones','','Traffic going into specified list of zones is not metered','',NULL,NULL,0),('Usage','DEFAULT','management-server','traffic.sentinel.include.zones','EXTERNAL','Traffic going into specified list of zones is metered. For metering all traffic leave this parameter empty','EXTERNAL',NULL,NULL,0),('Advanced','DEFAULT','management-server','ucs.sync.blade.interval','3600','the interval cloudstack sync with UCS manager for available blades in case user remove blades from chassis without notifying CloudStack','3600',NULL,NULL,0),('Advanced','DEFAULT','AgentManager','update.wait','600','Time to wait (in seconds) before alerting on a updating agent',NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','usage.aggregation.timezone','GMT','The timezone to use for usage stats aggregation',NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','usage.execution.timezone',NULL,'The timezone to use for usage job execution time',NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','usage.sanity.check.interval',NULL,'Interval (in days) to check sanity of usage data',NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','usage.stats.job.aggregation.range','1440','The range of time for aggregating the user statistics specified in minutes (e.g. 1440 for daily, 60 for hourly.',NULL,NULL,NULL,0),('Usage','DEFAULT','management-server','usage.stats.job.exec.time','00:15','The time at which the usage statistics aggregation job will run as an HH24:MM time, e.g. 00:30 to run at 12:30am.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','use.system.guest.vlans','true','If true, when account has dedicated guest vlan range(s), once the vlans dedicated to the account have been consumed vlans will be allocated from the system pool','true',NULL,NULL,0),('Advanced','DEFAULT','management-server','use.system.public.ips','true','If true, when account has dedicated public ip range(s), once the ips dedicated to the account have been consumed ips will be acquired from the system pool','true','2013-10-26 06:30:24',NULL,1),('Advanced','DEFAULT','management-server','vm.allocation.algorithm','random','\'random\', \'firstfit\', \'userdispersing\', \'userconcentratedpod_random\', \'userconcentratedpod_firstfit\' : Order in which hosts within a cluster will be considered for VM/volume allocation.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.deployment.planner','FirstFitPlanner','[\'FirstFitPlanner\', \'UserDispersingPlanner\', \'UserConcentratedPodPlanner\']: DeploymentPlanner heuristic that will be used for VM deployment.','FirstFitPlanner',NULL,NULL,0),('Advanced','DEFAULT','VirtualMachineManager','vm.destroy.forcestop','false','On destroy, force-stop takes this value ','false','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','management-server','vm.disk.stats.interval','0','Interval (in seconds) to report vm disk statistics.','0',NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.disk.throttling.bytes_read_rate','0','Default disk I/O read rate in bytes per second allowed in User vm\'s disk. ','0',NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.disk.throttling.bytes_write_rate','0','Default disk I/O write rate in bytes per second allowed in User vm\'s disk. ','0',NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.disk.throttling.iops_read_rate','0','Default disk I/O read rate in requests per second allowed in User vm\'s disk. ','0',NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.disk.throttling.iops_write_rate','0','Default disk I/O write rate in requests per second allowed in User vm\'s disk. ','0',NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.instancename.flag','false','If set to true, will set guest VM\'s name as it appears on the hypervisor, to its hostname','false',NULL,NULL,0),('Network','DEFAULT','management-server','vm.network.throttling.rate','200','Default data transfer rate in megabits per second allowed in User vm\'s default network.',NULL,NULL,NULL,0),('Advanced','DEFAULT','VirtualMachineManager','vm.op.cancel.interval','3600','Time (in seconds) to wait before cancelling a operation','3600','2013-10-26 06:30:24','Global',0),('Advanced','DEFAULT','VirtualMachineManager','vm.op.cleanup.interval','86400','Interval to run the thread that cleans up the vm operations (in seconds)','86400','2013-10-26 06:30:24','Global',0),('Advanced','DEFAULT','VirtualMachineManager','vm.op.cleanup.wait','3600','Time (in seconds) to wait before cleanuping up any vm work items','3600','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','VirtualMachineManager','vm.op.lock.state.retry','5','Times to retry locking the state of a VM for operations, -1 means forever','5','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','VirtualMachineManager','vm.op.wait.interval','120','Time (in seconds) to wait before checking if a previous operation has succeeded','120','2013-10-26 06:30:24','Global',1),('Advanced','DEFAULT','management-server','vm.stats.interval','60000','The interval (in milliseconds) when vm stats are retrieved from agents.',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.tranisition.wait.interval','3600','Time (in seconds) to wait before taking over a VM in transition state',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vm.user.dispersion.weight','1','Weight for user dispersion heuristic (as a value between 0 and 1) applied to resource allocation during vm deployment. Weight for capacity heuristic will be (1 - weight of user dispersion)',NULL,NULL,NULL,0),('Advanced','DEFAULT','none','vmsnapshot.create.wait','1800','In second, timeout for create vm snapshot',NULL,NULL,NULL,0),('Advanced','DEFAULT','none','vmsnapshot.max','10','Maximum vm snapshots for a vm',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.additional.vnc.portrange.size','1000','Start port number of additional VNC port range',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.additional.vnc.portrange.start','50000','Start port number of additional VNC port range',NULL,NULL,NULL,0),('Advanced','DEFAULT','UserVmManager','vmware.create.full.clone','true','If set to true, creates VMs as full clones on ESX hypervisor','true',NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.hung.wokervm.timeout','7200','Worker VM timeout in seconds',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.management.portgroup','Management Network','Specify the management network name(for ESXi hosts)',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.nested.virtualization','false','When set to true this will enable nested virtualization when this is supported by the hypervisor','false',NULL,NULL,0),('Network','DEFAULT','management-server','vmware.ports.per.dvportgroup','256','Default number of ports per Vmware dvPortGroup in VMware environment','256',NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.recycle.hung.wokervm','false','Specify whether or not to recycle hung worker VMs',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.reserve.cpu','false','Specify whether or not to reserve CPU based on CPU overprovisioning factor',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.reserve.mem','false','Specify whether or not to reserve memory based on memory overprovisioning factor',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.root.disk.controller','ide','Specify the default disk controller for root volumes, valid values are scsi, ide',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.service.console','Service Console','Specify the service console network name(for ESX hosts)',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vmware.systemvm.nic.device.type','E1000','Specify the default network device type for system VMs, valid values are E1000, PCNet32, Vmxnet2, Vmxnet3',NULL,NULL,NULL,0),('Network','DEFAULT','management-server','vmware.use.dvswitch','false','Enable/Disable Nexus/Vmware dvSwitch in VMware environment','false',NULL,NULL,0),('Network','DEFAULT','management-server','vmware.use.nexus.vswitch','false','Enable/Disable Cisco Nexus 1000v vSwitch in VMware environment',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vpc.cleanup.interval','3600','The interval (in seconds) between cleanup for Inactive VPCs',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','vpc.max.networks','3','Maximum number of networks per vpc',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','wait','1800','Time in seconds to wait for control commands to return','1800','2013-10-26 06:30:24','Global',1),('Advance','DEFAULT','AgentManager','workers','5','Number of worker threads handling remote agent connections.','5','2013-10-26 06:30:24','Global',0),('Advanced','DEFAULT','AgentManager','xapiwait','600','Time (in seconds) to wait for XAPI to return',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','xen.bond.storage.nics',NULL,'Attempt to bond the two networks if found',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','xen.create.pools.in.pod','false','Should we automatically add XenServers into pools that are inside a Pod',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','xen.guest.network.device',NULL,'Specify for guest network name label',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','xen.heartbeat.interval','60','heartbeat to use when implementing XenServer Self Fencing',NULL,NULL,NULL,0),('Advanced','DEFAULT','AgentManager','xen.nics.max','7','Maximum allowed nics for Vms created on Xen','7',NULL,NULL,0),('Hidden','DEFAULT','management-server','xen.private.network.device',NULL,'Specify when the private network name is different',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','xen.public.network.device',NULL,'[ONLY IF THE PUBLIC NETWORK IS ON A DEDICATED NIC]:The network name label of the physical device dedicated to the public network on a XenServer host',NULL,NULL,NULL,0),('Advanced','DEFAULT','management-server','xen.setup.multipath','false','Setup the host to do multipath',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','xen.storage.network.device1',NULL,'Specify when there are storage networks',NULL,NULL,NULL,0),('Hidden','DEFAULT','management-server','xen.storage.network.device2',NULL,'Specify when there are storage networks',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','zone.directnetwork.publicip.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of Direct Network Public Ip Utilization above which alerts will be sent about low number of direct network public ips.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','zone.secstorage.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of secondary storage utilization above which alerts will be sent about low storage available.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','zone.virtualnetwork.publicip.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of public IP address space utilization above which alerts will be sent.',NULL,NULL,NULL,0),('Alert','DEFAULT','management-server','zone.vlan.capacity.notificationthreshold','0.75','Percentage (as a value between 0 and 1) of Zone Vlan utilization above which alerts will be sent about low number of Zone Vlans.',NULL,NULL,NULL,0);
/*!40000 ALTER TABLE `configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `console_proxy`
--

DROP TABLE IF EXISTS `console_proxy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `console_proxy` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `public_mac_address` varchar(17) DEFAULT NULL COMMENT 'mac address of the public facing network card',
  `public_ip_address` char(40) DEFAULT NULL COMMENT 'public ip address for the console proxy',
  `public_netmask` varchar(15) DEFAULT NULL COMMENT 'public netmask used for the console proxy',
  `active_session` int(10) NOT NULL DEFAULT '0' COMMENT 'active session number',
  `last_update` datetime DEFAULT NULL COMMENT 'Last session update time',
  `session_details` blob COMMENT 'session detail info',
  PRIMARY KEY (`id`),
  UNIQUE KEY `public_mac_address` (`public_mac_address`),
  CONSTRAINT `fk_console_proxy__id` FOREIGN KEY (`id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `console_proxy`
--

LOCK TABLES `console_proxy` WRITE;
/*!40000 ALTER TABLE `console_proxy` DISABLE KEYS */;
INSERT INTO `console_proxy` VALUES (2,NULL,NULL,NULL,0,NULL,NULL);
/*!40000 ALTER TABLE `console_proxy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `counter`
--

DROP TABLE IF EXISTS `counter`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `counter` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `source` varchar(255) NOT NULL COMMENT 'source e.g. netscaler, snmp',
  `name` varchar(255) NOT NULL COMMENT 'Counter name',
  `value` varchar(255) NOT NULL COMMENT 'Value in case of source=snmp',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `created` datetime NOT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_counter__uuid` (`uuid`),
  KEY `i_counter__removed` (`removed`),
  KEY `i_counter__source` (`source`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `counter`
--

LOCK TABLES `counter` WRITE;
/*!40000 ALTER TABLE `counter` DISABLE KEYS */;
INSERT INTO `counter` VALUES (1,'4eee0088-3e05-11e3-a27a-14109fdfd297','snmp','Linux User CPU - percentage','1.3.6.1.4.1.2021.11.9.0',NULL,'2013-10-25 23:10:27'),(2,'4eee0c1e-3e05-11e3-a27a-14109fdfd297','snmp','Linux System CPU - percentage','1.3.6.1.4.1.2021.11.10.0',NULL,'2013-10-25 23:10:27'),(3,'4eee163a-3e05-11e3-a27a-14109fdfd297','snmp','Linux CPU Idle - percentage','1.3.6.1.4.1.2021.11.11.0',NULL,'2013-10-25 23:10:27'),(100,'4eee1fc2-3e05-11e3-a27a-14109fdfd297','netscaler','Response Time - microseconds','RESPTIME',NULL,'2013-10-25 23:10:27');
/*!40000 ALTER TABLE `counter` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_center`
--

DROP TABLE IF EXISTS `data_center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_center` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `dns1` varchar(255) NOT NULL,
  `dns2` varchar(255) DEFAULT NULL,
  `internal_dns1` varchar(255) NOT NULL,
  `internal_dns2` varchar(255) DEFAULT NULL,
  `gateway` varchar(15) DEFAULT NULL,
  `netmask` varchar(15) DEFAULT NULL,
  `router_mac_address` varchar(17) NOT NULL DEFAULT '02:00:00:00:00:01' COMMENT 'mac address for the router within the domain',
  `mac_address` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT 'Next available mac address for the ethernet card interacting with public internet',
  `guest_network_cidr` varchar(18) DEFAULT NULL,
  `domain` varchar(100) DEFAULT NULL COMMENT 'Network domain name of the Vms of the zone',
  `domain_id` bigint(20) unsigned DEFAULT NULL COMMENT 'domain id for the parent domain to this zone (null signifies public zone)',
  `networktype` varchar(255) NOT NULL DEFAULT 'Basic' COMMENT 'Network type of the zone',
  `dns_provider` char(64) DEFAULT 'VirtualRouter',
  `gateway_provider` char(64) DEFAULT 'VirtualRouter',
  `firewall_provider` char(64) DEFAULT 'VirtualRouter',
  `dhcp_provider` char(64) DEFAULT 'VirtualRouter',
  `lb_provider` char(64) DEFAULT 'VirtualRouter',
  `vpn_provider` char(64) DEFAULT 'VirtualRouter',
  `userdata_provider` char(64) DEFAULT 'VirtualRouter',
  `allocation_state` varchar(32) NOT NULL DEFAULT 'Enabled' COMMENT 'Is this data center enabled for allocation for new resources',
  `zone_token` varchar(255) DEFAULT NULL,
  `is_security_group_enabled` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1: enabled, 0: not',
  `is_local_storage_enabled` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'Is local storage offering enabled for this data center; 1: enabled, 0: not',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `owner` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `lastUpdated` datetime DEFAULT NULL COMMENT 'last updated',
  `engine_state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'the engine state of the zone',
  `ip6_dns1` varchar(255) DEFAULT NULL,
  `ip6_dns2` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_data_center__uuid` (`uuid`),
  KEY `i_data_center__domain_id` (`domain_id`),
  KEY `i_data_center__allocation_state` (`allocation_state`),
  KEY `i_data_center__zone_token` (`zone_token`),
  KEY `i_data_center__removed` (`removed`),
  CONSTRAINT `fk_data_center__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_center`
--

LOCK TABLES `data_center` WRITE;
/*!40000 ALTER TABLE `data_center` DISABLE KEYS */;
INSERT INTO `data_center` VALUES (1,'testzone','aa661d8d-0abd-4494-92a5-aa91d2ed59eb',NULL,'8.8.8.8',NULL,'192.168.3.1',NULL,NULL,NULL,'02:00:00:00:00:01',192,'10.1.1.0/24',NULL,NULL,'Advanced','VirtualRouter','VirtualRouter','VirtualRouter','VirtualRouter','VirtualRouter','VirtualRouter','VirtualRouter','Enabled','af82863d-c828-3714-984b-51ec600075cf',0,1,NULL,NULL,NULL,NULL,'Disabled',NULL,NULL);
/*!40000 ALTER TABLE `data_center` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `data_center_details`
--

DROP TABLE IF EXISTS `data_center_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `data_center_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `dc_id` bigint(20) unsigned NOT NULL COMMENT 'dc id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_dc_details__dc_id` (`dc_id`),
  CONSTRAINT `fk_dc_details__dc_id` FOREIGN KEY (`dc_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `data_center_details`
--

LOCK TABLES `data_center_details` WRITE;
/*!40000 ALTER TABLE `data_center_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `data_center_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `data_center_view`
--

DROP TABLE IF EXISTS `data_center_view`;
/*!50001 DROP VIEW IF EXISTS `data_center_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `data_center_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `is_security_group_enabled` tinyint NOT NULL,
  `is_local_storage_enabled` tinyint NOT NULL,
  `description` tinyint NOT NULL,
  `dns1` tinyint NOT NULL,
  `dns2` tinyint NOT NULL,
  `ip6_dns1` tinyint NOT NULL,
  `ip6_dns2` tinyint NOT NULL,
  `internal_dns1` tinyint NOT NULL,
  `internal_dns2` tinyint NOT NULL,
  `guest_network_cidr` tinyint NOT NULL,
  `domain` tinyint NOT NULL,
  `networktype` tinyint NOT NULL,
  `allocation_state` tinyint NOT NULL,
  `zone_token` tinyint NOT NULL,
  `dhcp_provider` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `affinity_group_id` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `affinity_group_uuid` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `dc_storage_network_ip_range`
--

DROP TABLE IF EXISTS `dc_storage_network_ip_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dc_storage_network_ip_range` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `start_ip` char(40) NOT NULL COMMENT 'start ip address',
  `end_ip` char(40) NOT NULL COMMENT 'end ip address',
  `gateway` varchar(15) NOT NULL COMMENT 'gateway ip address',
  `vlan` int(10) unsigned DEFAULT NULL COMMENT 'vlan the storage network on',
  `netmask` varchar(15) NOT NULL COMMENT 'netmask for storage network',
  `data_center_id` bigint(20) unsigned NOT NULL,
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod it belongs to',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'id of corresponding network offering',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_storage_ip_range__uuid` (`uuid`),
  KEY `fk_storage_ip_range__network_id` (`network_id`),
  KEY `fk_storage_ip_range__data_center_id` (`data_center_id`),
  KEY `fk_storage_ip_range__pod_id` (`pod_id`),
  CONSTRAINT `fk_storage_ip_range__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`),
  CONSTRAINT `fk_storage_ip_range__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`),
  CONSTRAINT `fk_storage_ip_range__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dc_storage_network_ip_range`
--

LOCK TABLES `dc_storage_network_ip_range` WRITE;
/*!40000 ALTER TABLE `dc_storage_network_ip_range` DISABLE KEYS */;
/*!40000 ALTER TABLE `dc_storage_network_ip_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `dedicated_resources`
--

DROP TABLE IF EXISTS `dedicated_resources`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `dedicated_resources` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `data_center_id` bigint(20) unsigned DEFAULT NULL COMMENT 'data center id',
  `pod_id` bigint(20) unsigned DEFAULT NULL COMMENT 'pod id',
  `cluster_id` bigint(20) unsigned DEFAULT NULL COMMENT 'cluster id',
  `host_id` bigint(20) unsigned DEFAULT NULL COMMENT 'host id',
  `domain_id` bigint(20) unsigned DEFAULT NULL COMMENT 'domain id of the domain to which resource is dedicated',
  `account_id` bigint(20) unsigned DEFAULT NULL COMMENT 'account id of the account to which resource is dedicated',
  `affinity_group_id` bigint(20) unsigned NOT NULL COMMENT 'affinity group id associated',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_dedicated_resources__uuid` (`uuid`),
  KEY `fk_dedicated_resources__data_center_id` (`data_center_id`),
  KEY `fk_dedicated_resources__pod_id` (`pod_id`),
  KEY `fk_dedicated_resources__cluster_id` (`cluster_id`),
  KEY `fk_dedicated_resources__host_id` (`host_id`),
  KEY `i_dedicated_resources_domain_id` (`domain_id`),
  KEY `i_dedicated_resources_account_id` (`account_id`),
  KEY `i_dedicated_resources_affinity_group_id` (`affinity_group_id`),
  CONSTRAINT `fk_dedicated_resources__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_dedicated_resources__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`),
  CONSTRAINT `fk_dedicated_resources__cluster_id` FOREIGN KEY (`cluster_id`) REFERENCES `cluster` (`id`),
  CONSTRAINT `fk_dedicated_resources__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`),
  CONSTRAINT `fk_dedicated_resources__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`),
  CONSTRAINT `fk_dedicated_resources__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_dedicated_resources__affinity_group_id` FOREIGN KEY (`affinity_group_id`) REFERENCES `affinity_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `dedicated_resources`
--

LOCK TABLES `dedicated_resources` WRITE;
/*!40000 ALTER TABLE `dedicated_resources` DISABLE KEYS */;
/*!40000 ALTER TABLE `dedicated_resources` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disk_offering`
--

DROP TABLE IF EXISTS `disk_offering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disk_offering` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `domain_id` bigint(20) unsigned DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `display_text` varchar(4096) DEFAULT NULL COMMENT 'Descrianaption text set by the admin for display purpose only',
  `disk_size` bigint(20) unsigned NOT NULL COMMENT 'disk space in byte',
  `type` varchar(32) DEFAULT NULL COMMENT 'inheritted by who?',
  `tags` varchar(4096) DEFAULT NULL COMMENT 'comma separated tags about the disk_offering',
  `recreatable` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'The root disk is always recreatable',
  `use_local_storage` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Indicates whether local storage pools should be used',
  `unique_name` varchar(32) DEFAULT NULL COMMENT 'unique name',
  `system_use` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'is this offering for system used only',
  `customized` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '0 implies not customized by default',
  `removed` datetime DEFAULT NULL COMMENT 'date removed',
  `created` datetime DEFAULT NULL COMMENT 'date the disk offering was created',
  `sort_key` int(32) NOT NULL DEFAULT '0' COMMENT 'sort key used for customising sort method',
  `display_offering` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should disk offering be displayed to the end user',
  `customized_iops` tinyint(1) unsigned DEFAULT NULL COMMENT 'Should customized IOPS be displayed to the end user',
  `min_iops` bigint(20) unsigned DEFAULT NULL COMMENT 'Minimum IOPS',
  `max_iops` bigint(20) unsigned DEFAULT NULL COMMENT 'Maximum IOPS',
  `bytes_read_rate` bigint(20) DEFAULT NULL,
  `bytes_write_rate` bigint(20) DEFAULT NULL,
  `iops_read_rate` bigint(20) DEFAULT NULL,
  `iops_write_rate` bigint(20) DEFAULT NULL,
  `state` char(40) NOT NULL DEFAULT 'Active' COMMENT 'state for disk offering',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_name` (`unique_name`),
  UNIQUE KEY `uc_disk_offering__uuid` (`uuid`),
  KEY `i_disk_offering__removed` (`removed`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disk_offering`
--

LOCK TABLES `disk_offering` WRITE;
/*!40000 ALTER TABLE `disk_offering` DISABLE KEYS */;
INSERT INTO `disk_offering` VALUES (17,NULL,'tinyOffering','50aab21f-3e05-11e3-a27a-14109fdfd297','tinyOffering',0,'Service',NULL,0,1,NULL,0,0,NULL,'2013-10-25 23:10:30',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(18,NULL,'tinyDiskOffering','50ab207d-3e05-11e3-a27a-14109fdfd297','tinyDiskOffering',1073741824,'Disk',NULL,0,0,NULL,0,0,NULL,'2013-10-25 23:10:30',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(19,NULL,'Small Instance','03d9fba4-c27b-457a-afd4-192b97f1b2c0','Small Instance',0,'Service',NULL,0,0,'Cloud.Com-Small Instance',0,1,NULL,'2013-10-26 06:30:23',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(20,NULL,'Medium Instance','c8317dbc-0d8b-4b44-808d-01d9396fda1d','Medium Instance',0,'Service',NULL,0,0,'Cloud.Com-Medium Instance',0,1,NULL,'2013-10-26 06:30:23',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(21,NULL,'Small','947ba71c-44b5-4206-80b1-01d610470018','Small Disk, 5 GB',5368709120,'Disk',NULL,0,0,'Cloud.Com-Small',0,0,NULL,'2013-10-26 06:30:23',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(22,NULL,'Medium','f5f0addd-7d5e-43e0-ac15-1e98cc807616','Medium Disk, 20 GB',21474836480,'Disk',NULL,0,0,'Cloud.Com-Medium',0,0,NULL,'2013-10-26 06:30:23',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(23,NULL,'Large','50f18ecf-7a19-41e0-9212-5cc1f9b6e81a','Large Disk, 100 GB',107374182400,'Disk',NULL,0,0,'Cloud.Com-Large',0,0,NULL,'2013-10-26 06:30:23',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(24,NULL,'Custom','c15e1f0a-2920-453f-b863-14dfae7e7a92','Custom Disk',0,'Disk',NULL,0,0,'Cloud.Com-Custom',0,1,NULL,'2013-10-26 06:30:23',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(25,NULL,'System Offering For Software Router','de995606-067d-4077-a082-c9bae434040a',NULL,0,'Service',NULL,1,1,'Cloud.Com-SoftwareRouter',1,1,NULL,'2013-10-26 06:30:25',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(26,NULL,'System Offering For Elastic LB VM','a67c345b-ae82-48e3-b9c1-bbe4bfb9fd34',NULL,0,'Service',NULL,1,1,'Cloud.Com-ElasticLBVm',1,1,NULL,'2013-10-26 06:30:25',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(27,NULL,'System Offering For Secondary Storage VM','355c8c8e-f3a0-498e-902d-eb68dfbd2b3e',NULL,0,'Service',NULL,1,1,'Cloud.com-SecondaryStorage',1,1,NULL,'2013-10-26 06:30:25',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(28,NULL,'System Offering For Internal LB VM','eb49507a-96e5-4a79-83cb-091004d3aea9',NULL,0,'Service',NULL,1,1,'Cloud.Com-InternalLBVm',1,1,NULL,'2013-10-26 06:30:25',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active'),(29,NULL,'System Offering For Console Proxy','c485a151-430e-4e17-b801-4019278ed6b1',NULL,0,'Service',NULL,1,1,'Cloud.com-ConsoleProxy',1,1,NULL,'2013-10-26 06:30:25',0,1,NULL,NULL,NULL,NULL,NULL,NULL,NULL,'Active');
/*!40000 ALTER TABLE `disk_offering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `disk_offering_details`
--

DROP TABLE IF EXISTS `disk_offering_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `disk_offering_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `offering_id` bigint(20) unsigned NOT NULL COMMENT 'offering id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) NOT NULL,
  `display_detail` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should detail be displayed to the end user',
  PRIMARY KEY (`id`),
  KEY `fk_offering_details__offering_id` (`offering_id`),
  CONSTRAINT `fk_offering_details__offering_id` FOREIGN KEY (`offering_id`) REFERENCES `disk_offering` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `disk_offering_details`
--

LOCK TABLES `disk_offering_details` WRITE;
/*!40000 ALTER TABLE `disk_offering_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `disk_offering_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `disk_offering_view`
--

DROP TABLE IF EXISTS `disk_offering_view`;
/*!50001 DROP VIEW IF EXISTS `disk_offering_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `disk_offering_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `display_text` tinyint NOT NULL,
  `disk_size` tinyint NOT NULL,
  `min_iops` tinyint NOT NULL,
  `max_iops` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `tags` tinyint NOT NULL,
  `customized` tinyint NOT NULL,
  `customized_iops` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `use_local_storage` tinyint NOT NULL,
  `system_use` tinyint NOT NULL,
  `bytes_read_rate` tinyint NOT NULL,
  `bytes_write_rate` tinyint NOT NULL,
  `iops_read_rate` tinyint NOT NULL,
  `iops_write_rate` tinyint NOT NULL,
  `sort_key` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  `display_offering` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `domain`
--

DROP TABLE IF EXISTS `domain`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domain` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `parent` bigint(20) unsigned DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `owner` bigint(20) unsigned NOT NULL,
  `path` varchar(255) NOT NULL,
  `level` int(10) NOT NULL DEFAULT '0',
  `child_count` int(10) NOT NULL DEFAULT '0',
  `next_child_seq` bigint(20) unsigned NOT NULL DEFAULT '1',
  `removed` datetime DEFAULT NULL COMMENT 'date removed',
  `state` char(32) NOT NULL DEFAULT 'Active' COMMENT 'state of the domain',
  `network_domain` varchar(255) DEFAULT NULL,
  `type` varchar(255) NOT NULL DEFAULT 'Normal' COMMENT 'type of the domain - can be Normal or Project',
  PRIMARY KEY (`id`),
  UNIQUE KEY `parent` (`parent`,`name`,`removed`),
  UNIQUE KEY `uc_domain__uuid` (`uuid`),
  KEY `i_domain__path` (`path`),
  KEY `i_domain__removed` (`removed`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain`
--

LOCK TABLES `domain` WRITE;
/*!40000 ALTER TABLE `domain` DISABLE KEYS */;
INSERT INTO `domain` VALUES (1,NULL,'ROOT','4e6d342c-3e05-11e3-a27a-14109fdfd297',2,'/',0,0,1,NULL,'Active',NULL,'Normal');
/*!40000 ALTER TABLE `domain` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domain_network_ref`
--

DROP TABLE IF EXISTS `domain_network_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domain_network_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain id',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network id',
  `subdomain_access` int(1) unsigned DEFAULT NULL COMMENT '1 if network can be accessible from the subdomain',
  PRIMARY KEY (`id`),
  KEY `fk_domain_network_ref__domain_id` (`domain_id`),
  KEY `fk_domain_network_ref__networks_id` (`network_id`),
  CONSTRAINT `fk_domain_network_ref__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_domain_network_ref__networks_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain_network_ref`
--

LOCK TABLES `domain_network_ref` WRITE;
/*!40000 ALTER TABLE `domain_network_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `domain_network_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `domain_router`
--

DROP TABLE IF EXISTS `domain_router`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `domain_router` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'Primary Key',
  `element_id` bigint(20) unsigned NOT NULL COMMENT 'correlated virtual router provider ID',
  `public_mac_address` varchar(17) DEFAULT NULL COMMENT 'mac address of the public facing network card',
  `public_ip_address` char(40) DEFAULT NULL COMMENT 'public ip address used for source net',
  `public_netmask` varchar(15) DEFAULT NULL COMMENT 'netmask used for the domR',
  `guest_netmask` varchar(15) DEFAULT NULL COMMENT 'netmask used for the guest network',
  `guest_ip_address` char(40) DEFAULT NULL COMMENT ' ip address in the guest network',
  `is_redundant_router` int(1) unsigned NOT NULL COMMENT 'if in redundant router mode',
  `priority` int(4) unsigned DEFAULT NULL COMMENT 'priority of router in the redundant router mode',
  `is_priority_bumpup` int(1) unsigned NOT NULL COMMENT 'if the priority has been bumped up',
  `redundant_state` varchar(64) NOT NULL COMMENT 'the state of redundant virtual router',
  `stop_pending` int(1) unsigned NOT NULL COMMENT 'if this router would be stopped after we can connect to it',
  `role` varchar(64) NOT NULL COMMENT 'type of role played by this router',
  `template_version` varchar(100) DEFAULT NULL COMMENT 'template version',
  `scripts_version` varchar(100) DEFAULT NULL COMMENT 'scripts version',
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'correlated virtual router vpc ID',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_domain_router__element_id` (`element_id`),
  KEY `fk_domain_router__vpc_id` (`vpc_id`),
  CONSTRAINT `fk_domain_router__id` FOREIGN KEY (`id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_domain_router__element_id` FOREIGN KEY (`element_id`) REFERENCES `virtual_router_providers` (`id`),
  CONSTRAINT `fk_domain_router__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='information about the domR instance';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `domain_router`
--

LOCK TABLES `domain_router` WRITE;
/*!40000 ALTER TABLE `domain_router` DISABLE KEYS */;
/*!40000 ALTER TABLE `domain_router` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `domain_router_view`
--

DROP TABLE IF EXISTS `domain_router_view`;
/*!50001 DROP VIEW IF EXISTS `domain_router_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `domain_router_view` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `pod_id` tinyint NOT NULL,
  `instance_name` tinyint NOT NULL,
  `pod_uuid` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `data_center_type` tinyint NOT NULL,
  `dns1` tinyint NOT NULL,
  `dns2` tinyint NOT NULL,
  `ip6_dns1` tinyint NOT NULL,
  `ip6_dns2` tinyint NOT NULL,
  `host_id` tinyint NOT NULL,
  `host_uuid` tinyint NOT NULL,
  `host_name` tinyint NOT NULL,
  `template_id` tinyint NOT NULL,
  `template_uuid` tinyint NOT NULL,
  `service_offering_id` tinyint NOT NULL,
  `service_offering_uuid` tinyint NOT NULL,
  `service_offering_name` tinyint NOT NULL,
  `nic_id` tinyint NOT NULL,
  `nic_uuid` tinyint NOT NULL,
  `network_id` tinyint NOT NULL,
  `ip_address` tinyint NOT NULL,
  `ip6_address` tinyint NOT NULL,
  `ip6_gateway` tinyint NOT NULL,
  `ip6_cidr` tinyint NOT NULL,
  `is_default_nic` tinyint NOT NULL,
  `gateway` tinyint NOT NULL,
  `netmask` tinyint NOT NULL,
  `mac_address` tinyint NOT NULL,
  `broadcast_uri` tinyint NOT NULL,
  `isolation_uri` tinyint NOT NULL,
  `vpc_id` tinyint NOT NULL,
  `vpc_uuid` tinyint NOT NULL,
  `network_uuid` tinyint NOT NULL,
  `network_name` tinyint NOT NULL,
  `network_domain` tinyint NOT NULL,
  `traffic_type` tinyint NOT NULL,
  `guest_type` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL,
  `template_version` tinyint NOT NULL,
  `scripts_version` tinyint NOT NULL,
  `is_redundant_router` tinyint NOT NULL,
  `redundant_state` tinyint NOT NULL,
  `stop_pending` tinyint NOT NULL,
  `role` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `elastic_lb_vm_map`
--

DROP TABLE IF EXISTS `elastic_lb_vm_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `elastic_lb_vm_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `ip_addr_id` bigint(20) unsigned NOT NULL,
  `elb_vm_id` bigint(20) unsigned NOT NULL,
  `lb_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_elastic_lb_vm_map__ip_id` (`ip_addr_id`),
  KEY `fk_elastic_lb_vm_map__elb_vm_id` (`elb_vm_id`),
  KEY `fk_elastic_lb_vm_map__lb_id` (`lb_id`),
  CONSTRAINT `fk_elastic_lb_vm_map__ip_id` FOREIGN KEY (`ip_addr_id`) REFERENCES `user_ip_address` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_elastic_lb_vm_map__elb_vm_id` FOREIGN KEY (`elb_vm_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_elastic_lb_vm_map__lb_id` FOREIGN KEY (`lb_id`) REFERENCES `load_balancing_rules` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `elastic_lb_vm_map`
--

LOCK TABLES `elastic_lb_vm_map` WRITE;
/*!40000 ALTER TABLE `elastic_lb_vm_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `elastic_lb_vm_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `type` varchar(32) NOT NULL,
  `state` varchar(32) NOT NULL DEFAULT 'Completed',
  `description` varchar(1024) NOT NULL,
  `user_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `level` varchar(16) NOT NULL,
  `start_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `parameters` varchar(1024) DEFAULT NULL,
  `archived` tinyint(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_event__uuid` (`uuid`),
  KEY `i_event__created` (`created`),
  KEY `i_event__user_id` (`user_id`),
  KEY `i_event__account_id` (`account_id`),
  KEY `i_event__level_id` (`level`),
  KEY `i_event__type_id` (`type`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

LOCK TABLES `event` WRITE;
/*!40000 ALTER TABLE `event` DISABLE KEYS */;
INSERT INTO `event` VALUES (1,'d58b2a0c-3576-458d-89d5-7d5806f98f4f','REGISTER.USER.KEY','Completed','Successfully completed register for the developer API keys',1,1,1,'2013-10-26 06:35:18','INFO',0,NULL,0),(2,'594bf2dc-3cd2-4f96-8dde-b209b9459fb0','ZONE.CREATE','Completed','Successfully completed creating zone. Zone Name: testzone',2,2,1,'2013-10-26 06:35:26','INFO',0,NULL,0),(3,'2ee7adb9-49e1-4154-b5c2-0552a18aa9e0','SERVICE.PROVIDER.CREATE','Created','Successfully created entity for Creating Physical Network ServiceProvider',2,2,1,'2013-10-26 06:35:26','INFO',0,NULL,0),(4,'bae4cc45-c18b-4d0c-b79e-3df66885ac43','SERVICE.PROVIDER.CREATE','Created','Successfully created entity for Creating Physical Network ServiceProvider',2,2,1,'2013-10-26 06:35:26','INFO',0,NULL,0),(5,'1167579e-f09f-4424-bfb3-85b8ea23b5b2','SERVICE.PROVIDER.CREATE','Created','Successfully created entity for Creating Physical Network ServiceProvider',2,2,1,'2013-10-26 06:35:26','INFO',0,NULL,0),(6,'7e79f1aa-76c8-4138-ae10-f9a52cb00535','SERVICE.PROVIDER.CREATE','Created','Successfully created entity for Creating Physical Network ServiceProvider',2,2,1,'2013-10-26 06:35:26','INFO',0,NULL,0),(7,'9f61d8bd-e10b-40bc-93b8-becdf385c494','PHYSICAL.NETWORK.CREATE','Created','Successfully created entity for Creating Physical Network',2,2,1,'2013-10-26 06:35:27','INFO',0,NULL,0),(8,'5da5e45e-da7d-4609-9c71-02a5d177611b','PHYSICAL.NETWORK.CREATE','Scheduled','creating Physical Network. Id: 200',2,1,1,'2013-10-26 06:35:27','INFO',7,NULL,0),(9,'6c70ed2c-e178-4c76-8ee9-ca1e56a0a7e8','PHYSICAL.NETWORK.CREATE','Started','Creating Physical Network. Physical Network Id: 200',2,2,1,'2013-10-26 06:35:27','INFO',7,NULL,0),(10,'8e968290-dcb7-464e-bc0b-e0fc7a142e3c','PHYSICAL.NETWORK.CREATE','Completed','Successfully completed Creating Physical Network. Physical Network Id: 200',2,2,1,'2013-10-26 06:35:27','INFO',7,NULL,0),(11,'5b238cd3-5d33-4d84-83fe-c10deaa5a75a','TRAFFIC.TYPE.CREATE','Created','Successfully created entity for Creating Physical Network TrafficType',2,2,1,'2013-10-26 06:35:27','INFO',0,NULL,0),(12,'455c2817-dfa2-4b1b-b3af-deb7d691fcf3','TRAFFIC.TYPE.CREATE','Scheduled','Adding physical network traffic type: 1',2,1,1,'2013-10-26 06:35:27','INFO',11,NULL,0),(13,'92d608f6-bff8-4db1-a3f6-6db076dc6776','TRAFFIC.TYPE.CREATE','Started','Creating Physical Network TrafficType. TrafficType Id: 1',2,2,1,'2013-10-26 06:35:27','INFO',11,NULL,0),(14,'400d7cd9-2f32-4d6b-bdba-2b993c5acc47','TRAFFIC.TYPE.CREATE','Completed','Successfully completed Creating Physical Network TrafficType. TrafficType Id: 1',2,2,1,'2013-10-26 06:35:27','INFO',11,NULL,0),(15,'183a9939-6dc2-4ad8-9fc3-48409b5da446','TRAFFIC.TYPE.CREATE','Created','Successfully created entity for Creating Physical Network TrafficType',2,2,1,'2013-10-26 06:35:32','INFO',0,NULL,0),(16,'08610e01-198b-4cd5-a942-7eef63fdbfba','TRAFFIC.TYPE.CREATE','Scheduled','Adding physical network traffic type: 2',2,1,1,'2013-10-26 06:35:32','INFO',15,NULL,0),(17,'239a8764-a4e9-4713-af39-b534af79f4ab','TRAFFIC.TYPE.CREATE','Started','Creating Physical Network TrafficType. TrafficType Id: 2',2,2,1,'2013-10-26 06:35:32','INFO',15,NULL,0),(18,'347b8e1b-f424-44b6-8991-03897762dbdc','TRAFFIC.TYPE.CREATE','Completed','Successfully completed Creating Physical Network TrafficType. TrafficType Id: 2',2,2,1,'2013-10-26 06:35:32','INFO',15,NULL,0),(19,'aa4f51a3-7855-4568-ac4f-585f1e8adff4','TRAFFIC.TYPE.CREATE','Created','Successfully created entity for Creating Physical Network TrafficType',2,2,1,'2013-10-26 06:35:37','INFO',0,NULL,0),(20,'c97f864c-4795-458a-9fa8-017c0d6f23cf','TRAFFIC.TYPE.CREATE','Scheduled','Adding physical network traffic type: 3',2,1,1,'2013-10-26 06:35:37','INFO',19,NULL,0),(21,'551260de-cb57-40c6-b38c-c599590b11e9','TRAFFIC.TYPE.CREATE','Started','Creating Physical Network TrafficType. TrafficType Id: 3',2,2,1,'2013-10-26 06:35:37','INFO',19,NULL,0),(22,'9d261425-0681-48bc-803b-e34f240f75dc','TRAFFIC.TYPE.CREATE','Completed','Successfully completed Creating Physical Network TrafficType. TrafficType Id: 3',2,2,1,'2013-10-26 06:35:37','INFO',19,NULL,0),(23,'9d0da671-4e58-4fe5-a6fd-3624776964ad','NETWORK.ELEMENT.CONFIGURE','Scheduled','configuring virtual router provider: 1',2,1,1,'2013-10-26 06:35:42','INFO',0,NULL,0),(24,'aacb2a53-3521-482c-bfc5-2437a2b2b01a','SERVICE.PROVIDER.UPDATE','Scheduled','Updating physical network ServiceProvider: 1',2,1,1,'2013-10-26 06:35:42','INFO',0,NULL,0),(25,'16b03f6a-0ba5-4013-b629-d800c973fdca','SERVICE.PROVIDER.UPDATE','Started','Updating physical network ServiceProvider',2,2,1,'2013-10-26 06:35:42','INFO',24,NULL,0),(26,'3a27f542-395f-4baa-9f42-232289477218','SERVICE.PROVIDER.UPDATE','Completed','Successfully completed Updating physical network ServiceProvider',2,2,1,'2013-10-26 06:35:42','INFO',24,NULL,0),(27,'3a2a8d16-e0f9-4e13-9122-17a055d05eba','NETWORK.ELEMENT.CONFIGURE','Scheduled','configuring virtual router provider: 2',2,1,1,'2013-10-26 06:35:47','INFO',0,NULL,0),(28,'372e2d7a-d9ff-4116-ab74-48a677aa8b21','SERVICE.PROVIDER.UPDATE','Scheduled','Updating physical network ServiceProvider: 3',2,1,1,'2013-10-26 06:35:47','INFO',0,NULL,0),(29,'a41d0d58-0f36-49ba-b6c8-477e7c86efd1','SERVICE.PROVIDER.UPDATE','Started','Updating physical network ServiceProvider',2,2,1,'2013-10-26 06:35:47','INFO',28,NULL,0),(30,'72a49ace-f045-47c9-bd6d-9feb6a9f41c8','SERVICE.PROVIDER.UPDATE','Completed','Successfully completed Updating physical network ServiceProvider',2,2,1,'2013-10-26 06:35:47','INFO',28,NULL,0),(31,'457fa3a1-7120-4d66-ab44-7f332a4cc98f','NETWORK.ELEMENT.CONFIGURE','Scheduled','configuring internal load balancer element: 3',2,1,1,'2013-10-26 06:35:52','INFO',0,NULL,0),(32,'6a370fcf-3af4-481d-94ca-27705e94b5fc','SERVICE.PROVIDER.UPDATE','Scheduled','Updating physical network ServiceProvider: 4',2,1,1,'2013-10-26 06:35:52','INFO',0,NULL,0),(33,'0a54d3f3-8bbe-4cab-b50d-6d67a4d2cb8b','SERVICE.PROVIDER.UPDATE','Started','Updating physical network ServiceProvider',2,2,1,'2013-10-26 06:35:52','INFO',32,NULL,0),(34,'07f33e45-849e-47e4-a9fa-f8da8747910d','SERVICE.PROVIDER.UPDATE','Completed','Successfully completed Updating physical network ServiceProvider',2,2,1,'2013-10-26 06:35:52','INFO',32,NULL,0),(35,'1dc33ba4-a4d5-49e7-bf07-12c9db954ae1','PHYSICAL.NETWORK.UPDATE','Scheduled','Updating Physical network: 200',2,1,1,'2013-10-26 06:35:57','INFO',0,NULL,0),(36,'916ee218-5de9-4030-b003-bcfe2f6bc285','PHYSICAL.NETWORK.UPDATE','Started','updating physical network',2,2,1,'2013-10-26 06:35:57','INFO',35,NULL,0),(37,'c2f222e0-ed58-4784-b54c-339df806bdf2','PHYSICAL.NETWORK.UPDATE','Completed','Successfully completed updating physical network',2,2,1,'2013-10-26 06:35:57','INFO',35,NULL,0),(38,'74767258-018b-4e17-8507-dbc0609fb7ed','VLAN.IP.RANGE.CREATE','Completed','Successfully completed creating vlan ip range',2,2,1,'2013-10-26 06:37:15','INFO',0,NULL,0),(39,'5f5c5bb5-86fb-4d75-bb0c-c6e201f6db56','TRAFFIC.TYPE.CREATE','Created','Successfully created entity for Creating Physical Network TrafficType. Zone Id: 1',2,2,1,'2013-10-26 06:37:15','INFO',0,NULL,0),(40,'23848d18-6dcc-4710-a5d3-58a96456ab6d','ZONE.EDIT','Completed','Successfully completed editing zone. Zone Id: 1',2,2,1,'2013-10-26 06:37:15','INFO',39,NULL,0),(41,'56bcee6b-98ad-4bd5-90dc-7e28ee87eade','FIREWALL.OPEN','Created','Successfully created entity for creating firewall rule',1,1,1,'2013-10-26 06:37:25','INFO',0,NULL,0),(42,'187bbe76-6b41-40ce-9667-485562b09574','FIREWALL.OPEN','Created','Successfully created entity for creating firewall rule',1,1,1,'2013-10-26 06:37:25','INFO',0,NULL,0);
/*!40000 ALTER TABLE `event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `event_view`
--

DROP TABLE IF EXISTS `event_view`;
/*!50001 DROP VIEW IF EXISTS `event_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `event_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `description` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `level` tinyint NOT NULL,
  `parameters` tinyint NOT NULL,
  `start_id` tinyint NOT NULL,
  `start_uuid` tinyint NOT NULL,
  `user_id` tinyint NOT NULL,
  `archived` tinyint NOT NULL,
  `user_name` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `external_bigswitch_vns_devices`
--

DROP TABLE IF EXISTS `external_bigswitch_vns_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_bigswitch_vns_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network in to which bigswitch vns device is added',
  `provider_name` varchar(255) NOT NULL COMMENT 'Service Provider name corresponding to this bigswitch vns device',
  `device_name` varchar(255) NOT NULL COMMENT 'name of the bigswitch vns device',
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id coresponding to the external bigswitch vns device',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_bigswitch_vns_devices__host_id` (`host_id`),
  KEY `fk_external_bigswitch_vns_devices__physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_external_bigswitch_vns_devices__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_bigswitch_vns_devices__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_bigswitch_vns_devices`
--

LOCK TABLES `external_bigswitch_vns_devices` WRITE;
/*!40000 ALTER TABLE `external_bigswitch_vns_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_bigswitch_vns_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_cisco_asa1000v_devices`
--

DROP TABLE IF EXISTS `external_cisco_asa1000v_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_cisco_asa1000v_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network in to which cisco asa1kv device is added',
  `management_ip` varchar(255) NOT NULL COMMENT 'mgmt. ip of cisco asa1kv device',
  `in_port_profile` varchar(255) NOT NULL COMMENT 'inside port profile name of cisco asa1kv device',
  `cluster_id` bigint(20) unsigned NOT NULL COMMENT 'id of the Vmware cluster to which cisco asa1kv device is attached (cisco n1kv switch)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `management_ip` (`management_ip`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_cisco_asa1000v_devices__physical_network_id` (`physical_network_id`),
  KEY `fk_external_cisco_asa1000v_devices__cluster_id` (`cluster_id`),
  CONSTRAINT `fk_external_cisco_asa1000v_devices__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_cisco_asa1000v_devices__cluster_id` FOREIGN KEY (`cluster_id`) REFERENCES `cluster` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_cisco_asa1000v_devices`
--

LOCK TABLES `external_cisco_asa1000v_devices` WRITE;
/*!40000 ALTER TABLE `external_cisco_asa1000v_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_cisco_asa1000v_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_cisco_vnmc_devices`
--

DROP TABLE IF EXISTS `external_cisco_vnmc_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_cisco_vnmc_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network in to which cisco vnmc device is added',
  `provider_name` varchar(255) NOT NULL COMMENT 'Service Provider name corresponding to this cisco vnmc device',
  `device_name` varchar(255) NOT NULL COMMENT 'name of the cisco vnmc device',
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id coresponding to the external cisco vnmc device',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_cisco_vnmc_devices__host_id` (`host_id`),
  KEY `fk_external_cisco_vnmc_devices__physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_external_cisco_vnmc_devices__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_cisco_vnmc_devices__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_cisco_vnmc_devices`
--

LOCK TABLES `external_cisco_vnmc_devices` WRITE;
/*!40000 ALTER TABLE `external_cisco_vnmc_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_cisco_vnmc_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_firewall_devices`
--

DROP TABLE IF EXISTS `external_firewall_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_firewall_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network in to which firewall device is added',
  `provider_name` varchar(255) NOT NULL COMMENT 'Service Provider name corresponding to this firewall device',
  `device_name` varchar(255) NOT NULL COMMENT 'name of the firewall device',
  `device_state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'state (enabled/disabled/shutdown) of the device',
  `is_dedicated` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if device/appliance meant for dedicated use only',
  `allocation_state` varchar(32) NOT NULL DEFAULT 'Free' COMMENT 'Allocation state (Free/Allocated) of the device',
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id coresponding to the external firewall device',
  `capacity` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'Capacity of the external firewall device',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_firewall_devices__host_id` (`host_id`),
  KEY `fk_external_firewall_devices__physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_external_firewall_devices__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_firewall_devices__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_firewall_devices`
--

LOCK TABLES `external_firewall_devices` WRITE;
/*!40000 ALTER TABLE `external_firewall_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_firewall_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_load_balancer_devices`
--

DROP TABLE IF EXISTS `external_load_balancer_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_load_balancer_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network in to which load balancer device is added',
  `provider_name` varchar(255) NOT NULL COMMENT 'Service Provider name corresponding to this load balancer device',
  `device_name` varchar(255) NOT NULL COMMENT 'name of the load balancer device',
  `capacity` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'Capacity of the load balancer device',
  `device_state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'state (enabled/disabled/shutdown) of the device',
  `allocation_state` varchar(32) NOT NULL DEFAULT 'Free' COMMENT 'Allocation state (Free/Shared/Dedicated/Provider) of the device',
  `is_dedicated` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if device/appliance is provisioned for dedicated use only',
  `is_managed` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if load balancer appliance is provisioned and its life cycle is managed by by cloudstack',
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id coresponding to the external load balancer device',
  `parent_host_id` bigint(20) unsigned DEFAULT NULL COMMENT 'if the load balancer appliance is cloudstack managed, then host id on which this appliance is provisioned',
  `is_gslb_provider` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if load balancer appliance is acting as gslb service provider in the zone',
  `gslb_site_publicip` varchar(255) DEFAULT NULL COMMENT 'GSLB service Provider site public ip',
  `gslb_site_privateip` varchar(255) DEFAULT NULL COMMENT 'GSLB service Provider site private ip',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_lb_devices_parent_host_id` (`host_id`),
  KEY `fk_external_lb_devices_physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_external_lb_devices_host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_lb_devices_parent_host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_lb_devices_physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_load_balancer_devices`
--

LOCK TABLES `external_load_balancer_devices` WRITE;
/*!40000 ALTER TABLE `external_load_balancer_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_load_balancer_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_nicira_nvp_devices`
--

DROP TABLE IF EXISTS `external_nicira_nvp_devices`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_nicira_nvp_devices` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network in to which nicira nvp device is added',
  `provider_name` varchar(255) NOT NULL COMMENT 'Service Provider name corresponding to this nicira nvp device',
  `device_name` varchar(255) NOT NULL COMMENT 'name of the nicira nvp device',
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id coresponding to the external nicira nvp device',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_external_nicira_nvp_devices__host_id` (`host_id`),
  KEY `fk_external_nicira_nvp_devices__physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_external_nicira_nvp_devices__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_external_nicira_nvp_devices__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_nicira_nvp_devices`
--

LOCK TABLES `external_nicira_nvp_devices` WRITE;
/*!40000 ALTER TABLE `external_nicira_nvp_devices` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_nicira_nvp_devices` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_stratosphere_ssp_credentials`
--

DROP TABLE IF EXISTS `external_stratosphere_ssp_credentials`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_stratosphere_ssp_credentials` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_stratosphere_ssp_credentials`
--

LOCK TABLES `external_stratosphere_ssp_credentials` WRITE;
/*!40000 ALTER TABLE `external_stratosphere_ssp_credentials` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_stratosphere_ssp_credentials` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_stratosphere_ssp_tenants`
--

DROP TABLE IF EXISTS `external_stratosphere_ssp_tenants`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_stratosphere_ssp_tenants` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL COMMENT 'SSP tenant uuid',
  `zone_id` bigint(20) NOT NULL COMMENT 'cloudstack zone_id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_stratosphere_ssp_tenants`
--

LOCK TABLES `external_stratosphere_ssp_tenants` WRITE;
/*!40000 ALTER TABLE `external_stratosphere_ssp_tenants` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_stratosphere_ssp_tenants` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `external_stratosphere_ssp_uuids`
--

DROP TABLE IF EXISTS `external_stratosphere_ssp_uuids`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `external_stratosphere_ssp_uuids` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(255) NOT NULL COMMENT 'uuid provided by SSP',
  `obj_class` varchar(255) NOT NULL,
  `obj_id` bigint(20) NOT NULL,
  `reservation_id` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `external_stratosphere_ssp_uuids`
--

LOCK TABLES `external_stratosphere_ssp_uuids` WRITE;
/*!40000 ALTER TABLE `external_stratosphere_ssp_uuids` DISABLE KEYS */;
/*!40000 ALTER TABLE `external_stratosphere_ssp_uuids` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firewall_rules`
--

DROP TABLE IF EXISTS `firewall_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `firewall_rules` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `ip_address_id` bigint(20) unsigned DEFAULT NULL COMMENT 'id of the corresponding ip address',
  `start_port` int(10) DEFAULT NULL COMMENT 'starting port of a port range',
  `end_port` int(10) DEFAULT NULL COMMENT 'end port of a port range',
  `state` char(32) NOT NULL COMMENT 'current state of this rule',
  `protocol` char(16) NOT NULL DEFAULT 'TCP' COMMENT 'protocol to open these ports for',
  `purpose` char(32) NOT NULL COMMENT 'why are these ports opened?',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner id',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain id',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network id',
  `xid` char(40) NOT NULL COMMENT 'external id',
  `created` datetime DEFAULT NULL COMMENT 'Date created',
  `icmp_code` int(10) DEFAULT NULL COMMENT 'The ICMP code (if protocol=ICMP). A value of -1 means all codes for the given ICMP type.',
  `icmp_type` int(10) DEFAULT NULL COMMENT 'The ICMP type (if protocol=ICMP). A value of -1 means all types.',
  `related` bigint(20) unsigned DEFAULT NULL COMMENT 'related to what other firewall rule',
  `type` varchar(10) NOT NULL DEFAULT 'USER',
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vpc the firewall rule is associated with',
  `traffic_type` char(32) DEFAULT NULL COMMENT 'the traffic type of the rule, can be Ingress or Egress',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_firewall_rules__uuid` (`uuid`),
  KEY `fk_firewall_rules__ip_address_id` (`ip_address_id`),
  KEY `fk_firewall_rules__network_id` (`network_id`),
  KEY `fk_firewall_rules__account_id` (`account_id`),
  KEY `fk_firewall_rules__domain_id` (`domain_id`),
  KEY `fk_firewall_rules__related` (`related`),
  KEY `fk_firewall_rules__vpc_id` (`vpc_id`),
  KEY `i_firewall_rules__purpose` (`purpose`),
  CONSTRAINT `fk_firewall_rules__ip_address_id` FOREIGN KEY (`ip_address_id`) REFERENCES `user_ip_address` (`id`),
  CONSTRAINT `fk_firewall_rules__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_firewall_rules__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_firewall_rules__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_firewall_rules__related` FOREIGN KEY (`related`) REFERENCES `firewall_rules` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_firewall_rules__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firewall_rules`
--

LOCK TABLES `firewall_rules` WRITE;
/*!40000 ALTER TABLE `firewall_rules` DISABLE KEYS */;
/*!40000 ALTER TABLE `firewall_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `firewall_rules_cidrs`
--

DROP TABLE IF EXISTS `firewall_rules_cidrs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `firewall_rules_cidrs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `firewall_rule_id` bigint(20) unsigned NOT NULL COMMENT 'firewall rule id',
  `source_cidr` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_rule_cidrs` (`firewall_rule_id`,`source_cidr`),
  KEY `fk_firewall_cidrs_firewall_rules` (`firewall_rule_id`),
  CONSTRAINT `fk_firewall_cidrs_firewall_rules` FOREIGN KEY (`firewall_rule_id`) REFERENCES `firewall_rules` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `firewall_rules_cidrs`
--

LOCK TABLES `firewall_rules_cidrs` WRITE;
/*!40000 ALTER TABLE `firewall_rules_cidrs` DISABLE KEYS */;
/*!40000 ALTER TABLE `firewall_rules_cidrs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `free_ip_view`
--

DROP TABLE IF EXISTS `free_ip_view`;
/*!50001 DROP VIEW IF EXISTS `free_ip_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `free_ip_view` (
  `free_ip` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `global_load_balancer_lb_rule_map`
--

DROP TABLE IF EXISTS `global_load_balancer_lb_rule_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `global_load_balancer_lb_rule_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `gslb_rule_id` bigint(20) unsigned NOT NULL,
  `lb_rule_id` bigint(20) unsigned NOT NULL,
  `weight` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT 'weight of the site in gslb',
  `revoke` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 is when rule is set for Revoke',
  PRIMARY KEY (`id`),
  UNIQUE KEY `gslb_rule_id` (`gslb_rule_id`,`lb_rule_id`),
  KEY `fk_lb_rule_id` (`lb_rule_id`),
  CONSTRAINT `fk_gslb_rule_id` FOREIGN KEY (`gslb_rule_id`) REFERENCES `global_load_balancing_rules` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_lb_rule_id` FOREIGN KEY (`lb_rule_id`) REFERENCES `load_balancing_rules` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `global_load_balancer_lb_rule_map`
--

LOCK TABLES `global_load_balancer_lb_rule_map` WRITE;
/*!40000 ALTER TABLE `global_load_balancer_lb_rule_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `global_load_balancer_lb_rule_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `global_load_balancing_rules`
--

DROP TABLE IF EXISTS `global_load_balancing_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `global_load_balancing_rules` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'account id',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain id',
  `region_id` int(10) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(4096) DEFAULT NULL COMMENT 'description',
  `state` char(32) NOT NULL COMMENT 'current state of this rule',
  `algorithm` varchar(255) NOT NULL COMMENT 'load balancing algorithm used to distribbute traffic across zones',
  `persistence` varchar(255) NOT NULL COMMENT 'session persistence used across the zone',
  `service_type` varchar(255) NOT NULL COMMENT 'GSLB service type (tcp/udp)',
  `gslb_domain_name` varchar(255) NOT NULL COMMENT 'DNS name for the GSLB service that is used to provide a FQDN for the GSLB service',
  PRIMARY KEY (`id`),
  KEY `fk_global_load_balancing_rules_account_id` (`account_id`),
  KEY `fk_global_load_balancing_rules_region_id` (`region_id`),
  CONSTRAINT `fk_global_load_balancing_rules_account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_global_load_balancing_rules_region_id` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `global_load_balancing_rules`
--

LOCK TABLES `global_load_balancing_rules` WRITE;
/*!40000 ALTER TABLE `global_load_balancing_rules` DISABLE KEYS */;
/*!40000 ALTER TABLE `global_load_balancing_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest_os`
--

DROP TABLE IF EXISTS `guest_os`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest_os` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `category_id` bigint(20) unsigned NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `display_name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_guest_os__uuid` (`uuid`),
  KEY `fk_guest_os__category_id` (`category_id`),
  CONSTRAINT `fk_guest_os__category_id` FOREIGN KEY (`category_id`) REFERENCES `guest_os_category` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=225 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_os`
--

LOCK TABLES `guest_os` WRITE;
/*!40000 ALTER TABLE `guest_os` DISABLE KEYS */;
INSERT INTO `guest_os` VALUES (1,1,NULL,'4d86cc58-3e05-11e3-a27a-14109fdfd297','CentOS 4.5 (32-bit)'),(2,1,NULL,'4d86d1da-3e05-11e3-a27a-14109fdfd297','CentOS 4.6 (32-bit)'),(3,1,NULL,'4d86d668-3e05-11e3-a27a-14109fdfd297','CentOS 4.7 (32-bit)'),(4,1,NULL,'4d86dae7-3e05-11e3-a27a-14109fdfd297','CentOS 4.8 (32-bit)'),(5,1,NULL,'4d86df6c-3e05-11e3-a27a-14109fdfd297','CentOS 5.0 (32-bit)'),(6,1,NULL,'4d86e3f1-3e05-11e3-a27a-14109fdfd297','CentOS 5.0 (64-bit)'),(7,1,NULL,'4d86e96a-3e05-11e3-a27a-14109fdfd297','CentOS 5.1 (32-bit)'),(8,1,NULL,'4d86edf2-3e05-11e3-a27a-14109fdfd297','CentOS 5.1 (64-bit)'),(9,1,NULL,'4d86f278-3e05-11e3-a27a-14109fdfd297','CentOS 5.2 (32-bit)'),(10,1,NULL,'4d86f6f9-3e05-11e3-a27a-14109fdfd297','CentOS 5.2 (64-bit)'),(11,1,NULL,'4d86fb7c-3e05-11e3-a27a-14109fdfd297','CentOS 5.3 (32-bit)'),(12,1,NULL,'4d86fff8-3e05-11e3-a27a-14109fdfd297','CentOS 5.3 (64-bit)'),(13,1,NULL,'4d870480-3e05-11e3-a27a-14109fdfd297','CentOS 5.4 (32-bit)'),(14,1,NULL,'4d8708fa-3e05-11e3-a27a-14109fdfd297','CentOS 5.4 (64-bit)'),(15,2,NULL,'4d870d7f-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 5.0 (32-bit)'),(16,3,NULL,'4d871207-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.0 (32-bit)'),(17,3,NULL,'4d87168d-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.0 (64-bit)'),(18,3,NULL,'4d871b15-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.1 (32-bit)'),(19,3,NULL,'4d872034-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.1 (64-bit)'),(20,3,NULL,'4d872572-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.2 (32-bit)'),(21,3,NULL,'4d872da9-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.2 (64-bit)'),(22,3,NULL,'4d873505-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.3 (32-bit)'),(23,3,NULL,'4d873cb9-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.3 (64-bit)'),(24,3,NULL,'4d87439a-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.4 (32-bit)'),(25,3,NULL,'4d874b5e-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.4 (64-bit)'),(26,4,NULL,'4d8753f6-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 4.5 (32-bit)'),(27,4,NULL,'4d875c85-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 4.6 (32-bit)'),(28,4,NULL,'4d876550-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 4.7 (32-bit)'),(29,4,NULL,'4d876d9e-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 4.8 (32-bit)'),(30,4,NULL,'4d877764-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.0 (32-bit)'),(31,4,NULL,'4d877efc-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.0 (64-bit)'),(32,4,NULL,'4d8785bf-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.1 (32-bit)'),(33,4,NULL,'4d878e12-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.1 (64-bit)'),(34,4,NULL,'4d879535-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.2 (32-bit)'),(35,4,NULL,'4d879abc-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.2 (64-bit)'),(36,4,NULL,'4d879fa9-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.3 (32-bit)'),(37,4,NULL,'4d87a718-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.3 (64-bit)'),(38,4,NULL,'4d87b242-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.4 (32-bit)'),(39,4,NULL,'4d87b93c-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.4 (64-bit)'),(40,5,NULL,'4d87c037-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 9 SP4 (32-bit)'),(41,5,NULL,'4d87c721-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP1 (32-bit)'),(42,5,NULL,'4d87ce04-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP1 (64-bit)'),(43,5,NULL,'4d87d4c4-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP2 (32-bit)'),(44,5,NULL,'4d87df14-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP2 (64-bit)'),(45,5,NULL,'4d87e5eb-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP3 (64-bit)'),(46,5,NULL,'4d87edfb-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 (32-bit)'),(47,5,NULL,'4d87f450-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 (64-bit)'),(48,6,NULL,'4d87fcb9-3e05-11e3-a27a-14109fdfd297','Windows 7 (32-bit)'),(49,6,NULL,'4d8803bb-3e05-11e3-a27a-14109fdfd297','Windows 7 (64-bit)'),(50,6,NULL,'4d880d26-3e05-11e3-a27a-14109fdfd297','Windows Server 2003 Enterprise Edition(32-bit)'),(51,6,NULL,'4d8813fd-3e05-11e3-a27a-14109fdfd297','Windows Server 2003 Enterprise Edition(64-bit)'),(52,6,NULL,'4d881d3f-3e05-11e3-a27a-14109fdfd297','Windows Server 2008 (32-bit)'),(53,6,NULL,'4d882488-3e05-11e3-a27a-14109fdfd297','Windows Server 2008 (64-bit)'),(54,6,NULL,'4d882ab8-3e05-11e3-a27a-14109fdfd297','Windows Server 2008 R2 (64-bit)'),(55,6,NULL,'4d883154-3e05-11e3-a27a-14109fdfd297','Windows 2000 Server SP4 (32-bit)'),(56,6,NULL,'4d88370b-3e05-11e3-a27a-14109fdfd297','Windows Vista (32-bit)'),(57,6,NULL,'4d883f12-3e05-11e3-a27a-14109fdfd297','Windows XP SP2 (32-bit)'),(58,6,NULL,'4d8846b0-3e05-11e3-a27a-14109fdfd297','Windows XP SP3 (32-bit)'),(59,10,NULL,'4d884beb-3e05-11e3-a27a-14109fdfd297','Other Ubuntu (32-bit)'),(60,7,NULL,'4d8851d6-3e05-11e3-a27a-14109fdfd297','Other (32-bit)'),(61,6,NULL,'4d8858f0-3e05-11e3-a27a-14109fdfd297','Windows 2000 Server'),(62,6,NULL,'4d885f9e-3e05-11e3-a27a-14109fdfd297','Windows 98'),(63,6,NULL,'4d88673a-3e05-11e3-a27a-14109fdfd297','Windows 95'),(64,6,NULL,'4d886c72-3e05-11e3-a27a-14109fdfd297','Windows NT 4'),(65,6,NULL,'4d887373-3e05-11e3-a27a-14109fdfd297','Windows 3.1'),(66,4,NULL,'4d887962-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 3(32-bit)'),(67,4,NULL,'4d8880b5-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 3(64-bit)'),(68,7,NULL,'4d8887d8-3e05-11e3-a27a-14109fdfd297','Open Enterprise Server'),(69,7,NULL,'4d888f6c-3e05-11e3-a27a-14109fdfd297','Asianux 3(32-bit)'),(70,7,NULL,'4d889541-3e05-11e3-a27a-14109fdfd297','Asianux 3(64-bit)'),(72,2,NULL,'4d889f1a-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 5(64-bit)'),(73,2,NULL,'4d88a485-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 4(32-bit)'),(74,2,NULL,'4d88acbb-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 4(64-bit)'),(75,7,NULL,'4d88b24c-3e05-11e3-a27a-14109fdfd297','Other 2.6x Linux (32-bit)'),(76,7,NULL,'4d88b8d4-3e05-11e3-a27a-14109fdfd297','Other 2.6x Linux (64-bit)'),(77,8,NULL,'4d88bdc9-3e05-11e3-a27a-14109fdfd297','Novell Netware 6.x'),(78,8,NULL,'4d88c758-3e05-11e3-a27a-14109fdfd297','Novell Netware 5.1'),(79,9,NULL,'4d88cce9-3e05-11e3-a27a-14109fdfd297','Sun Solaris 10(32-bit)'),(80,9,NULL,'4d88d3ef-3e05-11e3-a27a-14109fdfd297','Sun Solaris 10(64-bit)'),(81,9,NULL,'4d88d92b-3e05-11e3-a27a-14109fdfd297','Sun Solaris 9(Experimental)'),(82,9,NULL,'4d88de53-3e05-11e3-a27a-14109fdfd297','Sun Solaris 8(Experimental)'),(83,9,NULL,'4d88e4dc-3e05-11e3-a27a-14109fdfd297','FreeBSD (32-bit)'),(84,9,NULL,'4d88ed60-3e05-11e3-a27a-14109fdfd297','FreeBSD (64-bit)'),(85,9,NULL,'4d88f52f-3e05-11e3-a27a-14109fdfd297','SCO OpenServer 5'),(86,9,NULL,'4d88fdf9-3e05-11e3-a27a-14109fdfd297','SCO UnixWare 7'),(87,6,NULL,'4d8903af-3e05-11e3-a27a-14109fdfd297','Windows Server 2003 DataCenter Edition(32-bit)'),(88,6,NULL,'4d890a54-3e05-11e3-a27a-14109fdfd297','Windows Server 2003 DataCenter Edition(64-bit)'),(89,6,NULL,'4d891324-3e05-11e3-a27a-14109fdfd297','Windows Server 2003 Standard Edition(32-bit)'),(90,6,NULL,'4d891ba6-3e05-11e3-a27a-14109fdfd297','Windows Server 2003 Standard Edition(64-bit)'),(91,6,NULL,'4d89264c-3e05-11e3-a27a-14109fdfd297','Windows Server 2003 Web Edition'),(92,6,NULL,'4d892df8-3e05-11e3-a27a-14109fdfd297','Microsoft Small Bussiness Server 2003'),(93,6,NULL,'4d8937fc-3e05-11e3-a27a-14109fdfd297','Windows XP (32-bit)'),(94,6,NULL,'4d893f7f-3e05-11e3-a27a-14109fdfd297','Windows XP (64-bit)'),(95,6,NULL,'4d89498e-3e05-11e3-a27a-14109fdfd297','Windows 2000 Advanced Server'),(96,5,NULL,'4d8950fe-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise 8(32-bit)'),(97,5,NULL,'4d895a87-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise 8(64-bit)'),(98,7,NULL,'4d896023-3e05-11e3-a27a-14109fdfd297','Other Linux (32-bit)'),(99,7,NULL,'4d896841-3e05-11e3-a27a-14109fdfd297','Other Linux (64-bit)'),(100,10,NULL,'4d897406-3e05-11e3-a27a-14109fdfd297','Other Ubuntu (64-bit)'),(101,6,NULL,'4d897c2f-3e05-11e3-a27a-14109fdfd297','Windows Vista (64-bit)'),(102,6,NULL,'4d898564-3e05-11e3-a27a-14109fdfd297','DOS'),(103,7,NULL,'4d898ebe-3e05-11e3-a27a-14109fdfd297','Other (64-bit)'),(104,7,NULL,'4d899709-3e05-11e3-a27a-14109fdfd297','OS/2'),(105,6,NULL,'4d89a0d8-3e05-11e3-a27a-14109fdfd297','Windows 2000 Professional'),(106,4,NULL,'4d89a9c5-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 4(64-bit)'),(107,5,NULL,'4d89b3ae-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise 9(32-bit)'),(108,5,NULL,'4d89bdf5-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise 9(64-bit)'),(109,5,NULL,'4d89c79a-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise 10(32-bit)'),(110,5,NULL,'4d89d0ab-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise 10(64-bit)'),(111,1,NULL,'4d89d8ac-3e05-11e3-a27a-14109fdfd297','CentOS 5.5 (32-bit)'),(112,1,NULL,'4d89e2b0-3e05-11e3-a27a-14109fdfd297','CentOS 5.5 (64-bit)'),(113,4,NULL,'4d89eb33-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.5 (32-bit)'),(114,4,NULL,'4d89f35d-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.5 (64-bit)'),(115,4,NULL,'4d89fb83-3e05-11e3-a27a-14109fdfd297','Fedora 13'),(116,4,NULL,'4d8a02dd-3e05-11e3-a27a-14109fdfd297','Fedora 12'),(117,4,NULL,'4d8a0a12-3e05-11e3-a27a-14109fdfd297','Fedora 11'),(118,4,NULL,'4d8a1153-3e05-11e3-a27a-14109fdfd297','Fedora 10'),(119,4,NULL,'4d8a1abf-3e05-11e3-a27a-14109fdfd297','Fedora 9'),(120,4,NULL,'4d8a21f6-3e05-11e3-a27a-14109fdfd297','Fedora 8'),(121,10,NULL,'4d8a2a0d-3e05-11e3-a27a-14109fdfd297','Ubuntu 10.04 (32-bit)'),(122,10,NULL,'4d8a3356-3e05-11e3-a27a-14109fdfd297','Ubuntu 9.10 (32-bit)'),(123,10,NULL,'4d8a3ace-3e05-11e3-a27a-14109fdfd297','Ubuntu 9.04 (32-bit)'),(124,10,NULL,'4d8a4423-3e05-11e3-a27a-14109fdfd297','Ubuntu 8.10 (32-bit)'),(125,10,NULL,'4d8a4c95-3e05-11e3-a27a-14109fdfd297','Ubuntu 8.04 (32-bit)'),(126,10,NULL,'4d8a563b-3e05-11e3-a27a-14109fdfd297','Ubuntu 10.04 (64-bit)'),(127,10,NULL,'4d8a60de-3e05-11e3-a27a-14109fdfd297','Ubuntu 9.10 (64-bit)'),(128,10,NULL,'4d8a6b07-3e05-11e3-a27a-14109fdfd297','Ubuntu 9.04 (64-bit)'),(129,10,NULL,'4d8a74d4-3e05-11e3-a27a-14109fdfd297','Ubuntu 8.10 (64-bit)'),(130,10,NULL,'4d8a7e96-3e05-11e3-a27a-14109fdfd297','Ubuntu 8.04 (64-bit)'),(131,4,NULL,'4d8a87d4-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 2'),(132,2,NULL,'4d8a9078-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 6(32-bit)'),(133,2,NULL,'4d8a9948-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 6(64-bit)'),(134,3,NULL,'4d8aa245-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.5 (32-bit)'),(135,3,NULL,'4d8aaa8c-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.5 (64-bit)'),(136,4,NULL,'4d8ab33e-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.0 (32-bit)'),(137,4,NULL,'4d8abb63-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.0 (64-bit)'),(138,7,NULL,'4d8ac381-3e05-11e3-a27a-14109fdfd297','None'),(139,7,NULL,'4d8acb68-3e05-11e3-a27a-14109fdfd297','Other PV (32-bit)'),(140,7,NULL,'4d8ad33c-3e05-11e3-a27a-14109fdfd297','Other PV (64-bit)'),(141,1,NULL,'4d8adb01-3e05-11e3-a27a-14109fdfd297','CentOS 5.6 (32-bit)'),(142,1,NULL,'4d8ae2ba-3e05-11e3-a27a-14109fdfd297','CentOS 5.6 (64-bit)'),(143,1,NULL,'4d8ae9da-3e05-11e3-a27a-14109fdfd297','CentOS 6.0 (32-bit)'),(144,1,NULL,'4d8af1a4-3e05-11e3-a27a-14109fdfd297','CentOS 6.0 (64-bit)'),(145,3,NULL,'4d8afa33-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.6 (32-bit)'),(146,3,NULL,'4d8b01c7-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.6 (64-bit)'),(147,3,NULL,'4d8b0839-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.0 (32-bit)'),(148,3,NULL,'4d8b103d-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.0 (64-bit)'),(149,4,NULL,'4d8b16b1-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.6 (32-bit)'),(150,4,NULL,'4d8b1b9e-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.6 (64-bit)'),(151,5,NULL,'4d8b207d-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP3 (32-bit)'),(152,5,NULL,'4d8b2637-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP4 (64-bit)'),(153,5,NULL,'4d8b2cce-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 10 SP4 (32-bit)'),(154,5,NULL,'4d8b367c-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 SP1 (64-bit)'),(155,5,NULL,'4d8b3b5d-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 SP1 (32-bit)'),(156,10,NULL,'4d8b402e-3e05-11e3-a27a-14109fdfd297','Ubuntu 10.10 (32-bit)'),(157,10,NULL,'4d8b4507-3e05-11e3-a27a-14109fdfd297','Ubuntu 10.10 (64-bit)'),(158,9,NULL,'4d8b49d7-3e05-11e3-a27a-14109fdfd297','Sun Solaris 11 (64-bit)'),(159,9,NULL,'4d8b4ea2-3e05-11e3-a27a-14109fdfd297','Sun Solaris 11 (32-bit)'),(160,6,NULL,'4d8b536e-3e05-11e3-a27a-14109fdfd297','Windows PV'),(161,1,NULL,'4d8b5841-3e05-11e3-a27a-14109fdfd297','CentOS 5.7 (32-bit)'),(162,1,NULL,'4d8b5ef9-3e05-11e3-a27a-14109fdfd297','CentOS 5.7 (64-bit)'),(163,10,NULL,'4d8b6628-3e05-11e3-a27a-14109fdfd297','Ubuntu 12.04 (32-bit)'),(164,10,NULL,'4d8b6bc2-3e05-11e3-a27a-14109fdfd297','Ubuntu 12.04 (64-bit)'),(165,6,NULL,'4d8b7172-3e05-11e3-a27a-14109fdfd297','Windows 8 (32-bit)'),(166,6,NULL,'4d8b7671-3e05-11e3-a27a-14109fdfd297','Windows 8 (64-bit)'),(167,6,NULL,'4d8b7b96-3e05-11e3-a27a-14109fdfd297','Windows Server 2012 (64-bit)'),(169,10,NULL,'4d8b8174-3e05-11e3-a27a-14109fdfd297','Ubuntu 11.04 (32-bit)'),(170,10,NULL,'4d8b877c-3e05-11e3-a27a-14109fdfd297','Ubuntu 11.04 (64-bit)'),(171,1,NULL,'4d8b8d55-3e05-11e3-a27a-14109fdfd297','CentOS 6.3 (32-bit)'),(172,1,NULL,'4d8b925b-3e05-11e3-a27a-14109fdfd297','CentOS 6.3 (64-bit)'),(173,1,NULL,'4d8b97e4-3e05-11e3-a27a-14109fdfd297','CentOS 5.8 (32-bit)'),(174,1,NULL,'4d8b9dd7-3e05-11e3-a27a-14109fdfd297','CentOS 5.8 (64-bit)'),(175,1,NULL,'4d8ba2f2-3e05-11e3-a27a-14109fdfd297','CentOS 5.9 (32-bit)'),(176,1,NULL,'4d8baa0c-3e05-11e3-a27a-14109fdfd297','CentOS 5.9 (64-bit)'),(177,1,NULL,'4d8bb0fa-3e05-11e3-a27a-14109fdfd297','CentOS 6.1 (32-bit)'),(178,1,NULL,'4d8bb5f8-3e05-11e3-a27a-14109fdfd297','CentOS 6.1 (64-bit)'),(179,1,NULL,'4d8bbac6-3e05-11e3-a27a-14109fdfd297','CentOS 6.2 (32-bit)'),(180,1,NULL,'4d8bbf8a-3e05-11e3-a27a-14109fdfd297','CentOS 6.2 (64-bit)'),(181,1,NULL,'4d8bc449-3e05-11e3-a27a-14109fdfd297','CentOS 6.4 (32-bit)'),(182,1,NULL,'4d8bcbaa-3e05-11e3-a27a-14109fdfd297','CentOS 6.4 (64-bit)'),(183,2,NULL,'4d8bd12f-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 7(32-bit)'),(184,2,NULL,'4d8bd61b-3e05-11e3-a27a-14109fdfd297','Debian GNU/Linux 7(64-bit)'),(185,5,NULL,'4d8bdaf5-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 SP2 (64-bit)'),(186,5,NULL,'4d8bdfcb-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 SP2 (32-bit)'),(187,5,NULL,'4d8be4a0-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 SP3 (64-bit)'),(188,5,NULL,'4d8beb33-3e05-11e3-a27a-14109fdfd297','SUSE Linux Enterprise Server 11 SP3 (32-bit)'),(189,4,NULL,'4d8bf2d2-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.7 (32-bit)'),(190,4,NULL,'4d8bfa09-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.7 (64-bit)'),(191,4,NULL,'4d8c013f-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.8 (32-bit)'),(192,4,NULL,'4d8c085c-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.8 (64-bit)'),(193,4,NULL,'4d8c0fb3-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.9 (32-bit)'),(194,4,NULL,'4d8c16d8-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 5.9 (64-bit)'),(195,4,NULL,'4d8c1cc2-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.1 (32-bit)'),(196,4,NULL,'4d8c21ae-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.1 (64-bit)'),(197,4,NULL,'4d8c26f0-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.2 (32-bit)'),(198,4,NULL,'4d8c2d2f-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.2 (64-bit)'),(199,4,NULL,'4d8c339d-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.3 (32-bit)'),(200,1,NULL,'4d8ca235-3e05-11e3-a27a-14109fdfd297','Other CentOS (32-bit)'),(201,1,NULL,'4d8ca70c-3e05-11e3-a27a-14109fdfd297','Other CentOS (64-bit)'),(202,5,NULL,'4d8cacac-3e05-11e3-a27a-14109fdfd297','Other SUSE Linux(32-bit)'),(203,5,NULL,'4d8cb1ae-3e05-11e3-a27a-14109fdfd297','Other SUSE Linux(64-bit)'),(204,4,NULL,'4d8c38f3-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.3 (64-bit)'),(205,4,NULL,'4d8c3dff-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.4 (32-bit)'),(206,4,NULL,'4f30fe59-3e05-11e3-a27a-14109fdfd297','Red Hat Enterprise Linux 6.4 (64-bit)'),(207,3,NULL,'4d8c48ec-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.7 (32-bit)'),(208,3,NULL,'4d8c4db6-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.7 (64-bit)'),(209,3,NULL,'4d8c5298-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.8 (32-bit)'),(210,3,NULL,'4d8c5765-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.8 (64-bit)'),(211,3,NULL,'4d8c5c26-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.9 (32-bit)'),(212,3,NULL,'4d8c60e5-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 5.9 (64-bit)'),(213,3,NULL,'4d8c659d-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.1 (32-bit)'),(214,3,NULL,'4d8c6cbc-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.1 (64-bit)'),(215,3,NULL,'4d8c71d7-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.2 (32-bit)'),(216,3,NULL,'4d8c7697-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.2 (64-bit)'),(217,3,NULL,'4d8c7b53-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.3 (32-bit)'),(218,3,NULL,'4d8c800d-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.3 (64-bit)'),(219,3,NULL,'4d8c84c9-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.4 (32-bit)'),(220,3,NULL,'4d8c897d-3e05-11e3-a27a-14109fdfd297','Oracle Enterprise Linux 6.4 (64-bit)'),(221,7,NULL,'4d8c8f30-3e05-11e3-a27a-14109fdfd297','Apple Mac OS X 10.6 (32-bit)'),(222,7,NULL,'4d8c93f9-3e05-11e3-a27a-14109fdfd297','Apple Mac OS X 10.6 (64-bit)'),(223,7,NULL,'4d8c98b8-3e05-11e3-a27a-14109fdfd297','Apple Mac OS X 10.7 (32-bit)'),(224,7,NULL,'4d8c9d6e-3e05-11e3-a27a-14109fdfd297','Apple Mac OS X 10.7 (64-bit)');
/*!40000 ALTER TABLE `guest_os` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest_os_category`
--

DROP TABLE IF EXISTS `guest_os_category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest_os_category` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_guest_os_category__uuid` (`uuid`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_os_category`
--

LOCK TABLES `guest_os_category` WRITE;
/*!40000 ALTER TABLE `guest_os_category` DISABLE KEYS */;
INSERT INTO `guest_os_category` VALUES (1,'CentOS','4d869797-3e05-11e3-a27a-14109fdfd297'),(2,'Debian','4d869c6c-3e05-11e3-a27a-14109fdfd297'),(3,'Oracle','4d86a0fc-3e05-11e3-a27a-14109fdfd297'),(4,'RedHat','4d86a57f-3e05-11e3-a27a-14109fdfd297'),(5,'SUSE','4d86aa04-3e05-11e3-a27a-14109fdfd297'),(6,'Windows','4d86ae85-3e05-11e3-a27a-14109fdfd297'),(7,'Other','4d86b305-3e05-11e3-a27a-14109fdfd297'),(8,'Novel','4d86b850-3e05-11e3-a27a-14109fdfd297'),(9,'Unix','4d86bcff-3e05-11e3-a27a-14109fdfd297'),(10,'Ubuntu','4d86c15b-3e05-11e3-a27a-14109fdfd297'),(11,'None','4d86c5b5-3e05-11e3-a27a-14109fdfd297');
/*!40000 ALTER TABLE `guest_os_category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `guest_os_hypervisor`
--

DROP TABLE IF EXISTS `guest_os_hypervisor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `guest_os_hypervisor` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `hypervisor_type` varchar(32) NOT NULL,
  `guest_os_name` varchar(255) NOT NULL,
  `guest_os_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=330 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `guest_os_hypervisor`
--

LOCK TABLES `guest_os_hypervisor` WRITE;
/*!40000 ALTER TABLE `guest_os_hypervisor` DISABLE KEYS */;
INSERT INTO `guest_os_hypervisor` VALUES (1,'XenServer','CentOS 4.5 (32-bit)',1),(2,'XenServer','CentOS 4.6 (32-bit)',2),(3,'XenServer','CentOS 4.7 (32-bit)',3),(4,'XenServer','CentOS 4.8 (32-bit)',4),(5,'XenServer','CentOS 5.0 (32-bit)',5),(6,'XenServer','CentOS 5.0 (64-bit)',6),(7,'XenServer','CentOS 5.1 (32-bit)',7),(8,'XenServer','CentOS 5.1 (32-bit)',8),(9,'XenServer','CentOS 5.2 (32-bit)',9),(10,'XenServer','CentOS 5.2 (64-bit)',10),(11,'XenServer','CentOS 5.3 (32-bit)',11),(12,'XenServer','CentOS 5.3 (64-bit)',12),(13,'XenServer','CentOS 5.4 (32-bit)',13),(14,'XenServer','CentOS 5.4 (64-bit)',14),(15,'XenServer','CentOS 5.5 (32-bit)',111),(16,'XenServer','CentOS 5.5 (64-bit)',112),(17,'XenServer','CentOS 5.6 (32-bit)',141),(18,'XenServer','CentOS 5.6 (64-bit)',142),(19,'XenServer','CentOS 5.7 (32-bit)',161),(20,'XenServer','CentOS 5.7 (64-bit)',162),(21,'XenServer','CentOS 5.8 (32-bit)',173),(22,'XenServer','CentOS 5.8 (64-bit)',174),(23,'XenServer','CentOS 5.9 (32-bit)',175),(24,'XenServer','CentOS 5.9 (64-bit)',176),(25,'XenServer','CentOS 6.0 (32-bit)',143),(26,'XenServer','CentOS 6.0 (64-bit)',144),(27,'XenServer','CentOS 6.1 (32-bit)',177),(28,'XenServer','CentOS 6.1 (64-bit)',178),(29,'XenServer','CentOS 6.2 (32-bit)',179),(30,'XenServer','CentOS 6.2 (64-bit)',180),(31,'XenServer','CentOS 6.3 (32-bit)',171),(32,'XenServer','CentOS 6.3 (64-bit)',172),(33,'XenServer','CentOS 6.4 (32-bit)',181),(34,'XenServer','CentOS 6.4 (64-bit)',182),(35,'XenServer','Debian Lenny 5.0 (32-bit)',15),(36,'XenServer','Oracle Enterprise Linux 5.0 (32-bit)',16),(37,'XenServer','Oracle Enterprise Linux 5.0 (64-bit)',17),(38,'XenServer','Oracle Enterprise Linux 5.1 (32-bit)',18),(39,'XenServer','Oracle Enterprise Linux 5.1 (64-bit)',19),(40,'XenServer','Oracle Enterprise Linux 5.2 (32-bit)',20),(41,'XenServer','Oracle Enterprise Linux 5.2 (64-bit)',21),(42,'XenServer','Oracle Enterprise Linux 5.3 (32-bit)',22),(43,'XenServer','Oracle Enterprise Linux 5.3 (64-bit)',23),(44,'XenServer','Oracle Enterprise Linux 5.4 (32-bit)',24),(45,'XenServer','Oracle Enterprise Linux 5.4 (64-bit)',25),(46,'XenServer','Red Hat Enterprise Linux 4.5 (32-bit)',26),(47,'XenServer','Red Hat Enterprise Linux 4.6 (32-bit)',27),(48,'XenServer','Red Hat Enterprise Linux 4.7 (32-bit)',28),(49,'XenServer','Red Hat Enterprise Linux 4.8 (32-bit)',29),(50,'XenServer','Red Hat Enterprise Linux 5.0 (32-bit)',30),(51,'XenServer','Red Hat Enterprise Linux 5.0 (64-bit)',31),(52,'XenServer','Red Hat Enterprise Linux 5.1 (32-bit)',32),(53,'XenServer','Red Hat Enterprise Linux 5.1 (64-bit)',33),(54,'XenServer','Red Hat Enterprise Linux 5.2 (32-bit)',34),(55,'XenServer','Red Hat Enterprise Linux 5.2 (64-bit)',35),(56,'XenServer','Red Hat Enterprise Linux 5.3 (32-bit)',36),(57,'XenServer','Red Hat Enterprise Linux 5.3 (64-bit)',37),(58,'XenServer','Red Hat Enterprise Linux 5.4 (32-bit)',38),(59,'XenServer','Red Hat Enterprise Linux 5.4 (64-bit)',39),(60,'XenServer','SUSE Linux Enterprise Server 9 SP4 (32-bit)',40),(61,'XenServer','SUSE Linux Enterprise Server 10 SP1 (32-bit)',41),(62,'XenServer','SUSE Linux Enterprise Server 10 SP1 (64-bit)',42),(63,'XenServer','SUSE Linux Enterprise Server 10 SP2 (32-bit)',43),(64,'XenServer','SUSE Linux Enterprise Server 10 SP2 (64-bit)',44),(65,'XenServer','SUSE Linux Enterprise Server 10 SP3 (64-bit)',45),(66,'XenServer','SUSE Linux Enterprise Server 11 (32-bit)',46),(67,'XenServer','SUSE Linux Enterprise Server 11 (64-bit)',47),(68,'XenServer','Windows 7 (32-bit)',48),(69,'XenServer','Windows 7 (64-bit)',49),(70,'XenServer','Windows Server 2003 (32-bit)',50),(71,'XenServer','Windows Server 2003 (64-bit)',51),(72,'XenServer','Windows Server 2008 (32-bit)',52),(73,'XenServer','Windows Server 2008 (64-bit)',53),(74,'XenServer','Windows Server 2008 R2 (64-bit)',54),(75,'XenServer','Windows 2000 SP4 (32-bit)',55),(76,'XenServer','Windows Vista (32-bit)',56),(77,'XenServer','Windows XP SP2 (32-bit)',57),(78,'XenServer','Windows XP SP3 (32-bit)',58),(79,'XenServer','Other install media',59),(80,'XenServer','Other install media',100),(81,'XenServer','Other install media',60),(82,'XenServer','Other install media',103),(83,'XenServer','Other install media',121),(84,'XenServer','Other install media',126),(85,'XenServer','Other install media',122),(86,'XenServer','Other install media',127),(87,'XenServer','Other install media',123),(88,'XenServer','Other install media',128),(89,'XenServer','Other install media',124),(90,'XenServer','Other install media',129),(91,'XenServer','Other install media',125),(92,'XenServer','Other install media',130),(93,'XenServer','Other PV (32-bit)',139),(94,'XenServer','Other PV (64-bit)',140),(95,'XenServer','Windows 8 (32-bit)',165),(96,'XenServer','Windows 8 (64-bit)',166),(97,'XenServer','Windows Server 2012 (64-bit)',167),(98,'VmWare','Microsoft Windows 7(32-bit)',48),(99,'VmWare','Microsoft Windows 7(64-bit)',49),(100,'VmWare','Microsoft Windows Server 2008 R2(64-bit)',54),(101,'VmWare','Microsoft Windows Server 2008(32-bit)',52),(102,'VmWare','Microsoft Windows Server 2008(64-bit)',53),(103,'VmWare','Microsoft Windows Server 2003, Enterprise Edition (32-bit)',50),(104,'VmWare','Microsoft Windows Server 2003, Enterprise Edition (64-bit)',51),(105,'VmWare','Microsoft Windows Server 2003, Datacenter Edition (32-bit)',87),(106,'VmWare','Microsoft Windows Server 2003, Datacenter Edition (64-bit)',88),(107,'VmWare','Microsoft Windows Server 2003, Standard Edition (32-bit)',89),(108,'VmWare','Microsoft Windows Server 2003, Standard Edition (64-bit)',90),(109,'VmWare','Microsoft Windows Server 2003, Web Edition',91),(110,'VmWare','Microsoft Small Bussiness Server 2003',92),(111,'VmWare','Microsoft Windows Vista (32-bit)',56),(112,'VmWare','Microsoft Windows Vista (64-bit)',101),(113,'VmWare','Microsoft Windows XP Professional (32-bit)',93),(114,'VmWare','Microsoft Windows XP Professional (32-bit)',57),(115,'VmWare','Microsoft Windows XP Professional (32-bit)',58),(116,'VmWare','Microsoft Windows XP Professional (64-bit)',94),(117,'VmWare','Microsoft Windows 2000 Advanced Server',95),(118,'VmWare','Microsoft Windows 2000 Server',61),(119,'VmWare','Microsoft Windows 2000 Professional',105),(120,'VmWare','Microsoft Windows 2000 Server',55),(121,'VmWare','Microsoft Windows 98',62),(122,'VmWare','Microsoft Windows 95',63),(123,'VmWare','Microsoft Windows NT 4',64),(124,'VmWare','Microsoft Windows 3.1',65),(125,'VmWare','Windows 8 (32-bit)',165),(126,'VmWare','Windows 8 (64-bit)',166),(127,'VmWare','Windows Server 2012 (64-bit)',167),(128,'VmWare','Red Hat Enterprise Linux 5.0(32-bit)',30),(129,'VmWare','Red Hat Enterprise Linux 5.1(32-bit)',32),(130,'VmWare','Red Hat Enterprise Linux 5.2(32-bit)',34),(131,'VmWare','Red Hat Enterprise Linux 5.3(32-bit)',36),(132,'VmWare','Red Hat Enterprise Linux 5.4(32-bit)',38),(133,'VmWare','Red Hat Enterprise Linux 5.0(64-bit)',31),(134,'VmWare','Red Hat Enterprise Linux 5.1(64-bit)',33),(135,'VmWare','Red Hat Enterprise Linux 5.2(64-bit)',35),(136,'VmWare','Red Hat Enterprise Linux 5.3(64-bit)',37),(137,'VmWare','Red Hat Enterprise Linux 5.4(64-bit)',39),(138,'VmWare','Red Hat Enterprise Linux 4.5(32-bit)',26),(139,'VmWare','Red Hat Enterprise Linux 4.6(32-bit)',27),(140,'VmWare','Red Hat Enterprise Linux 4.7(32-bit)',28),(141,'VmWare','Red Hat Enterprise Linux 4.8(32-bit)',29),(142,'VmWare','Red Hat Enterprise Linux 4(64-bit)',106),(143,'VmWare','Red Hat Enterprise Linux 3(32-bit)',66),(144,'VmWare','Red Hat Enterprise Linux 3(64-bit)',67),(145,'VmWare','Red Hat Enterprise Linux 2',131),(146,'VmWare','Red Hat Enterprise Linux 6(32-bit)',136),(147,'VmWare','Red Hat Enterprise Linux 6(64-bit)',137),(148,'VmWare','Suse Linux Enterprise 11(32-bit)',46),(149,'VmWare','Suse Linux Enterprise 11(64-bit)',47),(150,'VmWare','Suse Linux Enterprise 10(32-bit)',41),(151,'VmWare','Suse Linux Enterprise 10(32-bit)',43),(152,'VmWare','Suse Linux Enterprise 10(64-bit)',42),(153,'VmWare','Suse Linux Enterprise 10(64-bit)',44),(154,'VmWare','Suse Linux Enterprise 10(64-bit)',45),(155,'VmWare','Suse Linux Enterprise 10(32-bit)',109),(156,'VmWare','Suse Linux Enterprise 10(64-bit)',110),(157,'VmWare','Suse Linux Enterprise 8/9(32-bit)',40),(158,'VmWare','Suse Linux Enterprise 8/9(32-bit)',96),(159,'VmWare','Suse Linux Enterprise 8/9(64-bit)',97),(160,'VmWare','Suse Linux Enterprise 8/9(32-bit)',107),(161,'VmWare','Suse Linux Enterprise 8/9(64-bit)',108),(162,'VmWare','Other Suse Linux Enterprise(32-bit)',202),(163,'VmWare','Other Suse Linux Enterprise(64-bit)',203),(164,'VmWare','Open Enterprise Server',68),(165,'VmWare','Asianux 3(32-bit)',69),(166,'VmWare','Asianux 3(64-bit)',70),(167,'VmWare','Debian GNU/Linux 5(32-bit)',15),(168,'VmWare','Debian GNU/Linux 5(64-bit)',72),(169,'VmWare','Debian GNU/Linux 4(32-bit)',73),(170,'VmWare','Debian GNU/Linux 4(64-bit)',74),(171,'VmWare','Ubuntu 12.04 (32-bit)',162),(172,'VmWare','Ubuntu 10.04 (32-bit)',121),(173,'VmWare','Ubuntu 9.10 (32-bit)',122),(174,'VmWare','Ubuntu 9.04 (32-bit)',123),(175,'VmWare','Ubuntu 8.10 (32-bit)',124),(176,'VmWare','Ubuntu 8.04 (32-bit)',125),(177,'VmWare','Ubuntu 12.04 (64-bit)',163),(178,'VmWare','Ubuntu 10.04 (64-bit)',126),(179,'VmWare','Ubuntu 9.10 (64-bit)',127),(180,'VmWare','Ubuntu 9.04 (64-bit)',128),(181,'VmWare','Ubuntu 8.10 (64-bit)',129),(182,'VmWare','Ubuntu 8.04 (64-bit)',130),(183,'VmWare','Ubuntu 10.10 (32-bit)',59),(184,'VmWare','Ubuntu 10.10 (64-bit)',100),(185,'VmWare','Other Ubuntu Linux (32-bit)',59),(186,'VmWare','Other Ubuntu (64-bit)',100),(187,'VmWare','Other 2.6x Linux (32-bit)',75),(188,'VmWare','Other 2.6x Linux (64-bit)',76),(189,'VmWare','Other Linux (32-bit)',98),(190,'VmWare','Other Linux (64-bit)',99),(191,'VmWare','Novell Netware 6.x',77),(192,'VmWare','Novell Netware 5.1',78),(193,'VmWare','Sun Solaris 10(32-bit)',79),(194,'VmWare','Sun Solaris 10(64-bit)',80),(195,'VmWare','Sun Solaris 9(Experimental)',81),(196,'VmWare','Sun Solaris 8(Experimental)',82),(197,'VmWare','FreeBSD (32-bit)',83),(198,'VmWare','FreeBSD (64-bit)',84),(199,'VmWare','OS/2',104),(200,'VmWare','SCO OpenServer 5',85),(201,'VmWare','SCO UnixWare 7',86),(202,'VmWare','DOS',102),(203,'VmWare','Other (32-bit)',60),(204,'VmWare','Other (64-bit)',103),(205,'VmWare','CentOS (32-bit)',200),(206,'VmWare','CentOS (64-bit)',201),(207,'KVM','CentOS 4.5',1),(208,'KVM','CentOS 4.6',2),(209,'KVM','CentOS 4.7',3),(210,'KVM','CentOS 4.8',4),(211,'KVM','CentOS 5.0',5),(212,'KVM','CentOS 5.0',6),(213,'KVM','CentOS 5.1',7),(214,'KVM','CentOS 5.1',8),(215,'KVM','CentOS 5.2',9),(216,'KVM','CentOS 5.2',10),(217,'KVM','CentOS 5.3',11),(218,'KVM','CentOS 5.3',12),(219,'KVM','CentOS 5.4',13),(220,'KVM','CentOS 5.4',14),(221,'KVM','CentOS 5.5',111),(222,'KVM','CentOS 5.5',112),(223,'KVM','Red Hat Enterprise Linux 4.5',26),(224,'KVM','Red Hat Enterprise Linux 4.6',27),(225,'KVM','Red Hat Enterprise Linux 4.7',28),(226,'KVM','Red Hat Enterprise Linux 4.8',29),(227,'KVM','Red Hat Enterprise Linux 5.0',30),(228,'KVM','Red Hat Enterprise Linux 5.0',31),(229,'KVM','Red Hat Enterprise Linux 5.1',32),(230,'KVM','Red Hat Enterprise Linux 5.1',33),(231,'KVM','Red Hat Enterprise Linux 5.2',34),(232,'KVM','Red Hat Enterprise Linux 5.2',35),(233,'KVM','Red Hat Enterprise Linux 5.3',36),(234,'KVM','Red Hat Enterprise Linux 5.3',37),(235,'KVM','Red Hat Enterprise Linux 5.4',38),(236,'KVM','Red Hat Enterprise Linux 5.4',39),(237,'KVM','Red Hat Enterprise Linux 5.5',113),(238,'KVM','Red Hat Enterprise Linux 5.5',114),(239,'KVM','Red Hat Enterprise Linux 4',106),(240,'KVM','Red Hat Enterprise Linux 3',66),(241,'KVM','Red Hat Enterprise Linux 3',67),(242,'KVM','Red Hat Enterprise Linux 2',131),(243,'KVM','Fedora 13',115),(244,'KVM','Fedora 12',116),(245,'KVM','Fedora 11',117),(246,'KVM','Fedora 10',118),(247,'KVM','Fedora 9',119),(248,'KVM','Fedora 8',120),(249,'KVM','Ubuntu 10.04',121),(250,'KVM','Ubuntu 10.04',126),(251,'KVM','Ubuntu 10.04',162),(252,'KVM','Ubuntu 10.04',163),(253,'KVM','Ubuntu 9.10',122),(254,'KVM','Ubuntu 9.10',127),(255,'KVM','Ubuntu 9.04',123),(256,'KVM','Ubuntu 9.04',128),(257,'KVM','Ubuntu 8.10',124),(258,'KVM','Ubuntu 8.10',129),(259,'KVM','Ubuntu 8.04',125),(260,'KVM','Ubuntu 8.04',130),(261,'KVM','Debian GNU/Linux 5',15),(262,'KVM','Debian GNU/Linux 5',72),(263,'KVM','Debian GNU/Linux 4',73),(264,'KVM','Debian GNU/Linux 4',74),(265,'KVM','Other Linux 2.6x',75),(266,'KVM','Other Linux 2.6x',76),(267,'KVM','Other Ubuntu',59),(268,'KVM','Other Ubuntu',100),(269,'KVM','Other Linux',98),(270,'KVM','Other Linux',99),(271,'KVM','Windows 7',48),(272,'KVM','Windows 7',49),(273,'KVM','Windows Server 2003',50),(274,'KVM','Windows Server 2003',51),(275,'KVM','Windows Server 2003',87),(276,'KVM','Windows Server 2003',88),(277,'KVM','Windows Server 2003',89),(278,'KVM','Windows Server 2003',90),(279,'KVM','Windows Server 2003',91),(280,'KVM','Windows Server 2003',92),(281,'KVM','Windows Server 2008',52),(282,'KVM','Windows Server 2008',53),(283,'KVM','Windows 2000',55),(284,'KVM','Windows 2000',61),(285,'KVM','Windows 2000',95),(286,'KVM','Windows 98',62),(287,'KVM','Windows Vista',56),(288,'KVM','Windows Vista',101),(289,'KVM','Windows XP SP2',57),(290,'KVM','Windows XP SP3',58),(291,'KVM','Windows XP ',93),(292,'KVM','Windows XP ',94),(293,'KVM','DOS',102),(294,'KVM','Other',60),(295,'KVM','Other',103),(296,'VmWare','Windows 8 (32-bit)',165),(297,'VmWare','Windows 8 (64-bit)',166),(298,'VmWare','Windows Server 2012 (64-bit)',167),(300,'XenServer','Windows 8 (32-bit)',165),(301,'XenServer','Windows 8 (64-bit)',166),(302,'XenServer','Windows Server 2012 (64-bit)',167),(304,'XenServer','CentOS 5.5 (32-bit)',111),(305,'XenServer','CentOS 5.5 (64-bit)',112),(306,'XenServer','CentOS 5.6 (32-bit)',141),(307,'XenServer','CentOS 5.6 (64-bit)',142),(308,'XenServer','CentOS 5.7 (32-bit)',161),(309,'XenServer','CentOS 5.7 (64-bit)',162),(310,'XenServer','CentOS 5.8 (32-bit)',173),(311,'XenServer','CentOS 5.8 (64-bit)',174),(312,'XenServer','CentOS 5.9 (32-bit)',175),(313,'XenServer','CentOS 5.9 (64-bit)',176),(314,'XenServer','CentOS 6.0 (32-bit)',143),(315,'XenServer','CentOS 6.0 (64-bit)',144),(316,'XenServer','CentOS 6.1 (32-bit)',177),(317,'XenServer','CentOS 6.1 (64-bit)',178),(318,'XenServer','CentOS 6.2 (32-bit)',179),(319,'XenServer','CentOS 6.2 (64-bit)',180),(320,'XenServer','CentOS 6.3 (32-bit)',171),(321,'XenServer','CentOS 6.3 (64-bit)',172),(322,'XenServer','CentOS 6.4 (32-bit)',181),(323,'XenServer','CentOS 6.4 (64-bit)',182),(324,'XenServer','Debian GNU/Linux 7(32-bit)',183),(325,'XenServer','Debian GNU/Linux 7(64-bit)',184),(326,'VmWare','Apple Mac OS X 10.6 (32-bit)',221),(327,'VmWare','Apple Mac OS X 10.6 (64-bit)',222),(328,'VmWare','Apple Mac OS X 10.7 (32-bit)',223),(329,'VmWare','Apple Mac OS X 10.7 (64-bit)',224);
/*!40000 ALTER TABLE `guest_os_hypervisor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host`
--

DROP TABLE IF EXISTS `host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL COMMENT 'this uuid is different with guid below, the later one is used by hypervisor resource',
  `status` varchar(32) NOT NULL,
  `type` varchar(32) NOT NULL,
  `private_ip_address` char(40) NOT NULL,
  `private_netmask` varchar(15) DEFAULT NULL,
  `private_mac_address` varchar(17) DEFAULT NULL,
  `storage_ip_address` char(40) DEFAULT NULL,
  `storage_netmask` varchar(15) DEFAULT NULL,
  `storage_mac_address` varchar(17) DEFAULT NULL,
  `storage_ip_address_2` char(40) DEFAULT NULL,
  `storage_mac_address_2` varchar(17) DEFAULT NULL,
  `storage_netmask_2` varchar(15) DEFAULT NULL,
  `cluster_id` bigint(20) unsigned DEFAULT NULL COMMENT 'foreign key to cluster',
  `public_ip_address` char(40) DEFAULT NULL,
  `public_netmask` varchar(15) DEFAULT NULL,
  `public_mac_address` varchar(17) DEFAULT NULL,
  `proxy_port` int(10) unsigned DEFAULT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `pod_id` bigint(20) unsigned DEFAULT NULL,
  `cpus` int(10) unsigned DEFAULT NULL,
  `speed` int(10) unsigned DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL COMMENT 'iqn for the servers',
  `fs_type` varchar(32) DEFAULT NULL,
  `hypervisor_type` varchar(32) DEFAULT NULL COMMENT 'hypervisor type, can be NONE for storage',
  `hypervisor_version` varchar(32) DEFAULT NULL COMMENT 'hypervisor version',
  `ram` bigint(20) unsigned DEFAULT NULL,
  `resource` varchar(255) DEFAULT NULL COMMENT 'If it is a local resource, this is the class name',
  `version` varchar(40) NOT NULL,
  `parent` varchar(255) DEFAULT NULL COMMENT 'parent path for the storage server',
  `total_size` bigint(20) unsigned DEFAULT NULL COMMENT 'TotalSize',
  `capabilities` varchar(255) DEFAULT NULL COMMENT 'host capabilities in comma separated list',
  `guid` varchar(255) DEFAULT NULL,
  `available` int(1) unsigned NOT NULL DEFAULT '1' COMMENT 'Is this host ready for more resources?',
  `setup` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is this host already setup?',
  `dom0_memory` bigint(20) unsigned NOT NULL COMMENT 'memory used by dom0 for computing and routing servers',
  `last_ping` int(10) unsigned NOT NULL COMMENT 'time in seconds from the start of machine of the last ping',
  `mgmt_server_id` bigint(20) unsigned DEFAULT NULL COMMENT 'ManagementServer this host is connected to.',
  `disconnected` datetime DEFAULT NULL COMMENT 'Time this was disconnected',
  `created` datetime DEFAULT NULL COMMENT 'date the host first signed on',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `update_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'atomic increase count making status update operation atomical',
  `resource_state` varchar(32) NOT NULL DEFAULT 'Enabled' COMMENT 'Is this host enabled for allocation for new resources',
  `owner` varchar(255) DEFAULT NULL,
  `lastUpdated` datetime DEFAULT NULL COMMENT 'last updated',
  `engine_state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'the engine state of the zone',
  PRIMARY KEY (`id`),
  UNIQUE KEY `guid` (`guid`),
  UNIQUE KEY `uc_host__uuid` (`uuid`),
  KEY `i_host__removed` (`removed`),
  KEY `i_host__last_ping` (`last_ping`),
  KEY `i_host__status` (`status`),
  KEY `i_host__data_center_id` (`data_center_id`),
  KEY `i_host__pod_id` (`pod_id`),
  KEY `fk_host__cluster_id` (`cluster_id`),
  CONSTRAINT `fk_host__cluster_id` FOREIGN KEY (`cluster_id`) REFERENCES `cluster` (`id`),
  CONSTRAINT `fk_host__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host`
--

LOCK TABLES `host` WRITE;
/*!40000 ALTER TABLE `host` DISABLE KEYS */;
INSERT INTO `host` VALUES (1,'xenserver1','157c8777-62dd-4774-abd2-6a99fe6de4df','Up','Routing','192.168.3.117','255.255.255.0','52:54:00:12:34:01','192.168.3.117','255.255.255.0','52:54:00:12:34:01',NULL,NULL,NULL,1,'192.168.3.117','255.255.255.0','52:54:00:12:34:01',NULL,1,1,1,4100,'iqn.2013-09.com.example:220dd137',NULL,'XenServer','6.2.0',7546988736,'com.cloud.hypervisor.xen.resource.XenServer620Resource','1382769364508',NULL,NULL,'xen-3.0-x86_64 , xen-3.0-x86_32p , hvm-3.0-x86_32 , hvm-3.0-x86_32p , hvm-3.0-x86_64','14bc9042-dd55-4579-a420-4265017946f1',1,1,0,1350360417,22061634278039,NULL,'2013-10-26 06:36:04',NULL,2,'Enabled',NULL,NULL,'Disabled');
/*!40000 ALTER TABLE `host` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host_details`
--

DROP TABLE IF EXISTS `host_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id',
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_host_id_name` (`host_id`,`name`),
  KEY `fk_host_details__host_id` (`host_id`),
  CONSTRAINT `fk_host_details__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host_details`
--

LOCK TABLES `host_details` WRITE;
/*!40000 ALTER TABLE `host_details` DISABLE KEYS */;
INSERT INTO `host_details` VALUES (1,1,'product_version','6.2.0'),(2,1,'private.network.device','Pool-wide network associated with eth0'),(3,1,'com.cloud.network.Networks.RouterPrivateIpStrategy','DcGlobal'),(4,1,'Hypervisor.Version','4.1.5'),(5,1,'Host.OS','XenServer'),(6,1,'Host.OS.Kernel.Version','2.6.32.43-0.4.1.xs1.8.0.835.170778xen'),(7,1,'wait','600'),(8,1,'password','asdf1234'),(9,1,'url','192.168.3.117'),(10,1,'username','root'),(11,1,'product_brand','XenServer'),(12,1,'product_version_text_short','6.2'),(13,1,'can_bridge_firewall','false'),(14,1,'Host.OS.Version','6.2.0'),(15,1,'instance.name','VM');
/*!40000 ALTER TABLE `host_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host_pod_ref`
--

DROP TABLE IF EXISTS `host_pod_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host_pod_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `gateway` varchar(255) NOT NULL COMMENT 'gateway for the pod',
  `cidr_address` varchar(15) NOT NULL COMMENT 'CIDR address for the pod',
  `cidr_size` bigint(20) unsigned NOT NULL COMMENT 'CIDR size for the pod',
  `description` varchar(255) DEFAULT NULL COMMENT 'store private ip range in startIP-endIP format',
  `allocation_state` varchar(32) NOT NULL DEFAULT 'Enabled' COMMENT 'Is this Pod enabled for allocation for new resources',
  `external_dhcp` tinyint(4) NOT NULL DEFAULT '0' COMMENT 'Is this Pod using external DHCP',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `owner` varchar(255) DEFAULT NULL,
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `lastUpdated` datetime DEFAULT NULL COMMENT 'last updated',
  `engine_state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'the engine state of the zone',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`,`data_center_id`),
  UNIQUE KEY `uc_host_pod_ref__uuid` (`uuid`),
  KEY `i_host_pod_ref__data_center_id` (`data_center_id`),
  KEY `i_host_pod_ref__allocation_state` (`allocation_state`),
  KEY `i_host_pod_ref__removed` (`removed`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host_pod_ref`
--

LOCK TABLES `host_pod_ref` WRITE;
/*!40000 ALTER TABLE `host_pod_ref` DISABLE KEYS */;
INSERT INTO `host_pod_ref` VALUES (1,'testpod','51fbb668-2e57-43f3-b71e-ee6f43b72118',1,'192.168.3.1','192.168.3.0',24,'192.168.3.10-192.168.3.99','Enabled',0,NULL,NULL,NULL,NULL,'Disabled');
/*!40000 ALTER TABLE `host_pod_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `host_tags`
--

DROP TABLE IF EXISTS `host_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `host_tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id',
  `tag` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_host_tags__host_id` (`host_id`),
  CONSTRAINT `fk_host_tags__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `host_tags`
--

LOCK TABLES `host_tags` WRITE;
/*!40000 ALTER TABLE `host_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `host_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `host_view`
--

DROP TABLE IF EXISTS `host_view`;
/*!50001 DROP VIEW IF EXISTS `host_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `host_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `status` tinyint NOT NULL,
  `disconnected` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  `private_ip_address` tinyint NOT NULL,
  `version` tinyint NOT NULL,
  `hypervisor_type` tinyint NOT NULL,
  `hypervisor_version` tinyint NOT NULL,
  `capabilities` tinyint NOT NULL,
  `last_ping` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `resource_state` tinyint NOT NULL,
  `mgmt_server_id` tinyint NOT NULL,
  `cpus` tinyint NOT NULL,
  `speed` tinyint NOT NULL,
  `ram` tinyint NOT NULL,
  `cluster_id` tinyint NOT NULL,
  `cluster_uuid` tinyint NOT NULL,
  `cluster_name` tinyint NOT NULL,
  `cluster_type` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `data_center_type` tinyint NOT NULL,
  `pod_id` tinyint NOT NULL,
  `pod_uuid` tinyint NOT NULL,
  `pod_name` tinyint NOT NULL,
  `tag` tinyint NOT NULL,
  `guest_os_category_id` tinyint NOT NULL,
  `guest_os_category_uuid` tinyint NOT NULL,
  `guest_os_category_name` tinyint NOT NULL,
  `memory_used_capacity` tinyint NOT NULL,
  `memory_reserved_capacity` tinyint NOT NULL,
  `cpu_used_capacity` tinyint NOT NULL,
  `cpu_reserved_capacity` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `hypervisor_capabilities`
--

DROP TABLE IF EXISTS `hypervisor_capabilities`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hypervisor_capabilities` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `hypervisor_type` varchar(32) NOT NULL,
  `hypervisor_version` varchar(32) DEFAULT NULL,
  `max_guests_limit` bigint(20) unsigned DEFAULT '50',
  `security_group_enabled` int(1) unsigned DEFAULT '1' COMMENT 'Is security group supported',
  `max_data_volumes_limit` int(10) unsigned DEFAULT '6' COMMENT 'Max. data volumes per VM supported by hypervisor',
  `max_hosts_per_cluster` int(10) unsigned DEFAULT NULL COMMENT 'Max. hosts in cluster supported by hypervisor',
  `storage_motion_supported` int(1) unsigned DEFAULT '0' COMMENT 'Is storage motion supported',
  `vm_snapshot_enabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Whether VM snapshot is supported by hypervisor',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_hypervisor_capabilities__uuid` (`uuid`),
  UNIQUE KEY `uc_hypervisor` (`hypervisor_type`,`hypervisor_version`)
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `hypervisor_capabilities`
--

LOCK TABLES `hypervisor_capabilities` WRITE;
/*!40000 ALTER TABLE `hypervisor_capabilities` DISABLE KEYS */;
INSERT INTO `hypervisor_capabilities` VALUES (1,'1','XenServer','default',50,1,6,NULL,0,1),(2,'2','XenServer','XCP 1.0',50,1,6,NULL,0,1),(3,'3','XenServer','5.6',50,1,6,NULL,0,1),(4,'4','XenServer','5.6 FP1',50,1,6,NULL,0,1),(5,'5','XenServer','5.6 SP2',50,1,6,NULL,0,1),(6,'6','XenServer','6.0',50,1,13,NULL,0,1),(7,'7','XenServer','6.0.2',50,1,13,NULL,0,1),(8,'8','VMware','default',128,0,6,32,0,1),(9,'9','VMware','4.0',128,0,6,32,0,1),(10,'10','VMware','4.1',128,0,6,32,0,1),(11,'11','VMware','5.0',128,0,6,32,1,1),(12,'12','KVM','default',50,1,6,NULL,0,0),(13,'13','Ovm','default',25,1,6,NULL,0,0),(14,'14','Ovm','2.3',25,1,6,NULL,0,0),(15,'4f17b64e-3e05-11e3-a27a-14109fdfd297','XenServer','6.1.0',50,1,13,NULL,1,1),(16,'4f17bee2-3e05-11e3-a27a-14109fdfd297','XenServer','6.2.0',50,1,13,NULL,1,1),(17,'4f17c926-3e05-11e3-a27a-14109fdfd297','VMware','5.1',128,0,6,32,1,1),(18,'4f6f168e-3e05-11e3-a27a-14109fdfd297','LXC','default',50,1,6,NULL,0,0);
/*!40000 ALTER TABLE `hypervisor_capabilities` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_store`
--

DROP TABLE IF EXISTS `image_store`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image_store` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT 'name of data store',
  `image_provider_name` varchar(255) NOT NULL COMMENT 'id of image_store_provider',
  `protocol` varchar(255) NOT NULL COMMENT 'protocol of data store',
  `url` varchar(255) DEFAULT NULL COMMENT 'url for image data store',
  `data_center_id` bigint(20) unsigned DEFAULT NULL COMMENT 'datacenter id of data store',
  `scope` varchar(255) DEFAULT NULL COMMENT 'scope of data store',
  `role` varchar(255) DEFAULT NULL COMMENT 'role of data store',
  `uuid` varchar(255) DEFAULT NULL COMMENT 'uuid of data store',
  `parent` varchar(255) DEFAULT NULL COMMENT 'parent path for the storage server',
  `created` datetime DEFAULT NULL COMMENT 'date the image store first signed on',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `total_size` bigint(20) unsigned DEFAULT NULL COMMENT 'storage total size statistics',
  `used_bytes` bigint(20) unsigned DEFAULT NULL COMMENT 'storage available bytes statistics',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_store`
--

LOCK TABLES `image_store` WRITE;
/*!40000 ALTER TABLE `image_store` DISABLE KEYS */;
INSERT INTO `image_store` VALUES (1,'nfs://192.168.3.134:/exports/secondary1','NFS','nfs','nfs://192.168.3.134:/exports/secondary1',1,'ZONE','Image','59139c05-81ff-4556-96f5-7e72849b27a5',NULL,'2013-10-26 06:37:15',NULL,NULL,NULL);
/*!40000 ALTER TABLE `image_store` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `image_store_details`
--

DROP TABLE IF EXISTS `image_store_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `image_store_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `store_id` bigint(20) unsigned NOT NULL COMMENT 'store the detail is related to',
  `name` varchar(255) NOT NULL COMMENT 'name of the detail',
  `value` varchar(255) NOT NULL COMMENT 'value of the detail',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_image_store_details__store_id` (`store_id`),
  KEY `i_image_store__name__value` (`name`(128),`value`(128)),
  CONSTRAINT `fk_image_store_details__store_id` FOREIGN KEY (`store_id`) REFERENCES `image_store` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `image_store_details`
--

LOCK TABLES `image_store_details` WRITE;
/*!40000 ALTER TABLE `image_store_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `image_store_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `image_store_view`
--

DROP TABLE IF EXISTS `image_store_view`;
/*!50001 DROP VIEW IF EXISTS `image_store_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `image_store_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `image_provider_name` tinyint NOT NULL,
  `protocol` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `scope` tinyint NOT NULL,
  `role` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `detail_name` tinyint NOT NULL,
  `detail_value` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `inline_load_balancer_nic_map`
--

DROP TABLE IF EXISTS `inline_load_balancer_nic_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inline_load_balancer_nic_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `public_ip_address` char(40) NOT NULL,
  `nic_id` bigint(20) unsigned DEFAULT NULL COMMENT 'nic id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `nic_id` (`nic_id`),
  CONSTRAINT `fk_inline_load_balancer_nic_map__nic_id` FOREIGN KEY (`nic_id`) REFERENCES `nics` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inline_load_balancer_nic_map`
--

LOCK TABLES `inline_load_balancer_nic_map` WRITE;
/*!40000 ALTER TABLE `inline_load_balancer_nic_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `inline_load_balancer_nic_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `instance_group`
--

DROP TABLE IF EXISTS `instance_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instance_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner.  foreign key to account table',
  `name` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `removed` datetime DEFAULT NULL COMMENT 'date the group was removed',
  `created` datetime DEFAULT NULL COMMENT 'date the group was created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_instance_group__uuid` (`uuid`),
  KEY `i_instance_group__removed` (`removed`),
  KEY `fk_instance_group__account_id` (`account_id`),
  CONSTRAINT `fk_instance_group__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instance_group`
--

LOCK TABLES `instance_group` WRITE;
/*!40000 ALTER TABLE `instance_group` DISABLE KEYS */;
/*!40000 ALTER TABLE `instance_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `instance_group_view`
--

DROP TABLE IF EXISTS `instance_group_view`;
/*!50001 DROP VIEW IF EXISTS `instance_group_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `instance_group_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `instance_group_vm_map`
--

DROP TABLE IF EXISTS `instance_group_vm_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `instance_group_vm_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `group_id` bigint(20) unsigned NOT NULL,
  `instance_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_instance_group_vm_map___group_id` (`group_id`),
  KEY `fk_instance_group_vm_map___instance_id` (`instance_id`),
  CONSTRAINT `fk_instance_group_vm_map___group_id` FOREIGN KEY (`group_id`) REFERENCES `instance_group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_instance_group_vm_map___instance_id` FOREIGN KEY (`instance_id`) REFERENCES `user_vm` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `instance_group_vm_map`
--

LOCK TABLES `instance_group_vm_map` WRITE;
/*!40000 ALTER TABLE `instance_group_vm_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `instance_group_vm_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `keystore`
--

DROP TABLE IF EXISTS `keystore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `keystore` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) NOT NULL COMMENT 'unique name for the certifiation',
  `certificate` text NOT NULL COMMENT 'the actual certificate being stored in the db',
  `key` text COMMENT 'private key associated wih the certificate',
  `domain_suffix` varchar(256) NOT NULL COMMENT 'DNS domain suffix associated with the certificate',
  `seq` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `keystore`
--

LOCK TABLES `keystore` WRITE;
/*!40000 ALTER TABLE `keystore` DISABLE KEYS */;
INSERT INTO `keystore` VALUES (1,'CPVMCertificate','-----BEGIN CERTIFICATE-----\nMIIFZTCCBE2gAwIBAgIHKBCduBUoKDANBgkqhkiG9w0BAQUFADCByjELMAkGA1UE\nBhMCVVMxEDAOBgNVBAgTB0FyaXpvbmExEzARBgNVBAcTClNjb3R0c2RhbGUxGjAY\nBgNVBAoTEUdvRGFkZHkuY29tLCBJbmMuMTMwMQYDVQQLEypodHRwOi8vY2VydGlm\naWNhdGVzLmdvZGFkZHkuY29tL3JlcG9zaXRvcnkxMDAuBgNVBAMTJ0dvIERhZGR5\nIFNlY3VyZSBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTERMA8GA1UEBRMIMDc5Njky\nODcwHhcNMTIwMjAzMDMzMDQwWhcNMTcwMjA3MDUxMTIzWjBZMRkwFwYDVQQKDBAq\nLnJlYWxob3N0aXAuY29tMSEwHwYDVQQLDBhEb21haW4gQ29udHJvbCBWYWxpZGF0\nZWQxGTAXBgNVBAMMECoucmVhbGhvc3RpcC5jb20wggEiMA0GCSqGSIb3DQEBAQUA\nA4IBDwAwggEKAoIBAQCDT9AtEfs+s/I8QXp6rrCw0iNJ0+GgsybNHheU+JpL39LM\nTZykCrZhZnyDvwdxCoOfE38Sa32baHKNds+y2SHnMNsOkw8OcNucHEBX1FIpOBGp\nh9D6xC+umx9od6xMWETUv7j6h2u+WC3OhBM8fHCBqIiAol31/IkcqDxxsHlQ8S/o\nCfTlXJUY6Yn628OA1XijKdRnadV0hZ829cv/PZKljjwQUTyrd0KHQeksBH+YAYSo\n2JUl8ekNLsOi8/cPtfojnltzRI1GXi0ZONs8VnDzJ0a2gqZY+uxlz+CGbLnGnlN4\nj9cBpE+MfUE+35Dq121sTpsSgF85Mz+pVhn2S633AgMBAAGjggG+MIIBujAPBgNV\nHRMBAf8EBTADAQEAMB0GA1UdJQQWMBQGCCsGAQUFBwMBBggrBgEFBQcDAjAOBgNV\nHQ8BAf8EBAMCBaAwMwYDVR0fBCwwKjAooCagJIYiaHR0cDovL2NybC5nb2RhZGR5\nLmNvbS9nZHMxLTY0LmNybDBTBgNVHSAETDBKMEgGC2CGSAGG/W0BBxcBMDkwNwYI\nKwYBBQUHAgEWK2h0dHA6Ly9jZXJ0aWZpY2F0ZXMuZ29kYWRkeS5jb20vcmVwb3Np\ndG9yeS8wgYAGCCsGAQUFBwEBBHQwcjAkBggrBgEFBQcwAYYYaHR0cDovL29jc3Au\nZ29kYWRkeS5jb20vMEoGCCsGAQUFBzAChj5odHRwOi8vY2VydGlmaWNhdGVzLmdv\nZGFkZHkuY29tL3JlcG9zaXRvcnkvZ2RfaW50ZXJtZWRpYXRlLmNydDAfBgNVHSME\nGDAWgBT9rGEyk2xF1uLuhV+auud2mWjM5zArBgNVHREEJDAighAqLnJlYWxob3N0\naXAuY29tgg5yZWFsaG9zdGlwLmNvbTAdBgNVHQ4EFgQUZyJz9/QLy5TWIIscTXID\nE8Xk47YwDQYJKoZIhvcNAQEFBQADggEBAKiUV3KK16mP0NpS92fmQkCLqm+qUWyN\nBfBVgf9/M5pcT8EiTZlS5nAtzAE/eRpBeR3ubLlaAogj4rdH7YYVJcDDLLoB2qM3\nqeCHu8LFoblkb93UuFDWqRaVPmMlJRnhsRkL1oa2gM2hwQTkBDkP7w5FG1BELCgl\ngZI2ij2yxjge6pOEwSyZCzzbCcg9pN+dNrYyGEtB4k+BBnPA3N4r14CWbk+uxjrQ\n6j2Ip+b7wOc5IuMEMl8xwTyjuX3lsLbAZyFI9RCyofwA9NqIZ1GeB6Zd196rubQp\n93cmBqGGjZUs3wMrGlm7xdjlX6GQ9UvmvkMub9+lL99A5W50QgCmFeI=\n-----END CERTIFICATE-----\n','-----BEGIN PRIVATE KEY-----\nMIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCDT9AtEfs+s/I8QXp6rrCw0iNJ\n0+GgsybNHheU+JpL39LMTZykCrZhZnyDvwdxCoOfE38Sa32baHKNds+y2SHnMNsOkw8OcNucHEBX\n1FIpOBGph9D6xC+umx9od6xMWETUv7j6h2u+WC3OhBM8fHCBqIiAol31/IkcqDxxsHlQ8S/oCfTl\nXJUY6Yn628OA1XijKdRnadV0hZ829cv/PZKljjwQUTyrd0KHQeksBH+YAYSo2JUl8ekNLsOi8/cP\ntfojnltzRI1GXi0ZONs8VnDzJ0a2gqZY+uxlz+CGbLnGnlN4j9cBpE+MfUE+35Dq121sTpsSgF85\nMz+pVhn2S633AgMBAAECggEAH/Szd9RxbVADenCA6wxKSa3KErRyq1YN8ksJeCKMAj0FIt0caruE\nqO11DebWW8cwQu1Otl/cYI6pmg24/BBldMrp9IELX/tNJo+lhPpRyGAxxC0eSXinFfoASb8d+jJd\nBd1mmemM6fSxqRlxSP4LrzIhjhR1g2CiyYuTsiM9UtoVKGyHwe7KfFwirUOJo3Mr18zUVNm7YqY4\nIVhOSq59zkH3ULBlYq4bG50jpxa5mNSCZ7IpafPY/kE/CbR+FWNt30+rk69T+qb5abg6+XGm+OAm\nbnQ18yZEqX6nJLk7Ch0cfA5orGgrTMOrM71wK7tBBDQ308kOxDGebx6j0qD36QKBgQDTRDr8kuhA\n9sUyKr9vk2DQCMpNvEeiwI3JRMqmmxpNAtg01aJ3Ya57vX5Fc+zcuV87kP6FM1xgpHQvnw5LWo2J\ns7ANwQcP8ricEW5zkZhSjI4ssMeAubmsHOloGxmLFYZqwx0JI7CWViGTLMcUlqKblmHcjeQDeDfP\nP1TaCItFmwKBgQCfHZwVvIcaDs5vxVpZ4ftvflIrW8qq0uOVK6QIf9A/YTGhCXl2qxxTg2A6+0rg\nZqI7zKzUDxIbVv0KlgCbpHDC9d5+sdtDB3wW2pimuJ3p1z4/RHb4n/lDwXCACZl1S5l24yXX2pFZ\nwdPCXmy5PYkHMssFLNhI24pprUIQs66M1QKBgQDQwjAjWisD3pRXESSfZRsaFkWJcM28hdbVFhPF\nc6gWhwQLmTp0CuL2RPXcPUPFi6sN2iWWi3zxxi9Eyz+9uBn6AsOpo56N5MME/LiOnETO9TKb+Ib6\nrQtKhjshcv3XkIqFPo2XdVvOAgglPO7vajX91iiXXuH7h7RmJud6l0y/lwKBgE+bi90gLuPtpoEr\nVzIDKz40ED5bNYHT80NNy0rpT7J2GVN9nwStRYXPBBVeZq7xCpgqpgmO5LtDAWULeZBlbHlOdBwl\nNhNKKl5wzdEUKwW0yBL1WSS5PQgWPwgARYP25/ggW22sj+49WIo1neXsEKPGWObk8e050f1fTt92\nVo1lAoGAb1gCoyBCzvi7sqFxm4V5oapnJeiQQJFjhoYWqGa26rQ+AvXXNuBcigIeDXNJPctSF0Uc\np11KbbCgiruBbckvM1vGsk6Sx4leRk+IFHRpJktFUek4o0eUg0shOsyyvyet48Dfg0a8FvcxROs0\ngD+IYds5doiob/hcm1hnNB/3vk4=\n-----END PRIVATE KEY-----\n','realhostip.com',NULL),(2,'root','-----BEGIN CERTIFICATE-----\nMIIE3jCCA8agAwIBAgICAwEwDQYJKoZIhvcNAQEFBQAwYzELMAkGA1UEBhMCVVMx\nITAfBgNVBAoTGFRoZSBHbyBEYWRkeSBHcm91cCwgSW5jLjExMC8GA1UECxMoR28g\nRGFkZHkgQ2xhc3MgMiBDZXJ0aWZpY2F0aW9uIEF1dGhvcml0eTAeFw0wNjExMTYw\nMTU0MzdaFw0yNjExMTYwMTU0MzdaMIHKMQswCQYDVQQGEwJVUzEQMA4GA1UECBMH\nQXJpem9uYTETMBEGA1UEBxMKU2NvdHRzZGFsZTEaMBgGA1UEChMRR29EYWRkeS5j\nb20sIEluYy4xMzAxBgNVBAsTKmh0dHA6Ly9jZXJ0aWZpY2F0ZXMuZ29kYWRkeS5j\nb20vcmVwb3NpdG9yeTEwMC4GA1UEAxMnR28gRGFkZHkgU2VjdXJlIENlcnRpZmlj\nYXRpb24gQXV0aG9yaXR5MREwDwYDVQQFEwgwNzk2OTI4NzCCASIwDQYJKoZIhvcN\nAQEBBQADggEPADCCAQoCggEBAMQt1RWMnCZM7DI161+4WQFapmGBWTtwY6vj3D3H\nKrjJM9N55DrtPDAjhI6zMBS2sofDPZVUBJ7fmd0LJR4h3mUpfjWoqVTr9vcyOdQm\nVZWt7/v+WIbXnvQAjYwqDL1CBM6nPwT27oDyqu9SoWlm2r4arV3aLGbqGmu75RpR\nSgAvSMeYddi5Kcju+GZtCpyz8/x4fKL4o/K1w/O5epHBp+YlLpyo7RJlbmr2EkRT\ncDCVw5wrWCs9CHRK8r5RsL+H0EwnWGu1NcWdrxcx+AuP7q2BNgWJCJjPOq8lh8BJ\n6qf9Z/dFjpfMFDniNoW1fho3/Rb2cRGadDAW/hOUoz+EDU8CAwEAAaOCATIwggEu\nMB0GA1UdDgQWBBT9rGEyk2xF1uLuhV+auud2mWjM5zAfBgNVHSMEGDAWgBTSxLDS\nkdRMEXGzYcs9of7dqGrU4zASBgNVHRMBAf8ECDAGAQH/AgEAMDMGCCsGAQUFBwEB\nBCcwJTAjBggrBgEFBQcwAYYXaHR0cDovL29jc3AuZ29kYWRkeS5jb20wRgYDVR0f\nBD8wPTA7oDmgN4Y1aHR0cDovL2NlcnRpZmljYXRlcy5nb2RhZGR5LmNvbS9yZXBv\nc2l0b3J5L2dkcm9vdC5jcmwwSwYDVR0gBEQwQjBABgRVHSAAMDgwNgYIKwYBBQUH\nAgEWKmh0dHA6Ly9jZXJ0aWZpY2F0ZXMuZ29kYWRkeS5jb20vcmVwb3NpdG9yeTAO\nBgNVHQ8BAf8EBAMCAQYwDQYJKoZIhvcNAQEFBQADggEBANKGwOy9+aG2Z+5mC6IG\nOgRQjhVyrEp0lVPLN8tESe8HkGsz2ZbwlFalEzAFPIUyIXvJxwqoJKSQ3kbTJSMU\nA2fCENZvD117esyfxVgqwcSeIaha86ykRvOe5GPLL5CkKSkB2XIsKd83ASe8T+5o\n0yGPwLPk9Qnt0hCqU7S+8MxZC9Y7lhyVJEnfzuz9p0iRFEUOOjZv2kWzRaJBydTX\nRE4+uXR21aITVSzGh6O1mawGhId/dQb8vxRMDsxuxN89txJx9OjxUUAiKEngHUuH\nqDTMBqLdElrRhjZkAzVvb3du6/KFUJheqwNTrZEjYx8WnM25sgVjOuH0aBsXBTWV\nU+4=\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\nMIIE+zCCBGSgAwIBAgICAQ0wDQYJKoZIhvcNAQEFBQAwgbsxJDAiBgNVBAcTG1Zh\nbGlDZXJ0IFZhbGlkYXRpb24gTmV0d29yazEXMBUGA1UEChMOVmFsaUNlcnQsIElu\nYy4xNTAzBgNVBAsTLFZhbGlDZXJ0IENsYXNzIDIgUG9saWN5IFZhbGlkYXRpb24g\nQXV0aG9yaXR5MSEwHwYDVQQDExhodHRwOi8vd3d3LnZhbGljZXJ0LmNvbS8xIDAe\nBgkqhkiG9w0BCQEWEWluZm9AdmFsaWNlcnQuY29tMB4XDTA0MDYyOTE3MDYyMFoX\nDTI0MDYyOTE3MDYyMFowYzELMAkGA1UEBhMCVVMxITAfBgNVBAoTGFRoZSBHbyBE\nYWRkeSBHcm91cCwgSW5jLjExMC8GA1UECxMoR28gRGFkZHkgQ2xhc3MgMiBDZXJ0\naWZpY2F0aW9uIEF1dGhvcml0eTCCASAwDQYJKoZIhvcNAQEBBQADggENADCCAQgC\nggEBAN6d1+pXGEmhW+vXX0iG6r7d/+TvZxz0ZWizV3GgXne77ZtJ6XCAPVYYYwhv\n2vLM0D9/AlQiVBDYsoHUwHU9S3/Hd8M+eKsaA7Ugay9qK7HFiH7Eux6wwdhFJ2+q\nN1j3hybX2C32qRe3H3I2TqYXP2WYktsqbl2i/ojgC95/5Y0V4evLOtXiEqITLdiO\nr18SPaAIBQi2XKVlOARFmR6jYGB0xUGlcmIbYsUfb18aQr4CUWWoriMYavx4A6lN\nf4DD+qta/KFApMoZFv6yyO9ecw3ud72a9nmYvLEHZ6IVDd2gWMZEewo+YihfukEH\nU1jPEX44dMX4/7VpkI+EdOqXG68CAQOjggHhMIIB3TAdBgNVHQ4EFgQU0sSw0pHU\nTBFxs2HLPaH+3ahq1OMwgdIGA1UdIwSByjCBx6GBwaSBvjCBuzEkMCIGA1UEBxMb\nVmFsaUNlcnQgVmFsaWRhdGlvbiBOZXR3b3JrMRcwFQYDVQQKEw5WYWxpQ2VydCwg\nSW5jLjE1MDMGA1UECxMsVmFsaUNlcnQgQ2xhc3MgMiBQb2xpY3kgVmFsaWRhdGlv\nbiBBdXRob3JpdHkxITAfBgNVBAMTGGh0dHA6Ly93d3cudmFsaWNlcnQuY29tLzEg\nMB4GCSqGSIb3DQEJARYRaW5mb0B2YWxpY2VydC5jb22CAQEwDwYDVR0TAQH/BAUw\nAwEB/zAzBggrBgEFBQcBAQQnMCUwIwYIKwYBBQUHMAGGF2h0dHA6Ly9vY3NwLmdv\nZGFkZHkuY29tMEQGA1UdHwQ9MDswOaA3oDWGM2h0dHA6Ly9jZXJ0aWZpY2F0ZXMu\nZ29kYWRkeS5jb20vcmVwb3NpdG9yeS9yb290LmNybDBLBgNVHSAERDBCMEAGBFUd\nIAAwODA2BggrBgEFBQcCARYqaHR0cDovL2NlcnRpZmljYXRlcy5nb2RhZGR5LmNv\nbS9yZXBvc2l0b3J5MA4GA1UdDwEB/wQEAwIBBjANBgkqhkiG9w0BAQUFAAOBgQC1\nQPmnHfbq/qQaQlpE9xXUhUaJwL6e4+PrxeNYiY+Sn1eocSxI0YGyeR+sBjUZsE4O\nWBsUs5iB0QQeyAfJg594RAoYC5jcdnplDQ1tgMQLARzLrUc+cb53S8wGd9D0Vmsf\nSxOaFIqII6hR8INMqzW/Rn453HWkrugp++85j09VZw==\n-----END CERTIFICATE-----\n-----BEGIN CERTIFICATE-----\nMIIC5zCCAlACAQEwDQYJKoZIhvcNAQEFBQAwgbsxJDAiBgNVBAcTG1ZhbGlDZXJ0\nIFZhbGlkYXRpb24gTmV0d29yazEXMBUGA1UEChMOVmFsaUNlcnQsIEluYy4xNTAz\nBgNVBAsTLFZhbGlDZXJ0IENsYXNzIDIgUG9saWN5IFZhbGlkYXRpb24gQXV0aG9y\naXR5MSEwHwYDVQQDExhodHRwOi8vd3d3LnZhbGljZXJ0LmNvbS8xIDAeBgkqhkiG\n9w0BCQEWEWluZm9AdmFsaWNlcnQuY29tMB4XDTk5MDYyNjAwMTk1NFoXDTE5MDYy\nNjAwMTk1NFowgbsxJDAiBgNVBAcTG1ZhbGlDZXJ0IFZhbGlkYXRpb24gTmV0d29y\nazEXMBUGA1UEChMOVmFsaUNlcnQsIEluYy4xNTAzBgNVBAsTLFZhbGlDZXJ0IENs\nYXNzIDIgUG9saWN5IFZhbGlkYXRpb24gQXV0aG9yaXR5MSEwHwYDVQQDExhodHRw\nOi8vd3d3LnZhbGljZXJ0LmNvbS8xIDAeBgkqhkiG9w0BCQEWEWluZm9AdmFsaWNl\ncnQuY29tMIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDOOnHK5avIWZJV16vY\ndA757tn2VUdZZUcOBVXc65g2PFxTXdMwzzjsvUGJ7SVCCSRrCl6zfN1SLUzm1NZ9\nWlmpZdRJEy0kTRxQb7XBhVQ7/nHk01xC+YDgkRoKWzk2Z/M/VXwbP7RfZHM047QS\nv4dk+NoS/zcnwbNDu+97bi5p9wIDAQABMA0GCSqGSIb3DQEBBQUAA4GBADt/UG9v\nUJSZSWI4OB9L+KXIPqeCgfYrx+jFzug6EILLGACOTb2oWH+heQC1u+mNr0HZDzTu\nIYEZoDJJKPTEjlbVUjP9UNV+mWwD5MlM/Mtsq2azSiGM5bUMMj4QssxsodyamEwC\nW/POuZ6lcg5Ktz885hZo+L7tdEy8W9ViH0Pd\n-----END CERTIFICATE-----\n',NULL,'realhostip.com',0);
/*!40000 ALTER TABLE `keystore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `launch_permission`
--

DROP TABLE IF EXISTS `launch_permission`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `launch_permission` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `template_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `i_launch_permission_template_id` (`template_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `launch_permission`
--

LOCK TABLES `launch_permission` WRITE;
/*!40000 ALTER TABLE `launch_permission` DISABLE KEYS */;
/*!40000 ALTER TABLE `launch_permission` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ldap_configuration`
--

DROP TABLE IF EXISTS `ldap_configuration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ldap_configuration` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `hostname` varchar(255) NOT NULL COMMENT 'the hostname of the ldap server',
  `port` int(10) DEFAULT NULL COMMENT 'port that the ldap server is listening on',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ldap_configuration`
--

LOCK TABLES `ldap_configuration` WRITE;
/*!40000 ALTER TABLE `ldap_configuration` DISABLE KEYS */;
/*!40000 ALTER TABLE `ldap_configuration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `legacy_zones`
--

DROP TABLE IF EXISTS `legacy_zones`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `legacy_zones` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `zone_id` bigint(20) unsigned NOT NULL COMMENT 'id of CloudStack zone',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zone_id` (`zone_id`),
  CONSTRAINT `fk_legacy_zones__zone_id` FOREIGN KEY (`zone_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `legacy_zones`
--

LOCK TABLES `legacy_zones` WRITE;
/*!40000 ALTER TABLE `legacy_zones` DISABLE KEYS */;
/*!40000 ALTER TABLE `legacy_zones` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `load_balancer_healthcheck_policies`
--

DROP TABLE IF EXISTS `load_balancer_healthcheck_policies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `load_balancer_healthcheck_policies` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `load_balancer_id` bigint(20) unsigned NOT NULL,
  `pingpath` varchar(225) DEFAULT '/',
  `description` varchar(4096) DEFAULT NULL,
  `response_time` int(11) DEFAULT '5',
  `healthcheck_interval` int(11) DEFAULT '5',
  `healthcheck_thresshold` int(11) DEFAULT '2',
  `unhealth_thresshold` int(11) DEFAULT '10',
  `revoke` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 is when rule is set for Revoke',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`),
  KEY `fk_load_balancer_healthcheck_policies_loadbalancer_id` (`load_balancer_id`),
  CONSTRAINT `fk_load_balancer_healthcheck_policies_loadbalancer_id` FOREIGN KEY (`load_balancer_id`) REFERENCES `load_balancing_rules` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `load_balancer_healthcheck_policies`
--

LOCK TABLES `load_balancer_healthcheck_policies` WRITE;
/*!40000 ALTER TABLE `load_balancer_healthcheck_policies` DISABLE KEYS */;
/*!40000 ALTER TABLE `load_balancer_healthcheck_policies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `load_balancer_stickiness_policies`
--

DROP TABLE IF EXISTS `load_balancer_stickiness_policies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `load_balancer_stickiness_policies` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `load_balancer_id` bigint(20) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(4096) DEFAULT NULL COMMENT 'description',
  `method_name` varchar(255) NOT NULL,
  `params` varchar(4096) NOT NULL,
  `revoke` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 is when rule is set for Revoke',
  PRIMARY KEY (`id`),
  KEY `fk_load_balancer_stickiness_policies__load_balancer_id` (`load_balancer_id`),
  CONSTRAINT `fk_load_balancer_stickiness_policies__load_balancer_id` FOREIGN KEY (`load_balancer_id`) REFERENCES `load_balancing_rules` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `load_balancer_stickiness_policies`
--

LOCK TABLES `load_balancer_stickiness_policies` WRITE;
/*!40000 ALTER TABLE `load_balancer_stickiness_policies` DISABLE KEYS */;
/*!40000 ALTER TABLE `load_balancer_stickiness_policies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `load_balancer_vm_map`
--

DROP TABLE IF EXISTS `load_balancer_vm_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `load_balancer_vm_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `load_balancer_id` bigint(20) unsigned NOT NULL,
  `instance_id` bigint(20) unsigned NOT NULL,
  `revoke` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 is when rule is set for Revoke',
  `state` varchar(40) DEFAULT NULL COMMENT 'service status updated by LB healthcheck manager',
  PRIMARY KEY (`id`),
  UNIQUE KEY `load_balancer_id` (`load_balancer_id`,`instance_id`),
  KEY `fk_load_balancer_vm_map__instance_id` (`instance_id`),
  CONSTRAINT `fk_load_balancer_vm_map__instance_id` FOREIGN KEY (`instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_load_balancer_vm_map__load_balancer_id` FOREIGN KEY (`load_balancer_id`) REFERENCES `load_balancing_rules` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `load_balancer_vm_map`
--

LOCK TABLES `load_balancer_vm_map` WRITE;
/*!40000 ALTER TABLE `load_balancer_vm_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `load_balancer_vm_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `load_balancing_rules`
--

DROP TABLE IF EXISTS `load_balancing_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `load_balancing_rules` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` varchar(4096) DEFAULT NULL COMMENT 'description',
  `default_port_start` int(10) NOT NULL COMMENT 'default private port range start',
  `default_port_end` int(10) NOT NULL COMMENT 'default destination port range end',
  `algorithm` varchar(255) NOT NULL,
  `source_ip_address` varchar(40) DEFAULT NULL COMMENT 'source ip address for the load balancer rule',
  `source_ip_address_network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'the id of the network where source ip belongs to',
  `scheme` varchar(40) NOT NULL COMMENT 'load balancer scheme; can be Internal or Public',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_load_balancing_rules__id` FOREIGN KEY (`id`) REFERENCES `firewall_rules` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `load_balancing_rules`
--

LOCK TABLES `load_balancing_rules` WRITE;
/*!40000 ALTER TABLE `load_balancing_rules` DISABLE KEYS */;
/*!40000 ALTER TABLE `load_balancing_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mshost`
--

DROP TABLE IF EXISTS `mshost`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mshost` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `msid` bigint(20) unsigned NOT NULL COMMENT 'management server id derived from MAC address',
  `runid` bigint(20) NOT NULL DEFAULT '0' COMMENT 'run id, combined with msid to form a cluster session',
  `name` varchar(255) DEFAULT NULL,
  `state` varchar(10) NOT NULL DEFAULT 'Down',
  `version` varchar(255) DEFAULT NULL,
  `service_ip` char(40) NOT NULL,
  `service_port` int(11) NOT NULL,
  `last_update` datetime DEFAULT NULL COMMENT 'Last record update time',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `alert_count` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `msid` (`msid`),
  KEY `i_mshost__removed` (`removed`),
  KEY `i_mshost__last_update` (`last_update`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mshost`
--

LOCK TABLES `mshost` WRITE;
/*!40000 ALTER TABLE `mshost` DISABLE KEYS */;
INSERT INTO `mshost` VALUES (1,22061634278039,1382769008391,'mymbp','Up',NULL,'127.0.0.1',9090,'2013-10-26 06:37:27',NULL,0);
/*!40000 ALTER TABLE `mshost` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mshost_peer`
--

DROP TABLE IF EXISTS `mshost_peer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `mshost_peer` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `owner_mshost` bigint(20) unsigned NOT NULL,
  `peer_mshost` bigint(20) unsigned NOT NULL,
  `peer_runid` bigint(20) NOT NULL,
  `peer_state` varchar(10) NOT NULL DEFAULT 'Down',
  `last_update` datetime DEFAULT NULL COMMENT 'Last record update time',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_mshost_peer__owner_peer_runid` (`owner_mshost`,`peer_mshost`,`peer_runid`),
  KEY `fk_mshost_peer__peer_mshost` (`peer_mshost`),
  CONSTRAINT `fk_mshost_peer__owner_mshost` FOREIGN KEY (`owner_mshost`) REFERENCES `mshost` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_mshost_peer__peer_mshost` FOREIGN KEY (`peer_mshost`) REFERENCES `mshost` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mshost_peer`
--

LOCK TABLES `mshost_peer` WRITE;
/*!40000 ALTER TABLE `mshost_peer` DISABLE KEYS */;
INSERT INTO `mshost_peer` VALUES (1,1,1,1382769008391,'Up','2013-10-26 06:30:27');
/*!40000 ALTER TABLE `mshost_peer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `netapp_lun`
--

DROP TABLE IF EXISTS `netapp_lun`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `netapp_lun` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `lun_name` varchar(255) NOT NULL COMMENT 'lun name',
  `target_iqn` varchar(255) NOT NULL COMMENT 'target iqn',
  `path` varchar(255) NOT NULL COMMENT 'lun path',
  `size` bigint(20) NOT NULL COMMENT 'lun size',
  `volume_id` bigint(20) unsigned NOT NULL COMMENT 'parent volume id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `i_netapp_lun__volume_id` (`volume_id`),
  KEY `i_netapp_lun__lun_name` (`lun_name`),
  CONSTRAINT `fk_netapp_lun__volume_id` FOREIGN KEY (`volume_id`) REFERENCES `netapp_volume` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `netapp_lun`
--

LOCK TABLES `netapp_lun` WRITE;
/*!40000 ALTER TABLE `netapp_lun` DISABLE KEYS */;
/*!40000 ALTER TABLE `netapp_lun` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `netapp_pool`
--

DROP TABLE IF EXISTS `netapp_pool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `netapp_pool` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT 'name for the pool',
  `algorithm` varchar(255) NOT NULL COMMENT 'algorithm',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `netapp_pool`
--

LOCK TABLES `netapp_pool` WRITE;
/*!40000 ALTER TABLE `netapp_pool` DISABLE KEYS */;
/*!40000 ALTER TABLE `netapp_pool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `netapp_volume`
--

DROP TABLE IF EXISTS `netapp_volume`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `netapp_volume` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `ip_address` varchar(255) NOT NULL COMMENT 'ip address/fqdn of the volume',
  `pool_id` bigint(20) unsigned NOT NULL COMMENT 'id for the pool',
  `pool_name` varchar(255) NOT NULL COMMENT 'name for the pool',
  `aggregate_name` varchar(255) NOT NULL COMMENT 'name for the aggregate',
  `volume_name` varchar(255) NOT NULL COMMENT 'name for the volume',
  `volume_size` varchar(255) NOT NULL COMMENT 'volume size',
  `snapshot_policy` varchar(255) NOT NULL COMMENT 'snapshot policy',
  `snapshot_reservation` int(11) NOT NULL COMMENT 'snapshot reservation',
  `username` varchar(255) NOT NULL COMMENT 'username',
  `password` varchar(200) DEFAULT NULL COMMENT 'password',
  `round_robin_marker` int(11) DEFAULT NULL COMMENT 'This marks the volume to be picked up for lun creation, RR fashion',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `i_netapp_volume__pool_id` (`pool_id`),
  CONSTRAINT `fk_netapp_volume__pool_id` FOREIGN KEY (`pool_id`) REFERENCES `netapp_pool` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `netapp_volume`
--

LOCK TABLES `netapp_volume` WRITE;
/*!40000 ALTER TABLE `netapp_volume` DISABLE KEYS */;
/*!40000 ALTER TABLE `netapp_volume` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `netscaler_pod_ref`
--

DROP TABLE IF EXISTS `netscaler_pod_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `netscaler_pod_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `external_load_balancer_device_id` bigint(20) unsigned NOT NULL COMMENT 'id of external load balancer device',
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod id',
  PRIMARY KEY (`id`),
  KEY `fk_ns_pod_ref__pod_id` (`pod_id`),
  KEY `fk_ns_pod_ref__device_id` (`external_load_balancer_device_id`),
  CONSTRAINT `fk_ns_pod_ref__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ns_pod_ref__device_id` FOREIGN KEY (`external_load_balancer_device_id`) REFERENCES `external_load_balancer_devices` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `netscaler_pod_ref`
--

LOCK TABLES `netscaler_pod_ref` WRITE;
/*!40000 ALTER TABLE `netscaler_pod_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `netscaler_pod_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_acl`
--

DROP TABLE IF EXISTS `network_acl`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_acl` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) NOT NULL COMMENT 'name of the network acl',
  `uuid` varchar(40) DEFAULT NULL,
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vpc this network acl belongs to',
  `description` varchar(1024) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_acl`
--

LOCK TABLES `network_acl` WRITE;
/*!40000 ALTER TABLE `network_acl` DISABLE KEYS */;
INSERT INTO `network_acl` VALUES (1,'default_deny','4fae475f-3e05-11e3-a27a-14109fdfd297',0,'Default Network ACL Deny All'),(2,'default_allow','4fae6833-3e05-11e3-a27a-14109fdfd297',0,'Default Network ACL Allow All');
/*!40000 ALTER TABLE `network_acl` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_acl_item`
--

DROP TABLE IF EXISTS `network_acl_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_acl_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `acl_id` bigint(20) unsigned NOT NULL COMMENT 'network acl id',
  `start_port` int(10) DEFAULT NULL COMMENT 'starting port of a port range',
  `end_port` int(10) DEFAULT NULL COMMENT 'end port of a port range',
  `state` char(32) NOT NULL COMMENT 'current state of this rule',
  `protocol` char(16) NOT NULL DEFAULT 'TCP' COMMENT 'protocol to open these ports for',
  `created` datetime DEFAULT NULL COMMENT 'Date created',
  `icmp_code` int(10) DEFAULT NULL COMMENT 'The ICMP code (if protocol=ICMP). A value of -1 means all codes for the given ICMP type.',
  `icmp_type` int(10) DEFAULT NULL COMMENT 'The ICMP type (if protocol=ICMP). A value of -1 means all types.',
  `traffic_type` char(32) DEFAULT NULL COMMENT 'the traffic type of the rule, can be Ingress or Egress',
  `cidr` varchar(255) DEFAULT NULL COMMENT 'comma seperated cidr list',
  `number` int(10) NOT NULL COMMENT 'priority number of the acl item',
  `action` varchar(10) NOT NULL COMMENT 'rule action, allow or deny',
  PRIMARY KEY (`id`),
  UNIQUE KEY `acl_id` (`acl_id`,`number`),
  UNIQUE KEY `uc_network_acl_item__uuid` (`uuid`),
  CONSTRAINT `fk_network_acl_item__acl_id` FOREIGN KEY (`acl_id`) REFERENCES `network_acl` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_acl_item`
--

LOCK TABLES `network_acl_item` WRITE;
/*!40000 ALTER TABLE `network_acl_item` DISABLE KEYS */;
INSERT INTO `network_acl_item` VALUES (1,'4fae53ea-3e05-11e3-a27a-14109fdfd297',1,NULL,NULL,'Active','all','2013-10-25 23:10:28',NULL,NULL,'Ingress','0.0.0.0/0',1,'Deny'),(2,'4fae5e1c-3e05-11e3-a27a-14109fdfd297',1,NULL,NULL,'Active','all','2013-10-25 23:10:28',NULL,NULL,'Egress','0.0.0.0/0',2,'Deny'),(3,'4fae71d5-3e05-11e3-a27a-14109fdfd297',2,NULL,NULL,'Active','all','2013-10-25 23:10:28',NULL,NULL,'Ingress','0.0.0.0/0',1,'Allow'),(4,'4fae7bce-3e05-11e3-a27a-14109fdfd297',2,NULL,NULL,'Active','all','2013-10-25 23:10:28',NULL,NULL,'Egress','0.0.0.0/0',2,'Allow');
/*!40000 ALTER TABLE `network_acl_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_asa1000v_map`
--

DROP TABLE IF EXISTS `network_asa1000v_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_asa1000v_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'id of guest network',
  `asa1000v_id` bigint(20) unsigned NOT NULL COMMENT 'id of asa1000v device',
  PRIMARY KEY (`id`),
  UNIQUE KEY `network_id` (`network_id`),
  UNIQUE KEY `asa1000v_id` (`asa1000v_id`),
  CONSTRAINT `fk_network_asa1000v_map__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_network_asa1000v_map__asa1000v_id` FOREIGN KEY (`asa1000v_id`) REFERENCES `external_cisco_asa1000v_devices` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_asa1000v_map`
--

LOCK TABLES `network_asa1000v_map` WRITE;
/*!40000 ALTER TABLE `network_asa1000v_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `network_asa1000v_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_details`
--

DROP TABLE IF EXISTS `network_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) NOT NULL,
  `display_detail` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should detail be displayed to the end user',
  PRIMARY KEY (`id`),
  KEY `fk_network_details__network_id` (`network_id`),
  CONSTRAINT `fk_network_details__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_details`
--

LOCK TABLES `network_details` WRITE;
/*!40000 ALTER TABLE `network_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `network_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_external_firewall_device_map`
--

DROP TABLE IF EXISTS `network_external_firewall_device_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_external_firewall_device_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `network_id` bigint(20) unsigned NOT NULL COMMENT ' guest network id',
  `external_firewall_device_id` bigint(20) unsigned NOT NULL COMMENT 'id of external firewall device assigned for this device',
  `created` datetime DEFAULT NULL COMMENT 'Date from when network started using the device',
  `removed` datetime DEFAULT NULL COMMENT 'Date till the network stopped using the device ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_network_external_firewall_devices_network_id` (`network_id`),
  KEY `fk_network_external_firewall_devices_device_id` (`external_firewall_device_id`),
  CONSTRAINT `fk_network_external_firewall_devices_network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_network_external_firewall_devices_device_id` FOREIGN KEY (`external_firewall_device_id`) REFERENCES `external_firewall_devices` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_external_firewall_device_map`
--

LOCK TABLES `network_external_firewall_device_map` WRITE;
/*!40000 ALTER TABLE `network_external_firewall_device_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `network_external_firewall_device_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_external_lb_device_map`
--

DROP TABLE IF EXISTS `network_external_lb_device_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_external_lb_device_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `network_id` bigint(20) unsigned NOT NULL COMMENT ' guest network id',
  `external_load_balancer_device_id` bigint(20) unsigned NOT NULL COMMENT 'id of external load balancer device assigned for this network',
  `created` datetime DEFAULT NULL COMMENT 'Date from when network started using the device',
  `removed` datetime DEFAULT NULL COMMENT 'Date till the network stopped using the device ',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_network_external_lb_devices_network_id` (`network_id`),
  KEY `fk_network_external_lb_devices_device_id` (`external_load_balancer_device_id`),
  CONSTRAINT `fk_network_external_lb_devices_network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_network_external_lb_devices_device_id` FOREIGN KEY (`external_load_balancer_device_id`) REFERENCES `external_load_balancer_devices` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_external_lb_device_map`
--

LOCK TABLES `network_external_lb_device_map` WRITE;
/*!40000 ALTER TABLE `network_external_lb_device_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `network_external_lb_device_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_offering_details`
--

DROP TABLE IF EXISTS `network_offering_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_offering_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `network_offering_id` bigint(20) unsigned NOT NULL COMMENT 'network offering id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_network_offering_details__network_offering_id` (`network_offering_id`),
  CONSTRAINT `fk_network_offering_details__network_offering_id` FOREIGN KEY (`network_offering_id`) REFERENCES `network_offerings` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_offering_details`
--

LOCK TABLES `network_offering_details` WRITE;
/*!40000 ALTER TABLE `network_offering_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `network_offering_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_offerings`
--

DROP TABLE IF EXISTS `network_offerings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_offerings` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(64) DEFAULT NULL COMMENT 'name of the network offering',
  `uuid` varchar(40) DEFAULT NULL,
  `unique_name` varchar(64) DEFAULT NULL COMMENT 'unique name of the network offering',
  `display_text` varchar(255) NOT NULL COMMENT 'text to display to users',
  `nw_rate` smallint(5) unsigned DEFAULT NULL COMMENT 'network rate throttle mbits/s',
  `mc_rate` smallint(5) unsigned DEFAULT NULL COMMENT 'mcast rate throttle mbits/s',
  `traffic_type` varchar(32) NOT NULL COMMENT 'traffic type carried on this network',
  `tags` varchar(4096) DEFAULT NULL COMMENT 'tags supported by this offering',
  `system_only` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is this network offering for system use only',
  `specify_vlan` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Should the user specify vlan',
  `service_offering_id` bigint(20) unsigned DEFAULT NULL COMMENT 'service offering id that virtual router is tied to',
  `conserve_mode` int(1) unsigned NOT NULL DEFAULT '1' COMMENT 'Is this network offering is IP conserve mode enabled',
  `created` datetime NOT NULL COMMENT 'time the entry was created',
  `removed` datetime DEFAULT NULL COMMENT 'time the entry was removed',
  `default` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if network offering is default',
  `availability` varchar(255) NOT NULL COMMENT 'availability of the network',
  `dedicated_lb_service` int(1) unsigned NOT NULL DEFAULT '1' COMMENT 'true if the network offering provides a dedicated load balancer for each network',
  `shared_source_nat_service` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering provides the shared source nat service',
  `sort_key` int(32) NOT NULL DEFAULT '0' COMMENT 'sort key used for customising sort method',
  `redundant_router_service` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering provides the redundant router service',
  `state` char(32) DEFAULT NULL COMMENT 'state of the network offering that has Disabled value by default',
  `guest_type` char(32) DEFAULT NULL COMMENT 'type of guest network that can be shared or isolated',
  `elastic_ip_service` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering provides elastic ip service',
  `eip_associate_public_ip` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if public IP is associated with user VM creation by default when EIP service is enabled.',
  `elastic_lb_service` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering provides elastic lb service',
  `specify_ip_ranges` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering provides an ability to define ip ranges',
  `inline` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is this network offering LB provider is in inline mode',
  `is_persistent` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering provides an ability to create persistent networks',
  `internal_lb` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering supports Internal lb service',
  `public_lb` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network offering supports Public lb service',
  `egress_default_policy` tinyint(1) DEFAULT '0',
  `concurrent_connections` int(10) unsigned DEFAULT NULL COMMENT 'Load Balancer(haproxy) maximum number of concurrent connections(global max)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `unique_name` (`unique_name`),
  UNIQUE KEY `uc_network_offerings__uuid` (`uuid`),
  KEY `i_network_offerings__system_only` (`system_only`),
  KEY `i_network_offerings__removed` (`removed`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_offerings`
--

LOCK TABLES `network_offerings` WRITE;
/*!40000 ALTER TABLE `network_offerings` DISABLE KEYS */;
INSERT INTO `network_offerings` VALUES (1,'System-Public-Network','b1d93343-c5a3-4cb4-89f7-473423a07aa1','System-Public-Network','System Offering for System-Public-Network',0,0,'Public',NULL,1,0,NULL,1,'2013-10-26 06:30:24',NULL,1,'Required',1,0,0,0,'Enabled',NULL,0,1,0,1,0,0,0,0,0,NULL),(2,'System-Management-Network','02873f83-8b5e-42a8-9e66-78a12d94a4e1','System-Management-Network','System Offering for System-Management-Network',0,0,'Management',NULL,1,0,NULL,1,'2013-10-26 06:30:24',NULL,1,'Required',1,0,0,0,'Enabled',NULL,0,1,0,0,0,0,0,0,0,NULL),(3,'System-Control-Network','245a08c5-9b2a-4fce-a36c-339fce179aad','System-Control-Network','System Offering for System-Control-Network',0,0,'Control',NULL,1,0,NULL,1,'2013-10-26 06:30:24',NULL,1,'Required',1,0,0,0,'Enabled',NULL,0,1,0,0,0,0,0,0,0,NULL),(4,'System-Storage-Network','a9a15379-43bf-42af-a2e5-0c5fcf2f2642','System-Storage-Network','System Offering for System-Storage-Network',0,0,'Storage',NULL,1,0,NULL,1,'2013-10-26 06:30:24',NULL,1,'Required',1,0,0,0,'Enabled',NULL,0,1,0,1,0,0,0,0,0,NULL),(5,'System-Private-Gateway-Network-Offering','1f8e95c7-a1f3-4c0b-a3cd-31c52a9c53c1','System-Private-Gateway-Network-Offering','System Offering for System-Private-Gateway-Network-Offering',0,0,'Guest',NULL,1,1,NULL,1,'2013-10-26 06:30:24',NULL,1,'Optional',1,0,0,0,'Enabled','Isolated',0,1,0,0,0,0,0,0,0,NULL),(6,'DefaultSharedNetworkOfferingWithSGService','d2b90dd7-7652-4619-881f-61ba4ae81c3d','DefaultSharedNetworkOfferingWithSGService','Offering for Shared Security group enabled networks',NULL,NULL,'Guest',NULL,0,1,NULL,1,'2013-10-26 06:30:24',NULL,1,'Optional',1,0,0,0,'Enabled','Shared',0,1,0,1,0,0,0,0,0,NULL),(7,'DefaultSharedNetworkOffering','b12213d8-58a7-4b69-abb6-41afa7b28590','DefaultSharedNetworkOffering','Offering for Shared networks',NULL,NULL,'Guest',NULL,0,1,NULL,1,'2013-10-26 06:30:24',NULL,1,'Optional',1,0,0,0,'Enabled','Shared',0,1,0,1,0,0,0,0,0,NULL),(8,'DefaultIsolatedNetworkOfferingWithSourceNatService','3df96f81-8f7a-4fcf-a1c7-af49d739dbd8','DefaultIsolatedNetworkOfferingWithSourceNatService','Offering for Isolated networks with Source Nat service enabled',NULL,NULL,'Guest',NULL,0,0,NULL,1,'2013-10-26 06:30:24',NULL,1,'Required',1,0,0,0,'Enabled','Isolated',0,1,0,0,0,0,0,1,0,NULL),(9,'DefaultIsolatedNetworkOffering','c108639a-d994-4cb7-9b2e-fb308da4c3ef','DefaultIsolatedNetworkOffering','Offering for Isolated networks with no Source Nat service',NULL,NULL,'Guest',NULL,0,1,NULL,1,'2013-10-26 06:30:24',NULL,1,'Optional',1,0,0,0,'Enabled','Isolated',0,1,0,1,0,0,0,0,0,NULL),(10,'DefaultSharedNetscalerEIPandELBNetworkOffering','5f2f77ff-137e-4bd4-9140-8e546fa69996','DefaultSharedNetscalerEIPandELBNetworkOffering','Offering for Shared networks with Elastic IP and Elastic LB capabilities',NULL,NULL,'Guest',NULL,0,1,NULL,1,'2013-10-26 06:30:24',NULL,1,'Optional',0,0,0,0,'Enabled','Shared',1,1,1,1,0,0,0,1,0,NULL),(11,'DefaultIsolatedNetworkOfferingForVpcNetworks','ebbde752-e3c7-43a2-b917-000c77be1998','DefaultIsolatedNetworkOfferingForVpcNetworks','Offering for Isolated Vpc networks with Source Nat service enabled',NULL,NULL,'Guest',NULL,0,0,NULL,0,'2013-10-26 06:30:24',NULL,1,'Optional',1,0,0,0,'Enabled','Isolated',0,1,0,0,0,0,0,1,0,NULL),(12,'DefaultIsolatedNetworkOfferingForVpcNetworksNoLB','e175871f-2e5a-495e-a8ac-612f35a872d0','DefaultIsolatedNetworkOfferingForVpcNetworksNoLB','Offering for Isolated Vpc networks with Source Nat service enabled and LB service Disabled',NULL,NULL,'Guest',NULL,0,0,NULL,0,'2013-10-26 06:30:24',NULL,1,'Optional',1,0,0,0,'Enabled','Isolated',0,1,0,0,0,0,0,0,0,NULL),(13,'DefaultIsolatedNetworkOfferingForVpcNetworksWithInternalLB','7966c0c3-40d4-45e1-88f3-990e3c43770d','DefaultIsolatedNetworkOfferingForVpcNetworksWithInternalLB','Offering for Isolated Vpc networks with Internal LB support',NULL,NULL,'Guest',NULL,0,0,NULL,0,'2013-10-26 06:30:24',NULL,1,'Optional',1,0,0,0,'Enabled','Isolated',0,1,0,0,0,0,1,0,0,NULL),(14,'QuickCloudNoServices','cf4ad1f2-3e7e-47ac-a341-67cace35c516','QuickCloudNoServices','Offering for QuickCloud with no services',NULL,10,'Guest',NULL,0,1,NULL,1,'2013-10-26 06:30:25',NULL,1,'Optional',0,0,0,0,'Enabled','Shared',0,0,0,1,0,0,0,0,0,NULL);
/*!40000 ALTER TABLE `network_offerings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `network_rule_config`
--

DROP TABLE IF EXISTS `network_rule_config`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `network_rule_config` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `security_group_id` bigint(20) unsigned NOT NULL,
  `public_port` varchar(10) DEFAULT NULL,
  `private_port` varchar(10) DEFAULT NULL,
  `protocol` varchar(16) NOT NULL DEFAULT 'TCP',
  `create_status` varchar(32) DEFAULT NULL COMMENT 'rule creation status',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `network_rule_config`
--

LOCK TABLES `network_rule_config` WRITE;
/*!40000 ALTER TABLE `network_rule_config` DISABLE KEYS */;
/*!40000 ALTER TABLE `network_rule_config` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `networks`
--

DROP TABLE IF EXISTS `networks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `networks` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(255) DEFAULT NULL COMMENT 'name for this network',
  `uuid` varchar(40) DEFAULT NULL,
  `display_text` varchar(255) DEFAULT NULL COMMENT 'display text for this network',
  `traffic_type` varchar(32) NOT NULL COMMENT 'type of traffic going through this network',
  `broadcast_domain_type` varchar(32) NOT NULL COMMENT 'type of broadcast domain used',
  `broadcast_uri` varchar(255) DEFAULT NULL COMMENT 'broadcast domain specifier',
  `gateway` varchar(15) DEFAULT NULL COMMENT 'gateway for this network configuration',
  `cidr` varchar(18) DEFAULT NULL COMMENT 'CloudStack managed vms get IP address from cidr.In general this cidr also serves as the network CIDR. But in case IP reservation feature is being used by a Guest network, networkcidr is the Effective network CIDR for that network',
  `mode` varchar(32) DEFAULT NULL COMMENT 'How to retrieve ip address in this network',
  `network_offering_id` bigint(20) unsigned NOT NULL COMMENT 'network offering id that this configuration is created from',
  `physical_network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'physical network id that this configuration is based on',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center id that this configuration is used in',
  `guru_name` varchar(255) NOT NULL COMMENT 'who is responsible for this type of network configuration',
  `state` varchar(32) NOT NULL COMMENT 'what state is this configuration in',
  `related` bigint(20) unsigned NOT NULL COMMENT 'related to what other network configuration',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'foreign key to domain id',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner of this network',
  `dns1` varchar(255) DEFAULT NULL COMMENT 'comma separated DNS list',
  `dns2` varchar(255) DEFAULT NULL COMMENT 'comma separated DNS list',
  `guru_data` varchar(1024) DEFAULT NULL COMMENT 'data stored by the network guru that setup this network',
  `set_fields` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'which fields are set already',
  `acl_type` varchar(15) DEFAULT NULL COMMENT 'ACL access type. Null for system networks, can be Account/Domain for Guest networks',
  `network_domain` varchar(255) DEFAULT NULL COMMENT 'domain',
  `reservation_id` char(40) DEFAULT NULL COMMENT 'reservation id',
  `guest_type` char(32) DEFAULT NULL COMMENT 'type of guest network that can be shared or isolated',
  `restart_required` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if restart is required for the network',
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `specify_ip_ranges` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the network provides an ability to define ip ranges',
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vpc this network belongs to',
  `ip6_gateway` varchar(50) DEFAULT NULL COMMENT 'IPv6 gateway for this network',
  `ip6_cidr` varchar(50) DEFAULT NULL COMMENT 'IPv6 cidr for this network',
  `network_cidr` varchar(18) DEFAULT NULL COMMENT 'The network cidr for the isolated guest network which uses IP Reservation facility.For networks not using IP reservation, network_cidr is always null.',
  `display_network` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should network be displayed to the end user',
  `network_acl_id` bigint(20) unsigned DEFAULT NULL COMMENT 'network acl id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_networks__uuid` (`uuid`),
  KEY `fk_networks__network_offering_id` (`network_offering_id`),
  KEY `fk_networks__data_center_id` (`data_center_id`),
  KEY `fk_networks__related` (`related`),
  KEY `fk_networks__account_id` (`account_id`),
  KEY `fk_networks__domain_id` (`domain_id`),
  KEY `fk_networks__vpc_id` (`vpc_id`),
  KEY `i_networks__removed` (`removed`),
  CONSTRAINT `fk_networks__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_networks__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_networks__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`),
  CONSTRAINT `fk_networks__network_offering_id` FOREIGN KEY (`network_offering_id`) REFERENCES `network_offerings` (`id`),
  CONSTRAINT `fk_networks__related` FOREIGN KEY (`related`) REFERENCES `networks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_networks__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=204 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `networks`
--

LOCK TABLES `networks` WRITE;
/*!40000 ALTER TABLE `networks` DISABLE KEYS */;
INSERT INTO `networks` VALUES (200,NULL,'675b2d81-dfbd-4e9b-8be6-32e19e5ef70d',NULL,'Public','Vlan',NULL,NULL,NULL,'Static',1,NULL,1,'PublicNetworkGuru','Setup',200,1,1,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,0,'2013-10-26 06:35:26',NULL,1,NULL,NULL,NULL,NULL,1,NULL),(201,NULL,'93fc5ebc-34fc-48c8-8414-90aae876bf64',NULL,'Management','Native',NULL,NULL,NULL,'Static',2,NULL,1,'PodBasedNetworkGuru','Setup',201,1,1,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,0,'2013-10-26 06:35:26',NULL,0,NULL,NULL,NULL,NULL,1,NULL),(202,NULL,'c24e9c72-1053-4e76-936f-f51a8ae89fc8',NULL,'Control','LinkLocal',NULL,'169.254.0.1','169.254.0.0/16','Static',3,NULL,1,'ControlNetworkGuru','Setup',202,1,1,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,0,'2013-10-26 06:35:26',NULL,0,NULL,NULL,NULL,NULL,1,NULL),(203,NULL,'515f7560-629d-4218-8f51-11c7798e185b',NULL,'Storage','Native',NULL,NULL,NULL,'Static',4,NULL,1,'StorageNetworkGuru','Setup',203,1,1,NULL,NULL,NULL,0,NULL,NULL,NULL,NULL,0,'2013-10-26 06:35:26',NULL,1,NULL,NULL,NULL,NULL,1,NULL);
/*!40000 ALTER TABLE `networks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nic_details`
--

DROP TABLE IF EXISTS `nic_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nic_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `nic_id` bigint(20) unsigned NOT NULL COMMENT 'nic id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) NOT NULL,
  `display_detail` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should detail be displayed to the end user',
  PRIMARY KEY (`id`),
  KEY `fk_nic_details__nic_id` (`nic_id`),
  CONSTRAINT `fk_nic_details__nic_id` FOREIGN KEY (`nic_id`) REFERENCES `nics` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nic_details`
--

LOCK TABLES `nic_details` WRITE;
/*!40000 ALTER TABLE `nic_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `nic_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nic_ip_alias`
--

DROP TABLE IF EXISTS `nic_ip_alias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nic_ip_alias` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) NOT NULL,
  `nic_id` bigint(20) unsigned DEFAULT NULL,
  `ip4_address` char(40) DEFAULT NULL,
  `ip6_address` char(40) DEFAULT NULL,
  `netmask` char(40) DEFAULT NULL,
  `gateway` char(40) DEFAULT NULL,
  `start_ip_of_subnet` char(40) DEFAULT NULL,
  `network_id` bigint(20) unsigned DEFAULT NULL,
  `vmId` bigint(20) unsigned DEFAULT NULL,
  `alias_count` bigint(20) unsigned DEFAULT NULL,
  `created` datetime NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `state` char(32) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id_UNIQUE` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nic_ip_alias`
--

LOCK TABLES `nic_ip_alias` WRITE;
/*!40000 ALTER TABLE `nic_ip_alias` DISABLE KEYS */;
/*!40000 ALTER TABLE `nic_ip_alias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nic_secondary_ips`
--

DROP TABLE IF EXISTS `nic_secondary_ips`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nic_secondary_ips` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `vmId` bigint(20) unsigned DEFAULT NULL COMMENT 'vm instance id',
  `nicId` bigint(20) unsigned NOT NULL,
  `ip4_address` char(40) DEFAULT NULL COMMENT 'ip4 address',
  `ip6_address` char(40) DEFAULT NULL COMMENT 'ip6 address',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network configuration id',
  `created` datetime NOT NULL COMMENT 'date created',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner.  foreign key to   account table',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'the domain that the owner belongs to',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_nic_secondary_ip__uuid` (`uuid`),
  KEY `fk_nic_secondary_ip__vmId` (`vmId`),
  KEY `fk_nic_secondary_ip__networks_id` (`network_id`),
  CONSTRAINT `fk_nic_secondary_ip__vmId` FOREIGN KEY (`vmId`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_nic_secondary_ip__networks_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nic_secondary_ips`
--

LOCK TABLES `nic_secondary_ips` WRITE;
/*!40000 ALTER TABLE `nic_secondary_ips` DISABLE KEYS */;
/*!40000 ALTER TABLE `nic_secondary_ips` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nicira_nvp_nic_map`
--

DROP TABLE IF EXISTS `nicira_nvp_nic_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nicira_nvp_nic_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `logicalswitch` varchar(255) NOT NULL COMMENT 'nicira uuid of logical switch this port is provisioned on',
  `logicalswitchport` varchar(255) DEFAULT NULL COMMENT 'nicira uuid of this logical switch port',
  `nic` varchar(255) DEFAULT NULL COMMENT 'cloudstack uuid of the nic connected to this logical switch port',
  PRIMARY KEY (`id`),
  UNIQUE KEY `logicalswitchport` (`logicalswitchport`),
  UNIQUE KEY `nic` (`nic`),
  CONSTRAINT `fk_nicira_nvp_nic_map__nic` FOREIGN KEY (`nic`) REFERENCES `nics` (`uuid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nicira_nvp_nic_map`
--

LOCK TABLES `nicira_nvp_nic_map` WRITE;
/*!40000 ALTER TABLE `nicira_nvp_nic_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `nicira_nvp_nic_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nicira_nvp_router_map`
--

DROP TABLE IF EXISTS `nicira_nvp_router_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nicira_nvp_router_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `logicalrouter_uuid` varchar(255) NOT NULL COMMENT 'nicira uuid of logical router',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'cloudstack id of the network',
  PRIMARY KEY (`id`),
  UNIQUE KEY `logicalrouter_uuid` (`logicalrouter_uuid`),
  UNIQUE KEY `network_id` (`network_id`),
  CONSTRAINT `fk_nicira_nvp_router_map__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nicira_nvp_router_map`
--

LOCK TABLES `nicira_nvp_router_map` WRITE;
/*!40000 ALTER TABLE `nicira_nvp_router_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `nicira_nvp_router_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `nics`
--

DROP TABLE IF EXISTS `nics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `nics` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `instance_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vm instance id',
  `mac_address` varchar(17) DEFAULT NULL COMMENT 'mac address',
  `ip4_address` char(40) DEFAULT NULL COMMENT 'ip4 address',
  `netmask` varchar(15) DEFAULT NULL COMMENT 'netmask for ip4 address',
  `gateway` varchar(15) DEFAULT NULL COMMENT 'gateway',
  `ip_type` varchar(32) DEFAULT NULL COMMENT 'type of ip',
  `broadcast_uri` varchar(255) DEFAULT NULL COMMENT 'broadcast uri',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network configuration id',
  `mode` varchar(32) DEFAULT NULL COMMENT 'mode of getting ip address',
  `state` varchar(32) NOT NULL COMMENT 'state of the creation',
  `strategy` varchar(32) NOT NULL COMMENT 'reservation strategy',
  `reserver_name` varchar(255) DEFAULT NULL COMMENT 'Name of the component that reserved the ip address',
  `reservation_id` varchar(64) DEFAULT NULL COMMENT 'id for the reservation',
  `device_id` int(10) DEFAULT NULL COMMENT 'device id for the network when plugged into the virtual machine',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT 'time the state was changed',
  `isolation_uri` varchar(255) DEFAULT NULL COMMENT 'id for isolation',
  `ip6_address` char(40) DEFAULT NULL COMMENT 'ip6 address',
  `default_nic` tinyint(4) NOT NULL COMMENT 'None',
  `vm_type` varchar(32) DEFAULT NULL COMMENT 'type of vm: System or User vm',
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `ip6_gateway` varchar(50) DEFAULT NULL COMMENT 'gateway for ip6 address',
  `ip6_cidr` varchar(50) DEFAULT NULL COMMENT 'cidr for ip6 address',
  `secondary_ip` smallint(6) DEFAULT '0' COMMENT 'secondary ips configured for the nic',
  `display_nic` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should nic be displayed to the end user',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_nics__uuid` (`uuid`),
  KEY `fk_nics__instance_id` (`instance_id`),
  KEY `fk_nics__networks_id` (`network_id`),
  KEY `i_nics__removed` (`removed`),
  CONSTRAINT `fk_nics__instance_id` FOREIGN KEY (`instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_nics__networks_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `nics`
--

LOCK TABLES `nics` WRITE;
/*!40000 ALTER TABLE `nics` DISABLE KEYS */;
INSERT INTO `nics` VALUES (1,'e173bf5d-51f2-466b-ad1b-5caebb62a4b0',1,'06:d4:0e:00:00:5b','192.168.4.100','255.255.255.0','192.168.4.1','Ip4','vlan://untagged',200,'Static','Allocated','Create','PublicNetworkGuru',NULL,2,'2013-10-26 06:37:25','vlan://untagged',NULL,1,'SecondaryStorageVm','2013-10-26 06:37:25',NULL,NULL,NULL,0,1),(2,'9f9e36d0-f8b5-4932-bd28-c1e99f39cec0',1,NULL,NULL,NULL,NULL,NULL,NULL,202,'Static','Allocated','Start','ControlNetworkGuru','4b2a6384-054f-4716-9e18-550fc097a6a7',0,'2013-10-26 06:37:25',NULL,NULL,0,'SecondaryStorageVm','2013-10-26 06:37:25',NULL,NULL,NULL,0,1),(3,'0c0dd383-5e41-4f44-92d9-59d9c413159e',1,NULL,NULL,NULL,NULL,NULL,NULL,201,'Static','Allocated','Start','PodBasedNetworkGuru','4b2a6384-054f-4716-9e18-550fc097a6a7',1,'2013-10-26 06:37:25',NULL,NULL,0,'SecondaryStorageVm','2013-10-26 06:37:25',NULL,NULL,NULL,0,1),(4,'b00f29c4-3825-40dd-a0d7-f74989158794',1,NULL,NULL,NULL,NULL,NULL,NULL,203,'Static','Allocated','Start','StorageNetworkGuru','4b2a6384-054f-4716-9e18-550fc097a6a7',3,'2013-10-26 06:37:25',NULL,NULL,0,'SecondaryStorageVm','2013-10-26 06:37:25',NULL,NULL,NULL,0,1),(5,'850992b6-6458-40a0-8d22-d7cc4c9de846',2,'06:d5:b8:00:00:5c','192.168.4.101','255.255.255.0','192.168.4.1','Ip4','vlan://untagged',200,'Static','Allocated','Create','PublicNetworkGuru',NULL,2,'2013-10-26 06:37:25','vlan://untagged',NULL,1,'ConsoleProxy','2013-10-26 06:37:25',NULL,NULL,NULL,0,1),(6,'c81c0c43-2a41-4595-b197-69a6a41cea44',2,NULL,NULL,NULL,NULL,NULL,NULL,202,'Static','Allocated','Start','ControlNetworkGuru','199c52f6-7787-4e25-9f86-af6dcd84d720',0,'2013-10-26 06:37:25',NULL,NULL,0,'ConsoleProxy','2013-10-26 06:37:25',NULL,NULL,NULL,0,1),(7,'c4f6199e-c854-4e71-8bf8-ea821257d6f7',2,NULL,NULL,NULL,NULL,NULL,NULL,201,'Static','Allocated','Start','PodBasedNetworkGuru','199c52f6-7787-4e25-9f86-af6dcd84d720',1,'2013-10-26 06:37:25',NULL,NULL,0,'ConsoleProxy','2013-10-26 06:37:25',NULL,NULL,NULL,0,1);
/*!40000 ALTER TABLE `nics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ntwk_offering_service_map`
--

DROP TABLE IF EXISTS `ntwk_offering_service_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ntwk_offering_service_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `network_offering_id` bigint(20) unsigned NOT NULL COMMENT 'network_offering_id',
  `service` varchar(255) NOT NULL COMMENT 'service',
  `provider` varchar(255) DEFAULT NULL COMMENT 'service provider',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `network_offering_id` (`network_offering_id`,`service`,`provider`),
  CONSTRAINT `fk_ntwk_offering_service_map__network_offering_id` FOREIGN KEY (`network_offering_id`) REFERENCES `network_offerings` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ntwk_offering_service_map`
--

LOCK TABLES `ntwk_offering_service_map` WRITE;
/*!40000 ALTER TABLE `ntwk_offering_service_map` DISABLE KEYS */;
INSERT INTO `ntwk_offering_service_map` VALUES (1,6,'UserData','VirtualRouter','2013-10-26 06:30:24'),(2,6,'Dns','VirtualRouter','2013-10-26 06:30:24'),(3,6,'SecurityGroup','SecurityGroupProvider','2013-10-26 06:30:24'),(4,6,'Dhcp','VirtualRouter','2013-10-26 06:30:24'),(5,7,'UserData','VirtualRouter','2013-10-26 06:30:24'),(6,7,'Dns','VirtualRouter','2013-10-26 06:30:24'),(7,7,'Dhcp','VirtualRouter','2013-10-26 06:30:24'),(8,8,'PortForwarding','VirtualRouter','2013-10-26 06:30:24'),(9,8,'UserData','VirtualRouter','2013-10-26 06:30:24'),(10,8,'Dns','VirtualRouter','2013-10-26 06:30:24'),(11,8,'Vpn','VirtualRouter','2013-10-26 06:30:24'),(12,8,'SourceNat','VirtualRouter','2013-10-26 06:30:24'),(13,8,'Firewall','VirtualRouter','2013-10-26 06:30:24'),(14,8,'Lb','VirtualRouter','2013-10-26 06:30:24'),(15,8,'StaticNat','VirtualRouter','2013-10-26 06:30:24'),(16,8,'Gateway','VirtualRouter','2013-10-26 06:30:24'),(17,8,'Dhcp','VirtualRouter','2013-10-26 06:30:24'),(18,9,'UserData','VirtualRouter','2013-10-26 06:30:24'),(19,9,'Dns','VirtualRouter','2013-10-26 06:30:24'),(20,9,'Dhcp','VirtualRouter','2013-10-26 06:30:24'),(21,10,'UserData','VirtualRouter','2013-10-26 06:30:24'),(22,10,'Dns','VirtualRouter','2013-10-26 06:30:24'),(23,10,'SecurityGroup','SecurityGroupProvider','2013-10-26 06:30:24'),(24,10,'Lb','Netscaler','2013-10-26 06:30:24'),(25,10,'StaticNat','Netscaler','2013-10-26 06:30:24'),(26,10,'Dhcp','VirtualRouter','2013-10-26 06:30:24'),(27,11,'NetworkACL','VpcVirtualRouter','2013-10-26 06:30:24'),(28,11,'PortForwarding','VpcVirtualRouter','2013-10-26 06:30:24'),(29,11,'UserData','VpcVirtualRouter','2013-10-26 06:30:24'),(30,11,'Dns','VpcVirtualRouter','2013-10-26 06:30:24'),(31,11,'Vpn','VpcVirtualRouter','2013-10-26 06:30:24'),(32,11,'SourceNat','VpcVirtualRouter','2013-10-26 06:30:24'),(33,11,'Lb','VpcVirtualRouter','2013-10-26 06:30:24'),(34,11,'StaticNat','VpcVirtualRouter','2013-10-26 06:30:24'),(35,11,'Gateway','VpcVirtualRouter','2013-10-26 06:30:24'),(36,11,'Dhcp','VpcVirtualRouter','2013-10-26 06:30:24'),(37,12,'NetworkACL','VpcVirtualRouter','2013-10-26 06:30:24'),(38,12,'PortForwarding','VpcVirtualRouter','2013-10-26 06:30:24'),(39,12,'UserData','VpcVirtualRouter','2013-10-26 06:30:24'),(40,12,'Dns','VpcVirtualRouter','2013-10-26 06:30:24'),(41,12,'Vpn','VpcVirtualRouter','2013-10-26 06:30:24'),(42,12,'SourceNat','VpcVirtualRouter','2013-10-26 06:30:24'),(43,12,'StaticNat','VpcVirtualRouter','2013-10-26 06:30:24'),(44,12,'Gateway','VpcVirtualRouter','2013-10-26 06:30:24'),(45,12,'Dhcp','VpcVirtualRouter','2013-10-26 06:30:24'),(46,13,'NetworkACL','VpcVirtualRouter','2013-10-26 06:30:24'),(47,13,'UserData','VpcVirtualRouter','2013-10-26 06:30:24'),(48,13,'Dns','VpcVirtualRouter','2013-10-26 06:30:24'),(49,13,'SourceNat','VpcVirtualRouter','2013-10-26 06:30:24'),(50,13,'Lb','InternalLbVm','2013-10-26 06:30:24'),(51,13,'Gateway','VpcVirtualRouter','2013-10-26 06:30:24'),(52,13,'Dhcp','VpcVirtualRouter','2013-10-26 06:30:24');
/*!40000 ALTER TABLE `ntwk_offering_service_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ntwk_service_map`
--

DROP TABLE IF EXISTS `ntwk_service_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ntwk_service_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network_id',
  `service` varchar(255) NOT NULL COMMENT 'service',
  `provider` varchar(255) DEFAULT NULL COMMENT 'service provider',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `network_id` (`network_id`,`service`,`provider`),
  CONSTRAINT `fk_ntwk_service_map__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ntwk_service_map`
--

LOCK TABLES `ntwk_service_map` WRITE;
/*!40000 ALTER TABLE `ntwk_service_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `ntwk_service_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `object_datastore_ref`
--

DROP TABLE IF EXISTS `object_datastore_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `object_datastore_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `datastore_uuid` varchar(255) NOT NULL,
  `datastore_role` varchar(255) NOT NULL,
  `object_uuid` varchar(255) NOT NULL,
  `object_type` varchar(255) NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `download_pct` int(10) unsigned DEFAULT NULL,
  `download_state` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `format` varchar(255) DEFAULT NULL,
  `checksum` varchar(255) DEFAULT NULL,
  `error_str` varchar(255) DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  `install_path` varchar(255) DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL COMMENT 'the size of the template on the pool',
  `state` varchar(255) NOT NULL,
  `update_count` bigint(20) unsigned NOT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `object_datastore_ref`
--

LOCK TABLES `object_datastore_ref` WRITE;
/*!40000 ALTER TABLE `object_datastore_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `object_datastore_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_dc_ip_address_alloc`
--

DROP TABLE IF EXISTS `op_dc_ip_address_alloc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_dc_ip_address_alloc` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `ip_address` char(40) NOT NULL COMMENT 'ip address',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center it belongs to',
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod it belongs to',
  `nic_id` bigint(20) unsigned DEFAULT NULL COMMENT 'nic id',
  `reservation_id` char(40) DEFAULT NULL COMMENT 'reservation id',
  `taken` datetime DEFAULT NULL COMMENT 'Date taken',
  `mac_address` bigint(20) unsigned NOT NULL COMMENT 'mac address for management ips',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_op_dc_ip_address_alloc__ip_address__data_center_id` (`ip_address`,`data_center_id`),
  KEY `fk_op_dc_ip_address_alloc__data_center_id` (`data_center_id`),
  KEY `i_op_dc_ip_address_alloc__pod_id__data_center_id__taken` (`pod_id`,`data_center_id`,`taken`,`nic_id`),
  KEY `i_op_dc_ip_address_alloc__pod_id` (`pod_id`),
  CONSTRAINT `fk_op_dc_ip_address_alloc__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_op_dc_ip_address_alloc__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=91 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_dc_ip_address_alloc`
--

LOCK TABLES `op_dc_ip_address_alloc` WRITE;
/*!40000 ALTER TABLE `op_dc_ip_address_alloc` DISABLE KEYS */;
INSERT INTO `op_dc_ip_address_alloc` VALUES (1,'192.168.3.10',1,1,NULL,NULL,NULL,1),(2,'192.168.3.11',1,1,NULL,NULL,NULL,2),(3,'192.168.3.12',1,1,NULL,NULL,NULL,3),(4,'192.168.3.13',1,1,NULL,NULL,NULL,4),(5,'192.168.3.14',1,1,NULL,NULL,NULL,5),(6,'192.168.3.15',1,1,NULL,NULL,NULL,6),(7,'192.168.3.16',1,1,NULL,NULL,NULL,7),(8,'192.168.3.17',1,1,NULL,NULL,NULL,8),(9,'192.168.3.18',1,1,NULL,NULL,NULL,9),(10,'192.168.3.19',1,1,NULL,NULL,NULL,10),(11,'192.168.3.20',1,1,NULL,NULL,NULL,11),(12,'192.168.3.21',1,1,NULL,NULL,NULL,12),(13,'192.168.3.22',1,1,NULL,NULL,NULL,13),(14,'192.168.3.23',1,1,NULL,NULL,NULL,14),(15,'192.168.3.24',1,1,NULL,NULL,NULL,15),(16,'192.168.3.25',1,1,NULL,NULL,NULL,16),(17,'192.168.3.26',1,1,NULL,NULL,NULL,17),(18,'192.168.3.27',1,1,NULL,NULL,NULL,18),(19,'192.168.3.28',1,1,NULL,NULL,NULL,19),(20,'192.168.3.29',1,1,NULL,NULL,NULL,20),(21,'192.168.3.30',1,1,NULL,NULL,NULL,21),(22,'192.168.3.31',1,1,NULL,NULL,NULL,22),(23,'192.168.3.32',1,1,NULL,NULL,NULL,23),(24,'192.168.3.33',1,1,NULL,NULL,NULL,24),(25,'192.168.3.34',1,1,NULL,NULL,NULL,25),(26,'192.168.3.35',1,1,NULL,NULL,NULL,26),(27,'192.168.3.36',1,1,NULL,NULL,NULL,27),(28,'192.168.3.37',1,1,NULL,NULL,NULL,28),(29,'192.168.3.38',1,1,NULL,NULL,NULL,29),(30,'192.168.3.39',1,1,NULL,NULL,NULL,30),(31,'192.168.3.40',1,1,NULL,NULL,NULL,31),(32,'192.168.3.41',1,1,NULL,NULL,NULL,32),(33,'192.168.3.42',1,1,NULL,NULL,NULL,33),(34,'192.168.3.43',1,1,NULL,NULL,NULL,34),(35,'192.168.3.44',1,1,NULL,NULL,NULL,35),(36,'192.168.3.45',1,1,NULL,NULL,NULL,36),(37,'192.168.3.46',1,1,NULL,NULL,NULL,37),(38,'192.168.3.47',1,1,NULL,NULL,NULL,38),(39,'192.168.3.48',1,1,NULL,NULL,NULL,39),(40,'192.168.3.49',1,1,NULL,NULL,NULL,40),(41,'192.168.3.50',1,1,NULL,NULL,NULL,41),(42,'192.168.3.51',1,1,NULL,NULL,NULL,42),(43,'192.168.3.52',1,1,NULL,NULL,NULL,43),(44,'192.168.3.53',1,1,NULL,NULL,NULL,44),(45,'192.168.3.54',1,1,NULL,NULL,NULL,45),(46,'192.168.3.55',1,1,NULL,NULL,NULL,46),(47,'192.168.3.56',1,1,NULL,NULL,NULL,47),(48,'192.168.3.57',1,1,NULL,NULL,NULL,48),(49,'192.168.3.58',1,1,NULL,NULL,NULL,49),(50,'192.168.3.59',1,1,NULL,NULL,NULL,50),(51,'192.168.3.60',1,1,NULL,NULL,NULL,51),(52,'192.168.3.61',1,1,NULL,NULL,NULL,52),(53,'192.168.3.62',1,1,NULL,NULL,NULL,53),(54,'192.168.3.63',1,1,NULL,NULL,NULL,54),(55,'192.168.3.64',1,1,NULL,NULL,NULL,55),(56,'192.168.3.65',1,1,NULL,NULL,NULL,56),(57,'192.168.3.66',1,1,NULL,NULL,NULL,57),(58,'192.168.3.67',1,1,NULL,NULL,NULL,58),(59,'192.168.3.68',1,1,NULL,NULL,NULL,59),(60,'192.168.3.69',1,1,NULL,NULL,NULL,60),(61,'192.168.3.70',1,1,NULL,NULL,NULL,61),(62,'192.168.3.71',1,1,NULL,NULL,NULL,62),(63,'192.168.3.72',1,1,NULL,NULL,NULL,63),(64,'192.168.3.73',1,1,NULL,NULL,NULL,64),(65,'192.168.3.74',1,1,NULL,NULL,NULL,65),(66,'192.168.3.75',1,1,NULL,NULL,NULL,66),(67,'192.168.3.76',1,1,NULL,NULL,NULL,67),(68,'192.168.3.77',1,1,NULL,NULL,NULL,68),(69,'192.168.3.78',1,1,NULL,NULL,NULL,69),(70,'192.168.3.79',1,1,NULL,NULL,NULL,70),(71,'192.168.3.80',1,1,NULL,NULL,NULL,71),(72,'192.168.3.81',1,1,NULL,NULL,NULL,72),(73,'192.168.3.82',1,1,NULL,NULL,NULL,73),(74,'192.168.3.83',1,1,NULL,NULL,NULL,74),(75,'192.168.3.84',1,1,NULL,NULL,NULL,75),(76,'192.168.3.85',1,1,NULL,NULL,NULL,76),(77,'192.168.3.86',1,1,NULL,NULL,NULL,77),(78,'192.168.3.87',1,1,NULL,NULL,NULL,78),(79,'192.168.3.88',1,1,NULL,NULL,NULL,79),(80,'192.168.3.89',1,1,NULL,NULL,NULL,80),(81,'192.168.3.90',1,1,NULL,NULL,NULL,81),(82,'192.168.3.91',1,1,NULL,NULL,NULL,82),(83,'192.168.3.92',1,1,NULL,NULL,NULL,83),(84,'192.168.3.93',1,1,NULL,NULL,NULL,84),(85,'192.168.3.94',1,1,NULL,NULL,NULL,85),(86,'192.168.3.95',1,1,NULL,NULL,NULL,86),(87,'192.168.3.96',1,1,NULL,NULL,NULL,87),(88,'192.168.3.97',1,1,NULL,NULL,NULL,88),(89,'192.168.3.98',1,1,NULL,NULL,NULL,89),(90,'192.168.3.99',1,1,NULL,NULL,NULL,90);
/*!40000 ALTER TABLE `op_dc_ip_address_alloc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_dc_link_local_ip_address_alloc`
--

DROP TABLE IF EXISTS `op_dc_link_local_ip_address_alloc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_dc_link_local_ip_address_alloc` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `ip_address` char(40) NOT NULL COMMENT 'ip address',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center it belongs to',
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod it belongs to',
  `nic_id` bigint(20) unsigned DEFAULT NULL COMMENT 'instance id',
  `reservation_id` char(40) DEFAULT NULL COMMENT 'reservation id used to reserve this network',
  `taken` datetime DEFAULT NULL COMMENT 'Date taken',
  PRIMARY KEY (`id`),
  KEY `i_op_dc_link_local_ip_address_alloc__pod_id` (`pod_id`),
  KEY `i_op_dc_link_local_ip_address_alloc__data_center_id` (`data_center_id`),
  KEY `i_op_dc_link_local_ip_address_alloc__nic_id_reservation_id` (`nic_id`,`reservation_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1022 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_dc_link_local_ip_address_alloc`
--

LOCK TABLES `op_dc_link_local_ip_address_alloc` WRITE;
/*!40000 ALTER TABLE `op_dc_link_local_ip_address_alloc` DISABLE KEYS */;
INSERT INTO `op_dc_link_local_ip_address_alloc` VALUES (1,'169.254.0.2',1,1,NULL,NULL,NULL),(2,'169.254.0.3',1,1,NULL,NULL,NULL),(3,'169.254.0.4',1,1,NULL,NULL,NULL),(4,'169.254.0.5',1,1,NULL,NULL,NULL),(5,'169.254.0.6',1,1,NULL,NULL,NULL),(6,'169.254.0.7',1,1,NULL,NULL,NULL),(7,'169.254.0.8',1,1,NULL,NULL,NULL),(8,'169.254.0.9',1,1,NULL,NULL,NULL),(9,'169.254.0.10',1,1,NULL,NULL,NULL),(10,'169.254.0.11',1,1,NULL,NULL,NULL),(11,'169.254.0.12',1,1,NULL,NULL,NULL),(12,'169.254.0.13',1,1,NULL,NULL,NULL),(13,'169.254.0.14',1,1,NULL,NULL,NULL),(14,'169.254.0.15',1,1,NULL,NULL,NULL),(15,'169.254.0.16',1,1,NULL,NULL,NULL),(16,'169.254.0.17',1,1,NULL,NULL,NULL),(17,'169.254.0.18',1,1,NULL,NULL,NULL),(18,'169.254.0.19',1,1,NULL,NULL,NULL),(19,'169.254.0.20',1,1,NULL,NULL,NULL),(20,'169.254.0.21',1,1,NULL,NULL,NULL),(21,'169.254.0.22',1,1,NULL,NULL,NULL),(22,'169.254.0.23',1,1,NULL,NULL,NULL),(23,'169.254.0.24',1,1,NULL,NULL,NULL),(24,'169.254.0.25',1,1,NULL,NULL,NULL),(25,'169.254.0.26',1,1,NULL,NULL,NULL),(26,'169.254.0.27',1,1,NULL,NULL,NULL),(27,'169.254.0.28',1,1,NULL,NULL,NULL),(28,'169.254.0.29',1,1,NULL,NULL,NULL),(29,'169.254.0.30',1,1,NULL,NULL,NULL),(30,'169.254.0.31',1,1,NULL,NULL,NULL),(31,'169.254.0.32',1,1,NULL,NULL,NULL),(32,'169.254.0.33',1,1,NULL,NULL,NULL),(33,'169.254.0.34',1,1,NULL,NULL,NULL),(34,'169.254.0.35',1,1,NULL,NULL,NULL),(35,'169.254.0.36',1,1,NULL,NULL,NULL),(36,'169.254.0.37',1,1,NULL,NULL,NULL),(37,'169.254.0.38',1,1,NULL,NULL,NULL),(38,'169.254.0.39',1,1,NULL,NULL,NULL),(39,'169.254.0.40',1,1,NULL,NULL,NULL),(40,'169.254.0.41',1,1,NULL,NULL,NULL),(41,'169.254.0.42',1,1,NULL,NULL,NULL),(42,'169.254.0.43',1,1,NULL,NULL,NULL),(43,'169.254.0.44',1,1,NULL,NULL,NULL),(44,'169.254.0.45',1,1,NULL,NULL,NULL),(45,'169.254.0.46',1,1,NULL,NULL,NULL),(46,'169.254.0.47',1,1,NULL,NULL,NULL),(47,'169.254.0.48',1,1,NULL,NULL,NULL),(48,'169.254.0.49',1,1,NULL,NULL,NULL),(49,'169.254.0.50',1,1,NULL,NULL,NULL),(50,'169.254.0.51',1,1,NULL,NULL,NULL),(51,'169.254.0.52',1,1,NULL,NULL,NULL),(52,'169.254.0.53',1,1,NULL,NULL,NULL),(53,'169.254.0.54',1,1,NULL,NULL,NULL),(54,'169.254.0.55',1,1,NULL,NULL,NULL),(55,'169.254.0.56',1,1,NULL,NULL,NULL),(56,'169.254.0.57',1,1,NULL,NULL,NULL),(57,'169.254.0.58',1,1,NULL,NULL,NULL),(58,'169.254.0.59',1,1,NULL,NULL,NULL),(59,'169.254.0.60',1,1,NULL,NULL,NULL),(60,'169.254.0.61',1,1,NULL,NULL,NULL),(61,'169.254.0.62',1,1,NULL,NULL,NULL),(62,'169.254.0.63',1,1,NULL,NULL,NULL),(63,'169.254.0.64',1,1,NULL,NULL,NULL),(64,'169.254.0.65',1,1,NULL,NULL,NULL),(65,'169.254.0.66',1,1,NULL,NULL,NULL),(66,'169.254.0.67',1,1,NULL,NULL,NULL),(67,'169.254.0.68',1,1,NULL,NULL,NULL),(68,'169.254.0.69',1,1,NULL,NULL,NULL),(69,'169.254.0.70',1,1,NULL,NULL,NULL),(70,'169.254.0.71',1,1,NULL,NULL,NULL),(71,'169.254.0.72',1,1,NULL,NULL,NULL),(72,'169.254.0.73',1,1,NULL,NULL,NULL),(73,'169.254.0.74',1,1,NULL,NULL,NULL),(74,'169.254.0.75',1,1,NULL,NULL,NULL),(75,'169.254.0.76',1,1,NULL,NULL,NULL),(76,'169.254.0.77',1,1,NULL,NULL,NULL),(77,'169.254.0.78',1,1,NULL,NULL,NULL),(78,'169.254.0.79',1,1,NULL,NULL,NULL),(79,'169.254.0.80',1,1,NULL,NULL,NULL),(80,'169.254.0.81',1,1,NULL,NULL,NULL),(81,'169.254.0.82',1,1,NULL,NULL,NULL),(82,'169.254.0.83',1,1,NULL,NULL,NULL),(83,'169.254.0.84',1,1,NULL,NULL,NULL),(84,'169.254.0.85',1,1,NULL,NULL,NULL),(85,'169.254.0.86',1,1,NULL,NULL,NULL),(86,'169.254.0.87',1,1,NULL,NULL,NULL),(87,'169.254.0.88',1,1,NULL,NULL,NULL),(88,'169.254.0.89',1,1,NULL,NULL,NULL),(89,'169.254.0.90',1,1,NULL,NULL,NULL),(90,'169.254.0.91',1,1,NULL,NULL,NULL),(91,'169.254.0.92',1,1,NULL,NULL,NULL),(92,'169.254.0.93',1,1,NULL,NULL,NULL),(93,'169.254.0.94',1,1,NULL,NULL,NULL),(94,'169.254.0.95',1,1,NULL,NULL,NULL),(95,'169.254.0.96',1,1,NULL,NULL,NULL),(96,'169.254.0.97',1,1,NULL,NULL,NULL),(97,'169.254.0.98',1,1,NULL,NULL,NULL),(98,'169.254.0.99',1,1,NULL,NULL,NULL),(99,'169.254.0.100',1,1,NULL,NULL,NULL),(100,'169.254.0.101',1,1,NULL,NULL,NULL),(101,'169.254.0.102',1,1,NULL,NULL,NULL),(102,'169.254.0.103',1,1,NULL,NULL,NULL),(103,'169.254.0.104',1,1,NULL,NULL,NULL),(104,'169.254.0.105',1,1,NULL,NULL,NULL),(105,'169.254.0.106',1,1,NULL,NULL,NULL),(106,'169.254.0.107',1,1,NULL,NULL,NULL),(107,'169.254.0.108',1,1,NULL,NULL,NULL),(108,'169.254.0.109',1,1,NULL,NULL,NULL),(109,'169.254.0.110',1,1,NULL,NULL,NULL),(110,'169.254.0.111',1,1,NULL,NULL,NULL),(111,'169.254.0.112',1,1,NULL,NULL,NULL),(112,'169.254.0.113',1,1,NULL,NULL,NULL),(113,'169.254.0.114',1,1,NULL,NULL,NULL),(114,'169.254.0.115',1,1,NULL,NULL,NULL),(115,'169.254.0.116',1,1,NULL,NULL,NULL),(116,'169.254.0.117',1,1,NULL,NULL,NULL),(117,'169.254.0.118',1,1,NULL,NULL,NULL),(118,'169.254.0.119',1,1,NULL,NULL,NULL),(119,'169.254.0.120',1,1,NULL,NULL,NULL),(120,'169.254.0.121',1,1,NULL,NULL,NULL),(121,'169.254.0.122',1,1,NULL,NULL,NULL),(122,'169.254.0.123',1,1,NULL,NULL,NULL),(123,'169.254.0.124',1,1,NULL,NULL,NULL),(124,'169.254.0.125',1,1,NULL,NULL,NULL),(125,'169.254.0.126',1,1,NULL,NULL,NULL),(126,'169.254.0.127',1,1,NULL,NULL,NULL),(127,'169.254.0.128',1,1,NULL,NULL,NULL),(128,'169.254.0.129',1,1,NULL,NULL,NULL),(129,'169.254.0.130',1,1,NULL,NULL,NULL),(130,'169.254.0.131',1,1,NULL,NULL,NULL),(131,'169.254.0.132',1,1,NULL,NULL,NULL),(132,'169.254.0.133',1,1,NULL,NULL,NULL),(133,'169.254.0.134',1,1,NULL,NULL,NULL),(134,'169.254.0.135',1,1,NULL,NULL,NULL),(135,'169.254.0.136',1,1,NULL,NULL,NULL),(136,'169.254.0.137',1,1,NULL,NULL,NULL),(137,'169.254.0.138',1,1,NULL,NULL,NULL),(138,'169.254.0.139',1,1,NULL,NULL,NULL),(139,'169.254.0.140',1,1,NULL,NULL,NULL),(140,'169.254.0.141',1,1,NULL,NULL,NULL),(141,'169.254.0.142',1,1,NULL,NULL,NULL),(142,'169.254.0.143',1,1,NULL,NULL,NULL),(143,'169.254.0.144',1,1,NULL,NULL,NULL),(144,'169.254.0.145',1,1,NULL,NULL,NULL),(145,'169.254.0.146',1,1,NULL,NULL,NULL),(146,'169.254.0.147',1,1,NULL,NULL,NULL),(147,'169.254.0.148',1,1,NULL,NULL,NULL),(148,'169.254.0.149',1,1,NULL,NULL,NULL),(149,'169.254.0.150',1,1,NULL,NULL,NULL),(150,'169.254.0.151',1,1,NULL,NULL,NULL),(151,'169.254.0.152',1,1,NULL,NULL,NULL),(152,'169.254.0.153',1,1,NULL,NULL,NULL),(153,'169.254.0.154',1,1,NULL,NULL,NULL),(154,'169.254.0.155',1,1,NULL,NULL,NULL),(155,'169.254.0.156',1,1,NULL,NULL,NULL),(156,'169.254.0.157',1,1,NULL,NULL,NULL),(157,'169.254.0.158',1,1,NULL,NULL,NULL),(158,'169.254.0.159',1,1,NULL,NULL,NULL),(159,'169.254.0.160',1,1,NULL,NULL,NULL),(160,'169.254.0.161',1,1,NULL,NULL,NULL),(161,'169.254.0.162',1,1,NULL,NULL,NULL),(162,'169.254.0.163',1,1,NULL,NULL,NULL),(163,'169.254.0.164',1,1,NULL,NULL,NULL),(164,'169.254.0.165',1,1,NULL,NULL,NULL),(165,'169.254.0.166',1,1,NULL,NULL,NULL),(166,'169.254.0.167',1,1,NULL,NULL,NULL),(167,'169.254.0.168',1,1,NULL,NULL,NULL),(168,'169.254.0.169',1,1,NULL,NULL,NULL),(169,'169.254.0.170',1,1,NULL,NULL,NULL),(170,'169.254.0.171',1,1,NULL,NULL,NULL),(171,'169.254.0.172',1,1,NULL,NULL,NULL),(172,'169.254.0.173',1,1,NULL,NULL,NULL),(173,'169.254.0.174',1,1,NULL,NULL,NULL),(174,'169.254.0.175',1,1,NULL,NULL,NULL),(175,'169.254.0.176',1,1,NULL,NULL,NULL),(176,'169.254.0.177',1,1,NULL,NULL,NULL),(177,'169.254.0.178',1,1,NULL,NULL,NULL),(178,'169.254.0.179',1,1,NULL,NULL,NULL),(179,'169.254.0.180',1,1,NULL,NULL,NULL),(180,'169.254.0.181',1,1,NULL,NULL,NULL),(181,'169.254.0.182',1,1,NULL,NULL,NULL),(182,'169.254.0.183',1,1,NULL,NULL,NULL),(183,'169.254.0.184',1,1,NULL,NULL,NULL),(184,'169.254.0.185',1,1,NULL,NULL,NULL),(185,'169.254.0.186',1,1,NULL,NULL,NULL),(186,'169.254.0.187',1,1,NULL,NULL,NULL),(187,'169.254.0.188',1,1,NULL,NULL,NULL),(188,'169.254.0.189',1,1,NULL,NULL,NULL),(189,'169.254.0.190',1,1,NULL,NULL,NULL),(190,'169.254.0.191',1,1,NULL,NULL,NULL),(191,'169.254.0.192',1,1,NULL,NULL,NULL),(192,'169.254.0.193',1,1,NULL,NULL,NULL),(193,'169.254.0.194',1,1,NULL,NULL,NULL),(194,'169.254.0.195',1,1,NULL,NULL,NULL),(195,'169.254.0.196',1,1,NULL,NULL,NULL),(196,'169.254.0.197',1,1,NULL,NULL,NULL),(197,'169.254.0.198',1,1,NULL,NULL,NULL),(198,'169.254.0.199',1,1,NULL,NULL,NULL),(199,'169.254.0.200',1,1,NULL,NULL,NULL),(200,'169.254.0.201',1,1,NULL,NULL,NULL),(201,'169.254.0.202',1,1,NULL,NULL,NULL),(202,'169.254.0.203',1,1,NULL,NULL,NULL),(203,'169.254.0.204',1,1,NULL,NULL,NULL),(204,'169.254.0.205',1,1,NULL,NULL,NULL),(205,'169.254.0.206',1,1,NULL,NULL,NULL),(206,'169.254.0.207',1,1,NULL,NULL,NULL),(207,'169.254.0.208',1,1,NULL,NULL,NULL),(208,'169.254.0.209',1,1,NULL,NULL,NULL),(209,'169.254.0.210',1,1,NULL,NULL,NULL),(210,'169.254.0.211',1,1,NULL,NULL,NULL),(211,'169.254.0.212',1,1,NULL,NULL,NULL),(212,'169.254.0.213',1,1,NULL,NULL,NULL),(213,'169.254.0.214',1,1,NULL,NULL,NULL),(214,'169.254.0.215',1,1,NULL,NULL,NULL),(215,'169.254.0.216',1,1,NULL,NULL,NULL),(216,'169.254.0.217',1,1,NULL,NULL,NULL),(217,'169.254.0.218',1,1,NULL,NULL,NULL),(218,'169.254.0.219',1,1,NULL,NULL,NULL),(219,'169.254.0.220',1,1,NULL,NULL,NULL),(220,'169.254.0.221',1,1,NULL,NULL,NULL),(221,'169.254.0.222',1,1,NULL,NULL,NULL),(222,'169.254.0.223',1,1,NULL,NULL,NULL),(223,'169.254.0.224',1,1,NULL,NULL,NULL),(224,'169.254.0.225',1,1,NULL,NULL,NULL),(225,'169.254.0.226',1,1,NULL,NULL,NULL),(226,'169.254.0.227',1,1,NULL,NULL,NULL),(227,'169.254.0.228',1,1,NULL,NULL,NULL),(228,'169.254.0.229',1,1,NULL,NULL,NULL),(229,'169.254.0.230',1,1,NULL,NULL,NULL),(230,'169.254.0.231',1,1,NULL,NULL,NULL),(231,'169.254.0.232',1,1,NULL,NULL,NULL),(232,'169.254.0.233',1,1,NULL,NULL,NULL),(233,'169.254.0.234',1,1,NULL,NULL,NULL),(234,'169.254.0.235',1,1,NULL,NULL,NULL),(235,'169.254.0.236',1,1,NULL,NULL,NULL),(236,'169.254.0.237',1,1,NULL,NULL,NULL),(237,'169.254.0.238',1,1,NULL,NULL,NULL),(238,'169.254.0.239',1,1,NULL,NULL,NULL),(239,'169.254.0.240',1,1,NULL,NULL,NULL),(240,'169.254.0.241',1,1,NULL,NULL,NULL),(241,'169.254.0.242',1,1,NULL,NULL,NULL),(242,'169.254.0.243',1,1,NULL,NULL,NULL),(243,'169.254.0.244',1,1,NULL,NULL,NULL),(244,'169.254.0.245',1,1,NULL,NULL,NULL),(245,'169.254.0.246',1,1,NULL,NULL,NULL),(246,'169.254.0.247',1,1,NULL,NULL,NULL),(247,'169.254.0.248',1,1,NULL,NULL,NULL),(248,'169.254.0.249',1,1,NULL,NULL,NULL),(249,'169.254.0.250',1,1,NULL,NULL,NULL),(250,'169.254.0.251',1,1,NULL,NULL,NULL),(251,'169.254.0.252',1,1,NULL,NULL,NULL),(252,'169.254.0.253',1,1,NULL,NULL,NULL),(253,'169.254.0.254',1,1,NULL,NULL,NULL),(254,'169.254.0.255',1,1,NULL,NULL,NULL),(255,'169.254.1.0',1,1,NULL,NULL,NULL),(256,'169.254.1.1',1,1,NULL,NULL,NULL),(257,'169.254.1.2',1,1,NULL,NULL,NULL),(258,'169.254.1.3',1,1,NULL,NULL,NULL),(259,'169.254.1.4',1,1,NULL,NULL,NULL),(260,'169.254.1.5',1,1,NULL,NULL,NULL),(261,'169.254.1.6',1,1,NULL,NULL,NULL),(262,'169.254.1.7',1,1,NULL,NULL,NULL),(263,'169.254.1.8',1,1,NULL,NULL,NULL),(264,'169.254.1.9',1,1,NULL,NULL,NULL),(265,'169.254.1.10',1,1,NULL,NULL,NULL),(266,'169.254.1.11',1,1,NULL,NULL,NULL),(267,'169.254.1.12',1,1,NULL,NULL,NULL),(268,'169.254.1.13',1,1,NULL,NULL,NULL),(269,'169.254.1.14',1,1,NULL,NULL,NULL),(270,'169.254.1.15',1,1,NULL,NULL,NULL),(271,'169.254.1.16',1,1,NULL,NULL,NULL),(272,'169.254.1.17',1,1,NULL,NULL,NULL),(273,'169.254.1.18',1,1,NULL,NULL,NULL),(274,'169.254.1.19',1,1,NULL,NULL,NULL),(275,'169.254.1.20',1,1,NULL,NULL,NULL),(276,'169.254.1.21',1,1,NULL,NULL,NULL),(277,'169.254.1.22',1,1,NULL,NULL,NULL),(278,'169.254.1.23',1,1,NULL,NULL,NULL),(279,'169.254.1.24',1,1,NULL,NULL,NULL),(280,'169.254.1.25',1,1,NULL,NULL,NULL),(281,'169.254.1.26',1,1,NULL,NULL,NULL),(282,'169.254.1.27',1,1,NULL,NULL,NULL),(283,'169.254.1.28',1,1,NULL,NULL,NULL),(284,'169.254.1.29',1,1,NULL,NULL,NULL),(285,'169.254.1.30',1,1,NULL,NULL,NULL),(286,'169.254.1.31',1,1,NULL,NULL,NULL),(287,'169.254.1.32',1,1,NULL,NULL,NULL),(288,'169.254.1.33',1,1,NULL,NULL,NULL),(289,'169.254.1.34',1,1,NULL,NULL,NULL),(290,'169.254.1.35',1,1,NULL,NULL,NULL),(291,'169.254.1.36',1,1,NULL,NULL,NULL),(292,'169.254.1.37',1,1,NULL,NULL,NULL),(293,'169.254.1.38',1,1,NULL,NULL,NULL),(294,'169.254.1.39',1,1,NULL,NULL,NULL),(295,'169.254.1.40',1,1,NULL,NULL,NULL),(296,'169.254.1.41',1,1,NULL,NULL,NULL),(297,'169.254.1.42',1,1,NULL,NULL,NULL),(298,'169.254.1.43',1,1,NULL,NULL,NULL),(299,'169.254.1.44',1,1,NULL,NULL,NULL),(300,'169.254.1.45',1,1,NULL,NULL,NULL),(301,'169.254.1.46',1,1,NULL,NULL,NULL),(302,'169.254.1.47',1,1,NULL,NULL,NULL),(303,'169.254.1.48',1,1,NULL,NULL,NULL),(304,'169.254.1.49',1,1,NULL,NULL,NULL),(305,'169.254.1.50',1,1,NULL,NULL,NULL),(306,'169.254.1.51',1,1,NULL,NULL,NULL),(307,'169.254.1.52',1,1,NULL,NULL,NULL),(308,'169.254.1.53',1,1,NULL,NULL,NULL),(309,'169.254.1.54',1,1,NULL,NULL,NULL),(310,'169.254.1.55',1,1,NULL,NULL,NULL),(311,'169.254.1.56',1,1,NULL,NULL,NULL),(312,'169.254.1.57',1,1,NULL,NULL,NULL),(313,'169.254.1.58',1,1,NULL,NULL,NULL),(314,'169.254.1.59',1,1,NULL,NULL,NULL),(315,'169.254.1.60',1,1,NULL,NULL,NULL),(316,'169.254.1.61',1,1,NULL,NULL,NULL),(317,'169.254.1.62',1,1,NULL,NULL,NULL),(318,'169.254.1.63',1,1,NULL,NULL,NULL),(319,'169.254.1.64',1,1,NULL,NULL,NULL),(320,'169.254.1.65',1,1,NULL,NULL,NULL),(321,'169.254.1.66',1,1,NULL,NULL,NULL),(322,'169.254.1.67',1,1,NULL,NULL,NULL),(323,'169.254.1.68',1,1,NULL,NULL,NULL),(324,'169.254.1.69',1,1,NULL,NULL,NULL),(325,'169.254.1.70',1,1,NULL,NULL,NULL),(326,'169.254.1.71',1,1,NULL,NULL,NULL),(327,'169.254.1.72',1,1,NULL,NULL,NULL),(328,'169.254.1.73',1,1,NULL,NULL,NULL),(329,'169.254.1.74',1,1,NULL,NULL,NULL),(330,'169.254.1.75',1,1,NULL,NULL,NULL),(331,'169.254.1.76',1,1,NULL,NULL,NULL),(332,'169.254.1.77',1,1,NULL,NULL,NULL),(333,'169.254.1.78',1,1,NULL,NULL,NULL),(334,'169.254.1.79',1,1,NULL,NULL,NULL),(335,'169.254.1.80',1,1,NULL,NULL,NULL),(336,'169.254.1.81',1,1,NULL,NULL,NULL),(337,'169.254.1.82',1,1,NULL,NULL,NULL),(338,'169.254.1.83',1,1,NULL,NULL,NULL),(339,'169.254.1.84',1,1,NULL,NULL,NULL),(340,'169.254.1.85',1,1,NULL,NULL,NULL),(341,'169.254.1.86',1,1,NULL,NULL,NULL),(342,'169.254.1.87',1,1,NULL,NULL,NULL),(343,'169.254.1.88',1,1,NULL,NULL,NULL),(344,'169.254.1.89',1,1,NULL,NULL,NULL),(345,'169.254.1.90',1,1,NULL,NULL,NULL),(346,'169.254.1.91',1,1,NULL,NULL,NULL),(347,'169.254.1.92',1,1,NULL,NULL,NULL),(348,'169.254.1.93',1,1,NULL,NULL,NULL),(349,'169.254.1.94',1,1,NULL,NULL,NULL),(350,'169.254.1.95',1,1,NULL,NULL,NULL),(351,'169.254.1.96',1,1,NULL,NULL,NULL),(352,'169.254.1.97',1,1,NULL,NULL,NULL),(353,'169.254.1.98',1,1,NULL,NULL,NULL),(354,'169.254.1.99',1,1,NULL,NULL,NULL),(355,'169.254.1.100',1,1,NULL,NULL,NULL),(356,'169.254.1.101',1,1,NULL,NULL,NULL),(357,'169.254.1.102',1,1,NULL,NULL,NULL),(358,'169.254.1.103',1,1,NULL,NULL,NULL),(359,'169.254.1.104',1,1,NULL,NULL,NULL),(360,'169.254.1.105',1,1,NULL,NULL,NULL),(361,'169.254.1.106',1,1,NULL,NULL,NULL),(362,'169.254.1.107',1,1,NULL,NULL,NULL),(363,'169.254.1.108',1,1,NULL,NULL,NULL),(364,'169.254.1.109',1,1,NULL,NULL,NULL),(365,'169.254.1.110',1,1,NULL,NULL,NULL),(366,'169.254.1.111',1,1,NULL,NULL,NULL),(367,'169.254.1.112',1,1,NULL,NULL,NULL),(368,'169.254.1.113',1,1,NULL,NULL,NULL),(369,'169.254.1.114',1,1,NULL,NULL,NULL),(370,'169.254.1.115',1,1,NULL,NULL,NULL),(371,'169.254.1.116',1,1,NULL,NULL,NULL),(372,'169.254.1.117',1,1,NULL,NULL,NULL),(373,'169.254.1.118',1,1,NULL,NULL,NULL),(374,'169.254.1.119',1,1,NULL,NULL,NULL),(375,'169.254.1.120',1,1,NULL,NULL,NULL),(376,'169.254.1.121',1,1,NULL,NULL,NULL),(377,'169.254.1.122',1,1,NULL,NULL,NULL),(378,'169.254.1.123',1,1,NULL,NULL,NULL),(379,'169.254.1.124',1,1,NULL,NULL,NULL),(380,'169.254.1.125',1,1,NULL,NULL,NULL),(381,'169.254.1.126',1,1,NULL,NULL,NULL),(382,'169.254.1.127',1,1,NULL,NULL,NULL),(383,'169.254.1.128',1,1,NULL,NULL,NULL),(384,'169.254.1.129',1,1,NULL,NULL,NULL),(385,'169.254.1.130',1,1,NULL,NULL,NULL),(386,'169.254.1.131',1,1,NULL,NULL,NULL),(387,'169.254.1.132',1,1,NULL,NULL,NULL),(388,'169.254.1.133',1,1,NULL,NULL,NULL),(389,'169.254.1.134',1,1,NULL,NULL,NULL),(390,'169.254.1.135',1,1,NULL,NULL,NULL),(391,'169.254.1.136',1,1,NULL,NULL,NULL),(392,'169.254.1.137',1,1,NULL,NULL,NULL),(393,'169.254.1.138',1,1,NULL,NULL,NULL),(394,'169.254.1.139',1,1,NULL,NULL,NULL),(395,'169.254.1.140',1,1,NULL,NULL,NULL),(396,'169.254.1.141',1,1,NULL,NULL,NULL),(397,'169.254.1.142',1,1,NULL,NULL,NULL),(398,'169.254.1.143',1,1,NULL,NULL,NULL),(399,'169.254.1.144',1,1,NULL,NULL,NULL),(400,'169.254.1.145',1,1,NULL,NULL,NULL),(401,'169.254.1.146',1,1,NULL,NULL,NULL),(402,'169.254.1.147',1,1,NULL,NULL,NULL),(403,'169.254.1.148',1,1,NULL,NULL,NULL),(404,'169.254.1.149',1,1,NULL,NULL,NULL),(405,'169.254.1.150',1,1,NULL,NULL,NULL),(406,'169.254.1.151',1,1,NULL,NULL,NULL),(407,'169.254.1.152',1,1,NULL,NULL,NULL),(408,'169.254.1.153',1,1,NULL,NULL,NULL),(409,'169.254.1.154',1,1,NULL,NULL,NULL),(410,'169.254.1.155',1,1,NULL,NULL,NULL),(411,'169.254.1.156',1,1,NULL,NULL,NULL),(412,'169.254.1.157',1,1,NULL,NULL,NULL),(413,'169.254.1.158',1,1,NULL,NULL,NULL),(414,'169.254.1.159',1,1,NULL,NULL,NULL),(415,'169.254.1.160',1,1,NULL,NULL,NULL),(416,'169.254.1.161',1,1,NULL,NULL,NULL),(417,'169.254.1.162',1,1,NULL,NULL,NULL),(418,'169.254.1.163',1,1,NULL,NULL,NULL),(419,'169.254.1.164',1,1,NULL,NULL,NULL),(420,'169.254.1.165',1,1,NULL,NULL,NULL),(421,'169.254.1.166',1,1,NULL,NULL,NULL),(422,'169.254.1.167',1,1,NULL,NULL,NULL),(423,'169.254.1.168',1,1,NULL,NULL,NULL),(424,'169.254.1.169',1,1,NULL,NULL,NULL),(425,'169.254.1.170',1,1,NULL,NULL,NULL),(426,'169.254.1.171',1,1,NULL,NULL,NULL),(427,'169.254.1.172',1,1,NULL,NULL,NULL),(428,'169.254.1.173',1,1,NULL,NULL,NULL),(429,'169.254.1.174',1,1,NULL,NULL,NULL),(430,'169.254.1.175',1,1,NULL,NULL,NULL),(431,'169.254.1.176',1,1,NULL,NULL,NULL),(432,'169.254.1.177',1,1,NULL,NULL,NULL),(433,'169.254.1.178',1,1,NULL,NULL,NULL),(434,'169.254.1.179',1,1,NULL,NULL,NULL),(435,'169.254.1.180',1,1,NULL,NULL,NULL),(436,'169.254.1.181',1,1,NULL,NULL,NULL),(437,'169.254.1.182',1,1,NULL,NULL,NULL),(438,'169.254.1.183',1,1,NULL,NULL,NULL),(439,'169.254.1.184',1,1,NULL,NULL,NULL),(440,'169.254.1.185',1,1,NULL,NULL,NULL),(441,'169.254.1.186',1,1,NULL,NULL,NULL),(442,'169.254.1.187',1,1,NULL,NULL,NULL),(443,'169.254.1.188',1,1,NULL,NULL,NULL),(444,'169.254.1.189',1,1,NULL,NULL,NULL),(445,'169.254.1.190',1,1,NULL,NULL,NULL),(446,'169.254.1.191',1,1,NULL,NULL,NULL),(447,'169.254.1.192',1,1,NULL,NULL,NULL),(448,'169.254.1.193',1,1,NULL,NULL,NULL),(449,'169.254.1.194',1,1,NULL,NULL,NULL),(450,'169.254.1.195',1,1,NULL,NULL,NULL),(451,'169.254.1.196',1,1,NULL,NULL,NULL),(452,'169.254.1.197',1,1,NULL,NULL,NULL),(453,'169.254.1.198',1,1,NULL,NULL,NULL),(454,'169.254.1.199',1,1,NULL,NULL,NULL),(455,'169.254.1.200',1,1,NULL,NULL,NULL),(456,'169.254.1.201',1,1,NULL,NULL,NULL),(457,'169.254.1.202',1,1,NULL,NULL,NULL),(458,'169.254.1.203',1,1,NULL,NULL,NULL),(459,'169.254.1.204',1,1,NULL,NULL,NULL),(460,'169.254.1.205',1,1,NULL,NULL,NULL),(461,'169.254.1.206',1,1,NULL,NULL,NULL),(462,'169.254.1.207',1,1,NULL,NULL,NULL),(463,'169.254.1.208',1,1,NULL,NULL,NULL),(464,'169.254.1.209',1,1,NULL,NULL,NULL),(465,'169.254.1.210',1,1,NULL,NULL,NULL),(466,'169.254.1.211',1,1,NULL,NULL,NULL),(467,'169.254.1.212',1,1,NULL,NULL,NULL),(468,'169.254.1.213',1,1,NULL,NULL,NULL),(469,'169.254.1.214',1,1,NULL,NULL,NULL),(470,'169.254.1.215',1,1,NULL,NULL,NULL),(471,'169.254.1.216',1,1,NULL,NULL,NULL),(472,'169.254.1.217',1,1,NULL,NULL,NULL),(473,'169.254.1.218',1,1,NULL,NULL,NULL),(474,'169.254.1.219',1,1,NULL,NULL,NULL),(475,'169.254.1.220',1,1,NULL,NULL,NULL),(476,'169.254.1.221',1,1,NULL,NULL,NULL),(477,'169.254.1.222',1,1,NULL,NULL,NULL),(478,'169.254.1.223',1,1,NULL,NULL,NULL),(479,'169.254.1.224',1,1,NULL,NULL,NULL),(480,'169.254.1.225',1,1,NULL,NULL,NULL),(481,'169.254.1.226',1,1,NULL,NULL,NULL),(482,'169.254.1.227',1,1,NULL,NULL,NULL),(483,'169.254.1.228',1,1,NULL,NULL,NULL),(484,'169.254.1.229',1,1,NULL,NULL,NULL),(485,'169.254.1.230',1,1,NULL,NULL,NULL),(486,'169.254.1.231',1,1,NULL,NULL,NULL),(487,'169.254.1.232',1,1,NULL,NULL,NULL),(488,'169.254.1.233',1,1,NULL,NULL,NULL),(489,'169.254.1.234',1,1,NULL,NULL,NULL),(490,'169.254.1.235',1,1,NULL,NULL,NULL),(491,'169.254.1.236',1,1,NULL,NULL,NULL),(492,'169.254.1.237',1,1,NULL,NULL,NULL),(493,'169.254.1.238',1,1,NULL,NULL,NULL),(494,'169.254.1.239',1,1,NULL,NULL,NULL),(495,'169.254.1.240',1,1,NULL,NULL,NULL),(496,'169.254.1.241',1,1,NULL,NULL,NULL),(497,'169.254.1.242',1,1,NULL,NULL,NULL),(498,'169.254.1.243',1,1,NULL,NULL,NULL),(499,'169.254.1.244',1,1,NULL,NULL,NULL),(500,'169.254.1.245',1,1,NULL,NULL,NULL),(501,'169.254.1.246',1,1,NULL,NULL,NULL),(502,'169.254.1.247',1,1,NULL,NULL,NULL),(503,'169.254.1.248',1,1,NULL,NULL,NULL),(504,'169.254.1.249',1,1,NULL,NULL,NULL),(505,'169.254.1.250',1,1,NULL,NULL,NULL),(506,'169.254.1.251',1,1,NULL,NULL,NULL),(507,'169.254.1.252',1,1,NULL,NULL,NULL),(508,'169.254.1.253',1,1,NULL,NULL,NULL),(509,'169.254.1.254',1,1,NULL,NULL,NULL),(510,'169.254.1.255',1,1,NULL,NULL,NULL),(511,'169.254.2.0',1,1,NULL,NULL,NULL),(512,'169.254.2.1',1,1,NULL,NULL,NULL),(513,'169.254.2.2',1,1,NULL,NULL,NULL),(514,'169.254.2.3',1,1,NULL,NULL,NULL),(515,'169.254.2.4',1,1,NULL,NULL,NULL),(516,'169.254.2.5',1,1,NULL,NULL,NULL),(517,'169.254.2.6',1,1,NULL,NULL,NULL),(518,'169.254.2.7',1,1,NULL,NULL,NULL),(519,'169.254.2.8',1,1,NULL,NULL,NULL),(520,'169.254.2.9',1,1,NULL,NULL,NULL),(521,'169.254.2.10',1,1,NULL,NULL,NULL),(522,'169.254.2.11',1,1,NULL,NULL,NULL),(523,'169.254.2.12',1,1,NULL,NULL,NULL),(524,'169.254.2.13',1,1,NULL,NULL,NULL),(525,'169.254.2.14',1,1,NULL,NULL,NULL),(526,'169.254.2.15',1,1,NULL,NULL,NULL),(527,'169.254.2.16',1,1,NULL,NULL,NULL),(528,'169.254.2.17',1,1,NULL,NULL,NULL),(529,'169.254.2.18',1,1,NULL,NULL,NULL),(530,'169.254.2.19',1,1,NULL,NULL,NULL),(531,'169.254.2.20',1,1,NULL,NULL,NULL),(532,'169.254.2.21',1,1,NULL,NULL,NULL),(533,'169.254.2.22',1,1,NULL,NULL,NULL),(534,'169.254.2.23',1,1,NULL,NULL,NULL),(535,'169.254.2.24',1,1,NULL,NULL,NULL),(536,'169.254.2.25',1,1,NULL,NULL,NULL),(537,'169.254.2.26',1,1,NULL,NULL,NULL),(538,'169.254.2.27',1,1,NULL,NULL,NULL),(539,'169.254.2.28',1,1,NULL,NULL,NULL),(540,'169.254.2.29',1,1,NULL,NULL,NULL),(541,'169.254.2.30',1,1,NULL,NULL,NULL),(542,'169.254.2.31',1,1,NULL,NULL,NULL),(543,'169.254.2.32',1,1,NULL,NULL,NULL),(544,'169.254.2.33',1,1,NULL,NULL,NULL),(545,'169.254.2.34',1,1,NULL,NULL,NULL),(546,'169.254.2.35',1,1,NULL,NULL,NULL),(547,'169.254.2.36',1,1,NULL,NULL,NULL),(548,'169.254.2.37',1,1,NULL,NULL,NULL),(549,'169.254.2.38',1,1,NULL,NULL,NULL),(550,'169.254.2.39',1,1,NULL,NULL,NULL),(551,'169.254.2.40',1,1,NULL,NULL,NULL),(552,'169.254.2.41',1,1,NULL,NULL,NULL),(553,'169.254.2.42',1,1,NULL,NULL,NULL),(554,'169.254.2.43',1,1,NULL,NULL,NULL),(555,'169.254.2.44',1,1,NULL,NULL,NULL),(556,'169.254.2.45',1,1,NULL,NULL,NULL),(557,'169.254.2.46',1,1,NULL,NULL,NULL),(558,'169.254.2.47',1,1,NULL,NULL,NULL),(559,'169.254.2.48',1,1,NULL,NULL,NULL),(560,'169.254.2.49',1,1,NULL,NULL,NULL),(561,'169.254.2.50',1,1,NULL,NULL,NULL),(562,'169.254.2.51',1,1,NULL,NULL,NULL),(563,'169.254.2.52',1,1,NULL,NULL,NULL),(564,'169.254.2.53',1,1,NULL,NULL,NULL),(565,'169.254.2.54',1,1,NULL,NULL,NULL),(566,'169.254.2.55',1,1,NULL,NULL,NULL),(567,'169.254.2.56',1,1,NULL,NULL,NULL),(568,'169.254.2.57',1,1,NULL,NULL,NULL),(569,'169.254.2.58',1,1,NULL,NULL,NULL),(570,'169.254.2.59',1,1,NULL,NULL,NULL),(571,'169.254.2.60',1,1,NULL,NULL,NULL),(572,'169.254.2.61',1,1,NULL,NULL,NULL),(573,'169.254.2.62',1,1,NULL,NULL,NULL),(574,'169.254.2.63',1,1,NULL,NULL,NULL),(575,'169.254.2.64',1,1,NULL,NULL,NULL),(576,'169.254.2.65',1,1,NULL,NULL,NULL),(577,'169.254.2.66',1,1,NULL,NULL,NULL),(578,'169.254.2.67',1,1,NULL,NULL,NULL),(579,'169.254.2.68',1,1,NULL,NULL,NULL),(580,'169.254.2.69',1,1,NULL,NULL,NULL),(581,'169.254.2.70',1,1,NULL,NULL,NULL),(582,'169.254.2.71',1,1,NULL,NULL,NULL),(583,'169.254.2.72',1,1,NULL,NULL,NULL),(584,'169.254.2.73',1,1,NULL,NULL,NULL),(585,'169.254.2.74',1,1,NULL,NULL,NULL),(586,'169.254.2.75',1,1,NULL,NULL,NULL),(587,'169.254.2.76',1,1,NULL,NULL,NULL),(588,'169.254.2.77',1,1,NULL,NULL,NULL),(589,'169.254.2.78',1,1,NULL,NULL,NULL),(590,'169.254.2.79',1,1,NULL,NULL,NULL),(591,'169.254.2.80',1,1,NULL,NULL,NULL),(592,'169.254.2.81',1,1,NULL,NULL,NULL),(593,'169.254.2.82',1,1,NULL,NULL,NULL),(594,'169.254.2.83',1,1,NULL,NULL,NULL),(595,'169.254.2.84',1,1,NULL,NULL,NULL),(596,'169.254.2.85',1,1,NULL,NULL,NULL),(597,'169.254.2.86',1,1,NULL,NULL,NULL),(598,'169.254.2.87',1,1,NULL,NULL,NULL),(599,'169.254.2.88',1,1,NULL,NULL,NULL),(600,'169.254.2.89',1,1,NULL,NULL,NULL),(601,'169.254.2.90',1,1,NULL,NULL,NULL),(602,'169.254.2.91',1,1,NULL,NULL,NULL),(603,'169.254.2.92',1,1,NULL,NULL,NULL),(604,'169.254.2.93',1,1,NULL,NULL,NULL),(605,'169.254.2.94',1,1,NULL,NULL,NULL),(606,'169.254.2.95',1,1,NULL,NULL,NULL),(607,'169.254.2.96',1,1,NULL,NULL,NULL),(608,'169.254.2.97',1,1,NULL,NULL,NULL),(609,'169.254.2.98',1,1,NULL,NULL,NULL),(610,'169.254.2.99',1,1,NULL,NULL,NULL),(611,'169.254.2.100',1,1,NULL,NULL,NULL),(612,'169.254.2.101',1,1,NULL,NULL,NULL),(613,'169.254.2.102',1,1,NULL,NULL,NULL),(614,'169.254.2.103',1,1,NULL,NULL,NULL),(615,'169.254.2.104',1,1,NULL,NULL,NULL),(616,'169.254.2.105',1,1,NULL,NULL,NULL),(617,'169.254.2.106',1,1,NULL,NULL,NULL),(618,'169.254.2.107',1,1,NULL,NULL,NULL),(619,'169.254.2.108',1,1,NULL,NULL,NULL),(620,'169.254.2.109',1,1,NULL,NULL,NULL),(621,'169.254.2.110',1,1,NULL,NULL,NULL),(622,'169.254.2.111',1,1,NULL,NULL,NULL),(623,'169.254.2.112',1,1,NULL,NULL,NULL),(624,'169.254.2.113',1,1,NULL,NULL,NULL),(625,'169.254.2.114',1,1,NULL,NULL,NULL),(626,'169.254.2.115',1,1,NULL,NULL,NULL),(627,'169.254.2.116',1,1,NULL,NULL,NULL),(628,'169.254.2.117',1,1,NULL,NULL,NULL),(629,'169.254.2.118',1,1,NULL,NULL,NULL),(630,'169.254.2.119',1,1,NULL,NULL,NULL),(631,'169.254.2.120',1,1,NULL,NULL,NULL),(632,'169.254.2.121',1,1,NULL,NULL,NULL),(633,'169.254.2.122',1,1,NULL,NULL,NULL),(634,'169.254.2.123',1,1,NULL,NULL,NULL),(635,'169.254.2.124',1,1,NULL,NULL,NULL),(636,'169.254.2.125',1,1,NULL,NULL,NULL),(637,'169.254.2.126',1,1,NULL,NULL,NULL),(638,'169.254.2.127',1,1,NULL,NULL,NULL),(639,'169.254.2.128',1,1,NULL,NULL,NULL),(640,'169.254.2.129',1,1,NULL,NULL,NULL),(641,'169.254.2.130',1,1,NULL,NULL,NULL),(642,'169.254.2.131',1,1,NULL,NULL,NULL),(643,'169.254.2.132',1,1,NULL,NULL,NULL),(644,'169.254.2.133',1,1,NULL,NULL,NULL),(645,'169.254.2.134',1,1,NULL,NULL,NULL),(646,'169.254.2.135',1,1,NULL,NULL,NULL),(647,'169.254.2.136',1,1,NULL,NULL,NULL),(648,'169.254.2.137',1,1,NULL,NULL,NULL),(649,'169.254.2.138',1,1,NULL,NULL,NULL),(650,'169.254.2.139',1,1,NULL,NULL,NULL),(651,'169.254.2.140',1,1,NULL,NULL,NULL),(652,'169.254.2.141',1,1,NULL,NULL,NULL),(653,'169.254.2.142',1,1,NULL,NULL,NULL),(654,'169.254.2.143',1,1,NULL,NULL,NULL),(655,'169.254.2.144',1,1,NULL,NULL,NULL),(656,'169.254.2.145',1,1,NULL,NULL,NULL),(657,'169.254.2.146',1,1,NULL,NULL,NULL),(658,'169.254.2.147',1,1,NULL,NULL,NULL),(659,'169.254.2.148',1,1,NULL,NULL,NULL),(660,'169.254.2.149',1,1,NULL,NULL,NULL),(661,'169.254.2.150',1,1,NULL,NULL,NULL),(662,'169.254.2.151',1,1,NULL,NULL,NULL),(663,'169.254.2.152',1,1,NULL,NULL,NULL),(664,'169.254.2.153',1,1,NULL,NULL,NULL),(665,'169.254.2.154',1,1,NULL,NULL,NULL),(666,'169.254.2.155',1,1,NULL,NULL,NULL),(667,'169.254.2.156',1,1,NULL,NULL,NULL),(668,'169.254.2.157',1,1,NULL,NULL,NULL),(669,'169.254.2.158',1,1,NULL,NULL,NULL),(670,'169.254.2.159',1,1,NULL,NULL,NULL),(671,'169.254.2.160',1,1,NULL,NULL,NULL),(672,'169.254.2.161',1,1,NULL,NULL,NULL),(673,'169.254.2.162',1,1,NULL,NULL,NULL),(674,'169.254.2.163',1,1,NULL,NULL,NULL),(675,'169.254.2.164',1,1,NULL,NULL,NULL),(676,'169.254.2.165',1,1,NULL,NULL,NULL),(677,'169.254.2.166',1,1,NULL,NULL,NULL),(678,'169.254.2.167',1,1,NULL,NULL,NULL),(679,'169.254.2.168',1,1,NULL,NULL,NULL),(680,'169.254.2.169',1,1,NULL,NULL,NULL),(681,'169.254.2.170',1,1,NULL,NULL,NULL),(682,'169.254.2.171',1,1,NULL,NULL,NULL),(683,'169.254.2.172',1,1,NULL,NULL,NULL),(684,'169.254.2.173',1,1,NULL,NULL,NULL),(685,'169.254.2.174',1,1,NULL,NULL,NULL),(686,'169.254.2.175',1,1,NULL,NULL,NULL),(687,'169.254.2.176',1,1,NULL,NULL,NULL),(688,'169.254.2.177',1,1,NULL,NULL,NULL),(689,'169.254.2.178',1,1,NULL,NULL,NULL),(690,'169.254.2.179',1,1,NULL,NULL,NULL),(691,'169.254.2.180',1,1,NULL,NULL,NULL),(692,'169.254.2.181',1,1,NULL,NULL,NULL),(693,'169.254.2.182',1,1,NULL,NULL,NULL),(694,'169.254.2.183',1,1,NULL,NULL,NULL),(695,'169.254.2.184',1,1,NULL,NULL,NULL),(696,'169.254.2.185',1,1,NULL,NULL,NULL),(697,'169.254.2.186',1,1,NULL,NULL,NULL),(698,'169.254.2.187',1,1,NULL,NULL,NULL),(699,'169.254.2.188',1,1,NULL,NULL,NULL),(700,'169.254.2.189',1,1,NULL,NULL,NULL),(701,'169.254.2.190',1,1,NULL,NULL,NULL),(702,'169.254.2.191',1,1,NULL,NULL,NULL),(703,'169.254.2.192',1,1,NULL,NULL,NULL),(704,'169.254.2.193',1,1,NULL,NULL,NULL),(705,'169.254.2.194',1,1,NULL,NULL,NULL),(706,'169.254.2.195',1,1,NULL,NULL,NULL),(707,'169.254.2.196',1,1,NULL,NULL,NULL),(708,'169.254.2.197',1,1,NULL,NULL,NULL),(709,'169.254.2.198',1,1,NULL,NULL,NULL),(710,'169.254.2.199',1,1,NULL,NULL,NULL),(711,'169.254.2.200',1,1,NULL,NULL,NULL),(712,'169.254.2.201',1,1,NULL,NULL,NULL),(713,'169.254.2.202',1,1,NULL,NULL,NULL),(714,'169.254.2.203',1,1,NULL,NULL,NULL),(715,'169.254.2.204',1,1,NULL,NULL,NULL),(716,'169.254.2.205',1,1,NULL,NULL,NULL),(717,'169.254.2.206',1,1,NULL,NULL,NULL),(718,'169.254.2.207',1,1,NULL,NULL,NULL),(719,'169.254.2.208',1,1,NULL,NULL,NULL),(720,'169.254.2.209',1,1,NULL,NULL,NULL),(721,'169.254.2.210',1,1,NULL,NULL,NULL),(722,'169.254.2.211',1,1,NULL,NULL,NULL),(723,'169.254.2.212',1,1,NULL,NULL,NULL),(724,'169.254.2.213',1,1,NULL,NULL,NULL),(725,'169.254.2.214',1,1,NULL,NULL,NULL),(726,'169.254.2.215',1,1,NULL,NULL,NULL),(727,'169.254.2.216',1,1,NULL,NULL,NULL),(728,'169.254.2.217',1,1,NULL,NULL,NULL),(729,'169.254.2.218',1,1,NULL,NULL,NULL),(730,'169.254.2.219',1,1,NULL,NULL,NULL),(731,'169.254.2.220',1,1,NULL,NULL,NULL),(732,'169.254.2.221',1,1,NULL,NULL,NULL),(733,'169.254.2.222',1,1,NULL,NULL,NULL),(734,'169.254.2.223',1,1,NULL,NULL,NULL),(735,'169.254.2.224',1,1,NULL,NULL,NULL),(736,'169.254.2.225',1,1,NULL,NULL,NULL),(737,'169.254.2.226',1,1,NULL,NULL,NULL),(738,'169.254.2.227',1,1,NULL,NULL,NULL),(739,'169.254.2.228',1,1,NULL,NULL,NULL),(740,'169.254.2.229',1,1,NULL,NULL,NULL),(741,'169.254.2.230',1,1,NULL,NULL,NULL),(742,'169.254.2.231',1,1,NULL,NULL,NULL),(743,'169.254.2.232',1,1,NULL,NULL,NULL),(744,'169.254.2.233',1,1,NULL,NULL,NULL),(745,'169.254.2.234',1,1,NULL,NULL,NULL),(746,'169.254.2.235',1,1,NULL,NULL,NULL),(747,'169.254.2.236',1,1,NULL,NULL,NULL),(748,'169.254.2.237',1,1,NULL,NULL,NULL),(749,'169.254.2.238',1,1,NULL,NULL,NULL),(750,'169.254.2.239',1,1,NULL,NULL,NULL),(751,'169.254.2.240',1,1,NULL,NULL,NULL),(752,'169.254.2.241',1,1,NULL,NULL,NULL),(753,'169.254.2.242',1,1,NULL,NULL,NULL),(754,'169.254.2.243',1,1,NULL,NULL,NULL),(755,'169.254.2.244',1,1,NULL,NULL,NULL),(756,'169.254.2.245',1,1,NULL,NULL,NULL),(757,'169.254.2.246',1,1,NULL,NULL,NULL),(758,'169.254.2.247',1,1,NULL,NULL,NULL),(759,'169.254.2.248',1,1,NULL,NULL,NULL),(760,'169.254.2.249',1,1,NULL,NULL,NULL),(761,'169.254.2.250',1,1,NULL,NULL,NULL),(762,'169.254.2.251',1,1,NULL,NULL,NULL),(763,'169.254.2.252',1,1,NULL,NULL,NULL),(764,'169.254.2.253',1,1,NULL,NULL,NULL),(765,'169.254.2.254',1,1,NULL,NULL,NULL),(766,'169.254.2.255',1,1,NULL,NULL,NULL),(767,'169.254.3.0',1,1,NULL,NULL,NULL),(768,'169.254.3.1',1,1,NULL,NULL,NULL),(769,'169.254.3.2',1,1,NULL,NULL,NULL),(770,'169.254.3.3',1,1,NULL,NULL,NULL),(771,'169.254.3.4',1,1,NULL,NULL,NULL),(772,'169.254.3.5',1,1,NULL,NULL,NULL),(773,'169.254.3.6',1,1,NULL,NULL,NULL),(774,'169.254.3.7',1,1,NULL,NULL,NULL),(775,'169.254.3.8',1,1,NULL,NULL,NULL),(776,'169.254.3.9',1,1,NULL,NULL,NULL),(777,'169.254.3.10',1,1,NULL,NULL,NULL),(778,'169.254.3.11',1,1,NULL,NULL,NULL),(779,'169.254.3.12',1,1,NULL,NULL,NULL),(780,'169.254.3.13',1,1,NULL,NULL,NULL),(781,'169.254.3.14',1,1,NULL,NULL,NULL),(782,'169.254.3.15',1,1,NULL,NULL,NULL),(783,'169.254.3.16',1,1,NULL,NULL,NULL),(784,'169.254.3.17',1,1,NULL,NULL,NULL),(785,'169.254.3.18',1,1,NULL,NULL,NULL),(786,'169.254.3.19',1,1,NULL,NULL,NULL),(787,'169.254.3.20',1,1,NULL,NULL,NULL),(788,'169.254.3.21',1,1,NULL,NULL,NULL),(789,'169.254.3.22',1,1,NULL,NULL,NULL),(790,'169.254.3.23',1,1,NULL,NULL,NULL),(791,'169.254.3.24',1,1,NULL,NULL,NULL),(792,'169.254.3.25',1,1,NULL,NULL,NULL),(793,'169.254.3.26',1,1,NULL,NULL,NULL),(794,'169.254.3.27',1,1,NULL,NULL,NULL),(795,'169.254.3.28',1,1,NULL,NULL,NULL),(796,'169.254.3.29',1,1,NULL,NULL,NULL),(797,'169.254.3.30',1,1,NULL,NULL,NULL),(798,'169.254.3.31',1,1,NULL,NULL,NULL),(799,'169.254.3.32',1,1,NULL,NULL,NULL),(800,'169.254.3.33',1,1,NULL,NULL,NULL),(801,'169.254.3.34',1,1,NULL,NULL,NULL),(802,'169.254.3.35',1,1,NULL,NULL,NULL),(803,'169.254.3.36',1,1,NULL,NULL,NULL),(804,'169.254.3.37',1,1,NULL,NULL,NULL),(805,'169.254.3.38',1,1,NULL,NULL,NULL),(806,'169.254.3.39',1,1,NULL,NULL,NULL),(807,'169.254.3.40',1,1,NULL,NULL,NULL),(808,'169.254.3.41',1,1,NULL,NULL,NULL),(809,'169.254.3.42',1,1,NULL,NULL,NULL),(810,'169.254.3.43',1,1,NULL,NULL,NULL),(811,'169.254.3.44',1,1,NULL,NULL,NULL),(812,'169.254.3.45',1,1,NULL,NULL,NULL),(813,'169.254.3.46',1,1,NULL,NULL,NULL),(814,'169.254.3.47',1,1,NULL,NULL,NULL),(815,'169.254.3.48',1,1,NULL,NULL,NULL),(816,'169.254.3.49',1,1,NULL,NULL,NULL),(817,'169.254.3.50',1,1,NULL,NULL,NULL),(818,'169.254.3.51',1,1,NULL,NULL,NULL),(819,'169.254.3.52',1,1,NULL,NULL,NULL),(820,'169.254.3.53',1,1,NULL,NULL,NULL),(821,'169.254.3.54',1,1,NULL,NULL,NULL),(822,'169.254.3.55',1,1,NULL,NULL,NULL),(823,'169.254.3.56',1,1,NULL,NULL,NULL),(824,'169.254.3.57',1,1,NULL,NULL,NULL),(825,'169.254.3.58',1,1,NULL,NULL,NULL),(826,'169.254.3.59',1,1,NULL,NULL,NULL),(827,'169.254.3.60',1,1,NULL,NULL,NULL),(828,'169.254.3.61',1,1,NULL,NULL,NULL),(829,'169.254.3.62',1,1,NULL,NULL,NULL),(830,'169.254.3.63',1,1,NULL,NULL,NULL),(831,'169.254.3.64',1,1,NULL,NULL,NULL),(832,'169.254.3.65',1,1,NULL,NULL,NULL),(833,'169.254.3.66',1,1,NULL,NULL,NULL),(834,'169.254.3.67',1,1,NULL,NULL,NULL),(835,'169.254.3.68',1,1,NULL,NULL,NULL),(836,'169.254.3.69',1,1,NULL,NULL,NULL),(837,'169.254.3.70',1,1,NULL,NULL,NULL),(838,'169.254.3.71',1,1,NULL,NULL,NULL),(839,'169.254.3.72',1,1,NULL,NULL,NULL),(840,'169.254.3.73',1,1,NULL,NULL,NULL),(841,'169.254.3.74',1,1,NULL,NULL,NULL),(842,'169.254.3.75',1,1,NULL,NULL,NULL),(843,'169.254.3.76',1,1,NULL,NULL,NULL),(844,'169.254.3.77',1,1,NULL,NULL,NULL),(845,'169.254.3.78',1,1,NULL,NULL,NULL),(846,'169.254.3.79',1,1,NULL,NULL,NULL),(847,'169.254.3.80',1,1,NULL,NULL,NULL),(848,'169.254.3.81',1,1,NULL,NULL,NULL),(849,'169.254.3.82',1,1,NULL,NULL,NULL),(850,'169.254.3.83',1,1,NULL,NULL,NULL),(851,'169.254.3.84',1,1,NULL,NULL,NULL),(852,'169.254.3.85',1,1,NULL,NULL,NULL),(853,'169.254.3.86',1,1,NULL,NULL,NULL),(854,'169.254.3.87',1,1,NULL,NULL,NULL),(855,'169.254.3.88',1,1,NULL,NULL,NULL),(856,'169.254.3.89',1,1,NULL,NULL,NULL),(857,'169.254.3.90',1,1,NULL,NULL,NULL),(858,'169.254.3.91',1,1,NULL,NULL,NULL),(859,'169.254.3.92',1,1,NULL,NULL,NULL),(860,'169.254.3.93',1,1,NULL,NULL,NULL),(861,'169.254.3.94',1,1,NULL,NULL,NULL),(862,'169.254.3.95',1,1,NULL,NULL,NULL),(863,'169.254.3.96',1,1,NULL,NULL,NULL),(864,'169.254.3.97',1,1,NULL,NULL,NULL),(865,'169.254.3.98',1,1,NULL,NULL,NULL),(866,'169.254.3.99',1,1,NULL,NULL,NULL),(867,'169.254.3.100',1,1,NULL,NULL,NULL),(868,'169.254.3.101',1,1,NULL,NULL,NULL),(869,'169.254.3.102',1,1,NULL,NULL,NULL),(870,'169.254.3.103',1,1,NULL,NULL,NULL),(871,'169.254.3.104',1,1,NULL,NULL,NULL),(872,'169.254.3.105',1,1,NULL,NULL,NULL),(873,'169.254.3.106',1,1,NULL,NULL,NULL),(874,'169.254.3.107',1,1,NULL,NULL,NULL),(875,'169.254.3.108',1,1,NULL,NULL,NULL),(876,'169.254.3.109',1,1,NULL,NULL,NULL),(877,'169.254.3.110',1,1,NULL,NULL,NULL),(878,'169.254.3.111',1,1,NULL,NULL,NULL),(879,'169.254.3.112',1,1,NULL,NULL,NULL),(880,'169.254.3.113',1,1,NULL,NULL,NULL),(881,'169.254.3.114',1,1,NULL,NULL,NULL),(882,'169.254.3.115',1,1,NULL,NULL,NULL),(883,'169.254.3.116',1,1,NULL,NULL,NULL),(884,'169.254.3.117',1,1,NULL,NULL,NULL),(885,'169.254.3.118',1,1,NULL,NULL,NULL),(886,'169.254.3.119',1,1,NULL,NULL,NULL),(887,'169.254.3.120',1,1,NULL,NULL,NULL),(888,'169.254.3.121',1,1,NULL,NULL,NULL),(889,'169.254.3.122',1,1,NULL,NULL,NULL),(890,'169.254.3.123',1,1,NULL,NULL,NULL),(891,'169.254.3.124',1,1,NULL,NULL,NULL),(892,'169.254.3.125',1,1,NULL,NULL,NULL),(893,'169.254.3.126',1,1,NULL,NULL,NULL),(894,'169.254.3.127',1,1,NULL,NULL,NULL),(895,'169.254.3.128',1,1,NULL,NULL,NULL),(896,'169.254.3.129',1,1,NULL,NULL,NULL),(897,'169.254.3.130',1,1,NULL,NULL,NULL),(898,'169.254.3.131',1,1,NULL,NULL,NULL),(899,'169.254.3.132',1,1,NULL,NULL,NULL),(900,'169.254.3.133',1,1,NULL,NULL,NULL),(901,'169.254.3.134',1,1,NULL,NULL,NULL),(902,'169.254.3.135',1,1,NULL,NULL,NULL),(903,'169.254.3.136',1,1,NULL,NULL,NULL),(904,'169.254.3.137',1,1,NULL,NULL,NULL),(905,'169.254.3.138',1,1,NULL,NULL,NULL),(906,'169.254.3.139',1,1,NULL,NULL,NULL),(907,'169.254.3.140',1,1,NULL,NULL,NULL),(908,'169.254.3.141',1,1,NULL,NULL,NULL),(909,'169.254.3.142',1,1,NULL,NULL,NULL),(910,'169.254.3.143',1,1,NULL,NULL,NULL),(911,'169.254.3.144',1,1,NULL,NULL,NULL),(912,'169.254.3.145',1,1,NULL,NULL,NULL),(913,'169.254.3.146',1,1,NULL,NULL,NULL),(914,'169.254.3.147',1,1,NULL,NULL,NULL),(915,'169.254.3.148',1,1,NULL,NULL,NULL),(916,'169.254.3.149',1,1,NULL,NULL,NULL),(917,'169.254.3.150',1,1,NULL,NULL,NULL),(918,'169.254.3.151',1,1,NULL,NULL,NULL),(919,'169.254.3.152',1,1,NULL,NULL,NULL),(920,'169.254.3.153',1,1,NULL,NULL,NULL),(921,'169.254.3.154',1,1,NULL,NULL,NULL),(922,'169.254.3.155',1,1,NULL,NULL,NULL),(923,'169.254.3.156',1,1,NULL,NULL,NULL),(924,'169.254.3.157',1,1,NULL,NULL,NULL),(925,'169.254.3.158',1,1,NULL,NULL,NULL),(926,'169.254.3.159',1,1,NULL,NULL,NULL),(927,'169.254.3.160',1,1,NULL,NULL,NULL),(928,'169.254.3.161',1,1,NULL,NULL,NULL),(929,'169.254.3.162',1,1,NULL,NULL,NULL),(930,'169.254.3.163',1,1,NULL,NULL,NULL),(931,'169.254.3.164',1,1,NULL,NULL,NULL),(932,'169.254.3.165',1,1,NULL,NULL,NULL),(933,'169.254.3.166',1,1,NULL,NULL,NULL),(934,'169.254.3.167',1,1,NULL,NULL,NULL),(935,'169.254.3.168',1,1,NULL,NULL,NULL),(936,'169.254.3.169',1,1,NULL,NULL,NULL),(937,'169.254.3.170',1,1,NULL,NULL,NULL),(938,'169.254.3.171',1,1,NULL,NULL,NULL),(939,'169.254.3.172',1,1,NULL,NULL,NULL),(940,'169.254.3.173',1,1,NULL,NULL,NULL),(941,'169.254.3.174',1,1,NULL,NULL,NULL),(942,'169.254.3.175',1,1,NULL,NULL,NULL),(943,'169.254.3.176',1,1,NULL,NULL,NULL),(944,'169.254.3.177',1,1,NULL,NULL,NULL),(945,'169.254.3.178',1,1,NULL,NULL,NULL),(946,'169.254.3.179',1,1,NULL,NULL,NULL),(947,'169.254.3.180',1,1,NULL,NULL,NULL),(948,'169.254.3.181',1,1,NULL,NULL,NULL),(949,'169.254.3.182',1,1,NULL,NULL,NULL),(950,'169.254.3.183',1,1,NULL,NULL,NULL),(951,'169.254.3.184',1,1,NULL,NULL,NULL),(952,'169.254.3.185',1,1,NULL,NULL,NULL),(953,'169.254.3.186',1,1,NULL,NULL,NULL),(954,'169.254.3.187',1,1,NULL,NULL,NULL),(955,'169.254.3.188',1,1,NULL,NULL,NULL),(956,'169.254.3.189',1,1,NULL,NULL,NULL),(957,'169.254.3.190',1,1,NULL,NULL,NULL),(958,'169.254.3.191',1,1,NULL,NULL,NULL),(959,'169.254.3.192',1,1,NULL,NULL,NULL),(960,'169.254.3.193',1,1,NULL,NULL,NULL),(961,'169.254.3.194',1,1,NULL,NULL,NULL),(962,'169.254.3.195',1,1,NULL,NULL,NULL),(963,'169.254.3.196',1,1,NULL,NULL,NULL),(964,'169.254.3.197',1,1,NULL,NULL,NULL),(965,'169.254.3.198',1,1,NULL,NULL,NULL),(966,'169.254.3.199',1,1,NULL,NULL,NULL),(967,'169.254.3.200',1,1,NULL,NULL,NULL),(968,'169.254.3.201',1,1,NULL,NULL,NULL),(969,'169.254.3.202',1,1,NULL,NULL,NULL),(970,'169.254.3.203',1,1,NULL,NULL,NULL),(971,'169.254.3.204',1,1,NULL,NULL,NULL),(972,'169.254.3.205',1,1,NULL,NULL,NULL),(973,'169.254.3.206',1,1,NULL,NULL,NULL),(974,'169.254.3.207',1,1,NULL,NULL,NULL),(975,'169.254.3.208',1,1,NULL,NULL,NULL),(976,'169.254.3.209',1,1,NULL,NULL,NULL),(977,'169.254.3.210',1,1,NULL,NULL,NULL),(978,'169.254.3.211',1,1,NULL,NULL,NULL),(979,'169.254.3.212',1,1,NULL,NULL,NULL),(980,'169.254.3.213',1,1,NULL,NULL,NULL),(981,'169.254.3.214',1,1,NULL,NULL,NULL),(982,'169.254.3.215',1,1,NULL,NULL,NULL),(983,'169.254.3.216',1,1,NULL,NULL,NULL),(984,'169.254.3.217',1,1,NULL,NULL,NULL),(985,'169.254.3.218',1,1,NULL,NULL,NULL),(986,'169.254.3.219',1,1,NULL,NULL,NULL),(987,'169.254.3.220',1,1,NULL,NULL,NULL),(988,'169.254.3.221',1,1,NULL,NULL,NULL),(989,'169.254.3.222',1,1,NULL,NULL,NULL),(990,'169.254.3.223',1,1,NULL,NULL,NULL),(991,'169.254.3.224',1,1,NULL,NULL,NULL),(992,'169.254.3.225',1,1,NULL,NULL,NULL),(993,'169.254.3.226',1,1,NULL,NULL,NULL),(994,'169.254.3.227',1,1,NULL,NULL,NULL),(995,'169.254.3.228',1,1,NULL,NULL,NULL),(996,'169.254.3.229',1,1,NULL,NULL,NULL),(997,'169.254.3.230',1,1,NULL,NULL,NULL),(998,'169.254.3.231',1,1,NULL,NULL,NULL),(999,'169.254.3.232',1,1,NULL,NULL,NULL),(1000,'169.254.3.233',1,1,NULL,NULL,NULL),(1001,'169.254.3.234',1,1,NULL,NULL,NULL),(1002,'169.254.3.235',1,1,NULL,NULL,NULL),(1003,'169.254.3.236',1,1,NULL,NULL,NULL),(1004,'169.254.3.237',1,1,NULL,NULL,NULL),(1005,'169.254.3.238',1,1,NULL,NULL,NULL),(1006,'169.254.3.239',1,1,NULL,NULL,NULL),(1007,'169.254.3.240',1,1,NULL,NULL,NULL),(1008,'169.254.3.241',1,1,NULL,NULL,NULL),(1009,'169.254.3.242',1,1,NULL,NULL,NULL),(1010,'169.254.3.243',1,1,NULL,NULL,NULL),(1011,'169.254.3.244',1,1,NULL,NULL,NULL),(1012,'169.254.3.245',1,1,NULL,NULL,NULL),(1013,'169.254.3.246',1,1,NULL,NULL,NULL),(1014,'169.254.3.247',1,1,NULL,NULL,NULL),(1015,'169.254.3.248',1,1,NULL,NULL,NULL),(1016,'169.254.3.249',1,1,NULL,NULL,NULL),(1017,'169.254.3.250',1,1,NULL,NULL,NULL),(1018,'169.254.3.251',1,1,NULL,NULL,NULL),(1019,'169.254.3.252',1,1,NULL,NULL,NULL),(1020,'169.254.3.253',1,1,NULL,NULL,NULL),(1021,'169.254.3.254',1,1,NULL,NULL,NULL);
/*!40000 ALTER TABLE `op_dc_link_local_ip_address_alloc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_dc_storage_network_ip_address`
--

DROP TABLE IF EXISTS `op_dc_storage_network_ip_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_dc_storage_network_ip_address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `range_id` bigint(20) unsigned NOT NULL COMMENT 'id of ip range in dc_storage_network_ip_range',
  `ip_address` char(40) NOT NULL COMMENT 'ip address',
  `mac_address` bigint(20) unsigned NOT NULL COMMENT 'mac address for storage ips',
  `taken` datetime DEFAULT NULL COMMENT 'Date taken',
  PRIMARY KEY (`id`),
  KEY `fk_storage_ip_address__range_id` (`range_id`),
  CONSTRAINT `fk_storage_ip_address__range_id` FOREIGN KEY (`range_id`) REFERENCES `dc_storage_network_ip_range` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_dc_storage_network_ip_address`
--

LOCK TABLES `op_dc_storage_network_ip_address` WRITE;
/*!40000 ALTER TABLE `op_dc_storage_network_ip_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_dc_storage_network_ip_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_dc_vnet_alloc`
--

DROP TABLE IF EXISTS `op_dc_vnet_alloc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_dc_vnet_alloc` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary id',
  `vnet` varchar(18) NOT NULL COMMENT 'vnet',
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'physical network the vnet belongs to',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center the vnet belongs to',
  `reservation_id` char(40) DEFAULT NULL COMMENT 'reservation id',
  `account_id` bigint(20) unsigned DEFAULT NULL COMMENT 'account the vnet belongs to right now',
  `taken` datetime DEFAULT NULL COMMENT 'Date taken',
  `account_vnet_map_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_op_dc_vnet_alloc__vnet__data_center_id` (`vnet`,`physical_network_id`,`data_center_id`),
  KEY `i_op_dc_vnet_alloc__dc_taken` (`data_center_id`,`taken`),
  KEY `fk_op_dc_vnet_alloc__physical_network_id` (`physical_network_id`),
  KEY `fk_op_dc_vnet_alloc__account_vnet_map_id` (`account_vnet_map_id`),
  CONSTRAINT `fk_op_dc_vnet_alloc__account_vnet_map_id` FOREIGN KEY (`account_vnet_map_id`) REFERENCES `account_vnet_map` (`id`),
  CONSTRAINT `fk_op_dc_vnet_alloc__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_op_dc_vnet_alloc__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_dc_vnet_alloc`
--

LOCK TABLES `op_dc_vnet_alloc` WRITE;
/*!40000 ALTER TABLE `op_dc_vnet_alloc` DISABLE KEYS */;
INSERT INTO `op_dc_vnet_alloc` VALUES (1,'3928',200,1,NULL,NULL,NULL,NULL),(2,'3929',200,1,NULL,NULL,NULL,NULL),(3,'3926',200,1,NULL,NULL,NULL,NULL),(4,'3927',200,1,NULL,NULL,NULL,NULL),(5,'3924',200,1,NULL,NULL,NULL,NULL),(6,'3925',200,1,NULL,NULL,NULL,NULL),(7,'3922',200,1,NULL,NULL,NULL,NULL),(8,'3923',200,1,NULL,NULL,NULL,NULL),(9,'3920',200,1,NULL,NULL,NULL,NULL),(10,'3921',200,1,NULL,NULL,NULL,NULL),(11,'3917',200,1,NULL,NULL,NULL,NULL),(12,'3918',200,1,NULL,NULL,NULL,NULL),(13,'3919',200,1,NULL,NULL,NULL,NULL),(14,'3913',200,1,NULL,NULL,NULL,NULL),(15,'3914',200,1,NULL,NULL,NULL,NULL),(16,'3915',200,1,NULL,NULL,NULL,NULL),(17,'3916',200,1,NULL,NULL,NULL,NULL),(18,'3910',200,1,NULL,NULL,NULL,NULL),(19,'3911',200,1,NULL,NULL,NULL,NULL),(20,'3912',200,1,NULL,NULL,NULL,NULL),(21,'3995',200,1,NULL,NULL,NULL,NULL),(22,'3996',200,1,NULL,NULL,NULL,NULL),(23,'3993',200,1,NULL,NULL,NULL,NULL),(24,'3994',200,1,NULL,NULL,NULL,NULL),(25,'3999',200,1,NULL,NULL,NULL,NULL),(26,'3997',200,1,NULL,NULL,NULL,NULL),(27,'3998',200,1,NULL,NULL,NULL,NULL),(28,'3948',200,1,NULL,NULL,NULL,NULL),(29,'3949',200,1,NULL,NULL,NULL,NULL),(30,'3946',200,1,NULL,NULL,NULL,NULL),(31,'3947',200,1,NULL,NULL,NULL,NULL),(32,'3940',200,1,NULL,NULL,NULL,NULL),(33,'3941',200,1,NULL,NULL,NULL,NULL),(34,'3944',200,1,NULL,NULL,NULL,NULL),(35,'3945',200,1,NULL,NULL,NULL,NULL),(36,'3942',200,1,NULL,NULL,NULL,NULL),(37,'3943',200,1,NULL,NULL,NULL,NULL),(38,'3935',200,1,NULL,NULL,NULL,NULL),(39,'3936',200,1,NULL,NULL,NULL,NULL),(40,'3937',200,1,NULL,NULL,NULL,NULL),(41,'3938',200,1,NULL,NULL,NULL,NULL),(42,'3939',200,1,NULL,NULL,NULL,NULL),(43,'3930',200,1,NULL,NULL,NULL,NULL),(44,'3931',200,1,NULL,NULL,NULL,NULL),(45,'3932',200,1,NULL,NULL,NULL,NULL),(46,'3933',200,1,NULL,NULL,NULL,NULL),(47,'3934',200,1,NULL,NULL,NULL,NULL),(48,'3970',200,1,NULL,NULL,NULL,NULL),(49,'4000',200,1,NULL,NULL,NULL,NULL),(50,'3967',200,1,NULL,NULL,NULL,NULL),(51,'3966',200,1,NULL,NULL,NULL,NULL),(52,'3965',200,1,NULL,NULL,NULL,NULL),(53,'3964',200,1,NULL,NULL,NULL,NULL),(54,'3963',200,1,NULL,NULL,NULL,NULL),(55,'3962',200,1,NULL,NULL,NULL,NULL),(56,'3961',200,1,NULL,NULL,NULL,NULL),(57,'3960',200,1,NULL,NULL,NULL,NULL),(58,'3969',200,1,NULL,NULL,NULL,NULL),(59,'3968',200,1,NULL,NULL,NULL,NULL),(60,'3954',200,1,NULL,NULL,NULL,NULL),(61,'3953',200,1,NULL,NULL,NULL,NULL),(62,'3956',200,1,NULL,NULL,NULL,NULL),(63,'3955',200,1,NULL,NULL,NULL,NULL),(64,'3950',200,1,NULL,NULL,NULL,NULL),(65,'3952',200,1,NULL,NULL,NULL,NULL),(66,'3951',200,1,NULL,NULL,NULL,NULL),(67,'3958',200,1,NULL,NULL,NULL,NULL),(68,'3957',200,1,NULL,NULL,NULL,NULL),(69,'3959',200,1,NULL,NULL,NULL,NULL),(70,'3901',200,1,NULL,NULL,NULL,NULL),(71,'3900',200,1,NULL,NULL,NULL,NULL),(72,'3903',200,1,NULL,NULL,NULL,NULL),(73,'3902',200,1,NULL,NULL,NULL,NULL),(74,'3905',200,1,NULL,NULL,NULL,NULL),(75,'3904',200,1,NULL,NULL,NULL,NULL),(76,'3907',200,1,NULL,NULL,NULL,NULL),(77,'3991',200,1,NULL,NULL,NULL,NULL),(78,'3906',200,1,NULL,NULL,NULL,NULL),(79,'3992',200,1,NULL,NULL,NULL,NULL),(80,'3909',200,1,NULL,NULL,NULL,NULL),(81,'3908',200,1,NULL,NULL,NULL,NULL),(82,'3990',200,1,NULL,NULL,NULL,NULL),(83,'3985',200,1,NULL,NULL,NULL,NULL),(84,'3984',200,1,NULL,NULL,NULL,NULL),(85,'3983',200,1,NULL,NULL,NULL,NULL),(86,'3982',200,1,NULL,NULL,NULL,NULL),(87,'3989',200,1,NULL,NULL,NULL,NULL),(88,'3988',200,1,NULL,NULL,NULL,NULL),(89,'3987',200,1,NULL,NULL,NULL,NULL),(90,'3986',200,1,NULL,NULL,NULL,NULL),(91,'3980',200,1,NULL,NULL,NULL,NULL),(92,'3981',200,1,NULL,NULL,NULL,NULL),(93,'3972',200,1,NULL,NULL,NULL,NULL),(94,'3971',200,1,NULL,NULL,NULL,NULL),(95,'3974',200,1,NULL,NULL,NULL,NULL),(96,'3973',200,1,NULL,NULL,NULL,NULL),(97,'3976',200,1,NULL,NULL,NULL,NULL),(98,'3975',200,1,NULL,NULL,NULL,NULL),(99,'3978',200,1,NULL,NULL,NULL,NULL),(100,'3977',200,1,NULL,NULL,NULL,NULL),(101,'3979',200,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `op_dc_vnet_alloc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_ha_work`
--

DROP TABLE IF EXISTS `op_ha_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_ha_work` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `instance_id` bigint(20) unsigned NOT NULL COMMENT 'vm instance that needs to be ha.',
  `type` varchar(32) NOT NULL COMMENT 'type of work',
  `vm_type` varchar(32) NOT NULL COMMENT 'VM type',
  `state` varchar(32) NOT NULL COMMENT 'state of the vm instance when this happened.',
  `mgmt_server_id` bigint(20) unsigned DEFAULT NULL COMMENT 'management server that has taken up the work of doing ha',
  `host_id` bigint(20) unsigned DEFAULT NULL COMMENT 'host that the vm is suppose to be on',
  `created` datetime NOT NULL COMMENT 'time the entry was requested',
  `tried` int(10) unsigned DEFAULT NULL COMMENT '# of times tried',
  `taken` datetime DEFAULT NULL COMMENT 'time it was taken by the management server',
  `step` varchar(32) NOT NULL COMMENT 'Step in the work',
  `time_to_try` bigint(20) DEFAULT NULL COMMENT 'time to try do this work',
  `updated` bigint(20) unsigned NOT NULL COMMENT 'time the VM state was updated when it was stored into work queue',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `i_op_ha_work__instance_id` (`instance_id`),
  KEY `i_op_ha_work__host_id` (`host_id`),
  KEY `i_op_ha_work__step` (`step`),
  KEY `i_op_ha_work__type` (`type`),
  KEY `i_op_ha_work__mgmt_server_id` (`mgmt_server_id`),
  CONSTRAINT `fk_op_ha_work__instance_id` FOREIGN KEY (`instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_op_ha_work__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`),
  CONSTRAINT `fk_op_ha_work__mgmt_server_id` FOREIGN KEY (`mgmt_server_id`) REFERENCES `mshost` (`msid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_ha_work`
--

LOCK TABLES `op_ha_work` WRITE;
/*!40000 ALTER TABLE `op_ha_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_ha_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_host`
--

DROP TABLE IF EXISTS `op_host`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_host` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'host id',
  `sequence` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT 'sequence for the host communication',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  CONSTRAINT `fk_op_host__id` FOREIGN KEY (`id`) REFERENCES `host` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_host`
--

LOCK TABLES `op_host` WRITE;
/*!40000 ALTER TABLE `op_host` DISABLE KEYS */;
INSERT INTO `op_host` VALUES (1,1);
/*!40000 ALTER TABLE `op_host` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_host_capacity`
--

DROP TABLE IF EXISTS `op_host_capacity`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_host_capacity` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` bigint(20) unsigned DEFAULT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `pod_id` bigint(20) unsigned DEFAULT NULL,
  `cluster_id` bigint(20) unsigned DEFAULT NULL COMMENT 'foreign key to cluster',
  `used_capacity` bigint(20) NOT NULL,
  `reserved_capacity` bigint(20) NOT NULL,
  `total_capacity` bigint(20) NOT NULL,
  `capacity_type` int(1) unsigned NOT NULL,
  `capacity_state` varchar(32) NOT NULL DEFAULT 'Enabled' COMMENT 'Is this capacity enabled for allocation for new resources',
  `update_time` datetime DEFAULT NULL COMMENT 'time the capacity was last updated',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  KEY `i_op_host_capacity__host_type` (`host_id`,`capacity_type`),
  KEY `i_op_host_capacity__pod_id` (`pod_id`),
  KEY `i_op_host_capacity__data_center_id` (`data_center_id`),
  KEY `i_op_host_capacity__cluster_id` (`cluster_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_host_capacity`
--

LOCK TABLES `op_host_capacity` WRITE;
/*!40000 ALTER TABLE `op_host_capacity` DISABLE KEYS */;
INSERT INTO `op_host_capacity` VALUES (1,NULL,1,NULL,NULL,0,0,0,4,'Enabled','2013-10-26 06:35:56','2013-10-26 06:35:56'),(2,NULL,1,NULL,NULL,0,0,0,8,'Enabled','2013-10-26 06:35:56','2013-10-26 06:35:56'),(3,NULL,1,NULL,NULL,0,0,0,7,'Enabled','2013-10-26 06:35:56','2013-10-26 06:35:56'),(4,1,1,1,1,184614912,0,33808039936,9,'Enabled','2013-10-26 06:36:14','2013-10-26 06:36:14'),(5,1,1,1,1,0,0,7546988736,0,'Enabled','2013-10-26 06:37:25','2013-10-26 06:36:14'),(6,1,1,1,1,0,0,4100,1,'Enabled','2013-10-26 06:37:25','2013-10-26 06:36:14');
/*!40000 ALTER TABLE `op_host_capacity` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_host_planner_reservation`
--

DROP TABLE IF EXISTS `op_host_planner_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_host_planner_reservation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `pod_id` bigint(20) unsigned DEFAULT NULL,
  `cluster_id` bigint(20) unsigned DEFAULT NULL,
  `host_id` bigint(20) unsigned DEFAULT NULL,
  `resource_usage` varchar(255) DEFAULT NULL COMMENT 'Shared(between planners) Vs Dedicated (exclusive usage to a planner)',
  PRIMARY KEY (`id`),
  KEY `i_op_host_planner_reservation__host_resource_usage` (`host_id`,`resource_usage`),
  KEY `fk_planner_reservation__data_center_id` (`data_center_id`),
  KEY `fk_planner_reservation__pod_id` (`pod_id`),
  KEY `fk_planner_reservation__cluster_id` (`cluster_id`),
  CONSTRAINT `fk_planner_reservation__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_planner_reservation__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_planner_reservation__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_planner_reservation__cluster_id` FOREIGN KEY (`cluster_id`) REFERENCES `cluster` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_host_planner_reservation`
--

LOCK TABLES `op_host_planner_reservation` WRITE;
/*!40000 ALTER TABLE `op_host_planner_reservation` DISABLE KEYS */;
INSERT INTO `op_host_planner_reservation` VALUES (1,1,1,1,1,'Shared');
/*!40000 ALTER TABLE `op_host_planner_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_host_transfer`
--

DROP TABLE IF EXISTS `op_host_transfer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_host_transfer` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'Id of the host',
  `initial_mgmt_server_id` bigint(20) unsigned DEFAULT NULL COMMENT 'management server the host is transfered from',
  `future_mgmt_server_id` bigint(20) unsigned DEFAULT NULL COMMENT 'management server the host is transfered to',
  `state` varchar(32) NOT NULL COMMENT 'the transfer state of the host',
  `created` datetime NOT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_op_host_transfer__initial_mgmt_server_id` (`initial_mgmt_server_id`),
  KEY `fk_op_host_transfer__future_mgmt_server_id` (`future_mgmt_server_id`),
  CONSTRAINT `fk_op_host_transfer__id` FOREIGN KEY (`id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_op_host_transfer__initial_mgmt_server_id` FOREIGN KEY (`initial_mgmt_server_id`) REFERENCES `mshost` (`msid`),
  CONSTRAINT `fk_op_host_transfer__future_mgmt_server_id` FOREIGN KEY (`future_mgmt_server_id`) REFERENCES `mshost` (`msid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_host_transfer`
--

LOCK TABLES `op_host_transfer` WRITE;
/*!40000 ALTER TABLE `op_host_transfer` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_host_transfer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_host_upgrade`
--

DROP TABLE IF EXISTS `op_host_upgrade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_host_upgrade` (
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id',
  `version` varchar(20) NOT NULL COMMENT 'version',
  `state` varchar(20) NOT NULL COMMENT 'state',
  PRIMARY KEY (`host_id`),
  UNIQUE KEY `host_id` (`host_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_host_upgrade`
--

LOCK TABLES `op_host_upgrade` WRITE;
/*!40000 ALTER TABLE `op_host_upgrade` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_host_upgrade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_it_work`
--

DROP TABLE IF EXISTS `op_it_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_it_work` (
  `id` char(40) NOT NULL DEFAULT '' COMMENT 'reservation id',
  `mgmt_server_id` bigint(20) unsigned DEFAULT NULL COMMENT 'management server id',
  `created_at` bigint(20) unsigned NOT NULL COMMENT 'when was this work detail created',
  `thread` varchar(255) NOT NULL COMMENT 'thread name',
  `type` char(32) NOT NULL COMMENT 'type of work',
  `vm_type` char(32) NOT NULL COMMENT 'type of vm',
  `step` char(32) NOT NULL COMMENT 'state',
  `updated_at` bigint(20) unsigned NOT NULL COMMENT 'time it was taken over',
  `instance_id` bigint(20) unsigned NOT NULL COMMENT 'vm instance',
  `resource_type` char(32) DEFAULT NULL COMMENT 'type of resource being worked on',
  `resource_id` bigint(20) unsigned DEFAULT NULL COMMENT 'resource id being worked on',
  PRIMARY KEY (`id`),
  KEY `fk_op_it_work__mgmt_server_id` (`mgmt_server_id`),
  KEY `fk_op_it_work__instance_id` (`instance_id`),
  KEY `i_op_it_work__step` (`step`),
  CONSTRAINT `fk_op_it_work__mgmt_server_id` FOREIGN KEY (`mgmt_server_id`) REFERENCES `mshost` (`msid`),
  CONSTRAINT `fk_op_it_work__instance_id` FOREIGN KEY (`instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_it_work`
--

LOCK TABLES `op_it_work` WRITE;
/*!40000 ALTER TABLE `op_it_work` DISABLE KEYS */;
INSERT INTO `op_it_work` VALUES ('199c52f6-7787-4e25-9f86-af6dcd84d720',22061634278039,1382769386,'consoleproxy-1','Starting','ConsoleProxy','Done',1382769386,2,NULL,0),('4b2a6384-054f-4716-9e18-550fc097a6a7',22061634278039,1382769386,'secstorage-1','Starting','SecondaryStorageVm','Done',1382769386,1,NULL,0);
/*!40000 ALTER TABLE `op_it_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_lock`
--

DROP TABLE IF EXISTS `op_lock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_lock` (
  `key` varchar(128) NOT NULL COMMENT 'primary key of the table',
  `mac` varchar(17) NOT NULL COMMENT 'management server id of the server that holds this lock',
  `ip` char(40) NOT NULL COMMENT 'name of the thread that holds this lock',
  `thread` varchar(255) NOT NULL COMMENT 'Thread id that acquired this lock',
  `acquired_on` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Time acquired',
  `waiters` int(11) NOT NULL DEFAULT '0' COMMENT 'How many have the thread acquired this lock (reentrant)',
  PRIMARY KEY (`key`),
  UNIQUE KEY `key` (`key`),
  KEY `i_op_lock__mac_ip_thread` (`mac`,`ip`,`thread`)
) ENGINE=MEMORY DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_lock`
--

LOCK TABLES `op_lock` WRITE;
/*!40000 ALTER TABLE `op_lock` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_lock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_networks`
--

DROP TABLE IF EXISTS `op_networks`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_networks` (
  `id` bigint(20) unsigned NOT NULL,
  `mac_address_seq` bigint(20) unsigned NOT NULL DEFAULT '1' COMMENT 'mac address',
  `nics_count` int(10) unsigned NOT NULL DEFAULT '0' COMMENT '# of nics',
  `gc` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT 'gc this network or not',
  `check_for_gc` tinyint(3) unsigned NOT NULL DEFAULT '1' COMMENT 'check this network for gc or not',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  CONSTRAINT `fk_op_networks__id` FOREIGN KEY (`id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_networks`
--

LOCK TABLES `op_networks` WRITE;
/*!40000 ALTER TABLE `op_networks` DISABLE KEYS */;
INSERT INTO `op_networks` VALUES (200,1,0,0,0),(201,1,0,0,0),(202,1,0,0,0),(203,1,0,0,0);
/*!40000 ALTER TABLE `op_networks` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_nwgrp_work`
--

DROP TABLE IF EXISTS `op_nwgrp_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_nwgrp_work` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `instance_id` bigint(20) unsigned NOT NULL COMMENT 'vm instance that needs rules to be synced.',
  `mgmt_server_id` bigint(20) unsigned DEFAULT NULL COMMENT 'management server that has taken up the work of doing rule sync',
  `created` datetime NOT NULL COMMENT 'time the entry was requested',
  `taken` datetime DEFAULT NULL COMMENT 'time it was taken by the management server',
  `step` varchar(32) NOT NULL COMMENT 'Step in the work',
  `seq_no` bigint(20) unsigned DEFAULT NULL COMMENT 'seq number to be sent to agent, uniquely identifies ruleset update',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `i_op_nwgrp_work__instance_id` (`instance_id`),
  KEY `i_op_nwgrp_work__mgmt_server_id` (`mgmt_server_id`),
  KEY `i_op_nwgrp_work__taken` (`taken`),
  KEY `i_op_nwgrp_work__step` (`step`),
  KEY `i_op_nwgrp_work__seq_no` (`seq_no`)
) ENGINE=MEMORY DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_nwgrp_work`
--

LOCK TABLES `op_nwgrp_work` WRITE;
/*!40000 ALTER TABLE `op_nwgrp_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_nwgrp_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_pod_vlan_alloc`
--

DROP TABLE IF EXISTS `op_pod_vlan_alloc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_pod_vlan_alloc` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary id',
  `vlan` varchar(18) NOT NULL COMMENT 'vlan id',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center the pod belongs to',
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod the vlan belongs to',
  `account_id` bigint(20) unsigned DEFAULT NULL COMMENT 'account the vlan belongs to right now',
  `taken` datetime DEFAULT NULL COMMENT 'Date taken',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_pod_vlan_alloc`
--

LOCK TABLES `op_pod_vlan_alloc` WRITE;
/*!40000 ALTER TABLE `op_pod_vlan_alloc` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_pod_vlan_alloc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_user_stats_log`
--

DROP TABLE IF EXISTS `op_user_stats_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_user_stats_log` (
  `user_stats_id` bigint(20) unsigned NOT NULL,
  `net_bytes_received` bigint(20) unsigned NOT NULL DEFAULT '0',
  `net_bytes_sent` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_bytes_received` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_bytes_sent` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_bytes_received` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_bytes_sent` bigint(20) unsigned NOT NULL DEFAULT '0',
  `updated` datetime DEFAULT NULL COMMENT 'stats update timestamp',
  UNIQUE KEY `user_stats_id` (`user_stats_id`,`updated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_user_stats_log`
--

LOCK TABLES `op_user_stats_log` WRITE;
/*!40000 ALTER TABLE `op_user_stats_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_user_stats_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `op_vm_ruleset_log`
--

DROP TABLE IF EXISTS `op_vm_ruleset_log`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `op_vm_ruleset_log` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `instance_id` bigint(20) unsigned NOT NULL COMMENT 'vm instance that needs rules to be synced.',
  `created` datetime NOT NULL COMMENT 'time the entry was requested',
  `logsequence` bigint(20) unsigned DEFAULT NULL COMMENT 'seq number to be sent to agent, uniquely identifies ruleset update',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `u_op_vm_ruleset_log__instance_id` (`instance_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `op_vm_ruleset_log`
--

LOCK TABLES `op_vm_ruleset_log` WRITE;
/*!40000 ALTER TABLE `op_vm_ruleset_log` DISABLE KEYS */;
/*!40000 ALTER TABLE `op_vm_ruleset_log` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ovs_tunnel_interface`
--

DROP TABLE IF EXISTS `ovs_tunnel_interface`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ovs_tunnel_interface` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `ip` varchar(16) DEFAULT NULL,
  `netmask` varchar(16) DEFAULT NULL,
  `mac` varchar(18) DEFAULT NULL,
  `host_id` bigint(20) DEFAULT NULL,
  `label` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ovs_tunnel_interface`
--

LOCK TABLES `ovs_tunnel_interface` WRITE;
/*!40000 ALTER TABLE `ovs_tunnel_interface` DISABLE KEYS */;
INSERT INTO `ovs_tunnel_interface` VALUES (1,'0','0','0',0,'lock');
/*!40000 ALTER TABLE `ovs_tunnel_interface` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ovs_tunnel_network`
--

DROP TABLE IF EXISTS `ovs_tunnel_network`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ovs_tunnel_network` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `from` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'from host id',
  `to` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'to host id',
  `network_id` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'network identifier',
  `key` int(10) unsigned DEFAULT NULL COMMENT 'gre key',
  `port_name` varchar(32) DEFAULT NULL COMMENT 'in port on open vswitch',
  `state` varchar(16) DEFAULT 'FAILED' COMMENT 'result of tunnel creatation',
  PRIMARY KEY (`from`,`to`,`network_id`),
  UNIQUE KEY `id` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ovs_tunnel_network`
--

LOCK TABLES `ovs_tunnel_network` WRITE;
/*!40000 ALTER TABLE `ovs_tunnel_network` DISABLE KEYS */;
INSERT INTO `ovs_tunnel_network` VALUES (1,0,0,0,0,'lock','SUCCESS');
/*!40000 ALTER TABLE `ovs_tunnel_network` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_network`
--

DROP TABLE IF EXISTS `physical_network`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_network` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center id that this physical network belongs to',
  `vnet` varchar(255) DEFAULT NULL,
  `speed` varchar(32) DEFAULT NULL,
  `domain_id` bigint(20) unsigned DEFAULT NULL COMMENT 'foreign key to domain id',
  `broadcast_domain_range` varchar(32) NOT NULL DEFAULT 'POD' COMMENT 'range of broadcast domain : POD/ZONE',
  `state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'what state is this configuration in',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_physical_networks__uuid` (`uuid`),
  KEY `fk_physical_network__data_center_id` (`data_center_id`),
  KEY `fk_physical_network__domain_id` (`domain_id`),
  KEY `i_physical_network__removed` (`removed`),
  CONSTRAINT `fk_physical_network__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_physical_network__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=201 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_network`
--

LOCK TABLES `physical_network` WRITE;
/*!40000 ALTER TABLE `physical_network` DISABLE KEYS */;
INSERT INTO `physical_network` VALUES (200,'443034f1-1c8c-4ebc-bdb0-d37329264651','eth0',1,'3900-4000',NULL,NULL,'ZONE','Enabled','2013-10-26 06:35:26',NULL);
/*!40000 ALTER TABLE `physical_network` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_network_isolation_methods`
--

DROP TABLE IF EXISTS `physical_network_isolation_methods`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_network_isolation_methods` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network',
  `isolation_method` varchar(255) NOT NULL COMMENT 'isolation method(VLAN, L3 or GRE)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `physical_network_id` (`physical_network_id`,`isolation_method`),
  CONSTRAINT `fk_physical_network_imethods__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_network_isolation_methods`
--

LOCK TABLES `physical_network_isolation_methods` WRITE;
/*!40000 ALTER TABLE `physical_network_isolation_methods` DISABLE KEYS */;
/*!40000 ALTER TABLE `physical_network_isolation_methods` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_network_service_providers`
--

DROP TABLE IF EXISTS `physical_network_service_providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_network_service_providers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network',
  `provider_name` varchar(255) NOT NULL COMMENT 'Service Provider name',
  `state` varchar(32) NOT NULL DEFAULT 'Disabled' COMMENT 'provider state',
  `destination_physical_network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'id of the physical network to bridge to',
  `vpn_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is VPN service provided',
  `dhcp_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is DHCP service provided',
  `dns_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is DNS service provided',
  `gateway_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is Gateway service provided',
  `firewall_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is Firewall service provided',
  `source_nat_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is Source NAT service provided',
  `load_balance_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is LB service provided',
  `static_nat_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is Static NAT service provided',
  `port_forwarding_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is Port Forwarding service provided',
  `user_data_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is UserData service provided',
  `security_group_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is SG service provided',
  `networkacl_service_provided` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is Network ACL service provided',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_service_providers__uuid` (`uuid`),
  KEY `fk_pnetwork_service_providers__physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_pnetwork_service_providers__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_network_service_providers`
--

LOCK TABLES `physical_network_service_providers` WRITE;
/*!40000 ALTER TABLE `physical_network_service_providers` DISABLE KEYS */;
INSERT INTO `physical_network_service_providers` VALUES (1,'696de5bd-a643-4271-a87d-b26a779797bb',200,'VirtualRouter','Enabled',0,1,1,1,1,1,1,1,1,1,1,0,0,NULL),(2,'d21eaee4-a978-47fc-9fef-ed0ceabe5b88',200,'SecurityGroupProvider','Disabled',0,0,0,0,0,0,0,0,0,0,0,1,0,NULL),(3,'cd7fcabe-1cf5-4bb4-8303-f99b7773a358',200,'VpcVirtualRouter','Enabled',0,1,1,1,1,0,1,1,1,1,1,0,1,NULL),(4,'0b6218e0-b4e5-4cb5-b895-fc89a401b2c5',200,'InternalLbVm','Enabled',0,0,0,0,0,0,0,1,0,0,0,0,0,NULL);
/*!40000 ALTER TABLE `physical_network_service_providers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_network_tags`
--

DROP TABLE IF EXISTS `physical_network_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_network_tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network',
  `tag` varchar(255) NOT NULL COMMENT 'tag',
  PRIMARY KEY (`id`),
  UNIQUE KEY `physical_network_id` (`physical_network_id`,`tag`),
  CONSTRAINT `fk_physical_network_tags__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_network_tags`
--

LOCK TABLES `physical_network_tags` WRITE;
/*!40000 ALTER TABLE `physical_network_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `physical_network_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `physical_network_traffic_types`
--

DROP TABLE IF EXISTS `physical_network_traffic_types`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `physical_network_traffic_types` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the physical network',
  `traffic_type` varchar(32) NOT NULL COMMENT 'type of traffic going through this network',
  `xen_network_label` varchar(255) DEFAULT NULL COMMENT 'The network name label of the physical device dedicated to this traffic on a XenServer host',
  `kvm_network_label` varchar(255) DEFAULT 'cloudbr0' COMMENT 'The network name label of the physical device dedicated to this traffic on a KVM host',
  `vmware_network_label` varchar(255) DEFAULT 'vSwitch0' COMMENT 'The network name label of the physical device dedicated to this traffic on a VMware host',
  `simulator_network_label` varchar(255) DEFAULT NULL COMMENT 'The name labels needed for identifying the simulator',
  `ovm_network_label` varchar(255) DEFAULT NULL COMMENT 'The network name label of the physical device dedicated to this traffic on a Ovm host',
  `vlan` varchar(255) DEFAULT NULL COMMENT 'The vlan tag to be sent down to a VMware host',
  `lxc_network_label` varchar(255) DEFAULT 'cloudbr0' COMMENT 'The network name label of the physical device dedicated to this traffic on a LXC host',
  PRIMARY KEY (`id`),
  UNIQUE KEY `physical_network_id` (`physical_network_id`,`traffic_type`),
  UNIQUE KEY `uc_traffic_types__uuid` (`uuid`),
  CONSTRAINT `fk_physical_network_traffic_types__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `physical_network_traffic_types`
--

LOCK TABLES `physical_network_traffic_types` WRITE;
/*!40000 ALTER TABLE `physical_network_traffic_types` DISABLE KEYS */;
INSERT INTO `physical_network_traffic_types` VALUES (1,'97797fb8-2342-4527-b01e-64311f461078',200,'Management','Pool-wide network associated with eth0',NULL,NULL,NULL,NULL,NULL,'cloudbr0'),(2,'d102a472-2204-42d0-aa70-79e9a51c2b71',200,'Guest','Pool-wide network associated with eth0',NULL,NULL,NULL,NULL,NULL,'cloudbr0'),(3,'c4707703-949a-444c-a0e6-9f7ccf8d7b81',200,'Public','Pool-wide network associated with eth0',NULL,NULL,NULL,NULL,NULL,'cloudbr0'),(4,'fc0a537d-ce02-4372-a765-63c6e0e15c0f',200,'Storage','Pool-wide network associated with eth0',NULL,NULL,NULL,NULL,NULL,'cloudbr0');
/*!40000 ALTER TABLE `physical_network_traffic_types` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pod_vlan_map`
--

DROP TABLE IF EXISTS `pod_vlan_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pod_vlan_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod id. foreign key to pod table',
  `vlan_db_id` bigint(20) unsigned NOT NULL COMMENT 'database id of vlan. foreign key to vlan table',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `i_pod_vlan_map__pod_id` (`pod_id`),
  KEY `i_pod_vlan_map__vlan_id` (`vlan_db_id`),
  CONSTRAINT `fk_pod_vlan_map__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_pod_vlan_map__vlan_id` FOREIGN KEY (`vlan_db_id`) REFERENCES `vlan` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pod_vlan_map`
--

LOCK TABLES `pod_vlan_map` WRITE;
/*!40000 ALTER TABLE `pod_vlan_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `pod_vlan_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `port_forwarding_rules`
--

DROP TABLE IF EXISTS `port_forwarding_rules`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `port_forwarding_rules` (
  `id` bigint(20) unsigned NOT NULL COMMENT 'id',
  `instance_id` bigint(20) unsigned NOT NULL COMMENT 'vm instance id',
  `dest_ip_address` char(40) NOT NULL COMMENT 'id_address',
  `dest_port_start` int(10) NOT NULL COMMENT 'starting port of the port range to map to',
  `dest_port_end` int(10) NOT NULL COMMENT 'end port of the the port range to map to',
  PRIMARY KEY (`id`),
  KEY `fk_port_forwarding_rules__instance_id` (`instance_id`),
  CONSTRAINT `fk_port_forwarding_rules__id` FOREIGN KEY (`id`) REFERENCES `firewall_rules` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_port_forwarding_rules__instance_id` FOREIGN KEY (`instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `port_forwarding_rules`
--

LOCK TABLES `port_forwarding_rules` WRITE;
/*!40000 ALTER TABLE `port_forwarding_rules` DISABLE KEYS */;
/*!40000 ALTER TABLE `port_forwarding_rules` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `port_profile`
--

DROP TABLE IF EXISTS `port_profile`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `port_profile` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `port_profile_name` varchar(255) DEFAULT NULL,
  `port_mode` varchar(10) DEFAULT NULL,
  `vsm_id` bigint(20) unsigned NOT NULL,
  `trunk_low_vlan_id` int(11) DEFAULT NULL,
  `trunk_high_vlan_id` int(11) DEFAULT NULL,
  `access_vlan_id` int(11) DEFAULT NULL,
  `port_type` varchar(20) NOT NULL,
  `port_binding` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `port_profile`
--

LOCK TABLES `port_profile` WRITE;
/*!40000 ALTER TABLE `port_profile` DISABLE KEYS */;
/*!40000 ALTER TABLE `port_profile` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portable_ip_address`
--

DROP TABLE IF EXISTS `portable_ip_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portable_ip_address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned DEFAULT NULL,
  `domain_id` bigint(20) unsigned DEFAULT NULL,
  `allocated` datetime DEFAULT NULL COMMENT 'Date portable ip was allocated',
  `state` char(32) NOT NULL DEFAULT 'Free' COMMENT 'state of the portable ip address',
  `region_id` int(10) unsigned NOT NULL,
  `vlan` varchar(255) DEFAULT NULL,
  `gateway` varchar(255) DEFAULT NULL,
  `netmask` varchar(255) DEFAULT NULL,
  `portable_ip_address` varchar(255) DEFAULT NULL,
  `portable_ip_range_id` bigint(20) unsigned NOT NULL,
  `data_center_id` bigint(20) unsigned DEFAULT NULL COMMENT 'zone to which portable IP is associated',
  `physical_network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'physical network id in the zone to which portable IP is associated',
  `network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'guest network to which portable ip address is associated with',
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vpc to which portable ip address is associated with',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_portable_ip_address__portable_ip_range_id` (`portable_ip_range_id`),
  KEY `fk_portable_ip_address__region_id` (`region_id`),
  CONSTRAINT `fk_portable_ip_address__portable_ip_range_id` FOREIGN KEY (`portable_ip_range_id`) REFERENCES `portable_ip_range` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_portable_ip_address__region_id` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portable_ip_address`
--

LOCK TABLES `portable_ip_address` WRITE;
/*!40000 ALTER TABLE `portable_ip_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `portable_ip_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `portable_ip_range`
--

DROP TABLE IF EXISTS `portable_ip_range`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `portable_ip_range` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `region_id` int(10) unsigned NOT NULL,
  `vlan_id` varchar(255) DEFAULT NULL,
  `gateway` varchar(255) DEFAULT NULL,
  `netmask` varchar(255) DEFAULT NULL,
  `start_ip` varchar(255) DEFAULT NULL,
  `end_ip` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_portableip__region_id` (`region_id`),
  CONSTRAINT `fk_portableip__region_id` FOREIGN KEY (`region_id`) REFERENCES `region` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `portable_ip_range`
--

LOCK TABLES `portable_ip_range` WRITE;
/*!40000 ALTER TABLE `portable_ip_range` DISABLE KEYS */;
/*!40000 ALTER TABLE `portable_ip_range` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `private_ip_address`
--

DROP TABLE IF EXISTS `private_ip_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `private_ip_address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'primary key',
  `ip_address` char(40) NOT NULL COMMENT 'ip address',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'id of the network ip belongs to',
  `reservation_id` char(40) DEFAULT NULL COMMENT 'reservation id',
  `mac_address` varchar(17) DEFAULT NULL COMMENT 'mac address',
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vpc this ip belongs to',
  `taken` datetime DEFAULT NULL COMMENT 'Date taken',
  `source_nat` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_private_ip_address__vpc_id` (`vpc_id`),
  KEY `fk_private_ip_address__network_id` (`network_id`),
  CONSTRAINT `fk_private_ip_address__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_private_ip_address__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `private_ip_address`
--

LOCK TABLES `private_ip_address` WRITE;
/*!40000 ALTER TABLE `private_ip_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `private_ip_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `project_account`
--

DROP TABLE IF EXISTS `project_account`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'account id',
  `account_role` varchar(255) NOT NULL DEFAULT 'Regular' COMMENT 'Account role in the project (Owner or Regular)',
  `project_id` bigint(20) unsigned NOT NULL COMMENT 'project id',
  `project_account_id` bigint(20) unsigned NOT NULL,
  `created` datetime DEFAULT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `account_id` (`account_id`,`project_id`),
  KEY `fk_project_account__project_id` (`project_id`),
  KEY `fk_project_account__project_account_id` (`project_account_id`),
  CONSTRAINT `fk_project_account__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_project_account__project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_project_account__project_account_id` FOREIGN KEY (`project_account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_account`
--

LOCK TABLES `project_account` WRITE;
/*!40000 ALTER TABLE `project_account` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_account` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `project_account_view`
--

DROP TABLE IF EXISTS `project_account_view`;
/*!50001 DROP VIEW IF EXISTS `project_account_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `project_account_view` (
  `id` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `account_role` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Temporary table structure for view `project_invitation_view`
--

DROP TABLE IF EXISTS `project_invitation_view`;
/*!50001 DROP VIEW IF EXISTS `project_invitation_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `project_invitation_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `project_invitations`
--

DROP TABLE IF EXISTS `project_invitations`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `project_invitations` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `project_id` bigint(20) unsigned NOT NULL COMMENT 'project id',
  `account_id` bigint(20) unsigned DEFAULT NULL COMMENT 'account id',
  `domain_id` bigint(20) unsigned DEFAULT NULL COMMENT 'domain id',
  `email` varchar(255) DEFAULT NULL COMMENT 'email',
  `token` varchar(255) DEFAULT NULL COMMENT 'token',
  `state` varchar(255) NOT NULL DEFAULT 'Pending' COMMENT 'the state of the invitation',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `project_id` (`project_id`,`account_id`),
  UNIQUE KEY `project_id_2` (`project_id`,`email`),
  UNIQUE KEY `project_id_3` (`project_id`,`token`),
  UNIQUE KEY `uc_project_invitations__uuid` (`uuid`),
  KEY `fk_project_invitations__account_id` (`account_id`),
  KEY `fk_project_invitations__domain_id` (`domain_id`),
  CONSTRAINT `fk_project_invitations__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_project_invitations__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_project_invitations__project_id` FOREIGN KEY (`project_id`) REFERENCES `projects` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `project_invitations`
--

LOCK TABLES `project_invitations` WRITE;
/*!40000 ALTER TABLE `project_invitations` DISABLE KEYS */;
/*!40000 ALTER TABLE `project_invitations` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `project_view`
--

DROP TABLE IF EXISTS `project_view`;
/*!50001 DROP VIEW IF EXISTS `project_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `project_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `display_text` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `project_account_id` tinyint NOT NULL,
  `owner` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `tag_id` tinyint NOT NULL,
  `tag_uuid` tinyint NOT NULL,
  `tag_key` tinyint NOT NULL,
  `tag_value` tinyint NOT NULL,
  `tag_domain_id` tinyint NOT NULL,
  `tag_account_id` tinyint NOT NULL,
  `tag_resource_id` tinyint NOT NULL,
  `tag_resource_uuid` tinyint NOT NULL,
  `tag_resource_type` tinyint NOT NULL,
  `tag_customer` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `projects`
--

DROP TABLE IF EXISTS `projects`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `projects` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'project name',
  `uuid` varchar(40) DEFAULT NULL,
  `display_text` varchar(255) DEFAULT NULL COMMENT 'project name',
  `project_account_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed',
  `state` varchar(255) NOT NULL COMMENT 'state of the project (Active/Inactive/Suspended)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_projects__uuid` (`uuid`),
  KEY `fk_projects__project_account_id` (`project_account_id`),
  KEY `fk_projects__domain_id` (`domain_id`),
  KEY `i_projects__removed` (`removed`),
  CONSTRAINT `fk_projects__project_account_id` FOREIGN KEY (`project_account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_projects__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `projects`
--

LOCK TABLES `projects` WRITE;
/*!40000 ALTER TABLE `projects` DISABLE KEYS */;
/*!40000 ALTER TABLE `projects` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `region`
--

DROP TABLE IF EXISTS `region`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `region` (
  `id` int(10) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `end_point` varchar(255) NOT NULL,
  `portableip_service_enabled` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is Portable IP service enalbed in the Region',
  `gslb_service_enabled` tinyint(1) unsigned NOT NULL DEFAULT '1' COMMENT 'Is GSLB service enalbed in the Region',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `region`
--

LOCK TABLES `region` WRITE;
/*!40000 ALTER TABLE `region` DISABLE KEYS */;
INSERT INTO `region` VALUES (1,'Local','http://localhost:8080/client/',0,1);
/*!40000 ALTER TABLE `region` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `remote_access_vpn`
--

DROP TABLE IF EXISTS `remote_access_vpn`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `remote_access_vpn` (
  `vpn_server_addr_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `network_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `local_ip` char(40) NOT NULL,
  `ip_range` varchar(32) NOT NULL,
  `ipsec_psk` varchar(256) NOT NULL,
  `state` char(32) NOT NULL,
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `vpn_server_addr_id` (`vpn_server_addr_id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `fk_remote_access_vpn__account_id` (`account_id`),
  KEY `fk_remote_access_vpn__domain_id` (`domain_id`),
  KEY `fk_remote_access_vpn__network_id` (`network_id`),
  CONSTRAINT `fk_remote_access_vpn__vpn_server_addr_id` FOREIGN KEY (`vpn_server_addr_id`) REFERENCES `user_ip_address` (`id`),
  CONSTRAINT `fk_remote_access_vpn__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_remote_access_vpn__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_remote_access_vpn__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `remote_access_vpn`
--

LOCK TABLES `remote_access_vpn` WRITE;
/*!40000 ALTER TABLE `remote_access_vpn` DISABLE KEYS */;
/*!40000 ALTER TABLE `remote_access_vpn` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_count`
--

DROP TABLE IF EXISTS `resource_count`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_count` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `account_id` bigint(20) unsigned DEFAULT NULL,
  `domain_id` bigint(20) unsigned DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `count` bigint(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_resource_count__type_accountId` (`type`,`account_id`),
  UNIQUE KEY `i_resource_count__type_domaintId` (`type`,`domain_id`),
  KEY `fk_resource_count__account_id` (`account_id`),
  KEY `fk_resource_count__domain_id` (`domain_id`),
  KEY `i_resource_count__type` (`type`),
  CONSTRAINT `fk_resource_count__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_resource_count__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_count`
--

LOCK TABLES `resource_count` WRITE;
/*!40000 ALTER TABLE `resource_count` DISABLE KEYS */;
INSERT INTO `resource_count` VALUES (1,1,NULL,'cpu',0),(2,1,NULL,'memory',0),(3,1,NULL,'primary_storage',0),(4,1,NULL,'secondary_storage',0),(5,2,NULL,'cpu',0),(6,2,NULL,'memory',0),(7,2,NULL,'primary_storage',0),(8,2,NULL,'secondary_storage',0),(9,NULL,1,'cpu',0),(10,NULL,1,'memory',0),(11,NULL,1,'primary_storage',0),(12,NULL,1,'secondary_storage',0),(33,NULL,1,'user_vm',0),(34,NULL,1,'public_ip',0),(35,NULL,1,'volume',0),(36,NULL,1,'snapshot',0),(37,NULL,1,'template',0),(38,NULL,1,'project',0),(39,NULL,1,'network',0),(40,NULL,1,'vpc',0),(41,1,NULL,'user_vm',0),(42,1,NULL,'public_ip',0),(43,1,NULL,'volume',0),(44,1,NULL,'snapshot',0),(45,1,NULL,'template',0),(46,1,NULL,'project',0),(47,1,NULL,'network',0),(48,1,NULL,'vpc',0),(49,2,NULL,'user_vm',0),(50,2,NULL,'public_ip',0),(51,2,NULL,'volume',0),(52,2,NULL,'snapshot',0),(53,2,NULL,'template',0),(54,2,NULL,'project',0),(55,2,NULL,'network',0),(56,2,NULL,'vpc',0);
/*!40000 ALTER TABLE `resource_count` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resource_limit`
--

DROP TABLE IF EXISTS `resource_limit`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_limit` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `domain_id` bigint(20) unsigned DEFAULT NULL,
  `account_id` bigint(20) unsigned DEFAULT NULL,
  `type` varchar(255) DEFAULT NULL,
  `max` bigint(20) NOT NULL DEFAULT '-1',
  PRIMARY KEY (`id`),
  KEY `i_resource_limit__domain_id` (`domain_id`),
  KEY `i_resource_limit__account_id` (`account_id`),
  CONSTRAINT `fk_resource_limit__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_resource_limit__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_limit`
--

LOCK TABLES `resource_limit` WRITE;
/*!40000 ALTER TABLE `resource_limit` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_limit` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `resource_tag_view`
--

DROP TABLE IF EXISTS `resource_tag_view`;
/*!50001 DROP VIEW IF EXISTS `resource_tag_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `resource_tag_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `key` tinyint NOT NULL,
  `value` tinyint NOT NULL,
  `resource_id` tinyint NOT NULL,
  `resource_uuid` tinyint NOT NULL,
  `resource_type` tinyint NOT NULL,
  `customer` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `resource_tags`
--

DROP TABLE IF EXISTS `resource_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `resource_tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `key` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `resource_id` bigint(20) unsigned NOT NULL,
  `resource_uuid` varchar(40) DEFAULT NULL,
  `resource_type` varchar(255) DEFAULT NULL,
  `customer` varchar(255) DEFAULT NULL,
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'foreign key to domain id',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner of this network',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_tags__resource_id__resource_type__key` (`resource_id`,`resource_type`,`key`),
  UNIQUE KEY `uc_resource_tags__uuid` (`uuid`),
  KEY `fk_tags__account_id` (`account_id`),
  KEY `fk_tags__domain_id` (`domain_id`),
  CONSTRAINT `fk_tags__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_tags__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resource_tags`
--

LOCK TABLES `resource_tags` WRITE;
/*!40000 ALTER TABLE `resource_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `resource_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `router_network_ref`
--

DROP TABLE IF EXISTS `router_network_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `router_network_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `router_id` bigint(20) unsigned NOT NULL COMMENT 'router id',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network id',
  `guest_type` char(32) DEFAULT NULL COMMENT 'type of guest network that can be shared or isolated',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_router_network_ref__router_id__network_id` (`router_id`,`network_id`),
  KEY `fk_router_network_ref__networks_id` (`network_id`),
  CONSTRAINT `fk_router_network_ref__router_id` FOREIGN KEY (`router_id`) REFERENCES `domain_router` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_router_network_ref__networks_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `router_network_ref`
--

LOCK TABLES `router_network_ref` WRITE;
/*!40000 ALTER TABLE `router_network_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `router_network_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s2s_customer_gateway`
--

DROP TABLE IF EXISTS `s2s_customer_gateway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s2s_customer_gateway` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `name` varchar(255) NOT NULL,
  `gateway_ip` char(40) NOT NULL,
  `guest_cidr_list` varchar(200) NOT NULL,
  `ipsec_psk` varchar(256) DEFAULT NULL,
  `ike_policy` varchar(30) NOT NULL,
  `esp_policy` varchar(30) NOT NULL,
  `ike_lifetime` int(11) NOT NULL DEFAULT '86400',
  `esp_lifetime` int(11) NOT NULL DEFAULT '3600',
  `dpd` int(1) NOT NULL DEFAULT '0',
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_s2s_customer_gateway__uuid` (`uuid`),
  KEY `fk_s2s_customer_gateway__account_id` (`account_id`),
  KEY `fk_s2s_customer_gateway__domain_id` (`domain_id`),
  CONSTRAINT `fk_s2s_customer_gateway__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_s2s_customer_gateway__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s2s_customer_gateway`
--

LOCK TABLES `s2s_customer_gateway` WRITE;
/*!40000 ALTER TABLE `s2s_customer_gateway` DISABLE KEYS */;
/*!40000 ALTER TABLE `s2s_customer_gateway` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s2s_vpn_connection`
--

DROP TABLE IF EXISTS `s2s_vpn_connection`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s2s_vpn_connection` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `vpn_gateway_id` bigint(20) unsigned DEFAULT NULL,
  `customer_gateway_id` bigint(20) unsigned DEFAULT NULL,
  `state` varchar(32) NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_s2s_vpn_connection__uuid` (`uuid`),
  KEY `fk_s2s_vpn_connection__vpn_gateway_id` (`vpn_gateway_id`),
  KEY `fk_s2s_vpn_connection__customer_gateway_id` (`customer_gateway_id`),
  KEY `fk_s2s_vpn_connection__account_id` (`account_id`),
  KEY `fk_s2s_vpn_connection__domain_id` (`domain_id`),
  CONSTRAINT `fk_s2s_vpn_connection__vpn_gateway_id` FOREIGN KEY (`vpn_gateway_id`) REFERENCES `s2s_vpn_gateway` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_s2s_vpn_connection__customer_gateway_id` FOREIGN KEY (`customer_gateway_id`) REFERENCES `s2s_customer_gateway` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_s2s_vpn_connection__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_s2s_vpn_connection__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s2s_vpn_connection`
--

LOCK TABLES `s2s_vpn_connection` WRITE;
/*!40000 ALTER TABLE `s2s_vpn_connection` DISABLE KEYS */;
/*!40000 ALTER TABLE `s2s_vpn_connection` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s2s_vpn_gateway`
--

DROP TABLE IF EXISTS `s2s_vpn_gateway`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s2s_vpn_gateway` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `addr_id` bigint(20) unsigned NOT NULL,
  `vpc_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_s2s_vpn_gateway__uuid` (`uuid`),
  KEY `fk_s2s_vpn_gateway__addr_id` (`addr_id`),
  KEY `fk_s2s_vpn_gateway__vpc_id` (`vpc_id`),
  KEY `fk_s2s_vpn_gateway__account_id` (`account_id`),
  KEY `fk_s2s_vpn_gateway__domain_id` (`domain_id`),
  CONSTRAINT `fk_s2s_vpn_gateway__addr_id` FOREIGN KEY (`addr_id`) REFERENCES `user_ip_address` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_s2s_vpn_gateway__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_s2s_vpn_gateway__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_s2s_vpn_gateway__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s2s_vpn_gateway`
--

LOCK TABLES `s2s_vpn_gateway` WRITE;
/*!40000 ALTER TABLE `s2s_vpn_gateway` DISABLE KEYS */;
/*!40000 ALTER TABLE `s2s_vpn_gateway` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `s3`
--

DROP TABLE IF EXISTS `s3`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `s3` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `access_key` varchar(20) NOT NULL COMMENT ' The S3 access key',
  `secret_key` varchar(40) NOT NULL COMMENT ' The S3 secret key',
  `end_point` varchar(1024) DEFAULT NULL COMMENT ' The S3 host',
  `bucket` varchar(63) NOT NULL COMMENT ' The S3 host',
  `https` tinyint(3) unsigned DEFAULT NULL COMMENT ' Flag indicating whether or not to connect over HTTPS',
  `connection_timeout` int(11) DEFAULT NULL COMMENT ' The amount of time to wait (in milliseconds) when initially establishing a connection before giving up and timing out.',
  `max_error_retry` int(11) DEFAULT NULL COMMENT ' The maximum number of retry attempts for failed retryable requests (ex: 5xx error responses from services).',
  `socket_timeout` int(11) DEFAULT NULL COMMENT ' The amount of time to wait (in milliseconds) for data to be transfered over an established, open connection before the connection times out and is closed.',
  `created` datetime DEFAULT NULL COMMENT 'date the s3 first signed on',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_s3__uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `s3`
--

LOCK TABLES `s3` WRITE;
/*!40000 ALTER TABLE `s3` DISABLE KEYS */;
/*!40000 ALTER TABLE `s3` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `secondary_storage_vm`
--

DROP TABLE IF EXISTS `secondary_storage_vm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `secondary_storage_vm` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `public_mac_address` varchar(17) DEFAULT NULL COMMENT 'mac address of the public facing network card',
  `public_ip_address` char(40) DEFAULT NULL COMMENT 'public ip address for the sec storage vm',
  `public_netmask` varchar(15) DEFAULT NULL COMMENT 'public netmask used for the sec storage vm',
  `guid` varchar(255) DEFAULT NULL COMMENT 'copied from guid of secondary storage host',
  `nfs_share` varchar(255) DEFAULT NULL COMMENT 'server and path exported by the nfs server ',
  `last_update` datetime DEFAULT NULL COMMENT 'Last session update time',
  `role` varchar(64) NOT NULL DEFAULT 'templateProcessor' COMMENT 'work role of secondary storage host(templateProcessor | commandExecutor)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `public_mac_address` (`public_mac_address`),
  CONSTRAINT `fk_secondary_storage_vm__id` FOREIGN KEY (`id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `secondary_storage_vm`
--

LOCK TABLES `secondary_storage_vm` WRITE;
/*!40000 ALTER TABLE `secondary_storage_vm` DISABLE KEYS */;
INSERT INTO `secondary_storage_vm` VALUES (1,NULL,NULL,NULL,NULL,NULL,NULL,'templateProcessor');
/*!40000 ALTER TABLE `secondary_storage_vm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_group`
--

DROP TABLE IF EXISTS `security_group`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_group` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `description` varchar(4096) DEFAULT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`,`account_id`),
  UNIQUE KEY `uc_security_group__uuid` (`uuid`),
  KEY `fk_security_group__account_id` (`account_id`),
  KEY `fk_security_group__domain_id` (`domain_id`),
  KEY `i_security_group_name` (`name`),
  CONSTRAINT `fk_security_group__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_security_group__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_group`
--

LOCK TABLES `security_group` WRITE;
/*!40000 ALTER TABLE `security_group` DISABLE KEYS */;
INSERT INTO `security_group` VALUES (1,'default','175f5d6d-3e08-11e3-a27a-14109fdfd297','Default Security Group',1,2);
/*!40000 ALTER TABLE `security_group` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `security_group_rule`
--

DROP TABLE IF EXISTS `security_group_rule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_group_rule` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `security_group_id` bigint(20) unsigned NOT NULL,
  `type` varchar(10) DEFAULT 'ingress',
  `start_port` varchar(10) DEFAULT NULL,
  `end_port` varchar(10) DEFAULT NULL,
  `protocol` varchar(16) NOT NULL DEFAULT 'TCP',
  `allowed_network_id` bigint(20) unsigned DEFAULT NULL,
  `allowed_ip_cidr` varchar(44) DEFAULT NULL,
  `create_status` varchar(32) DEFAULT NULL COMMENT 'rule creation status',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_security_group_rule__uuid` (`uuid`),
  KEY `i_security_group_rule_network_id` (`security_group_id`),
  KEY `i_security_group_rule_allowed_network` (`allowed_network_id`),
  CONSTRAINT `fk_security_group_rule___security_group_id` FOREIGN KEY (`security_group_id`) REFERENCES `security_group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_security_group_rule___allowed_network_id` FOREIGN KEY (`allowed_network_id`) REFERENCES `security_group` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_group_rule`
--

LOCK TABLES `security_group_rule` WRITE;
/*!40000 ALTER TABLE `security_group_rule` DISABLE KEYS */;
/*!40000 ALTER TABLE `security_group_rule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `security_group_view`
--

DROP TABLE IF EXISTS `security_group_view`;
/*!50001 DROP VIEW IF EXISTS `security_group_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `security_group_view` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `description` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL,
  `rule_id` tinyint NOT NULL,
  `rule_uuid` tinyint NOT NULL,
  `rule_type` tinyint NOT NULL,
  `rule_start_port` tinyint NOT NULL,
  `rule_end_port` tinyint NOT NULL,
  `rule_protocol` tinyint NOT NULL,
  `rule_allowed_network_id` tinyint NOT NULL,
  `rule_allowed_ip_cidr` tinyint NOT NULL,
  `rule_create_status` tinyint NOT NULL,
  `tag_id` tinyint NOT NULL,
  `tag_uuid` tinyint NOT NULL,
  `tag_key` tinyint NOT NULL,
  `tag_value` tinyint NOT NULL,
  `tag_domain_id` tinyint NOT NULL,
  `tag_account_id` tinyint NOT NULL,
  `tag_resource_id` tinyint NOT NULL,
  `tag_resource_uuid` tinyint NOT NULL,
  `tag_resource_type` tinyint NOT NULL,
  `tag_customer` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `security_group_vm_map`
--

DROP TABLE IF EXISTS `security_group_vm_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `security_group_vm_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `security_group_id` bigint(20) unsigned NOT NULL,
  `instance_id` bigint(20) unsigned NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_security_group_vm_map___security_group_id` (`security_group_id`),
  KEY `fk_security_group_vm_map___instance_id` (`instance_id`),
  CONSTRAINT `fk_security_group_vm_map___security_group_id` FOREIGN KEY (`security_group_id`) REFERENCES `security_group` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_security_group_vm_map___instance_id` FOREIGN KEY (`instance_id`) REFERENCES `user_vm` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `security_group_vm_map`
--

LOCK TABLES `security_group_vm_map` WRITE;
/*!40000 ALTER TABLE `security_group_vm_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `security_group_vm_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sequence`
--

DROP TABLE IF EXISTS `sequence`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sequence` (
  `name` varchar(64) NOT NULL COMMENT 'name of the sequence',
  `value` bigint(20) unsigned NOT NULL COMMENT 'sequence value',
  PRIMARY KEY (`name`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sequence`
--

LOCK TABLES `sequence` WRITE;
/*!40000 ALTER TABLE `sequence` DISABLE KEYS */;
INSERT INTO `sequence` VALUES ('checkpoint_seq',1),('networks_seq',204),('physical_networks_seq',201),('private_mac_address_seq',1),('public_mac_address_seq',1),('storage_pool_seq',200),('vm_instance_seq',3),('vm_template_seq',202),('volume_seq',1);
/*!40000 ALTER TABLE `sequence` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_offering`
--

DROP TABLE IF EXISTS `service_offering`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_offering` (
  `id` bigint(20) unsigned NOT NULL,
  `cpu` int(10) unsigned NOT NULL COMMENT '# of cores',
  `speed` int(10) unsigned NOT NULL COMMENT 'speed per core in mhz',
  `ram_size` bigint(20) unsigned NOT NULL,
  `nw_rate` smallint(5) unsigned DEFAULT '200' COMMENT 'network rate throttle mbits/s',
  `mc_rate` smallint(5) unsigned DEFAULT '10' COMMENT 'mcast rate throttle mbits/s',
  `ha_enabled` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Enable HA',
  `limit_cpu_use` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Limit the CPU usage to service offering',
  `host_tag` varchar(255) DEFAULT NULL COMMENT 'host tag specified by the service_offering',
  `default_use` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'is this offering a default system offering',
  `vm_type` varchar(32) DEFAULT NULL COMMENT 'type of offering specified for system offerings',
  `sort_key` int(32) NOT NULL DEFAULT '0' COMMENT 'sort key used for customising sort method',
  `is_volatile` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if the vm needs to be volatile, i.e., on every reboot of vm from API root disk is discarded and creates a new root disk',
  `deployment_planner` varchar(255) DEFAULT NULL COMMENT 'Planner heuristics used to deploy a VM of this offering; if null global config vm.deployment.planner is used',
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_service_offering__id` FOREIGN KEY (`id`) REFERENCES `disk_offering` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_offering`
--

LOCK TABLES `service_offering` WRITE;
/*!40000 ALTER TABLE `service_offering` DISABLE KEYS */;
INSERT INTO `service_offering` VALUES (17,1,100,100,200,10,0,0,NULL,0,NULL,0,0,NULL),(19,1,500,512,NULL,NULL,0,0,NULL,0,NULL,0,0,NULL),(20,1,1000,1024,NULL,NULL,0,0,NULL,0,NULL,0,0,NULL),(25,1,100,100,NULL,NULL,1,0,NULL,1,'domainrouter',0,0,NULL),(26,1,128,128,0,0,1,0,NULL,1,'elasticloadbalancervm',0,0,NULL),(27,1,100,100,NULL,NULL,0,0,NULL,1,'secondarystoragevm',0,0,NULL),(28,1,256,128,NULL,NULL,1,0,NULL,1,'internalloadbalancervm',0,0,NULL),(29,1,100,100,0,0,0,0,NULL,1,'consoleproxy',0,0,NULL);
/*!40000 ALTER TABLE `service_offering` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `service_offering_details`
--

DROP TABLE IF EXISTS `service_offering_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `service_offering_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `service_offering_id` bigint(20) unsigned NOT NULL COMMENT 'service offering id',
  `name` varchar(255) NOT NULL,
  `value` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_service_offering_id_name` (`service_offering_id`,`name`),
  CONSTRAINT `fk_service_offering_details__service_offering_id` FOREIGN KEY (`service_offering_id`) REFERENCES `service_offering` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `service_offering_details`
--

LOCK TABLES `service_offering_details` WRITE;
/*!40000 ALTER TABLE `service_offering_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `service_offering_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `service_offering_view`
--

DROP TABLE IF EXISTS `service_offering_view`;
/*!50001 DROP VIEW IF EXISTS `service_offering_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `service_offering_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `display_text` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `tags` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `use_local_storage` tinyint NOT NULL,
  `system_use` tinyint NOT NULL,
  `bytes_read_rate` tinyint NOT NULL,
  `bytes_write_rate` tinyint NOT NULL,
  `iops_read_rate` tinyint NOT NULL,
  `iops_write_rate` tinyint NOT NULL,
  `cpu` tinyint NOT NULL,
  `speed` tinyint NOT NULL,
  `ram_size` tinyint NOT NULL,
  `nw_rate` tinyint NOT NULL,
  `mc_rate` tinyint NOT NULL,
  `ha_enabled` tinyint NOT NULL,
  `limit_cpu_use` tinyint NOT NULL,
  `host_tag` tinyint NOT NULL,
  `default_use` tinyint NOT NULL,
  `vm_type` tinyint NOT NULL,
  `sort_key` tinyint NOT NULL,
  `is_volatile` tinyint NOT NULL,
  `deployment_planner` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `snapshot_policy`
--

DROP TABLE IF EXISTS `snapshot_policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `snapshot_policy` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `volume_id` bigint(20) unsigned NOT NULL,
  `schedule` varchar(100) NOT NULL COMMENT 'schedule time of execution',
  `timezone` varchar(100) NOT NULL COMMENT 'the timezone in which the schedule time is specified',
  `interval` int(4) NOT NULL DEFAULT '4' COMMENT 'backup schedule, e.g. hourly, daily, etc.',
  `max_snaps` int(8) NOT NULL DEFAULT '0' COMMENT 'maximum number of snapshots to maintain',
  `active` tinyint(1) unsigned NOT NULL COMMENT 'Is the policy active',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_snapshot_policy__uuid` (`uuid`),
  KEY `i_snapshot_policy__volume_id` (`volume_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snapshot_policy`
--

LOCK TABLES `snapshot_policy` WRITE;
/*!40000 ALTER TABLE `snapshot_policy` DISABLE KEYS */;
/*!40000 ALTER TABLE `snapshot_policy` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snapshot_schedule`
--

DROP TABLE IF EXISTS `snapshot_schedule`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `snapshot_schedule` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `volume_id` bigint(20) unsigned NOT NULL COMMENT 'The volume for which this snapshot is being taken',
  `policy_id` bigint(20) unsigned NOT NULL COMMENT 'One of the policyIds for which this snapshot was taken',
  `scheduled_timestamp` datetime NOT NULL COMMENT 'Time at which the snapshot was scheduled for execution',
  `async_job_id` bigint(20) unsigned DEFAULT NULL COMMENT 'If this schedule is being executed, it is the id of the create aysnc_job. Before that it is null',
  `snapshot_id` bigint(20) unsigned DEFAULT NULL COMMENT 'If this schedule is being executed, then the corresponding snapshot has this id. Before that it is null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `volume_id` (`volume_id`,`policy_id`),
  UNIQUE KEY `uc_snapshot_schedule__uuid` (`uuid`),
  KEY `i_snapshot_schedule__volume_id` (`volume_id`),
  KEY `i_snapshot_schedule__policy_id` (`policy_id`),
  KEY `i_snapshot_schedule__async_job_id` (`async_job_id`),
  KEY `i_snapshot_schedule__snapshot_id` (`snapshot_id`),
  KEY `i_snapshot_schedule__scheduled_timestamp` (`scheduled_timestamp`),
  CONSTRAINT `fk__snapshot_schedule_volume_id` FOREIGN KEY (`volume_id`) REFERENCES `volumes` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk__snapshot_schedule_policy_id` FOREIGN KEY (`policy_id`) REFERENCES `snapshot_policy` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk__snapshot_schedule_async_job_id` FOREIGN KEY (`async_job_id`) REFERENCES `async_job` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk__snapshot_schedule_snapshot_id` FOREIGN KEY (`snapshot_id`) REFERENCES `snapshots` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snapshot_schedule`
--

LOCK TABLES `snapshot_schedule` WRITE;
/*!40000 ALTER TABLE `snapshot_schedule` DISABLE KEYS */;
/*!40000 ALTER TABLE `snapshot_schedule` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snapshot_store_ref`
--

DROP TABLE IF EXISTS `snapshot_store_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `snapshot_store_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `store_id` bigint(20) unsigned NOT NULL,
  `snapshot_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `store_role` varchar(255) DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL,
  `physical_size` bigint(20) unsigned DEFAULT '0',
  `parent_snapshot_id` bigint(20) unsigned DEFAULT '0',
  `install_path` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  `update_count` bigint(20) unsigned DEFAULT NULL,
  `ref_cnt` bigint(20) unsigned DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `volume_id` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_snapshot_store_ref__store_id` (`store_id`),
  KEY `i_snapshot_store_ref__snapshot_id` (`snapshot_id`),
  CONSTRAINT `fk_snapshot_store_ref__snapshot_id` FOREIGN KEY (`snapshot_id`) REFERENCES `snapshots` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snapshot_store_ref`
--

LOCK TABLES `snapshot_store_ref` WRITE;
/*!40000 ALTER TABLE `snapshot_store_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `snapshot_store_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `snapshots`
--

DROP TABLE IF EXISTS `snapshots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `snapshots` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `data_center_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner.  foreign key to account table',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'the domain that the owner belongs to',
  `volume_id` bigint(20) unsigned NOT NULL COMMENT 'volume it belongs to. foreign key to volume table',
  `disk_offering_id` bigint(20) unsigned NOT NULL COMMENT 'from original volume',
  `status` varchar(32) DEFAULT NULL COMMENT 'snapshot creation status',
  `path` varchar(255) DEFAULT NULL COMMENT 'Path',
  `name` varchar(255) NOT NULL COMMENT 'snapshot name',
  `uuid` varchar(40) DEFAULT NULL,
  `snapshot_type` int(4) NOT NULL COMMENT 'type of snapshot, e.g. manual, recurring',
  `type_description` varchar(25) DEFAULT NULL COMMENT 'description of the type of snapshot, e.g. manual, recurring',
  `size` bigint(20) unsigned NOT NULL COMMENT 'original disk size of snapshot',
  `created` datetime DEFAULT NULL COMMENT 'Date Created',
  `removed` datetime DEFAULT NULL COMMENT 'Date removed.  not null if removed',
  `backup_snap_id` varchar(255) DEFAULT NULL COMMENT 'Back up uuid of the snapshot',
  `swift_id` bigint(20) unsigned DEFAULT NULL COMMENT 'which swift',
  `sechost_id` bigint(20) unsigned DEFAULT NULL COMMENT 'secondary storage host id',
  `prev_snap_id` bigint(20) unsigned DEFAULT NULL COMMENT 'Id of the most recent snapshot',
  `hypervisor_type` varchar(32) NOT NULL COMMENT 'hypervisor that the snapshot was taken under',
  `version` varchar(32) DEFAULT NULL COMMENT 'snapshot version',
  `s3_id` bigint(20) unsigned DEFAULT NULL COMMENT 'S3 to which this snapshot will be stored',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_snapshots__uuid` (`uuid`),
  KEY `i_snapshots__account_id` (`account_id`),
  KEY `i_snapshots__volume_id` (`volume_id`),
  KEY `i_snapshots__name` (`name`),
  KEY `i_snapshots__snapshot_type` (`snapshot_type`),
  KEY `i_snapshots__prev_snap_id` (`prev_snap_id`),
  KEY `i_snapshots__removed` (`removed`),
  KEY `fk_snapshots__s3_id` (`s3_id`),
  CONSTRAINT `fk_snapshots__s3_id` FOREIGN KEY (`s3_id`) REFERENCES `s3` (`id`),
  CONSTRAINT `fk_snapshots__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `snapshots`
--

LOCK TABLES `snapshots` WRITE;
/*!40000 ALTER TABLE `snapshots` DISABLE KEYS */;
/*!40000 ALTER TABLE `snapshots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ssh_keypairs`
--

DROP TABLE IF EXISTS `ssh_keypairs`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ssh_keypairs` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner, foreign key to account table',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain, foreign key to domain table',
  `keypair_name` varchar(256) NOT NULL COMMENT 'name of the key pair',
  `fingerprint` varchar(128) NOT NULL COMMENT 'fingerprint for the ssh public key',
  `public_key` varchar(5120) NOT NULL COMMENT 'public key of the ssh key pair',
  PRIMARY KEY (`id`),
  KEY `fk_ssh_keypairs__account_id` (`account_id`),
  KEY `fk_ssh_keypairs__domain_id` (`domain_id`),
  CONSTRAINT `fk_ssh_keypairs__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_ssh_keypairs__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ssh_keypairs`
--

LOCK TABLES `ssh_keypairs` WRITE;
/*!40000 ALTER TABLE `ssh_keypairs` DISABLE KEYS */;
/*!40000 ALTER TABLE `ssh_keypairs` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stack_maid`
--

DROP TABLE IF EXISTS `stack_maid`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `stack_maid` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `msid` bigint(20) unsigned NOT NULL,
  `thread_id` bigint(20) unsigned NOT NULL,
  `seq` int(10) unsigned NOT NULL,
  `cleanup_delegate` varchar(128) DEFAULT NULL,
  `cleanup_context` text,
  `created` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_stack_maid_msid_thread_id` (`msid`,`thread_id`),
  KEY `i_stack_maid_seq` (`msid`,`seq`),
  KEY `i_stack_maid_created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stack_maid`
--

LOCK TABLES `stack_maid` WRITE;
/*!40000 ALTER TABLE `stack_maid` DISABLE KEYS */;
/*!40000 ALTER TABLE `stack_maid` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `static_routes`
--

DROP TABLE IF EXISTS `static_routes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `static_routes` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `vpc_gateway_id` bigint(20) unsigned DEFAULT NULL COMMENT 'id of the corresponding ip address',
  `cidr` varchar(18) DEFAULT NULL COMMENT 'cidr for the static route',
  `state` char(32) NOT NULL COMMENT 'current state of this rule',
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vpc the firewall rule is associated with',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner id',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain id',
  `created` datetime DEFAULT NULL COMMENT 'Date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_static_routes__uuid` (`uuid`),
  KEY `fk_static_routes__vpc_gateway_id` (`vpc_gateway_id`),
  KEY `fk_static_routes__vpc_id` (`vpc_id`),
  KEY `fk_static_routes__account_id` (`account_id`),
  KEY `fk_static_routes__domain_id` (`domain_id`),
  CONSTRAINT `fk_static_routes__vpc_gateway_id` FOREIGN KEY (`vpc_gateway_id`) REFERENCES `vpc_gateways` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_static_routes__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_static_routes__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_static_routes__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `static_routes`
--

LOCK TABLES `static_routes` WRITE;
/*!40000 ALTER TABLE `static_routes` DISABLE KEYS */;
/*!40000 ALTER TABLE `static_routes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_pool`
--

DROP TABLE IF EXISTS `storage_pool`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_pool` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL COMMENT 'should be NOT NULL',
  `uuid` varchar(255) DEFAULT NULL,
  `pool_type` varchar(32) NOT NULL,
  `port` int(10) unsigned NOT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `pod_id` bigint(20) unsigned DEFAULT NULL,
  `cluster_id` bigint(20) unsigned DEFAULT NULL COMMENT 'foreign key to cluster',
  `used_bytes` bigint(20) unsigned DEFAULT NULL,
  `capacity_bytes` bigint(20) unsigned DEFAULT NULL,
  `host_address` varchar(255) NOT NULL COMMENT 'FQDN or IP of storage server',
  `user_info` varchar(255) DEFAULT NULL COMMENT 'Authorization information for the storage pool. Used by network filesystems',
  `path` varchar(255) NOT NULL COMMENT 'Filesystem path that is shared',
  `created` datetime DEFAULT NULL COMMENT 'date the pool created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `update_time` datetime DEFAULT NULL,
  `status` varchar(32) DEFAULT NULL,
  `storage_provider_name` varchar(255) DEFAULT NULL,
  `scope` varchar(255) DEFAULT NULL,
  `hypervisor` varchar(32) DEFAULT NULL,
  `managed` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Should CloudStack manage this storage',
  `capacity_iops` bigint(20) unsigned DEFAULT NULL COMMENT 'IOPS CloudStack can provision from this storage pool',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `id_2` (`id`),
  UNIQUE KEY `uuid` (`uuid`),
  KEY `i_storage_pool__pod_id` (`pod_id`),
  KEY `fk_storage_pool__cluster_id` (`cluster_id`),
  KEY `i_storage_pool__removed` (`removed`),
  CONSTRAINT `fk_storage_pool__cluster_id` FOREIGN KEY (`cluster_id`) REFERENCES `cluster` (`id`),
  CONSTRAINT `fk_storage_pool__pod_id` FOREIGN KEY (`pod_id`) REFERENCES `host_pod_ref` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_pool`
--

LOCK TABLES `storage_pool` WRITE;
/*!40000 ALTER TABLE `storage_pool` DISABLE KEYS */;
INSERT INTO `storage_pool` VALUES (1,'xenserver1 Local Storage','be408a6e-8f4d-992f-0ca0-f68fd29927c8','EXT',0,1,1,1,184614912,33808039936,'192.168.3.117',NULL,'ext','2013-10-26 06:36:14',NULL,NULL,'Up','DefaultPrimary','HOST',NULL,0,NULL);
/*!40000 ALTER TABLE `storage_pool` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_pool_details`
--

DROP TABLE IF EXISTS `storage_pool_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_pool_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pool_id` bigint(20) unsigned NOT NULL COMMENT 'pool the detail is related to',
  `name` varchar(255) NOT NULL COMMENT 'name of the detail',
  `value` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_storage_pool_details__pool_id` (`pool_id`),
  KEY `i_storage_pool_details__name__value` (`name`(128),`value`(128)),
  CONSTRAINT `fk_storage_pool_details__pool_id` FOREIGN KEY (`pool_id`) REFERENCES `storage_pool` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_pool_details`
--

LOCK TABLES `storage_pool_details` WRITE;
/*!40000 ALTER TABLE `storage_pool_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage_pool_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `storage_pool_host_ref`
--

DROP TABLE IF EXISTS `storage_pool_host_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_pool_host_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` bigint(20) unsigned NOT NULL,
  `pool_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_storage_pool_host_ref__host_id` (`host_id`),
  KEY `fk_storage_pool_host_ref__pool_id` (`pool_id`),
  CONSTRAINT `fk_storage_pool_host_ref__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_storage_pool_host_ref__pool_id` FOREIGN KEY (`pool_id`) REFERENCES `storage_pool` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_pool_host_ref`
--

LOCK TABLES `storage_pool_host_ref` WRITE;
/*!40000 ALTER TABLE `storage_pool_host_ref` DISABLE KEYS */;
INSERT INTO `storage_pool_host_ref` VALUES (1,1,1,'2013-10-26 06:36:14',NULL,'ext');
/*!40000 ALTER TABLE `storage_pool_host_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `storage_pool_view`
--

DROP TABLE IF EXISTS `storage_pool_view`;
/*!50001 DROP VIEW IF EXISTS `storage_pool_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `storage_pool_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `status` tinyint NOT NULL,
  `path` tinyint NOT NULL,
  `pool_type` tinyint NOT NULL,
  `host_address` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `capacity_bytes` tinyint NOT NULL,
  `capacity_iops` tinyint NOT NULL,
  `scope` tinyint NOT NULL,
  `hypervisor` tinyint NOT NULL,
  `storage_provider_name` tinyint NOT NULL,
  `cluster_id` tinyint NOT NULL,
  `cluster_uuid` tinyint NOT NULL,
  `cluster_name` tinyint NOT NULL,
  `cluster_type` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `data_center_type` tinyint NOT NULL,
  `pod_id` tinyint NOT NULL,
  `pod_uuid` tinyint NOT NULL,
  `pod_name` tinyint NOT NULL,
  `tag` tinyint NOT NULL,
  `disk_used_capacity` tinyint NOT NULL,
  `disk_reserved_capacity` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `storage_pool_work`
--

DROP TABLE IF EXISTS `storage_pool_work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `storage_pool_work` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `pool_id` bigint(20) unsigned NOT NULL COMMENT 'storage pool associated with the vm',
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'vm identifier',
  `stopped_for_maintenance` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT 'this flag denoted whether the vm was stopped during maintenance',
  `started_after_maintenance` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT 'this flag denoted whether the vm was started after maintenance',
  `mgmt_server_id` bigint(20) unsigned NOT NULL COMMENT 'management server id',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `pool_id` (`pool_id`,`vm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `storage_pool_work`
--

LOCK TABLES `storage_pool_work` WRITE;
/*!40000 ALTER TABLE `storage_pool_work` DISABLE KEYS */;
/*!40000 ALTER TABLE `storage_pool_work` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `swift`
--

DROP TABLE IF EXISTS `swift`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `swift` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `account` varchar(255) NOT NULL COMMENT ' account in swift',
  `username` varchar(255) NOT NULL COMMENT ' username in swift',
  `key` varchar(255) NOT NULL COMMENT 'token for this user',
  `created` datetime DEFAULT NULL COMMENT 'date the swift first signed on',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_swift__uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `swift`
--

LOCK TABLES `swift` WRITE;
/*!40000 ALTER TABLE `swift` DISABLE KEYS */;
/*!40000 ALTER TABLE `swift` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sync_queue`
--

DROP TABLE IF EXISTS `sync_queue`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sync_queue` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `sync_objtype` varchar(64) NOT NULL,
  `sync_objid` bigint(20) unsigned NOT NULL,
  `queue_proc_number` bigint(20) DEFAULT NULL COMMENT 'process number, increase 1 for each iteration',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `last_updated` datetime DEFAULT NULL COMMENT 'date created',
  `queue_size` smallint(6) NOT NULL DEFAULT '0' COMMENT 'number of items being processed by the queue',
  `queue_size_limit` smallint(6) NOT NULL DEFAULT '1' COMMENT 'max number of items the queue can process concurrently',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_sync_queue__objtype__objid` (`sync_objtype`,`sync_objid`),
  KEY `i_sync_queue__created` (`created`),
  KEY `i_sync_queue__last_updated` (`last_updated`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sync_queue`
--

LOCK TABLES `sync_queue` WRITE;
/*!40000 ALTER TABLE `sync_queue` DISABLE KEYS */;
/*!40000 ALTER TABLE `sync_queue` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sync_queue_item`
--

DROP TABLE IF EXISTS `sync_queue_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sync_queue_item` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `queue_id` bigint(20) unsigned NOT NULL,
  `content_type` varchar(64) DEFAULT NULL,
  `content_id` bigint(20) DEFAULT NULL,
  `queue_proc_msid` bigint(20) DEFAULT NULL COMMENT 'owner msid when the queue item is being processed',
  `queue_proc_number` bigint(20) DEFAULT NULL COMMENT 'used to distinguish raw items and items being in process',
  `queue_proc_time` datetime DEFAULT NULL COMMENT 'when processing started for the item',
  `created` datetime DEFAULT NULL COMMENT 'time created',
  PRIMARY KEY (`id`),
  KEY `i_sync_queue_item__queue_id` (`queue_id`),
  KEY `i_sync_queue_item__created` (`created`),
  KEY `i_sync_queue_item__queue_proc_number` (`queue_proc_number`),
  KEY `i_sync_queue_item__queue_proc_msid` (`queue_proc_msid`),
  KEY `i_sync_queue__queue_proc_time` (`queue_proc_time`),
  CONSTRAINT `fk_sync_queue_item__queue_id` FOREIGN KEY (`queue_id`) REFERENCES `sync_queue` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sync_queue_item`
--

LOCK TABLES `sync_queue_item` WRITE;
/*!40000 ALTER TABLE `sync_queue_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `sync_queue_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template_host_ref`
--

DROP TABLE IF EXISTS `template_host_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template_host_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` bigint(20) unsigned NOT NULL,
  `template_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `download_pct` int(10) unsigned DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL,
  `physical_size` bigint(20) unsigned DEFAULT '0',
  `download_state` varchar(255) DEFAULT NULL,
  `error_str` varchar(255) DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  `install_path` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `destroyed` tinyint(1) DEFAULT NULL COMMENT 'indicates whether the template_host entry was destroyed by the user or not',
  `is_copy` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'indicates whether this was copied ',
  PRIMARY KEY (`id`),
  KEY `i_template_host_ref__host_id` (`host_id`),
  KEY `i_template_host_ref__template_id` (`template_id`),
  CONSTRAINT `fk_template_host_ref__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_template_host_ref__template_id` FOREIGN KEY (`template_id`) REFERENCES `vm_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template_host_ref`
--

LOCK TABLES `template_host_ref` WRITE;
/*!40000 ALTER TABLE `template_host_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `template_host_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template_s3_ref`
--

DROP TABLE IF EXISTS `template_s3_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template_s3_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `s3_id` bigint(20) unsigned NOT NULL COMMENT ' Associated S3 instance id',
  `template_id` bigint(20) unsigned NOT NULL COMMENT ' Associated template id',
  `created` datetime NOT NULL COMMENT ' The creation timestamp',
  `size` bigint(20) unsigned DEFAULT NULL COMMENT ' The size of the object',
  `physical_size` bigint(20) unsigned DEFAULT '0' COMMENT ' The physical size of the object',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_template_s3_ref__template_id` (`template_id`),
  KEY `i_template_s3_ref__s3_id` (`s3_id`),
  KEY `i_template_s3_ref__template_id` (`template_id`),
  CONSTRAINT `fk_template_s3_ref__s3_id` FOREIGN KEY (`s3_id`) REFERENCES `s3` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_template_s3_ref__template_id` FOREIGN KEY (`template_id`) REFERENCES `vm_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template_s3_ref`
--

LOCK TABLES `template_s3_ref` WRITE;
/*!40000 ALTER TABLE `template_s3_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `template_s3_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template_spool_ref`
--

DROP TABLE IF EXISTS `template_spool_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template_spool_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `pool_id` bigint(20) unsigned NOT NULL,
  `template_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `download_pct` int(10) unsigned DEFAULT NULL,
  `download_state` varchar(255) DEFAULT NULL,
  `error_str` varchar(255) DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  `install_path` varchar(255) DEFAULT NULL,
  `template_size` bigint(20) unsigned NOT NULL COMMENT 'the size of the template on the pool',
  `marked_for_gc` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'if true, the garbage collector will evict the template from this pool.',
  `state` varchar(255) DEFAULT NULL,
  `update_count` bigint(20) unsigned DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_template_spool_ref__template_id__pool_id` (`template_id`,`pool_id`),
  KEY `fk_template_spool_ref__pool_id` (`pool_id`),
  CONSTRAINT `fk_template_spool_ref__pool_id` FOREIGN KEY (`pool_id`) REFERENCES `storage_pool` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_template_spool_ref__template_id` FOREIGN KEY (`template_id`) REFERENCES `vm_template` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template_spool_ref`
--

LOCK TABLES `template_spool_ref` WRITE;
/*!40000 ALTER TABLE `template_spool_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `template_spool_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template_store_ref`
--

DROP TABLE IF EXISTS `template_store_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template_store_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `store_id` bigint(20) unsigned DEFAULT NULL,
  `template_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `download_pct` int(10) unsigned DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL,
  `store_role` varchar(255) DEFAULT NULL,
  `physical_size` bigint(20) unsigned DEFAULT '0',
  `download_state` varchar(255) DEFAULT NULL,
  `error_str` varchar(255) DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  `install_path` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  `destroyed` tinyint(1) DEFAULT NULL COMMENT 'indicates whether the template_store entry was destroyed by the user or not',
  `is_copy` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'indicates whether this was copied ',
  `update_count` bigint(20) unsigned DEFAULT NULL,
  `ref_cnt` bigint(20) unsigned DEFAULT '0',
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_template_store_ref__store_id` (`store_id`),
  KEY `i_template_store_ref__template_id` (`template_id`),
  CONSTRAINT `fk_template_store_ref__template_id` FOREIGN KEY (`template_id`) REFERENCES `vm_template` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template_store_ref`
--

LOCK TABLES `template_store_ref` WRITE;
/*!40000 ALTER TABLE `template_store_ref` DISABLE KEYS */;
INSERT INTO `template_store_ref` VALUES (1,1,10,'2013-10-26 06:37:15','2013-10-26 06:37:15',NULL,100,0,'Image',0,'DOWNLOADED',NULL,NULL,'template/tmpl/1/10/','http://download.cloud.com/templates/acton/acton-systemvm-02062012.qcow2.bz2','Ready',0,0,0,0,NULL),(2,1,9,'2013-10-26 06:37:15','2013-10-26 06:37:15',NULL,100,0,'Image',0,'DOWNLOADED',NULL,NULL,'template/tmpl/1/9/','http://download.cloud.com/templates/4.2/systemvmtemplate-2013-06-12-master-xen.vhd.bz2','Ready',0,0,0,0,NULL),(3,1,8,'2013-10-26 06:37:15','2013-10-26 06:37:15',NULL,100,0,'Image',0,'DOWNLOADED',NULL,NULL,'template/tmpl/1/8/','http://download.cloud.com/templates/4.2/systemvmtemplate-4.2-vh7.ova','Ready',0,0,0,0,NULL),(4,1,3,'2013-10-26 06:37:15','2013-10-26 06:37:15',NULL,100,0,'Image',0,'DOWNLOADED',NULL,NULL,'template/tmpl/1/3/','http://download.cloud.com/templates/4.2/systemvmtemplate-2013-06-12-master-kvm.qcow2.bz2','Ready',0,0,0,0,NULL),(5,1,1,'2013-10-26 06:37:15','2013-10-26 06:37:15',NULL,100,0,'Image',0,'DOWNLOADED',NULL,NULL,'template/tmpl/1/1/','http://download.cloud.com/templates/4.2/systemvmtemplate-2013-07-12-master-xen.vhd.bz2','Ready',0,0,0,0,NULL);
/*!40000 ALTER TABLE `template_store_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `template_swift_ref`
--

DROP TABLE IF EXISTS `template_swift_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template_swift_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `swift_id` bigint(20) unsigned NOT NULL,
  `template_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `path` varchar(255) DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL,
  `physical_size` bigint(20) unsigned DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `i_template_swift_ref__swift_id` (`swift_id`),
  KEY `i_template_swift_ref__template_id` (`template_id`),
  CONSTRAINT `fk_template_swift_ref__swift_id` FOREIGN KEY (`swift_id`) REFERENCES `swift` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_template_swift_ref__template_id` FOREIGN KEY (`template_id`) REFERENCES `vm_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template_swift_ref`
--

LOCK TABLES `template_swift_ref` WRITE;
/*!40000 ALTER TABLE `template_swift_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `template_swift_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `template_view`
--

DROP TABLE IF EXISTS `template_view`;
/*!50001 DROP VIEW IF EXISTS `template_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `template_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `unique_name` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `public` tinyint NOT NULL,
  `featured` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  `hvm` tinyint NOT NULL,
  `bits` tinyint NOT NULL,
  `url` tinyint NOT NULL,
  `format` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `checksum` tinyint NOT NULL,
  `display_text` tinyint NOT NULL,
  `enable_password` tinyint NOT NULL,
  `dynamically_scalable` tinyint NOT NULL,
  `guest_os_id` tinyint NOT NULL,
  `guest_os_uuid` tinyint NOT NULL,
  `guest_os_name` tinyint NOT NULL,
  `bootable` tinyint NOT NULL,
  `prepopulate` tinyint NOT NULL,
  `cross_zones` tinyint NOT NULL,
  `hypervisor_type` tinyint NOT NULL,
  `extractable` tinyint NOT NULL,
  `template_tag` tinyint NOT NULL,
  `sort_key` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `enable_sshkey` tinyint NOT NULL,
  `source_template_id` tinyint NOT NULL,
  `source_template_uuid` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `lp_account_id` tinyint NOT NULL,
  `store_id` tinyint NOT NULL,
  `store_scope` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `download_state` tinyint NOT NULL,
  `download_pct` tinyint NOT NULL,
  `error_str` tinyint NOT NULL,
  `size` tinyint NOT NULL,
  `destroyed` tinyint NOT NULL,
  `created_on_store` tinyint NOT NULL,
  `detail_name` tinyint NOT NULL,
  `detail_value` tinyint NOT NULL,
  `tag_id` tinyint NOT NULL,
  `tag_uuid` tinyint NOT NULL,
  `tag_key` tinyint NOT NULL,
  `tag_value` tinyint NOT NULL,
  `tag_domain_id` tinyint NOT NULL,
  `tag_account_id` tinyint NOT NULL,
  `tag_resource_id` tinyint NOT NULL,
  `tag_resource_uuid` tinyint NOT NULL,
  `tag_resource_type` tinyint NOT NULL,
  `tag_customer` tinyint NOT NULL,
  `temp_zone_pair` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `template_zone_ref`
--

DROP TABLE IF EXISTS `template_zone_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `template_zone_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `zone_id` bigint(20) unsigned NOT NULL,
  `template_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  KEY `i_template_zone_ref__zone_id` (`zone_id`),
  KEY `i_template_zone_ref__template_id` (`template_id`),
  KEY `i_template_zone_ref__removed` (`removed`),
  CONSTRAINT `fk_template_zone_ref__zone_id` FOREIGN KEY (`zone_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_template_zone_ref__template_id` FOREIGN KEY (`template_id`) REFERENCES `vm_template` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `template_zone_ref`
--

LOCK TABLES `template_zone_ref` WRITE;
/*!40000 ALTER TABLE `template_zone_ref` DISABLE KEYS */;
INSERT INTO `template_zone_ref` VALUES (1,1,1,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(2,1,2,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(3,1,3,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(4,1,4,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(5,1,5,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(6,1,7,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(7,1,8,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(8,1,9,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL),(9,1,10,'2013-10-26 06:36:14','2013-10-26 06:36:14',NULL);
/*!40000 ALTER TABLE `template_zone_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ucs_blade`
--

DROP TABLE IF EXISTS `ucs_blade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ucs_blade` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `ucs_manager_id` bigint(20) unsigned NOT NULL,
  `host_id` bigint(20) unsigned DEFAULT NULL,
  `dn` varchar(512) NOT NULL,
  `profile_dn` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ucs_blade`
--

LOCK TABLES `ucs_blade` WRITE;
/*!40000 ALTER TABLE `ucs_blade` DISABLE KEYS */;
/*!40000 ALTER TABLE `ucs_blade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ucs_manager`
--

DROP TABLE IF EXISTS `ucs_manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ucs_manager` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `zone_id` bigint(20) unsigned NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `url` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ucs_manager`
--

LOCK TABLES `ucs_manager` WRITE;
/*!40000 ALTER TABLE `ucs_manager` DISABLE KEYS */;
/*!40000 ALTER TABLE `ucs_manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `upload`
--

DROP TABLE IF EXISTS `upload`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `upload` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` bigint(20) unsigned NOT NULL,
  `type_id` bigint(20) unsigned NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `mode` varchar(255) DEFAULT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `upload_pct` int(10) unsigned DEFAULT NULL,
  `upload_state` varchar(255) DEFAULT NULL,
  `error_str` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `install_path` varchar(255) DEFAULT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_upload__host_id` (`host_id`),
  KEY `i_upload__type_id` (`type_id`),
  CONSTRAINT `fk_upload__store_id` FOREIGN KEY (`host_id`) REFERENCES `image_store` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `upload`
--

LOCK TABLES `upload` WRITE;
/*!40000 ALTER TABLE `upload` DISABLE KEYS */;
/*!40000 ALTER TABLE `upload` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usage_event`
--

DROP TABLE IF EXISTS `usage_event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usage_event` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `type` varchar(32) NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `zone_id` bigint(20) unsigned NOT NULL,
  `resource_id` bigint(20) unsigned DEFAULT NULL,
  `resource_name` varchar(255) DEFAULT NULL,
  `offering_id` bigint(20) unsigned DEFAULT NULL,
  `template_id` bigint(20) unsigned DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL,
  `resource_type` varchar(32) DEFAULT NULL,
  `processed` tinyint(4) NOT NULL DEFAULT '0',
  `virtual_size` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_usage_event__created` (`created`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usage_event`
--

LOCK TABLES `usage_event` WRITE;
/*!40000 ALTER TABLE `usage_event` DISABLE KEYS */;
/*!40000 ALTER TABLE `usage_event` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `firstname` varchar(255) DEFAULT NULL,
  `lastname` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `state` varchar(10) NOT NULL DEFAULT 'enabled',
  `api_key` varchar(255) DEFAULT NULL,
  `secret_key` varchar(255) DEFAULT NULL,
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed',
  `timezone` varchar(30) DEFAULT NULL,
  `registration_token` varchar(255) DEFAULT NULL,
  `is_registered` tinyint(4) NOT NULL DEFAULT '0' COMMENT '1: yes, 0: no',
  `incorrect_login_attempts` int(10) unsigned NOT NULL DEFAULT '0',
  `default` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if user is default',
  PRIMARY KEY (`id`),
  UNIQUE KEY `i_user__api_key` (`api_key`),
  UNIQUE KEY `uc_user__uuid` (`uuid`),
  KEY `i_user__removed` (`removed`),
  KEY `i_user__secret_key_removed` (`secret_key`,`removed`),
  KEY `i_user__account_id` (`account_id`),
  CONSTRAINT `fk_user__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'4e6d4eae-3e05-11e3-a27a-14109fdfd297','system','0.9798112083038419',1,'system','cloud',NULL,'enabled',NULL,NULL,'2013-10-25 23:10:26',NULL,NULL,NULL,0,0,1),(2,'4e6d57c1-3e05-11e3-a27a-14109fdfd297','admin','p3kvfF2+V+mWgpRvzn5Ls7Sz2QTjXXhznW367llM1L8=:vUQT5tvHmIoSRknJxWKGhUSv0MDgTZVVQVAzgEVh3qw=',2,'Admin','User','admin@mailprovider.com','enabled','XDgVVHxFHzk6fuexVOFdfGcJLAZBuaWJK7I8z1LMJhMMXRnRX77qGN7By6pKBNsYMV_V5whEpCUfrvvwzwySoA','yf-EEumo2Jif-68mIw2KIupoAGDOIt88egC3wWOLlCP3EQXeOooOcLv4_6q51bvFNWXfbIsSiFplHfG4MyZ6Ug','2013-10-25 23:10:26',NULL,NULL,NULL,0,0,1);
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_ip_address`
--

DROP TABLE IF EXISTS `user_ip_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_ip_address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `account_id` bigint(20) unsigned DEFAULT NULL,
  `domain_id` bigint(20) unsigned DEFAULT NULL,
  `public_ip_address` char(40) NOT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'zone that it belongs to',
  `source_nat` int(1) unsigned NOT NULL DEFAULT '0',
  `allocated` datetime DEFAULT NULL COMMENT 'Date this ip was allocated to someone',
  `vlan_db_id` bigint(20) unsigned NOT NULL,
  `one_to_one_nat` int(1) unsigned NOT NULL DEFAULT '0',
  `vm_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vm id the one_to_one nat ip is assigned to',
  `state` char(32) NOT NULL DEFAULT 'Free' COMMENT 'state of the ip address',
  `mac_address` bigint(20) unsigned NOT NULL COMMENT 'mac address of this ip',
  `source_network_id` bigint(20) unsigned NOT NULL COMMENT 'network id ip belongs to',
  `network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'network this public ip address is associated with',
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'physical network id that this configuration is based on',
  `is_system` int(1) unsigned NOT NULL DEFAULT '0',
  `vpc_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vpc the ip address is associated with',
  `dnat_vmip` varchar(40) DEFAULT NULL,
  `is_portable` int(1) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `public_ip_address` (`public_ip_address`,`source_network_id`),
  UNIQUE KEY `uc_user_ip_address__uuid` (`uuid`),
  KEY `fk_user_ip_address__source_network_id` (`source_network_id`),
  KEY `fk_user_ip_address__network_id` (`network_id`),
  KEY `fk_user_ip_address__account_id` (`account_id`),
  KEY `fk_user_ip_address__vm_id` (`vm_id`),
  KEY `fk_user_ip_address__vlan_db_id` (`vlan_db_id`),
  KEY `fk_user_ip_address__data_center_id` (`data_center_id`),
  KEY `fk_user_ip_address__physical_network_id` (`physical_network_id`),
  KEY `fk_user_ip_address__vpc_id` (`vpc_id`),
  KEY `i_user_ip_address__allocated` (`allocated`),
  KEY `i_user_ip_address__source_nat` (`source_nat`),
  CONSTRAINT `fk_user_ip_address__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_user_ip_address__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_ip_address__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`),
  CONSTRAINT `fk_user_ip_address__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_ip_address__source_network_id` FOREIGN KEY (`source_network_id`) REFERENCES `networks` (`id`),
  CONSTRAINT `fk_user_ip_address__vlan_db_id` FOREIGN KEY (`vlan_db_id`) REFERENCES `vlan` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_ip_address__vm_id` FOREIGN KEY (`vm_id`) REFERENCES `vm_instance` (`id`),
  CONSTRAINT `fk_user_ip_address__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=102 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_ip_address`
--

LOCK TABLES `user_ip_address` WRITE;
/*!40000 ALTER TABLE `user_ip_address` DISABLE KEYS */;
INSERT INTO `user_ip_address` VALUES (1,'874914ea-b8bc-4642-bd72-c7d24b2673ef',1,1,'192.168.4.100',1,0,'2013-10-26 06:37:25',1,0,NULL,'Allocated',91,200,NULL,200,0,NULL,NULL,0),(2,'8f68ac40-39a4-449c-8826-575cbbb33208',1,1,'192.168.4.101',1,0,'2013-10-26 06:37:25',1,0,NULL,'Allocated',92,200,NULL,200,0,NULL,NULL,0),(3,'fa4dfd3c-af5e-43c0-accd-63b2cd250090',NULL,NULL,'192.168.4.102',1,0,NULL,1,0,NULL,'Free',93,200,NULL,200,0,NULL,NULL,0),(4,'5ec3d0f3-4683-4548-a459-cce4e102b09e',NULL,NULL,'192.168.4.103',1,0,NULL,1,0,NULL,'Free',94,200,NULL,200,0,NULL,NULL,0),(5,'fb37235e-79d9-4bf5-8d3a-43b16065f115',NULL,NULL,'192.168.4.104',1,0,NULL,1,0,NULL,'Free',95,200,NULL,200,0,NULL,NULL,0),(6,'90acdbfc-ce53-47bd-8795-65e13fe57728',NULL,NULL,'192.168.4.105',1,0,NULL,1,0,NULL,'Free',96,200,NULL,200,0,NULL,NULL,0),(7,'e5b4253a-6806-4f5c-8355-287fc3004ac4',NULL,NULL,'192.168.4.106',1,0,NULL,1,0,NULL,'Free',97,200,NULL,200,0,NULL,NULL,0),(8,'83f5c972-ea2b-4192-8f4e-3ba29b3efd64',NULL,NULL,'192.168.4.107',1,0,NULL,1,0,NULL,'Free',98,200,NULL,200,0,NULL,NULL,0),(9,'995a7b11-e7c5-40bb-a7b4-0cdd7b06f45a',NULL,NULL,'192.168.4.108',1,0,NULL,1,0,NULL,'Free',99,200,NULL,200,0,NULL,NULL,0),(10,'8817d773-24be-4617-bfb8-2b504ab64093',NULL,NULL,'192.168.4.109',1,0,NULL,1,0,NULL,'Free',100,200,NULL,200,0,NULL,NULL,0),(11,'60cb078b-d58c-429b-97ef-06549152da1c',NULL,NULL,'192.168.4.110',1,0,NULL,1,0,NULL,'Free',101,200,NULL,200,0,NULL,NULL,0),(12,'40761ca5-eef5-4648-a1be-f1da9577efd2',NULL,NULL,'192.168.4.111',1,0,NULL,1,0,NULL,'Free',102,200,NULL,200,0,NULL,NULL,0),(13,'4ac74e62-aebc-4e73-906d-95f61d504704',NULL,NULL,'192.168.4.112',1,0,NULL,1,0,NULL,'Free',103,200,NULL,200,0,NULL,NULL,0),(14,'ad9dfdb1-d4b3-4af5-9992-f5bde305f92b',NULL,NULL,'192.168.4.113',1,0,NULL,1,0,NULL,'Free',104,200,NULL,200,0,NULL,NULL,0),(15,'3136f79f-08d7-4271-badd-e7b8a64212af',NULL,NULL,'192.168.4.114',1,0,NULL,1,0,NULL,'Free',105,200,NULL,200,0,NULL,NULL,0),(16,'8a8f44e4-1e82-40c6-9ca4-ff60c55cba73',NULL,NULL,'192.168.4.115',1,0,NULL,1,0,NULL,'Free',106,200,NULL,200,0,NULL,NULL,0),(17,'e6e83951-7929-43e5-9546-04f4c4c787be',NULL,NULL,'192.168.4.116',1,0,NULL,1,0,NULL,'Free',107,200,NULL,200,0,NULL,NULL,0),(18,'074f4766-889b-4fc0-a565-4678c7acf71a',NULL,NULL,'192.168.4.117',1,0,NULL,1,0,NULL,'Free',108,200,NULL,200,0,NULL,NULL,0),(19,'dcb9ef6b-fc04-4064-a86b-224f1ba7a695',NULL,NULL,'192.168.4.118',1,0,NULL,1,0,NULL,'Free',109,200,NULL,200,0,NULL,NULL,0),(20,'438ea8dd-dfa6-4df7-9655-8b3634ca0646',NULL,NULL,'192.168.4.119',1,0,NULL,1,0,NULL,'Free',110,200,NULL,200,0,NULL,NULL,0),(21,'6670f4e2-6f90-4799-a57a-9aab492e684e',NULL,NULL,'192.168.4.120',1,0,NULL,1,0,NULL,'Free',111,200,NULL,200,0,NULL,NULL,0),(22,'bb3ad002-c958-426d-983d-3c5b37b0a4d0',NULL,NULL,'192.168.4.121',1,0,NULL,1,0,NULL,'Free',112,200,NULL,200,0,NULL,NULL,0),(23,'209b69d0-0d40-401d-a2c7-e3d9f050c422',NULL,NULL,'192.168.4.122',1,0,NULL,1,0,NULL,'Free',113,200,NULL,200,0,NULL,NULL,0),(24,'c76b1bce-c8dc-4bb1-a326-66c89bbd1bcb',NULL,NULL,'192.168.4.123',1,0,NULL,1,0,NULL,'Free',114,200,NULL,200,0,NULL,NULL,0),(25,'c04bdaa0-e507-4335-8158-f147c22bdac4',NULL,NULL,'192.168.4.124',1,0,NULL,1,0,NULL,'Free',115,200,NULL,200,0,NULL,NULL,0),(26,'16854bb3-9cde-40df-8341-fb2461a33ed8',NULL,NULL,'192.168.4.125',1,0,NULL,1,0,NULL,'Free',116,200,NULL,200,0,NULL,NULL,0),(27,'29dbf197-13e9-4587-a84d-7d7b87fcbf4e',NULL,NULL,'192.168.4.126',1,0,NULL,1,0,NULL,'Free',117,200,NULL,200,0,NULL,NULL,0),(28,'edf4cbab-c3fb-4ed6-94c2-5ded7d60837f',NULL,NULL,'192.168.4.127',1,0,NULL,1,0,NULL,'Free',118,200,NULL,200,0,NULL,NULL,0),(29,'70fe8aff-f8ce-4ff5-9dc8-a387763bca33',NULL,NULL,'192.168.4.128',1,0,NULL,1,0,NULL,'Free',119,200,NULL,200,0,NULL,NULL,0),(30,'0b2c25dd-1ab3-4b6a-95e9-7a9ae4a1f4a9',NULL,NULL,'192.168.4.129',1,0,NULL,1,0,NULL,'Free',120,200,NULL,200,0,NULL,NULL,0),(31,'08903fa7-4ddc-43ae-b9db-692ed472bcaa',NULL,NULL,'192.168.4.130',1,0,NULL,1,0,NULL,'Free',121,200,NULL,200,0,NULL,NULL,0),(32,'62755a0c-9964-4097-a30a-0a66db2ebeea',NULL,NULL,'192.168.4.131',1,0,NULL,1,0,NULL,'Free',122,200,NULL,200,0,NULL,NULL,0),(33,'59b13def-797d-4f5f-a6f4-ade6f4148064',NULL,NULL,'192.168.4.132',1,0,NULL,1,0,NULL,'Free',123,200,NULL,200,0,NULL,NULL,0),(34,'fb808a66-0d03-44a9-9a77-39a42e5c6609',NULL,NULL,'192.168.4.133',1,0,NULL,1,0,NULL,'Free',124,200,NULL,200,0,NULL,NULL,0),(35,'52654164-0b7e-44d8-9c90-dc0a3fc3d803',NULL,NULL,'192.168.4.134',1,0,NULL,1,0,NULL,'Free',125,200,NULL,200,0,NULL,NULL,0),(36,'23f1a098-8663-4fbc-ac8b-cd7580d56c92',NULL,NULL,'192.168.4.135',1,0,NULL,1,0,NULL,'Free',126,200,NULL,200,0,NULL,NULL,0),(37,'a76958e5-3917-4c20-8aa4-af7d87c427d1',NULL,NULL,'192.168.4.136',1,0,NULL,1,0,NULL,'Free',127,200,NULL,200,0,NULL,NULL,0),(38,'36d3b340-5b44-471e-afeb-d6b9fe43a8de',NULL,NULL,'192.168.4.137',1,0,NULL,1,0,NULL,'Free',128,200,NULL,200,0,NULL,NULL,0),(39,'d0618fce-2b7d-4f36-b97a-61aff200d0fd',NULL,NULL,'192.168.4.138',1,0,NULL,1,0,NULL,'Free',129,200,NULL,200,0,NULL,NULL,0),(40,'5606bc1e-909b-436a-a84c-b58521957a4b',NULL,NULL,'192.168.4.139',1,0,NULL,1,0,NULL,'Free',130,200,NULL,200,0,NULL,NULL,0),(41,'d52f60a9-e4a5-4f5d-bdcb-8c2ab9fcbeba',NULL,NULL,'192.168.4.140',1,0,NULL,1,0,NULL,'Free',131,200,NULL,200,0,NULL,NULL,0),(42,'d9c55796-6339-47a9-88c3-c6be868cff57',NULL,NULL,'192.168.4.141',1,0,NULL,1,0,NULL,'Free',132,200,NULL,200,0,NULL,NULL,0),(43,'83af8a03-16d5-4b6a-a168-81e89aedfbc7',NULL,NULL,'192.168.4.142',1,0,NULL,1,0,NULL,'Free',133,200,NULL,200,0,NULL,NULL,0),(44,'5ba37c8e-be8e-4efc-93dc-dc83d00fbb04',NULL,NULL,'192.168.4.143',1,0,NULL,1,0,NULL,'Free',134,200,NULL,200,0,NULL,NULL,0),(45,'261edebb-f425-477b-9aec-70861336cc8c',NULL,NULL,'192.168.4.144',1,0,NULL,1,0,NULL,'Free',135,200,NULL,200,0,NULL,NULL,0),(46,'8708714e-4b82-4395-9282-68f18c964941',NULL,NULL,'192.168.4.145',1,0,NULL,1,0,NULL,'Free',136,200,NULL,200,0,NULL,NULL,0),(47,'b1e99aee-8fd2-40d4-ab3c-b30bf0108d0e',NULL,NULL,'192.168.4.146',1,0,NULL,1,0,NULL,'Free',137,200,NULL,200,0,NULL,NULL,0),(48,'57d30956-89d2-4f0f-b4eb-ae5f4f0e82d5',NULL,NULL,'192.168.4.147',1,0,NULL,1,0,NULL,'Free',138,200,NULL,200,0,NULL,NULL,0),(49,'34ef7d7e-f5ec-42f6-96cd-011d6f7a279b',NULL,NULL,'192.168.4.148',1,0,NULL,1,0,NULL,'Free',139,200,NULL,200,0,NULL,NULL,0),(50,'582bd324-c090-4b31-9e71-0917baba46cf',NULL,NULL,'192.168.4.149',1,0,NULL,1,0,NULL,'Free',140,200,NULL,200,0,NULL,NULL,0),(51,'6bb1f31a-2b11-431c-a7c1-4a49f16e31e3',NULL,NULL,'192.168.4.150',1,0,NULL,1,0,NULL,'Free',141,200,NULL,200,0,NULL,NULL,0),(52,'b98cb951-174d-4dcd-96a2-e690bce3034f',NULL,NULL,'192.168.4.151',1,0,NULL,1,0,NULL,'Free',142,200,NULL,200,0,NULL,NULL,0),(53,'8f4d1b77-e6d0-461c-924d-51c84faecf4a',NULL,NULL,'192.168.4.152',1,0,NULL,1,0,NULL,'Free',143,200,NULL,200,0,NULL,NULL,0),(54,'d03159a7-afb5-45ba-b6ca-249021669f6f',NULL,NULL,'192.168.4.153',1,0,NULL,1,0,NULL,'Free',144,200,NULL,200,0,NULL,NULL,0),(55,'168ae13e-af0e-4a5f-9aca-43cecc55813f',NULL,NULL,'192.168.4.154',1,0,NULL,1,0,NULL,'Free',145,200,NULL,200,0,NULL,NULL,0),(56,'378b6ddf-aa0f-4af2-a535-0b16ddb392d7',NULL,NULL,'192.168.4.155',1,0,NULL,1,0,NULL,'Free',146,200,NULL,200,0,NULL,NULL,0),(57,'fa614fb6-85fb-42a5-b0d8-3fad6f00f90d',NULL,NULL,'192.168.4.156',1,0,NULL,1,0,NULL,'Free',147,200,NULL,200,0,NULL,NULL,0),(58,'8136a30c-4117-490b-bf08-351642104a9e',NULL,NULL,'192.168.4.157',1,0,NULL,1,0,NULL,'Free',148,200,NULL,200,0,NULL,NULL,0),(59,'e3f5eb83-eb49-4714-b33c-e35d145ecaee',NULL,NULL,'192.168.4.158',1,0,NULL,1,0,NULL,'Free',149,200,NULL,200,0,NULL,NULL,0),(60,'ca1a4d1c-8141-42ae-97d5-f16cff3fdff2',NULL,NULL,'192.168.4.159',1,0,NULL,1,0,NULL,'Free',150,200,NULL,200,0,NULL,NULL,0),(61,'aa0bc0e6-bf1c-4b81-9532-bb6726de6397',NULL,NULL,'192.168.4.160',1,0,NULL,1,0,NULL,'Free',151,200,NULL,200,0,NULL,NULL,0),(62,'52136945-b9d1-49d4-96e9-e8c048c0e9c0',NULL,NULL,'192.168.4.161',1,0,NULL,1,0,NULL,'Free',152,200,NULL,200,0,NULL,NULL,0),(63,'789ea557-c560-4416-a136-38817c5a9d93',NULL,NULL,'192.168.4.162',1,0,NULL,1,0,NULL,'Free',153,200,NULL,200,0,NULL,NULL,0),(64,'c56dfc5a-738f-460d-8084-d7b6fee99b3a',NULL,NULL,'192.168.4.163',1,0,NULL,1,0,NULL,'Free',154,200,NULL,200,0,NULL,NULL,0),(65,'eaf72dd0-f3d5-4c27-84b8-19d1c716e9fa',NULL,NULL,'192.168.4.164',1,0,NULL,1,0,NULL,'Free',155,200,NULL,200,0,NULL,NULL,0),(66,'9b8ead82-effd-40c3-98c4-d0b5c33ce014',NULL,NULL,'192.168.4.165',1,0,NULL,1,0,NULL,'Free',156,200,NULL,200,0,NULL,NULL,0),(67,'bd886395-3fee-4f05-abca-6766e1d397dc',NULL,NULL,'192.168.4.166',1,0,NULL,1,0,NULL,'Free',157,200,NULL,200,0,NULL,NULL,0),(68,'bb94a6a4-2161-42d7-ab2e-20add2519084',NULL,NULL,'192.168.4.167',1,0,NULL,1,0,NULL,'Free',158,200,NULL,200,0,NULL,NULL,0),(69,'4324a32e-26ce-45e8-8c47-91a582ea011e',NULL,NULL,'192.168.4.168',1,0,NULL,1,0,NULL,'Free',159,200,NULL,200,0,NULL,NULL,0),(70,'653c9ae9-485c-4521-86d7-e4ce7a02f7ae',NULL,NULL,'192.168.4.169',1,0,NULL,1,0,NULL,'Free',160,200,NULL,200,0,NULL,NULL,0),(71,'d3387671-280a-4b39-8131-bd6d6bfb5882',NULL,NULL,'192.168.4.170',1,0,NULL,1,0,NULL,'Free',161,200,NULL,200,0,NULL,NULL,0),(72,'b4a427ad-9dfd-4af7-8018-a363f6c89b15',NULL,NULL,'192.168.4.171',1,0,NULL,1,0,NULL,'Free',162,200,NULL,200,0,NULL,NULL,0),(73,'45789777-ec40-4aea-9801-f71d9a94316b',NULL,NULL,'192.168.4.172',1,0,NULL,1,0,NULL,'Free',163,200,NULL,200,0,NULL,NULL,0),(74,'c397750e-85c5-4848-bd65-92205a7d8acf',NULL,NULL,'192.168.4.173',1,0,NULL,1,0,NULL,'Free',164,200,NULL,200,0,NULL,NULL,0),(75,'94af0890-f196-41cd-999f-7c0485581442',NULL,NULL,'192.168.4.174',1,0,NULL,1,0,NULL,'Free',165,200,NULL,200,0,NULL,NULL,0),(76,'5ce9ba63-7dbf-47f3-b24b-2a699d356bf0',NULL,NULL,'192.168.4.175',1,0,NULL,1,0,NULL,'Free',166,200,NULL,200,0,NULL,NULL,0),(77,'9a198c6b-79a0-4c00-9c59-7b06ca0e6434',NULL,NULL,'192.168.4.176',1,0,NULL,1,0,NULL,'Free',167,200,NULL,200,0,NULL,NULL,0),(78,'b9aa2d43-5360-4b1f-8755-7c6cafc5ff5e',NULL,NULL,'192.168.4.177',1,0,NULL,1,0,NULL,'Free',168,200,NULL,200,0,NULL,NULL,0),(79,'080b8282-620d-4e29-b66c-59482c79d26c',NULL,NULL,'192.168.4.178',1,0,NULL,1,0,NULL,'Free',169,200,NULL,200,0,NULL,NULL,0),(80,'46a15e68-2a83-4631-852c-591cfb9ddcde',NULL,NULL,'192.168.4.179',1,0,NULL,1,0,NULL,'Free',170,200,NULL,200,0,NULL,NULL,0),(81,'37d3ee0c-3b1a-44a2-b783-b4ac06cba0ec',NULL,NULL,'192.168.4.180',1,0,NULL,1,0,NULL,'Free',171,200,NULL,200,0,NULL,NULL,0),(82,'4e567743-7701-4a67-81d4-e1218cd09b54',NULL,NULL,'192.168.4.181',1,0,NULL,1,0,NULL,'Free',172,200,NULL,200,0,NULL,NULL,0),(83,'6f0b2b7f-08a7-43db-9814-1b6bfb343738',NULL,NULL,'192.168.4.182',1,0,NULL,1,0,NULL,'Free',173,200,NULL,200,0,NULL,NULL,0),(84,'a0b1f1c4-ed64-452b-851d-36cb8fc1ebe5',NULL,NULL,'192.168.4.183',1,0,NULL,1,0,NULL,'Free',174,200,NULL,200,0,NULL,NULL,0),(85,'b722f797-8ad1-4c55-9383-dc1f0df355d2',NULL,NULL,'192.168.4.184',1,0,NULL,1,0,NULL,'Free',175,200,NULL,200,0,NULL,NULL,0),(86,'725c3c44-ca01-4665-aa82-47a5c23b3503',NULL,NULL,'192.168.4.185',1,0,NULL,1,0,NULL,'Free',176,200,NULL,200,0,NULL,NULL,0),(87,'f9d5912a-cbbe-4847-8764-7a7bdd655733',NULL,NULL,'192.168.4.186',1,0,NULL,1,0,NULL,'Free',177,200,NULL,200,0,NULL,NULL,0),(88,'4f4954e9-7a14-4f82-9f71-dd655c929f4f',NULL,NULL,'192.168.4.187',1,0,NULL,1,0,NULL,'Free',178,200,NULL,200,0,NULL,NULL,0),(89,'00b9b2bc-e803-4b57-b46e-7a8633da24a8',NULL,NULL,'192.168.4.188',1,0,NULL,1,0,NULL,'Free',179,200,NULL,200,0,NULL,NULL,0),(90,'d4677355-48f6-4419-85f6-49dff865b8de',NULL,NULL,'192.168.4.189',1,0,NULL,1,0,NULL,'Free',180,200,NULL,200,0,NULL,NULL,0),(91,'cab1fb50-498a-468d-8043-ef8a4754b0a0',NULL,NULL,'192.168.4.190',1,0,NULL,1,0,NULL,'Free',181,200,NULL,200,0,NULL,NULL,0),(92,'d85c4d99-0a66-4825-a7d3-108fcc342d23',NULL,NULL,'192.168.4.191',1,0,NULL,1,0,NULL,'Free',182,200,NULL,200,0,NULL,NULL,0),(93,'d2cb15dd-26ae-41f6-9540-1961787b4fc0',NULL,NULL,'192.168.4.192',1,0,NULL,1,0,NULL,'Free',183,200,NULL,200,0,NULL,NULL,0),(94,'ec548dc8-1fdb-452c-82cf-52d51de2a99d',NULL,NULL,'192.168.4.193',1,0,NULL,1,0,NULL,'Free',184,200,NULL,200,0,NULL,NULL,0),(95,'bbe4dc27-2161-416a-a82c-1cfef471d948',NULL,NULL,'192.168.4.194',1,0,NULL,1,0,NULL,'Free',185,200,NULL,200,0,NULL,NULL,0),(96,'b07fd832-dd38-47d0-b65d-c3d6f1029e11',NULL,NULL,'192.168.4.195',1,0,NULL,1,0,NULL,'Free',186,200,NULL,200,0,NULL,NULL,0),(97,'2b424efd-fed7-4bf5-b41a-1cb4b82403bd',NULL,NULL,'192.168.4.196',1,0,NULL,1,0,NULL,'Free',187,200,NULL,200,0,NULL,NULL,0),(98,'0e20bae0-4ef0-4418-a04b-c3a7c161f281',NULL,NULL,'192.168.4.197',1,0,NULL,1,0,NULL,'Free',188,200,NULL,200,0,NULL,NULL,0),(99,'49e4a79b-3667-420b-8c26-77d3b5f5c691',NULL,NULL,'192.168.4.198',1,0,NULL,1,0,NULL,'Free',189,200,NULL,200,0,NULL,NULL,0),(100,'775d62e9-e3e9-468d-97b9-0774b3b0fc70',NULL,NULL,'192.168.4.199',1,0,NULL,1,0,NULL,'Free',190,200,NULL,200,0,NULL,NULL,0),(101,'bd3879ee-03f4-4765-9680-7cce643169b1',NULL,NULL,'192.168.4.200',1,0,NULL,1,0,NULL,'Free',191,200,NULL,200,0,NULL,NULL,0);
/*!40000 ALTER TABLE `user_ip_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_ipv6_address`
--

DROP TABLE IF EXISTS `user_ipv6_address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_ipv6_address` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `account_id` bigint(20) unsigned DEFAULT NULL,
  `domain_id` bigint(20) unsigned DEFAULT NULL,
  `ip_address` char(50) NOT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'zone that it belongs to',
  `vlan_id` bigint(20) unsigned NOT NULL,
  `state` char(32) NOT NULL DEFAULT 'Free' COMMENT 'state of the ip address',
  `mac_address` varchar(40) NOT NULL COMMENT 'mac address of this ip',
  `source_network_id` bigint(20) unsigned NOT NULL COMMENT 'network id ip belongs to',
  `network_id` bigint(20) unsigned DEFAULT NULL COMMENT 'network this public ip address is associated with',
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'physical network id that this configuration is based on',
  `created` datetime DEFAULT NULL COMMENT 'Date this ip was allocated to someone',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `ip_address` (`ip_address`,`source_network_id`),
  UNIQUE KEY `uc_user_ipv6_address__uuid` (`uuid`),
  KEY `fk_user_ipv6_address__source_network_id` (`source_network_id`),
  KEY `fk_user_ipv6_address__network_id` (`network_id`),
  KEY `fk_user_ipv6_address__account_id` (`account_id`),
  KEY `fk_user_ipv6_address__vlan_id` (`vlan_id`),
  KEY `fk_user_ipv6_address__data_center_id` (`data_center_id`),
  KEY `fk_user_ipv6_address__physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_user_ipv6_address__source_network_id` FOREIGN KEY (`source_network_id`) REFERENCES `networks` (`id`),
  CONSTRAINT `fk_user_ipv6_address__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`),
  CONSTRAINT `fk_user_ipv6_address__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_user_ipv6_address__vlan_id` FOREIGN KEY (`vlan_id`) REFERENCES `vlan` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_ipv6_address__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_user_ipv6_address__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_ipv6_address`
--

LOCK TABLES `user_ipv6_address` WRITE;
/*!40000 ALTER TABLE `user_ipv6_address` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_ipv6_address` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_statistics`
--

DROP TABLE IF EXISTS `user_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_statistics` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `public_ip_address` char(40) DEFAULT NULL,
  `device_id` bigint(20) unsigned NOT NULL,
  `device_type` varchar(32) NOT NULL,
  `network_id` bigint(20) unsigned DEFAULT NULL,
  `net_bytes_received` bigint(20) unsigned NOT NULL DEFAULT '0',
  `net_bytes_sent` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_bytes_received` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_bytes_sent` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_bytes_received` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_bytes_sent` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `account_id` (`account_id`,`data_center_id`,`public_ip_address`,`device_id`,`device_type`),
  KEY `i_user_statistics__account_id` (`account_id`),
  KEY `i_user_statistics__account_id_data_center_id` (`account_id`,`data_center_id`),
  CONSTRAINT `fk_user_statistics__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_statistics`
--

LOCK TABLES `user_statistics` WRITE;
/*!40000 ALTER TABLE `user_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `user_view`
--

DROP TABLE IF EXISTS `user_view`;
/*!50001 DROP VIEW IF EXISTS `user_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `user_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `username` tinyint NOT NULL,
  `password` tinyint NOT NULL,
  `firstname` tinyint NOT NULL,
  `lastname` tinyint NOT NULL,
  `email` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `api_key` tinyint NOT NULL,
  `secret_key` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `timezone` tinyint NOT NULL,
  `registration_token` tinyint NOT NULL,
  `is_registered` tinyint NOT NULL,
  `incorrect_login_attempts` tinyint NOT NULL,
  `default` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `user_vm`
--

DROP TABLE IF EXISTS `user_vm`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_vm` (
  `id` bigint(20) unsigned NOT NULL,
  `iso_id` bigint(20) unsigned DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `user_data` mediumtext,
  `update_parameters` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Defines if the parameters have been updated for the vm',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  CONSTRAINT `fk_user_vm__id` FOREIGN KEY (`id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_vm`
--

LOCK TABLES `user_vm` WRITE;
/*!40000 ALTER TABLE `user_vm` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_vm` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_vm_clone_setting`
--

DROP TABLE IF EXISTS `user_vm_clone_setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_vm_clone_setting` (
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'guest VM id',
  `clone_type` varchar(10) NOT NULL COMMENT 'Full or Linked Clone (applicable to VMs on ESX)',
  PRIMARY KEY (`vm_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_vm_clone_setting`
--

LOCK TABLES `user_vm_clone_setting` WRITE;
/*!40000 ALTER TABLE `user_vm_clone_setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_vm_clone_setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_vm_details`
--

DROP TABLE IF EXISTS `user_vm_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_vm_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'vm id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) NOT NULL,
  `display_detail` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should vm detail instance be displayed to the end user',
  PRIMARY KEY (`id`),
  KEY `fk_user_vm_details__vm_id` (`vm_id`),
  CONSTRAINT `fk_user_vm_details__vm_id` FOREIGN KEY (`vm_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_vm_details`
--

LOCK TABLES `user_vm_details` WRITE;
/*!40000 ALTER TABLE `user_vm_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `user_vm_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `user_vm_view`
--

DROP TABLE IF EXISTS `user_vm_view`;
/*!50001 DROP VIEW IF EXISTS `user_vm_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `user_vm_view` (
  `id` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `display_name` tinyint NOT NULL,
  `user_data` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL,
  `instance_group_id` tinyint NOT NULL,
  `instance_group_uuid` tinyint NOT NULL,
  `instance_group_name` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `last_host_id` tinyint NOT NULL,
  `type` tinyint NOT NULL,
  `vnc_password` tinyint NOT NULL,
  `limit_cpu_use` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `ha_enabled` tinyint NOT NULL,
  `hypervisor_type` tinyint NOT NULL,
  `instance_name` tinyint NOT NULL,
  `guest_os_id` tinyint NOT NULL,
  `display_vm` tinyint NOT NULL,
  `guest_os_uuid` tinyint NOT NULL,
  `pod_id` tinyint NOT NULL,
  `pod_uuid` tinyint NOT NULL,
  `private_ip_address` tinyint NOT NULL,
  `private_mac_address` tinyint NOT NULL,
  `vm_type` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `security_group_enabled` tinyint NOT NULL,
  `data_center_type` tinyint NOT NULL,
  `host_id` tinyint NOT NULL,
  `host_uuid` tinyint NOT NULL,
  `host_name` tinyint NOT NULL,
  `template_id` tinyint NOT NULL,
  `template_uuid` tinyint NOT NULL,
  `template_name` tinyint NOT NULL,
  `template_display_text` tinyint NOT NULL,
  `password_enabled` tinyint NOT NULL,
  `iso_id` tinyint NOT NULL,
  `iso_uuid` tinyint NOT NULL,
  `iso_name` tinyint NOT NULL,
  `iso_display_text` tinyint NOT NULL,
  `service_offering_id` tinyint NOT NULL,
  `service_offering_uuid` tinyint NOT NULL,
  `cpu` tinyint NOT NULL,
  `speed` tinyint NOT NULL,
  `ram_size` tinyint NOT NULL,
  `service_offering_name` tinyint NOT NULL,
  `pool_id` tinyint NOT NULL,
  `pool_uuid` tinyint NOT NULL,
  `pool_type` tinyint NOT NULL,
  `volume_id` tinyint NOT NULL,
  `volume_uuid` tinyint NOT NULL,
  `volume_device_id` tinyint NOT NULL,
  `volume_type` tinyint NOT NULL,
  `security_group_id` tinyint NOT NULL,
  `security_group_uuid` tinyint NOT NULL,
  `security_group_name` tinyint NOT NULL,
  `security_group_description` tinyint NOT NULL,
  `nic_id` tinyint NOT NULL,
  `nic_uuid` tinyint NOT NULL,
  `network_id` tinyint NOT NULL,
  `ip_address` tinyint NOT NULL,
  `ip6_address` tinyint NOT NULL,
  `ip6_gateway` tinyint NOT NULL,
  `ip6_cidr` tinyint NOT NULL,
  `is_default_nic` tinyint NOT NULL,
  `gateway` tinyint NOT NULL,
  `netmask` tinyint NOT NULL,
  `mac_address` tinyint NOT NULL,
  `broadcast_uri` tinyint NOT NULL,
  `isolation_uri` tinyint NOT NULL,
  `vpc_id` tinyint NOT NULL,
  `vpc_uuid` tinyint NOT NULL,
  `network_uuid` tinyint NOT NULL,
  `network_name` tinyint NOT NULL,
  `traffic_type` tinyint NOT NULL,
  `guest_type` tinyint NOT NULL,
  `public_ip_id` tinyint NOT NULL,
  `public_ip_uuid` tinyint NOT NULL,
  `public_ip_address` tinyint NOT NULL,
  `keypair_name` tinyint NOT NULL,
  `tag_id` tinyint NOT NULL,
  `tag_uuid` tinyint NOT NULL,
  `tag_key` tinyint NOT NULL,
  `tag_value` tinyint NOT NULL,
  `tag_domain_id` tinyint NOT NULL,
  `tag_account_id` tinyint NOT NULL,
  `tag_resource_id` tinyint NOT NULL,
  `tag_resource_uuid` tinyint NOT NULL,
  `tag_resource_type` tinyint NOT NULL,
  `tag_customer` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL,
  `affinity_group_id` tinyint NOT NULL,
  `affinity_group_uuid` tinyint NOT NULL,
  `affinity_group_name` tinyint NOT NULL,
  `affinity_group_description` tinyint NOT NULL,
  `dynamically_scalable` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `version`
--

DROP TABLE IF EXISTS `version`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `version` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `version` char(40) NOT NULL COMMENT 'version',
  `updated` datetime NOT NULL COMMENT 'Date this version table was updated',
  `step` char(32) NOT NULL COMMENT 'Step in the upgrade to this version',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `version` (`version`),
  KEY `i_version__version` (`version`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `version`
--

LOCK TABLES `version` WRITE;
/*!40000 ALTER TABLE `version` DISABLE KEYS */;
INSERT INTO `version` VALUES (1,'4.0.0','2013-10-25 23:10:22','Complete'),(2,'4.1.0','2013-10-26 06:10:29','Complete'),(3,'4.2.0','2013-10-26 06:10:29','Complete'),(4,'4.2.1','2013-10-26 06:10:29','Complete'),(5,'4.3.0','2013-10-26 06:10:29','Complete');
/*!40000 ALTER TABLE `version` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtual_router_providers`
--

DROP TABLE IF EXISTS `virtual_router_providers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virtual_router_providers` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `nsp_id` bigint(20) unsigned NOT NULL COMMENT 'Network Service Provider ID',
  `uuid` varchar(40) DEFAULT NULL,
  `type` varchar(255) NOT NULL COMMENT 'Virtual router, or ElbVM',
  `enabled` int(1) NOT NULL COMMENT 'Enabled or disabled',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_virtual_router_providers__uuid` (`uuid`),
  KEY `fk_virtual_router_providers__nsp_id` (`nsp_id`),
  CONSTRAINT `fk_virtual_router_providers__nsp_id` FOREIGN KEY (`nsp_id`) REFERENCES `physical_network_service_providers` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtual_router_providers`
--

LOCK TABLES `virtual_router_providers` WRITE;
/*!40000 ALTER TABLE `virtual_router_providers` DISABLE KEYS */;
INSERT INTO `virtual_router_providers` VALUES (1,1,'39d1140d-9235-481c-89c0-3dd92b8e85c9','VirtualRouter',1,NULL),(2,3,'b7b4eb62-98b0-41b0-a18e-6de5d5051308','VPCVirtualRouter',1,NULL),(3,4,'027fb8c1-9443-4c0b-8190-a00f3c39eec1','InternalLbVm',1,NULL);
/*!40000 ALTER TABLE `virtual_router_providers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `virtual_supervisor_module`
--

DROP TABLE IF EXISTS `virtual_supervisor_module`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `virtual_supervisor_module` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `host_id` bigint(20) NOT NULL,
  `vsm_name` varchar(255) DEFAULT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `ipaddr` varchar(80) NOT NULL,
  `management_vlan` int(32) DEFAULT NULL,
  `control_vlan` int(32) DEFAULT NULL,
  `packet_vlan` int(32) DEFAULT NULL,
  `storage_vlan` int(32) DEFAULT NULL,
  `vsm_domain_id` bigint(20) unsigned DEFAULT NULL,
  `config_mode` varchar(20) DEFAULT NULL,
  `config_state` varchar(20) DEFAULT NULL,
  `vsm_device_state` varchar(20) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `virtual_supervisor_module`
--

LOCK TABLES `virtual_supervisor_module` WRITE;
/*!40000 ALTER TABLE `virtual_supervisor_module` DISABLE KEYS */;
/*!40000 ALTER TABLE `virtual_supervisor_module` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vlan`
--

DROP TABLE IF EXISTS `vlan`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vlan` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `vlan_id` varchar(255) DEFAULT NULL,
  `vlan_gateway` varchar(255) DEFAULT NULL,
  `vlan_netmask` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `vlan_type` varchar(255) DEFAULT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'id of corresponding network offering',
  `physical_network_id` bigint(20) unsigned NOT NULL COMMENT 'physical network id that this configuration is based on',
  `ip6_gateway` varchar(255) DEFAULT NULL,
  `ip6_cidr` varchar(255) DEFAULT NULL,
  `ip6_range` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_vlan__uuid` (`uuid`),
  KEY `fk_vlan__data_center_id` (`data_center_id`),
  KEY `fk_vlan__physical_network_id` (`physical_network_id`),
  CONSTRAINT `fk_vlan__data_center_id` FOREIGN KEY (`data_center_id`) REFERENCES `data_center` (`id`),
  CONSTRAINT `fk_vlan__physical_network_id` FOREIGN KEY (`physical_network_id`) REFERENCES `physical_network` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vlan`
--

LOCK TABLES `vlan` WRITE;
/*!40000 ALTER TABLE `vlan` DISABLE KEYS */;
INSERT INTO `vlan` VALUES (1,'3da27e5e-9771-4a0e-a3c1-45631247a0d4','vlan://untagged','192.168.4.1','255.255.255.0','192.168.4.100-192.168.4.200','VirtualNetwork',1,200,200,NULL,NULL,NULL);
/*!40000 ALTER TABLE `vlan` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_compute_tags`
--

DROP TABLE IF EXISTS `vm_compute_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_compute_tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'vm id',
  `compute_tag` varchar(255) NOT NULL COMMENT 'name of tag',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_compute_tags`
--

LOCK TABLES `vm_compute_tags` WRITE;
/*!40000 ALTER TABLE `vm_compute_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_compute_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_disk_statistics`
--

DROP TABLE IF EXISTS `vm_disk_statistics`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_disk_statistics` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `data_center_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `vm_id` bigint(20) unsigned NOT NULL,
  `volume_id` bigint(20) unsigned NOT NULL DEFAULT '0',
  `net_io_read` bigint(20) unsigned NOT NULL DEFAULT '0',
  `net_io_write` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_io_read` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_io_write` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_io_read` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_io_write` bigint(20) unsigned NOT NULL DEFAULT '0',
  `net_bytes_read` bigint(20) unsigned NOT NULL DEFAULT '0',
  `net_bytes_write` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_bytes_read` bigint(20) unsigned NOT NULL DEFAULT '0',
  `current_bytes_write` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_bytes_read` bigint(20) unsigned NOT NULL DEFAULT '0',
  `agg_bytes_write` bigint(20) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `account_id` (`account_id`,`data_center_id`,`vm_id`,`volume_id`),
  KEY `i_vm_disk_statistics__account_id` (`account_id`),
  KEY `i_vm_disk_statistics__account_id_data_center_id` (`account_id`,`data_center_id`),
  CONSTRAINT `fk_vm_disk_statistics__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_disk_statistics`
--

LOCK TABLES `vm_disk_statistics` WRITE;
/*!40000 ALTER TABLE `vm_disk_statistics` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_disk_statistics` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_instance`
--

DROP TABLE IF EXISTS `vm_instance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_instance` (
  `id` bigint(20) unsigned NOT NULL,
  `name` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `instance_name` varchar(255) NOT NULL COMMENT 'name of the vm instance running on the hosts',
  `state` varchar(32) NOT NULL,
  `vm_template_id` bigint(20) unsigned DEFAULT NULL,
  `guest_os_id` bigint(20) unsigned NOT NULL,
  `private_mac_address` varchar(17) DEFAULT NULL,
  `private_ip_address` char(40) DEFAULT NULL,
  `pod_id` bigint(20) unsigned DEFAULT NULL,
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'Data Center the instance belongs to',
  `host_id` bigint(20) unsigned DEFAULT NULL,
  `last_host_id` bigint(20) unsigned DEFAULT NULL COMMENT 'tentative host for first run or last host that it has been running on',
  `proxy_id` bigint(20) unsigned DEFAULT NULL COMMENT 'console proxy allocated in previous session',
  `proxy_assign_time` datetime DEFAULT NULL COMMENT 'time when console proxy was assigned',
  `vnc_password` varchar(255) NOT NULL COMMENT 'vnc password',
  `ha_enabled` tinyint(1) NOT NULL DEFAULT '0' COMMENT 'Should HA be enabled for this VM',
  `limit_cpu_use` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Limit the cpu usage to service offering',
  `update_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'date state was updated',
  `update_time` datetime DEFAULT NULL COMMENT 'date the destroy was requested',
  `created` datetime NOT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `type` varchar(32) NOT NULL COMMENT 'type of vm it is',
  `vm_type` varchar(32) NOT NULL COMMENT 'vm type',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'user id of owner',
  `domain_id` bigint(20) unsigned NOT NULL,
  `service_offering_id` bigint(20) unsigned NOT NULL COMMENT 'service offering id',
  `reservation_id` char(40) DEFAULT NULL COMMENT 'reservation id',
  `hypervisor_type` char(32) DEFAULT NULL COMMENT 'hypervisor type',
  `disk_offering_id` bigint(20) unsigned DEFAULT NULL,
  `cpu` int(10) unsigned DEFAULT NULL,
  `ram` bigint(20) unsigned DEFAULT NULL,
  `owner` varchar(255) DEFAULT NULL,
  `speed` int(10) unsigned DEFAULT NULL,
  `host_name` varchar(255) DEFAULT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `desired_state` varchar(32) DEFAULT NULL,
  `dynamically_scalable` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if VM contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory',
  `display_vm` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should vm instance be displayed to the end user',
  `power_state` varchar(74) DEFAULT 'PowerUnknown',
  `power_state_update_time` datetime DEFAULT NULL,
  `power_state_update_count` int(11) DEFAULT '0',
  `power_host` bigint(20) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_vm_instance_uuid` (`uuid`),
  KEY `i_vm_instance__removed` (`removed`),
  KEY `i_vm_instance__type` (`type`),
  KEY `i_vm_instance__pod_id` (`pod_id`),
  KEY `i_vm_instance__update_time` (`update_time`),
  KEY `i_vm_instance__update_count` (`update_count`),
  KEY `i_vm_instance__state` (`state`),
  KEY `i_vm_instance__data_center_id` (`data_center_id`),
  KEY `fk_vm_instance__host_id` (`host_id`),
  KEY `fk_vm_instance__last_host_id` (`last_host_id`),
  KEY `i_vm_instance__template_id` (`vm_template_id`),
  KEY `fk_vm_instance__account_id` (`account_id`),
  KEY `fk_vm_instance__service_offering_id` (`service_offering_id`),
  KEY `fk_vm_instance__power_host` (`power_host`),
  CONSTRAINT `fk_vm_instance__power_host` FOREIGN KEY (`power_host`) REFERENCES `host` (`id`),
  CONSTRAINT `fk_vm_instance__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_vm_instance__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`),
  CONSTRAINT `fk_vm_instance__last_host_id` FOREIGN KEY (`last_host_id`) REFERENCES `host` (`id`),
  CONSTRAINT `fk_vm_instance__service_offering_id` FOREIGN KEY (`service_offering_id`) REFERENCES `service_offering` (`id`),
  CONSTRAINT `fk_vm_instance__template_id` FOREIGN KEY (`vm_template_id`) REFERENCES `vm_template` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_instance`
--

LOCK TABLES `vm_instance` WRITE;
/*!40000 ALTER TABLE `vm_instance` DISABLE KEYS */;
INSERT INTO `vm_instance` VALUES (1,'s-1-VM','5d170cf9-0490-432e-a2ea-b96481cf67b2','s-1-VM','Stopped',1,183,NULL,NULL,1,1,NULL,NULL,NULL,NULL,'86a3f085fdcae30',0,0,3,'2013-10-26 06:37:25','2013-10-26 06:37:25',NULL,'SecondaryStorageVm','SecondaryStorageVm',1,1,27,'4b2a6384-054f-4716-9e18-550fc097a6a7','XenServer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,'PowerUnknown',NULL,0,NULL),(2,'v-2-VM','7df1bf1e-0231-426b-bc2c-f57072ec636d','v-2-VM','Stopped',1,183,NULL,NULL,1,1,NULL,NULL,NULL,NULL,'f699a4238aaa7eb4',0,0,3,'2013-10-26 06:37:25','2013-10-26 06:37:25',NULL,'ConsoleProxy','ConsoleProxy',1,1,29,'199c52f6-7787-4e25-9f86-af6dcd84d720','XenServer',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,0,1,'PowerUnknown',NULL,0,NULL);
/*!40000 ALTER TABLE `vm_instance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_network_map`
--

DROP TABLE IF EXISTS `vm_network_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_network_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'vm id',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_network_map`
--

LOCK TABLES `vm_network_map` WRITE;
/*!40000 ALTER TABLE `vm_network_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_network_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_reservation`
--

DROP TABLE IF EXISTS `vm_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_reservation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) NOT NULL COMMENT 'reservation id',
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'vm id',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'zone id',
  `pod_id` bigint(20) unsigned NOT NULL COMMENT 'pod id',
  `cluster_id` bigint(20) unsigned NOT NULL COMMENT 'cluster id',
  `host_id` bigint(20) unsigned NOT NULL COMMENT 'host id',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_vm_reservation__uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_reservation`
--

LOCK TABLES `vm_reservation` WRITE;
/*!40000 ALTER TABLE `vm_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_root_disk_tags`
--

DROP TABLE IF EXISTS `vm_root_disk_tags`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_root_disk_tags` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'vm id',
  `root_disk_tag` varchar(255) NOT NULL COMMENT 'name of tag',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_root_disk_tags`
--

LOCK TABLES `vm_root_disk_tags` WRITE;
/*!40000 ALTER TABLE `vm_root_disk_tags` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_root_disk_tags` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_snapshots`
--

DROP TABLE IF EXISTS `vm_snapshots`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_snapshots` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `uuid` varchar(40) NOT NULL,
  `name` varchar(255) NOT NULL,
  `display_name` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `vm_id` bigint(20) unsigned NOT NULL,
  `account_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `vm_snapshot_type` varchar(32) DEFAULT NULL,
  `state` varchar(32) NOT NULL,
  `parent` bigint(20) unsigned DEFAULT NULL,
  `current` int(1) unsigned DEFAULT NULL,
  `update_count` bigint(20) unsigned NOT NULL DEFAULT '0',
  `updated` datetime DEFAULT NULL,
  `created` datetime DEFAULT NULL,
  `removed` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_vm_snapshots_uuid` (`uuid`),
  KEY `vm_snapshots_name` (`name`),
  KEY `vm_snapshots_vm_id` (`vm_id`),
  KEY `vm_snapshots_account_id` (`account_id`),
  KEY `vm_snapshots_display_name` (`display_name`),
  KEY `vm_snapshots_removed` (`removed`),
  KEY `vm_snapshots_parent` (`parent`),
  KEY `fk_vm_snapshots_domain_id__domain_id` (`domain_id`),
  CONSTRAINT `fk_vm_snapshots_vm_id__vm_instance_id` FOREIGN KEY (`vm_id`) REFERENCES `vm_instance` (`id`),
  CONSTRAINT `fk_vm_snapshots_account_id__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`),
  CONSTRAINT `fk_vm_snapshots_domain_id__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_snapshots`
--

LOCK TABLES `vm_snapshots` WRITE;
/*!40000 ALTER TABLE `vm_snapshots` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_snapshots` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_template`
--

DROP TABLE IF EXISTS `vm_template`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_template` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `unique_name` varchar(255) NOT NULL,
  `name` varchar(255) NOT NULL,
  `uuid` varchar(40) DEFAULT NULL,
  `public` int(1) unsigned NOT NULL,
  `featured` int(1) unsigned NOT NULL,
  `type` varchar(32) DEFAULT NULL,
  `hvm` int(1) unsigned NOT NULL COMMENT 'requires HVM',
  `bits` int(6) unsigned NOT NULL COMMENT '32 bit or 64 bit',
  `url` varchar(255) DEFAULT NULL COMMENT 'the url where the template exists externally',
  `format` varchar(32) NOT NULL COMMENT 'format for the template',
  `created` datetime NOT NULL COMMENT 'Date created',
  `removed` datetime DEFAULT NULL COMMENT 'Date removed if not null',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'id of the account that created this template',
  `checksum` varchar(255) DEFAULT NULL COMMENT 'checksum for the template root disk',
  `display_text` varchar(4096) DEFAULT NULL COMMENT 'Description text set by the admin for display purpose only',
  `enable_password` int(1) unsigned NOT NULL DEFAULT '1' COMMENT 'true if this template supports password reset',
  `enable_sshkey` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if this template supports sshkey reset',
  `guest_os_id` bigint(20) unsigned NOT NULL COMMENT 'the OS of the template',
  `bootable` int(1) unsigned NOT NULL DEFAULT '1' COMMENT 'true if this template represents a bootable ISO',
  `prepopulate` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'prepopulate this template to primary storage',
  `cross_zones` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Make this template available in all zones',
  `extractable` int(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is this template extractable',
  `hypervisor_type` varchar(32) DEFAULT NULL COMMENT 'hypervisor that the template belongs to',
  `source_template_id` bigint(20) unsigned DEFAULT NULL COMMENT 'Id of the original template, if this template is created from snapshot',
  `template_tag` varchar(255) DEFAULT NULL COMMENT 'template tag',
  `sort_key` int(32) NOT NULL DEFAULT '0' COMMENT 'sort key used for customising sort method',
  `size` bigint(20) unsigned DEFAULT NULL,
  `state` varchar(255) DEFAULT NULL,
  `update_count` bigint(20) unsigned DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  `dynamically_scalable` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'true if template contains XS/VMWare tools inorder to support dynamic scaling of VM cpu/memory',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_vm_template__uuid` (`uuid`),
  KEY `i_vm_template__removed` (`removed`),
  KEY `i_vm_template__public` (`public`)
) ENGINE=InnoDB AUTO_INCREMENT=202 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_template`
--

LOCK TABLES `vm_template` WRITE;
/*!40000 ALTER TABLE `vm_template` DISABLE KEYS */;
INSERT INTO `vm_template` VALUES (1,'routing-1','SystemVM Template (XenServer)','4d8664aa-3e05-11e3-a27a-14109fdfd297',0,0,'SYSTEM',0,32,'http://download.cloud.com/templates/4.2/systemvmtemplate-2013-07-12-master-xen.vhd.bz2','VHD','2013-10-25 23:10:24',NULL,1,'fb1b6e032a160d86f2c28feb5add6d83','SystemVM Template (XenServer)',0,0,183,1,0,1,0,'XenServer',NULL,NULL,0,NULL,'Active',0,NULL,0),(2,'centos53-x86_64','CentOS 5.3(64-bit) no GUI (XenServer)','4d866e23-3e05-11e3-a27a-14109fdfd297',1,1,'BUILTIN',0,64,'http://download.cloud.com/templates/builtin/f59f18fb-ae94-4f97-afd2-f84755767aca.vhd.bz2','VHD','2013-10-25 23:10:24',NULL,1,'b63d854a9560c013142567bbae8d98cf','CentOS 5.3(64-bit) no GUI (XenServer)',0,0,12,1,0,1,1,'XenServer',NULL,NULL,0,NULL,'Inactive',0,NULL,0),(3,'routing-3','SystemVM Template (KVM)','4d86744b-3e05-11e3-a27a-14109fdfd297',0,0,'SYSTEM',0,64,'http://download.cloud.com/templates/4.2/systemvmtemplate-2013-06-12-master-kvm.qcow2.bz2','QCOW2','2013-10-25 23:10:24',NULL,1,'6cea42b2633841648040becb588bd8f0','SystemVM Template (KVM)',0,0,15,1,0,1,0,'KVM',NULL,NULL,0,NULL,'Active',0,NULL,0),(4,'centos55-x86_64','CentOS 5.5(64-bit) no GUI (KVM)','4d867a26-3e05-11e3-a27a-14109fdfd297',1,1,'BUILTIN',0,64,'http://download.cloud.com/releases/2.2.0/eec2209b-9875-3c8d-92be-c001bd8a0faf.qcow2.bz2','QCOW2','2013-10-25 23:10:24',NULL,1,'ed0e788280ff2912ea40f7f91ca7a249','CentOS 5.5(64-bit) no GUI (KVM)',0,0,112,1,0,1,1,'KVM',NULL,NULL,0,NULL,'Active',0,NULL,0),(5,'tiny Linux','tiny Linux','4d867fec-3e05-11e3-a27a-14109fdfd297',1,1,'BUILTIN',0,64,'http://people.apache.org/~bhaisaab/vms/ttylinux_pv.vhd','VHD','2013-10-25 23:10:24',NULL,1,'046e134e642e6d344b34648223ba4bc1','tiny Linux',0,0,12,1,0,1,1,'XenServer',NULL,NULL,0,NULL,'Active',0,NULL,1),(7,'centos53-x64','CentOS 5.3(64-bit) no GUI (vSphere)','4d8685ad-3e05-11e3-a27a-14109fdfd297',1,1,'BUILTIN',0,64,'http://download.cloud.com/releases/2.2.0/CentOS5.3-x86_64.ova','OVA','2013-10-25 23:10:24',NULL,1,'f6f881b7f2292948d8494db837fe0f47','CentOS 5.3(64-bit) no GUI (vSphere)',0,0,12,1,0,1,1,'VMware',NULL,NULL,0,NULL,'Active',0,NULL,0),(8,'routing-8','SystemVM Template (vSphere)','4d868b6a-3e05-11e3-a27a-14109fdfd297',0,0,'SYSTEM',0,32,'http://download.cloud.com/templates/4.2/systemvmtemplate-4.2-vh7.ova','OVA','2013-10-25 23:10:24',NULL,1,'8fde62b1089e5844a9cd3b9b953f9596','SystemVM Template (vSphere)',0,0,15,1,0,1,0,'VMware',NULL,NULL,0,NULL,'Active',0,NULL,1),(9,'routing-9','SystemVM Template (HyperV)','4d869114-3e05-11e3-a27a-14109fdfd297',0,0,'SYSTEM',0,32,'http://download.cloud.com/templates/4.2/systemvmtemplate-2013-06-12-master-xen.vhd.bz2','VHD','2013-10-25 23:10:24',NULL,1,'fb1b6e032a160d86f2c28feb5add6d83','SystemVM Template (HyperV)',0,0,15,1,0,1,0,'Hyperv',NULL,NULL,0,NULL,'Active',0,NULL,0),(10,'routing-10','SystemVM Template (LXC)','4f70c948-3e05-11e3-a27a-14109fdfd297',0,0,'SYSTEM',0,64,'http://download.cloud.com/templates/acton/acton-systemvm-02062012.qcow2.bz2','QCOW2','2013-10-25 23:10:27',NULL,1,'2755de1f9ef2ce4d6f2bee2efbb4da92','SystemVM Template (LXC)',0,0,15,1,0,1,0,'LXC',NULL,NULL,0,NULL,'Active',0,NULL,0),(200,'vmware-tools.iso','vmware-tools.iso','12ba41a9-0e73-4f8e-b861-0612ce18c3dc',1,1,'PERHOST',1,64,NULL,'ISO','2013-10-26 06:30:25',NULL,1,NULL,'VMware Tools Installer ISO',0,0,1,0,0,0,1,'VMware',NULL,NULL,0,NULL,'Active',0,NULL,0),(201,'xs-tools.iso','xs-tools.iso','d50b6bfe-bc2f-4a06-b708-9ee2be4a9707',1,1,'PERHOST',1,64,NULL,'ISO','2013-10-26 06:30:25',NULL,1,NULL,'xen-pv-drv-iso',0,0,1,0,0,0,1,'XenServer',NULL,NULL,0,NULL,'Active',0,NULL,0);
/*!40000 ALTER TABLE `vm_template` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_template_details`
--

DROP TABLE IF EXISTS `vm_template_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_template_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `template_id` bigint(20) unsigned NOT NULL COMMENT 'template id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_vm_template_details__template_id` (`template_id`),
  CONSTRAINT `fk_vm_template_details__template_id` FOREIGN KEY (`template_id`) REFERENCES `vm_template` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_template_details`
--

LOCK TABLES `vm_template_details` WRITE;
/*!40000 ALTER TABLE `vm_template_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_template_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vm_work_job`
--

DROP TABLE IF EXISTS `vm_work_job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vm_work_job` (
  `id` bigint(20) unsigned NOT NULL,
  `step` char(32) NOT NULL COMMENT 'state',
  `vm_type` char(32) NOT NULL COMMENT 'type of vm',
  `vm_instance_id` bigint(20) unsigned NOT NULL COMMENT 'vm instance',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  KEY `fk_vm_work_job__instance_id` (`vm_instance_id`),
  KEY `i_vm_work_job__vm` (`vm_type`,`vm_instance_id`),
  KEY `i_vm_work_job__step` (`step`),
  CONSTRAINT `fk_vm_work_job__instance_id` FOREIGN KEY (`vm_instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vm_work_job`
--

LOCK TABLES `vm_work_job` WRITE;
/*!40000 ALTER TABLE `vm_work_job` DISABLE KEYS */;
/*!40000 ALTER TABLE `vm_work_job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vmware_data_center`
--

DROP TABLE IF EXISTS `vmware_data_center`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vmware_data_center` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(255) DEFAULT NULL,
  `name` varchar(255) NOT NULL COMMENT 'Name of VMware datacenter',
  `guid` varchar(255) NOT NULL COMMENT 'id of VMware datacenter',
  `vcenter_host` varchar(255) NOT NULL COMMENT 'vCenter host containing this VMware datacenter',
  `username` varchar(255) NOT NULL COMMENT 'Name of vCenter host user',
  `password` varchar(255) NOT NULL COMMENT 'Password of vCenter host user',
  PRIMARY KEY (`id`),
  UNIQUE KEY `guid` (`guid`),
  UNIQUE KEY `uuid` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vmware_data_center`
--

LOCK TABLES `vmware_data_center` WRITE;
/*!40000 ALTER TABLE `vmware_data_center` DISABLE KEYS */;
/*!40000 ALTER TABLE `vmware_data_center` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vmware_data_center_zone_map`
--

DROP TABLE IF EXISTS `vmware_data_center_zone_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vmware_data_center_zone_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `zone_id` bigint(20) unsigned NOT NULL COMMENT 'id of CloudStack zone',
  `vmware_data_center_id` bigint(20) unsigned NOT NULL COMMENT 'id of VMware datacenter',
  PRIMARY KEY (`id`),
  UNIQUE KEY `zone_id` (`zone_id`),
  UNIQUE KEY `vmware_data_center_id` (`vmware_data_center_id`),
  CONSTRAINT `fk_vmware_data_center_zone_map__vmware_data_center_id` FOREIGN KEY (`vmware_data_center_id`) REFERENCES `vmware_data_center` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vmware_data_center_zone_map`
--

LOCK TABLES `vmware_data_center_zone_map` WRITE;
/*!40000 ALTER TABLE `vmware_data_center_zone_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `vmware_data_center_zone_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volume_details`
--

DROP TABLE IF EXISTS `volume_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volume_details` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `volume_id` bigint(20) unsigned NOT NULL COMMENT 'volume id',
  `name` varchar(255) NOT NULL,
  `value` varchar(1024) NOT NULL,
  `display_detail` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should detail be displayed to the end user',
  PRIMARY KEY (`id`),
  KEY `fk_volume_details__volume_id` (`volume_id`),
  CONSTRAINT `fk_volume_details__volume_id` FOREIGN KEY (`volume_id`) REFERENCES `volumes` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volume_details`
--

LOCK TABLES `volume_details` WRITE;
/*!40000 ALTER TABLE `volume_details` DISABLE KEYS */;
/*!40000 ALTER TABLE `volume_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volume_host_ref`
--

DROP TABLE IF EXISTS `volume_host_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volume_host_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `host_id` bigint(20) unsigned NOT NULL,
  `volume_id` bigint(20) unsigned NOT NULL,
  `zone_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `download_pct` int(10) unsigned DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL,
  `physical_size` bigint(20) unsigned DEFAULT '0',
  `download_state` varchar(255) DEFAULT NULL,
  `checksum` varchar(255) DEFAULT NULL COMMENT 'checksum for the data disk',
  `error_str` varchar(255) DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  `install_path` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `format` varchar(32) NOT NULL COMMENT 'format for the volume',
  `destroyed` tinyint(1) DEFAULT NULL COMMENT 'indicates whether the volume_host entry was destroyed by the user or not',
  PRIMARY KEY (`id`),
  KEY `i_volume_host_ref__host_id` (`host_id`),
  KEY `i_volume_host_ref__volume_id` (`volume_id`),
  CONSTRAINT `fk_volume_host_ref__host_id` FOREIGN KEY (`host_id`) REFERENCES `host` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_volume_host_ref__volume_id` FOREIGN KEY (`volume_id`) REFERENCES `volumes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volume_host_ref`
--

LOCK TABLES `volume_host_ref` WRITE;
/*!40000 ALTER TABLE `volume_host_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `volume_host_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volume_reservation`
--

DROP TABLE IF EXISTS `volume_reservation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volume_reservation` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `vm_reservation_id` bigint(20) unsigned NOT NULL COMMENT 'id of the vm reservation',
  `vm_id` bigint(20) unsigned NOT NULL COMMENT 'vm id',
  `volume_id` bigint(20) unsigned NOT NULL COMMENT 'volume id',
  `pool_id` bigint(20) unsigned NOT NULL COMMENT 'pool assigned to the volume',
  PRIMARY KEY (`id`),
  KEY `fk_vm_pool_reservation__vm_reservation_id` (`vm_reservation_id`),
  CONSTRAINT `fk_vm_pool_reservation__vm_reservation_id` FOREIGN KEY (`vm_reservation_id`) REFERENCES `vm_reservation` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volume_reservation`
--

LOCK TABLES `volume_reservation` WRITE;
/*!40000 ALTER TABLE `volume_reservation` DISABLE KEYS */;
/*!40000 ALTER TABLE `volume_reservation` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `volume_store_ref`
--

DROP TABLE IF EXISTS `volume_store_ref`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volume_store_ref` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `store_id` bigint(20) unsigned NOT NULL,
  `volume_id` bigint(20) unsigned NOT NULL,
  `zone_id` bigint(20) unsigned NOT NULL,
  `created` datetime NOT NULL,
  `last_updated` datetime DEFAULT NULL,
  `job_id` varchar(255) DEFAULT NULL,
  `download_pct` int(10) unsigned DEFAULT NULL,
  `size` bigint(20) unsigned DEFAULT NULL,
  `physical_size` bigint(20) unsigned DEFAULT '0',
  `download_state` varchar(255) DEFAULT NULL,
  `checksum` varchar(255) DEFAULT NULL COMMENT 'checksum for the data disk',
  `error_str` varchar(255) DEFAULT NULL,
  `local_path` varchar(255) DEFAULT NULL,
  `install_path` varchar(255) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `download_url` varchar(255) DEFAULT NULL,
  `state` varchar(255) NOT NULL,
  `destroyed` tinyint(1) DEFAULT NULL COMMENT 'indicates whether the volume_host entry was destroyed by the user or not',
  `update_count` bigint(20) unsigned DEFAULT NULL,
  `ref_cnt` bigint(20) unsigned DEFAULT NULL,
  `updated` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `i_volume_store_ref__store_id` (`store_id`),
  KEY `i_volume_store_ref__volume_id` (`volume_id`),
  CONSTRAINT `fk_volume_store_ref__store_id` FOREIGN KEY (`store_id`) REFERENCES `image_store` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_volume_store_ref__volume_id` FOREIGN KEY (`volume_id`) REFERENCES `volumes` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volume_store_ref`
--

LOCK TABLES `volume_store_ref` WRITE;
/*!40000 ALTER TABLE `volume_store_ref` DISABLE KEYS */;
/*!40000 ALTER TABLE `volume_store_ref` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Temporary table structure for view `volume_view`
--

DROP TABLE IF EXISTS `volume_view`;
/*!50001 DROP VIEW IF EXISTS `volume_view`*/;
SET @saved_cs_client     = @@character_set_client;
SET character_set_client = utf8;
/*!50001 CREATE TABLE `volume_view` (
  `id` tinyint NOT NULL,
  `uuid` tinyint NOT NULL,
  `name` tinyint NOT NULL,
  `device_id` tinyint NOT NULL,
  `volume_type` tinyint NOT NULL,
  `size` tinyint NOT NULL,
  `min_iops` tinyint NOT NULL,
  `max_iops` tinyint NOT NULL,
  `created` tinyint NOT NULL,
  `state` tinyint NOT NULL,
  `attached` tinyint NOT NULL,
  `removed` tinyint NOT NULL,
  `pod_id` tinyint NOT NULL,
  `display_volume` tinyint NOT NULL,
  `format` tinyint NOT NULL,
  `path` tinyint NOT NULL,
  `account_id` tinyint NOT NULL,
  `account_uuid` tinyint NOT NULL,
  `account_name` tinyint NOT NULL,
  `account_type` tinyint NOT NULL,
  `domain_id` tinyint NOT NULL,
  `domain_uuid` tinyint NOT NULL,
  `domain_name` tinyint NOT NULL,
  `domain_path` tinyint NOT NULL,
  `project_id` tinyint NOT NULL,
  `project_uuid` tinyint NOT NULL,
  `project_name` tinyint NOT NULL,
  `data_center_id` tinyint NOT NULL,
  `data_center_uuid` tinyint NOT NULL,
  `data_center_name` tinyint NOT NULL,
  `data_center_type` tinyint NOT NULL,
  `vm_id` tinyint NOT NULL,
  `vm_uuid` tinyint NOT NULL,
  `vm_name` tinyint NOT NULL,
  `vm_state` tinyint NOT NULL,
  `vm_type` tinyint NOT NULL,
  `vm_display_name` tinyint NOT NULL,
  `volume_store_size` tinyint NOT NULL,
  `download_pct` tinyint NOT NULL,
  `download_state` tinyint NOT NULL,
  `error_str` tinyint NOT NULL,
  `created_on_store` tinyint NOT NULL,
  `disk_offering_id` tinyint NOT NULL,
  `disk_offering_uuid` tinyint NOT NULL,
  `disk_offering_name` tinyint NOT NULL,
  `disk_offering_display_text` tinyint NOT NULL,
  `use_local_storage` tinyint NOT NULL,
  `system_use` tinyint NOT NULL,
  `bytes_read_rate` tinyint NOT NULL,
  `bytes_write_rate` tinyint NOT NULL,
  `iops_read_rate` tinyint NOT NULL,
  `iops_write_rate` tinyint NOT NULL,
  `pool_id` tinyint NOT NULL,
  `pool_uuid` tinyint NOT NULL,
  `pool_name` tinyint NOT NULL,
  `hypervisor_type` tinyint NOT NULL,
  `template_id` tinyint NOT NULL,
  `template_uuid` tinyint NOT NULL,
  `extractable` tinyint NOT NULL,
  `template_type` tinyint NOT NULL,
  `tag_id` tinyint NOT NULL,
  `tag_uuid` tinyint NOT NULL,
  `tag_key` tinyint NOT NULL,
  `tag_value` tinyint NOT NULL,
  `tag_domain_id` tinyint NOT NULL,
  `tag_account_id` tinyint NOT NULL,
  `tag_resource_id` tinyint NOT NULL,
  `tag_resource_uuid` tinyint NOT NULL,
  `tag_resource_type` tinyint NOT NULL,
  `tag_customer` tinyint NOT NULL,
  `job_id` tinyint NOT NULL,
  `job_uuid` tinyint NOT NULL,
  `job_status` tinyint NOT NULL,
  `job_account_id` tinyint NOT NULL
) ENGINE=MyISAM */;
SET character_set_client = @saved_cs_client;

--
-- Table structure for table `volumes`
--

DROP TABLE IF EXISTS `volumes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `volumes` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'Primary Key',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner.  foreign key to account table',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'the domain that the owner belongs to',
  `pool_id` bigint(20) unsigned DEFAULT NULL COMMENT 'pool it belongs to. foreign key to storage_pool table',
  `last_pool_id` bigint(20) unsigned DEFAULT NULL COMMENT 'last pool it belongs to.',
  `instance_id` bigint(20) unsigned DEFAULT NULL COMMENT 'vm instance it belongs to. foreign key to vm_instance table',
  `device_id` bigint(20) unsigned DEFAULT NULL COMMENT 'which device inside vm instance it is ',
  `name` varchar(255) DEFAULT NULL COMMENT 'A user specified name for the volume',
  `uuid` varchar(40) DEFAULT NULL,
  `size` bigint(20) unsigned NOT NULL COMMENT 'total size',
  `folder` varchar(255) DEFAULT NULL COMMENT 'The folder where the volume is saved',
  `path` varchar(255) DEFAULT NULL COMMENT 'Path',
  `pod_id` bigint(20) unsigned DEFAULT NULL COMMENT 'pod this volume belongs to',
  `data_center_id` bigint(20) unsigned NOT NULL COMMENT 'data center this volume belongs to',
  `iscsi_name` varchar(255) DEFAULT NULL COMMENT 'iscsi target name',
  `host_ip` char(40) DEFAULT NULL COMMENT 'host ip address for convenience',
  `volume_type` varchar(64) NOT NULL COMMENT 'root, swap or data',
  `pool_type` varchar(64) DEFAULT NULL COMMENT 'type of the pool',
  `disk_offering_id` bigint(20) unsigned NOT NULL COMMENT 'can be null for system VMs',
  `template_id` bigint(20) unsigned DEFAULT NULL COMMENT 'fk to vm_template.id',
  `first_snapshot_backup_uuid` varchar(255) DEFAULT NULL COMMENT 'The first snapshot that was ever taken for this volume',
  `recreatable` tinyint(1) unsigned NOT NULL DEFAULT '0' COMMENT 'Is this volume recreatable?',
  `created` datetime DEFAULT NULL COMMENT 'Date Created',
  `attached` datetime DEFAULT NULL COMMENT 'Date Attached',
  `updated` datetime DEFAULT NULL COMMENT 'Date updated for attach/detach',
  `removed` datetime DEFAULT NULL COMMENT 'Date removed.  not null if removed',
  `state` varchar(32) DEFAULT NULL COMMENT 'State machine',
  `chain_info` text COMMENT 'save possible disk chain info in primary storage',
  `update_count` bigint(20) unsigned NOT NULL DEFAULT '0' COMMENT 'date state was updated',
  `disk_type` varchar(255) DEFAULT NULL,
  `vm_snapshot_chain_size` bigint(20) unsigned DEFAULT NULL,
  `iso_id` bigint(20) unsigned DEFAULT NULL,
  `display_volume` tinyint(1) NOT NULL DEFAULT '1' COMMENT 'Should volume be displayed to the end user',
  `format` varchar(255) DEFAULT NULL COMMENT 'volume format',
  `min_iops` bigint(20) unsigned DEFAULT NULL COMMENT 'Minimum IOPS',
  `max_iops` bigint(20) unsigned DEFAULT NULL COMMENT 'Maximum IOPS',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_volumes__uuid` (`uuid`),
  KEY `i_volumes__removed` (`removed`),
  KEY `i_volumes__pod_id` (`pod_id`),
  KEY `i_volumes__data_center_id` (`data_center_id`),
  KEY `i_volumes__account_id` (`account_id`),
  KEY `i_volumes__pool_id` (`pool_id`),
  KEY `i_volumes__last_pool_id` (`last_pool_id`),
  KEY `i_volumes__instance_id` (`instance_id`),
  KEY `i_volumes__state` (`state`),
  KEY `i_volumes__update_count` (`update_count`),
  CONSTRAINT `fk_volumes__instance_id` FOREIGN KEY (`instance_id`) REFERENCES `vm_instance` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_volumes__pool_id` FOREIGN KEY (`pool_id`) REFERENCES `storage_pool` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `volumes`
--

LOCK TABLES `volumes` WRITE;
/*!40000 ALTER TABLE `volumes` DISABLE KEYS */;
INSERT INTO `volumes` VALUES (1,1,1,NULL,NULL,1,0,'ROOT-1','84ef5510-0098-454d-b60e-922ddc754ce6',0,NULL,NULL,NULL,1,NULL,NULL,'ROOT',NULL,27,1,NULL,1,'2013-10-26 06:37:25',NULL,NULL,NULL,'Allocated',NULL,0,NULL,NULL,NULL,0,'VHD',NULL,NULL),(2,1,1,NULL,NULL,2,0,'ROOT-2','75e54265-f4a2-4e41-a8d7-ec2de2e97b88',0,NULL,NULL,NULL,1,NULL,NULL,'ROOT',NULL,29,1,NULL,1,'2013-10-26 06:37:25',NULL,NULL,NULL,'Allocated',NULL,0,NULL,NULL,NULL,0,'VHD',NULL,NULL);
/*!40000 ALTER TABLE `volumes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpc`
--

DROP TABLE IF EXISTS `vpc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpc` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT 'vpc name',
  `display_text` varchar(255) DEFAULT NULL COMMENT 'vpc display text',
  `cidr` varchar(18) DEFAULT NULL COMMENT 'vpc cidr',
  `vpc_offering_id` bigint(20) unsigned NOT NULL COMMENT 'vpc offering id that this vpc is created from',
  `zone_id` bigint(20) unsigned NOT NULL COMMENT 'the id of the zone this Vpc belongs to',
  `state` varchar(32) NOT NULL COMMENT 'state of the VP (can be Enabled and Disabled)',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain the vpc belongs to',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner of this vpc',
  `network_domain` varchar(255) DEFAULT NULL COMMENT 'network domain',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `created` datetime NOT NULL COMMENT 'date created',
  `restart_required` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if restart is required for the VPC',
  PRIMARY KEY (`id`),
  KEY `i_vpc__removed` (`removed`),
  KEY `fk_vpc__zone_id` (`zone_id`),
  KEY `fk_vpc__vpc_offering_id` (`vpc_offering_id`),
  KEY `fk_vpc__account_id` (`account_id`),
  KEY `fk_vpc__domain_id` (`domain_id`),
  CONSTRAINT `fk_vpc__zone_id` FOREIGN KEY (`zone_id`) REFERENCES `data_center` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_vpc__vpc_offering_id` FOREIGN KEY (`vpc_offering_id`) REFERENCES `vpc_offerings` (`id`),
  CONSTRAINT `fk_vpc__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_vpc__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpc`
--

LOCK TABLES `vpc` WRITE;
/*!40000 ALTER TABLE `vpc` DISABLE KEYS */;
/*!40000 ALTER TABLE `vpc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpc_gateways`
--

DROP TABLE IF EXISTS `vpc_gateways`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpc_gateways` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) DEFAULT NULL,
  `ip4_address` char(40) DEFAULT NULL COMMENT 'ip4 address of the gateway',
  `netmask` varchar(15) DEFAULT NULL COMMENT 'netmask of the gateway',
  `gateway` varchar(15) DEFAULT NULL COMMENT 'gateway',
  `vlan_tag` varchar(255) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL COMMENT 'type of gateway; can be Public/Private/Vpn',
  `network_id` bigint(20) unsigned NOT NULL COMMENT 'network id vpc gateway belongs to',
  `vpc_id` bigint(20) unsigned NOT NULL COMMENT 'id of the vpc the gateway belongs to',
  `zone_id` bigint(20) unsigned NOT NULL COMMENT 'id of the zone the gateway belongs to',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  `account_id` bigint(20) unsigned NOT NULL COMMENT 'owner id',
  `domain_id` bigint(20) unsigned NOT NULL COMMENT 'domain id',
  `state` varchar(32) NOT NULL COMMENT 'what state the vpc gateway in',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `source_nat` tinyint(1) DEFAULT '0',
  `network_acl_id` bigint(20) unsigned NOT NULL DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `uc_vpc_gateways__uuid` (`uuid`),
  KEY `fk_vpc_gateways__network_id` (`network_id`),
  KEY `fk_vpc_gateways__vpc_id` (`vpc_id`),
  KEY `fk_vpc_gateways__zone_id` (`zone_id`),
  KEY `fk_vpc_gateways__account_id` (`account_id`),
  KEY `fk_vpc_gateways__domain_id` (`domain_id`),
  KEY `i_vpc_gateways__removed` (`removed`),
  CONSTRAINT `fk_vpc_gateways__account_id` FOREIGN KEY (`account_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_vpc_gateways__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_vpc_gateways__network_id` FOREIGN KEY (`network_id`) REFERENCES `networks` (`id`),
  CONSTRAINT `fk_vpc_gateways__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`),
  CONSTRAINT `fk_vpc_gateways__zone_id` FOREIGN KEY (`zone_id`) REFERENCES `data_center` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpc_gateways`
--

LOCK TABLES `vpc_gateways` WRITE;
/*!40000 ALTER TABLE `vpc_gateways` DISABLE KEYS */;
/*!40000 ALTER TABLE `vpc_gateways` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpc_offering_service_map`
--

DROP TABLE IF EXISTS `vpc_offering_service_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpc_offering_service_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vpc_offering_id` bigint(20) unsigned NOT NULL COMMENT 'vpc_offering_id',
  `service` varchar(255) NOT NULL COMMENT 'service',
  `provider` varchar(255) DEFAULT NULL COMMENT 'service provider',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vpc_offering_id` (`vpc_offering_id`,`service`,`provider`),
  CONSTRAINT `fk_vpc_offering_service_map__vpc_offering_id` FOREIGN KEY (`vpc_offering_id`) REFERENCES `vpc_offerings` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpc_offering_service_map`
--

LOCK TABLES `vpc_offering_service_map` WRITE;
/*!40000 ALTER TABLE `vpc_offering_service_map` DISABLE KEYS */;
INSERT INTO `vpc_offering_service_map` VALUES (1,1,'NetworkACL','VpcVirtualRouter','2013-10-26 06:30:24'),(2,1,'PortForwarding','VpcVirtualRouter','2013-10-26 06:30:24'),(3,1,'UserData','VpcVirtualRouter','2013-10-26 06:30:24'),(4,1,'Dns','VpcVirtualRouter','2013-10-26 06:30:24'),(5,1,'Vpn','VpcVirtualRouter','2013-10-26 06:30:24'),(6,1,'SourceNat','VpcVirtualRouter','2013-10-26 06:30:24'),(7,1,'Lb','VpcVirtualRouter','2013-10-26 06:30:24'),(8,1,'Lb','InternalLbVm','2013-10-26 06:30:24'),(9,1,'StaticNat','VpcVirtualRouter','2013-10-26 06:30:24'),(10,1,'Gateway','VpcVirtualRouter','2013-10-26 06:30:24'),(11,1,'Dhcp','VpcVirtualRouter','2013-10-26 06:30:24'),(12,2,'NetworkACL','VpcVirtualRouter','2013-10-26 06:30:24'),(13,2,'PortForwarding','VpcVirtualRouter','2013-10-26 06:30:25'),(14,2,'UserData','VpcVirtualRouter','2013-10-26 06:30:25'),(15,2,'Dns','VpcVirtualRouter','2013-10-26 06:30:25'),(16,2,'Vpn','VpcVirtualRouter','2013-10-26 06:30:25'),(17,2,'SourceNat','VpcVirtualRouter','2013-10-26 06:30:25'),(18,2,'Lb','InternalLbVm','2013-10-26 06:30:25'),(19,2,'Lb','Netscaler','2013-10-26 06:30:25'),(20,2,'StaticNat','VpcVirtualRouter','2013-10-26 06:30:25'),(21,2,'Gateway','VpcVirtualRouter','2013-10-26 06:30:25'),(22,2,'Dhcp','VpcVirtualRouter','2013-10-26 06:30:25');
/*!40000 ALTER TABLE `vpc_offering_service_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpc_offerings`
--

DROP TABLE IF EXISTS `vpc_offerings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpc_offerings` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT 'id',
  `uuid` varchar(40) NOT NULL,
  `unique_name` varchar(64) DEFAULT NULL COMMENT 'unique name of the vpc offering',
  `name` varchar(255) DEFAULT NULL COMMENT 'vpc name',
  `display_text` varchar(255) DEFAULT NULL COMMENT 'display text',
  `state` char(32) DEFAULT NULL COMMENT 'state of the vpc offering that has Disabled value by default',
  `default` int(1) unsigned NOT NULL DEFAULT '0' COMMENT '1 if vpc offering is default',
  `removed` datetime DEFAULT NULL COMMENT 'date removed if not null',
  `created` datetime NOT NULL COMMENT 'date created',
  `service_offering_id` bigint(20) unsigned DEFAULT NULL COMMENT 'service offering id that virtual router is tied to',
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_name` (`unique_name`),
  KEY `i_vpc__removed` (`removed`),
  KEY `fk_vpc_offerings__service_offering_id` (`service_offering_id`),
  CONSTRAINT `fk_vpc_offerings__service_offering_id` FOREIGN KEY (`service_offering_id`) REFERENCES `service_offering` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpc_offerings`
--

LOCK TABLES `vpc_offerings` WRITE;
/*!40000 ALTER TABLE `vpc_offerings` DISABLE KEYS */;
INSERT INTO `vpc_offerings` VALUES (1,'ec4b6d1b-af92-4c3f-b11e-3ffb37444ae2','Default VPC offering','Default VPC offering','Default VPC offering','Enabled',1,NULL,'2013-10-26 06:30:24',NULL),(2,'cb890842-68c1-405d-ae10-62f879c2cabf','Default VPC  offering with Netscaler','Default VPC  offering with Netscaler','Default VPC  offering with Netscaler','Enabled',0,NULL,'2013-10-26 06:30:24',NULL);
/*!40000 ALTER TABLE `vpc_offerings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpc_service_map`
--

DROP TABLE IF EXISTS `vpc_service_map`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpc_service_map` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `vpc_id` bigint(20) unsigned NOT NULL COMMENT 'vpc_id',
  `service` varchar(255) NOT NULL COMMENT 'service',
  `provider` varchar(255) DEFAULT NULL COMMENT 'service provider',
  `created` datetime DEFAULT NULL COMMENT 'date created',
  PRIMARY KEY (`id`),
  UNIQUE KEY `vpc_id` (`vpc_id`,`service`,`provider`),
  CONSTRAINT `fk_vpc_service_map__vpc_id` FOREIGN KEY (`vpc_id`) REFERENCES `vpc` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpc_service_map`
--

LOCK TABLES `vpc_service_map` WRITE;
/*!40000 ALTER TABLE `vpc_service_map` DISABLE KEYS */;
/*!40000 ALTER TABLE `vpc_service_map` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vpn_users`
--

DROP TABLE IF EXISTS `vpn_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vpn_users` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `uuid` varchar(40) DEFAULT NULL,
  `owner_id` bigint(20) unsigned NOT NULL,
  `domain_id` bigint(20) unsigned NOT NULL,
  `username` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `state` char(32) NOT NULL COMMENT 'What state is this vpn user in',
  PRIMARY KEY (`id`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `i_vpn_users__account_id__username` (`owner_id`,`username`),
  UNIQUE KEY `uc_vpn_users__uuid` (`uuid`),
  KEY `fk_vpn_users__domain_id` (`domain_id`),
  KEY `i_vpn_users_username` (`username`),
  CONSTRAINT `fk_vpn_users__owner_id` FOREIGN KEY (`owner_id`) REFERENCES `account` (`id`) ON DELETE CASCADE,
  CONSTRAINT `fk_vpn_users__domain_id` FOREIGN KEY (`domain_id`) REFERENCES `domain` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vpn_users`
--

LOCK TABLES `vpn_users` WRITE;
/*!40000 ALTER TABLE `vpn_users` DISABLE KEYS */;
/*!40000 ALTER TABLE `vpn_users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Final view structure for view `account_netstats_view`
--

/*!50001 DROP TABLE IF EXISTS `account_netstats_view`*/;
/*!50001 DROP VIEW IF EXISTS `account_netstats_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `account_netstats_view` AS select `user_statistics`.`account_id` AS `account_id`,(sum(`user_statistics`.`net_bytes_received`) + sum(`user_statistics`.`current_bytes_received`)) AS `bytesReceived`,(sum(`user_statistics`.`net_bytes_sent`) + sum(`user_statistics`.`current_bytes_sent`)) AS `bytesSent` from `user_statistics` group by `user_statistics`.`account_id` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `account_view`
--

/*!50001 DROP TABLE IF EXISTS `account_view`*/;
/*!50001 DROP VIEW IF EXISTS `account_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `account_view` AS select `account`.`id` AS `id`,`account`.`uuid` AS `uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `type`,`account`.`state` AS `state`,`account`.`removed` AS `removed`,`account`.`cleanup_needed` AS `cleanup_needed`,`account`.`network_domain` AS `network_domain`,`account`.`default` AS `default`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`account_netstats_view`.`bytesReceived` AS `bytesReceived`,`account_netstats_view`.`bytesSent` AS `bytesSent`,`vmlimit`.`max` AS `vmLimit`,`vmcount`.`count` AS `vmTotal`,`runningvm`.`vmcount` AS `runningVms`,`stoppedvm`.`vmcount` AS `stoppedVms`,`iplimit`.`max` AS `ipLimit`,`ipcount`.`count` AS `ipTotal`,`free_ip_view`.`free_ip` AS `ipFree`,`volumelimit`.`max` AS `volumeLimit`,`volumecount`.`count` AS `volumeTotal`,`snapshotlimit`.`max` AS `snapshotLimit`,`snapshotcount`.`count` AS `snapshotTotal`,`templatelimit`.`max` AS `templateLimit`,`templatecount`.`count` AS `templateTotal`,`vpclimit`.`max` AS `vpcLimit`,`vpccount`.`count` AS `vpcTotal`,`projectlimit`.`max` AS `projectLimit`,`projectcount`.`count` AS `projectTotal`,`networklimit`.`max` AS `networkLimit`,`networkcount`.`count` AS `networkTotal`,`cpulimit`.`max` AS `cpuLimit`,`cpucount`.`count` AS `cpuTotal`,`memorylimit`.`max` AS `memoryLimit`,`memorycount`.`count` AS `memoryTotal`,`primary_storage_limit`.`max` AS `primaryStorageLimit`,`primary_storage_count`.`count` AS `primaryStorageTotal`,`secondary_storage_limit`.`max` AS `secondaryStorageLimit`,`secondary_storage_count`.`count` AS `secondaryStorageTotal`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id` from (`free_ip_view` join ((((((((((((((((((((((((((((((`account` join `domain` on((`account`.`domain_id` = `domain`.`id`))) left join `data_center` on((`account`.`default_zone_id` = `data_center`.`id`))) left join `account_netstats_view` on((`account`.`id` = `account_netstats_view`.`account_id`))) left join `resource_limit` `vmlimit` on(((`account`.`id` = `vmlimit`.`account_id`) and (`vmlimit`.`type` = 'user_vm')))) left join `resource_count` `vmcount` on(((`account`.`id` = `vmcount`.`account_id`) and (`vmcount`.`type` = 'user_vm')))) left join `account_vmstats_view` `runningvm` on(((`account`.`id` = `runningvm`.`account_id`) and (`runningvm`.`state` = 'Running')))) left join `account_vmstats_view` `stoppedvm` on(((`account`.`id` = `stoppedvm`.`account_id`) and (`stoppedvm`.`state` = 'Stopped')))) left join `resource_limit` `iplimit` on(((`account`.`id` = `iplimit`.`account_id`) and (`iplimit`.`type` = 'public_ip')))) left join `resource_count` `ipcount` on(((`account`.`id` = `ipcount`.`account_id`) and (`ipcount`.`type` = 'public_ip')))) left join `resource_limit` `volumelimit` on(((`account`.`id` = `volumelimit`.`account_id`) and (`volumelimit`.`type` = 'volume')))) left join `resource_count` `volumecount` on(((`account`.`id` = `volumecount`.`account_id`) and (`volumecount`.`type` = 'volume')))) left join `resource_limit` `snapshotlimit` on(((`account`.`id` = `snapshotlimit`.`account_id`) and (`snapshotlimit`.`type` = 'snapshot')))) left join `resource_count` `snapshotcount` on(((`account`.`id` = `snapshotcount`.`account_id`) and (`snapshotcount`.`type` = 'snapshot')))) left join `resource_limit` `templatelimit` on(((`account`.`id` = `templatelimit`.`account_id`) and (`templatelimit`.`type` = 'template')))) left join `resource_count` `templatecount` on(((`account`.`id` = `templatecount`.`account_id`) and (`templatecount`.`type` = 'template')))) left join `resource_limit` `vpclimit` on(((`account`.`id` = `vpclimit`.`account_id`) and (`vpclimit`.`type` = 'vpc')))) left join `resource_count` `vpccount` on(((`account`.`id` = `vpccount`.`account_id`) and (`vpccount`.`type` = 'vpc')))) left join `resource_limit` `projectlimit` on(((`account`.`id` = `projectlimit`.`account_id`) and (`projectlimit`.`type` = 'project')))) left join `resource_count` `projectcount` on(((`account`.`id` = `projectcount`.`account_id`) and (`projectcount`.`type` = 'project')))) left join `resource_limit` `networklimit` on(((`account`.`id` = `networklimit`.`account_id`) and (`networklimit`.`type` = 'network')))) left join `resource_count` `networkcount` on(((`account`.`id` = `networkcount`.`account_id`) and (`networkcount`.`type` = 'network')))) left join `resource_limit` `cpulimit` on(((`account`.`id` = `cpulimit`.`account_id`) and (`cpulimit`.`type` = 'cpu')))) left join `resource_count` `cpucount` on(((`account`.`id` = `cpucount`.`account_id`) and (`cpucount`.`type` = 'cpu')))) left join `resource_limit` `memorylimit` on(((`account`.`id` = `memorylimit`.`account_id`) and (`memorylimit`.`type` = 'memory')))) left join `resource_count` `memorycount` on(((`account`.`id` = `memorycount`.`account_id`) and (`memorycount`.`type` = 'memory')))) left join `resource_limit` `primary_storage_limit` on(((`account`.`id` = `primary_storage_limit`.`account_id`) and (`primary_storage_limit`.`type` = 'primary_storage')))) left join `resource_count` `primary_storage_count` on(((`account`.`id` = `primary_storage_count`.`account_id`) and (`primary_storage_count`.`type` = 'primary_storage')))) left join `resource_limit` `secondary_storage_limit` on(((`account`.`id` = `secondary_storage_limit`.`account_id`) and (`secondary_storage_limit`.`type` = 'secondary_storage')))) left join `resource_count` `secondary_storage_count` on(((`account`.`id` = `secondary_storage_count`.`account_id`) and (`secondary_storage_count`.`type` = 'secondary_storage')))) left join `async_job` on(((`async_job`.`instance_id` = `account`.`id`) and (`async_job`.`instance_type` = 'Account') and (`async_job`.`job_status` = 0))))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `account_vmstats_view`
--

/*!50001 DROP TABLE IF EXISTS `account_vmstats_view`*/;
/*!50001 DROP VIEW IF EXISTS `account_vmstats_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `account_vmstats_view` AS select `vm_instance`.`account_id` AS `account_id`,`vm_instance`.`state` AS `state`,count(0) AS `vmcount` from `vm_instance` where (`vm_instance`.`vm_type` = 'User') group by `vm_instance`.`account_id`,`vm_instance`.`state` */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `affinity_group_view`
--

/*!50001 DROP TABLE IF EXISTS `affinity_group_view`*/;
/*!50001 DROP VIEW IF EXISTS `affinity_group_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `affinity_group_view` AS select `affinity_group`.`id` AS `id`,`affinity_group`.`name` AS `name`,`affinity_group`.`type` AS `type`,`affinity_group`.`description` AS `description`,`affinity_group`.`uuid` AS `uuid`,`affinity_group`.`acl_type` AS `acl_type`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`vm_instance`.`id` AS `vm_id`,`vm_instance`.`uuid` AS `vm_uuid`,`vm_instance`.`name` AS `vm_name`,`vm_instance`.`state` AS `vm_state`,`user_vm`.`display_name` AS `vm_display_name` from (((((`affinity_group` join `account` on((`affinity_group`.`account_id` = `account`.`id`))) join `domain` on((`affinity_group`.`domain_id` = `domain`.`id`))) left join `affinity_group_vm_map` on((`affinity_group`.`id` = `affinity_group_vm_map`.`affinity_group_id`))) left join `vm_instance` on((`vm_instance`.`id` = `affinity_group_vm_map`.`instance_id`))) left join `user_vm` on((`user_vm`.`id` = `vm_instance`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `async_job_view`
--

/*!50001 DROP TABLE IF EXISTS `async_job_view`*/;
/*!50001 DROP VIEW IF EXISTS `async_job_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `async_job_view` AS select `account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`user`.`id` AS `user_id`,`user`.`uuid` AS `user_uuid`,`async_job`.`id` AS `id`,`async_job`.`uuid` AS `uuid`,`async_job`.`job_cmd` AS `job_cmd`,`async_job`.`job_status` AS `job_status`,`async_job`.`job_process_status` AS `job_process_status`,`async_job`.`job_result_code` AS `job_result_code`,`async_job`.`job_result` AS `job_result`,`async_job`.`created` AS `created`,`async_job`.`removed` AS `removed`,`async_job`.`instance_type` AS `instance_type`,`async_job`.`instance_id` AS `instance_id`,(case when (`async_job`.`instance_type` = 'Volume') then `volumes`.`uuid` when ((`async_job`.`instance_type` = 'Template') or (`async_job`.`instance_type` = 'Iso')) then `vm_template`.`uuid` when ((`async_job`.`instance_type` = 'VirtualMachine') or (`async_job`.`instance_type` = 'ConsoleProxy') or (`async_job`.`instance_type` = 'SystemVm') or (`async_job`.`instance_type` = 'DomainRouter')) then `vm_instance`.`uuid` when (`async_job`.`instance_type` = 'Snapshot') then `snapshots`.`uuid` when (`async_job`.`instance_type` = 'Host') then `host`.`uuid` when (`async_job`.`instance_type` = 'StoragePool') then `storage_pool`.`uuid` when (`async_job`.`instance_type` = 'IpAddress') then `user_ip_address`.`uuid` when (`async_job`.`instance_type` = 'SecurityGroup') then `security_group`.`uuid` when (`async_job`.`instance_type` = 'PhysicalNetwork') then `physical_network`.`uuid` when (`async_job`.`instance_type` = 'TrafficType') then `physical_network_traffic_types`.`uuid` when (`async_job`.`instance_type` = 'PhysicalNetworkServiceProvider') then `physical_network_service_providers`.`uuid` when (`async_job`.`instance_type` = 'FirewallRule') then `firewall_rules`.`uuid` when (`async_job`.`instance_type` = 'Account') then `acct`.`uuid` when (`async_job`.`instance_type` = 'User') then `us`.`uuid` when (`async_job`.`instance_type` = 'StaticRoute') then `static_routes`.`uuid` when (`async_job`.`instance_type` = 'PrivateGateway') then `vpc_gateways`.`uuid` when (`async_job`.`instance_type` = 'Counter') then `counter`.`uuid` when (`async_job`.`instance_type` = 'Condition') then `conditions`.`uuid` when (`async_job`.`instance_type` = 'AutoScalePolicy') then `autoscale_policies`.`uuid` when (`async_job`.`instance_type` = 'AutoScaleVmProfile') then `autoscale_vmprofiles`.`uuid` when (`async_job`.`instance_type` = 'AutoScaleVmGroup') then `autoscale_vmgroups`.`uuid` else NULL end) AS `instance_uuid` from ((((((((((((((((((((((((`async_job` left join `account` on((`async_job`.`account_id` = `account`.`id`))) left join `domain` on((`domain`.`id` = `account`.`domain_id`))) left join `user` on((`async_job`.`user_id` = `user`.`id`))) left join `volumes` on((`async_job`.`instance_id` = `volumes`.`id`))) left join `vm_template` on((`async_job`.`instance_id` = `vm_template`.`id`))) left join `vm_instance` on((`async_job`.`instance_id` = `vm_instance`.`id`))) left join `snapshots` on((`async_job`.`instance_id` = `snapshots`.`id`))) left join `host` on((`async_job`.`instance_id` = `host`.`id`))) left join `storage_pool` on((`async_job`.`instance_id` = `storage_pool`.`id`))) left join `user_ip_address` on((`async_job`.`instance_id` = `user_ip_address`.`id`))) left join `security_group` on((`async_job`.`instance_id` = `security_group`.`id`))) left join `physical_network` on((`async_job`.`instance_id` = `physical_network`.`id`))) left join `physical_network_traffic_types` on((`async_job`.`instance_id` = `physical_network_traffic_types`.`id`))) left join `physical_network_service_providers` on((`async_job`.`instance_id` = `physical_network_service_providers`.`id`))) left join `firewall_rules` on((`async_job`.`instance_id` = `firewall_rules`.`id`))) left join `account` `acct` on((`async_job`.`instance_id` = `acct`.`id`))) left join `user` `us` on((`async_job`.`instance_id` = `us`.`id`))) left join `static_routes` on((`async_job`.`instance_id` = `static_routes`.`id`))) left join `vpc_gateways` on((`async_job`.`instance_id` = `vpc_gateways`.`id`))) left join `counter` on((`async_job`.`instance_id` = `counter`.`id`))) left join `conditions` on((`async_job`.`instance_id` = `conditions`.`id`))) left join `autoscale_policies` on((`async_job`.`instance_id` = `autoscale_policies`.`id`))) left join `autoscale_vmprofiles` on((`async_job`.`instance_id` = `autoscale_vmprofiles`.`id`))) left join `autoscale_vmgroups` on((`async_job`.`instance_id` = `autoscale_vmgroups`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `data_center_view`
--

/*!50001 DROP TABLE IF EXISTS `data_center_view`*/;
/*!50001 DROP VIEW IF EXISTS `data_center_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `data_center_view` AS select `data_center`.`id` AS `id`,`data_center`.`uuid` AS `uuid`,`data_center`.`name` AS `name`,`data_center`.`is_security_group_enabled` AS `is_security_group_enabled`,`data_center`.`is_local_storage_enabled` AS `is_local_storage_enabled`,`data_center`.`description` AS `description`,`data_center`.`dns1` AS `dns1`,`data_center`.`dns2` AS `dns2`,`data_center`.`ip6_dns1` AS `ip6_dns1`,`data_center`.`ip6_dns2` AS `ip6_dns2`,`data_center`.`internal_dns1` AS `internal_dns1`,`data_center`.`internal_dns2` AS `internal_dns2`,`data_center`.`guest_network_cidr` AS `guest_network_cidr`,`data_center`.`domain` AS `domain`,`data_center`.`networktype` AS `networktype`,`data_center`.`allocation_state` AS `allocation_state`,`data_center`.`zone_token` AS `zone_token`,`data_center`.`dhcp_provider` AS `dhcp_provider`,`data_center`.`removed` AS `removed`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`dedicated_resources`.`affinity_group_id` AS `affinity_group_id`,`dedicated_resources`.`account_id` AS `account_id`,`affinity_group`.`uuid` AS `affinity_group_uuid` from (((`data_center` left join `domain` on((`data_center`.`domain_id` = `domain`.`id`))) left join `dedicated_resources` on((`data_center`.`id` = `dedicated_resources`.`data_center_id`))) left join `affinity_group` on((`dedicated_resources`.`affinity_group_id` = `affinity_group`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `disk_offering_view`
--

/*!50001 DROP TABLE IF EXISTS `disk_offering_view`*/;
/*!50001 DROP VIEW IF EXISTS `disk_offering_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `disk_offering_view` AS select `disk_offering`.`id` AS `id`,`disk_offering`.`uuid` AS `uuid`,`disk_offering`.`name` AS `name`,`disk_offering`.`display_text` AS `display_text`,`disk_offering`.`disk_size` AS `disk_size`,`disk_offering`.`min_iops` AS `min_iops`,`disk_offering`.`max_iops` AS `max_iops`,`disk_offering`.`created` AS `created`,`disk_offering`.`tags` AS `tags`,`disk_offering`.`customized` AS `customized`,`disk_offering`.`customized_iops` AS `customized_iops`,`disk_offering`.`removed` AS `removed`,`disk_offering`.`use_local_storage` AS `use_local_storage`,`disk_offering`.`system_use` AS `system_use`,`disk_offering`.`bytes_read_rate` AS `bytes_read_rate`,`disk_offering`.`bytes_write_rate` AS `bytes_write_rate`,`disk_offering`.`iops_read_rate` AS `iops_read_rate`,`disk_offering`.`iops_write_rate` AS `iops_write_rate`,`disk_offering`.`sort_key` AS `sort_key`,`disk_offering`.`type` AS `type`,`disk_offering`.`display_offering` AS `display_offering`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path` from (`disk_offering` left join `domain` on((`disk_offering`.`domain_id` = `domain`.`id`))) where (`disk_offering`.`state` = 'ACTIVE') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `domain_router_view`
--

/*!50001 DROP TABLE IF EXISTS `domain_router_view`*/;
/*!50001 DROP VIEW IF EXISTS `domain_router_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `domain_router_view` AS select `vm_instance`.`id` AS `id`,`vm_instance`.`name` AS `name`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name`,`vm_instance`.`uuid` AS `uuid`,`vm_instance`.`created` AS `created`,`vm_instance`.`state` AS `state`,`vm_instance`.`removed` AS `removed`,`vm_instance`.`pod_id` AS `pod_id`,`vm_instance`.`instance_name` AS `instance_name`,`host_pod_ref`.`uuid` AS `pod_uuid`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`data_center`.`networktype` AS `data_center_type`,`data_center`.`dns1` AS `dns1`,`data_center`.`dns2` AS `dns2`,`data_center`.`ip6_dns1` AS `ip6_dns1`,`data_center`.`ip6_dns2` AS `ip6_dns2`,`host`.`id` AS `host_id`,`host`.`uuid` AS `host_uuid`,`host`.`name` AS `host_name`,`vm_template`.`id` AS `template_id`,`vm_template`.`uuid` AS `template_uuid`,`service_offering`.`id` AS `service_offering_id`,`disk_offering`.`uuid` AS `service_offering_uuid`,`disk_offering`.`name` AS `service_offering_name`,`nics`.`id` AS `nic_id`,`nics`.`uuid` AS `nic_uuid`,`nics`.`network_id` AS `network_id`,`nics`.`ip4_address` AS `ip_address`,`nics`.`ip6_address` AS `ip6_address`,`nics`.`ip6_gateway` AS `ip6_gateway`,`nics`.`ip6_cidr` AS `ip6_cidr`,`nics`.`default_nic` AS `is_default_nic`,`nics`.`gateway` AS `gateway`,`nics`.`netmask` AS `netmask`,`nics`.`mac_address` AS `mac_address`,`nics`.`broadcast_uri` AS `broadcast_uri`,`nics`.`isolation_uri` AS `isolation_uri`,`vpc`.`id` AS `vpc_id`,`vpc`.`uuid` AS `vpc_uuid`,`networks`.`uuid` AS `network_uuid`,`networks`.`name` AS `network_name`,`networks`.`network_domain` AS `network_domain`,`networks`.`traffic_type` AS `traffic_type`,`networks`.`guest_type` AS `guest_type`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id`,`domain_router`.`template_version` AS `template_version`,`domain_router`.`scripts_version` AS `scripts_version`,`domain_router`.`is_redundant_router` AS `is_redundant_router`,`domain_router`.`redundant_state` AS `redundant_state`,`domain_router`.`stop_pending` AS `stop_pending`,`domain_router`.`role` AS `role` from ((((((((((((((`domain_router` join `vm_instance` on((`vm_instance`.`id` = `domain_router`.`id`))) join `account` on((`vm_instance`.`account_id` = `account`.`id`))) join `domain` on((`vm_instance`.`domain_id` = `domain`.`id`))) left join `host_pod_ref` on((`vm_instance`.`pod_id` = `host_pod_ref`.`id`))) left join `projects` on((`projects`.`project_account_id` = `account`.`id`))) left join `data_center` on((`vm_instance`.`data_center_id` = `data_center`.`id`))) left join `host` on((`vm_instance`.`host_id` = `host`.`id`))) left join `vm_template` on((`vm_instance`.`vm_template_id` = `vm_template`.`id`))) left join `service_offering` on((`vm_instance`.`service_offering_id` = `service_offering`.`id`))) left join `disk_offering` on((`vm_instance`.`service_offering_id` = `disk_offering`.`id`))) left join `nics` on(((`vm_instance`.`id` = `nics`.`instance_id`) and isnull(`nics`.`removed`)))) left join `networks` on((`nics`.`network_id` = `networks`.`id`))) left join `vpc` on(((`domain_router`.`vpc_id` = `vpc`.`id`) and isnull(`vpc`.`removed`)))) left join `async_job` on(((`async_job`.`instance_id` = `vm_instance`.`id`) and (`async_job`.`instance_type` = 'DomainRouter') and (`async_job`.`job_status` = 0)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `event_view`
--

/*!50001 DROP TABLE IF EXISTS `event_view`*/;
/*!50001 DROP VIEW IF EXISTS `event_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `event_view` AS select `event`.`id` AS `id`,`event`.`uuid` AS `uuid`,`event`.`type` AS `type`,`event`.`state` AS `state`,`event`.`description` AS `description`,`event`.`created` AS `created`,`event`.`level` AS `level`,`event`.`parameters` AS `parameters`,`event`.`start_id` AS `start_id`,`eve`.`uuid` AS `start_uuid`,`event`.`user_id` AS `user_id`,`event`.`archived` AS `archived`,`user`.`username` AS `user_name`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name` from (((((`event` join `account` on((`event`.`account_id` = `account`.`id`))) join `domain` on((`event`.`domain_id` = `domain`.`id`))) join `user` on((`event`.`user_id` = `user`.`id`))) left join `projects` on((`projects`.`project_account_id` = `event`.`account_id`))) left join `event` `eve` on((`event`.`start_id` = `eve`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `free_ip_view`
--

/*!50001 DROP TABLE IF EXISTS `free_ip_view`*/;
/*!50001 DROP VIEW IF EXISTS `free_ip_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `free_ip_view` AS select count(`user_ip_address`.`id`) AS `free_ip` from (`user_ip_address` join `vlan` on(((`vlan`.`id` = `user_ip_address`.`vlan_db_id`) and (`vlan`.`vlan_type` = 'VirtualNetwork')))) where (`user_ip_address`.`state` = 'Free') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `host_view`
--

/*!50001 DROP TABLE IF EXISTS `host_view`*/;
/*!50001 DROP VIEW IF EXISTS `host_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `host_view` AS select `host`.`id` AS `id`,`host`.`uuid` AS `uuid`,`host`.`name` AS `name`,`host`.`status` AS `status`,`host`.`disconnected` AS `disconnected`,`host`.`type` AS `type`,`host`.`private_ip_address` AS `private_ip_address`,`host`.`version` AS `version`,`host`.`hypervisor_type` AS `hypervisor_type`,`host`.`hypervisor_version` AS `hypervisor_version`,`host`.`capabilities` AS `capabilities`,`host`.`last_ping` AS `last_ping`,`host`.`created` AS `created`,`host`.`removed` AS `removed`,`host`.`resource_state` AS `resource_state`,`host`.`mgmt_server_id` AS `mgmt_server_id`,`host`.`cpus` AS `cpus`,`host`.`speed` AS `speed`,`host`.`ram` AS `ram`,`cluster`.`id` AS `cluster_id`,`cluster`.`uuid` AS `cluster_uuid`,`cluster`.`name` AS `cluster_name`,`cluster`.`cluster_type` AS `cluster_type`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`data_center`.`networktype` AS `data_center_type`,`host_pod_ref`.`id` AS `pod_id`,`host_pod_ref`.`uuid` AS `pod_uuid`,`host_pod_ref`.`name` AS `pod_name`,`host_tags`.`tag` AS `tag`,`guest_os_category`.`id` AS `guest_os_category_id`,`guest_os_category`.`uuid` AS `guest_os_category_uuid`,`guest_os_category`.`name` AS `guest_os_category_name`,`mem_caps`.`used_capacity` AS `memory_used_capacity`,`mem_caps`.`reserved_capacity` AS `memory_reserved_capacity`,`cpu_caps`.`used_capacity` AS `cpu_used_capacity`,`cpu_caps`.`reserved_capacity` AS `cpu_reserved_capacity`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id` from (((((((((`host` left join `cluster` on((`host`.`cluster_id` = `cluster`.`id`))) left join `data_center` on((`host`.`data_center_id` = `data_center`.`id`))) left join `host_pod_ref` on((`host`.`pod_id` = `host_pod_ref`.`id`))) left join `host_details` on(((`host`.`id` = `host_details`.`host_id`) and (`host_details`.`name` = 'guest.os.category.id')))) left join `guest_os_category` on((`guest_os_category`.`id` = cast(`host_details`.`value` as unsigned)))) left join `host_tags` on((`host_tags`.`host_id` = `host`.`id`))) left join `op_host_capacity` `mem_caps` on(((`host`.`id` = `mem_caps`.`host_id`) and (`mem_caps`.`capacity_type` = 0)))) left join `op_host_capacity` `cpu_caps` on(((`host`.`id` = `cpu_caps`.`host_id`) and (`cpu_caps`.`capacity_type` = 1)))) left join `async_job` on(((`async_job`.`instance_id` = `host`.`id`) and (`async_job`.`instance_type` = 'Host') and (`async_job`.`job_status` = 0)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `image_store_view`
--

/*!50001 DROP TABLE IF EXISTS `image_store_view`*/;
/*!50001 DROP VIEW IF EXISTS `image_store_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `image_store_view` AS select `image_store`.`id` AS `id`,`image_store`.`uuid` AS `uuid`,`image_store`.`name` AS `name`,`image_store`.`image_provider_name` AS `image_provider_name`,`image_store`.`protocol` AS `protocol`,`image_store`.`url` AS `url`,`image_store`.`scope` AS `scope`,`image_store`.`role` AS `role`,`image_store`.`removed` AS `removed`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`image_store_details`.`name` AS `detail_name`,`image_store_details`.`value` AS `detail_value` from ((`image_store` left join `data_center` on((`image_store`.`data_center_id` = `data_center`.`id`))) left join `image_store_details` on((`image_store_details`.`store_id` = `image_store`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `instance_group_view`
--

/*!50001 DROP TABLE IF EXISTS `instance_group_view`*/;
/*!50001 DROP VIEW IF EXISTS `instance_group_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `instance_group_view` AS select `instance_group`.`id` AS `id`,`instance_group`.`uuid` AS `uuid`,`instance_group`.`name` AS `name`,`instance_group`.`removed` AS `removed`,`instance_group`.`created` AS `created`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name` from (((`instance_group` join `account` on((`instance_group`.`account_id` = `account`.`id`))) join `domain` on((`account`.`domain_id` = `domain`.`id`))) left join `projects` on((`projects`.`project_account_id` = `instance_group`.`account_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `project_account_view`
--

/*!50001 DROP TABLE IF EXISTS `project_account_view`*/;
/*!50001 DROP VIEW IF EXISTS `project_account_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `project_account_view` AS select `project_account`.`id` AS `id`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`project_account`.`account_role` AS `account_role`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path` from (((`project_account` join `account` on((`project_account`.`account_id` = `account`.`id`))) join `domain` on((`account`.`domain_id` = `domain`.`id`))) join `projects` on((`projects`.`id` = `project_account`.`project_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `project_invitation_view`
--

/*!50001 DROP TABLE IF EXISTS `project_invitation_view`*/;
/*!50001 DROP VIEW IF EXISTS `project_invitation_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `project_invitation_view` AS select `project_invitations`.`id` AS `id`,`project_invitations`.`uuid` AS `uuid`,`project_invitations`.`email` AS `email`,`project_invitations`.`created` AS `created`,`project_invitations`.`state` AS `state`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path` from (((`project_invitations` left join `account` on((`project_invitations`.`account_id` = `account`.`id`))) left join `domain` on((`project_invitations`.`domain_id` = `domain`.`id`))) left join `projects` on((`projects`.`id` = `project_invitations`.`project_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `project_view`
--

/*!50001 DROP TABLE IF EXISTS `project_view`*/;
/*!50001 DROP VIEW IF EXISTS `project_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `project_view` AS select `projects`.`id` AS `id`,`projects`.`uuid` AS `uuid`,`projects`.`name` AS `name`,`projects`.`display_text` AS `display_text`,`projects`.`state` AS `state`,`projects`.`removed` AS `removed`,`projects`.`created` AS `created`,`projects`.`project_account_id` AS `project_account_id`,`account`.`account_name` AS `owner`,`pacct`.`account_id` AS `account_id`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`resource_tags`.`id` AS `tag_id`,`resource_tags`.`uuid` AS `tag_uuid`,`resource_tags`.`key` AS `tag_key`,`resource_tags`.`value` AS `tag_value`,`resource_tags`.`domain_id` AS `tag_domain_id`,`resource_tags`.`account_id` AS `tag_account_id`,`resource_tags`.`resource_id` AS `tag_resource_id`,`resource_tags`.`resource_uuid` AS `tag_resource_uuid`,`resource_tags`.`resource_type` AS `tag_resource_type`,`resource_tags`.`customer` AS `tag_customer` from (((((`projects` join `domain` on((`projects`.`domain_id` = `domain`.`id`))) join `project_account` on(((`projects`.`id` = `project_account`.`project_id`) and (`project_account`.`account_role` = 'Admin')))) join `account` on((`account`.`id` = `project_account`.`account_id`))) left join `resource_tags` on(((`resource_tags`.`resource_id` = `projects`.`id`) and (`resource_tags`.`resource_type` = 'Project')))) left join `project_account` `pacct` on((`projects`.`id` = `pacct`.`project_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `resource_tag_view`
--

/*!50001 DROP TABLE IF EXISTS `resource_tag_view`*/;
/*!50001 DROP VIEW IF EXISTS `resource_tag_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `resource_tag_view` AS select `resource_tags`.`id` AS `id`,`resource_tags`.`uuid` AS `uuid`,`resource_tags`.`key` AS `key`,`resource_tags`.`value` AS `value`,`resource_tags`.`resource_id` AS `resource_id`,`resource_tags`.`resource_uuid` AS `resource_uuid`,`resource_tags`.`resource_type` AS `resource_type`,`resource_tags`.`customer` AS `customer`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name` from (((`resource_tags` join `account` on((`resource_tags`.`account_id` = `account`.`id`))) join `domain` on((`resource_tags`.`domain_id` = `domain`.`id`))) left join `projects` on((`projects`.`project_account_id` = `resource_tags`.`account_id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `security_group_view`
--

/*!50001 DROP TABLE IF EXISTS `security_group_view`*/;
/*!50001 DROP VIEW IF EXISTS `security_group_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `security_group_view` AS select `security_group`.`id` AS `id`,`security_group`.`name` AS `name`,`security_group`.`description` AS `description`,`security_group`.`uuid` AS `uuid`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name`,`security_group_rule`.`id` AS `rule_id`,`security_group_rule`.`uuid` AS `rule_uuid`,`security_group_rule`.`type` AS `rule_type`,`security_group_rule`.`start_port` AS `rule_start_port`,`security_group_rule`.`end_port` AS `rule_end_port`,`security_group_rule`.`protocol` AS `rule_protocol`,`security_group_rule`.`allowed_network_id` AS `rule_allowed_network_id`,`security_group_rule`.`allowed_ip_cidr` AS `rule_allowed_ip_cidr`,`security_group_rule`.`create_status` AS `rule_create_status`,`resource_tags`.`id` AS `tag_id`,`resource_tags`.`uuid` AS `tag_uuid`,`resource_tags`.`key` AS `tag_key`,`resource_tags`.`value` AS `tag_value`,`resource_tags`.`domain_id` AS `tag_domain_id`,`resource_tags`.`account_id` AS `tag_account_id`,`resource_tags`.`resource_id` AS `tag_resource_id`,`resource_tags`.`resource_uuid` AS `tag_resource_uuid`,`resource_tags`.`resource_type` AS `tag_resource_type`,`resource_tags`.`customer` AS `tag_customer`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id` from ((((((`security_group` left join `security_group_rule` on((`security_group`.`id` = `security_group_rule`.`security_group_id`))) join `account` on((`security_group`.`account_id` = `account`.`id`))) join `domain` on((`security_group`.`domain_id` = `domain`.`id`))) left join `projects` on((`projects`.`project_account_id` = `security_group`.`account_id`))) left join `resource_tags` on(((`resource_tags`.`resource_id` = `security_group`.`id`) and (`resource_tags`.`resource_type` = 'SecurityGroup')))) left join `async_job` on(((`async_job`.`instance_id` = `security_group`.`id`) and (`async_job`.`instance_type` = 'SecurityGroup') and (`async_job`.`job_status` = 0)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `service_offering_view`
--

/*!50001 DROP TABLE IF EXISTS `service_offering_view`*/;
/*!50001 DROP VIEW IF EXISTS `service_offering_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `service_offering_view` AS select `service_offering`.`id` AS `id`,`disk_offering`.`uuid` AS `uuid`,`disk_offering`.`name` AS `name`,`disk_offering`.`display_text` AS `display_text`,`disk_offering`.`created` AS `created`,`disk_offering`.`tags` AS `tags`,`disk_offering`.`removed` AS `removed`,`disk_offering`.`use_local_storage` AS `use_local_storage`,`disk_offering`.`system_use` AS `system_use`,`disk_offering`.`bytes_read_rate` AS `bytes_read_rate`,`disk_offering`.`bytes_write_rate` AS `bytes_write_rate`,`disk_offering`.`iops_read_rate` AS `iops_read_rate`,`disk_offering`.`iops_write_rate` AS `iops_write_rate`,`service_offering`.`cpu` AS `cpu`,`service_offering`.`speed` AS `speed`,`service_offering`.`ram_size` AS `ram_size`,`service_offering`.`nw_rate` AS `nw_rate`,`service_offering`.`mc_rate` AS `mc_rate`,`service_offering`.`ha_enabled` AS `ha_enabled`,`service_offering`.`limit_cpu_use` AS `limit_cpu_use`,`service_offering`.`host_tag` AS `host_tag`,`service_offering`.`default_use` AS `default_use`,`service_offering`.`vm_type` AS `vm_type`,`service_offering`.`sort_key` AS `sort_key`,`service_offering`.`is_volatile` AS `is_volatile`,`service_offering`.`deployment_planner` AS `deployment_planner`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path` from ((`service_offering` join `disk_offering` on((`service_offering`.`id` = `disk_offering`.`id`))) left join `domain` on((`disk_offering`.`domain_id` = `domain`.`id`))) where (`disk_offering`.`state` = 'Active') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `storage_pool_view`
--

/*!50001 DROP TABLE IF EXISTS `storage_pool_view`*/;
/*!50001 DROP VIEW IF EXISTS `storage_pool_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `storage_pool_view` AS select `storage_pool`.`id` AS `id`,`storage_pool`.`uuid` AS `uuid`,`storage_pool`.`name` AS `name`,`storage_pool`.`status` AS `status`,`storage_pool`.`path` AS `path`,`storage_pool`.`pool_type` AS `pool_type`,`storage_pool`.`host_address` AS `host_address`,`storage_pool`.`created` AS `created`,`storage_pool`.`removed` AS `removed`,`storage_pool`.`capacity_bytes` AS `capacity_bytes`,`storage_pool`.`capacity_iops` AS `capacity_iops`,`storage_pool`.`scope` AS `scope`,`storage_pool`.`hypervisor` AS `hypervisor`,`storage_pool`.`storage_provider_name` AS `storage_provider_name`,`cluster`.`id` AS `cluster_id`,`cluster`.`uuid` AS `cluster_uuid`,`cluster`.`name` AS `cluster_name`,`cluster`.`cluster_type` AS `cluster_type`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`data_center`.`networktype` AS `data_center_type`,`host_pod_ref`.`id` AS `pod_id`,`host_pod_ref`.`uuid` AS `pod_uuid`,`host_pod_ref`.`name` AS `pod_name`,`storage_pool_details`.`name` AS `tag`,`op_host_capacity`.`used_capacity` AS `disk_used_capacity`,`op_host_capacity`.`reserved_capacity` AS `disk_reserved_capacity`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id` from ((((((`storage_pool` left join `cluster` on((`storage_pool`.`cluster_id` = `cluster`.`id`))) left join `data_center` on((`storage_pool`.`data_center_id` = `data_center`.`id`))) left join `host_pod_ref` on((`storage_pool`.`pod_id` = `host_pod_ref`.`id`))) left join `storage_pool_details` on(((`storage_pool_details`.`pool_id` = `storage_pool`.`id`) and (`storage_pool_details`.`value` = 'true')))) left join `op_host_capacity` on(((`storage_pool`.`id` = `op_host_capacity`.`host_id`) and (`op_host_capacity`.`capacity_type` = 3)))) left join `async_job` on(((`async_job`.`instance_id` = `storage_pool`.`id`) and (`async_job`.`instance_type` = 'StoragePool') and (`async_job`.`job_status` = 0)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `template_view`
--

/*!50001 DROP TABLE IF EXISTS `template_view`*/;
/*!50001 DROP VIEW IF EXISTS `template_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `template_view` AS select `vm_template`.`id` AS `id`,`vm_template`.`uuid` AS `uuid`,`vm_template`.`unique_name` AS `unique_name`,`vm_template`.`name` AS `name`,`vm_template`.`public` AS `public`,`vm_template`.`featured` AS `featured`,`vm_template`.`type` AS `type`,`vm_template`.`hvm` AS `hvm`,`vm_template`.`bits` AS `bits`,`vm_template`.`url` AS `url`,`vm_template`.`format` AS `format`,`vm_template`.`created` AS `created`,`vm_template`.`checksum` AS `checksum`,`vm_template`.`display_text` AS `display_text`,`vm_template`.`enable_password` AS `enable_password`,`vm_template`.`dynamically_scalable` AS `dynamically_scalable`,`vm_template`.`guest_os_id` AS `guest_os_id`,`guest_os`.`uuid` AS `guest_os_uuid`,`guest_os`.`display_name` AS `guest_os_name`,`vm_template`.`bootable` AS `bootable`,`vm_template`.`prepopulate` AS `prepopulate`,`vm_template`.`cross_zones` AS `cross_zones`,`vm_template`.`hypervisor_type` AS `hypervisor_type`,`vm_template`.`extractable` AS `extractable`,`vm_template`.`template_tag` AS `template_tag`,`vm_template`.`sort_key` AS `sort_key`,`vm_template`.`removed` AS `removed`,`vm_template`.`enable_sshkey` AS `enable_sshkey`,`source_template`.`id` AS `source_template_id`,`source_template`.`uuid` AS `source_template_uuid`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`launch_permission`.`account_id` AS `lp_account_id`,`template_store_ref`.`store_id` AS `store_id`,`image_store`.`scope` AS `store_scope`,`template_store_ref`.`state` AS `state`,`template_store_ref`.`download_state` AS `download_state`,`template_store_ref`.`download_pct` AS `download_pct`,`template_store_ref`.`error_str` AS `error_str`,`template_store_ref`.`size` AS `size`,`template_store_ref`.`destroyed` AS `destroyed`,`template_store_ref`.`created` AS `created_on_store`,`vm_template_details`.`name` AS `detail_name`,`vm_template_details`.`value` AS `detail_value`,`resource_tags`.`id` AS `tag_id`,`resource_tags`.`uuid` AS `tag_uuid`,`resource_tags`.`key` AS `tag_key`,`resource_tags`.`value` AS `tag_value`,`resource_tags`.`domain_id` AS `tag_domain_id`,`resource_tags`.`account_id` AS `tag_account_id`,`resource_tags`.`resource_id` AS `tag_resource_id`,`resource_tags`.`resource_uuid` AS `tag_resource_uuid`,`resource_tags`.`resource_type` AS `tag_resource_type`,`resource_tags`.`customer` AS `tag_customer`,concat(`vm_template`.`id`,'_',ifnull(`data_center`.`id`,0)) AS `temp_zone_pair` from ((((((((((((`vm_template` join `guest_os` on((`guest_os`.`id` = `vm_template`.`guest_os_id`))) join `account` on((`account`.`id` = `vm_template`.`account_id`))) join `domain` on((`domain`.`id` = `account`.`domain_id`))) left join `projects` on((`projects`.`project_account_id` = `account`.`id`))) left join `vm_template_details` on((`vm_template_details`.`template_id` = `vm_template`.`id`))) left join `vm_template` `source_template` on((`source_template`.`id` = `vm_template`.`source_template_id`))) left join `template_store_ref` on(((`template_store_ref`.`template_id` = `vm_template`.`id`) and (`template_store_ref`.`store_role` = 'Image')))) left join `image_store` on((isnull(`image_store`.`removed`) and (`template_store_ref`.`store_id` is not null) and (`image_store`.`id` = `template_store_ref`.`store_id`)))) left join `template_zone_ref` on(((`template_zone_ref`.`template_id` = `vm_template`.`id`) and isnull(`template_store_ref`.`store_id`) and isnull(`template_zone_ref`.`removed`)))) left join `data_center` on(((`image_store`.`data_center_id` = `data_center`.`id`) or (`template_zone_ref`.`zone_id` = `data_center`.`id`)))) left join `launch_permission` on((`launch_permission`.`template_id` = `vm_template`.`id`))) left join `resource_tags` on(((`resource_tags`.`resource_id` = `vm_template`.`id`) and ((`resource_tags`.`resource_type` = 'Template') or (`resource_tags`.`resource_type` = 'ISO'))))) where (`vm_template`.`state` = 'Active') */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_view`
--

/*!50001 DROP TABLE IF EXISTS `user_view`*/;
/*!50001 DROP VIEW IF EXISTS `user_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_view` AS select `user`.`id` AS `id`,`user`.`uuid` AS `uuid`,`user`.`username` AS `username`,`user`.`password` AS `password`,`user`.`firstname` AS `firstname`,`user`.`lastname` AS `lastname`,`user`.`email` AS `email`,`user`.`state` AS `state`,`user`.`api_key` AS `api_key`,`user`.`secret_key` AS `secret_key`,`user`.`created` AS `created`,`user`.`removed` AS `removed`,`user`.`timezone` AS `timezone`,`user`.`registration_token` AS `registration_token`,`user`.`is_registered` AS `is_registered`,`user`.`incorrect_login_attempts` AS `incorrect_login_attempts`,`user`.`default` AS `default`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id` from (((`user` join `account` on((`user`.`account_id` = `account`.`id`))) join `domain` on((`account`.`domain_id` = `domain`.`id`))) left join `async_job` on(((`async_job`.`instance_id` = `user`.`id`) and (`async_job`.`instance_type` = 'User') and (`async_job`.`job_status` = 0)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `user_vm_view`
--

/*!50001 DROP TABLE IF EXISTS `user_vm_view`*/;
/*!50001 DROP VIEW IF EXISTS `user_vm_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `user_vm_view` AS select `vm_instance`.`id` AS `id`,`vm_instance`.`name` AS `name`,`user_vm`.`display_name` AS `display_name`,`user_vm`.`user_data` AS `user_data`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name`,`instance_group`.`id` AS `instance_group_id`,`instance_group`.`uuid` AS `instance_group_uuid`,`instance_group`.`name` AS `instance_group_name`,`vm_instance`.`uuid` AS `uuid`,`vm_instance`.`last_host_id` AS `last_host_id`,`vm_instance`.`vm_type` AS `type`,`vm_instance`.`vnc_password` AS `vnc_password`,`vm_instance`.`limit_cpu_use` AS `limit_cpu_use`,`vm_instance`.`created` AS `created`,`vm_instance`.`state` AS `state`,`vm_instance`.`removed` AS `removed`,`vm_instance`.`ha_enabled` AS `ha_enabled`,`vm_instance`.`hypervisor_type` AS `hypervisor_type`,`vm_instance`.`instance_name` AS `instance_name`,`vm_instance`.`guest_os_id` AS `guest_os_id`,`vm_instance`.`display_vm` AS `display_vm`,`guest_os`.`uuid` AS `guest_os_uuid`,`vm_instance`.`pod_id` AS `pod_id`,`host_pod_ref`.`uuid` AS `pod_uuid`,`vm_instance`.`private_ip_address` AS `private_ip_address`,`vm_instance`.`private_mac_address` AS `private_mac_address`,`vm_instance`.`vm_type` AS `vm_type`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`data_center`.`is_security_group_enabled` AS `security_group_enabled`,`data_center`.`networktype` AS `data_center_type`,`host`.`id` AS `host_id`,`host`.`uuid` AS `host_uuid`,`host`.`name` AS `host_name`,`vm_template`.`id` AS `template_id`,`vm_template`.`uuid` AS `template_uuid`,`vm_template`.`name` AS `template_name`,`vm_template`.`display_text` AS `template_display_text`,`vm_template`.`enable_password` AS `password_enabled`,`iso`.`id` AS `iso_id`,`iso`.`uuid` AS `iso_uuid`,`iso`.`name` AS `iso_name`,`iso`.`display_text` AS `iso_display_text`,`service_offering`.`id` AS `service_offering_id`,`disk_offering`.`uuid` AS `service_offering_uuid`,`service_offering`.`cpu` AS `cpu`,`service_offering`.`speed` AS `speed`,`service_offering`.`ram_size` AS `ram_size`,`disk_offering`.`name` AS `service_offering_name`,`storage_pool`.`id` AS `pool_id`,`storage_pool`.`uuid` AS `pool_uuid`,`storage_pool`.`pool_type` AS `pool_type`,`volumes`.`id` AS `volume_id`,`volumes`.`uuid` AS `volume_uuid`,`volumes`.`device_id` AS `volume_device_id`,`volumes`.`volume_type` AS `volume_type`,`security_group`.`id` AS `security_group_id`,`security_group`.`uuid` AS `security_group_uuid`,`security_group`.`name` AS `security_group_name`,`security_group`.`description` AS `security_group_description`,`nics`.`id` AS `nic_id`,`nics`.`uuid` AS `nic_uuid`,`nics`.`network_id` AS `network_id`,`nics`.`ip4_address` AS `ip_address`,`nics`.`ip6_address` AS `ip6_address`,`nics`.`ip6_gateway` AS `ip6_gateway`,`nics`.`ip6_cidr` AS `ip6_cidr`,`nics`.`default_nic` AS `is_default_nic`,`nics`.`gateway` AS `gateway`,`nics`.`netmask` AS `netmask`,`nics`.`mac_address` AS `mac_address`,`nics`.`broadcast_uri` AS `broadcast_uri`,`nics`.`isolation_uri` AS `isolation_uri`,`vpc`.`id` AS `vpc_id`,`vpc`.`uuid` AS `vpc_uuid`,`networks`.`uuid` AS `network_uuid`,`networks`.`name` AS `network_name`,`networks`.`traffic_type` AS `traffic_type`,`networks`.`guest_type` AS `guest_type`,`user_ip_address`.`id` AS `public_ip_id`,`user_ip_address`.`uuid` AS `public_ip_uuid`,`user_ip_address`.`public_ip_address` AS `public_ip_address`,`ssh_keypairs`.`keypair_name` AS `keypair_name`,`resource_tags`.`id` AS `tag_id`,`resource_tags`.`uuid` AS `tag_uuid`,`resource_tags`.`key` AS `tag_key`,`resource_tags`.`value` AS `tag_value`,`resource_tags`.`domain_id` AS `tag_domain_id`,`resource_tags`.`account_id` AS `tag_account_id`,`resource_tags`.`resource_id` AS `tag_resource_id`,`resource_tags`.`resource_uuid` AS `tag_resource_uuid`,`resource_tags`.`resource_type` AS `tag_resource_type`,`resource_tags`.`customer` AS `tag_customer`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id`,`affinity_group`.`id` AS `affinity_group_id`,`affinity_group`.`uuid` AS `affinity_group_uuid`,`affinity_group`.`name` AS `affinity_group_name`,`affinity_group`.`description` AS `affinity_group_description`,`vm_instance`.`dynamically_scalable` AS `dynamically_scalable` from ((((((((((((((((((((((((((((`user_vm` join `vm_instance` on(((`vm_instance`.`id` = `user_vm`.`id`) and isnull(`vm_instance`.`removed`)))) join `account` on((`vm_instance`.`account_id` = `account`.`id`))) join `domain` on((`vm_instance`.`domain_id` = `domain`.`id`))) left join `guest_os` on((`vm_instance`.`guest_os_id` = `guest_os`.`id`))) left join `host_pod_ref` on((`vm_instance`.`pod_id` = `host_pod_ref`.`id`))) left join `projects` on((`projects`.`project_account_id` = `account`.`id`))) left join `instance_group_vm_map` on((`vm_instance`.`id` = `instance_group_vm_map`.`instance_id`))) left join `instance_group` on((`instance_group_vm_map`.`group_id` = `instance_group`.`id`))) left join `data_center` on((`vm_instance`.`data_center_id` = `data_center`.`id`))) left join `host` on((`vm_instance`.`host_id` = `host`.`id`))) left join `vm_template` on((`vm_instance`.`vm_template_id` = `vm_template`.`id`))) left join `vm_template` `iso` on((`iso`.`id` = `user_vm`.`iso_id`))) left join `service_offering` on((`vm_instance`.`service_offering_id` = `service_offering`.`id`))) left join `disk_offering` on((`vm_instance`.`service_offering_id` = `disk_offering`.`id`))) left join `volumes` on((`vm_instance`.`id` = `volumes`.`instance_id`))) left join `storage_pool` on((`volumes`.`pool_id` = `storage_pool`.`id`))) left join `security_group_vm_map` on((`vm_instance`.`id` = `security_group_vm_map`.`instance_id`))) left join `security_group` on((`security_group_vm_map`.`security_group_id` = `security_group`.`id`))) left join `nics` on(((`vm_instance`.`id` = `nics`.`instance_id`) and isnull(`nics`.`removed`)))) left join `networks` on((`nics`.`network_id` = `networks`.`id`))) left join `vpc` on(((`networks`.`vpc_id` = `vpc`.`id`) and isnull(`vpc`.`removed`)))) left join `user_ip_address` on((`user_ip_address`.`vm_id` = `vm_instance`.`id`))) left join `user_vm_details` on(((`user_vm_details`.`vm_id` = `vm_instance`.`id`) and (`user_vm_details`.`name` = 'SSH.PublicKey')))) left join `ssh_keypairs` on((`ssh_keypairs`.`public_key` = `user_vm_details`.`value`))) left join `resource_tags` on(((`resource_tags`.`resource_id` = `vm_instance`.`id`) and (`resource_tags`.`resource_type` = 'UserVm')))) left join `async_job` on(((`async_job`.`instance_id` = `vm_instance`.`id`) and (`async_job`.`instance_type` = 'VirtualMachine') and (`async_job`.`job_status` = 0)))) left join `affinity_group_vm_map` on((`vm_instance`.`id` = `affinity_group_vm_map`.`instance_id`))) left join `affinity_group` on((`affinity_group_vm_map`.`affinity_group_id` = `affinity_group`.`id`))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;

--
-- Final view structure for view `volume_view`
--

/*!50001 DROP TABLE IF EXISTS `volume_view`*/;
/*!50001 DROP VIEW IF EXISTS `volume_view`*/;
/*!50001 SET @saved_cs_client          = @@character_set_client */;
/*!50001 SET @saved_cs_results         = @@character_set_results */;
/*!50001 SET @saved_col_connection     = @@collation_connection */;
/*!50001 SET character_set_client      = latin1 */;
/*!50001 SET character_set_results     = latin1 */;
/*!50001 SET collation_connection      = latin1_swedish_ci */;
/*!50001 CREATE ALGORITHM=UNDEFINED */
/*!50013 DEFINER=`cloud`@`localhost` SQL SECURITY DEFINER */
/*!50001 VIEW `volume_view` AS select `volumes`.`id` AS `id`,`volumes`.`uuid` AS `uuid`,`volumes`.`name` AS `name`,`volumes`.`device_id` AS `device_id`,`volumes`.`volume_type` AS `volume_type`,`volumes`.`size` AS `size`,`volumes`.`min_iops` AS `min_iops`,`volumes`.`max_iops` AS `max_iops`,`volumes`.`created` AS `created`,`volumes`.`state` AS `state`,`volumes`.`attached` AS `attached`,`volumes`.`removed` AS `removed`,`volumes`.`pod_id` AS `pod_id`,`volumes`.`display_volume` AS `display_volume`,`volumes`.`format` AS `format`,`volumes`.`path` AS `path`,`account`.`id` AS `account_id`,`account`.`uuid` AS `account_uuid`,`account`.`account_name` AS `account_name`,`account`.`type` AS `account_type`,`domain`.`id` AS `domain_id`,`domain`.`uuid` AS `domain_uuid`,`domain`.`name` AS `domain_name`,`domain`.`path` AS `domain_path`,`projects`.`id` AS `project_id`,`projects`.`uuid` AS `project_uuid`,`projects`.`name` AS `project_name`,`data_center`.`id` AS `data_center_id`,`data_center`.`uuid` AS `data_center_uuid`,`data_center`.`name` AS `data_center_name`,`data_center`.`networktype` AS `data_center_type`,`vm_instance`.`id` AS `vm_id`,`vm_instance`.`uuid` AS `vm_uuid`,`vm_instance`.`name` AS `vm_name`,`vm_instance`.`state` AS `vm_state`,`vm_instance`.`vm_type` AS `vm_type`,`user_vm`.`display_name` AS `vm_display_name`,`volume_store_ref`.`size` AS `volume_store_size`,`volume_store_ref`.`download_pct` AS `download_pct`,`volume_store_ref`.`download_state` AS `download_state`,`volume_store_ref`.`error_str` AS `error_str`,`volume_store_ref`.`created` AS `created_on_store`,`disk_offering`.`id` AS `disk_offering_id`,`disk_offering`.`uuid` AS `disk_offering_uuid`,`disk_offering`.`name` AS `disk_offering_name`,`disk_offering`.`display_text` AS `disk_offering_display_text`,`disk_offering`.`use_local_storage` AS `use_local_storage`,`disk_offering`.`system_use` AS `system_use`,`disk_offering`.`bytes_read_rate` AS `bytes_read_rate`,`disk_offering`.`bytes_write_rate` AS `bytes_write_rate`,`disk_offering`.`iops_read_rate` AS `iops_read_rate`,`disk_offering`.`iops_write_rate` AS `iops_write_rate`,`storage_pool`.`id` AS `pool_id`,`storage_pool`.`uuid` AS `pool_uuid`,`storage_pool`.`name` AS `pool_name`,`cluster`.`hypervisor_type` AS `hypervisor_type`,`vm_template`.`id` AS `template_id`,`vm_template`.`uuid` AS `template_uuid`,`vm_template`.`extractable` AS `extractable`,`vm_template`.`type` AS `template_type`,`resource_tags`.`id` AS `tag_id`,`resource_tags`.`uuid` AS `tag_uuid`,`resource_tags`.`key` AS `tag_key`,`resource_tags`.`value` AS `tag_value`,`resource_tags`.`domain_id` AS `tag_domain_id`,`resource_tags`.`account_id` AS `tag_account_id`,`resource_tags`.`resource_id` AS `tag_resource_id`,`resource_tags`.`resource_uuid` AS `tag_resource_uuid`,`resource_tags`.`resource_type` AS `tag_resource_type`,`resource_tags`.`customer` AS `tag_customer`,`async_job`.`id` AS `job_id`,`async_job`.`uuid` AS `job_uuid`,`async_job`.`job_status` AS `job_status`,`async_job`.`account_id` AS `job_account_id` from (((((((((((((`volumes` join `account` on((`volumes`.`account_id` = `account`.`id`))) join `domain` on((`volumes`.`domain_id` = `domain`.`id`))) left join `projects` on((`projects`.`project_account_id` = `account`.`id`))) left join `data_center` on((`volumes`.`data_center_id` = `data_center`.`id`))) left join `vm_instance` on((`volumes`.`instance_id` = `vm_instance`.`id`))) left join `user_vm` on((`user_vm`.`id` = `vm_instance`.`id`))) left join `volume_store_ref` on((`volumes`.`id` = `volume_store_ref`.`volume_id`))) left join `disk_offering` on((`volumes`.`disk_offering_id` = `disk_offering`.`id`))) left join `storage_pool` on((`volumes`.`pool_id` = `storage_pool`.`id`))) left join `cluster` on((`storage_pool`.`cluster_id` = `cluster`.`id`))) left join `vm_template` on(((`volumes`.`template_id` = `vm_template`.`id`) or (`volumes`.`iso_id` = `vm_template`.`id`)))) left join `resource_tags` on(((`resource_tags`.`resource_id` = `volumes`.`id`) and (`resource_tags`.`resource_type` = 'Volume')))) left join `async_job` on(((`async_job`.`instance_id` = `volumes`.`id`) and (`async_job`.`instance_type` = 'Volume') and (`async_job`.`job_status` = 0)))) */;
/*!50001 SET character_set_client      = @saved_cs_client */;
/*!50001 SET character_set_results     = @saved_cs_results */;
/*!50001 SET collation_connection      = @saved_col_connection */;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2013-10-25 23:38:21
