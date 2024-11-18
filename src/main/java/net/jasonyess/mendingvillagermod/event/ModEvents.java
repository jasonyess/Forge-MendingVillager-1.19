package net.jasonyess.mendingvillagermod.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.jasonyess.mendingvillagermod.MendingVillagerMod;
import net.jasonyess.mendingvillagermod.villager.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = MendingVillagerMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if (event.getType() == ModVillagers.MENDER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack mendingBook = new ItemStack(Items.ENCHANTED_BOOK);
            mendingBook.enchant(Enchantments.MENDING, 1);

            trades.get(1).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(Items.EMERALD, 32),
                    mendingBook, 1, 1, 0.01f));
        }
    }

}
