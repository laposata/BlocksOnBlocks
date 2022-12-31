package com.dreamtea.wild_blocks.datagen;

import com.dreamtea.wild_blocks.registry.BlockAlts;
import com.dreamtea.wild_blocks.registry.AltList;
import com.dreamtea.wild_blocks.utils.OnAlts;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.block.Block;

import java.util.function.Consumer;

public class Language extends FabricLanguageProvider {
    protected Language(FabricDataGenerator dataOutput) {
        super(dataOutput, "en_us");
    }

    @Override
    public void generateTranslations(TranslationBuilder translationBuilder) {
        AltList.SIMPLE_ALTS.forEach(alts -> register(alts, translationBuilder));
    }

    private void register(BlockAlts blocks, TranslationBuilder builder){
        blocks.doOnEach((block, type) -> {
            builder.add(block, makeName(blocks.baseNameInWords(), type.name));
        });
    }

    private String makeName(String base, String blockType){
        return base + " " + blockType;
    }
}
