-- CARGA NA TABELA DE USUARIOS
INSERT INTO TB_USER(name,username,email,password) VALUES('Cleiton Ferreira','cleitonferreiraa','cleitonferreiraa@hotmail.com','$2a$10$Qi7vPWQchmWbTAEZo1wPNO0hVoNsM3J7fA.sPRuvRIy.L6Q67ftae');


-- CARGA NA TABELA DE Accessory

INSERT INTO accessory (name) VALUES ('Capacete');
INSERT INTO accessory (name) VALUES ('Luzes de sinalização');
INSERT INTO accessory (name) VALUES ('Bermuda');
INSERT INTO accessory (name) VALUES ('Garrafa de água');
INSERT INTO accessory (name) VALUES ('Bomba para encher o pneu portátil');
INSERT INTO accessory (name) VALUES ('Espátula para trocar a câmara');
INSERT INTO accessory (name) VALUES ('Câmara reserva');
INSERT INTO accessory (name) VALUES ('Kit de reparos');
INSERT INTO accessory (name) VALUES ('Camisa com porta objetos');
INSERT INTO accessory (name) VALUES ('Alimentação');
INSERT INTO accessory (name) VALUES ('Luva');
INSERT INTO accessory (name) VALUES ('Kit de chaves');
INSERT INTO accessory (name) VALUES ('Reparo de corrente');
INSERT INTO accessory (name) VALUES ('Conhecimentos básicos de mecânica');


--Andar no máximo 5 quilômetros no total
INSERT INTO bike (id, modality, distance) VALUES (1, 'NONE', '5km');

INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (1, 1);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (1, 2);

--Andar no máximo 10 quilômetros no total
INSERT INTO bike (id, modality, distance) VALUES (2, 'NONE', '10km');

INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (2, 1);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (2, 2);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (2, 3);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (2, 4);

--Andar no máximo 20 quilômetros no total
INSERT INTO bike (id, modality, distance) VALUES (3, 'NONE', '20km');

INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (3, 1);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (3, 2);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (3, 3);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (3, 4);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (3, 5);


--Andar no máximo 40 quilômetros no total
INSERT INTO bike (id, modality, distance) VALUES (4, 'NONE', '40km');

INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (4, 1);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (4, 2);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (4, 3);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (4, 4);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (4, 5);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (4, 6);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (4, 7);

--Andar no máximo 80 quilômetros no total
INSERT INTO bike (id, modality, distance) VALUES (5, 'NONE', '80km');

INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 1);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 2);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 3);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 4);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 5);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 6);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 7);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 8);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 9);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (5, 10);

--Andar no máximo 130 quilômetros no total
INSERT INTO bike (id, modality, distance) VALUES (6, 'NONE', '130km');

INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 1);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 2);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 3);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 4);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 5);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 6);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 7);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 8);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 9);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 10);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 11);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 12);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 13);
INSERT INTO accessory_bike (id_bike, id_accessory) VALUES (6, 14);


