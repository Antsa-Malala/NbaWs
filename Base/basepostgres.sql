CREATE DATABASE nba;
CREATE user nba WITH PASSWORD 'nba';
GRANT ALL PRIVILEGES ON DATABASE "nba" to nba;
ALTER DATABASE nba OWNER TO nba;

CREATE TABLE Equipe(
    idEquipe serial primary key,
    nomEquipe varchar(60)
);

CREATE TABLE Joueur(
    idJoueur serial primary key,
    nomJoueur varchar(60),
    dateNaissance date,
    mesure double precision,
    idEquipe int,
    sexe varchar(10),
    foreign key(idEquipe) references Equipe(idEquipe)
);

CREATE TABLE Match(
    idMatch serial primary key,
    lieu varchar(60),
    dateDebut date,
    idequipe1 int,
    idequipe2 int,
    foreign key(idEquipe1) references Equipe(idEquipe),
    foreign key(idEquipe2) references Equipe(idEquipe)
);
CREATE TABLE actions(
    idactions serial primary key,
    actions varchar(60)
);

CREATE TABLE Mouvement(
    idmouvement serial primary key,
    idJoueur int,
    idMatch int,
    idActions int,
    points int,
    foreign key(idJoueur) references Joueur(idJoueur),
    foreign key(idMatch) references Match(idMatch),
    foreign key(idActions) references actions(idActions)

);

CREATE TABLE JoueurMatch(
    idJoueur int,
    idMatch int,
    foreign key(idJoueur) references Joueur(idJoueur),
    foreign key(idMatch) references Match(idMatch)
);

CREATE TABLE EntreeJoueurMatch(
    identree serial primary key,
    idJoueur int,
    idMatch int,
    minuteEntree time
);

CREATE TABLE SortieJoueurMatch(
    identree int,
    minuteSortie time,
    foreign key(identree) references EntreeJoueurMatch(identree)
);

CREATE TABLE JoueurEquipe(
    idJoueur int,
    idEquipe int,
    dateDebut date,
    dateFin date,
    foreign key(idJoueur) references Joueur(idJoueur),
    foreign key(idEquipe) references Equipe(idEquipe)
);

CREATE VIEW mpm as 
select sum(s.minutesortie-e.minuteentree) as temps,idjoueur,idmatch 
from sortiejoueurMatch as s 
join entreeJoueurMatch as e on s.identree=e.identree
group by idjoueur,idmatch;

-- Insertion de données pour la table Equipe
INSERT INTO Equipe (nomEquipe) VALUES
    ('Los Angeles Lakers'),
    ('Golden State Warriors'),
    ('Toronto Raptors');

-- Insertion de données pour la table Joueur
INSERT INTO Joueur (nomJoueur, dateNaissance, mesure, idEquipe, sexe) VALUES
    ('LeBron James', '1984-12-30', 203.0, 1, 'Masculin'),
    ('Stephen Curry', '1988-03-14', 191.0, 2, 'Masculin'),
    ('Kawhi Leonard', '1991-06-29', 201.0, 3, 'Masculin'),
    ('Anthony Davis', '1993-03-11', 208.0, 1, 'Masculin'),
    ('Pascal Siakam', '1994-04-02', 206.0, 3, 'Masculin'),
    ('Klay Thompson', '1990-02-08', 201.0, 2, 'Masculin'),
    ('Kyle Lowry', '1986-03-25', 183.0, 3, 'Masculin'),
    ('Draymond Green', '1990-03-04', 200.0, 2, 'Masculin'),
    ('Serge Ibaka', '1989-09-18', 211.0, 3, 'Masculin'),
    ('Marc Gasol', '1985-01-29', 216.0, 3, 'Masculin'),
    ('Dwight Howard', '1985-12-08', 211.0, 1, 'Masculin'),
    ('Fred VanVleet', '1994-02-25', 183.0, 3, 'Masculin'),
    ('Alex Caruso', '1994-02-28', 195.0, 1, 'Masculin'),
    ('Norman Powell', '1993-05-25', 196.0, 3, 'Masculin'),
    ('OG Anunoby', '1997-07-17', 203.0, 3, 'Masculin');

-- Insertion de données pour la table Match
INSERT INTO Match (lieu, dateDebut, idequipe1, idequipe2) VALUES
    ('Staples Center, Los Angeles', '2023-01-15', 1, 2),
    ('Chase Center, San Francisco', '2023-01-18', 2, 3),
    ('Scotiabank Arena, Toronto', '2023-01-20', 1, 3),
    ('Madison Square Garden, New York', '2023-01-22', 2, 1),
    ('Smoothie King Center, New Orleans', '2023-01-25', 3, 1),
    ('TD Garden, Boston', '2023-01-28', 1, 2),
    ('Amway Center, Orlando', '2023-02-01', 3, 1),
    ('United Center, Chicago', '2023-02-03', 2, 3),
    ('Oracle Arena, Oakland', '2023-02-06', 3, 1),
    ('Fiserv Forum, Milwaukee', '2023-02-09', 1, 2);

INSERT INTO JoueurMatch VALUES
(1,1),
(2,1),
(3,1),
(4,1),
(5,1),
(6,1),
(7,1),
(8,1),
(1,2),
(2,2),
(3,2),
(4,2),
(5,2),
(6,2),
(7,2),
(8,2);

INSERT INTO actions(actions) values
('Tir'),
('Rebond'),
('Passe Decisive'),
('Passe'),
('Lance franc');


INSERT INTO mouvement values
(default,1,1,1,0),
(default,1,1,1,2),
(default,1,1,1,3),
(default,1,1,2,0),
(default,1,1,3,0),
(default,1,1,4,1);

-- Insertion de données pour la table EntreeJoueurMatch
INSERT INTO EntreeJoueurMatch (idJoueur, idMatch, minuteEntree) VALUES
    (1, 1, '12:15:00'),
    (2, 1, '12:20:00'),
    (3, 2, '14:30:00'),
    (4, 2, '14:35:00'),
    (5, 3, '16:45:00'),
    (6, 3, '16:50:00'),
    (7, 4, '19:00:00'),
    (8, 4, '19:05:00'),
    (9, 5, '21:15:00'),
    (10, 5, '21:20:00'),
    (1, 2, '21:20:00');

-- Insertion de données pour la table SortieJoueurMatch
INSERT INTO SortieJoueurMatch (identree, minuteSortie) VALUES
    (1, '12:45:00'),
    (2, '12:50:00'),
    (3, '15:00:00'),
    (4, '15:05:00'),
    (5, '17:15:00'),
    (6, '17:20:00'),
    (7, '19:30:00'),
    (8, '19:35:00'),
    (9, '21:45:00'),
    (10, '21:50:00'),
    (11, '21:50:00');


-- Insertion de données pour la table JoueurEquipe
INSERT INTO JoueurEquipe (idJoueur, idEquipe, dateDebut, dateFin) VALUES
    (1, 1, '2022-01-01', '2022-12-31'),
    (2, 2, '2022-01-01', '2022-12-31'),
    (3, 3, '2022-01-01', '2022-12-31'),
    (4, 1, '2022-01-01', '2022-12-31'),
    (5, 3, '2022-01-01', '2022-12-31'),
    (6, 2, '2022-01-01', '2022-12-31'),
    (7, 3, '2022-01-01', '2022-12-31'),
    (8, 2, '2022-01-01', '2022-12-31'),
    (9, 3, '2022-01-01', '2022-12-31'),
    (10, 3, '2022-01-01', '2022-12-31');
