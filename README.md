# java-blog-spots
Repo to practice springboot

Para correr en en local conectandose a la DB en local se debe pasar como parametro el flag `-PisLocal`, adicionalmente se deben diferenciart los properties de la siguiente forma

```txt
// CLOUD
#spring.datasource.url=jdbc:mysql://google/${DB_NAME}?cloudSqlInstance=${DB_INSTANCE_NAME}&socketFactory=com.google.cloud.sql.mysql.SocketFactory&useSSL=false
#spring.datasource.username=${DB_USERNAME}
#spring.datasource.password=${DB_PASSWORD}

// DEV
spring.datasource.url=jdbc:mysql://${DB_HOSTNAME_DEV}:${DB_PORT}/${DB_NAME}
spring.datasource.username=${DB_USERNAME_DEV}
spring.datasource.password=${DB_PASSWORD_DEV}
```