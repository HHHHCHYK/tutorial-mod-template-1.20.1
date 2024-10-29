package com.example.registry;

import com.example.TutorialMod;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ItemRegister {
    public static Item itemRegistry (String path, Item item){
        return Registry.register(Registries.ITEM,new Identifier(TutorialMod.MOD_ID,path)
                ,item);
    }
}
