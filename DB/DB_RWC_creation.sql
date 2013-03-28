create database teste character set utf8 COLLATE utf8_general_mysql500_ci;
USE teste;

CREATE TABLE nation (
  nat_id INTEGER PRIMARY KEY AUTO_INCREMENT ,
  nat_nom VARCHAR(20) NOT NULL,
  nat_abr VARCHAR(3) NOT NULL,
  nat_poule CHAR(1) NOT NULL CHECK (nat_poule IN ('A','B','C','D'))
) ENGINE=InnoDB;;



CREATE TABLE stade (
       sta_id INTEGER PRIMARY KEY AUTO_INCREMENT,
       sta_nom VARCHAR(40),
       sta_ville VARCHAR(20),
       sta_cap INTEGER) ENGINE=InnoDB;;

CREATE TABLE matchs (
       mat_id INTEGER PRIMARY KEY AUTO_INCREMENT,
       mat_date DATE NOT NULL,
       mat_stade INTEGER REFERENCES stade(sta_id)
) ENGINE=InnoDB;;

CREATE TABLE joue (
       mat_id INTEGER REFERENCES matchs(mat_id),
       nat_id INTEGER REFERENCES nation(nat_id),
       nat_essai INTEGER,
       nat_trans INTEGER,
       nat_penal INTEGER,
       nat_drop INTEGER,
       PRIMARY KEY (mat_id, nat_id)
) ENGINE=InnoDB;;
