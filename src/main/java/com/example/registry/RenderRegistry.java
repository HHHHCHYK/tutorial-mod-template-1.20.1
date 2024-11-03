package com.example.registry;

import com.example.TutorialMod;
import com.example.entity.FireworkArrowEntity;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.ArrowEntityRenderer;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.util.Identifier;

public class RenderRegistry {

    public static void initRenderRegistry(){
        EntityRendererRegistry.register(EntityRegistry.FIREWORK_ARROW_ENTITY,
                (content)->new ProjectileEntityRenderer<FireworkArrowEntity>(content) {
                    @Override
                    public Identifier getTexture(FireworkArrowEntity fireworkArrowEntity) {
                        return new Identifier("textures/entity/projectiles/arrow.png");
                    }

                    @Override
                    public void render(FireworkArrowEntity entityType, float yaw, float tickDelta, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider,int light){
                        super.render(entityType,yaw,tickDelta,matrixStack,vertexConsumerProvider,light);
                    }
                });
    }
}
