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
	(3, 'Kysely Helgan jäsenille.', 'Kysely niille opiskelijoille, jotka eivät ole Helgan jäseniä.');

INSERT INTO kysymys
	(id, kysymys, tyyppi_id, kysely_id)
values
	(1, 'Kerro tärkein / tärkeimmät syyt sille, miksi olet liittynyt Helgan jäseneksi.', 4, 3),
	(2, 'Onko tämä testikysymys?', 3, 1),
	(3, 'Onko kakku hyvää?', 1, 1),
	(4, 'Oletko viimeisen kuukauden aikana syönyt meetvurstia?', 2, 2),
	(5, 'Oletko viime aikoina tuntenut olosi ihmiseksi?', 4, 2);

INSERT INTO vastaus
	(teksti, kysymys_id)
values
	('kyllä', 2),
	('ei', 2),
	('ehkä', 2),
	('vähän', 4),
	('sopivasti', 4),
	('paljon', 4);

INSERT INTO tulos
	(teksti, kysely_id, kysymys_id)
values
	('Opiskeluilmapiiri on tällä hetkellä erinomainen', 3, 1),
	('ehkä', 1, 2);
