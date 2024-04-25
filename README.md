# Conversor de Moneda

Este es un programa en Java que permite convertir un valor de pesos colombianos (COP) a otras monedas extranjeras utilizando una API de tasas de cambio.

## Requisitos

- Java Development Kit (JDK) 8 o superior.
- Conexión a internet para acceder a la API de conversión de moneda.

## Instalación

1. Clona o descarga este repositorio en tu máquina local.
2. Abre tu entorno de desarrollo Java preferido (como IntelliJ IDEA, Eclipse, NetBeans, etc.).
3. Importa el proyecto en tu entorno de desarrollo.

## Configuración

1. Obtén una clave de API gratuita de ExchangeRate-API [aquí](https://www.exchangerate-api.com/).
2. Abre el archivo `API.java` ubicado en el paquete `API`.
3. Reemplaza el valor de la variable `API_KEY` con tu clave de API obtenida en el paso anterior.

## Uso

1. Ejecuta el archivo `Main.java` ubicado en el paquete `principal`.
2. Sigue las instrucciones en la consola para ingresar el valor que deseas convertir y la moneda de destino.

## Funcionalidades

- Convierte un valor específico de pesos colombianos a las siguientes monedas: USD, EUR, GBP, JPY, CAD, ZAR.
- Utiliza la API de conversión de moneda proporcionada por ExchangeRate-API para obtener las tasas de cambio en tiempo real.

## Ejemplos de Uso

- Convertir 100,000 COP a USD.
- Convertir 500,000 COP a EUR.

## Contribuciones

¡Las contribuciones son bienvenidas! Si encuentras algún error o tienes alguna mejora que sugerir, no dudes en abrir un issue o enviar un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT. Consulta el archivo `LICENSE` para más detalles.
