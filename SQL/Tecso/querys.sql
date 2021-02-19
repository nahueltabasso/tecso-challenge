-- EJERCICIO 1
/*Realizar una consulta para consultar todos los alumnos existentes, mostrat: TipoDoc, Documento, Nombre, Apellido, Legajo.*/
SELECT p.tipodoc AS TipoDoc, p.documento AS Documento, p.nombre AS Nombre, p.apellido AS Apellido, a.legajo AS Legajo
FROM alumno a
INNER JOIN persona p ON p.identificador = a.idpersona;

-- EJERCICIO 2
/*Realizar una consulta para consultar todas las carreras a la que un alumno esta inscripto, mostrar: Legajo, nombre, apellido, nombre carrera, fechainscripcioncarrera
ordenado por legajo descendiente*/
-- Eligiendo a un alumno 1 (Florencia Maneiro)
SELECT a.legajo AS Legajo, p.nombre AS Nombre, p.apellido AS Apellido, c.nombre AS NombreCarrera, ic.fechainscripcion AS FechaInscripcion
FROM alumno a
INNER JOIN inscripciones_carrera ic ON ic.idalumno = a.identificador
INNER JOIN carrera c ON c.identificador = ic.idcarrera
INNER JOIN persona p ON p.identificador = a.idpersona
WHERE a.identificador = 1;

-- De todos los alumnos
SELECT a.legajo AS Legajo, p.nombre AS Nombre, p.apellido AS Apellido, c.nombre AS NombreCarrera, ic.fechainscripcion AS FechaInscripcion
FROM alumno a
INNER JOIN inscripciones_carrera ic ON ic.idalumno = a.identificador
INNER JOIN carrera c ON c.identificador = ic.idcarrera
INNER JOIN persona p ON p.identificador = a.idpersona
ORDER BY a.legajo DESC;

-- Ejercicio 3
/*Realizar una consulta para consultar la cantidad de inscriptos por por curso, mostrando: nombre carrera, nombre curso, cantidad inscriptos, cupo maximo por curso*/
SELECT ca.nombre AS NombreCarrera, c.nombre AS NombreCurso, COUNT(ic.fechainscripcion) AS CantidadInscriptos, c.cupomaximo AS CupoMaximo
FROM curso c
INNER JOIN inscripciones_curso ic ON ic.idcurso = c.identificador
INNER JOIN carrera ca ON ca.identificador = c.idcarrera
GROUP BY ca.nombre, c.nombre;

-- EJERCICIO 4
/*Sobre la consulta anterior (copiar y pegar y modificarla) modificar la sql para que la consulta retorne solo los cursos cuya cantidad de
inscripciones supera su cupo maximo*/
SELECT ca.nombre AS NombreCarrera, c.nombre AS NombreCurso, COUNT(ic.fechainscripcion) AS CantidadInscriptos, c.cupomaximo AS CupoMaximo
FROM curso c
INNER JOIN inscripciones_curso ic ON ic.idcurso = c.identificador
INNER JOIN carrera ca ON ca.identificador = c.idcarrera
GROUP BY ca.nombre, c.nombre
HAVING COUNT(ic.fechainscripcion) > c.cupomaximo;

-- EJERCICIO 5
/*Actualizar todos los cursos que posean anio 2018 y cuyo cupo sea menor a 5, y actualizar el cupo de todos ellos a 10*/
SET SQL_SAFE_UPDATES=0;
UPDATE curso SET cupomaximo = 10 WHERE anio = 2018 AND cupomaximo < 5;

-- EJERCICIO 6
/*Actualizar todas las fechas de inscripcion a cursados que posean el siguiente error: la fecha de inscripcion al cursado de un 
alumno es menor a la fecha de inscripcion a la carrera. La nueva fecha que debe tener es la fecha del dia. Se puede hacer en dos pasos
primero realizando la consulta y luego realizando el update manual*/
SELECT *
FROM inscripciones_curso ic
INNER JOIN alumno a ON a.identificador = ic.idalumno
INNER JOIN inscripciones_carrera ica ON ica.idalumno = a.identificador
WHERE ic.fechainscripcion < ica.fechainscripcion;

UPDATE inscripciones_curso c 
JOIN alumno a ON a.identificador = c.idalumno
JOIN inscripciones_carrera ic ON ic.idalumno = a.identificador 
SET c.fechainscripcion = CURRENT_DATE() WHERE c.fechainscripcion < ic.fechainscripcion;

-- EJERCICIO 7
/*INSERTAR un nuevo registro de alumno con tus datos personales, (hacer todos inserts que considera necesario)*/
INSERT INTO persona(identificador, tipodoc, documento, nombre, apellido, fechanac) VALUES(6, 'DNI', 39949799, 'Nahuel', 'Tabasso', '1996-12-11');
INSERT INTO alumno(identificador, idpersona, legajo) VALUES(6, 6, 43204);

-- EJERCICIO 8
/*Si se desea comenzar a persistir de ahora en mas el dato de direccion de un alumno y considerando que este es un unico cambio string
de 200 caracteres. Determine que tabla seria mas conveniente persistir esta informacion y realizar la modificacion de estructuras correspondientes*/
ALTER TABLE persona ADD direccion varchar(200) NULL;

 