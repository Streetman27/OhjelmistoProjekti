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
	(3, 'Kysely Helgan jäsenille.');

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
	('kyllä', 5),
	('ei', 5),
	('ehkä', 5),
	('vähän', 3),
	('sopivasti', 3),
	('paljon', 3);
