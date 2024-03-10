package com.example.ex4;

import com.example.ex4.service.load.LoadService;
import com.example.ex4.service.load.LoginLoadService;
import com.example.ex4.service.path.PathFromCmdService;
import com.example.ex4.service.path.PathService;
import com.example.ex4.service.save.SaveLoginsToDataBaseService;
import com.example.ex4.service.save.SaveService;
import lombok.SneakyThrows;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class Ex4Application {


	@SneakyThrows
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Ex4Application.class, args);

		PathService pathService = context.getBean(PathFromCmdService.class);
		LoadService loadService = context.getBean(LoginLoadService.class);
		SaveService saveService = context.getBean(SaveLoginsToDataBaseService.class);

		var path = pathService.getPath();
		var loaded = loadService.load(path);
		saveService.save(loaded);

	}

}
