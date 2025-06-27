package grool.example.item;

import grool.example.Grool;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    // Make item group for mod items.
    public static final RegistryKey<ItemGroup> SIMPLE_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Grool.MOD_ID, "item_group")); // Register simple item group key
    public static final ItemGroup SIMPLE_ITEM_GROUP = FabricItemGroup.builder()   // Create a new item group, this is the groups name internally within the mod
            .icon(() -> new ItemStack(ModItems.CUSTOM_ITEM))
            .displayName(Text.translatable("Grool.item_group.custom_items"))  // Display name for the item group, in game
            .build();


    // Make item group for modBlock items.
    public static final RegistryKey<ItemGroup> BLOCK_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), Identifier.of(Grool.MOD_ID, "block_group")); // Register simple item group key
    public static final ItemGroup BLOCK_ITEM_GROUP = FabricItemGroup.builder()   // Create a new item group, this is the groups name internally within the mod
            .icon(() -> new ItemStack(ModItems.CUSTOM_ITEM))
            .displayName(Text.translatable("Grool.block_group.custom_items"))  // Display name for the item group, in game
            .build();



}
