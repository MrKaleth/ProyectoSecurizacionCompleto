-- Creación de la base de datos exigida por el proyecto
CREATE DATABASE IF NOT EXISTS BonillaYSpringBoot;

-- Creación del usuario que luego configurarás en application.properties
CREATE USER 'usuario_spring'@'%' IDENTIFIED BY 'password_segura';

-- Dar permisos al usuario sobre la base de datos
GRANT ALL PRIVILEGES ON BonillaYSpringBoot.* TO 'usuario_spring'@'%';
FLUSH PRIVILEGES;

-- USE apellidoYSpringBoot;
-- A partir de aquí puedes añadir los CREATE TABLE de tus 3 entidades mapeadas [cite: 3, 4]