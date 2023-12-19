package com.example.demo.config

import io.swagger.v3.oas.models.Components

import io.swagger.v3.oas.models.OpenAPI
import io.swagger.v3.oas.models.info.Info
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration


@Configuration
class OpenApiConfig {
    @Bean
    fun openAPI(): OpenAPI {
        val info: Info = Info()
                .title("SnowHub-Backend API Document")
                .version("v0.0.1")
                .description("SnowHub Backend Server api 명세서입니다.")
        return OpenAPI()
                .components(Components())
                .info(info)
    }
}