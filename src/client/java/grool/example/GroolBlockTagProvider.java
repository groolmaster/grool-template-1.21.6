package grool.example;

import grool.example.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class GroolBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public GroolBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Item> SMELLY_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Grool.MOD_ID, "smelly_items"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //valueLookupBuilder replaces getOrCreateTagBuilder as of 06/15/25

        // ----------------------------------  TOOL MINING DEFINITIONS  ----------------------------------
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.STONE_SMOOTH2)
                .add(ModBlocks.CONDENSED_DIRT)
                ;

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.WOOD_SLAB)
                ;

        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.CONDENSED_DIRT)
        ;


        valueLookupBuilder(BlockTags.NEEDS_DIAMOND_TOOL);
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL);
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL);
    }
}

