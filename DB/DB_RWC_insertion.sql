

INSERT INTO nation VALUES   
       (NULL,'Nouvelle-Zelande','N-Z','A'), 
       (NULL,'France','FRA','A'),  	
       (NULL,'Tonga','TON','A'),		
       (NULL,'Japon','JAP','A'),		
       (NULL,'Canada','CAN','A'),		
       (NULL,'Angleterre','ANG','B'),	
       (NULL,'Ecosse','ECO','B'),		
       (NULL,'Argentine','ARG','B'),		
       (NULL,'GÃ©orgie','GEO','B'),		
       (NULL,'Roumanie','ROU','B'),		
       (NULL,'Irlande','IRL','C'),		
       (NULL,'Australie','AUS','C'),		
       (NULL,'Italie','ITA','C'),		
       (NULL,'Etats-Unis','E-U','C'),	
       (NULL,'Russie','RUS','C'),		
       (NULL,'Pays de Galles','GAL','D'),	
       (NULL,'Namibie','NAM','D'),		
       (NULL,'Samoa','SAM','D'),		
       (NULL,'Afrique du Sud','AFS','D'),	
       (NULL,'Fidji','FID','D');		

INSERT INTO stade values 
       (NULL, 'Rugby Park Stadium', 'Invercargill', 20000),		
       (NULL, 'Carisbrook Stadium', 'Dunedin', 29000),		
       (NULL, 'Trafalgar Park', 'Nelson', 20080),			
       (NULL, 'Wellington Regional Stadium', 'Wellington', 40000),	
       (NULL, 'Arena Manawatu', 'Palmerston North', 18300),		
       (NULL, 'Mc Lean Park', 'Napier', 18700),			
       (NULL, 'Rotorua International Stadium', 'Rotorua', 30000),	
       (NULL, 'Waikato Stadium', 'Hamilton', 30800),			
       (NULL, 'Eden Park', 'Auckland', 60000),			
       (NULL, 'North Harbourg Stadium', 'Auckland', 30000),		
       (NULL, 'Northland Events Center', 'Whangarei', 20000),	
       (NULL, 'Stadium Taranaki', 'New Plymouth', 25000);           






/*POULE A*/
/*    STR_TO_DATE( , '%d-%m-%Y')  */

-- ven 09/09/2011 Auckland   NOUVELLE-ZELANDE   - TONGA         41 - 10
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '09-09-2011', '%d-%m-%Y'), 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 1, 6, 4, 1, 0),
       (LAST_INSERT_ID(), 3, 1, 1, 1, 0);

-- ven 10/09/2011 Auckland   FRANCE   - JAPON         47 - 21
INSERT INTO matchs VALUES (NULL, STR_TO_DATE('10-09-2011' , '%d-%m-%Y'), 10);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 2, 6, 4, 3, 0),
       (LAST_INSERT_ID(), 4, 2, 1, 3, 0);

-- ven 14/09/2011 Whangarei   TONGA   - CANADA         20 - 25
INSERT INTO matchs VALUES (NULL, STR_TO_DATE('14-09-2011' , '%d-%m-%Y'), 11);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 3, 2, 2, 2, 0),
       (LAST_INSERT_ID(), 5, 3, 2, 2, 0);

-- ven 16/09/2011 Hamilton   NOUVELLE-ZELANDE	- JAPON		83 - 7
INSERT INTO matchs values (NULL, STR_TO_DATE( '16-09-2011', '%d-%m-%Y'), 8);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 1, 13, 9, 0, 0),
       (LAST_INSERT_ID(), 4, 1, 1, 0, 0);

-- dim 18/09/2011 Napier     FRANCE 		- CANADA        46 - 19
INSERT INTO matchs values (NULL, STR_TO_DATE( '18-09-2011', '%d-%m-%Y'), 6);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 2, 4, 4, 5, 1),
       (LAST_INSERT_ID(), 5, 1, 1, 2, 2);

-- mer 21/09/2011 Whangarei  TONGA 		- JAPON        	31 - 18
INSERT INTO matchs values (NULL, STR_TO_DATE( '21-09-2011', '%d-%m-%Y'), 11);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 3, 3, 2, 4, 0),
       (LAST_INSERT_ID(), 4, 3, 0, 1, 0);

-- sam 24/09/2011 Auckland   NOUVELLE-ZELANDE 	- FRANCE        37 - 17
INSERT INTO matchs values (NULL, STR_TO_DATE( '24-09-2011', '%d-%m-%Y'), 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 1, 5, 3, 1, 1),
       (LAST_INSERT_ID(), 2, 2, 2, 1, 0);

-- mar 27/09/2011 Napier     CANADA 		- JAPON        	23 - 23
INSERT INTO matchs values (NULL, STR_TO_DATE('27-09-2011' , '%d-%m-%Y'), 6);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 5, 3, 1, 2, 0),
       (LAST_INSERT_ID(), 4, 2, 2, 3, 0);

-- sam 01/10/2011 Wellington FRANCE 		- TONGA        	14 - 19
INSERT INTO matchs values (NULL, STR_TO_DATE( '01-10-2011', '%d-%m-%Y'), 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 2, 1, 0, 3, 0),
       (LAST_INSERT_ID(), 3, 1, 1, 4, 0);

-- dim 02/10/2011 Wellington NOUVELLE-ZELANDE 	- CANADA        79 - 15 
INSERT INTO matchs values (NULL, STR_TO_DATE( '02-10-2011', '%d-%m-%Y'), 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 1, 12, 8, 1, 0),
       (LAST_INSERT_ID(), 5, 2, 1, 1, 0);




/*POULE B*/

-- sam 10/09/2011       Invercargill      ECOSSE         - ROUMANIE      34 - 24
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '10-09-2011', '%d-%m-%Y') , 1);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 7, 4, 1, 4, 0),
       (LAST_INSERT_ID(), 10, 2, 1, 4, 0);
-- sam 10/09/2011       Dunedin           ARGENTINE      - ANGLETERRE     9 - 13
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '10-09-2011', '%d-%m-%Y'), 2);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 8, 0, 0, 3, 0),
       (LAST_INSERT_ID(), 6, 1, 1, 2, 0);
-- mer 14/09/2011       Dunedin	          ECOSSE         - GEORGIE       15 - 6
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '14-09-2011', '%d-%m-%Y') , 1);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 7, 0, 0, 4, 1),
       (LAST_INSERT_ID(), 9, 0, 0, 2, 0);
-- sam 17/09/2011       Invercargill      ARGENTINE      - ROUMANIE      43 - 8
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '17-09-2011', '%d-%m-%Y') , 1);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 8, 6, 5, 1, 0),
       (LAST_INSERT_ID(), 10, 1, 0, 1, 0);
-- dim 18/09/2011       Dunedin           ANGLETERRE     - GEORGIE       41 - 10
INSERT INTO matchs VALUES (NULL, STR_TO_DATE('18-09-2011' , '%d-%m-%Y'), 2);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 6, 6, 4, 1, 0),
       (LAST_INSERT_ID(), 9, 1, 1, 1, 0);
-- sam 24/09/2011       Dunedin           ANGLETERRE     - ROUMANIE      67 - 3
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '24-09-2011', '%d-%m-%Y') , 2);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 6, 10, 7, 1, 0),
       (LAST_INSERT_ID(), 10, 0, 0, 1, 0);
-- dim 25/09/2011       Wellington        ARGENTINE      - ECOSSE        13 - 12
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '25-09-2011', '%d-%m-%Y'), 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 8, 1, 1, 2, 0),
       (LAST_INSERT_ID(), 7, 0, 0, 2, 2);
-- mer 28/09/2011       Palmerston North  GEORGIE        - ROUMANIE      25 - 9
INSERT INTO matchs VALUES (NULL, STR_TO_DATE('28-09-2011', '%d-%m-%Y'), 5);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(),9, 1, 1, 6, 0),
       (LAST_INSERT_ID(), 10, 0, 0, 3, 0);
-- sam 01/10/2011       Auckland          ANGLETERRE     - ECOSSE        16 - 12
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '01-10-2011', '%d-%m-%Y') , 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 6, 1, 1, 2, 1),
       (LAST_INSERT_ID(), 7, 0, 0, 3, 1);
-- dim 02/10/2011       Palmerston North  ARGENTINE      - GEORGIE       25 - 7 
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '02-10-2011', '%d-%m-%Y'), 5);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 8, 3, 2, 2, 0),
       (LAST_INSERT_ID(), 9, 1, 1, 0, 0);




/*POULE C*/
-- dim 11/09/2011 	North Shore City  AUSTRALIE 	 - ITALIE        32 - 6
INSERT INTO matchs values(NULL,STR_TO_DATE('11-09-2011' , '%d-%m-%Y') , 10);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 12, 4, 3, 2, 0),
       (LAST_INSERT_ID(), 13, 0, 0, 2, 0);
-- dim 11/09/2011  	New Plymouth 	  IRLANDE 	 - ETATS-UNIS    22 - 10
INSERT INTO matchs values(NULL,STR_TO_DATE( '11-09-2011', '%d-%m-%Y') , 12);
INSERT INTO joue VALUES
       (LAST_INSERT_ID(), 11, 3, 2, 1, 0),
       (LAST_INSERT_ID(), 14, 1, 1, 1, 0);
-- jeu 15/09/2011 	New Plymouth 	  RUSSIE 	 - ETATS-UNIS     6 - 13
INSERT INTO matchs values(NULL,STR_TO_DATE( '15-09-2011', '%d-%m-%Y') , 12);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 15, 0, 0, 2, 0),
       (LAST_INSERT_ID(), 14, 1, 1, 2, 0);
-- sam 17/09/2011 	Auckland 	  AUSTRALIE 	 - IRLANDE        6 - 15
INSERT INTO matchs values(NULL,STR_TO_DATE( '17-09-2011', '%d-%m-%Y') , 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 12, 0, 0, 2, 0),
       (LAST_INSERT_ID(), 11, 0, 0, 4, 1);
-- mar 20/09/2011 	Nelson 	       	  ITALIE 	 - RUSSIE        53 - 17
INSERT INTO matchs values(NULL, STR_TO_DATE('20-09-2011' , '%d-%m-%Y'), 3);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 13, 9, 4, 0, 0),
       (LAST_INSERT_ID(), 15, 3, 1, 0, 0);
-- ven 23/09/2011 	Wellington 	  AUSTRALIE 	 - ETATS-UNIS    67 - 5
INSERT INTO matchs values(NULL, STR_TO_DATE('23-09-2011' , '%d-%m-%Y'), 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 12, 11, 6, 0, 0),
       (LAST_INSERT_ID(), 14, 1, 0, 0, 0);
-- dim 25/09/2011 	Rotorua 	  IRLANDE 	 - RUSSIE        62 - 12
INSERT INTO matchs values(NULL, STR_TO_DATE( '25-09-2011', '%d-%m-%Y'), 7);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 11, 9, 7, 1, 0),
       (LAST_INSERT_ID(), 15, 2, 1, 0, 0);
-- mar 27/09/2011 	Nelson 	          ITALIE 	 - ETATS-UNIS    27 - 10
INSERT INTO matchs values(NULL,STR_TO_DATE( '27-09-2011', '%d-%m-%Y') , 3);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 13, 4, 2, 1, 0),
       (LAST_INSERT_ID(), 14, 1, 1, 1, 0);
-- sam 01/10/2011 	Nelson 	          AUSTRALIE 	 - RUSSIE        68 - 22
INSERT INTO matchs values(NULL, STR_TO_DATE('01-10-2011' , '%d-%m-%Y'), 3);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 12, 10, 9, 0, 0),
       (LAST_INSERT_ID(), 15, 3, 2, 0, 1);
-- dim 02/10/2011 	Dunedin 	  IRLANDE 	 - ITALIE        36 - 6 
INSERT INTO matchs values(NULL, STR_TO_DATE( '02-10-2011', '%d-%m-%Y'), 2);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 11, 3, 3, 5, 0),
       (LAST_INSERT_ID(), 13, 0, 0, 2, 0);




/*POULE D*/

-- sam 10/09/2011 	Rotorua 	  FIDJI 	 - NAMIBIE       49 - 25
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '10-09-2011', '%d-%m-%Y') , 7);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 20, 6, 5, 3, 0),
       (LAST_INSERT_ID(), 17, 2, 0, 2, 3);

-- dim 11/09/2011 	Wellington 	  AFRIQUE DU SUD - GALLES        17 - 16
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '11-09-2011', '%d-%m-%Y') , 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 19, 2, 2, 1, 0),
       (LAST_INSERT_ID(), 16, 1, 1, 3, 0);

-- mer 14/09/2011 	Rotorua 	  SAMOA 	 - NAMIBIE       49 - 12
INSERT INTO matchs VALUES (NULL,STR_TO_DATE('14-09-2011' , '%d-%m-%Y') , 7);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 18, 6, 5, 3, 0),
       (LAST_INSERT_ID(), 17, 2, 1, 0, 0);

-- sam 17/09/2011 	Wellington 	  AFRIQUE DU SUD - FIDJI         49 - 3
INSERT INTO matchs VALUES (NULL,STR_TO_DATE(  '17-09-2011', '%d-%m-%Y'), 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 19, 6, 5, 3, 0),
       (LAST_INSERT_ID(), 20, 0, 0, 1, 0);

-- dim 18/09/2011 	Hamilton 	  GALLES 	 - SAMOA         17 - 10
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '18-09-2011', '%d-%m-%Y'), 8);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 16, 1, 0, 4, 0),
       (LAST_INSERT_ID(), 18, 1, 1, 1, 0);

-- jeu 22/09/2011       North Harbour Stadium    AFRIQUE DU SUD - NAMIBIE       87 - 0
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '22-09-2011', '%d-%m-%Y') , 10);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 19, 12, 12, 1, 0),
       (LAST_INSERT_ID(), 17, 0, 0, 0, 0);

-- dim 25/09/2011 	Auckland 	  FIDJI 	 - SAMOA          7 - 27
INSERT INTO matchs VALUES (NULL,STR_TO_DATE(  '25-09-2011', '%d-%m-%Y'), 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 20, 1, 1, 0, 0),
       (LAST_INSERT_ID(), 18, 2, 1, 4, 1);

-- lun 26/09/2011 	New Plymouth 	  GALLES 	 - NAMIBIE       81 - 7
INSERT INTO matchs VALUES (NULL,STR_TO_DATE('26-09-2011' , '%d-%m-%Y') , 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 16, 12, 9, 1, 0),
       (LAST_INSERT_ID(), 17, 1, 1, 0, 0);

-- ven 30/09/2011 	North Harbour Stadium 	  AFRIQUE DU SUD - SAMOA         13 - 5
INSERT INTO matchs VALUES (NULL, STR_TO_DATE('30-09-2011' , '%d-%m-%Y'), 10);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 19, 1, 1, 2, 0),
       (LAST_INSERT_ID(), 18, 1, 0, 0, 0);

-- dim 02/10/2011 	Hamilton 	  GALLES 	 - FIDJI         66 - 0
INSERT INTO matchs VALUES (NULL,STR_TO_DATE('02-10-2011' , '%d-%m-%Y') , 8);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 16, 9, 9, 1, 0),
       (LAST_INSERT_ID(), 20, 0, 0, 0, 0);




/* Quarts de finale*/

-- sam 8/10/2011       Wellington         IRLANDE         - GALLES      10 - 22
INSERT INTO matchs VALUES (NULL, STR_TO_DATE('08-10-2011' , '%d-%m-%Y'), 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 11, 1, 1, 1, 0),
       (LAST_INSERT_ID(), 16, 3, 2, 1, 0);

-- sam 8/10/2011       Auckland         ANGLETERRE         - FRANCE      12 - 19
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '08-10-2011', '%d-%m-%Y') , 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 6, 2, 1, 0, 0),
       (LAST_INSERT_ID(), 2, 2, 0, 2, 1);

-- dim 9/10/2011       Wellington        AFRIQUE DU SUD        - AUSTRALIE     9 - 11
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '09-10-2011', '%d-%m-%Y'), 4);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 19, 0, 0, 2, 1),
       (LAST_INSERT_ID(), 12, 1, 0, 2, 0);

-- dim 9/10/2011       Auckland       NOUVELLE-ZELANDE        - ARGENTINE    33 - 10
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '09-10-2011', '%d-%m-%Y') , 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 1, 2, 1, 7, 0),
       (LAST_INSERT_ID(), 8, 1, 1, 1, 0);




/*Demi-Finales*/

-- sam 15/10/2011       Auckland         GALLES         - FRANCE      8 - 9
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '15-10-2011', '%d-%m-%Y') , 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 16, 1, 0, 1, 0),
       (LAST_INSERT_ID(), 2, 0, 0, 3, 0);

-- dim 16/10/2011       Auckland         AUSTRALIE         - NOUVELLE-ZELANDE      6 - 20
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '16-10-2011', '%d-%m-%Y'), 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 12, 0, 0, 1, 1),
       (LAST_INSERT_ID(), 1, 1, 0, 4, 1);




/*3eme place PLAY-OFF*/

-- ven 21/10/2011       Auckland         GALLES         - AUSTRALIE        18 - 21
INSERT INTO matchs VALUES (NULL, STR_TO_DATE( '21-10-2011', '%d-%m-%Y'), 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 16, 2, 1, 2, 0),
       (LAST_INSERT_ID(), 12, 2, 1, 2, 1);




/*FINAL*/

-- dim 23/10/2011       Auckland         FRANCE         - NOUVELLE-ZELANDE         7 - 8
INSERT INTO matchs VALUES (NULL,STR_TO_DATE( '23-10-2011', '%d-%m-%Y') , 9);
INSERT INTO joue VALUES 
       (LAST_INSERT_ID(), 2, 1, 1, 0, 0),
       (LAST_INSERT_ID(), 1, 1, 0, 1, 0);
