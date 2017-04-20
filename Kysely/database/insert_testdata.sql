INSERT INTO QUESTION_TYPE
	(id, definition)
values
	(1, 'choice'),
	(2, 'radio'),
	(3, 'checkbox'),
	(4, 'textarea');

INSERT INTO POLL
	(id, name)
values
	(1, 'Testikysely1'),
	(2, 'Testikysely2');

INSERT INTO QUESTION
	(id, question, questionType_id, poll_id)
values
	(1, 'Onko t�m� testikysymys?', 3, 1),
	(2, 'Onko kakku hyv��?', 1, 1),
	(3, 'Oletko viimeisen kuukauden aikana sy�nyt meetvurstia?', 2, 2),
	(4, 'Oletko viime aikoina tuntenut olosi ihmiseksi?', 4, 2);

INSERT INTO ANSWER
	(text, question_id)
values
	('kyll�', 1),
	('ei', 1),
	('ehk�', 1),
	('v�h�n', 3),
	('sopivasti', 3),
	('paljon', 3);

--USER TABLES
INSERT INTO authority
	(id, role)
VALUES
	(2,'ROLE_ADMIN'),
	(1,'ROLE_USER');

INSERT INTO webuser
	(id, username, password_encrypted, enabled)
VALUES
	(1,'admin','00',1),
	(2,'user','00',1);

INSERT INTO webuser_authority
	(id, webuser_id, authority_id)
VALUES
	(1,1,2),
	(2,2,1);
