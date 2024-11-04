package com.example.particle;

import com.example.TutorialMod;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;

public class WhiteNormalParticle extends Particle {
    private static final float LIFETIME = 40.0F;
    private float alpha =1;

    public WhiteNormalParticle(ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        super(world, x, y, z, velocityX, velocityY, velocityZ);
        this.maxAge = (int) LIFETIME;
    }

    @Override
    public void tick() {
        if (age++ >= maxAge) {
            this.markDead();
        } else {
            alpha = (LIFETIME - age) / LIFETIME;
            this.move(velocityX, velocityY, velocityZ);
            // 减少速度以模拟粒子减速
            velocityX *= 0.7F;
            velocityY *= 0.7F;
            velocityZ *= 0.7F;
        }
    }

    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        float scale = (float) age / LIFETIME;
        float x = (float) this.x;
        float y = (float) this.y;
        float z = (float) this.z;

        // 使用RGBA颜色
        int color = getColor();
        float red = (color >> 16 & 255) / 255.0F;
        float green = (color >> 8 & 255) / 255.0F;
        float blue = (color & 255) / 255.0F;

        try{
            vertexConsumer.vertex(x - scale, y, z).color(red, green, blue, alpha).texture(0,0).light(1)
                    .next();
            vertexConsumer.vertex(x + scale, y, z).color(red, green, blue, alpha).texture(1,0).light(1)
                    .next();
            vertexConsumer.vertex(x, y, z - scale).color(red, green, blue, alpha).texture(0,1).light(1)
                    .next();
            vertexConsumer.vertex(x, y, z + scale).color(red, green, blue, alpha).texture(1,1).light(1)
                    .next();
        }catch (Exception e){
            TutorialMod.LOGGER.debug("Error e");
        }

        TutorialMod.LOGGER.info("builder was built.");
    }

    @Override
    public ParticleTextureSheet getType() {
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public static int getColor() {
        // 返回一个 RGBA 颜色值，255 代表不透明的白色
        TutorialMod.LOGGER.info("PC is running");
        return 0xFFFFFFFF; // 代表白色
    }
}
