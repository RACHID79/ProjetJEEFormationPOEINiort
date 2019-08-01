USE RESTAURANT
GO

CREATE TABLE plat (
id_plat INT NOT NULL IDENTITY(1,1),
prix float not null,
nom varchar(50) not null,
presentation varchar(250) not null,
niveau varchar(24) not null,
cout varchar(24) not null,
nbconvive int not null,
nbcommande int not null,
listingredient varchar(500) not null,
imageurl varchar(50) not null,
CONSTRAINT [PK_plat] PRIMARY KEY CLUSTERED (id_plat)
);
go

CREATE TABLE utilisateur (
id_utilisateur INT NOT NULL IDENTITY(1,1),
nom varchar(24) not null,
prenom varchar(24) not null,
email varchar(100) not null,
mdp varchar(24) not null,
commentaire varchar(200) null,
CONSTRAINT [PK_utilisateur] PRIMARY KEY CLUSTERED (id_utilisateur)
);
go


CREATE TABLE commentaire (
id_commentaire INT NOT NULL IDENTITY(1,1) ,
id_plat int  NOT NULL,
id_utilisateur int not null,
note int not null,
commentaire varchar(200) null,
date datetime not null,
CONSTRAINT [PK_commentaire] PRIMARY KEY CLUSTERED (id_commentaire),
CONSTRAINT [FK_commentaire_plat] FOREIGN KEY (id_plat) REFERENCES plat (id_plat),
CONSTRAINT [FK_commentaire_utilisateur] FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id_utilisateur),
);
go

CREATE TABLE role_utilisateur (
id_ru INT NOT NULL IDENTITY(1,1) ,
id_utilisateur int not null,
code_role varchar(24) not null,
commentaire varchar(200)  null,
CONSTRAINT [PK_ru_utilisateur] PRIMARY KEY CLUSTERED (id_ru),
CONSTRAINT [FK_ru_utilisateur] FOREIGN KEY (id_utilisateur) REFERENCES utilisateur (id_utilisateur),
);
go

CREATE TABLE restaurant (
id_restaurant INT NOT NULL IDENTITY(1,1) ,
nom varchar(50) not null,
map_url varchar(520) not null,
url_image varchar(50)  null,
CONSTRAINT [PK_restaurant] PRIMARY KEY CLUSTERED (id_restaurant)
);
go



