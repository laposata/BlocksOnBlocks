package com.dreamtea.wild_blocks.datagen;

import com.dreamtea.wild_blocks.WildBlocks;
import com.dreamtea.wild_blocks.blocks.*;
import com.dreamtea.wild_blocks.mixins.BlockStateModelGeneratorInvoker;
import com.dreamtea.wild_blocks.registry.BlockAlts;
import com.dreamtea.wild_blocks.registry.AltList;
import com.dreamtea.wild_blocks.utils.AltModelGen;
import com.dreamtea.wild_blocks.utils.BaseModels;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.TexturedModel;

public class Models extends FabricModelProvider {
    public Models(FabricDataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        AltList.SIMPLE_ALTS.forEach(alts ->
               register(alts, blockStateModelGenerator)
        );
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }

    public static void register(BlockAlts blocks, BlockStateModelGenerator bsmg){
        TexturedModel texturedModel = ((BlockStateModelGeneratorInvoker)bsmg)
                .sandstoneModels()
                .getOrDefault(blocks.base(), blocks.modelType().get(blocks.base()));
        try{
            if(blocks.wallBlock() != null){
                if(blocks.wallBlock() instanceof FacingWall){
                    bsmg.blockStateCollector.accept(AltModelGen.wall(
                            blocks.wallBlock(),
                            texturedModel.getTextures(),
                            bsmg,
                            BaseModels.ROTATION_PROPERTY,
                            BaseModels.rotation()
                    ));
                } else {
                    bsmg.blockStateCollector.accept(AltModelGen.wall(
                            blocks.wallBlock(),
                            texturedModel.getTextures(),
                            bsmg)
                    );
                }
            }
        } catch(Exception e){
            WildBlocks.LOGGER.error("failed to generate wall for "+ blocks.blockName(), e);
        }
        try{
            if(blocks.slabBlock() != null){
                if(blocks.slabBlock() instanceof FacingSlab){
                    AltModelGen.combineAndUploadVariantMaps(
                            bsmg,
                            blocks.slabBlock(),
                            AltModelGen.slab(blocks.slabBlock(), texturedModel.getTextures(), bsmg, blocks.base(), blocks.fallen()),
                            AltModelGen.rotation()
                    );
                } else if(blocks.slabBlock() instanceof DirectionalSlab){
                    AltModelGen.combineAndUploadVariantMaps(
                            bsmg,
                            blocks.slabBlock(),
                            AltModelGen.slab(blocks.slabBlock(), texturedModel.getTextures(), bsmg, blocks.base(), false),
                            AltModelGen.directional());
                } else {
                    AltModelGen.combineAndUploadVariantMaps(
                            bsmg,
                            blocks.slabBlock(),
                            AltModelGen.slab(blocks.slabBlock(), texturedModel.getTextures(), bsmg, blocks.base(), false)
                    );
                }
            }
        } catch(Exception e){
            WildBlocks.LOGGER.error("failed to generate slab for "+ blocks.blockName(), e);
        }
        try{
            if(blocks.stairBlock() != null){
                if(blocks.stairBlock() instanceof FacingStair){
                    bsmg.blockStateCollector.accept(AltModelGen.stairs(
                            blocks.stairBlock(),
                            texturedModel.getTextures(),
                            bsmg,
                            BaseModels.ROTATION_PROPERTY,
                            BaseModels.rotation()
                    ));
                } else if(blocks.stairBlock() instanceof DirectionalStair){
                    bsmg.blockStateCollector.accept(AltModelGen.stairs(
                            blocks.stairBlock(),
                            texturedModel.getTextures(),
                            bsmg,
                            BaseModels.DIRECTION_PROPERTY,
                            BaseModels.direction()
                    ));
                } else {
                    bsmg.blockStateCollector.accept(AltModelGen.stairs(
                            blocks.stairBlock(),
                            texturedModel.getTextures(),
                            bsmg
                    ));
                }
            }
        } catch(Exception e){
            WildBlocks.LOGGER.error("failed to generate stair for "+ blocks.blockName(), e);
        }
    }
}
