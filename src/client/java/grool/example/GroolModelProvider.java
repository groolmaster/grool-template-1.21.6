package grool.example;

import grool.example.block.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class GroolModelProvider extends FabricModelProvider {
    public GroolModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CONDENSED_DIRT);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.STONE_SMOOTH2);
    }


    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
    }

    @Override
    public String getName() {
        return "Grool Model Provider";
    }
}
