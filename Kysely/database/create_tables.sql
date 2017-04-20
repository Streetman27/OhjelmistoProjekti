--POLL TABLES
CREATE TABLE QUESTION_TYPE
(id integer NOT NULL auto_increment PRIMARY KEY
,definition varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE POLL
(id integer NOT NULL auto_increment PRIMARY KEY
,name varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE QUESTION
(id integer NOT NULL auto_increment PRIMARY KEY
,question varchar(255) NOT NULL
,questionType_id integer NOT NULL
,poll_id integer NOT NULL
,FOREIGN KEY (questionType_id) REFERENCES QUESTION_TYPE(id)
,FOREIGN KEY (poll_id) REFERENCES POLL(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE ANSWER
(id integer NOT NULL auto_increment PRIMARY KEY
,text varchar(255) NOT NULL
,question_id integer NOT NULL
,FOREIGN KEY (question_id) REFERENCES QUESTION(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--USER TABLES
CREATE TABLE authority
(id integer NOT NULL auto_increment PRIMARY KEY
,role varchar(255) NOT NULL UNIQUE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
CREATE TABLE webuser 
(id integer NOT NULL auto_increment PRIMARY KEY
,username varchar(255) NOT NULL UNIQUE
,password_encrypted varchar(255) NOT NULL
,enabled tinyint NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE webuser_authority 
(id integer NOT NULL auto_increment PRIMARY KEY
,webuser_id integer NOT NULL
,authority_id integer NOT NULL
,FOREIGN KEY (webuser_id) REFERENCES webuser(id) ON DELETE NO ACTION ON UPDATE NO ACTION
,FOREIGN KEY (authority_id) REFERENCES authority(id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
