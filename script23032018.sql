USE [master]
GO
/****** Object:  Database [dbclub]    Script Date: 3/23/2018 10:10:18 AM ******/
CREATE DATABASE [dbclub]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'college club management', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\college club management.mdf' , SIZE = 3072KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'college club management_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.SQLEXPRESS\MSSQL\DATA\college club management_log.ldf' , SIZE = 1024KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [dbclub] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [dbclub].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [dbclub] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [dbclub] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [dbclub] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [dbclub] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [dbclub] SET ARITHABORT OFF 
GO
ALTER DATABASE [dbclub] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [dbclub] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [dbclub] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [dbclub] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [dbclub] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [dbclub] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [dbclub] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [dbclub] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [dbclub] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [dbclub] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [dbclub] SET  DISABLE_BROKER 
GO
ALTER DATABASE [dbclub] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [dbclub] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [dbclub] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [dbclub] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [dbclub] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [dbclub] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [dbclub] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [dbclub] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [dbclub] SET  MULTI_USER 
GO
ALTER DATABASE [dbclub] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [dbclub] SET DB_CHAINING OFF 
GO
ALTER DATABASE [dbclub] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [dbclub] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [dbclub]
GO
/****** Object:  StoredProcedure [dbo].[prcInsertClub]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertClub]
@name varchar(50),
@dor date,
@type varchar(50),
@tinch	varchar(50),
@sinch varchar(50),
@email	varchar(50),
@flink  varchar(50),
@wlink varchar(50),
@cnum bigint,
@rfee money
as
begin
if(not exists(select * from tbclub where Name=@name ))
begin
insert into tbClub values(
@name ,
@dor ,
@type ,
@tinch	,
@sinch ,
@email	,
@flink  ,
@wlink ,
@cnum ,
@rfee ,
'Active'
)
end
end
GO
/****** Object:  StoredProcedure [dbo].[prcInsertEvent]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertEvent]
@title varchar(50),
@date date,
@venue varchar(50),
@type	varchar(50),
@clubid bigint,
@tinch	varchar(50),
@sinch  varchar(50),
@p1 varchar(50),
@p2 varchar(50),
@p3 varchar(50),
@desc varchar(max),
@pfee money
as
begin
if(not exists(select * from tbEvent where Title=@title ))
begin
insert into tbEvent values(
@title ,
@date ,
@venue ,
@type	,
@clubid ,
@tinch	,
@sinch  ,
@p1 ,
@p2 ,
@p3 ,
@desc ,
'Active',
@pfee
)
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcInsertMemRegister]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertMemRegister]
@name varchar(50),
@course varchar(50),
@year money,
@rno bigint,
@cnum bigint,
@email varchar(50),
@add	varchar(50),
@city  varchar(50),
@s1 varchar(50),
@s2 varchar(50),
@clubid bigint,
@dor date,
@amntpd money,
@bal money
as
begin
if(not exists(select * from tbMemRegister where [RollNo.]=@rno and ClubID=@clubid))
begin
insert into tbMemRegister values(
@name ,
@course ,
@year ,
@rno	,
@cnum ,
@email,
@add	,
@city  ,
@s1 ,
@s2 ,
@clubid ,
@dor,
@amntpd,
@bal,
'Active'
)
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcInsertParticipation]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertParticipation]
@name varchar(50),
@course varchar(50),
@year money,
@rno bigint,
@cnum bigint,
@add	varchar(50),
@city  varchar(50),
@eventid bigint,
@dor date,
@amntpd money,
@bal money,
@email varchar(50)
as
begin
if(not exists(select * from tbParticipation where [RollNo.]=@rno and EventID=@eventid))
begin
insert into tbParticipation values(
@name ,
@course ,
@year ,
@rno ,
@cnum ,
@add	,
@city  ,
@eventid ,
@dor,
@amntpd ,
@bal ,
@email 
)
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcInsertResult]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertResult]
@eventid bigint,
@rdate date,
@pid1 bigint,
@pid2 bigint,
@pid3 bigint
as
begin
if(not exists(select * from tbResult where EventID=@eventid and Prize1WinnerID= @pid1 and Prize2WinnerID= @pid2 and Prize3WinnerID= @pid3))
begin
insert into tbResult values(
@eventid ,
@rdate ,
@pid1 ,
@pid2 ,
@pid3 
)
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcInsertUser]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertUser]
@Usrnme varchar(50),
@pass varchar(50)
as
begin
if(not exists(select * from tbLogin where Username=@Usrnme ))
begin
insert into tbLogin values(
@Usrnme ,
@pass 
)
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcInsertUsr]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertUsr]
@Usrnme varchar(50),
@pass varchar(50)
as
begin
if(not exists(select * from tbLogin where Username=@Usrnme ))
begin
insert into tbLogin values(
@Usrnme ,
@pass 
)
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcInsertVolunteer]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcInsertVolunteer]
@eventid bigint,
@regid bigint,
@dutydesc varchar(max),
@doa date
as
begin
if(not exists(select * from tbVolunteer where EventID=@eventid and RegistrationID= @regid))
begin
insert into tbVolunteer values(
@eventid ,
@regid ,
@dutydesc ,
@doa,
'Active' 
)
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcRemoveUser]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcRemoveUser]
@Usrnme varchar(50),
@pass varchar(50)
as
begin
if(exists(select * from tbLogin where Username=@Usrnme ))
begin
delete from tbLogin where Username=@Usrnme
end
end

GO
/****** Object:  StoredProcedure [dbo].[prcUpdateClub]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcUpdateClub]
@clubid bigint,
@name varchar(50),
@dor date,
@type varchar(50),
@tinch	varchar(50),
@sinch varchar(50),
@email	varchar(50),
@flink  varchar(50),
@wlink varchar(50),
@cnum bigint,
@rfee money,
@status varchar(50)
as 
begin
if(not exists (select * from tbClub where Name= @name and ClubID=@clubid))
begin
update tbClub set
Name=@name ,
DateofRegistration= @dor ,
Type=  @type ,
TeacherIncharge=  @tinch,
StudentIncharge= @sinch ,
EmailID= @email	,
FacebookLink= @flink  ,
WebLink=  @wlink ,
ContactNumber=  @cnum ,
RegisterationFee=  @rfee,
Status= @status
where ClubID=@clubid
end
end
GO
/****** Object:  StoredProcedure [dbo].[prcUpdateEvent]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcUpdateEvent]
@eventid bigint,
@title varchar(50),
@date date,
@venue varchar(50),
@type	varchar(50),
@clubid bigint,
@tinch	varchar(50),
@sinch  varchar(50),
@p1 varchar(50),
@p2 varchar(50),
@p3 varchar(50),
@desc varchar(max),
@status varchar(50),
@pfee money
as 
begin
if(not exists (select * from tbEvent where Title= @title and EventID=@eventid))
begin
update tbEvent set
Title =@title ,
Date= @date ,
Venue= @venue ,
Type= @type	,
ClubID= @clubid ,
TeacherIncharge= @tinch	,
StudentIncharge= @sinch  ,
Prize1= @p1 ,
Prize2=@p2 ,
Prize3=@p3 ,
Description= @desc ,
Status= @status,
ParticipationFee= @pfee
where EventID=@eventid
end
end
GO
/****** Object:  StoredProcedure [dbo].[prcUpdateMemRegister]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcUpdateMemRegister]
@regid bigint,
@name varchar(50),
@course date,
@year money,
@rno bigint,
@cnum bigint,
@add	varchar(50),
@city  varchar(50),
@s1 varchar(50),
@s2 varchar(50),
@clubid bigint,
@dor date,
@amntpd money,
@bal money,
@status varchar(50),
@email varchar(50)
as 
begin
if(not exists (select * from tbMemRegister where Name= @name and RegistrationID=@regid))
begin
update tbMemRegister set
Name =@name ,
Course= @course ,
Year= @year ,
[RollNo.]= @rno	,
ContactNumber= @cnum ,
Address= @add	,
City= @city  ,
Skill1= @s1 ,
Skill2= @s2 ,
ClubID= @clubid ,
RegistrationDate= @dor,
AmountPaid= @amntpd,
Balance= @bal,
Status=@status,
Email= @email
where RegistrationID=@regid
end
end
GO
/****** Object:  StoredProcedure [dbo].[prcUpdateParticipation]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcUpdateParticipation]
@partid bigint,
@name varchar(50),
@course date,
@year money,
@rno bigint,
@cnum bigint,
@add	varchar(50),
@city  varchar(50),
@eventid bigint,
@dor date,
@amntpd money,
@bal money,
@email varchar(50)
as 
begin
if(not exists (select * from tbParticipation where [RollNo.]= @rno and ParticipationID=@partid))
begin
update tbParticipation set
Name= @name ,
Course= @course ,
Year= @year ,
[RollNo.]= @rno ,
ContactNumber= @cnum ,
Address= @add	,
City= @city  ,
EventID= @eventid ,
RegistrationDate= @dor ,
AmountPaid= @amntpd ,
Balance= @bal ,
Email= @email 
where ParticipationID=@partid
end
end
GO
/****** Object:  StoredProcedure [dbo].[prcUpdatePass]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE proc [dbo].[prcUpdatePass]
@Usrnme varchar(50),
@pass varchar(50),
@pass1 varchar(50)
as 
begin
if(exists (select * from tbLogin where Username= @usrnme and Password=@pass1))
begin
update tbLogin set
Password=@pass
where Username=@Usrnme
end
end
GO
/****** Object:  StoredProcedure [dbo].[prcUpdateResult]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create proc [dbo].[prcUpdateResult]
@resultid bigint,
@eventid bigint,
@rdate date,
@pid1 bigint,
@pid2 bigint,
@pid3 bigint
as 
begin
if(not exists (select * from tbResult where EventID=@eventid and Prize1WinnerID= @pid1 and Prize2WinnerID= @pid2 and Prize3WinnerID= @pid3))
begin
update tbResult set
EventID= @eventid ,
ResultDate= @rdate ,
Prize1WinnerID= @pid1 ,
Prize2WinnerID= @pid2 ,
Prize3WinnerID= @pid3 
where ResultID=@resultid
end
end
GO
/****** Object:  Table [dbo].[tbClub]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbClub](
	[ClubID] [bigint] IDENTITY(1000,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[DateofRegistration] [date] NOT NULL,
	[Type] [varchar](50) NOT NULL,
	[TeacherIncharge] [varchar](50) NOT NULL,
	[StudentIncharge] [varchar](50) NOT NULL,
	[EmailID] [varchar](50) NOT NULL,
	[FacebookLink] [varchar](50) NULL,
	[WebLink] [varchar](50) NULL,
	[ContactNumber] [bigint] NOT NULL,
	[RegisterationFee] [money] NULL,
	[Status] [varchar](50) NULL,
 CONSTRAINT [PK_tbClub] PRIMARY KEY CLUSTERED 
(
	[ClubID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbEvent]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbEvent](
	[EventID] [bigint] IDENTITY(2000,1) NOT NULL,
	[Title] [varchar](50) NOT NULL,
	[Date] [date] NOT NULL,
	[Venue] [varchar](50) NOT NULL,
	[Type] [varchar](50) NOT NULL,
	[ClubID] [bigint] NOT NULL,
	[TeacherIncharge] [varchar](50) NOT NULL,
	[StudentIncharge] [varchar](50) NOT NULL,
	[Prize1] [varchar](50) NOT NULL,
	[Prize2] [varchar](50) NOT NULL,
	[Prize3] [varchar](50) NOT NULL,
	[Description] [varchar](max) NOT NULL,
	[Status] [varchar](50) NOT NULL,
	[ParticipationFee] [money] NOT NULL,
 CONSTRAINT [PK_tbEvent] PRIMARY KEY CLUSTERED 
(
	[EventID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbLogin]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbLogin](
	[Username] [varchar](50) NOT NULL,
	[Password] [varchar](50) NOT NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbMemRegister]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbMemRegister](
	[RegistrationID] [bigint] IDENTITY(3000,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Course] [varchar](50) NOT NULL,
	[Year] [money] NOT NULL,
	[RollNo.] [bigint] NOT NULL,
	[ContactNumber] [bigint] NOT NULL,
	[Email] [varchar](50) NOT NULL,
	[Address] [varchar](50) NOT NULL,
	[City] [varchar](50) NOT NULL,
	[Skill1] [varchar](50) NOT NULL,
	[Skill2] [varchar](50) NOT NULL,
	[ClubID] [bigint] NOT NULL,
	[RegistrationDate] [date] NOT NULL,
	[AmountPaid] [money] NOT NULL,
	[Balance] [money] NOT NULL,
	[Status] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tbMemRegister] PRIMARY KEY CLUSTERED 
(
	[RegistrationID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbParticipation]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbParticipation](
	[ParticipationID] [bigint] IDENTITY(500,1) NOT NULL,
	[Name] [varchar](50) NOT NULL,
	[Course] [varchar](50) NOT NULL,
	[Year] [money] NOT NULL,
	[RollNo.] [varchar](50) NOT NULL,
	[ContactNumber] [bigint] NOT NULL,
	[Address] [varchar](50) NOT NULL,
	[City] [varchar](50) NOT NULL,
	[EventID] [bigint] NOT NULL,
	[RegistrationDate] [date] NOT NULL,
	[AmountPaid] [money] NOT NULL,
	[Balance] [money] NOT NULL,
	[Email] [varchar](50) NOT NULL,
 CONSTRAINT [PK_tbParticipation] PRIMARY KEY CLUSTERED 
(
	[ParticipationID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tbResult]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tbResult](
	[ResultID] [bigint] IDENTITY(6000,1) NOT NULL,
	[EventID] [bigint] NOT NULL,
	[ResultDate] [date] NOT NULL,
	[Prize1WinnerID] [bigint] NOT NULL,
	[Prize2WinnerID] [bigint] NOT NULL,
	[Prize3WinnerID] [bigint] NOT NULL,
 CONSTRAINT [PK_tbResult] PRIMARY KEY CLUSTERED 
(
	[ResultID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tbVolunteer]    Script Date: 3/23/2018 10:10:18 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[tbVolunteer](
	[VolunteerID] [bigint] IDENTITY(7000,1) NOT NULL,
	[EventID] [bigint] NOT NULL,
	[RegistrationID] [bigint] NOT NULL,
	[DutyDescription] [varchar](max) NOT NULL,
	[DateofAssgining] [date] NOT NULL,
	[Status] [varchar](50) NULL,
 CONSTRAINT [PK_tbVolunteer] PRIMARY KEY CLUSTERED 
(
	[VolunteerID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[tbClub] ON 

GO
INSERT [dbo].[tbClub] ([ClubID], [Name], [DateofRegistration], [Type], [TeacherIncharge], [StudentIncharge], [EmailID], [FacebookLink], [WebLink], [ContactNumber], [RegisterationFee], [Status]) VALUES (1000, N'm', CAST(0xFE3E0B00 AS Date), N'j', N'f', N't', N'h', N'h', N'y', 8500215576, 600.0000, N'Inactive')
GO
INSERT [dbo].[tbClub] ([ClubID], [Name], [DateofRegistration], [Type], [TeacherIncharge], [StudentIncharge], [EmailID], [FacebookLink], [WebLink], [ContactNumber], [RegisterationFee], [Status]) VALUES (1001, N'n', CAST(0x5B950A00 AS Date), N'', N'', N'', N'', N'jkb', N'jkn', 4545, 4.0000, N'Active')
GO
SET IDENTITY_INSERT [dbo].[tbClub] OFF
GO
SET IDENTITY_INSERT [dbo].[tbEvent] ON 

GO
INSERT [dbo].[tbEvent] ([EventID], [Title], [Date], [Venue], [Type], [ClubID], [TeacherIncharge], [StudentIncharge], [Prize1], [Prize2], [Prize3], [Description], [Status], [ParticipationFee]) VALUES (2000, N'manan', CAST(0xD63D0B00 AS Date), N'ghfg', N'vhjfg', 1000, N'hjgvhg', N'vchg', N'c', N'gc', N'fgc', N'fgc', N'Active', 7755.0000)
GO
INSERT [dbo].[tbEvent] ([EventID], [Title], [Date], [Venue], [Type], [ClubID], [TeacherIncharge], [StudentIncharge], [Prize1], [Prize2], [Prize3], [Description], [Status], [ParticipationFee]) VALUES (2001, N'mnn', CAST(0xE83D0B00 AS Date), N'gyub', N'v', 1000, N'vgyvhg', N'vgh', N'vhg', N'cvgh', N'cg', N'cgh', N'Active', 53415.0000)
GO
SET IDENTITY_INSERT [dbo].[tbEvent] OFF
GO
INSERT [dbo].[tbLogin] ([Username], [Password]) VALUES (N'mnn', N'j')
GO
SET IDENTITY_INSERT [dbo].[tbMemRegister] ON 

GO
INSERT [dbo].[tbMemRegister] ([RegistrationID], [Name], [Course], [Year], [RollNo.], [ContactNumber], [Email], [Address], [City], [Skill1], [Skill2], [ClubID], [RegistrationDate], [AmountPaid], [Balance], [Status]) VALUES (3000, N'ram', N'jhbh', 3456.0000, 45, 435, N'4', N'234', N'3', N'432', N'42', 1000, CAST(0xD63D0B00 AS Date), 156.0000, 45.0000, N'Active')
GO
SET IDENTITY_INSERT [dbo].[tbMemRegister] OFF
GO
SET IDENTITY_INSERT [dbo].[tbParticipation] ON 

GO
INSERT [dbo].[tbParticipation] ([ParticipationID], [Name], [Course], [Year], [RollNo.], [ContactNumber], [Address], [City], [EventID], [RegistrationDate], [AmountPaid], [Balance], [Email]) VALUES (500, N'jhcgff', N'hf', 67.0000, N'545', 3537357435, N'537537', N'357357', 2000, CAST(0xD53D0B00 AS Date), 53746.0000, 35.0000, N'4735')
GO
INSERT [dbo].[tbParticipation] ([ParticipationID], [Name], [Course], [Year], [RollNo.], [ContactNumber], [Address], [City], [EventID], [RegistrationDate], [AmountPaid], [Balance], [Email]) VALUES (501, N'hgfvgh', N'vghvhg', 64.0000, N'65453', 453, N'yufvg', N'gcv', 2000, CAST(0xD63D0B00 AS Date), 54156.0000, 151.0000, N'hgfyeuqk')
GO
INSERT [dbo].[tbParticipation] ([ParticipationID], [Name], [Course], [Year], [RollNo.], [ContactNumber], [Address], [City], [EventID], [RegistrationDate], [AmountPaid], [Balance], [Email]) VALUES (502, N'mnn', N'nhvujh', 151.0000, N'56151', 51561, N'36135', N'vghvhg', 2000, CAST(0xD63D0B00 AS Date), 465.0000, 453.0000, N'vytgv')
GO
SET IDENTITY_INSERT [dbo].[tbParticipation] OFF
GO
SET IDENTITY_INSERT [dbo].[tbResult] ON 

GO
INSERT [dbo].[tbResult] ([ResultID], [EventID], [ResultDate], [Prize1WinnerID], [Prize2WinnerID], [Prize3WinnerID]) VALUES (6003, 2000, CAST(0xD63D0B00 AS Date), 501, 500, 502)
GO
INSERT [dbo].[tbResult] ([ResultID], [EventID], [ResultDate], [Prize1WinnerID], [Prize2WinnerID], [Prize3WinnerID]) VALUES (6004, 2000, CAST(0xD63D0B00 AS Date), 501, 501, 502)
GO
SET IDENTITY_INSERT [dbo].[tbResult] OFF
GO
SET IDENTITY_INSERT [dbo].[tbVolunteer] ON 

GO
INSERT [dbo].[tbVolunteer] ([VolunteerID], [EventID], [RegistrationID], [DutyDescription], [DateofAssgining], [Status]) VALUES (7000, 2000, 3000, N'security', CAST(0xD63D0B00 AS Date), N'Active')
GO
SET IDENTITY_INSERT [dbo].[tbVolunteer] OFF
GO
ALTER TABLE [dbo].[tbEvent]  WITH CHECK ADD  CONSTRAINT [FK_tbEvent_tbClub] FOREIGN KEY([ClubID])
REFERENCES [dbo].[tbClub] ([ClubID])
GO
ALTER TABLE [dbo].[tbEvent] CHECK CONSTRAINT [FK_tbEvent_tbClub]
GO
ALTER TABLE [dbo].[tbMemRegister]  WITH CHECK ADD  CONSTRAINT [FK_tbMemRegister_tbClub] FOREIGN KEY([ClubID])
REFERENCES [dbo].[tbClub] ([ClubID])
GO
ALTER TABLE [dbo].[tbMemRegister] CHECK CONSTRAINT [FK_tbMemRegister_tbClub]
GO
ALTER TABLE [dbo].[tbResult]  WITH CHECK ADD  CONSTRAINT [FK_tbResult_tbEvent2] FOREIGN KEY([EventID])
REFERENCES [dbo].[tbEvent] ([EventID])
GO
ALTER TABLE [dbo].[tbResult] CHECK CONSTRAINT [FK_tbResult_tbEvent2]
GO
ALTER TABLE [dbo].[tbResult]  WITH CHECK ADD  CONSTRAINT [FK_tbResult_tbParticipation] FOREIGN KEY([Prize1WinnerID])
REFERENCES [dbo].[tbParticipation] ([ParticipationID])
GO
ALTER TABLE [dbo].[tbResult] CHECK CONSTRAINT [FK_tbResult_tbParticipation]
GO
ALTER TABLE [dbo].[tbResult]  WITH CHECK ADD  CONSTRAINT [FK_tbResult_tbParticipation1] FOREIGN KEY([Prize2WinnerID])
REFERENCES [dbo].[tbParticipation] ([ParticipationID])
GO
ALTER TABLE [dbo].[tbResult] CHECK CONSTRAINT [FK_tbResult_tbParticipation1]
GO
ALTER TABLE [dbo].[tbResult]  WITH CHECK ADD  CONSTRAINT [FK_tbResult_tbParticipation2] FOREIGN KEY([Prize3WinnerID])
REFERENCES [dbo].[tbParticipation] ([ParticipationID])
GO
ALTER TABLE [dbo].[tbResult] CHECK CONSTRAINT [FK_tbResult_tbParticipation2]
GO
ALTER TABLE [dbo].[tbVolunteer]  WITH CHECK ADD  CONSTRAINT [FK_tbVolunteer_tbEvent] FOREIGN KEY([EventID])
REFERENCES [dbo].[tbEvent] ([EventID])
GO
ALTER TABLE [dbo].[tbVolunteer] CHECK CONSTRAINT [FK_tbVolunteer_tbEvent]
GO
ALTER TABLE [dbo].[tbVolunteer]  WITH CHECK ADD  CONSTRAINT [FK_tbVolunteer_tbMemRegister] FOREIGN KEY([RegistrationID])
REFERENCES [dbo].[tbMemRegister] ([RegistrationID])
GO
ALTER TABLE [dbo].[tbVolunteer] CHECK CONSTRAINT [FK_tbVolunteer_tbMemRegister]
GO
ALTER TABLE [dbo].[tbVolunteer]  WITH CHECK ADD  CONSTRAINT [FK_tbVolunteer_tbMemRegister1] FOREIGN KEY([RegistrationID])
REFERENCES [dbo].[tbMemRegister] ([RegistrationID])
GO
ALTER TABLE [dbo].[tbVolunteer] CHECK CONSTRAINT [FK_tbVolunteer_tbMemRegister1]
GO
USE [master]
GO
ALTER DATABASE [dbclub] SET  READ_WRITE 
GO
