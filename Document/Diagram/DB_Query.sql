Create Database [StoryLineTool]
GO
/****** Object:  Table [dbo].[Tbl_Author]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
use [StoryLineTool]
GO
CREATE TABLE [dbo].[Tbl_Author](
	[Fld_AuthorName] [nchar](30) NOT NULL,
	[Fld_AuthorID] [numeric](18, 0) NOT NULL,
 CONSTRAINT [PK_Tbl_Author] PRIMARY KEY CLUSTERED 
(
	[Fld_AuthorID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tbl_Comment]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_Comment](
	[Fld_CommentDate] [date] NULL,
	[Fld_CommentText] [nchar](2000) NULL,
	[Fld_CommentID] [numeric](18, 0) NOT NULL,
	[Fld_UserName] [nchar](30) NULL,
 CONSTRAINT [PK_Tbl_Comment] PRIMARY KEY CLUSTERED 
(
	[Fld_CommentID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tbl_Event]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_Event](
	[Fld_QuickNote] [nchar](120) NULL,
	[Fld_EventName] [nchar](30) NOT NULL,
	[Fld_EventDate] [date] NULL,
	[Fld_Chapter] [nchar](30) NULL,
	[Fld_Role] [nchar](30) NULL,
	[Fld_Time] [time](7) NULL,
 CONSTRAINT [PK_Tbl_Event] PRIMARY KEY CLUSTERED 
(
	[Fld_EventName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tbl_EventCard]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_EventCard](
	[Fld_EventName] [nchar](30) NULL,
	[Fld_AuthorID] [numeric](18, 0) NULL,
	[Fld_EventCardID] [numeric](18, 0) NOT NULL,
	[Fld_CommentID] [numeric](18, 0) NULL,
	[Fld_NoteID] [numeric](18, 0) NULL,
	[Fld_PreRelation] [nchar](30) NULL,
	[Fld_AftaRelation] [nchar](30) NULL,
 CONSTRAINT [PK_Tbl_EventCard] PRIMARY KEY CLUSTERED 
(
	[Fld_EventCardID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tbl_Note]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_Note](
	[Fld_Location] [nchar](10) NULL,
	[Fld_Role] [nchar](10) NULL,
	[Fld_Background] [nchar](10) NULL,
	[Fld_Action] [nchar](10) NULL,
	[Fld_Result] [nchar](10) NULL,
	[Fld_NoteID] [numeric](18, 0) NOT NULL,
	[Fld_NoteText] [nchar](2000) NULL,
 CONSTRAINT [PK_Tbl_Note] PRIMARY KEY CLUSTERED 
(
	[Fld_NoteID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tbl_Story]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_Story](
	[Fld_Chapter] [nchar](30) NULL,
	[Fld_Direction] [nchar](30) NULL,
	[Fld_StoryName] [nchar](30) NOT NULL,
	[Fld_EventCardID] [numeric](18, 0) NULL,
 CONSTRAINT [PK_Tbl_Story_1] PRIMARY KEY CLUSTERED 
(
	[Fld_StoryName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tbl_TimeLine]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_TimeLine](
	[Fld_EventsChronologically] [nchar](30) NOT NULL,
	[Fld_StoryName] [nchar](30) NULL,
 CONSTRAINT [PK_Tbl_TimeLine] PRIMARY KEY CLUSTERED 
(
	[Fld_EventsChronologically] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Tbl_User]    Script Date: 01-06-2021 13:29:03 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Tbl_User](
	[Fld_UserName] [nchar](30) NOT NULL,
	[Fld_Password] [nchar](30) NULL,
	[Fld_AuthorID] [numeric](18, 0) NULL,
 CONSTRAINT [PK_Tbl_User] PRIMARY KEY CLUSTERED 
(
	[Fld_UserName] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[Tbl_Comment]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_Comment_Tbl_User] FOREIGN KEY([Fld_UserName])
REFERENCES [dbo].[Tbl_User] ([Fld_UserName])
GO
ALTER TABLE [dbo].[Tbl_Comment] CHECK CONSTRAINT [FK_Tbl_Comment_Tbl_User]
GO
ALTER TABLE [dbo].[Tbl_EventCard]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_EventCard_Tbl_Author] FOREIGN KEY([Fld_AuthorID])
REFERENCES [dbo].[Tbl_Author] ([Fld_AuthorID])
GO
ALTER TABLE [dbo].[Tbl_EventCard] CHECK CONSTRAINT [FK_Tbl_EventCard_Tbl_Author]
GO
ALTER TABLE [dbo].[Tbl_EventCard]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_EventCard_Tbl_Comment] FOREIGN KEY([Fld_CommentID])
REFERENCES [dbo].[Tbl_Comment] ([Fld_CommentID])
GO
ALTER TABLE [dbo].[Tbl_EventCard] CHECK CONSTRAINT [FK_Tbl_EventCard_Tbl_Comment]
GO
ALTER TABLE [dbo].[Tbl_EventCard]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_EventCard_Tbl_Event] FOREIGN KEY([Fld_EventName])
REFERENCES [dbo].[Tbl_Event] ([Fld_EventName])
GO
ALTER TABLE [dbo].[Tbl_EventCard] CHECK CONSTRAINT [FK_Tbl_EventCard_Tbl_Event]
GO
ALTER TABLE [dbo].[Tbl_EventCard]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_EventCard_Tbl_Note] FOREIGN KEY([Fld_NoteID])
REFERENCES [dbo].[Tbl_Note] ([Fld_NoteID])
GO
ALTER TABLE [dbo].[Tbl_EventCard] CHECK CONSTRAINT [FK_Tbl_EventCard_Tbl_Note]
GO
ALTER TABLE [dbo].[Tbl_Story]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_Story_Tbl_EventCard] FOREIGN KEY([Fld_EventCardID])
REFERENCES [dbo].[Tbl_EventCard] ([Fld_EventCardID])
GO
ALTER TABLE [dbo].[Tbl_Story] CHECK CONSTRAINT [FK_Tbl_Story_Tbl_EventCard]
GO
ALTER TABLE [dbo].[Tbl_TimeLine]  WITH CHECK ADD  CONSTRAINT [FK_Tbl_TimeLine_Tbl_Story] FOREIGN KEY([Fld_StoryName])
REFERENCES [dbo].[Tbl_Story] ([Fld_StoryName])
GO
ALTER TABLE [dbo].[Tbl_TimeLine] CHECK CONSTRAINT [FK_Tbl_TimeLine_Tbl_Story]
GO
