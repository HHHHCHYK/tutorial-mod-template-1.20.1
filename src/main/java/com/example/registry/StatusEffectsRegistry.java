package com.example.registry;

import com.example.TutorialMod;
import com.example.statusEffect.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StatusEffectsRegistry {

    public static void initRegistry(){
        Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,"hydro"), Hydro.HYDRO);//注册状态——水附着
        Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,"cryo"), Cryo.CRYO);//注册状态——冰附着
        Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,"pyro"), Pyro.PYRO);//注册状态——火附着
        Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,"electro"), Electro.ELECTRO);//注册状态——雷附着
        Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,"dendro"), Dendro.DENDRO);//注册状态——草附着
        Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,"frozen"),Frozen.FROZEN);//注册冻元素
    }
}
