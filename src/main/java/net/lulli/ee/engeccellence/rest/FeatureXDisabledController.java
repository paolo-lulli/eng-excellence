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
@ConditionalOnProperty(prefix = "feature.toggle", name = "featurex", havingValue="false")
public class FeatureXDisabledController implements FeatureXControllerInterface {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeatureXDisabledController.class);

    @Override
    @GetMapping("/data")
    public String getData(String param) {
        LOGGER.info("Calling DISABLED featurex");
        return "The Feature is currently not active";
    }
}
