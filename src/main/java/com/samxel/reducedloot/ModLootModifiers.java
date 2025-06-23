package com.samxel.reducedloot;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Reducedloot.MODID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> CHANCE_LOOT_MODIFIER =
            LOOT_MODIFIER_SERIALIZERS.register("chance_loot_modifier", () -> ChanceLootModifier.CODEC);
}