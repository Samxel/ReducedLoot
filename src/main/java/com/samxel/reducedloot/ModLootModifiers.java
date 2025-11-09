package com.samxel.reducedloot;

import com.mojang.serialization.MapCodec;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>>
            LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(
                    NeoForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, ReducedLoot.MODID);

    public static final DeferredHolder<
            MapCodec<? extends IGlobalLootModifier>, MapCodec<? extends IGlobalLootModifier>>
            CHANCE_LOOT_MODIFIER =
            LOOT_MODIFIER_SERIALIZERS.register(
                    "chance_loot_modifier", () -> ChanceLootModifier.CODEC);
}