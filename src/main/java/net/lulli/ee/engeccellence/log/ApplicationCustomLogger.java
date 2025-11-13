package net.lulli.ee.engeccellence.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ApplicationCustomLogger implements CommandLineRunner {
    private static final Logger LOGGER = LoggerFactory.getLogger(ApplicationCustomLogger.class);

    @Override
    public void run(String... args) {
        LOGGER.atInfo().setMessage("structured log").addKeyValue("logtype", "structured").log();
    }
}
