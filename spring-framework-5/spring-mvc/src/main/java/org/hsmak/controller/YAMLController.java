package org.hsmak.controller;

import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import java.util.List;

@Controller
public class YAMLController {
    @RequestMapping(
            value = "/yaml",
            produces = "text/yaml")
    @ResponseBody // Make sure Jackson jars are on the classpath
    public Person getYaml() {
        Person person = new Person();
        return person;
    }

    static class Person {
        String name = "Kamala";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}

@Configuration
class WebConfig extends WebMvcConfigurationSupport {
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(convertersY());
    }

    @Bean
    public HttpMessageConverter<?> convertersY() {
        YamlJackson2HttpMessageConverter yamlJackson2HttpMessageConverter = new YamlJackson2HttpMessageConverter();
        return yamlJackson2HttpMessageConverter;
    }

    class YamlJackson2HttpMessageConverter extends AbstractJackson2HttpMessageConverter {
        YamlJackson2HttpMessageConverter() {
            super(new YAMLMapper(),
                    new MediaType("application", "yaml"),
                    new MediaType("application", "x-yaml"),
                    new MediaType("text", "yaml"),
                    new MediaType("text", "x-yaml"));
        }
    }
}

