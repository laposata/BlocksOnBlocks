package com.dreamtea.wild_blocks.registry;

import com.dreamtea.wild_blocks.blocks.*;
import com.dreamtea.wild_blocks.utils.AltModelGen.BlockPropertyForAlts;
import net.minecraft.block.*;
import net.minecraft.data.client.TexturedModel;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;

import static com.dreamtea.wild_blocks.WildBlocks.NAMESPACE;

public class Register {

    public static void register(Identifier id, Block block) {
        Registry.register(Registry.BLOCK, id, block);
        register(new BlockItem(block, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
    }

    private static void register(BlockItem item) {
        item.appendBlocks(Item.BLOCK_ITEMS, item);
        Registry.register(Registry.ITEM, Registry.BLOCK.getId(item.getBlock()), item);
    }

    public static Identifier getName(BlockAlts blocks, BlockAlts.BlockType type) {
        List<String> parts = new ArrayList<>();
        Identifier baseId = Registry.BLOCK.getId(blocks.base());
        parts.add(baseId.getPath());
        if(blocks.fallen()){
            parts.add("fallen");
        }
        parts.add(type.lowerCaseName);
        return new Identifier(NAMESPACE, String.join("_", parts));
    }

    public static void register(List<BlockAlts> blocks){
        blocks.forEach(Register::register);
    }

    public static void register(BlockAlts blocks){
        blocks.doOnEach(((block, type) -> Register.register(Register.getName(blocks, type), block)));
    }

}
