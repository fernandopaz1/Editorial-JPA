# Persistencia de datos con JPA

Este es un ejemplo de conexión a una base de datos usando la API de persistencia de datos de Java.

La base de datos elegida es [Apache Derby](https://db.apache.org/derby/#What+is+Apache+Derby%3F), la cual se encuentra embebida en el proyecto una vez este inicia.

Se busca poder cargar los datos en formato csv a una base de datos para luego poder hacer consultas SQL sobre la misma.

Para esto se realiza un mapeo objeto relacional (<strong>ORM</strong>) utilizando [JPA](https://hibernate.org/orm/).

La carga de datos a la base se hace mediante la libreria commons-csv.

El manejo de dependencias se realiza con [Maven](https://maven.apache.org/).


Para ejecutar este programa se debe ejecutar el main de la clase edu.epidata.CargaDatos