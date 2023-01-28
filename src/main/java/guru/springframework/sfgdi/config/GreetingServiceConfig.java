package guru.springframework.sfgdi.config;


import guru.springframework.sfgdi.services.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

@EnableConfigurationProperties(BindingConstructorConfig.class)
@Configuration
public class GreetingServiceConfig {

    @Bean
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }
    @Profile("EN")
    @Bean("i18nService")
    I18nEnglishGreetingService I18nEnglishGreetingService(){
        return new I18nEnglishGreetingService();
    }

    @Profile({"ES", "default"})
    @Bean("i18nService")
    I18NSpanishService i18NSpanishService(){
        return new I18NSpanishService();
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
