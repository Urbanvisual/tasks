# Tasks Backend

Prueba tecnica de listado de tareas con las opciones de agregarlas, eliminarlas y cambiarles su estado. 

# Colección de postman para pruebas

Se encuentra en la ruta del proyecto, carpeta collection.

# Como probar

Pruebas hechas con cloudflare como tunel de local para poder consumir esta API desde el front como local. Cambiar urlBase del front cada que el cloudflare se detenga y la cambie. 

Para correr CloudFlared

1. Instalar la utilidad.
   ```bash
    brew install cloudflared 
2. Correrla generando la url del tunel.
    ```bash
    cloudflared tunnel --url http://localhost:8080
3. Copiar url y cambiarla en el frontend al correrlo.
   <img width="1278" alt="image" src="https://github.com/user-attachments/assets/45a52404-832a-4eeb-9ed5-b2f2aedc55ae">

