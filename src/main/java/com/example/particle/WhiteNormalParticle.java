package com.example.particle;

import com.example.TutorialMod;
import net.minecraft.client.particle.AnimatedParticle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.particle.SpriteProvider;
import net.minecraft.client.render.*;
import net.minecraft.client.world.ClientWorld;

public class WhiteNormalParticle extends AnimatedParticle {
    private static final float LIFETIME = 40.0F;
    private float alpha =1;

    public WhiteNormalParticle(ClientWorld world, double x, double y, double z, SpriteProvider spriteProvider, float upwardsAcceleration) {
        super(world, x, y, z, spriteProvider,upwardsAcceleration);
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
        float red = color / 255.0F;
        float green = color/ 255.0F;
        float blue = color/ 255.0F;

        vertexConsumer.vertex(x - scale, y, z)
                .texture(0,0)
                .color(red, green, blue, alpha)
                .light(1)
                .next();
        vertexConsumer.vertex(x + scale, y, z)
                .texture(1,0)
                .color(red, green, blue, alpha)
                .light(1)
                .next();
        vertexConsumer.vertex(x, y, z - scale)
                .texture(0,1)
                .color(red, green, blue, alpha)
                .light(1)
                .next();
        vertexConsumer.vertex(x, y, z + scale)
                .texture(0,1)
                .color(red, green, blue, alpha)
                .light(1)
                .next();

        TutorialMod.LOGGER.debug("buildG");
    }

    @Override
    public ParticleTextureSheet getType() {
        TutorialMod.LOGGER.debug("GetTypeRun");
        return ParticleTextureSheet.PARTICLE_SHEET_OPAQUE;
    }

    public static int getColor() {
        TutorialMod.LOGGER.debug("ColorRun");
        // 返回一个 RGBA 颜色值，255 代表不透明的白色
        return 255; // 代表白色
    }

    public float getAlpha() {
        return alpha;
    }
}
