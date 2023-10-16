package org.papiricoh.smelteryandfoundrymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.papiricoh.smelteryandfoundrymod.blocks.MarbleBlock;

public class SmelteryAndFoundryMod implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    public static final Block MARBLE_BLOCK = new MarbleBlock(FabricBlockSettings.create().strength(4.0f));
    public static final Block POLISHED_MARBLE_BLOCK = new MarbleBlock(FabricBlockSettings.create().strength(4.0f));
    public static final Block MARBLE_BRICKS_BLOCK = new MarbleBlock(FabricBlockSettings.create().strength(4.0f));

    public static final RegistryKey<PlacedFeature> MARBLE_ORE = RegistryKey.of(RegistryKeys.PLACED_FEATURE, new Identifier("saf","marble_ore"));


    private static final ItemGroup ITEM_GROUP_BLOCKS = FabricItemGroup.builder()
            .icon(() -> new ItemStack(MARBLE_BLOCK))
            .displayName(Text.translatable("itemGroup.saf.saf_blocks"))
            .entries((context, entries) -> {
                entries.add(MARBLE_BLOCK);
                entries.add(POLISHED_MARBLE_BLOCK);
                entries.add(MARBLE_BRICKS_BLOCK);
            })
            .build();

    @Override
    public void onInitialize() {
        Registry.register(Registries.ITEM_GROUP, new Identifier("saf", "saf_blocks"), ITEM_GROUP_BLOCKS);
        Registry.register(Registries.BLOCK, new Identifier("saf", "marble_block"), MARBLE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("saf", "marble_block"), new BlockItem(MARBLE_BLOCK, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("saf", "polished_marble_block"), POLISHED_MARBLE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("saf", "polished_marble_block"), new BlockItem(POLISHED_MARBLE_BLOCK, new Item.Settings()));
        Registry.register(Registries.BLOCK, new Identifier("saf", "marble_bricks_block"), MARBLE_BRICKS_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("saf", "marble_bricks_block"), new BlockItem(MARBLE_BRICKS_BLOCK, new Item.Settings()));

        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, MARBLE_ORE);
    }


}
