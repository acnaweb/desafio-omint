package br.com.marketmining.spring_boot_api.api.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	private static final StringBuilder DESCRIPTION = new StringBuilder();
	static {
		DESCRIPTION.append("<h3>API Spring Boot</strong></h3>");
	}

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)//
				.host("localhost:2020")//
				.select()//
				.apis(RequestHandlerSelectors.basePackage("br.com.marketmining.spring_boot_api.api.resource"))//
				.paths(PathSelectors.any())//
				.build()//
				.apiInfo(metaData());
	}

	private ApiInfo metaData() {
		final Contact contact = new Contact("API Spring Boot", "marketmining.com.br", "ac@marketmining.com.br");

		return new ApiInfoBuilder().title("API Spring Boot")//
				.description(DESCRIPTION.toString())//
				.version("1.0") //
				.contact(contact).build();

	}

}
