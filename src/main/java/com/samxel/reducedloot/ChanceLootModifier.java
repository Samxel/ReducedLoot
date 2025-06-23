package com.samxel.reducedloot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

public class ChanceLootModifier extends LootModifier {
    public static final Codec<ChanceLootModifier> CODEC = RecordCodecBuilder.create(inst ->
            LootModifier.codecStart(inst)
                    .apply(inst, ChanceLootModifier::new)
    );
    public ChanceLootModifier(LootItemCondition[] conditions) {
        super(conditions);
    }

    @NotNull
    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        ObjectArrayList<ItemStack> filtered = new ObjectArrayList<>();
        double chance = Config.chance;
        var rand = context.getRandom();
        for (ItemStack stack : generatedLoot) {
            if (rand.nextDouble() < chance) {
                filtered.add(stack);
            }
        }
        return filtered;
    }

    @Override
    public Codec<? extends LootModifier> codec() {
        return CODEC;
    }
}