// ToDo - Move to JavaConfig module
package org.hsmak.ws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;
import org.springframework.xml.xsd.XsdSchemaCollection;
import org.springframework.xml.xsd.commons.CommonsXsdSchemaCollection;

//@Configuration // Commenting this out to test out configs the xml context.
public class WSDLConfig {
    @Bean(name = "countries")
    // Bean's name will be the WASDL file in (http://localhost:8080/spring_ws/ws/countries.wsdl)
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema countriesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("CountriesPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace("http://hsmak.org/ws/countries-ws");
        wsdl11Definition.setSchema(countriesSchema);
//        wsdl11Definition.setSchemaCollection(schemaCollection());
        return wsdl11Definition;
    }

    @Bean
    public XsdSchemaCollection schemaCollection() {
        CommonsXsdSchemaCollection schemaCollection = new CommonsXsdSchemaCollection();
        schemaCollection.setInline(true);
        schemaCollection.setXsds(new ClassPathResource[]{
                new ClassPathResource("schemas/countries.xsd")
        });

        return schemaCollection;
    }

    @Bean
    public XsdSchema countriesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("schemas/countries.xsd"));
    }
}
