package com.invertir.ya;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.invertir.ya.model.Article;
import com.invertir.ya.model.User;
import com.invertir.ya.service.IArticleService;
import com.invertir.ya.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.FileCopyUtils;

import java.nio.charset.StandardCharsets;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class InvertirYaApiApplication implements ApplicationRunner {

	private final ResourceLoader resourceLoader;
	private final IArticleService service;
	private final IUserService userService;

	public static void main(String[] args) {
		SpringApplication.run(InvertirYaApiApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {
		Resource resource1 = resourceLoader.getResource("classpath:json/articles.json");
		Resource resource2 = resourceLoader.getResource("classpath:json/users.json");

		// Leer el contenido del archivo JSON
		byte[] jsonData1 = FileCopyUtils.copyToByteArray(resource1.getInputStream());
		byte[] jsonData2 = FileCopyUtils.copyToByteArray(resource2.getInputStream());

		String jsonString1 = new String(jsonData1, StandardCharsets.UTF_8);
		String jsonString2 = new String(jsonData2, StandardCharsets.UTF_8);

		// Puedes usar una librería como Jackson para convertir el JSON a objetos Java
		ObjectMapper objectMapper = new ObjectMapper();
		List<Article> authors = objectMapper.readValue(jsonString1, new TypeReference<>(){});
		List<User> users = objectMapper.readValue(jsonString2, new TypeReference<>(){});

		service.saveAll(authors);
		userService.saveAll(users);

	}
}
