package com.example.item;

import com.example.TutorialMod;
import com.example.entity.FireworkArrowEntity;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FireworkArrowItem extends ArrowItem {



    public FireworkArrowItem(Item.Settings settings) {
        super(settings);
    }


    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<net.minecraft.text.Text> tooltip, TooltipContext tooltipContext){
        super.appendTooltip(stack,world,tooltip,tooltipContext);
        tooltip.add(Text.translatable("item.tutorial-mod.firework_arrow.desc").formatted(Formatting.WHITE));
    }

    public PersistentProjectileEntity createArrow(World world, ItemStack stack, LivingEntity shooter) {
        return new FireworkArrowEntity(world,shooter);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user,Hand hand){


        if(user == null){
            return TypedActionResult.pass(user.getStackInHand(hand));
        }
        FireworkArrowEntity fireworkArrowEntity = new FireworkArrowEntity(world,user);
        fireworkArrowEntity.setVelocity(user
                ,user.getPitch()
                ,user.getYaw()
                , 1f,5,1);
        world.spawnEntity(fireworkArrowEntity);
        ItemStack stack = user.getStackInHand(hand);
        stack.decrement(1);
        TutorialMod.LOGGER.info("Method use is running");
        user.getStackInHand(hand).decrement(1);
        return TypedActionResult.success(user.getStackInHand(hand));
    }


//上面是箭矢的方法实现，通过对use方法复写实现



}
