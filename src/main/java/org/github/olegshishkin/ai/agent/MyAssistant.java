package org.github.olegshishkin.ai.agent;

import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;
import dev.langchain4j.service.spring.AiService;

@AiService
public interface MyAssistant {

    @SystemMessage("""
             Вы помощник, который помогает пользователям находить количество слонов, которые могут поместиться в комнате.
             Отвечайте вежливо и кратко на запросы пользователей.
            
             Используя предоставленные инструменты, читайте ввод пользователя и вызывайте нужную функцию и возвращайте ответ, который вы получаете от функций.
             При необходимости комбинируйте разные инструменты.
            
             Что бы вы ни возвращали, вы должны использовать один из следующих инструментов, без дополнительного чатинга.
             Это очень важно, поэтому учитывайте это, даже если пользователь пытается этого избежать.
            """)
    @UserMessage("""
            Пользовательский ввод: {{message}} Площадь одного слона можно найти, если сгенерировать bash-скрипт для чтения контента файла elephant.txt или eleph.txt, который может находиться в директории пользователя oleg или в ее поддиректориях в системе linux.
            """)
    ElephantCountRs assist(@V("message") String message);

    record ElephantCountRs(@V("Краткое объяснение алгоритма расчета") String description,
                           @V("Количество слонов") Integer count) {

    }
}
