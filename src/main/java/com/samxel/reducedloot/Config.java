package com.samxel.reducedloot;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = Reducedloot.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.DoubleValue CHANCE = BUILDER
            .comment("Chance that an item remains in the loot (0.0 = never, 1.0 = always)")
            .defineInRange("lootChance", 0.7, 0.0, 1.0);

    public static final ForgeConfigSpec SPEC = BUILDER.build();

    public static double chance;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        chance = CHANCE.get();
    }
}