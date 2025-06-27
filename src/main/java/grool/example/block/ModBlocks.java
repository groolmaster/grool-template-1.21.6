package grool.example.block;

import grool.example.Grool;
import grool.example.item.ModItemGroups;
import grool.example.item.ModItems;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static grool.example.item.ModItemGroups.*;

public class ModBlocks {

    // BLOCKS HERE
    public static final Block CONDENSED_DIRT = register(
            "condensed_dirt",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.DIRT),
            true
    );

    public static final Block WOOD_SLAB = register(
            "wood_slab",
            Block::new,
            AbstractBlock.Settings.copy(Blocks.ACACIA_WOOD),
            true
    );





    private static Block register(String name, Function<AbstractBlock.Settings, Block> blockFactory, AbstractBlock.Settings settings, boolean shouldRegisterItem) {
        // Create a registry key for the block
        RegistryKey<Block> blockKey = keyOfBlock(name);
        // Create the block instance
        Block block = blockFactory.apply(settings.registryKey(blockKey));

        // Sometimes, you may not want to register an item for the block.
        // Eg: if it's a technical block like `minecraft:moving_piston` or `minecraft:end_gateway`
        if (shouldRegisterItem) {
            // Items need to be registered with a different type of registry key, but the ID
            // can be the same.
            RegistryKey<Item> itemKey = keyOfItem(name);

            BlockItem blockItem = new BlockItem(block, new Item.Settings().registryKey(itemKey));
            Registry.register(Registries.ITEM, itemKey, blockItem);
        }

        return Registry.register(Registries.BLOCK, blockKey, block);
    }

    private static RegistryKey<Block> keyOfBlock(String name) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(Grool.MOD_ID, name));
    }

    private static RegistryKey<Item> keyOfItem(String name) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Grool.MOD_ID, name));
    }



    public static void initialize() {

        // Register the custom item group for the mod blocks in this class
        Registry.register(Registries.ITEM_GROUP, BLOCK_GROUP_KEY, BLOCK_ITEM_GROUP);

        // Register the blocks as items, while making them part of the block item group
        ItemGroupEvents.modifyEntriesEvent(BLOCK_GROUP_KEY).register((itemGroup) -> {
            itemGroup.add(ModBlocks.CONDENSED_DIRT.asItem());
            itemGroup.add(ModBlocks.WOOD_SLAB.asItem());
        });


    }

}