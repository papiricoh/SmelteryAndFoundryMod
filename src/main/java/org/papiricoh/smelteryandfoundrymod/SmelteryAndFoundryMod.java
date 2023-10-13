package org.papiricoh.smelteryandfoundrymod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.papiricoh.smelteryandfoundrymod.blocks.MarbleBlock;

public class SmelteryAndFoundryMod implements ModInitializer {
    /**
     * Runs the mod initializer.
     */
    public static final Block MARBLE_BLOCK = new MarbleBlock(FabricBlockSettings.create().strength(4.0f));
    @Override
    public void onInitialize() {
        Registry.register(Registries.BLOCK, new Identifier("saf", "marble_block"), MARBLE_BLOCK);
        Registry.register(Registries.ITEM, new Identifier("saf", "marble_block"), new BlockItem(MARBLE_BLOCK, new Item.Settings()));
    }
}
