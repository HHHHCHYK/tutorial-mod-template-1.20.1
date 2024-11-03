package com.example.particle;

import net.minecraft.client.particle.Particle;
import net.minecraft.client.particle.ParticleTextureSheet;
import net.minecraft.client.render.*;
import net.minecraft.client.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.Identifier;

public class WhitNormalParticle extends Particle {
    private static final float lifetime = 40.0F;
    float x,y,z;
    float maxAge = lifetime;
    float age = 0F;
    float alpha;

    protected WhitNormalParticle(ClientWorld world, double x, double y, double z) {
        super(world, x, y, z);
        this.x = (float) x;
        this.y = (float) y;
        this.z = (float) z;
    }




    @Override
    public void tick(){
        if(age++>=maxAge){
            this.markDead();
        }
        else {
            alpha = (lifetime - age)/lifetime;
            this.move(velocityX,velocityY,velocityZ);
            velocityX *=0.7F;
            velocityY *=0.7F;
            velocityZ *=0.7F;
        }
    }




    @Override
    public void buildGeometry(VertexConsumer vertexConsumer, Camera camera, float tickDelta) {
        float scale =age/lifetime;
        float x = (float) this.x;
        float y = (float) this.y;
        float z = (float) this.z;

        int color = getColor();
        float alpha = this.alpha;

        vertexConsumer.vertex(x-scale,y,z).color(color,color,color,alpha).next();
        vertexConsumer.vertex(x+scale,y,z).color(color,color,color,alpha).next();
        vertexConsumer.vertex(x,y,z-scale).color(color,color,color,alpha).next();
        vertexConsumer.vertex(x,y,z+scale).color(color,color,color,alpha).next();
    }

    @Override
    public ParticleTextureSheet getType() {
        return new ParticleTextureSheet() {
            @Override
            public void begin(BufferBuilder builder, TextureManager textureManager) {
                textureManager.bindTexture(new Identifier("minecraft","texture/particle/critical_hit.png"));

                builder.begin(VertexFormat.DrawMode.QUADS,VertexFormats.POSITION_COLOR_TEXTURE);
            }

            @Override
            public void draw(Tessellator tessellator) {
                BufferBuilder bufferBuilder = tessellator.getBuffer();
                bufferBuilder.begin(VertexFormat.DrawMode.QUADS,VertexFormats.POSITION_COLOR_TEXTURE);

                float scale =age/lifetime;
                int color = getColor();

                bufferBuilder.vertex(x-scale,y,z).color(color,color,color,alpha).next();
                bufferBuilder.vertex(x+scale,y,z).color(color,color,color,alpha).next();
                bufferBuilder.vertex(x,y,z-scale).color(color,color,color,alpha).next();
                bufferBuilder.vertex(x,y,z+scale).color(color,color,color,alpha).next();
            }
        };
    }

    public static int getColor(){
        return 255;
    }
}
