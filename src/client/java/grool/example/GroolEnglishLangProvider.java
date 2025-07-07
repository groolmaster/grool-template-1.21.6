package grool.example;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class GroolEnglishLangProvider extends FabricLanguageProvider {

    protected GroolEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    // Second is the menu / ingame text, first is the name of the thing
    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder translationBuilder) {
        // Add translations for blocks
        translationBuilder.add("item.grool.custom_item", "Custom Item");
        translationBuilder.add("item.grool.condensed_dirt", "Condensed Dirt Block");
        translationBuilder.add("item.grool.smooth_stone_alt", "Smooth Stone 2");

        // Add translations for items

        // Add translations for other elements and so on
        }
}
