USE [master]
GO
drop database UserManagement
go

CREATE DATABASE [UserManagement] 

USE [UserManagement]
GO


CREATE TABLE [dbo].[tblUsers](
	[userID] [nvarchar](50) NOT NULL,
	[fullName] [nvarchar](50) NULL,
	[password] [nvarchar](50) NULL,
	[roleID] [nvarchar](50) NULL,
	[status] [bit] NULL,
	[age] [int] NULL,
 CONSTRAINT [PK_tblUsers] PRIMARY KEY CLUSTERED 
(
	[userID] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO

Create table tblProducts(
	productID nvarchar(50) NOT NULL,
	name nvarchar(50) NULL,
	price int NULL,
	image nvarchar(255) NULL,
	userID nvarchar(50) NOT NULL,
	CONSTRAINT PK_tblProducts PRIMARY KEY(productID)
)
GO


Create table tblProductsInSchop(
	productID nvarchar(50) NOT NULL,
	name nvarchar(50) NULL,
	price int NULL,
	image nvarchar(255) NULL,
	cartID nvarchar(50) NULL,
	CONSTRAINT PK_tblProductsInSchop PRIMARY KEY(productID)
)
GO

Create table tblCart(
	cartID nvarchar(50) NOT NULL,
	userID nvarchar(50) NOT NULL,
	CONSTRAINT PK_tblCart PRIMARY KEY(cartID)
)
GO




INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'admin', N'Toi la admin', N'1', N'AD', 1, 20)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'Hoadnt', N'Hoa Doan', N'1', N'US', 1, 28)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'SE130363', N'Ngo Ha Tri Bao', N'1', N'AD', 1, 22)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'SE140103', N'Phuoc Ha', N'1', N'US', 1, 12)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'SE140119', N'Trai Nguyen', N'1', N'AD', 1, 21)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'SE140130', N'Tam Tran', N'1', N'AD', 1, 34)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'SE140201', N'PHAM HOANG TU', N'1', N'AD', 1, 43)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'SE140969', N'Nguyen Gia Tin', N'123', N'US', 1, 24)
INSERT [dbo].[tblUsers] ([userID], [fullName], [password], [roleID], [status], [age]) VALUES (N'SE150443', N'LE MINH KHOA', N'1', N'US', 1, 25)


INSERT tblProducts(productID, name, price, image, userID) VALUES(N'P001', N'iphone1', 7000, NULL, N'SE130363')
INSERT tblProducts(productID, name, price, image, userID) VALUES(N'P002', N'tablet1', 11000, NULL, N'SE130363')
INSERT tblProducts(productID, name, price, image, userID) VALUES(N'P003', N'mac1', 18000, NULL, N'SE130363')
INSERT tblProducts(productID, name, price, image, userID) VALUES(N'P004', N'laptop1', 20000, NULL, N'SE150443')
INSERT tblProducts(productID, name, price, image, userID) VALUES(N'P005', N'car1', 60000, NULL, N'SE140969')
INSERT tblProducts(productID, name, price, image, userID) VALUES(N'P006', N'samsung1', 6000, NULL, N'SE150443')
INSERT tblProducts(productID, name, price, image, userID) VALUES(N'P007', N'tv1', 20000, NULL, N'admin')


INSERT tblProductsInSchop(productID, name, price, image, cartID) VALUES(N'S001', N'iphone2', 7000, NULL, NULL)
INSERT tblProductsInSchop(productID, name, price, image, cartID) VALUES(N'S002', N'table2', 11000, NULL, NULL)
INSERT tblProductsInSchop(productID, name, price, image, cartID) VALUES(N'S003', N'mac2', 18000, NULL, NULL)
INSERT tblProductsInSchop(productID, name, price, image, cartID) VALUES(N'S004', N'laptop2', 20000, NULL, NULL)
INSERT tblProductsInSchop(productID, name, price, image, cartID) VALUES(N'S005', N'car2', 60000, NULL, NULL)
INSERT tblProductsInSchop(productID, name, price, image, cartID) VALUES(N'S006', N'samsung2', 6000, NULL, NULL)
INSERT tblProductsInSchop(productID, name, price, image, cartID) VALUES(N'S007', N'tv2', 20000, NULL, NULL)



ALTER TABLE tblProducts ADD CONSTRAINT FK_tblProducts FOREIGN KEY(userID)
REFERENCES [tblUsers](userID)
GO

ALTER TABLE tblProductsInSchop ADD CONSTRAINT FK_tblProductsInSchop FOREIGN KEY(cartID)
REFERENCES tblCart(cartID)
GO

ALTER TABLE tblCart ADD CONSTRAINT FK_tblCart FOREIGN KEY(userID)
REFERENCES [tblUsers](userID)
GO
