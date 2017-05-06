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
	(1, 'Helga kysely', 'Olen opiskelijakunta Helgan jäsen.'),
	(2, 'Helga kysely', 'Tiedän mikä opiskelijakunta helga on, mutta en ole jäsen.'),
	(3, 'Helga kysely', 'Tiedän hyvin vähän tai en ollenkaan Helgasta. En ole jäsen.')
;

INSERT INTO kysymys
	(id, kysymys, tyyppi_id, kysely_id)
VALUES
	(1, 'Sukupuoli?', 2, 1),
	(2, 'Ikä?', 2, 1),
	(3, 'Kerro tärkein/tärkeimmät syyt sille, miksi olet liittynyt jäseneksi.', 4, 1),
	(4, 'Mistä koet saavasi suurimman hyödyn jäsenyytesi ansiosta?', 4, 1),
	(5, 'Mitä sellaista toivoisit jäsenyytesi mahdollistavan, mitä Helga ei tällä hetkellä tarjoa?', 4, 1),
	(6, 'Missä asioissa Helga voisi parantaa toimintaansa?', 4, 1),
	(7,	'Suosittelisitko Helgaan liittymistä ystävällesi?', 2, 1),
	(8, 'Arvosanasi Helgalle?', 5, 1),
	
	(9, 'Sukupuoli?', 2, 2),
	(10, 'Ikä?', 2, 2),
	(11, 'Kerro tärkein/tärkeimmät syyt sille, miksi et ole liittynyt Helgan jäseneksi.', 4, 2),
	(12, 'Uskotko, että hyötyisit jäsenyydestä jollain tapaa?', 2, 2),
	(13, 'Koetko saaneesi riittävästi tietoa Helgasta ja sen toiminnasta?', 2, 2),
	(14, 'Mitä tiedät Helgan toiminnasta?', 4, 2),
	(15, 'Mikä saisi sinut liittymään Helgan jäseneksi?', 4, 2),
	(16, 'Voisitko ajatella liittyväsi Helgan jäseneksi?', 2, 2),
	
	(17, 'Sukupuoli?', 2, 3),
	(18, 'Ikä?', 2, 3),
	(19, 'Onko sinulla jonkinlainen käsitys siitä, mikä Helga on?', 2, 3),
	(20, 'Olisitko kiinnostunut saamaan lisää tietoa Helgasta?', 2, 3),
	(21, 'Miten toivoisit Helgan tiedottavan itsestään?', 3, 3)
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
	('kyllä', 7),
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
	('kyllä, miten?', 12),
	('kyllä', 13),
	('en', 13),
	('kyllä', 16),
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
	('kyllä, millainen?', 19),
	('kyllä', 20),
	('en', 20),
	('Sähköpostitse', 21),
	('Tekstiviestillä', 21),
	('Esittelytilaisuudella', 21),
	('Muuten, miten?', 21)
;

INSERT INTO tulos
	(teksti, kysely_id, kysymys_id)
VALUES
--	('Opiskeluilmapiiri on tällä hetkellä erinomainen', 3, 1),
;

