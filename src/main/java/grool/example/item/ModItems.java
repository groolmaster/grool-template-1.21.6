package grool.example.item;

import grool.example.Grool;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;


import java.util.function.Function;

// THESE ARE THE IMPORTS FOR THE ITEM GROUP NAMES AND KEYS
import static grool.example.item.ModItemGroups.SIMPLE_ITEM_GROUP;
import static grool.example.item.ModItemGroups.SIMPLE_GROUP_KEY;

public class ModItems {

    // Example custom item registration. You can add more items by following this pattern.
    public static final Item CUSTOM_ITEM = register("custom_item", Item::new, new Item.Settings().maxCount(64));
    public static final Item ANOTHER_ITEM = register("another_item", Item::new, new Item.Settings().maxCount(64));
    public static final Item COIN = register("coin", Item::new, new Item.Settings().maxCount(64));


    // Send in the item name, a function to create the item, and the settings for the item. Registers the item with the given name.
    public static Item register(String name, Function<Item.Settings, Item> itemFactory, Item.Settings settings) {
        // Create the item key. This is used to uniquely identify the item in the registry.
        RegistryKey<Item> itemKey = RegistryKey.of(RegistryKeys.ITEM, Identifier.of(Grool.MOD_ID, name));

        // Create the item instance.
        Item item = itemFactory.apply(settings.registryKey(itemKey));

        // Register the item.
        Registry.register(Registries.ITEM, itemKey, item);

        return item;
    }



    public static void initialize() {
        // This method can be used to perform any initialization logic if needed.
        // For example, you could log the items that have been registered.
        Grool.LOGGER.info("ModItems initialized with {} items.", Registries.ITEM.size());

        // Register the custom item group for the mod items in this class
        Registry.register(Registries.ITEM_GROUP, SIMPLE_GROUP_KEY, SIMPLE_ITEM_GROUP);

        // Register items to the custom item group as denoted by its registry key.
        ItemGroupEvents.modifyEntriesEvent(SIMPLE_GROUP_KEY).register(itemGroup -> {
            itemGroup.add(ModItems.CUSTOM_ITEM);
            itemGroup.add(ModItems.ANOTHER_ITEM);
            itemGroup.add(ModItems.COIN);

        });
    }
}
