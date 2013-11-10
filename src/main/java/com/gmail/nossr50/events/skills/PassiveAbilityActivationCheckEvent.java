package com.gmail.nossr50.events.skills;

import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;
import org.bukkit.event.player.PlayerEvent;

import com.gmail.nossr50.datatypes.skills.PassiveAbility;

public class PassiveAbilityActivationCheckEvent extends PlayerEvent implements Cancellable {

    private boolean cancelled;
    private double chance;
    private PassiveAbility ability;
    private boolean autoSuccess;

    public PassiveAbilityActivationCheckEvent(Player player, PassiveAbility ability, double chance) {
        super(player);
        this.ability = ability;
        this.chance = chance;
        this.cancelled = false;
        this.autoSuccess = false;
    }

    public PassiveAbility getPassiveAbility() {
        return ability;
    }

    public double getChance() {
        return chance;
    }

    public void setChance(double chance) {
        this.chance = Math.min(100, chance);
    }

    public boolean isAutomaticSuccess() {
        return autoSuccess;
    }

    public void setAutomaticSuccess(boolean autoSuccess) {
        this.autoSuccess = autoSuccess;
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }

    /** Rest of file is required boilerplate for custom events **/
    private static final HandlerList handlers = new HandlerList();

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public static HandlerList getHandlerList() {
        return handlers;
    }
}
