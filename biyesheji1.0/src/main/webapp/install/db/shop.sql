-- phpMyAdmin SQL Dump
-- version 2.10.2
-- http://www.phpmyadmin.net
-- 
-- 主机: localhost
-- 生成日期: 2013 年 06 月 04 日 09:57
-- 服务器版本: 5.0.45
-- PHP 版本: 5.2.3

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- 数据库: `shop`
-- 

-- --------------------------------------------------------

-- 
-- 表的结构 `address`
-- 
DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(20) default NULL,
  `phone` varchar(18) default NULL,
  `postcode` varchar(10) default NULL,
  `user` tinyblob,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `address`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `advise`
-- 
DROP TABLE IF EXISTS `advise`;
CREATE TABLE `advise` (
  `id` bigint(20) NOT NULL auto_increment,
  `adviseType` int(11) default NULL,
  `content` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  `startTime` datetime default NULL,
  `stopTime` datetime default NULL,
  `adPositionId` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKAB3E7EE879AF42A7` (`adPositionId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `advise`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `adviseposition`
-- 
DROP TABLE IF EXISTS `adviseposition`;
CREATE TABLE `adviseposition` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  `key1` varchar(10) default NULL,
  `value1` varchar(10) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `adviseposition`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `area`
-- 
DROP TABLE IF EXISTS `area`;
CREATE TABLE `area` (
  `endArea` varchar(20) NOT NULL,
  `startArea` varchar(20) NOT NULL,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`endArea`,`startArea`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `area`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `article`
-- 
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` varchar(255) NOT NULL,
  `articleType` int(11) default NULL,
  `content` varchar(255) default NULL,
  `faceIcon` varchar(255) default NULL,
  `ipAddr` varchar(20) default NULL,
  `is_top` int(11) default NULL,
  `postTime` datetime default NULL,
  `state` int(11) default NULL,
  `title` varchar(40) default NULL,
  `updateTime` datetime default NULL,
  `userId` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK379164D6F5EE46C0` (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `article`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `article_comments`
-- 
DROP TABLE IF EXISTS `article_comments`;
CREATE TABLE `article_comments` (
  `Article_id` varchar(255) NOT NULL,
  `content` varchar(255) default NULL,
  `name` varchar(50) default NULL,
  `postTime` datetime default NULL,
  `comments_KEY` bigint(20) NOT NULL,
  PRIMARY KEY  (`Article_id`,`comments_KEY`),
  KEY `FK82A0BB3D583FA62E` (`comments_KEY`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `article_comments`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `brand`
-- 
DROP TABLE IF EXISTS `brand`;
CREATE TABLE `brand` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `brand`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `carticle`
-- 
DROP TABLE IF EXISTS `carticle`;
CREATE TABLE `carticle` (
  `id` varchar(255) NOT NULL,
  `articleType` int(11) default NULL,
  `content` varchar(255) default NULL,
  `faceIcon` varchar(255) default NULL,
  `ipAddr` varchar(20) default NULL,
  `is_top` int(11) default NULL,
  `postTime` datetime default NULL,
  `state` int(11) default NULL,
  `title` varchar(40) default NULL,
  `updateTime` datetime default NULL,
  `userId` bigint(20) default NULL,
  `chanArticleCateId` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK63A5BF1368E38EAE` (`chanArticleCateId`),
  KEY `FK379164D6F5EE46C063a5bf13` (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `carticle`
-- 

INSERT INTO `carticle` VALUES ('bbb427383ef946f6013ef949cdf30004', 0, '&nbsp;还能哈哈哈', NULL, NULL, 0, '2013-05-31 14:32:43', 0, '广告歌', NULL, NULL, 'bbb427383ef946f6013ef948fa5d0002');
INSERT INTO `carticle` VALUES ('bbb427383ef946f6013ef94a18590005', 1, '&nbsp;哈哈哈哈哈', NULL, NULL, 0, '2013-05-31 14:33:02', 0, '好好好', NULL, NULL, 'bbb427383ef946f6013ef948fa5d0002');
INSERT INTO `carticle` VALUES ('5c2fa7143efedad2013efedd743d0000', NULL, '', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('5c2fa7143efedad2013efede6ea10001', NULL, '', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('5c2fa7143efedad2013efedff59c0002', NULL, '', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('5c2fa7143efedad2013efee1897b0003', NULL, '', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('5c2fa7143efedad2013efee296ca0004', NULL, '', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('ff8080813f0052dc013f0054c3220000', NULL, '&nbsp;', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('ff8080813f0052dc013f0055eddc0001', NULL, '&nbsp;', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('ff8080813f0052dc013f0056aaca0002', NULL, '&nbsp;', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('ff8080813f0052dc013f0057c5940003', NULL, '&nbsp;', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);
INSERT INTO `carticle` VALUES ('ff8080813f0052dc013f00596e3b0004', NULL, '&nbsp;', NULL, NULL, 0, NULL, 0, '', NULL, NULL, NULL);

-- --------------------------------------------------------

-- 
-- 表的结构 `cartproduct`
-- 
DROP TABLE IF EXISTS `cartproduct`;
CREATE TABLE `cartproduct` (
  `id` varchar(255) NOT NULL,
  `number` int(11) default NULL,
  `pid` int(11) NOT NULL,
  `price` double NOT NULL,
  `goodsId` varchar(255) default NULL,
  `ordersId` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK8D8D25AF8296DEB4` (`ordersId`),
  KEY `FK8D8D25AFDC2FAF58` (`goodsId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `cartproduct`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `channel`
-- 
DROP TABLE IF EXISTS `channel`;
CREATE TABLE `channel` (
  `id` bigint(20) NOT NULL auto_increment,
  `channelType` int(11) default NULL,
  `is_index` int(11) default NULL,
  `is_link` int(11) default NULL,
  `is_newWindow` int(11) default NULL,
  `is_recommend` int(11) default NULL,
  `is_stop` int(11) default NULL,
  `link_url` varchar(50) default NULL,
  `name` varchar(20) default NULL,
  `orders` int(11) default NULL,
  `position` int(11) default NULL,
  `articleId` varchar(255) default NULL,
  `pid` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK2C0B7D03E72F513` (`articleId`),
  KEY `FK2C0B7D035B8E1F5F` (`pid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=11 ;

-- 
-- 导出表中的数据 `channel`
-- 

INSERT INTO `channel` VALUES (1, 0, 1, 0, 0, 0, 0, 'myCard.html', '我的账户', 0, 0, '5c2fa7143efedad2013efedd743d0000', NULL);
INSERT INTO `channel` VALUES (2, 0, 1, 0, 0, 0, 0, 'register.html', '注册', 1, 0, '5c2fa7143efedad2013efede6ea10001', NULL);
INSERT INTO `channel` VALUES (3, 0, 0, 1, 1, 0, 0, 'main/adminAction!loginUI.action', '管理后台', 2, 0, '5c2fa7143efedad2013efedff59c0002', NULL);
INSERT INTO `channel` VALUES (4, 0, 1, 0, 0, 0, 0, 'card.html', '购物车', 3, 0, '5c2fa7143efedad2013efee1897b0003', NULL);
INSERT INTO `channel` VALUES (5, 0, 1, 0, 0, 0, 0, 'about.html', '关于我们', 4, 0, '5c2fa7143efedad2013efee296ca0004', NULL);
INSERT INTO `channel` VALUES (6, 0, 1, 0, 0, 0, 0, '', '男人', 0, 1, 'ff8080813f0052dc013f0054c3220000', NULL);
INSERT INTO `channel` VALUES (7, 0, 0, 0, 0, 0, 0, '', '上衣', 1, 1, 'ff8080813f0052dc013f0055eddc0001', 6);
INSERT INTO `channel` VALUES (8, 0, 0, 0, 0, 0, 0, '', 'T桖', 2, 1, 'ff8080813f0052dc013f0056aaca0002', 7);
INSERT INTO `channel` VALUES (9, 0, 0, 0, 0, 0, 0, '', '羊毛杉', 3, 1, 'ff8080813f0052dc013f0057c5940003', NULL);
INSERT INTO `channel` VALUES (10, 0, 0, 0, 0, 0, 0, '', '短褂', 4, 1, 'ff8080813f0052dc013f00596e3b0004', 8);

-- --------------------------------------------------------

-- 
-- 表的结构 `channel_category`
-- 
DROP TABLE IF EXISTS `channel_category`;
CREATE TABLE `channel_category` (
  `channel_id` bigint(20) NOT NULL,
  `categorys_id` varchar(255) NOT NULL,
  UNIQUE KEY `categorys_id` (`categorys_id`),
  KEY `FKF5AFC8DAE8769FAB` (`channel_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `channel_category`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `chcategory`
-- 
DROP TABLE IF EXISTS `chcategory`;
CREATE TABLE `chcategory` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  `pid` varchar(255) default NULL,
  `sort` int(11) NOT NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `chcategory`
-- 

INSERT INTO `chcategory` VALUES ('bbb427383ef946f6013ef948fa5d0002', '广告歌', 'baidu', NULL, 0);
INSERT INTO `chcategory` VALUES ('bbb427383ef946f6013ef949744e0003', '广告歌好好', 'baidu', NULL, 0);

-- --------------------------------------------------------

-- 
-- 表的结构 `discount`
-- 
DROP TABLE IF EXISTS `discount`;
CREATE TABLE `discount` (
  `id` bigint(20) NOT NULL auto_increment,
  `name` varchar(40) default NULL,
  `point` float NOT NULL,
  `type` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `discount`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `express`
-- 
DROP TABLE IF EXISTS `express`;
CREATE TABLE `express` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  `sort` int(11) default NULL,
  `url` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `express`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `forum`
-- 
DROP TABLE IF EXISTS `forum`;
CREATE TABLE `forum` (
  `id` bigint(20) NOT NULL auto_increment,
  `articleCount` int(11) NOT NULL,
  `description` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `position` int(11) NOT NULL,
  `topicCount` int(11) NOT NULL,
  `lastTopic_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK5D18D212D1A3D01` (`lastTopic_id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- 
-- 导出表中的数据 `forum`
-- 

INSERT INTO `forum` VALUES (1, 5, NULL, '广告', 1, 3, 'bbb427383ef94ed3013ef94f77130000');

-- --------------------------------------------------------

-- 
-- 表的结构 `frendlink`
-- 
DROP TABLE IF EXISTS `frendlink`;
CREATE TABLE `frendlink` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  `url` varchar(50) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=4 ;

-- 
-- 导出表中的数据 `frendlink`
-- 

INSERT INTO `frendlink` VALUES (1, 'baidu', 'baidu', 'http://www.baidu.com');
INSERT INTO `frendlink` VALUES (2, '腾讯qq', '腾讯网', 'http://www.qq.com');
INSERT INTO `frendlink` VALUES (3, '', 'zhuyuping', 'http://www.open-yun.com ');

-- --------------------------------------------------------

-- 
-- 表的结构 `goods`
-- 
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods` (
  `id` varchar(255) NOT NULL,
  `contents` varchar(255) default NULL,
  `description` varchar(255) default NULL,
  `name` varchar(60) default NULL,
  `postTime` datetime default NULL,
  `price` decimal(19,2) default NULL,
  `status` int(11) NOT NULL,
  `stock` int(11) NOT NULL,
  `updateTime` datetime default NULL,
  `brandId` bigint(20) default NULL,
  `categoryId` varchar(255) default NULL,
  `discountId` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK5DF9756F0E5D4AC` (`discountId`),
  KEY `FK5DF9756D7C8CF7A` (`brandId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `goods`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `goods_comments`
-- 
DROP TABLE IF EXISTS `goods_comments`;
CREATE TABLE `goods_comments` (
  `Goods_id` varchar(255) NOT NULL,
  `content` varchar(255) default NULL,
  `name` varchar(50) default NULL,
  `postTime` datetime default NULL,
  `comments_KEY` bigint(20) NOT NULL,
  PRIMARY KEY  (`Goods_id`,`comments_KEY`),
  KEY `FK2D2A24DD4E661B0B` (`Goods_id`),
  KEY `FK2D2A24DD583FA62E` (`comments_KEY`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `goods_comments`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `goods_img`
-- 
DROP TABLE IF EXISTS `goods_img`;
CREATE TABLE `goods_img` (
  `Goods_id` varchar(255) NOT NULL,
  `img` varchar(255) default NULL,
  KEY `FKCA96E33A4E661B0B` (`Goods_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `goods_img`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `goods_specification`
-- 
DROP TABLE IF EXISTS `goods_specification`;
CREATE TABLE `goods_specification` (
  `goods_id` varchar(255) NOT NULL,
  `specifications_id` bigint(20) NOT NULL,
  UNIQUE KEY `specifications_id` (`specifications_id`),
  KEY `FK8E391BDA4E661B0B` (`goods_id`),
  KEY `FK8E391BDAC22F50FE` (`specifications_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `goods_specification`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `logger`
-- 
DROP TABLE IF EXISTS `logger`;
CREATE TABLE `logger` (
  `id` bigint(20) NOT NULL auto_increment,
  `currentTime` datetime default NULL,
  `name` varchar(255) default NULL,
  `operater` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `logger`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `orders`
-- 
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` varchar(255) NOT NULL,
  `address` tinyblob,
  `buyDate` datetime default NULL,
  `confirmDate` datetime default NULL,
  `payDate` datetime default NULL,
  `price` double NOT NULL,
  `status` int(11) default NULL,
  `userId` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKC3DF62E5F5EE46C0` (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `orders`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `paymodel`
-- 
DROP TABLE IF EXISTS `paymodel`;
CREATE TABLE `paymodel` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `icon` varchar(40) default NULL,
  `name` varchar(20) default NULL,
  `sort` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `paymodel`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `privilege`
-- 
DROP TABLE IF EXISTS `privilege`;
CREATE TABLE `privilege` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `icon` varchar(40) default NULL,
  `name` varchar(40) default NULL,
  `url` varchar(60) default NULL,
  `pid` bigint(20) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FKA1FAF6B1F504A8CD` (`pid`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=40 ;

-- 
-- 导出表中的数据 `privilege`
-- 

INSERT INTO `privilege` VALUES (1, NULL, 'home', '网站设置', '', NULL);
INSERT INTO `privilege` VALUES (2, NULL, '', '网站设置', 'main/settingAction!list', 1);
INSERT INTO `privilege` VALUES (3, NULL, '', '支付管理', 'main/payAction!list', 1);
INSERT INTO `privilege` VALUES (4, NULL, '', '配送管理', 'main/deliveryAction!list', 1);
INSERT INTO `privilege` VALUES (5, NULL, '', '系统设置', 'main/settingAction!list', 2);
INSERT INTO `privilege` VALUES (6, NULL, '', '在线客服', 'main/messageAction!list', 2);
INSERT INTO `privilege` VALUES (7, NULL, '', '支付方式', 'main/payAction!list', 3);
INSERT INTO `privilege` VALUES (8, NULL, '', '配送方式', 'main/deliveryAction!list', 4);
INSERT INTO `privilege` VALUES (9, NULL, '', '地区管理', 'main/areaAction!list', 4);
INSERT INTO `privilege` VALUES (10, NULL, '', '物流公司', 'main/deliveryAction!list', 4);
INSERT INTO `privilege` VALUES (11, NULL, 'shopping_cart', '商品管理', '', NULL);
INSERT INTO `privilege` VALUES (12, NULL, '', '商品管理', 'main/shopAction!list', 11);
INSERT INTO `privilege` VALUES (13, NULL, '', '商品分类管理', 'main/shopcategoryAction!list', 11);
INSERT INTO `privilege` VALUES (14, NULL, '', '商品类型管理', 'main/shoptypeAction!list', 11);
INSERT INTO `privilege` VALUES (15, NULL, '', '商品规格管理', 'main/specificationAction!list', 11);
INSERT INTO `privilege` VALUES (16, NULL, '', '品牌管理', 'main/shopbrandAction!list', 11);
INSERT INTO `privilege` VALUES (17, NULL, 'show_thumbnails', '订单处理', '', NULL);
INSERT INTO `privilege` VALUES (18, NULL, '', '订单管理', 'main/orderAction!list', 17);
INSERT INTO `privilege` VALUES (19, NULL, '', '快递单管理', 'main/deliverycardAction!list', 17);
INSERT INTO `privilege` VALUES (20, NULL, 'adress_book', '会员管理', '', NULL);
INSERT INTO `privilege` VALUES (21, NULL, '', '会员管理', 'main/memberAction!list', 20);
INSERT INTO `privilege` VALUES (22, NULL, '', '商品评论', 'main/shopcommentAction!list', 20);
INSERT INTO `privilege` VALUES (23, NULL, '', '在线留言', 'main/shopleaveAction!list', 20);
INSERT INTO `privilege` VALUES (24, NULL, 'sort', '页面内容', '', NULL);
INSERT INTO `privilege` VALUES (25, NULL, '', '内容管理', 'main/contentAction!list', 24);
INSERT INTO `privilege` VALUES (26, NULL, '', '模板管理', 'main/pageTemplateAction!list', 24);
INSERT INTO `privilege` VALUES (27, NULL, '', '缓存管理', 'main/pageCacheAction!list', 24);
INSERT INTO `privilege` VALUES (28, NULL, '', '网站更新管理', 'main/pageBuildAction!list', 24);
INSERT INTO `privilege` VALUES (29, NULL, 'cogwheels', '权限管理', '', NULL);
INSERT INTO `privilege` VALUES (30, NULL, '', '权限管理', 'main/privilegeAction!list', 29);
INSERT INTO `privilege` VALUES (31, NULL, '', '角色管理', 'main/roleAction!list', 29);
INSERT INTO `privilege` VALUES (32, NULL, '', '站内消息', 'main/pageMessageAction!list', 29);
INSERT INTO `privilege` VALUES (33, NULL, '', '操作日志', 'main/logRecorderAction!list', 29);
INSERT INTO `privilege` VALUES (34, NULL, 'picture', '文章管理', '', NULL);
INSERT INTO `privilege` VALUES (35, NULL, '', '栏目管理', 'main/channelAction!list', 34);
INSERT INTO `privilege` VALUES (36, NULL, '', '友情链接', 'main/frendLinkAction!list', 34);
INSERT INTO `privilege` VALUES (37, NULL, 'show_thumbnails_with_lines', '论坛管理', '', NULL);
INSERT INTO `privilege` VALUES (38, NULL, '', '论坛管理', 'main/forumManagerAction!list', 37);
INSERT INTO `privilege` VALUES (39, NULL, '', '论坛', 'main/forumAction!list', 37);

-- --------------------------------------------------------

-- 
-- 表的结构 `reply`
-- 
DROP TABLE IF EXISTS `reply`;
CREATE TABLE `reply` (
  `id` varchar(255) NOT NULL,
  `articleType` int(11) default NULL,
  `content` varchar(255) default NULL,
  `faceIcon` varchar(255) default NULL,
  `ipAddr` varchar(20) default NULL,
  `is_top` int(11) default NULL,
  `postTime` datetime default NULL,
  `state` int(11) default NULL,
  `title` varchar(40) default NULL,
  `updateTime` datetime default NULL,
  `userId` bigint(20) default NULL,
  `topicId` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK67612EA8CA808CA` (`topicId`),
  KEY `FK379164D6F5EE46C067612ea` (`userId`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `reply`
-- 

INSERT INTO `reply` VALUES ('bbb427383ef96a8e013ef96b783b0000', NULL, '不是 的，，，，，，，，，', '2', '127.0.0.1', 0, '2013-05-31 15:09:30', 0, '回复：这是男装', NULL, 1, 'bbb427383ef94ed3013ef94f77130000');
INSERT INTO `reply` VALUES ('bbb427383ef96a8e013ef979174e0001', NULL, '&nbsp;嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎嘎', '4', '127.0.0.1', 0, '2013-05-31 15:24:22', 0, '回复：这是男装', NULL, 1, 'bbb427383ef94ed3013ef94f77130000');

-- --------------------------------------------------------

-- 
-- 表的结构 `role`
-- 
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `role`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `role_privilege`
-- 
DROP TABLE IF EXISTS `role_privilege`;
CREATE TABLE `role_privilege` (
  `roles_id` bigint(20) NOT NULL,
  `privileges_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`roles_id`,`privileges_id`),
  KEY `FK45FBD6289E86E5DA` (`privileges_id`),
  KEY `FK45FBD62817EBB722` (`roles_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `role_privilege`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `sales`
-- 
DROP TABLE IF EXISTS `sales`;
CREATE TABLE `sales` (
  `id` varchar(255) NOT NULL,
  `SaleDate` datetime default NULL,
  `goodId` varchar(255) default NULL,
  `price` decimal(19,2) default NULL,
  `quantity` bigint(20) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `sales`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `setting`
-- 
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting` (
  `id` bigint(20) NOT NULL auto_increment,
  `description` varchar(255) default NULL,
  `name` varchar(40) default NULL,
  `value` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

-- 
-- 导出表中的数据 `setting`
-- 

INSERT INTO `setting` VALUES (1, '网站标题', 'title', '校园二手交易网');
INSERT INTO `setting` VALUES (2, '网站描述', 'meta', '校园，二手，商店，购物，交易');
INSERT INTO `setting` VALUES (3, '联系方式', 'contect', '南昌大学电子商务091毕业设计QQ1050316096 电话18011790152');
INSERT INTO `setting` VALUES (4, '版权信息', 'copyright', '版权所有 power by zhuyuping');
INSERT INTO `setting` VALUES (5, '公告信息', 'notice', '欢迎进入二手交易网站！');
INSERT INTO `setting` VALUES (6, '主页展示', 'home_title', '欢迎进入WEBOS---GO Shoping');
INSERT INTO `setting` VALUES (7, '主页关键字', 'home_keywords', '二手，交易，南昌大学，webos,电子商务！');
INSERT INTO `setting` VALUES (8, '主页描述', 'hone_description', '校园二手交易webos是一个专们 大学生校园 二手交易的跳骚网上交易平台！采用Spring3+Hibernate4+maven+SpringMVC+struts2+jqueryUI+mysql开发！。');

-- --------------------------------------------------------

-- 
-- 表的结构 `shcategory`
-- 
DROP TABLE IF EXISTS `shcategory`;
CREATE TABLE `shcategory` (
  `id` varchar(255) NOT NULL,
  `description` varchar(255) default NULL,
  `name` varchar(20) default NULL,
  `pid` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `shcategory`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `specification`
-- 
DROP TABLE IF EXISTS `specification`;
CREATE TABLE `specification` (
  `id` bigint(20) NOT NULL auto_increment,
  `color` varchar(40) default NULL,
  `measures` varchar(40) default NULL,
  `name` varchar(40) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- 
-- 导出表中的数据 `specification`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `topic`
-- 
DROP TABLE IF EXISTS `topic`;
CREATE TABLE `topic` (
  `id` varchar(255) NOT NULL,
  `articleType` int(11) default NULL,
  `content` varchar(255) default NULL,
  `faceIcon` varchar(255) default NULL,
  `ipAddr` varchar(20) default NULL,
  `is_top` int(11) default NULL,
  `postTime` datetime default NULL,
  `state` int(11) default NULL,
  `title` varchar(40) default NULL,
  `updateTime` datetime default NULL,
  `userId` bigint(20) default NULL,
  `lastUpdateTime` datetime default NULL,
  `replyCount` int(11) NOT NULL,
  `type` int(11) NOT NULL,
  `forumId` bigint(20) default NULL,
  `lastReply_id` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  KEY `FK696CD2FA76D542E` (`forumId`),
  KEY `FK379164D6F5EE46C0696cd2f` (`userId`),
  KEY `FK696CD2F4C6D1F21` (`lastReply_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `topic`
-- 

INSERT INTO `topic` VALUES ('bbb427383ef946f6013ef947c39e0000', NULL, '古古怪怪', NULL, '127.0.0.1', 0, '2013-05-31 14:30:30', 0, '新会员注册', NULL, 1, '2013-05-31 14:30:30', 0, 0, 1, NULL);
INSERT INTO `topic` VALUES ('bbb427383ef94c84013ef94d00a70000', NULL, '&nbsp;<span class="Apple-tab-span" style="white-space:pre">	</span>userService.findById(user.getId());', '3', '127.0.0.1', 0, '2013-05-31 14:36:13', 0, '3个月【百度音乐VIP会员】免费拿，快来领吧~ （分享自 @百度音乐）', NULL, 1, '2013-05-31 14:36:13', 0, 0, 1, NULL);
INSERT INTO `topic` VALUES ('bbb427383ef94ed3013ef94f77130000', NULL, 'hhhhhhhhhhhhhhh', '4', '127.0.0.1', 0, '2013-05-31 14:38:54', 0, '这是男装', NULL, 1, '2013-05-31 15:24:22', 2, 0, 1, 'bbb427383ef96a8e013ef979174e0001');

-- --------------------------------------------------------

-- 
-- 表的结构 `user`
-- 
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL auto_increment,
  `email` varchar(255) default NULL,
  `face` varchar(255) default NULL,
  `ipaddress` varchar(40) default NULL,
  `lastLogDate` datetime default NULL,
  `logName` varchar(40) default NULL,
  `money` decimal(19,2) default NULL,
  `name` varchar(40) default NULL,
  `password` varchar(40) default NULL,
  `regDate` datetime default NULL,
  `status` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `logName` (`logName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=2 ;

-- 
-- 导出表中的数据 `user`
-- 

INSERT INTO `user` VALUES (1, 'zhuyuping1992@gmail.com', NULL, NULL, NULL, 'admin', 0.00, '超级管理员', '21232f297a57a5a743894a0e4a801fc3', NULL, 0);

-- --------------------------------------------------------

-- 
-- 表的结构 `user_address`
-- 
DROP TABLE IF EXISTS `user_address`;
CREATE TABLE `user_address` (
  `user_id` bigint(20) NOT NULL,
  `addresses_id` bigint(20) NOT NULL,
  UNIQUE KEY `addresses_id` (`addresses_id`),
  KEY `FK168733801EFE02A9` (`user_id`),
  KEY `FK16873380FB2D479D` (`addresses_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `user_address`
-- 


-- --------------------------------------------------------

-- 
-- 表的结构 `user_role`
-- 
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `users_id` bigint(20) NOT NULL,
  `roles_id` bigint(20) NOT NULL,
  PRIMARY KEY  (`users_id`,`roles_id`),
  KEY `FK143BF46A17EBB722` (`roles_id`),
  KEY `FK143BF46A17EEDB4C` (`users_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- 导出表中的数据 `user_role`
-- 

