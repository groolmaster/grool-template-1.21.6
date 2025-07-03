package grool.example;

import grool.example.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class GroolBlockLootTableProvider extends FabricBlockLootTableProvider {
    protected GroolBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {

        addDrop(ModBlocks.CONDENSED_DIRT);
        addDrop(ModBlocks.WOOD_SLAB);
        addDrop(ModBlocks.SMOOTH_STONE_ALT);
    }
}
