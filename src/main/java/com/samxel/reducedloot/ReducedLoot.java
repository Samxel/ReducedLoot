package com.samxel.reducedloot;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;

@Mod(ReducedLoot.MODID)
public class ReducedLoot {
    public static final String MODID = "reducedloot";

    public ReducedLoot(IEventBus modEventBus, ModContainer modContainer) {
        ModLootModifiers.LOOT_MODIFIER_SERIALIZERS.register(modEventBus);
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }
}