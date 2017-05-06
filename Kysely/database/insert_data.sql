INSERT INTO kysymys_tyyppi
	(id, maaritelma)
values
	(1, 'vaihtoehto'),
	(2, 'radio'),
	(3, 'checkbox'),
	(4, 'textarea'),
	(5, 'matrix')
;

INSERT INTO kysely
	(id, nimi, kuvaus)
VALUES
	(1, 'Helga kysely', 'Olen opiskelijakunta Helgan j�sen.'),
	(2, 'Helga kysely', 'Tied�n mik� opiskelijakunta helga on, mutta en ole j�sen.'),
	(3, 'Helga kysely', 'Tied�n hyvin v�h�n tai en ollenkaan Helgasta. En ole j�sen.')
;

INSERT INTO kysymys
	(id, kysymys, tyyppi_id, kysely_id)
VALUES
	(1, 'Sukupuoli?', 2, 1),
	(2, 'Ik�?', 2, 1),
	(3, 'Kerro t�rkein/t�rkeimm�t syyt sille, miksi olet liittynyt j�seneksi.', 4, 1),
	(4, 'Mist� koet saavasi suurimman hy�dyn j�senyytesi ansiosta?', 4, 1),
	(5, 'Mit� sellaista toivoisit j�senyytesi mahdollistavan, mit� Helga ei t�ll� hetkell� tarjoa?', 4, 1),
	(6, 'Miss� asioissa Helga voisi parantaa toimintaansa?', 4, 1),
	(7,	'Suosittelisitko Helgaan liittymist� yst�v�llesi?', 2, 1),
	(8, 'Arvosanasi Helgalle?', 5, 1),
	
	(9, 'Sukupuoli?', 2, 2),
	(10, 'Ik�?', 2, 2),
	(11, 'Kerro t�rkein/t�rkeimm�t syyt sille, miksi et ole liittynyt Helgan j�seneksi.', 4, 2),
	(12, 'Uskotko, ett� hy�tyisit j�senyydest� jollain tapaa?', 2, 2),
	(13, 'Koetko saaneesi riitt�v�sti tietoa Helgasta ja sen toiminnasta?', 2, 2),
	(14, 'Mit� tied�t Helgan toiminnasta?', 4, 2),
	(15, 'Mik� saisi sinut liittym��n Helgan j�seneksi?', 4, 2),
	(16, 'Voisitko ajatella liittyv�si Helgan j�seneksi?', 2, 2),
	
	(17, 'Sukupuoli?', 2, 3),
	(18, 'Ik�?', 2, 3),
	(19, 'Onko sinulla jonkinlainen k�sitys siit�, mik� Helga on?', 2, 3),
	(20, 'Olisitko kiinnostunut saamaan lis�� tietoa Helgasta?', 2, 3),
	(21, 'Miten toivoisit Helgan tiedottavan itsest��n?', 3, 3)
;

INSERT INTO vastaus
	(teksti, kysymys_id)
VALUES
	('mies', 1),
	('nainen', 1),
	('alle 20', 2),
	('21-25', 2),
	('26-30', 2),
	('31-35', 2),
	('36-40', 2),
	('yli 40', 2),
	('kyll�', 7),
	('en, miksi?', 7),
	('1,5', 8),
	
	('mies', 9),
	('nainen', 9),
	('alle 20', 10),
	('21-25', 10),
	('26-30', 10),
	('31-35', 10),
	('36-40', 10),
	('yli 40', 10),
	('en', 12),
	('kyll�, miten?', 12),
	('kyll�', 13),
	('en', 13),
	('kyll�', 16),
	('en', 16),
	
	('mies', 17),
	('nainen', 17),
	('alle 20', 18),
	('21-25', 18),
	('26-30', 18),
	('31-35', 18),
	('36-40', 18),
	('yli 40', 18),
	('ei', 19),
	('kyll�, millainen?', 19),
	('kyll�', 20),
	('en', 20),
	('S�hk�postitse', 21),
	('Tekstiviestill�', 21),
	('Esittelytilaisuudella', 21),
	('Muuten, miten?', 21)
;

INSERT INTO tulos
	(teksti, kysely_id, kysymys_id)
VALUES
--	('Opiskeluilmapiiri on t�ll� hetkell� erinomainen', 3, 1),
;

