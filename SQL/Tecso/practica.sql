-- ESTRUCTURAS DE DATOS PARA MODELO SIMPLIFICADO DE "Alumno inscriptos en varios cursos de una carrera"

DROP DATABASE IF EXISTS `practica`;

CREATE DATABASE `practica`
	CHARACTER SET 'utf8';
    
USE `practica`;

DROP TABLE alumno;
DROP TABLE inscripciones_curso;
DROP TABLE curso;
DROP TABLE inscripciones_carrera;
DROP TABLE carrera;
DROP TABLE persona;

CREATE TABLE `persona`(
	identificador int(11) NOT NULL,
    tipodoc char(5) NOT NULL,
    documento bigint NOT NULL,
    nombre varchar(40) NOT NULL,
    apellido varchar(40) NOT NULL,
    fechanac date NOT NULL,
    PRIMARY KEY(identificador)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `alumno`(
	identificador int(11) NOT NULL,
    idpersona int(11) NOT NULL UNIQUE, 
    legajo int(11) NOT NULL,
    PRIMARY KEY(identificador),
    CONSTRAINT `persona_fk` FOREIGN KEY(`idpersona`) REFERENCES `persona`(`identificador`) ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `carrera`(
	identificador int(11) NOT NULL,
    nombre varchar(40) NOT NULL,
    descripcion varchar(250),
    fechadesde date NOT NULL,
    fechahasta date,
    PRIMARY KEY(identificarreracador)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `curso`(
	identificador int(11) NOT NULL,
    idcarrera int(11) NOT NULL,
    nombre varchar(40) NOT NULL,
    descripcion varchar(250),
    cupomaximo smallint NOT NULL,
    anio smallint NOT NULL,
    PRIMARY KEY(identificador),
    CONSTRAINT `carrera_fk` FOREIGN KEY(`idcarrera`) REFERENCES `carrera`(`identificador`) ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `inscripciones_carrera`(
	idalumno int(11) NOT NULL,
    idcarrera int(11) NOT NULL,
    fechainscripcion date NOT NULL,
    PRIMARY KEY(idalumno, idcarrera),
    CONSTRAINT `alumno_fk` FOREIGN KEY(`idalumno`) REFERENCES `alumno`(`identificador`) ON UPDATE CASCADE,
    CONSTRAINT `carreras_fk` FOREIGN KEY(`idcarrera`) REFERENCES `carrera`(`identificador`) ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `inscripciones_curso`(
	idalumno int(11) NOT NULL,
    idcurso int(11) NOT NULL,
    fechainscripcion date NOT NULL,
    PRIMARY KEY(idalumno, idcurso),
    CONSTRAINT `alumnos_fk` FOREIGN KEY(`idalumno`) REFERENCES `alumno`(`identificador`) ON UPDATE CASCADE,
    CONSTRAINT `curso_fk` FOREIGN KEY(`idcurso`) REFERENCES `curso`(`identificador`) ON UPDATE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Insert de datos iniciales persona
INSERT INTO persona(identificador, tipodoc, documento, nombre, apellido, fechanac) VALUES(1, 'DNI', 31565839, 'Florencia', 'Maneiro', '1985-06-28');
INSERT INTO persona(identificador, tipodoc, documento, nombre, apellido, fechanac) VALUES(2, 'DNI', 31000123, 'Patricia', 'Brumatti', '1985-01-13');
INSERT INTO persona(identificador, tipodoc, documento, nombre, apellido, fechanac) VALUES(3, 'DNI', 20945422, 'Diego', 'Menendez', '1982-04-10');
INSERT INTO persona(identificador, tipodoc, documento, nombre, apellido, fechanac) VALUES(4, 'DNI', 30999281, 'Franzo', 'Perez', '1986-02-05');
INSERT INTO persona(identificador, tipodoc, documento, nombre, apellido, fechanac) VALUES(5, 'DNI', 24112872, 'Leandro', 'Garcia', '1988-01-03');

-- Insert de datos iniciales alumno
INSERT INTO alumno(identificador, idpersona, legajo) VALUES(1, 3, 98734);
INSERT INTO alumno(identificador, idpersona, legajo) VALUES(2, 4, 09213);
INSERT INTO alumno(identificador, idpersona, legajo) VALUES(3, 1, 35839);
INSERT INTO alumno(identificador, idpersona, legajo) VALUES(4, 5, 36299);
INSERT INTO alumno(identificador, idpersona, legajo) VALUES(5, 2, 11009);

-- Insert de datos iniciales carrera
INSERT INTO carrera(identificador, nombre, descripcion, fechadesde, fechahasta) VALUES(1, 'Ingenieria en sistema de informacion', 'Carrera a fines a programacion y desarrollo de software en general', '1960-01-01', NULL);
INSERT INTO carrera(identificador, nombre, descripcion, fechadesde, fechahasta) VALUES(2, 'Ingeniera civil', 'Carrera a fines a construccion, planificacion y desarrollo de obras de desarrollo urbano', '1980-01-01', NULL);

-- Insert de datos iniciales curso
INSERT INTO curso(identificador, idcarrera, nombre, descripcion, cupomaximo, anio) VALUES(1, 1, 'Análisis matemático', 'Curso sobre el desarrollo avanzado de matemáticas', 5, 2018);
INSERT INTO curso(identificador, idcarrera, nombre, descripcion, cupomaximo, anio) VALUES(2, 1, 'Diseño de sistemas', 'Curso sobre diseño de componentes de sistemas de software', 3, 2018);
INSERT INTO curso(identificador, idcarrera, nombre, descripcion, cupomaximo, anio) VALUES(3, 1, 'Java', 'Curso sobre el lenguaje de programacion JAVA', 4, 2018);
INSERT INTO curso(identificador, idcarrera, nombre, descripcion, cupomaximo, anio) VALUES(4, 1, 'Bases de datos-SQL', 'Curso sobre tipos de base de datos y consultas sql', 10, 2018);
INSERT INTO curso(identificador, idcarrera, nombre, descripcion, cupomaximo, anio) VALUES(5, 2, 'Fisica básica', 'Curso sobre fundamentso base de fisica', 5, 2018);
INSERT INTO curso(identificador, idcarrera, nombre, descripcion, cupomaximo, anio) VALUES(6, 2, 'Dibujo', 'Curso sobre dibujo de planos', 10, 2018);


