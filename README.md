# 🌐 URL Exercises 

Este repositorio contiene dos ejercicios básicos en **Java** para trabajar con la clase `URL` y Sockets.

## 📝 Ejercicio 1 — URLInfo
Este ejercicio pide una **URL** y muestra cada parte desglosada usando los métodos de `java.net.URL`.

### ▶️ Ejecutar desde el Main

<p align="center">
<img width="431" height="200" alt="image" src="https://github.com/user-attachments/assets/39641513-2030-47ad-a7e9-19441a83fc6b" />
</p>

## 📝 Ejercicio 2 — SimpleBrowser

Este programa funciona como un mini navegador por consola:

1. Pide una URL.
2. Descarga el HTML de esa página.
3. Lo guarda en un archivo llamado resultado.html.

▶️ Ejecutar desde el main

<p align="center">
<img width="575" height="210" alt="image" src="https://github.com/user-attachments/assets/06ee628f-1787-4f3a-ad34-c41a5747b563" />
</p>

- Vemos el resultado en **resultado.html**

<p align="center">
<img width="708" height="356" alt="image" src="https://github.com/user-attachments/assets/f9ad9ece-b232-4a63-a750-fdebcc28d104" />
</p>

# 🔢 Cliente-Servidor en Java: Sockets

## 📝 Ejercicio 1 — Square Calculator

 El servidor recibe un número enviado por el cliente y responde con su **cuadrado**.

 ▶️ Ejecutar desde la terminal

 1. Abrimos una terminal para el servidor y otra para el cliente:

    - Para ejecutar la del servidor usamos:

```bash
mvn -q -Dexec.mainClass=edu.eci.networking.SquareServer exec:java
```
<p align="center">
<img width="918" height="47" alt="image" src="https://github.com/user-attachments/assets/18153fa9-4e56-48c8-82ac-ea3970c71355" />
</p>

- Para el cliente usamos otra terminal y usamos el siguiente comando, luego de hacerlo el sistema nos pide un numero y se da el cuadrado de este:

```bash
mvn -q -Dexec.mainClass=edu.eci.networking.SquareClient exec:java
```
<p align="center">
<img width="920" height="98" alt="image" src="https://github.com/user-attachments/assets/f2546a6c-5284-4ef0-95e9-a3391ff78f90" />
</p>

## 📝 Ejercicio 2 — Function Server (sin/cos)

El servidor aplica una función trigonométrica sobre los números recibidos.Por defecto comienza con coseno, pero se puede cambiar a seno o regresar a coseno enviando comandos desde el cliente.

 ▶️ Ejecutar desde la terminal

 1. Abrimos una terminal para el servidor y otra para el cliente:

    - Para ejecutar la del servidor usamos:

```bash
mvn -q -Dexec.mainClass=edu.eci.networking.FunctionServer exec:java
```
<p align="center">
<img width="938" height="51" alt="image" src="https://github.com/user-attachments/assets/0b3e584c-967b-4bbb-8ec2-36cca8d6c3a6" />
</p>

- Para el cliente usamos otra terminal y usamos el siguiente comando, luego de hacerlo el sistema nos pide un numero o si se prefiere de una vez cambiar la función, fun:sin o fun:cos:

```bash
mvn -q -Dexec.mainClass=edu.eci.networking.FunctionClient exec:java
```
<p align="center">
<img width="937" height="303" alt="image" src="https://github.com/user-attachments/assets/7ae5456e-2e53-42c9-852a-dd42e152c2c0" />
</p>

  

