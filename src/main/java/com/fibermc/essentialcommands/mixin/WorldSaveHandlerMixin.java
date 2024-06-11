package com.fibermc.essentialcommands.mixin;

import java.util.Objects;

import com.fibermc.essentialcommands.access.ServerPlayerEntityAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.PlayerSaveHandler;

@Mixin(PlayerSaveHandler.class)
public class WorldSaveHandlerMixin {

    @Inject(method = "savePlayerData", at = @At("RETURN"))
    public void onSavePlayerData(PlayerEntity player, CallbackInfo ci) {
        ((ServerPlayerEntityAccess) player).ec$getPlayerData().save(Objects.requireNonNull(player.getServer()).getRegistryManager());
//        System.out.printf("Saved PlayerData for player: %s\n", player.getName().getString());
    }

}
