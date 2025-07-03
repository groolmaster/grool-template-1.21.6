package grool.example;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class GroolDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {

		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

		// Add DataGen Providers
		pack.addProvider(GroolAdvancementProvider::new);
		pack.addProvider(GroolRecipeProvider::new);

		pack.addProvider(GroolItemTagProvider::new);

		pack.addProvider(GroolEnglishLangProvider::new);


	}
}
