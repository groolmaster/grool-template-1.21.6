package grool.example;

import java.util.concurrent.CompletableFuture;

import grool.example.block.ModBlocks;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

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

                // ----------------------------------  EXAMPLE RECIPES  ----------------------------------
                // SHAPELESS RECIPE FOR DIRT from COARSE_DIRT
                createShapeless(RecipeCategory.BUILDING_BLOCKS, Items.DIRT) // You can also specify an int to produce more than one
                        .input(Items.COARSE_DIRT) // You can also specify an int to require more than one, or a tag to accept multiple things
                        // Create an advancement that gives you the recipe
                        .criterion(hasItem(Items.COARSE_DIRT), conditionsFromItem(Items.COARSE_DIRT))
                        .offerTo(exporter);

                // SHAPED RECIPE FOR SMOOTH_STONE2
                createShaped( RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_SMOOTH2, 4) // creates
                        .pattern("bb") // row 1, in crafting menu
                        .pattern("bb") // row 2, in crafting menu
                        .input('b', Items.STONE_BRICKS) // 'b' means "stone bricks" in the pattern, you can use ItemTags.x to represent existing groups of items
                        .group("multi_bench") // Put it in a group called "multi_bench" - groups are shown in one slot in the recipe book
                        .criterion(hasItem(Items.CRAFTING_TABLE), conditionsFromItem(Items.CRAFTING_TABLE))
                        .offerTo(exporter);

                // ----------------------------------  STONECUTTER RECIPES  ----------------------------------
                // Minecraft.Items.STONE BRICKS FROM ModBlocks.SMOOTH STONE
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,
                        Items.STONE_BRICKS, //output
                        ModBlocks.STONE_SMOOTH2, //input
                        1 // output count?
                );

                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.STONE_BRICKS_SMALL, //output
                        ModBlocks.STONE_SMOOTH2, //input
                        1 // output count?
                );

                // Other way around
                offerStonecuttingRecipe(RecipeCategory.BUILDING_BLOCKS,
                        ModBlocks.STONE_SMOOTH2, //output
                        Items.STONE_BRICKS, //input
                        1 // output count?
                );
            }
        };
    }

    @Override
    public String getName() {
        return "GroolRecipeProvider";
    }
}