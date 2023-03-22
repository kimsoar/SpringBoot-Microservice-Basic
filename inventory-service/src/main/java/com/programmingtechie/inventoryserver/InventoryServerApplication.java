package com.programmingtechie.inventoryserver;

import com.programmingtechie.inventoryserver.model.Inventory;
import com.programmingtechie.inventoryserver.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServerApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryRepository inventoryRepository) {
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
				Inventory inventory = new Inventory();
				inventory.setSkuCode("iphone_13");
				inventory.setQuantity(100);

				Inventory inventory1 = new Inventory();
				inventory1.setSkuCode("iphone_13_red");
				inventory1.setQuantity(0);

				inventoryRepository.save(inventory);
				inventoryRepository.save(inventory1);
			}
		};
	}
}
