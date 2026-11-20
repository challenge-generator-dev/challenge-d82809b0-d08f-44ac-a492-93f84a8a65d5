# Refactorización de Servicio Acoplado

El servicio de gestión de cuentas bancarias en el sistema de banca digital de Pragma tiene responsabilidades mezcladas y necesita ser refactorizado aplicando los principios SOLID. El servicio actual maneja tanto la lógica de negocio como la persistencia de datos, lo que dificulta su mantenimiento y pruebas. Tu tarea es separar las responsabilidades, invertir las dependencias e implementar interfaces específicas para mejorar la cohesión y la facilidad de prueba del servicio.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Principios SOLID aplicados al diseño de servicios |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 8 horas |

## Stack

- **Lenguaje:** Java
- **Framework:** Spring Boot 3.5
- **Version:** Java 21

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Tener el proyecto base del reto funcionando en tu máquina: clonar el repositorio, instalar las herramientas y verificar que compila y arranca antes de empezar a practicar.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Instala las herramientas para ejecutar el proyecto: JDK 17+ y Maven 3.9+.
- Clona el repositorio del reto (el enlace viene en la entrega del reto y en la sección "Repositorio del Proyecto" del PDF) y ábrelo en tu IDE.
- Instala las dependencias y compila ejecutando `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` en la raíz del repositorio.
- Confirma que el comando termina sin errores: el proyecto arranca y sus pruebas corren.
- Ubica los archivos de práctica: son los que contienen `TODO(reto)` (búscalos en el repositorio). Lee el README.md y el AGENTS.md antes de empezar.

**Entregable:** El proyecto compila/arranca sin errores con `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package`.

<details>
<summary>Pistas de conocimiento</summary>

- Los archivos con `TODO(reto)` son el ejercicio: el resto del repositorio ya está resuelto y no hace falta tocarlo.
- Si el comando de verificación falla, revisa la versión de las herramientas instaladas antes de modificar código.
- AGENTS.md describe el reto, el comando de verificación y las reglas del repositorio.

</details>

### Fase 1: Identificación de Responsabilidades

**Objetivo:** Identificar y separar las responsabilidades del servicio de gestión de cuentas bancarias.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Analiza el servicio existente y enumera las responsabilidades que tiene.
- Identifica cuáles de estas responsabilidades pueden ser separadas en componentes distintos.

**Entregable:** Lista de responsabilidades identificadas y propuesta de componentes separados.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo cada responsabilidad afecta a las demás.
- Piensa en cómo cada responsabilidad puede ser aislada y probada de forma independiente.

</details>

### Fase 2: Inversión de Dependencias

**Objetivo:** Refactorizar el servicio para invertir las dependencias y mejorar la cohesión.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Refactoriza el servicio `AccountService` para que dependa de las interfaces definidas en la fase f1.
- Asegúrate de que el servicio no dependa de implementaciones concretas, sino de abstracciones.
- Implementa la inyección de dependencias para las interfaces creadas.

**Entregable:** Implementación de las interfaces y refactorización del servicio para usar inyección de dependencias.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza interfaces para definir contratos entre componentes.
- Asegúrate de que cada componente dependa de abstracciones, no de implementaciones concretas.

</details>

### Fase 3: Pruebas de Componentes

**Objetivo:** Probar cada componente refactorizado para asegurar su correcta funcionalidad.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Escribe pruebas unitarias para `AccountService` utilizando Mockito para simular las dependencias.
- Verifica que cada método del servicio funcione correctamente con entradas válidas e inválidas.
- Asegúrate de que las pruebas cubran al menos dos casos de error o borde por componente.

**Entregable:** Pruebas unitarias para cada componente refactorizado, incluyendo casos de éxito y error.

<details>
<summary>Pistas de conocimiento</summary>

- Utiliza un marco de trabajo de pruebas para escribir y ejecutar tus pruebas.
- Asegúrate de que tus pruebas cubren todos los casos de uso y edge cases relevantes.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son los principios SOLID y por qué son importantes en el diseño de servicios?
- **paraQueSirve**: ¿Cómo aplicas los principios SOLID para mejorar la calidad del código y la facilidad de mantenimiento?
- **comoSeUsa**: ¿Cómo refactorizas un servicio acoplado aplicando los principios SOLID?
- **erroresComunes**: ¿Cuáles son los errores comunes al aplicar los principios SOLID y cómo los evitas?
- **queDecisionesImplica**: ¿Qué decisiones implica la aplicación de los principios SOLID en el diseño de servicios?

## Criterios de Evaluacion

- Identificación correcta de las responsabilidades del servicio.
- Aplicación adecuada del principio de inversión de dependencias.
- Creación de interfaces específicas para cada componente.
- Escritura de pruebas unitarias que cubren todos los casos de uso y edge cases relevantes.

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Identificación de Responsabilidades | Definición de interfaces específicas para responsabilidades | — | Se identifican al menos tres responsabilidades distintas en el servicio original.; Se definen interfaces específicas para cada responsabilidad identificada.; Las interfaces son coherentes con los principios SOLID. | — | — |
| f2 — Inversión de Dependencias | Inversión de dependencias mediante inyección | `src/main/java/core/application/AccountService.java:AccountService` | El servicio `AccountService` depende únicamente de interfaces, no de implementaciones concretas.; Las dependencias se inyectan correctamente mediante constructor o setter.; El código refactorizado cumple con el principio de inversión de dependencias. | — | — |
| f2 — Inversión de Dependencias | Implementación de adaptadores para interfaces | `src/main/java/infrastructure/adapters/AccountRepositoryAdapter.java:AccountRepositoryAdapter` | El servicio `AccountService` depende únicamente de interfaces, no de implementaciones concretas.; Las dependencias se inyectan correctamente mediante constructor o setter.; El código refactorizado cumple con el principio de inversión de dependencias. | — | — |
| f3 — Pruebas de Componentes | Pruebas unitarias con mocks para aislar componentes | — | Cada componente refactorizado tiene pruebas unitarias que cubren sus funcionalidades principales.; Las pruebas incluyen casos de éxito y al menos dos casos de error o borde.; Las dependencias se simulan correctamente utilizando Mockito. | — | — |

## Pruebas de aceptacion

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Entiende SOLID en teoría pero le cuesta aplicarlo en código existente | sin ubicar | Verificada |

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
