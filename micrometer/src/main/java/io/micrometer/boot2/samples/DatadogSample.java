package io.micrometer.boot2.samples;

import io.micrometer.boot2.samples.components.TimerTestController;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication(scanBasePackageClasses = TimerTestController.class)
public class DatadogSample {
    public static void main(String[] args) {
        new SpringApplicationBuilder(DatadogSample.class).run(args);
    }
}
