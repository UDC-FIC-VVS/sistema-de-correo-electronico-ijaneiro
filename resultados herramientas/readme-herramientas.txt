Creo este readme de herramientas, porque cuando fui subiendo los resultados de cada herramienta me olvidé
de ir comentando la categoria de cada una de las pruebas de las herramientas.

--> QuickCheck:
	Herramienta que lanza pruebas repetidamente con datos aleatorios dinamicas funcionales y de caja negra. Se debe a que ejecuta el codigo de 
	la aplicacion,	y compruebando su correcto funcionamiento (dinámicas funcionales). Pero solo comprueba el resultado, por lo tanto no es
	consciente del diseño del codigo (caja negra).

--> CheckStyle:
	Herramienta que lanza pruebas estáticas estruturales de caja branca. Se debe a que no comprueba que la aplicacion funcione como se espera
	y sin ejecutar el codigo (estáticas), y solo comprueban el diseño del codigo (pruebas estructurales de caja blanca).
	
--> SpotBugs:
	Herramienta que lanza pruebas dinamicas de caja branca. Se debe ejecuta el codigo de la aplicacion (dinámicas), y solo comprueban el diseño 
	del codigo (pruebas estructurales de caja blanca).
	
--> JETM:
	Herramienta que lanza pruebas no funcionales dinámicas de caja negra. Se debe a que ejecuta el codigo de la aplicacion, pero no comprueba su
	correcto funcionamiento (dinámicas no funcionales), sinno que solo comprueba el rendimiento de los procedimientos que hay en el codigo 
	(no funcionales de caja negra).
	
--> ArchUnit:
	Herramienta que lanza pruebas dinamicas estruturales de caja branca. Se debe a que ejecuta el codigo de la aplicacion, pero no comprueba su
	correcto funcionamiento (dinámicas no funcionales), y solo comprueban el diseño del codigo (pruebas estructurales de caja blanca).
	
--> PiTest:
	Herramienta que lanza pruebas de mutacion dinamicas funcionales y de caja blanca. Se debe a que ejecuta el codigo de la aplicacion (con mutaciones),
	y comprueba el correcto funcionamiento de los test para detectar estas mutaciones (dinámicas funcionales). Y como inserta mutaciones dentro del codigo
	de la aplicacion, es consciente de su diseño (caja blanca).

	