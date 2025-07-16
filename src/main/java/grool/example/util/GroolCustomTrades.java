package grool.example.util;

import grool.example.item.ModItems;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradedItem;
import net.minecraft.village.VillagerProfession;

public class GroolCustomTrades {
    public static void registerCustomTrades() {
        // Custom trades can be registered here
        // Example: VillagerTrades.registerVillagerTrades();
        // This method can be used to add custom trades for villagers or other entities
        TradeOfferHelper.registerVillagerOffers(VillagerProfession.FARMER, 1,
                factories -> {
                    factories.add((entity, random) -> {
                        // Example trade: 1 Emerald for 4 Bread
                        return new TradeOffer(
                                new TradedItem(ModItems.COIN, 1),
                                new ItemStack(Items.BREAD, 4),
                                10, 5, 0.05F); // there are other options that can be set here but we are keeping it simple for a basic example
                    });
                });
    }

}
