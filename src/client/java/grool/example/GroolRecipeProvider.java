package grool.example;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;

public class GroolRecipeProvider extends FabricRecipeProvider {
    public GroolRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                RegistryWrapper.Impl<Item> itemLookup = registries.getOrThrow(RegistryKeys.ITEM);

                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT) // You can also specify an int to produce more than one
                        .input(Items.COARSE_DIRT) // You can also specify an int to require more than one, or a tag to accept multiple things
                        // Create an advancement that gives you the recipe
                        .criterion(hasItem(Items.COARSE_DIRT), conditionsFromItem(Items.COARSE_DIRT))
                        .offerTo(exporter);

            }
        };
    }

    @Override
    public String getName() {
        return "GroolRecipeProvider";
    }
}