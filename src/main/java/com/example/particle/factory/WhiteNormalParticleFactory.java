package com.example.particle.factory;

import com.example.TutorialMod;
import com.example.particle.WhiteNormalParticle;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import org.jetbrains.annotations.Nullable;


public class WhiteNormalParticleFactory implements ParticleFactory<DefaultParticleType> {
    private final SpriteProvider spriteProvider;

    public WhiteNormalParticleFactory(SpriteProvider spriteProvider) {
        this.spriteProvider = spriteProvider;
    }


    public SpriteProvider getSpriteProvider() {
        return this.spriteProvider;
    }



    @Override
    public @Nullable Particle createParticle(DefaultParticleType parameters, ClientWorld world, double x, double y, double z, double velocityX, double velocityY, double velocityZ) {
        return new WhiteNormalParticle(world, x, y, z, spriteProvider,0);
    }
}
//WhiteNormalParticle(world, x, y, z, velocityX, velocityY, velocityZ)

