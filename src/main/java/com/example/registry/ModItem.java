package com.example.registry;

import com.example.TutorialMod;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class ModItem extends Item {

    public ModItem(Item.Settings settings) {
        super(settings);
    }
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<net.minecraft.text.Text> tooltip, TooltipContext tooltipContext){
        super.appendTooltip(stack,world,tooltip,tooltipContext);
        tooltip.add(Text.translatable("item.tutorial-mod.firework_arrow.desc").formatted(Formatting.GRAY));
    }

    public static Item itemRegistry (String name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name)
                ,item);
    }

    public static final Item FIREWORK_ARROW = itemRegistry("firework_arrow",new Item(new Item.Settings()));

    public static void initRegistry(){
        TutorialMod.LOGGER.debug("ModItem is Running");
    }
}
