package com.gmail.nossr50.commands.skills;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.gmail.nossr50.datatypes.skills.SkillType;
import com.gmail.nossr50.locale.LocaleLoader;
import com.gmail.nossr50.skills.axes.Axes;
import com.gmail.nossr50.util.Permissions;

public class AxesCommand extends SkillCommand {
    private String critChance;
    private String critChanceLucky;
    private double bonusDamage;
    private double impactDamage;
    private String skullSplitterLength;
    private String skullSplitterLengthEndurance;

    private boolean canSkullSplitter;
    private boolean canCritical;
    private boolean canBonusDamage;
    private boolean canImpact;
    private boolean canGreaterImpact;

    public AxesCommand() {
        super(SkillType.AXES);
    }

    @Override
    protected void dataCalculations(Player player, float skillValue, boolean isLucky) {
        // IMPACT
        if (canImpact) {
            impactDamage = 1 + (skillValue / Axes.impactIncreaseLevel);
        }

        // SKULL SPLITTER
        if (canSkullSplitter) {
            String[] skullSplitterStrings = calculateLengthDisplayValues(player, skillValue);
            skullSplitterLength = skullSplitterStrings[0];
            skullSplitterLengthEndurance = skullSplitterStrings[1];
        }

        // CRITICAL STRIKES
        if (canCritical) {
            String[] criticalStrikeStrings = calculateAbilityDisplayValues(skillValue, Axes.criticalHitMaxBonusLevel, Axes.criticalHitMaxChance, isLucky);
            critChance = criticalStrikeStrings[0];
            critChanceLucky = criticalStrikeStrings[1];
        }

        // AXE MASTERY
        if (canBonusDamage) {
            bonusDamage = Math.min(skillValue / (Axes.bonusDamageMaxBonusLevel / Axes.bonusDamageMaxBonus), Axes.bonusDamageMaxBonus);
        }
    }

    @Override
    protected void permissionsCheck(Player player) {
        canSkullSplitter = Permissions.skullSplitter(player);
        canCritical = Permissions.criticalStrikes(player);
        canBonusDamage = Permissions.bonusDamage(player, skill);
        canImpact = Permissions.armorImpact(player);
        canGreaterImpact = Permissions.greaterImpact(player);
    }

    @Override
    protected List<String> effectsDisplay() {
        List<String> messages = new ArrayList<String>();

        if (canSkullSplitter) {
            messages.add(LocaleLoader.getString("Effects.Template", LocaleLoader.getString("Axes.Effect.0"), LocaleLoader.getString("Axes.Effect.1")));
        }

        if (canCritical) {
            messages.add(LocaleLoader.getString("Effects.Template", LocaleLoader.getString("Axes.Effect.2"), LocaleLoader.getString("Axes.Effect.3")));
        }

        if (canBonusDamage) {
            messages.add(LocaleLoader.getString("Effects.Template", LocaleLoader.getString("Axes.Effect.4"), LocaleLoader.getString("Axes.Effect.5")));
        }

        if (canImpact) {
            messages.add(LocaleLoader.getString("Effects.Template", LocaleLoader.getString("Axes.Effect.6"), LocaleLoader.getString("Axes.Effect.7")));
        }

        if (canGreaterImpact) {
            messages.add(LocaleLoader.getString("Effects.Template", LocaleLoader.getString("Axes.Effect.8"), LocaleLoader.getString("Axes.Effect.9")));
        }

        return messages;
    }

    @Override
    protected List<String> statsDisplay(Player player, float skillValue, boolean hasEndurance, boolean isLucky) {
        List<String> messages = new ArrayList<String>();

        if (canBonusDamage) {
            messages.add(LocaleLoader.getString("Ability.Generic.Template", LocaleLoader.getString("Axes.Ability.Bonus.0"), LocaleLoader.getString("Axes.Ability.Bonus.1", bonusDamage)));
        }

        if (canImpact) {
            messages.add(LocaleLoader.getString("Ability.Generic.Template", LocaleLoader.getString("Axes.Ability.Bonus.2"), LocaleLoader.getString("Axes.Ability.Bonus.3", impactDamage)));
        }

        if (canGreaterImpact) {
            messages.add(LocaleLoader.getString("Ability.Generic.Template", LocaleLoader.getString("Axes.Ability.Bonus.4"), LocaleLoader.getString("Axes.Ability.Bonus.5", Axes.greaterImpactBonusDamage)));
        }

        if (canCritical) {
            messages.add(LocaleLoader.getString("Axes.Combat.CritChance", critChance) + (isLucky ? LocaleLoader.getString("Perks.Lucky.Bonus", critChanceLucky) : ""));
        }

        if (canSkullSplitter) {
            messages.add(LocaleLoader.getString("Axes.Combat.SS.Length", skullSplitterLength) + (hasEndurance ? LocaleLoader.getString("Perks.ActivationTime.Bonus", skullSplitterLengthEndurance) : ""));
        }

        return messages;
    }
}
