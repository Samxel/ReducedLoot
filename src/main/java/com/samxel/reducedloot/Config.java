package com.samxel.reducedloot;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import static com.samxel.reducedloot.ReducedLoot.MODID;

@EventBusSubscriber(modid = MODID)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.DoubleValue CHANCE =
            BUILDER
                    .comment(
                            " Chance that an item remains in the loot (0.0 = never, 1.0 = always)")
                    .defineInRange("lootChance", 0.7, 0.0, 1.0);

    public static final ModConfigSpec SPEC = BUILDER.build();

    public static double chance;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        chance = CHANCE.get();
    }
}