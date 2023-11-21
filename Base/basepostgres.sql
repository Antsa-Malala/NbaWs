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
    dateDebut date
);

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
INSERT INTO Match (lieu, dateDebut) VALUES
    ('Staples Center, Los Angeles', '2023-01-15'),
    ('Chase Center, San Francisco', '2023-01-18'),
    ('Scotiabank Arena, Toronto', '2023-01-20'),
    ('Madison Square Garden, New York', '2023-01-22'),
    ('Smoothie King Center, New Orleans', '2023-01-25'),
    ('TD Garden, Boston', '2023-01-28'),
    ('Amway Center, Orlando', '2023-02-01'),
    ('United Center, Chicago', '2023-02-03'),
    ('Oracle Arena, Oakland', '2023-02-06'),
    ('Fiserv Forum, Milwaukee', '2023-02-09');
