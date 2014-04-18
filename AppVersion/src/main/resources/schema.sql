CREATE TABLE users (
  USER_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  USERNAME VARCHAR(45) NOT NULL,
  PASSWORD VARCHAR(45) NOT NULL,
  ENABLED tinyint(1) NOT NULL,
  PRIMARY KEY (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE user_roles (
  USER_ROLE_ID INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  USER_ID INT(10) UNSIGNED NOT NULL,
  AUTHORITY VARCHAR(45) NOT NULL,
  PRIMARY KEY (USER_ROLE_ID),
  KEY FK_user_roles (USER_ID),
  CONSTRAINT FK_user_roles FOREIGN KEY (USER_ID) REFERENCES users (USER_ID)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;