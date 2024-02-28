-- DIMENSIONES
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(150, 70, 8);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(160, 75, 9);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(155, 72, 7.5);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(155, 72, 9.2);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(160, 71, 8.8);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(150, 71, 8.8);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(150, 65, 8.1);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(170, 78, 9.5);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(158, 69, 8.3);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(162, 73, 8.9);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(148, 67, 8.0);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(175, 80, 9.8);
INSERT INTO DIMENSION(alto, ancho, grosor) VALUES(155, 70, 8.7);

-- PANTALLAS
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(5.5, 'LCD');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(6.0, 'AMOLED');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(5.8, 'IPS');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(6.4, 'OLED');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(5.7, 'Super AMOLED');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(6.2, 'Retina');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(5.9, 'LCD');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(6.3, 'AMOLED');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(5.6, 'IPS');
INSERT INTO PANTALLA(tamanio, tecnologia) VALUES(6.1, 'OLED');

-- PROCESADORES
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Snapdragon 865', 8, 2.84);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Exynos 990', 8, 2.73);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('A13 Bionic', 6, 2.66);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Kirin 990', 8, 2.86);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Dimensity 1000', 8, 2.6);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Snapdragon 855', 8, 2.84);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Exynos 9820', 8, 2.73);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('A14 Bionic', 6, 2.86);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Kirin 980', 8, 2.6);
INSERT INTO PROCESADOR(tipo, nucleos, velocidad_max ) VALUES('Dimensity 800', 8, 2.0);

-- MARCAS
INSERT INTO MARCA(nombre ) VALUES('Samsung');
INSERT INTO MARCA(nombre ) VALUES('Apple');
INSERT INTO MARCA(nombre ) VALUES('Xiaomi');

-- MOVILES
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Galaxy S21', 128, 12, 160.0, 16, 4500, TRUE, 120, 799.99, 1, 1, 1, 6 );
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Galaxy S27', 128, 12, 160.0, 16, 4500, TRUE, 120, 299.9, 1, 1, 2, 8);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Galaxy S57', 128, 12, 160.0, 16, 4500, false, 120, 299.99, 1, 7, 2, 8);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Galaxy S17', 128, 12, 160.0, 16, 4500, false, 120, 299.99, 1, 4, 3, 8);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Iphone 13', 256, 16, 173.0, 12, 3687, TRUE, 90, 999.99, 2, 6, 4, 1);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('One Plus 9', 256, 12, 183.0, 48, 4500, TRUE, 110, 899.9, 1, 8, 2, 1);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Redmi 6', 128, 8, 183.8, 50, 4600, TRUE, 105, 899.9, 3, 7, 1, 1);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Xperia 5 III', 128, 8, 160.0, 20, 4300, TRUE, 95, 899.9, 1, 8, 1, 8);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Mi 11', 256, 12, 196.0, 108, 4600, TRUE, 80, 799.9, 3, 8, 4, 8);
INSERT INTO MOVIL(modelo, almacenamiento_gb, ram, peso, camara, bateria, nfc, contador_visita, precio_actual, marca_id, pantalla_id, dimension_id, procesador_id ) VALUES('Galaxy Z Flip 3', 128, 8, 183.8, 12, 3300, TRUE, 85, 1099.9, 1, 7, 4, 6);








