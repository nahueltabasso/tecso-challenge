/*Populate tables*/
/*Tabla alumno*/
INSERT INTO alumno (alumno_id, tipo_documento, nro_documento, legajo, nombre, apellido, fecha_nacimiento, promedio_carrera) VALUES(1, 'DNI', '31565839', 35839, 'Florencia', 'Maneiro', '1985-06-28', NULL);
INSERT INTO alumno (alumno_id, tipo_documento, nro_documento, legajo, nombre, apellido, fecha_nacimiento, promedio_carrera) VALUES(2, 'DNI', '31000123', 11009, 'Patricia', 'Brumatti', '1985-01-13', NULL);
INSERT INTO alumno (alumno_id, tipo_documento, nro_documento, legajo, nombre, apellido, fecha_nacimiento, promedio_carrera) VALUES(3, 'DNI', '20945422', 98734, 'Diego', 'Menendez', '1982-04-10', NULL);
INSERT INTO alumno (alumno_id, tipo_documento, nro_documento, legajo, nombre, apellido, fecha_nacimiento, promedio_carrera) VALUES(4, 'DNI', '30999281', 09213, 'Franzo', 'Perez', '1986-02-05', NULL);
INSERT INTO alumno (alumno_id, tipo_documento, nro_documento, legajo, nombre, apellido, fecha_nacimiento, promedio_carrera) VALUES(5, 'DNI', '24112872', 36299, 'Leandro', 'Garcia', '1988-01-03', NULL);

/*Tabla carreras*/
INSERT INTO carrera(carrera_id, nombre, siglas, descripcion, fecha_desde) VALUES(1, 'Ingenieria en sistema de informacion', 'ISI', 'Carrrera a fines de programacion y desarrollo de software en general', '1960-01-01');
INSERT INTO carrera(carrera_id, nombre, siglas, descripcion, fecha_desde) VALUES(2, 'Ingenieria Civil', 'IC', 'Carrrera a fines a construccion, planificacion y desarrollo de obras de desarrllo urbano', '1980-01-01');

/*Tabla docente*/
INSERT INTO docente(docente_id, nombre, apellido) VALUES(1, 'Cesar', 'Ruiz');
INSERT INTO docente(docente_id, nombre, apellido) VALUES(2, 'Paula', 'Perez');


/*Tabla curso*/
INSERT INTO curso(nombre, descripcion, cupo_maximo, anio, carrera_id, docente_id) VALUES('Analisis Matematico', 'Curso sobre el desarrollo avanzado de matematicas', 5, 2018, 1, 1);
INSERT INTO curso(nombre, descripcion, cupo_maximo, anio, carrera_id, docente_id) VALUES('Diseño de sistemas', 'Curso sobre diseño de componentes de sistemas de software', 3, 2018, 1, 2);
INSERT INTO curso(nombre, descripcion, cupo_maximo, anio, carrera_id, docente_id) VALUES('Java', 'Curso sobre el lenguaje de programacion JAVA', 4, 2018, 1, 1);
INSERT INTO curso(nombre, descripcion, cupo_maximo, anio, carrera_id, docente_id) VALUES('Base de datos-SQL', 'Curso sobre tipos de base de datos y consultas sql', 10, 2018, 1, 2);
INSERT INTO curso(nombre, descripcion, cupo_maximo, anio, carrera_id, docente_id) VALUES('Fisica Basica', 'Curso sobre fundamentes base de fisica', 5, 2018, 2, 1);
INSERT INTO curso(nombre, descripcion, cupo_maximo, anio, carrera_id, docente_id) VALUES('Dibujo Tecnico', 'Curso sobre dibujo de planos', 10, 2018, 2, 2);

/*Tabla inscripciones_curso*/
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(1, 'Aprobado', '2004-01-01', 8.0, 1, 1);
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(2, 'Aprobado', '2002-01-01', 9.0, 1, 2);
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(3, 'Aprobado', '2006-01-01', 10.0, 2, 1);
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(4, 'Regular', '2007-01-01', NULL, 2, 2);
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(5, 'Regular', '2005-01-01', NULL, 3, 3);
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(6, 'Aprobado', '2011-01-01', 8.0, 4, 4);
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(7, 'Aprobado', '2017-01-01', 7.0, 4, 1);
INSERT INTO inscripciones_curso(inscripcion_id, estado, fecha_inscripcion, nota, alumno_alumno_id, curso_curso_id) VALUES(8, 'En Curso', '2019-01-01', NULL, 5, 6);


/*Tabla inscripciones_carrera*/
INSERT INTO inscripciones_carrera(carrera_id, alumno_id) VALUES(1, 1);
INSERT INTO inscripciones_carrera(carrera_id, alumno_id) VALUES(1, 2);
INSERT INTO inscripciones_carrera(carrera_id, alumno_id) VALUES(1, 3);
INSERT INTO inscripciones_carrera(carrera_id, alumno_id) VALUES(1, 4);
INSERT INTO inscripciones_carrera(carrera_id, alumno_id) VALUES(2, 5);
