/*
Navicat SQL Server Data Transfer

Source Server         : SQLServer
Source Server Version : 130000
Source Host           : 127.0.0.1:1433
Source Database       : db_exam
Source Schema         : dbo

Target Server Type    : SQL Server
Target Server Version : 130000
File Encoding         : 65001

Date: 2018-01-10 22:07:09
*/


-- ----------------------------
-- Table structure for paper_class
-- ----------------------------
DROP TABLE [dbo].[paper_class]
GO
CREATE TABLE [dbo].[paper_class] (
[pcId] int NOT NULL IDENTITY(1,1) ,
[pId] int NOT NULL ,
[cCode] varchar(20) NOT NULL ,
[examDate] date NOT NULL ,
[endDate] date NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[paper_class]', RESEED, 2)
GO

-- ----------------------------
-- Records of paper_class
-- ----------------------------
SET IDENTITY_INSERT [dbo].[paper_class] ON
GO
INSERT INTO [dbo].[paper_class] ([pcId], [pId], [cCode], [examDate], [endDate]) VALUES (N'1', N'1', N'16GR1', N'2018-03-06', N'2018-03-06')
GO
GO
SET IDENTITY_INSERT [dbo].[paper_class] OFF
GO

-- ----------------------------
-- Table structure for paper_wquestion
-- ----------------------------
DROP TABLE [dbo].[paper_wquestion]
GO
CREATE TABLE [dbo].[paper_wquestion] (
[id] int NOT NULL IDENTITY(1,1) ,
[pId] int NOT NULL ,
[qId] int NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[paper_wquestion]', RESEED, 18)
GO

-- ----------------------------
-- Records of paper_wquestion
-- ----------------------------
SET IDENTITY_INSERT [dbo].[paper_wquestion] ON
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'1', N'3', N'1003')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'2', N'3', N'1004')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'3', N'3', N'1002')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'4', N'3', N'1001')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'5', N'3', N'1005')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'6', N'3', N'1006')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'7', N'4', N'1004')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'8', N'4', N'1002')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'9', N'4', N'1005')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'10', N'4', N'1001')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'11', N'4', N'1003')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'12', N'4', N'1006')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'13', N'5', N'1001')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'14', N'5', N'1004')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'15', N'5', N'1006')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'16', N'5', N'1002')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'17', N'5', N'1005')
GO
GO
INSERT INTO [dbo].[paper_wquestion] ([id], [pId], [qId]) VALUES (N'18', N'5', N'1003')
GO
GO
SET IDENTITY_INSERT [dbo].[paper_wquestion] OFF
GO

-- ----------------------------
-- Table structure for t_classInfo
-- ----------------------------
DROP TABLE [dbo].[t_classInfo]
GO
CREATE TABLE [dbo].[t_classInfo] (
[cCode] varchar(20) NOT NULL ,
[cName] varchar(20) NOT NULL ,
[major] varchar(10) NOT NULL ,
[insId] varchar(20) NOT NULL ,
[iecId] varchar(20) NOT NULL ,
[cDate] date NOT NULL ,
[g1Num] int NULL ,
[g2Num] int NULL ,
[g3Num] int NULL ,
[csId] int NULL DEFAULT ((0)) ,
[cRemark] varchar(50) NULL 
)


GO

-- ----------------------------
-- Records of t_classInfo
-- ----------------------------
INSERT INTO [dbo].[t_classInfo] ([cCode], [cName], [major], [insId], [iecId], [cDate], [g1Num], [g2Num], [g3Num], [csId], [cRemark]) VALUES (N'16GR1', N'16级高软1班', N'SCME', N'g17719100357', N'g13353952929', N'2016-09-01', null, null, null, N'0', null)
GO
GO

-- ----------------------------
-- Table structure for t_course
-- ----------------------------
DROP TABLE [dbo].[t_course]
GO
CREATE TABLE [dbo].[t_course] (
[csId] int NOT NULL IDENTITY(1,1) ,
[csName] varchar(20) NOT NULL ,
[stage] varchar(2) NOT NULL ,
[major] varchar(10) NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_course]', RESEED, 13)
GO

-- ----------------------------
-- Records of t_course
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_course] ON
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'1', N'计算机基础', N'G1', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'2', N'PS', N'G1', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'3', N'SQLServer', N'G1', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'4', N'Java', N'G1', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'5', N'JSP', N'G2', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'6', N'JavaScript', N'G2', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'7', N'Struts2', N'G2', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'8', N'Hibernate', N'G2', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'9', N'Spring', N'G3', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'10', N'MyBatis', N'G3', N'SCME')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'11', N'Liunx', N'G3', N'SCCE')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'12', N'QT', N'G3', N'SCCE')
GO
GO
INSERT INTO [dbo].[t_course] ([csId], [csName], [stage], [major]) VALUES (N'13', N'MySQL', N'G3', N'SCCE')
GO
GO
SET IDENTITY_INSERT [dbo].[t_course] OFF
GO

-- ----------------------------
-- Table structure for t_machineQuestion
-- ----------------------------
DROP TABLE [dbo].[t_machineQuestion]
GO
CREATE TABLE [dbo].[t_machineQuestion] (
[qId] int NOT NULL IDENTITY(1001,1) ,
[qTitle] varchar(100) NOT NULL ,
[degree] varchar(4) NOT NULL ,
[csId] int NOT NULL ,
[chapter] varchar(2) NULL 
)


GO

-- ----------------------------
-- Records of t_machineQuestion
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_machineQuestion] ON
GO
SET IDENTITY_INSERT [dbo].[t_machineQuestion] OFF
GO

-- ----------------------------
-- Table structure for t_paper
-- ----------------------------
DROP TABLE [dbo].[t_paper]
GO
CREATE TABLE [dbo].[t_paper] (
[pId] int NOT NULL IDENTITY(1,1) ,
[pName] varchar(20) NOT NULL ,
[pTime] int NOT NULL ,
[pTotalScore] int NOT NULL ,
[csId] int NOT NULL ,
[qTotal] float(53) NULL ,
[qScore] int NOT NULL ,
[pType] varchar(10) NOT NULL ,
[pState] varchar(10) NOT NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_paper]', RESEED, 5)
GO

-- ----------------------------
-- Records of t_paper
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_paper] ON
GO
INSERT INTO [dbo].[t_paper] ([pId], [pName], [pTime], [pTotalScore], [csId], [qTotal], [qScore], [pType], [pState]) VALUES (N'1', N'计算机基础考试01', N'60', N'100', N'1', N'50', N'2', N'笔试', N'未开考')
GO
GO
INSERT INTO [dbo].[t_paper] ([pId], [pName], [pTime], [pTotalScore], [csId], [qTotal], [qScore], [pType], [pState]) VALUES (N'3', N'计算机二级考试01', N'60', N'100', N'1', N'6', N'16', N'笔试', N'未开考')
GO
GO
INSERT INTO [dbo].[t_paper] ([pId], [pName], [pTime], [pTotalScore], [csId], [qTotal], [qScore], [pType], [pState]) VALUES (N'4', N'计算机一级考试01', N'60', N'100', N'1', N'6', N'16', N'笔试', N'未开考')
GO
GO
INSERT INTO [dbo].[t_paper] ([pId], [pName], [pTime], [pTotalScore], [csId], [qTotal], [qScore], [pType], [pState]) VALUES (N'5', N'计算机四级考试', N'60', N'100', N'1', N'6', N'16', N'笔试', N'未开考')
GO
GO
SET IDENTITY_INSERT [dbo].[t_paper] OFF
GO

-- ----------------------------
-- Table structure for t_student
-- ----------------------------
DROP TABLE [dbo].[t_student]
GO
CREATE TABLE [dbo].[t_student] (
[sid] varchar(20) NOT NULL ,
[sname] varchar(20) NOT NULL ,
[sex] varchar(2) NOT NULL ,
[enterSchool] varchar(10) NOT NULL ,
[cCode] varchar(20) NOT NULL ,
[photo] varchar(50) NULL ,
[birthday] date NULL ,
[IDCard] varchar(18) NULL ,
[pOutlook] varchar(10) NULL ,
[province] varchar(20) NULL ,
[city] varchar(20) NULL ,
[tel] varchar(11) NULL ,
[address] varchar(40) NULL ,
[ptel] varchar(11) NULL ,
[pRelation] varchar(10) NULL ,
[hostelBuil] varchar(10) NULL ,
[hostelNo] varchar(10) NULL ,
[baseInfo] varchar(50) NULL ,
[eduBg] varchar(20) NULL ,
[remarks] varchar(20) NULL 
)


GO

-- ----------------------------
-- Records of t_student
-- ----------------------------
INSERT INTO [dbo].[t_student] ([sid], [sname], [sex], [enterSchool], [cCode], [photo], [birthday], [IDCard], [pOutlook], [province], [city], [tel], [address], [ptel], [pRelation], [hostelBuil], [hostelNo], [baseInfo], [eduBg], [remarks]) VALUES (N's18339401079', N'秦大帅', N'男', N'2016', N'16GR1', null, null, null, null, null, null, null, null, null, null, null, null, null, null, null)
GO
GO

-- ----------------------------
-- Table structure for t_teacher
-- ----------------------------
DROP TABLE [dbo].[t_teacher]
GO
CREATE TABLE [dbo].[t_teacher] (
[tid] varchar(20) NOT NULL ,
[tname] varchar(20) NOT NULL ,
[sex] varchar(2) NOT NULL ,
[birthday] date NULL ,
[education] varchar(20) NULL ,
[tel] varchar(11) NULL ,
[post] varchar(10) NOT NULL ,
[remarks] varchar(100) NULL 
)


GO

-- ----------------------------
-- Records of t_teacher
-- ----------------------------
INSERT INTO [dbo].[t_teacher] ([tid], [tname], [sex], [birthday], [education], [tel], [post], [remarks]) VALUES (N'g13353952929', N'刘文甫', N'男', N'1989-06-12', N'本科', N'13353952929', N'讲师', N'')
GO
GO
INSERT INTO [dbo].[t_teacher] ([tid], [tname], [sex], [birthday], [education], [tel], [post], [remarks]) VALUES (N'g17719100357', N'李佳', N'男', N'1989-01-09', N'本科', N'17719100357', N'班主任', N'')
GO
GO

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE [dbo].[t_user]
GO
CREATE TABLE [dbo].[t_user] (
[name] varchar(20) NOT NULL ,
[pwd] varchar(20) NOT NULL ,
[role] int NOT NULL 
)


GO

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO [dbo].[t_user] ([name], [pwd], [role]) VALUES (N'admin', N'123456', N'4')
GO
GO
INSERT INTO [dbo].[t_user] ([name], [pwd], [role]) VALUES (N'g13353952929', N'123456', N'2')
GO
GO
INSERT INTO [dbo].[t_user] ([name], [pwd], [role]) VALUES (N'g17719100357', N'123456', N'2')
GO
GO
INSERT INTO [dbo].[t_user] ([name], [pwd], [role]) VALUES (N's18339401079', N'123456', N'1')
GO
GO

-- ----------------------------
-- Table structure for t_writtenQuestion
-- ----------------------------
DROP TABLE [dbo].[t_writtenQuestion]
GO
CREATE TABLE [dbo].[t_writtenQuestion] (
[qId] int NOT NULL IDENTITY(1001,1) ,
[qType] varchar(10) NOT NULL ,
[qTitle] varchar(100) NOT NULL ,
[optionA] varchar(100) NOT NULL ,
[optionB] varchar(100) NOT NULL ,
[optionC] varchar(100) NOT NULL ,
[optionD] varchar(100) NOT NULL ,
[answer] varchar(4) NULL DEFAULT ('略') ,
[degree] varchar(4) NOT NULL ,
[csId] int NOT NULL ,
[chapter] varchar(2) NULL 
)


GO
DBCC CHECKIDENT(N'[dbo].[t_writtenQuestion]', RESEED, 1006)
GO

-- ----------------------------
-- Records of t_writtenQuestion
-- ----------------------------
SET IDENTITY_INSERT [dbo].[t_writtenQuestion] ON
GO
INSERT INTO [dbo].[t_writtenQuestion] ([qId], [qType], [qTitle], [optionA], [optionB], [optionC], [optionD], [answer], [degree], [csId], [chapter]) VALUES (N'1001', N'单选', N'ss1', N'1', N'1', N'1', N'1', N'A', N'简单', N'1', N'T1')
GO
GO
INSERT INTO [dbo].[t_writtenQuestion] ([qId], [qType], [qTitle], [optionA], [optionB], [optionC], [optionD], [answer], [degree], [csId], [chapter]) VALUES (N'1002', N'单选', N'ss1', N'1', N'1', N'1', N'1', N'A', N'一般', N'1', N'T2')
GO
GO
INSERT INTO [dbo].[t_writtenQuestion] ([qId], [qType], [qTitle], [optionA], [optionB], [optionC], [optionD], [answer], [degree], [csId], [chapter]) VALUES (N'1003', N'单选', N'ss2', N'1', N'1', N'1', N'1', N'A', N'困难', N'1', N'T3')
GO
GO
INSERT INTO [dbo].[t_writtenQuestion] ([qId], [qType], [qTitle], [optionA], [optionB], [optionC], [optionD], [answer], [degree], [csId], [chapter]) VALUES (N'1004', N'多选', N'ss3', N'1', N'1', N'1', N'1', N'A', N'简单', N'1', N'T4')
GO
GO
INSERT INTO [dbo].[t_writtenQuestion] ([qId], [qType], [qTitle], [optionA], [optionB], [optionC], [optionD], [answer], [degree], [csId], [chapter]) VALUES (N'1005', N'多选', N'ss4', N'1', N'1', N'1', N'1', N'A', N'一般', N'1', N'T5')
GO
GO
INSERT INTO [dbo].[t_writtenQuestion] ([qId], [qType], [qTitle], [optionA], [optionB], [optionC], [optionD], [answer], [degree], [csId], [chapter]) VALUES (N'1006', N'多选', N'ss5', N'1', N'1', N'1', N'1', N'A', N'困难', N'1', N'T6')
GO
GO
SET IDENTITY_INSERT [dbo].[t_writtenQuestion] OFF
GO

-- ----------------------------
-- Indexes structure for table paper_class
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table paper_class
-- ----------------------------
ALTER TABLE [dbo].[paper_class] ADD PRIMARY KEY ([pcId])
GO

-- ----------------------------
-- Indexes structure for table paper_wquestion
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table paper_wquestion
-- ----------------------------
ALTER TABLE [dbo].[paper_wquestion] ADD PRIMARY KEY ([id])
GO

-- ----------------------------
-- Indexes structure for table t_classInfo
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_classInfo
-- ----------------------------
ALTER TABLE [dbo].[t_classInfo] ADD PRIMARY KEY ([cCode])
GO

-- ----------------------------
-- Indexes structure for table t_course
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_course
-- ----------------------------
ALTER TABLE [dbo].[t_course] ADD PRIMARY KEY ([csId])
GO

-- ----------------------------
-- Indexes structure for table t_machineQuestion
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_machineQuestion
-- ----------------------------
ALTER TABLE [dbo].[t_machineQuestion] ADD PRIMARY KEY ([qId])
GO

-- ----------------------------
-- Indexes structure for table t_paper
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_paper
-- ----------------------------
ALTER TABLE [dbo].[t_paper] ADD PRIMARY KEY ([pId])
GO

-- ----------------------------
-- Indexes structure for table t_student
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_student
-- ----------------------------
ALTER TABLE [dbo].[t_student] ADD PRIMARY KEY ([sid])
GO

-- ----------------------------
-- Indexes structure for table t_teacher
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_teacher
-- ----------------------------
ALTER TABLE [dbo].[t_teacher] ADD PRIMARY KEY ([tid])
GO

-- ----------------------------
-- Indexes structure for table t_user
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_user
-- ----------------------------
ALTER TABLE [dbo].[t_user] ADD PRIMARY KEY ([name])
GO

-- ----------------------------
-- Indexes structure for table t_writtenQuestion
-- ----------------------------

-- ----------------------------
-- Primary Key structure for table t_writtenQuestion
-- ----------------------------
ALTER TABLE [dbo].[t_writtenQuestion] ADD PRIMARY KEY ([qId])
GO
