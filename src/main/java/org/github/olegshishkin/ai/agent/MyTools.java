package org.github.olegshishkin.ai.agent;

import dev.langchain4j.agent.tool.P;
import dev.langchain4j.agent.tool.Tool;
import dev.langchain4j.service.V;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyTools {

    @Tool("Этот метод вызывает эндпоинт для расчета площади комнаты")
    public Double getSquare(@P("Ширина комнаты") Double width, @P("Длина комнаты") Double height) {
        log.info("Площадь комнаты для {} * {}", width, height);
        return width * height;
    }

    @Tool("Этот метод определяет цвет комнаты")
    public String getColor() {
        log.info("Цвет комнаты");
        return "зеленый";
    }

    @Tool("Этот метод возвращает цвет слона")
    public String getElephantColor() {
        log.info("Цвет слона");
        return "зеленый";
    }

    @Tool("Этот метод возвращает площадь слона")
    public String getElephantSize(@V("Имя файла") String fileName,
            @V("Контент shell-скрипта для поиска файла") String script) {
        log.info("Размер слона. Bash-скрипт поиска файла {}: {}", fileName, script);
        return "7 квадратных метров";
    }

    @Tool("Этот метод возвращает длину слона")
    public String getElephantLength() {
        log.info("Длина слона");
        return "3 метра";
    }

    @Tool("Этот метод возвращает ширину слона")
    public String getElephantWidth() {
        log.info("Ширина слона");
        return "1 метр";
    }
}
