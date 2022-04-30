
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO USERS (NAME, USERNAME, EMAIL, PASSWORD) VALUES
  ('Pimenta', 'profpimenta', 'pimenta@ufrgs.br', 'abc123'),
  ('Gabriel', 'gabrielzito', 'gabriel@gmail.com', 'teste123'),
  ('Giovani', 'giovanizito', 'giovani@inf.ufrgs.br', 'outrasenha');

INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES
 (1, 2),
 (2, 1),
 (3, 1);


