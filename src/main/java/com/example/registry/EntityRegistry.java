package com.example.registry;

import com.example.TutorialMod;
import com.example.entity.FireworkArrowEntity;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class EntityRegistry {
    public static final EntityType<FireworkArrowEntity> FIREWORK_ARROW_ENTITY = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(TutorialMod.MOD_ID,"firework_arrow_entity"),
            FabricEntityTypeBuilder.<FireworkArrowEntity>create(SpawnGroup.MISC,FireworkArrowEntity::new)
                    .dimensions(EntityDimensions.fixed(0.2F,0.2F)).build());
    //注册箭矢实体




    public static void initEntityRegistry(){
        TutorialMod.LOGGER.debug("Entity was registered");
    }
}
