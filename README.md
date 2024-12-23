# UltimateTest
Ejemplo de uso de herramientas de Android

* Software de diseño
  Adobe XD

* Sistema operativo
  Mac OS Apple M1 Sonoma 14.2.1

* Version de Android
  Android Studio Koala | 2024.1.1
  Build #AI-241.15989.150.2411.11948838, built on June 10, 2024
  Runtime version: 17.0.10+0-17.0.10b1087.21-11609105 aarch64
  VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.

* Librerias utilizadas
  Kotlin Serialization
  Hilt
  Jetpack Compose
  Ktor
  Coil
  Coroutines

* Clean Architecture

* Instrucciones
  Abrir el proyecto en la rama dev o main, y bajar todos los cambios, tener a la mano un dispositivo Android 10 o superior con INTERNET.
  de no tener internet solo se mostrará en el LOG la información del error, en caso de NO INTERNET y volverlo a conectar el internet y navegar entre pantallas se
  descargarán las imagenes y los respectivos response.

  Debido a que es una aplicación con PAGINACIÓN las listas son acumulables.

* Descripcion del alcance:
1. Configuración del Proyecto:
* Configura un proyecto Android utilizando Kotlin y Jetpack Compose.
2. Consumo de Servicio Web:
* Realiza una solicitud GET a un servicio web RESTful (por ejemplo, puedes usar rickandmortyapi.com para obtener datos de prueba).
3. Mapeo de Datos:
* Parsear la respuesta JSON y mapearla a objetos Kotlin.
4. Interfaz de Usuario:
* Crea una UI con Jetpack Compose que muestre los datos en una lista (puedes utilizar LazyColumn).
5. Arquitectura:
* Implementa la arquitectura MVVM para estructurar el código de manera adecuada.
6. Gestión de Estados:
* Gestiona los estados de la UI (cargando, éxito, error) de manera eficiente.

Proyecto en API FREE TO GAMES:

Rama -> main

![WhatsApp Image 2024-12-23 at 16 18 26 (6)](https://github.com/user-attachments/assets/bc9fb564-ca79-4dbe-ba0e-175d29c15365)


![WhatsApp Image 2024-12-23 at 16 18 26 (5)](https://github.com/user-attachments/assets/7dd6c113-c413-443c-9b83-4f4fb78974cc)
![WhatsApp Image 2024-12-23 at 16 18 26 (4)](https://github.com/user-attachments/assets/d0eae328-5869-4f10-aee0-0c8a05dd823d)

![WhatsApp Image 2024-12-23 at 16 18 26](https://github.com/user-attachments/assets/afbedf91-5eea-4deb-a941-d49469608d70)
![WhatsApp Image 2024-12-23 at 16 18 26 (3)](https://github.com/user-attachments/assets/29f296b1-da9c-4937-8afc-bd963eb12d95)
![WhatsApp Image 2024-12-23 at 16 18 26 (2)](https://github.com/user-attachments/assets/ba7c8b42-e479-4242-9353-55133c188951)
![WhatsApp Image 2024-12-23 at 16 18 26 (1)](https://github.com/user-attachments/assets/0ed34aab-403a-45c9-8143-6f20db06ec8a)

* Explicacion de la solucion
Se decidio aplicar Compose debido a que la implementacion es mas rapida demas de la gran cantidad de librerias y compatibilidad con librerias como Dagger y Room,
Se empezó por una pantalla de Bienvenida en la cual colocamos el endpoint a consultar

* Posteriormente en la siguiente pantalla se hace una consulta a backend por medio de Ktor, para las peticiones se construyó sobre un core de conexion hecho con el mismo ktor, para el manejo de peticiones y errores.
* En la misma pantalla se hace el guardado en Room de los datos, en caso de NO haber internet pero si de tener registros sé muestran los registros locales, en caso de no haber ninguno se verá una pantalla en blanco

* Al seleccionar un videojuego vamos a la pantalla de detalles, debido al tiempo no se definio con todos los campos, pero se muestran los mas importantes.
* En la misma pantalla de detalle existe un boton para ir a "Editar" el videojuego y alguno de sus datos.

NOTA:
***********************************************************
** Se hizo bajo el mismo repositorio para ahorrar tiempo **
** Se colocó en la rama main el desarrollo ****************
***********************************************************





Proyecto en API RICK AND MORTY:

Rama -> release/rick-and-morty-api

* Alcance no alcanzado:
Al no contar con más tiempo, se decidio que el almacenamiento local de los datos se llevara acabo por el momento solo en el ViewModel, posteriormente habrá una actualización para almacenarnos con Realm.

* Explicación de la solución:
Se empezó por el analisis de los requerimientos, posteriormente se llevó acabo un pequeño analisis de los modelos de respuesta para sabér las mejor forma de mostrarlos de cara al usuario, de manera que fuera entendible y agradable,
se usó el Software ADOBE XD, con la ayuda de la documentacón de https://rickandmortyapi.com/documentation/#introduction se desarrolló una estrategia que consistia en 4 pantalla, siendo el esquema el siguiente:


1.- Pantalla de bienvenida
En esta pantalla es la inicial y solo con fines ilustrativos para presentar un look and feel con fondo blanco y colores caracteristicos del logo de RickAndMorty
se tomaron en cuenta colores primarios y secundarios, siendo los siguientes los colores dominantes;

PrimaryColor
#41B4CA

SecondaryColor
#BFDE42

2.- Pantalla de HOME con BottomNavigationBar
Pantalla donde se consume el servicio -> https://rickandmortyapi.com/api/character así como su paginación.

3.- Pantalla de LOCATIONS en 2da posición, se consume el servicio de -> https://rickandmortyapi.com/api/location de igual forma su respectiva paginación al llegar hasta el ultimo elemento visible en la pantalla,
de forma horizontal se muestra una lista de los habitantes y un pequeño contador de los mismos.

4.- Y por ultimo y no menos importante EPISODES, este servicio -> https://rickandmortyapi.com/api/episodes se muestra de manera vertical la lista de capitulos con su nombre y una lista de forma horizontal de los personajes que arroja el mismo servicio.

* Aplicacion

![result](https://github.com/user-attachments/assets/d3f820ab-2430-4ce6-9e8b-f59cec89516c)

* Adobe XD
![image](https://github.com/user-attachments/assets/a979b09d-34a4-4c99-8eca-7e1e11dea836)


* Screenshots

![welcome](https://github.com/user-attachments/assets/56165dbd-8631-4002-b18c-d8f85c67cd74)


![characters](https://github.com/user-attachments/assets/60ae9479-1122-4134-9cfb-577eed3e8884)


![locations](https://github.com/user-attachments/assets/0672bf27-ab62-4e1e-8c0c-3d8758f1d67e)


![episodes](https://github.com/user-attachments/assets/e4a44392-41a9-41c4-87cf-fe35cd101040)





