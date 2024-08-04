spring:
    datasource:
        url: jdbc:mysql://localhost:3306/ms_curso_demo?useSSL=false&serverTimezone=UTC
        username: "user"
        password: "password"
        driver-class-name: com.mysql.cj.jdbc.Driver

    jpa:
        hibernate:
            ddl-auto: update
        show-sql: true
        properties:
            hibernate:
                dialect: org.hibernate.dialect.MySQLDialect
    
    application:
        name: ms-curso-demo
    
app:
    factor: 4800
    mensaje: "Test de micros"
    urlClient: "http://localhost:4200"