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
	(id, nimi)
values
	(1, 'Testikysely1'),
	(2, 'Testikysely2'),
	(3, 'Kysely Helgan j�senille.');

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
	('kyll�', 5),
	('ei', 5),
	('ehk�', 5),
	('v�h�n', 3),
	('sopivasti', 3),
	('paljon', 3);
