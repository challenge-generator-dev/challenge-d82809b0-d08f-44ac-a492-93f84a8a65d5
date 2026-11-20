# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/core/application/AccountService.java` — La pieza p2 (Inversión de dependencias mediante inyección, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).
- `src/main/java/infrastructure/adapters/AccountRepositoryAdapter.java` — La pieza p3 (Implementación de adaptadores para interfaces, fase f2) vive aqui: este archivo es su unico dueno (blueprint v2).

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/core/application/AccountServiceTest.java` — `Account.size`: Se invoca `size` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/core/application/AccountServiceTest.java` — `Account.get`: Se invoca `get` sobre `Account`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

### Imports sin uso — no rompen la compilacion

Limpieza opcional: el proyecto compila igual con ellos:

- `src/main/java/core/application/AccountService.java` — `AccountNotFoundException`

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollo backend, Tecnología Java, Advanced L2

### Brecha de conocimiento
Refactoriza un servicio con responsabilidades mezcladas aplicando principios SOLID: separación de responsabilidades, inversión de dependencias e interfaces específicas.

### Reto
- Tema: Principios SOLID aplicados al diseño de servicios
- Seniority: advanced-l2
- Tipo: practical
- Título: Refactorización de Servicio Acoplado
- Tiempo estimado: 8 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Identificación de Responsabilidades — objetivo: Identificar y separar las responsabilidades del servicio de gestión de cuentas bancarias. — entregable (NO resolver): Lista de responsabilidades identificadas y propuesta de componentes separados.
- Fase 2: Inversión de Dependencias — objetivo: Refactorizar el servicio para invertir las dependencias y mejorar la cohesión. — entregable (NO resolver): Implementación de las interfaces y refactorización del servicio para usar inyección de dependencias.
- Fase 3: Pruebas de Componentes — objetivo: Probar cada componente refactorizado para asegurar su correcta funcionalidad. — entregable (NO resolver): Pruebas unitarias para cada componente refactorizado, incluyendo casos de éxito y error.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-core</artifactId>
        </dependency>
        <dependency>
            <groupId>org.mockito</groupId>
            <artifactId>mockito-junit-jupiter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.data</groupId>
            <artifactId>spring-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter-api</artifactId>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/core/domain/Account.java ===
package core.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record Account(
    @NotNull UUID id,
    @NotBlank String accountNumber,
    @NotBlank String ownerName,
    @NotNull AccountType accountType,
    @PositiveOrZero BigDecimal balance,
    @NotNull LocalDateTime createdAt,
    @NotNull LocalDateTime updatedAt,
    boolean isActive
) {
    public enum AccountType {
        SAVINGS,
        CHECKING,
        FIXED_TERM
    }

    public Account {
        if (id == null) {
            id = UUID.randomUUID();
        }
        if (createdAt == null) {
            createdAt = LocalDateTime.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDateTime.now();
        }
        if (balance == null) {
            balance = BigDecimal.ZERO;
        }
    }

    public Account updateBalance(BigDecimal newBalance) {
        if (newBalance == null || newBalance.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Balance cannot be negative");
        }
        return new Account(
            this.id,
            this.accountNumber,
            this.ownerName,
            this.accountType,
            newBalance,
            this.createdAt,
            LocalDateTime.now(),
            this.isActive
        );
    }

    public Account deactivate() {
        return new Account(
            this.id,
            this.accountNumber,
            this.ownerName,
            this.accountType,
            this.balance,
            this.createdAt,
            LocalDateTime.now(),
            false
        );
    }
}

// === ARCHIVO: src/main/java/core/application/ports/AccountRepositoryPort.java ===
package core.application.ports;

import core.domain.Account;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AccountRepositoryPort {
    Account save(Account account);
    Optional<Account> findById(UUID id);
    List<Account> findAll();
    List<Account> findByOwnerName(String ownerName);
    void deleteById(UUID id);
    Optional<Account> findByAccountNumber(String accountNumber);
}

// === ARCHIVO: src/main/java/infrastructure/persistence/JpaAccountRepository.java ===
package infrastructure.persistence;

import core.domain.Account;
import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio Spring Data de cuentas. Solo expone operaciones de persistencia:
 * el mapeo a dominio y los contratos de puerto viven en infrastructure.adapters.AccountRepositoryAdapter.
 */
@Repository
public interface JpaAccountRepository extends JpaRepository<AccountEntity, UUID> {

    default Account save(Account account) {
        AccountEntity entity = AccountEntity.fromDomain(account);
        AccountEntity savedEntity = save(entity);
        return savedEntity.toDomain();
    }

    List<AccountEntity> findByOwnerNameContainingIgnoreCase(String ownerName);

    Optional<AccountEntity> findByAccountNumber(String accountNumber);
}

@Entity
@Table(name = "accounts")
@EntityListeners(AuditingEntityListener.class)
class AccountEntity {

    @Id
    private UUID id;

    @Column(nullable = false, unique = true)
    private String accountNumber;

    @Column(nullable = false)
    private String ownerName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Account.AccountType accountType;

    @Column(nullable = false)
    private BigDecimal balance;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    @Column(nullable = false)
    private boolean isActive;

    public AccountEntity() {
    }

    public AccountEntity(UUID id, String accountNumber, String ownerName, Account.AccountType accountType,
                         BigDecimal balance, LocalDateTime createdAt, LocalDateTime updatedAt, boolean isActive) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.ownerName = ownerName;
        this.accountType = accountType;
        this.balance = balance;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.isActive = isActive;
    }

    public static AccountEntity fromDomain(Account account) {
        return new AccountEntity(
                account.id(),
                account.accountNumber(),
                account.ownerName(),
                account.accountType(),
                account.balance(),
                account.createdAt(),
                account.updatedAt(),
                account.isActive()
        );
    }

    public Account toDomain() {
        return new Account(
                id,
                accountNumber,
                ownerName,
                accountType,
                balance,
                createdAt,
                updatedAt,
                isActive
        );
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public Account.AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(Account.AccountType accountType) {
        this.accountType = accountType;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}

// === ARCHIVO: src/main/java/core/application/AccountService.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package core.application;

import core.application.exception.AccountNotFoundException;
import core.application.ports.AccountRepositoryPort;
import core.domain.Account;
import java.util.UUID;

public class AccountService {

    private final AccountRepositoryPort accountRepository;

    public AccountService(AccountRepositoryPort accountRepository) {
        if (accountRepository == null) {
            throw new IllegalArgumentException("AccountRepositoryPort cannot be null");
        }
        this.accountRepository = accountRepository;
    }

    public Account getAccount(String id) {
      throw new UnsupportedOperationException("TODO(reto): getAccount");
    }

    public Account createAccount(Account account) {
      throw new UnsupportedOperationException("TODO(reto): createAccount");
    }

    public Account updateAccount(Account account) {
      throw new UnsupportedOperationException("TODO(reto): updateAccount");
    }

    public void deleteAccount(String id) {
      throw new UnsupportedOperationException("TODO(reto): deleteAccount");
    }

    public java.util.List<Account> getAllAccounts() {
      throw new UnsupportedOperationException("TODO(reto): getAllAccounts");
    }

    public java.util.List<Account> searchByOwnerName(String ownerName) {
      throw new UnsupportedOperationException("TODO(reto): searchByOwnerName");
    }
}

// === ARCHIVO: src/main/java/infrastructure/adapters/AccountRepositoryAdapter.java ===
// TODO(reto): archivo stubbeado; implementa los cuerpos.
package infrastructure.adapters;

import core.application.ports.AccountRepositoryPort;
import core.domain.Account;
import infrastructure.persistence.JpaAccountRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final JpaAccountRepository jpaRepository;

    public AccountRepositoryAdapter(JpaAccountRepository jpaRepository) {
        if (jpaRepository == null) {
            throw new IllegalArgumentException("JpaAccountRepository cannot be null");
        }
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<Account> findById(UUID id) {
      throw new UnsupportedOperationException("TODO(reto): findById");
    }

    @Override
    public Account save(Account account) {
      throw new UnsupportedOperationException("TODO(reto): save");
    }

    @Override
    public List<Account> findAll() {
      throw new UnsupportedOperationException("TODO(reto): findAll");
    }

    @Override
    public List<Account> findByOwnerName(String ownerName) {
      throw new UnsupportedOperationException("TODO(reto): findByOwnerName");
    }

    @Override
    public void deleteById(UUID id) {
      throw new UnsupportedOperationException("TODO(reto): deleteById");
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
      throw new UnsupportedOperationException("TODO(reto): findByAccountNumber");
    }
}

// === ARCHIVO: src/main/java/core/application/exception/AccountNotFoundException.java ===
package core.application.exception;


import core.domain.Account;
public class AccountNotFoundException extends RuntimeException {

    private final String accountId;
    private final String accountNumber;

    public AccountNotFoundException(String message) {
        super(message);
        this.accountId = null;
        this.accountNumber = null;
    }

    public AccountNotFoundException(String message, Throwable cause) {
        super(message, cause);
        this.accountId = null;
        this.accountNumber = null;
    }

    public AccountNotFoundException(String message, String accountId) {
        super(message);
        this.accountId = accountId;
        this.accountNumber = null;
    }

    public AccountNotFoundException(String message, String accountId, String accountNumber) {
        super(message);
        this.accountId = accountId;
        this.accountNumber = accountNumber;
    }

    public AccountNotFoundException(String message, String accountId, Throwable cause) {
        super(message, cause);
        this.accountId = accountId;
        this.accountNumber = null;
    }

    public String getAccountId() {
        return accountId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AccountNotFoundException: ").append(getMessage());
        
        if (accountId != null) {
            sb.append(" [Account ID: ").append(accountId).append("]");
        }
        
        if (accountNumber != null) {
            sb.append(" [Account Number: ").append(accountNumber).append("]");
        }
        
        return sb.toString();
    }

    public String getDetailedMessage() {
        StringBuilder sb = new StringBuilder();
        sb.append("No se encontró la cuenta solicitada.\n");
        
        if (accountId != null) {
            sb.append("ID de cuenta: ").append(accountId).append("\n");
        }
        
        if (accountNumber != null) {
            sb.append("Número de cuenta: ").append(accountNumber).append("\n");
        }
        
        sb.append("Por favor, verifique los datos e intente nuevamente.");
        
        return sb.toString();
    }

    public boolean hasAccountId() {
        return accountId != null && !accountId.isEmpty();
    }

    public boolean hasAccountNumber() {
        return accountNumber != null && !accountNumber.isEmpty();
    }
}

// === ARCHIVO: src/main/java/application.yml ===
spring:
  application:
    name: reto
  datasource:
    url: jdbc:postgresql://localhost:5432/pragma_bank
    username: postgres
    password: postgres
    driver-class-name: org.postgresql.Driver
    hikari:
      maximum-pool-size: 10
      minimum-idle: 5
      connection-timeout: 30000
      idle-timeout: 600000
      max-lifetime: 1800000
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: false
    properties:
      hibernate:
        dialect: org.hibernate.dialect.PostgreSQLDialect
        format_sql: true
        jdbc:
          batch_size: 20
        order_inserts: true
        order_updates: true
    open-in-view: false
  sql:
    init:
      mode: never
      schema-locations: classpath:schema.sql
      data-locations: classpath:data.sql

server:
  port: 8080
  servlet:
    context-path: /api/v1
    encoding:
      charset: UTF-8
      enabled: true
      force: true

logging:
  level:
    root: INFO
    com.example: DEBUG
    org.springframework.web: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE
  pattern:
    console: "%d{yyyy-MM-dd HH:mm:ss} - %msg%n"
    file: "%d{yyyy-MM-dd HH:mm:ss} [%thread] %-5level %logger{36} - %msg%n"

management:
  endpoints:
    web:
      exposure:
        include: health,info,metrics
  endpoint:
    health:
      show-details: always
  health:
    db:
      enabled: true

// === ARCHIVO: src/main/java/core/application/AccountServiceTest.java ===
package core.application;

import core.application.ports.AccountRepositoryPort;
import core.domain.Account;
import core.domain.Account.AccountType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepositoryPort accountRepository;

    @InjectMocks
    private AccountService accountService;

    private Account testAccount;
    private UUID testAccountId;

    @BeforeEach
    void setUp() {
        testAccountId = UUID.randomUUID();
        testAccount = new Account(
            testAccountId,
            "ACC-001",
            "Juan Perez",
            AccountType.CHECKING,
            BigDecimal.valueOf(1000.00),
            LocalDateTime.now(),
            LocalDateTime.now(),
            true
        );
    }

    @Test
    void getAccount_WhenAccountExists_ReturnsAccount() {
        when(accountRepository.findById(testAccountId))
            .thenReturn(Optional.of(testAccount));

        Account result = accountService.getAccount(testAccountId.toString());

        assertNotNull(result);
        assertEquals(testAccountId, result.id());
        assertEquals("ACC-001", result.accountNumber());
        assertEquals("Juan Perez", result.ownerName());
        verify(accountRepository, times(1)).findById(testAccountId);
    }

    @Test
    void getAccount_WhenAccountNotExists_ThrowsException() {
        UUID nonExistentId = UUID.randomUUID();
        when(accountRepository.findById(nonExistentId))
            .thenReturn(Optional.empty());

        assertThrows(RuntimeException.class, () ->
            accountService.getAccount(nonExistentId.toString())
        );
    }

    @Test
    void createAccount_WithValidData_ReturnsCreatedAccount() {
        when(accountRepository.save(any(Account.class)))
            .thenReturn(testAccount);

        Account result = accountService.createAccount(testAccount);

        assertNotNull(result);
        assertEquals("ACC-001", result.accountNumber());
        assertEquals("Juan Perez", result.ownerName());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void updateAccount_WithValidData_ReturnsUpdatedAccount() {
        Account updatedAccount = new Account(
            testAccountId,
            "ACC-001",
            "Juan Perez Actualizado",
            AccountType.CHECKING,
            BigDecimal.valueOf(2000.00),
            testAccount.createdAt(),
            LocalDateTime.now(),
            true
        );

        when(accountRepository.save(any(Account.class)))
            .thenReturn(updatedAccount);

        Account result = accountService.updateAccount(updatedAccount);

        assertNotNull(result);
        assertEquals("Juan Perez Actualizado", result.ownerName());
        assertEquals(BigDecimal.valueOf(2000.00), result.balance());
        verify(accountRepository, times(1)).save(any(Account.class));
    }

    @Test
    void deleteAccount_WithValidId_CompletesSuccessfully() {
        doNothing().when(accountRepository).deleteById(testAccountId);

        assertDoesNotThrow(() ->
            accountService.deleteAccount(testAccountId.toString())
        );

        verify(accountRepository, times(1)).deleteById(testAccountId);
    }

    @Test
    void getAllAccounts_WhenCalled_ReturnsAllAccounts() {
        List<Account> accounts = List.of(testAccount);
        when(accountRepository.findAll()).thenReturn(accounts);

        List<Account> result = accountService.getAllAccounts();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("ACC-001", result.get(0).accountNumber());
        verify(accountRepository, times(1)).findAll();
    }

    @Test
    void searchByOwnerName_WithValidName_ReturnsMatchingAccounts() {
        List<Account> accounts = List.of(testAccount);
        when(accountRepository.findByOwnerName("Juan Perez")).thenReturn(accounts);

        List<Account> result = accountService.searchByOwnerName("Juan Perez");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Juan Perez", result.get(0).ownerName());
        verify(accountRepository, times(1)).findByOwnerName("Juan Perez");
    }

    @Test
    void getAccount_WithInvalidId_ThrowsException() {
        String invalidId = "invalid-uuid-format";

        assertThrows(IllegalArgumentException.class, () ->
            accountService.getAccount(invalidId)
        );
    }

    @Test
    void createAccount_WithNullAccount_ThrowsException() {
        assertThrows(IllegalArgumentException.class, () ->
            accountService.createAccount(null)
        );
    }
}

// === ARCHIVO: src/main/java/Application.java ===
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
```
