package com.jtomsett.truss;

import org.modelmapper.ModelMapper;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

import io.r2dbc.postgresql.PostgresqlConnectionConfiguration;
import io.r2dbc.postgresql.PostgresqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;

@EnableR2dbcRepositories
@SpringBootApplication
public class TrussApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrussApplication.class, args);
	}

		@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI()
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")))
				.info(new Info().title("Truss API").version("0.1"));
	}


	@Bean
	public GroupedOpenApi storeOpenApi() {
		String[] paths = { "/ticket/**" };
		return GroupedOpenApi.builder().group("ticket").pathsToMatch(paths)
				.build();
	}

	    @Bean
    public ModelMapper getModelMapper() {
        return new ModelMapper();
    }

}
