package com.example.registry;

import com.example.TutorialMod;
import com.example.item.FireworkArrowItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegistry {

    public static final Item FIREWORK_ARROW = itemRegistry("firework_arrow",
            new FireworkArrowItem(new Item.Settings().maxCount(16)));


    public static Item itemRegistry (String path, Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,path)
                ,item);
    }

    public static void initItemRegistry(){
        TutorialMod.LOGGER.debug("Item was registered.");
    }
}
