package ua.pp.darknsoft.config.date;

import org.joda.time.DateTimeZone;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.pp.darknsoft.services.date.DateService;
import ua.pp.darknsoft.services.date.JodaDateService;

@Configuration
public class DateServiceConfig {

    @Bean
    DateService dateService() {
        return new JodaDateService(defaultTimeZone());
    }

    @Bean
    DateTimeZone defaultTimeZone() {
        return DateTimeZone.UTC;
    }
}
