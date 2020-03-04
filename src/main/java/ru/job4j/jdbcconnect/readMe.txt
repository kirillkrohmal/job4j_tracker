Любое приложение выводит дополнительную информацию в консоль или записывает ее в файл.

В Java есть удобная библиотека, которая позволяется решать эти вопросы.

Lob4j - библиотека позволяет осуществить логирование процессов в приложении.

Давайте подключим эту библиотеку в наш проект.

Для этого в корневом pom.xml добавим следующие библиотеки.

<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-api -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-api</artifactId>
    <version>2.11.1</version>
</dependency>

<!-- https://mvnrepository.com/artifact/org.apache.logging.log4j/log4j-core -->
<dependency>
    <groupId>org.apache.logging.log4j</groupId>
    <artifactId>log4j-core</artifactId>
    <version>2.11.1</version>
</dependency>

Теперь нужно создать файл в модуле chapter_008/resources/log4j2.xml

Ниже представлен конфигурация файла.

<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="WARN">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
        </Console>
    </Appenders>
    <Loggers>
        <Logger name="ru.job4j.principle_004" level="trace" additivity="false">
            <AppenderRef ref="Console"/>
        </Logger>
        <Root level="error">
            <AppenderRef ref="Console"/>
        </Root>
    </Loggers>
</Configuration>

Давайте разберемся в элементах файла.

<Configuration status="WARN"> указываем, что логгер будет обрабатывать все исключения с уровень WARN и выше.

Ниже представлены уровни сообщений начиная с низшего и заканчивая высшим.

Высшим значит - это сообщения приводящие к поломке приложения.

trace
debug
info
warn
error

Далее

<Appenders>
    <Console name="Console" target="SYSTEM_OUT">
        <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n"/>
    </Console>
</Appenders>

Указывает на хранилище сообщений. В данном примере мы сообщения выводим в лог.

Далее
<Loggers>
    <Logger name="ru.job4j.principle_004" level="trace" additivity="false">
        <AppenderRef ref="Console"/>
    </Logger>
    <Root level="error">
        <AppenderRef ref="Console"/>
    </Root>
</Loggers>

Этот кусок кода указывает уровни логера для конкретных пакетов.

Теперь можно использовать библиотеку в коде.

package ru.job4j.principle_004;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class UsageLog4j2 {

    private static final Logger LOG = LogManager.getLogger(UsageLog4j2.class.getName());

    public static void main(String[] args) {
        LOG.trace("trace message");
        LOG.debug("debug message");
        LOG.info("info message");
        LOG.warn("warn message");
        LOG.error("error message");
    }
}

Запустим этот код.

13:11:03.179 [main] TRACE ru.job4j.principle_004.UsageLog4j2 - trace message
13:11:03.189 [main] DEBUG ru.job4j.principle_004.UsageLog4j2 - debug message
13:11:03.189 [main] INFO ru.job4j.principle_004.UsageLog4j2 - info message
13:11:03.189 [main] WARN ru.job4j.principle_004.UsageLog4j2 - warn message
13:11:03.190 [main] ERROR ru.job4j.principle_004.UsageLog4j2 - error message

Мы получим следующий вывод.

Давайте создадим новый класс в другом папке.



package ru.job4j.principle_003;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ExJob {

    private static final Logger LOG = LogManager.getLogger(ExJob.class.getName());

    public static void main(String[] args) {
        int version = 1;
        LOG.trace("trace message {}", version);
        LOG.debug("trace message {}", version);
        LOG.info("trace message {}", version);
        LOG.warn("trace message {}", version);
        LOG.error("trace message {}", version);
    }
}


Если мы запустим этот класс, то вывод уже будет другой.

13:13:54.398 [main] ERROR ru.job4j.principle_003.ExJob - trace message 1

Здесь мы видим только одно сообщение уровня Error.

Это произошло потому. что в Loggers указан базовый уровень ERROR.

<Root level="error">
    <AppenderRef ref="Console"/>
</Root>

Важно в этом примере использовались параметры в сообщение.

Указываются они через фигурные скобки {}

LOG.error("trace message {}", version);

Задание

1. Подключить log4j 2 к модулю SQL.