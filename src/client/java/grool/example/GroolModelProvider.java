package grool.example;

import grool.example.block.ModBlocks;
import grool.example.item.ModItems;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;
import net.minecraft.client.data.Models;

public class GroolModelProvider extends FabricModelProvider {
    public GroolModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STONE_SMOOTH2);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STONE_BRICKS_SMALL);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STONE_BRICKS_SMALL_MOSSY);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        // Register item models for blocks
        itemModelGenerator.register(ModItems.COIN, Models.GENERATED);
    }

    @Override
    public String getName() {
        return "Grool Model Provider";
    }
}
