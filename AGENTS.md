# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Refactorización de Servicio Acoplado**.

| | |
|---|---|
| Tema | Principios SOLID aplicados al diseño de servicios |
| Nivel | advanced-l2 |
| Chapter | Backend |
| Especialidad | Java |
| Stack | Java / Spring Boot 3.5 |
| Patron arquitectonico | hexagonal/clean |
| Tiempo estimado | 8 horas |

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz`
- `clase con @SpringBootApplication`
- `application.yml en src/main/resources`
- `capa de dominio con entidades y puertos`
- `capa de aplicacion con casos de uso`
- `capa de infraestructura con adaptadores y @RestController`

Trampas conocidas:

- TODA `<version>` del pom va con tres segmentos: la del parent (ej. `3.5.6`) y la de cada dependencia que la lleve (ej. Resilience4j `2.2.0`). `3.4` y `2.0` no existen como artefacto y el build muere resolviendo dependencias.
- Las dependencias que el parent POM gestiona van SIN `<version>`: `spring-boot-starter-web`, `-data-jpa`, `-validation`, `-test`, etc.
- Resilience4j publica un artefacto por linea de Spring Boot. Con Spring Boot 3 va `resilience4j-spring-boot3` con version de tres segmentos (ej. `2.2.0`, no `2.0`). `resilience4j-spring-boot2` es de Spring Boot 2 y rompe el arranque.
- Si usas anotaciones de validacion (`@NotNull`, `@Size`, `@Positive`) declara `spring-boot-starter-validation`: el starter web no las trae.
- El `spring-boot-maven-plugin` tiene que estar en `<build><plugins>` o no se empaqueta ejecutable.
- Spring Boot 3 usa `jakarta.*`, nunca `javax.*`.
- Cada archivo empieza con su `package` y con un `import` por cada clase del proyecto que viva en otro paquete. Usar `PaymentService` desde `infrastructure` sin `import com.x.application.PaymentService` no compila.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- org.mockito:mockito-core
- org.mockito:mockito-junit-jupiter
- org.postgresql:postgresql
- org.projectlombok:lombok
- org.springframework.boot:spring-boot-starter-data-jpa
- org.springframework.boot:spring-boot-starter-validation
- org.springframework.data:spring-data-jpa

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` y mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Identificación de Responsabilidades**: Lista de responsabilidades identificadas y propuesta de componentes separados.
- **Fase 2 — Inversión de Dependencias**: Implementación de las interfaces y refactorización del servicio para usar inyección de dependencias.
- **Fase 3 — Pruebas de Componentes**: Pruebas unitarias para cada componente refactorizado, incluyendo casos de éxito y error.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/main/java/core/application/AccountService.java` — La pieza p2 (Inversión de dependencias mediante inyección, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- [ ] `src/main/java/infrastructure/adapters/AccountRepositoryAdapter.java` — La pieza p3 (Implementación de adaptadores para interfaces, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).

## Mapa de fases

La **Fase 0** es clonar el repositorio, instalar dependencias y correr las pruebas de aceptacion: todas fallan porque la logica de cada pieza esta pendiente.

| Fase | Pieza (skill) | Archivo:simbolo | Criterios | Prueba | Comando |
|------|---------------|-----------------|-----------|--------|---------|
| f1 — Identificación de Responsabilidades | Definición de interfaces específicas para responsabilidades | — | Se identifican al menos tres responsabilidades distintas en el servicio original.; Se definen interfaces específicas para cada responsabilidad identificada.; Las interfaces son coherentes con los principios SOLID. | — | — |
| f2 — Inversión de Dependencias | Inversión de dependencias mediante inyección | `src/main/java/core/application/AccountService.java:AccountService` | El servicio `AccountService` depende únicamente de interfaces, no de implementaciones concretas.; Las dependencias se inyectan correctamente mediante constructor o setter.; El código refactorizado cumple con el principio de inversión de dependencias. | — | — |
| f2 — Inversión de Dependencias | Implementación de adaptadores para interfaces | `src/main/java/infrastructure/adapters/AccountRepositoryAdapter.java:AccountRepositoryAdapter` | El servicio `AccountService` depende únicamente de interfaces, no de implementaciones concretas.; Las dependencias se inyectan correctamente mediante constructor o setter.; El código refactorizado cumple con el principio de inversión de dependencias. | — | — |
| f3 — Pruebas de Componentes | Pruebas unitarias con mocks para aislar componentes | — | Cada componente refactorizado tiene pruebas unitarias que cubren sus funcionalidades principales.; Las pruebas incluyen casos de éxito y al menos dos casos de error o borde.; Las dependencias se simulan correctamente utilizando Mockito. | — | — |

## Pruebas de aceptacion y ubicacion de la logica

Las pruebas de aceptacion (columna "Prueba" de la tabla) son de **solo lectura**: definen que significa "listo". No las edites, no las borres y no les agregues `skip`; lo que se resuelve es el codigo de cada pieza.

La logica de cada pieza va en su archivo; no la muevas a otro.

## Restricciones del pedido

| Restriccion | Donde se cumple | Estado |
|-------------|-----------------|--------|
| Entiende SOLID en teoría pero le cuesta aplicarlo en código existente | sin ubicar | Verificada |

## Lo que falta y tenes que completar

### 1. Referencias colgando (2)

Salieron de un analisis estatico del codigo que SI esta en el repo. Cada una rompe la compilacion:

- [ ] `src/main/java/core/application/AccountServiceTest.java` — `Account.size`
      Se invoca `size` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- [ ] `src/main/java/core/application/AccountServiceTest.java` — `Account.get`
      Se invoca `get` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Imports sin uso (1) — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos.

- `src/main/java/core/application/AccountService.java` — `AccountNotFoundException`

### Presentes (10)

- `pom.xml`
- `src/main/java/core/domain/Account.java`
- `src/main/java/core/application/ports/AccountRepositoryPort.java`
- `src/main/java/infrastructure/persistence/JpaAccountRepository.java`
- `src/main/java/core/application/AccountService.java`
- `src/main/java/infrastructure/adapters/AccountRepositoryAdapter.java`
- `src/main/java/core/application/exception/AccountNotFoundException.java`
- `src/main/java/application.yml`
- `src/main/java/core/application/AccountServiceTest.java`
- `src/main/java/Application.java`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/main/java/com/pragma/account/core/domain` (ausente)
- `src/main/java/com/pragma/account/core/application` (ausente)
- `src/main/java/com/pragma/account/core/application/ports` (ausente)
- `src/main/java/com/pragma/account/infrastructure/adapters` (ausente)
- `src/main/java/com/pragma/account/infrastructure/persistence` (ausente)
- `src/main/resources` (ausente)
- `src/test/java/com/pragma/account/core/application` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- El patron es **hexagonal/clean**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Backend, Especialidad Desarrollo backend, Tecnología Java, Advanced L2
- Brecha que el reto ataca: Refactoriza un servicio con responsabilidades mezcladas aplicando principios SOLID: separación de responsabilidades, inversión de dependencias e interfaces específicas.

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
