package org.github.olegshishkin.ai.agent;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class MyController {

    private final MyAssistant assistant;

    @PostMapping("/assist")
    public String assist(@RequestBody String prompt) {
        return assistant.assist(prompt);
    }
}
