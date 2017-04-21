--KYSELY TAULUT
CREATE TABLE kysymys_tyyppi
(id integer NOT NULL auto_increment PRIMARY KEY
,maaritelma varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysely
(id integer NOT NULL auto_increment PRIMARY KEY
,nimi varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysymys
(id integer NOT NULL auto_increment PRIMARY KEY
,kysmys varchar(255) NOT NULL
,tyyppi_id integer NOT NULL
,poll_id integer NOT NULL
,FOREIGN KEY (tyyppi_id) REFERENCES kysely_tyyppi(id)
,FOREIGN KEY (kysely_id) REFERENCES kysely(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE vastaus
(id integer NOT NULL auto_increment PRIMARY KEY
,teksti varchar(255) NOT NULL
,kysymys_id integer NOT NULL
,FOREIGN KEY (kysymys_id) REFERENCES kysymys(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
