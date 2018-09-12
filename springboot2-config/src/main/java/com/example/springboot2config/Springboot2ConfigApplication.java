package com.example.springboot2config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.boot.context.properties.bind.Bindable;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.context.ApplicationContext;

import java.util.List;

@SpringBootApplication
public class Springboot2ConfigApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(Springboot2ConfigApplication.class, args);

		Binder binder = Binder.get(context.getEnvironment());

		// 绑定简单配置
		FooProperties foo = binder.bind("com.moons", Bindable.of(FooProperties.class)).get();
		System.out.println(foo.getFoo());

		// 绑定List配置
		List<String> post = binder.bind("com.moons.post", Bindable.listOf(String.class)).get();
		System.out.println(post);

		List<PostInfo> posts = binder.bind("com.moons.posts", Bindable.listOf(PostInfo.class)).get();
		System.out.println(posts);

		// 读取配置
		System.out.println(context.getEnvironment().containsProperty("com.moons.database-platform"));
		System.out.println(context.getEnvironment().containsProperty("com.moons.databasePlatform"));

	}

}
