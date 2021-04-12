-- CARGA NA TABELA DE USUARIOS
INSERT INTO TB_USER (name,login,email,password,enable) VALUES('Cleiton Ferreira','cleitonferreiraa','Cleitonferreiraa@hotmail.com','$2a$10$Qi7vPWQchmWbTAEZo1wPNO0hVoNsM3J7fA.sPRuvRIy.L6Q67ftae','true');

-- CARGA DE PERFIL
INSERT INTO TB_PROFILE (name) VALUES ('ROLE_USER');

-- CARGA DE USUARIO X PERFIL
INSERT INTO TB_USER_PROFILES (TB_USER_ID,PROFILES_ID) VALUES  (1,1);

