package org.github.olegshishkin.ai.agent;

import dev.langchain4j.memory.ChatMemory;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.mistralai.MistralAiChatModel;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public ChatLanguageModel model(
            @Value("${langchain4j.mistral.chat-model.api-key}") String apiKey,
            @Value("${langchain4j.mistral.chat-model.model-name}") String model,
            @Value("${langchain4j.mistral.chat-model.log-requests}") boolean logRequests,
            @Value("${langchain4j.mistral.chat-model.log-responses}") boolean logResponses) {
        return MistralAiChatModel.builder()
                .apiKey(apiKey)
                .modelName(model)
                .logRequests(logRequests)
                .logResponses(logResponses)
                .build();
    }

    @Bean
    ChatMemory chatMemory() {
        return MessageWindowChatMemory.withMaxMessages(10);
    }
}
