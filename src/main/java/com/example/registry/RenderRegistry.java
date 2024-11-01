package com.example.registry;

import com.example.TutorialMod;
import com.example.entity.FireworkArrowEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

public class RenderRegistry {

    public static void initRenderRegistry(){
        EntityRendererRegistry.register(EntityRegistry.FIREWORK_ARROW_ENTITY,
                (content)->new ProjectileEntityRenderer<FireworkArrowEntity>(content) {
                    @Override
                    public Identifier getTexture(FireworkArrowEntity entity) {
                        return new Identifier("minecraft","texture/entity/arrow");
                    }
                });
    }
}
