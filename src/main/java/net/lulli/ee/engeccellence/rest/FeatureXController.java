package net.lulli.ee.engeccellence.rest;

import net.lulli.ee.engeccellence.FeatureXControllerInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/featurex")
@ConditionalOnProperty(prefix = "feature.toggle", name = "featurex", havingValue="true")
public class FeatureXController implements FeatureXControllerInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureXController.class);

    @Override
    @GetMapping("/data")
    public String getData(String param) {
        LOGGER.info("Calling ENABLED featurex with param {}", param);
        return "Actual Data";
    }
}
