package grool.example;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class GroolItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public GroolItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    public static final TagKey<Item> SMELLY_ITEMS = TagKey.of(RegistryKeys.ITEM, Identifier.of(Grool.MOD_ID, "smelly_items"));

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        //valueLookupBuilder replaces getOrCreateTagBuilder as of 06/15/25
        valueLookupBuilder(SMELLY_ITEMS)
                .add(Items.ROTTEN_FLESH);

    }
}
