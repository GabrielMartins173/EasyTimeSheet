
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_MODERATOR');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');

INSERT INTO USERS (NAME, USERNAME, EMAIL, PASSWORD) VALUES
  ('Pimenta', 'profpimenta', 'pimenta@ufrgs.br', '$2a$10$IPazAgztKjQDQY19PdimdOq0hVHQ6b4qz6GnIV6jH1WF4vgtaCDnG'),  --thisismypassword
  ('Gabriel', 'gabrielzito', 'gabriel@gmail.com', '$2a$10$5iPJEdbBFTZEgChnjI1d5evRmBoBrA2jOK7U4AgmI.jevBjwd9R.G'), -- 123456789
  ('Giovani', 'giovanizito', 'giovani@inf.ufrgs.br', '$2a$10$mipPNYCYTTAzKepH5pcyjO2kleS7QtvW6yfDY9X08IFteeiNggq8i'); -- abcde123
  ('Cechin', 'profcechin', 'cechinemail@ufrgs.br', '$2a$10$no6JCOuv8tyBlu7io6ColezBH75SxfoPsvrgABOGld1AaJmDPXNWe'),  -- cechinpassword

INSERT INTO USER_ROLES (USER_ID, ROLE_ID) VALUES
 (1, 2),
 (2, 1),
 (3, 1),
 (4, 3);


