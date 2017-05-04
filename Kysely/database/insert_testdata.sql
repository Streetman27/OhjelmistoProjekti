--KYSELY TAULUT
INSERT INTO kysymys_tyyppi
	(id, maaritelma)
values
	(1, 'vaihtoehto'),
	(2, 'radio'),
	(3, 'checkbox'),
	(4, 'textarea'),
	(5, 'matrix');

INSERT INTO kysely
	(id, nimi, kuvaus)
values
	(1, 'Testikysely1', ''),
	(2, 'Testikysely2', 'testikuvaus'),
	(3, 'Kysely Helgan j�senille.', 'Kysely niille opiskelijoille, jotka eiv�t ole Helgan j�seni�.');

INSERT INTO kysymys
	(id, kysymys, tyyppi_id, kysely_id)
values
	(1, 'Kerro t�rkein / t�rkeimm�t syyt sille, miksi olet liittynyt Helgan j�seneksi.', 4, 3),
	(2, 'Onko t�m� testikysymys?', 3, 1),
	(3, 'Onko kakku hyv��?', 1, 1),
	(4, 'Oletko viimeisen kuukauden aikana sy�nyt meetvurstia?', 2, 2),
	(5, 'Oletko viime aikoina tuntenut olosi ihmiseksi?', 4, 2);

INSERT INTO vastaus
	(teksti, kysymys_id)
values
	('kyll�', 2),
	('ei', 2),
	('ehk�', 2),
	('v�h�n', 4),
	('sopivasti', 4),
	('paljon', 4);

INSERT INTO tulos
	(teksti, kysely_id, kysymys_id)
values
	('Opiskeluilmapiiri on t�ll� hetkell� erinomainen', 3, 1),
	('ehk�', 1, 2);
