--KYSELY TAULUT
INSERT INTO kysymys_tyyppi
	(id, maaritelma)
values
	(1, 'vaihtoehto'),
	(2, 'radio'),
	(3, 'checkbox'),
	(4, 'textarea');

INSERT INTO kysely
	(id, nimi)
values
	(1, 'Testikysely1'),
	(2, 'Testikysely2');

INSERT INTO kysymys
	(id, kysymys, tyyppi_id, kysely_id)
values
	(1, 'Onko t�m� testikysymys?', 3, 1),
	(2, 'Onko kakku hyv��?', 1, 1),
	(3, 'Oletko viimeisen kuukauden aikana sy�nyt meetvurstia?', 2, 2),
	(4, 'Oletko viime aikoina tuntenut olosi ihmiseksi?', 4, 2);

INSERT INTO vastaus
	(teksti, kysymys_id)
values
	('kyll�', 1),
	('ei', 1),
	('ehk�', 1),
	('v�h�n', 3),
	('sopivasti', 3),
	('paljon', 3);
