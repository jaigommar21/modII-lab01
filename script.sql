SELECT * FROM almacen.categorias;

USE almacen;
INSERT INTO categorias (nombre,descripcion,orden) VALUES ('Monitores','Categoria de monitores',4);

USE almacen;
UPDATE categorias SET nombre='Monitores Gama Baja', descripcion='Categoria de Monitores Gama Baja' WHERE id=6;

USE almacen;
DELETE FROM categorias WHERE id = 8;