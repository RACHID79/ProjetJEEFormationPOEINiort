USE [RESTAURANT]
GO

INSERT INTO [dbo].[commentaire]
           ([id_plat]
           ,[id_utilisateur]
           ,[note]
           ,[commentaire]
           ,[date])
     VALUES
           (5,1,1,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',getdate()),
		   (5,1,4,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eico labin voluptate velit esse cillum dolore eu fugiat nulla pariatur.',getdate()),
		   (5,1,5,'Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.',getdate()),
		   (5,1,0,'Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam',getdate())
GO



