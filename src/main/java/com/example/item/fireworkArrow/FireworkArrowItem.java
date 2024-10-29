package com.example.item.fireworkArrow;

import com.example.TutorialMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.*;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.nio.file.Path;
import java.util.List;

public class FireworkArrowItem extends Item {


    public FireworkArrowItem(Item.Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<net.minecraft.text.Text> tooltip, TooltipContext tooltipContext){
        super.appendTooltip(stack,world,tooltip,tooltipContext);
        tooltip.add(Text.translatable("item.tutorial-mod.firework_arrow.desc").formatted(Formatting.GRAY));
    }


    public static final Item FIREWORK_ARROW = itemRegistry("firework_item",new Item(new Item.Settings()));

    public static Item itemRegistry (String path, Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,path)
                ,item);
    }

    @Override
    public TypedActionResult<ItemStack> use(World world, PlayerEntity user,Hand hand){


        if(user == null){
            return TypedActionResult.fail(user.getStackInHand(hand));
        }
        ArrowEntity arrowEntity = new ArrowEntity(world,user);
        arrowEntity.setVelocity((Entity) user
                ,user.getPitch()
                ,user.getYaw()
                , 3f,30,1);
        world.spawnEntity(arrowEntity);
        ItemStack stack = user.getStackInHand(hand);
        stack.decrement(1);
        return TypedActionResult.success(user.getStackInHand(hand));
    }
//上面是箭矢的方法实现，通过对use方法复写实现




    public static void initRegistry(){
        TutorialMod.LOGGER.debug("ModItem is Running");
    }
}
