USE [QuizDB]
GO
/****** Object:  Table [dbo].[Quiz]    Script Date: 6/8/2018 1:52:32 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Quiz](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Content] [nvarchar](200) NOT NULL,
	[OptA] [nvarchar](150) NOT NULL,
	[OptB] [nvarchar](150) NOT NULL,
	[OptC] [nvarchar](150) NOT NULL,
	[OptD] [nvarchar](150) NOT NULL,
	[Answer] [nvarchar](50) NOT NULL,
	[DateCreated] [date] NULL,
	[CreatorID] [int] NULL,
 CONSTRAINT [PK_Quiz] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Test_Result]    Script Date: 6/8/2018 1:52:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Test_Result](
	[UserID] [int] NOT NULL,
	[Mark] [float] NOT NULL,
	[DateTaken] [date] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserTBL]    Script Date: 6/8/2018 1:52:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserTBL](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Username] [nvarchar](150) NOT NULL,
	[Password] [nvarchar](150) NOT NULL,
	[TypeID] [int] NOT NULL,
	[Email] [nvarchar](150) NULL,
 CONSTRAINT [PK_UserTBL] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserType]    Script Date: 6/8/2018 1:52:34 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserType](
	[ID] [int] NOT NULL,
	[Name] [nvarchar](150) NOT NULL,
 CONSTRAINT [PK_UserType] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET IDENTITY_INSERT [dbo].[Quiz] ON 

INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (1, N'The name of capital of Vietnam after 1975', N'Sai Gon', N'HCM', N'Ha Noi', N'Ha Tinh', N'Ha Noi', CAST(N'2018-05-25' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (2, N'My hometown', N'Ha Noi', N'Ha Tinh', N'Ha Giang', N'Ha Tay', N'Ha Tinh', CAST(N'2018-04-25' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (4, N'Unlucky number of Chinese', N'1', N'2', N'3', N'4', N'4', CAST(N'2018-05-25' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (5, N'How do you say "cá" in English', N'meat', N'fish', N'pork', N'beef', N'fish', CAST(N'2018-10-10' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (6, N'The best footballer to me', N'CR7', N'Messi', N'Rooney', N'None of the above', N'CR7', CAST(N'2018-05-26' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (7, N'Hello, how ... you today?', N'is', N'are', N'am', N'aren''t', N'are', CAST(N'2018-05-26' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (8, N'Có một tàu điện đi về hướng nam. Gió hướng tây bắc. Vậy khói từ con tàu sẽ theo hướng nào?', N'Đông', N'Tây', N'Bắc', N' Không hướng nào', N' Không hướng nào', CAST(N'2018-05-26' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (11, N'Từ gì mà 100% người Việt Nam đều phát âm sai?', N'Đúng', N'Sai', N'Nothing', N'Nothing', N'Sai', CAST(N'2018-07-07' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (12, N'A là đáp án đúng', N'A', N'B', N'C', N'D', N'A', CAST(N'2018-06-07' AS Date), 5)
INSERT [dbo].[Quiz] ([ID], [Content], [OptA], [OptB], [OptC], [OptD], [Answer], [DateCreated], [CreatorID]) VALUES (13, N'Có bao nhiêu chữ C trong câu sau: "Cơm, canh, cá, tất cả em đều thích"?', N'1', N'2', N'4', N'5', N'1', CAST(N'2018-01-01' AS Date), 5)
SET IDENTITY_INSERT [dbo].[Quiz] OFF
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 15, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 20, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 10, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 10, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 5, CAST(N'2018-05-30' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 10, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 10, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (8, 10, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 13.333333969116211, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-05-29' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 0, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 20, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 30, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 40, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 50, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 60, CAST(N'2018-06-07' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (5, 5, CAST(N'2018-06-08' AS Date))
INSERT [dbo].[Test_Result] ([UserID], [Mark], [DateTaken]) VALUES (2, 6, CAST(N'2018-06-06' AS Date))
SET IDENTITY_INSERT [dbo].[UserTBL] ON 

INSERT [dbo].[UserTBL] ([ID], [Username], [Password], [TypeID], [Email]) VALUES (2, N'1', N'1', 1, N'hongmienft@gmail.com')
INSERT [dbo].[UserTBL] ([ID], [Username], [Password], [TypeID], [Email]) VALUES (3, N'mien', N'mien', 2, N'mienabc@zyz')
INSERT [dbo].[UserTBL] ([ID], [Username], [Password], [TypeID], [Email]) VALUES (4, N'miennguyen', N'miennguyen', 2, N'hongmienft98@gmail.com')
INSERT [dbo].[UserTBL] ([ID], [Username], [Password], [TypeID], [Email]) VALUES (5, N'2', N'2', 2, N'eeee@xyz.abc')
INSERT [dbo].[UserTBL] ([ID], [Username], [Password], [TypeID], [Email]) VALUES (6, N'1', N'1', 1, N'1')
INSERT [dbo].[UserTBL] ([ID], [Username], [Password], [TypeID], [Email]) VALUES (7, N'mienabczy', N'Mennthse05583@fpt.edu.vn', 1, N'miennthse05583@fpt.edu.vn')
INSERT [dbo].[UserTBL] ([ID], [Username], [Password], [TypeID], [Email]) VALUES (8, N'sasdfsdfdsfsdfsdf', N'10003dfsdfsdfsdfdsResfdsf@', 1, N'mmmmmmmmmm@mail.cogmmmmmmmm')
SET IDENTITY_INSERT [dbo].[UserTBL] OFF
INSERT [dbo].[UserType] ([ID], [Name]) VALUES (1, N'Student')
INSERT [dbo].[UserType] ([ID], [Name]) VALUES (2, N'Teacher')
ALTER TABLE [dbo].[Quiz]  WITH CHECK ADD  CONSTRAINT [FK_CreatorID] FOREIGN KEY([CreatorID])
REFERENCES [dbo].[UserTBL] ([ID])
GO
ALTER TABLE [dbo].[Quiz] CHECK CONSTRAINT [FK_CreatorID]
GO
ALTER TABLE [dbo].[UserTBL]  WITH CHECK ADD  CONSTRAINT [FK_UserTBL_UserType] FOREIGN KEY([TypeID])
REFERENCES [dbo].[UserType] ([ID])
GO
ALTER TABLE [dbo].[UserTBL] CHECK CONSTRAINT [FK_UserTBL_UserType]
GO
