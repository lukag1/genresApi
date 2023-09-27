package com.onboarding.genres;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;

@SpringBootApplication
public class OnboardingGenresApplication {
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder) {
		return springApplicationBuilder
				.sources(OnboardingGenresApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(OnboardingGenresApplication.class, args);
	}
}
