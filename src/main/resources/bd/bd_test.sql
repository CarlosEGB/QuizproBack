INSERT INTO questions (question) VALUES
('<p>Con pruebas exhaustivas es posible eliminar todos los defectos de un programa antes de su entrega al cliente.&nbsp;</p>'),
('<p>La diferencia entre la repetici&oacute;n de pruebas y las pruebas de regresi&oacute;n es la siguiente&nbsp;</p>'),
('<p>Dada la siguiente tabla de transiciones de estado &iquest;Cu&aacute;l de los siguientes casos de prueba cubrir&aacute; la siguiente serie de transiciones de estado? S1 SO S1 S2 SO</p>
<p><img src="https://ckeditor.com/apps/ckfinder/userfiles/files/image-20230506200706-1.png" style="height:114px; width:217px" /></p>');

INSERT INTO answers (answer, is_correct, question_id) VALUES
('Verdadero',false,1),
('Falso',true,1),
('La repetición de una prueba consiste en repetirla. Las pruebas de regresión buscan efectos secundarios inesperados.',true,2),
('Las pruebas de regresión buscan efectos secundarios inesperados. Las pruebas de regresión consisten en repetir esas pruebas.',false,2),
('La repetición de pruebas se realiza una vez corregidos los fallos. Las pruebas de regresión se realizan temprano.',false,2),
('La repetición de pruebas utiliza entornos diferentes. Las pruebas de regresión utilizan el mismo entorno.',false,2),
('Las pruebas de regresión las realizan desarrolladores. Las pruebas de regresión las realizan evaluadores independientes.',false,2),
('D, A, B, C.',true,3),
('A, B, C, D.',false,3),
('D, A, B.',false,3),
('A, B, C.',false,3);

INSERT INTO users (dni,user,name,email,password) values
("7475","carlos","Carlos","carlos@yopmail.com","123456"),
("8521","nicolas","Nicolas","nicolas@yopmail.com","123456");
