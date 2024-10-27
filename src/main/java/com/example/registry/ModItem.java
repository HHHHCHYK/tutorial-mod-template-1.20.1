package com.example.registry;

import com.example.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItem {
    public static Item itemRegistry (String name,Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,name)
                ,item);
    }

    public static final Item FIREWORK_ARROW = itemRegistry("firework_arrow",new Item(new Item.Settings()));

    public static void initRegistry(){
        TutorialMod.LOGGER.debug("ModItem is Running");
    }
}
