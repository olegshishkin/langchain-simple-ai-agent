package org.github.olegshishkin.ai.agent;

import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.mistralai.MistralAiChatModel;
import dev.langchain4j.service.AiServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class Config {

    @Primary
    @Bean
    public ChatLanguageModel model() {
        return MistralAiChatModel.builder()
                .apiKey(System.getenv("MISTRAL_AI_API_KEY"))
                .modelName("mistral-large-latest")
                .logRequests(true)
                .logResponses(true)
                .build();
    }

    @Bean
    public MyAssistant assistant(ChatLanguageModel model, MyTools tools) {
        return AiServices.builder(MyAssistant.class)
                .chatLanguageModel(model)
                .chatMemory(MessageWindowChatMemory.withMaxMessages(10))
                .tools(tools)
                .build();
    }
}
