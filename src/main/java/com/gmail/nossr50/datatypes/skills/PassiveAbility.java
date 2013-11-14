package com.gmail.nossr50.datatypes.skills;

import org.bukkit.entity.Player;

import com.gmail.nossr50.config.AdvancedConfig;
import com.gmail.nossr50.util.Permissions;

public enum PassiveAbility {
    /* ACROBATICS */
    DODGE,
    GRACEFUL_ROLL,
    ROLL,

    /* ARCHERY */
    RETRIEVE,
    DAZE,
    AXES_CRITICAL,
    IMPACT,
    GREATER_IMPACT,
    HERBALISM_DOUBLE_DROPS,
    GREEN_THUMB,
    SHROOM_THUMB,
    HYLIAN_LUCK,
    GREEN_THUMB_BLOCK,
    MINING_DOUBLE_DROPS,
    SUPER_REPAIR,
    SECOND_SMELT,
    BLEED,
    COUNTER,
    FAST_FOOD,
    GORE,
    WOODCUTTING_DOUBLE_DROPS,
    TREASURE_DROP,
    SHAKE,
    FLUX_MINING,
    IRON_GRIP,
    DEFLECT,
    DISARM,
    ;

    public double getMaxChance() {
        return AdvancedConfig.getInstance().getMaxChance(this);
    }

    public int getMaxLevel() {
        return AdvancedConfig.getInstance().getMaxBonusLevel(this);
    }

    public boolean hasPermission(Player player) {
        return Permissions.passiveAbilityEnabled(player, this);
    }
}
