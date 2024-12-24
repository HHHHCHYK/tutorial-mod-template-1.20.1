package com.example.registry;

import com.example.TutorialMod;
import com.example.statusEffect.Hydro;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class StatusEffectsRegistry {

    public static void initRegistry(){
        Registry.register(Registries.STATUS_EFFECT,new Identifier(TutorialMod.MOD_ID,"hydro"), Hydro.HYDRO);//注册状态——水附着


    }
}
