USE master

GO
CREATE DATABASE Photographer
GO
USE Photographer
GO
CREATE TABLE Gallery(
    gallery_id INT IDENTITY(1,1) PRIMARY KEY,
	title NVARCHAR(50),
	[description] NVARCHAR(max),
	main_image NVARCHAR(50),
	view_number INT 
)
GO
CREATE TABLE Images(
	id int IDENTITY(1,1) PRIMARY KEY,
	gallery_id int FOREIGN KEY REFERENCES Gallery(gallery_id),
	image_url nvarchar(50)
)
GO
CREATE TABLE Contact(
	[address] nvarchar(200),
	[city] nvarchar(200),
	[country] nvarchar(50),
	[telephone] nvarchar(50),
	[email] nvarchar(200),
	[about] nvarchar(max),
	[main_image] nvarchar(50),
	[short_description] nvarchar(50),
	[map] nvarchar(50)
)
GO
SET IDENTITY_INSERT [dbo].[Gallery] ON 
GO
DELETE FROM Gallery
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (1, N'Gallery 1', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'1.jpg', 9)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (2, N'Gallery 2', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'2.jpg', 8)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (3, N'Gallery 3', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'3.jpg', 3)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (4, N'Gallery 4', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'4.jpg', 4)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (5, N'Gallery 5', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'5.jpg', 7)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (6, N'Gallery 6', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'6.jpg', 8)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (7, N'Gallery 7', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'7.jpg', 1)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (8, N'Gallery 8', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'8.jpg', 2)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (9, N'Gallery 9', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'1.jpg', 3)
INSERT [dbo].[Gallery] ([gallery_id], [title], [description], [main_image], view_number) VALUES (10, N'Gallery 10', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation', N'2.jpg', 7)
GO
SET IDENTITY_INSERT [dbo].[Gallery] OFF
GO
SET IDENTITY_INSERT [dbo].[Images] ON 
GO
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (1, 1, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (2, 1, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (3, 1, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (4, 1, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (5, 1, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (6, 1, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (7, 1, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (8, 1, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (9, 2, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (10, 2, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (11, 2, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (12, 2, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (13, 2, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (14, 2, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (15, 2, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (16, 2, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (17, 3, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (18, 3, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (19, 3, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (20, 3, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (21, 3, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (22, 3, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (23, 3, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (24, 3, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (25, 4, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (26, 4, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (27, 4, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (28, 4, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (29, 4, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (30, 4, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (31, 4, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (32, 4, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (33, 5, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (34, 5, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (35, 5, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (36, 5, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (37, 5, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (38, 5, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (39, 5, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (40, 5, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (41, 6, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (42, 6, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (43, 6, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (44, 6, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (45, 6, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (46, 6, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (47, 6, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (48, 6, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (49, 7, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (50, 7, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (51, 7, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (52, 7, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (53, 7, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (54, 7, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (55, 7, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (56, 7, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (57, 8, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (58, 8, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (59, 8, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (60, 8, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (61, 8, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (62, 8, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (63, 8, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (64, 8, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (65, 9, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (66, 9, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (67, 9, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (68, 9, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (69, 9, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (70, 9, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (71, 9, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (72, 9, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (73, 10, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (74, 10, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (75, 10, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (76, 10, N'4.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (77, 10, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (78, 10, N'6.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (79, 10, N'7.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (80, 10, N'8.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (81, 1, N'1.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (82, 1, N'2.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (83, 1, N'3.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (84, 1, N'5.jpg')
INSERT [dbo].[Images] ([id], [gallery_id], [image_url]) VALUES (85, 1, N'6.jpg')
GO
SET IDENTITY_INSERT [dbo].[Images] OFF
GO
INSERT [dbo].[Contact] ([address], [city], [country], [telephone], [email], [about], [main_image], [short_description], [map]) 
VALUES (N'Lục Nam', N'Bắc Giang', N'Việt Nam', N'0968266589', N'minhtbhe130746', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim', N'max.jpg', N'Lorem ipsum dolor sit amet', N'map.png')
GO
CREATE TABLE ShareContent(
   title NVARCHAR(50),
   icon NVARCHAR(50),
   link NVARCHAR(MAX)
)
GO
INSERT INTO ShareContent
VALUES (N'Share on Facebook',N'face.png', N'Facebook')
INSERT INTO ShareContent
VALUES (N'Share on Twitter',N'google.png', N'Facebook')
INSERT INTO ShareContent
VALUES (N'Share on Google+',N'twitter.png', N'Facebook')
GO
CREATE TABLE [View](
   number INT NOT NULL
)
INSERT INTO [View] VALUES(5)
SELECT * FROM Gallery
