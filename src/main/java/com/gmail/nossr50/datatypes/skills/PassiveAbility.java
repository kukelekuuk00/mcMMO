package com.gmail.nossr50.datatypes.skills;

public enum PassiveAbility {
    IRON_GRIP(SkillType.UNARMED),
    DEFLECT(SkillType.UNARMED),
    DISARM(SkillType.UNARMED),
    DODGE(SkillType.ACROBATICS),
    ROLL(SkillType.ACROBATICS),
    GRACEFUL_ROLL(SkillType.ACROBATICS),
    TRACK_ARROWS(SkillType.ARCHERY),
    DAZE(SkillType.ARCHERY),
    CRITICAL_HIT(SkillType.AXES),
    IMPACT(SkillType.AXES),
    GREATER_IMPACT(SkillType.AXES),
    HERBALISM_DOUBLE_DROPS(SkillType.HERBALISM),
    GREEN_THUMB(SkillType.HERBALISM),
    SHROOM_THUMB(SkillType.HERBALISM),
    HYLIAN_LUCK(SkillType.HERBALISM),
    GREEN_THUMB_BLOCK(SkillType.HERBALISM),
    MINING_DOUBLE_DROPS(SkillType.MINING),
    SUPER_REPAIR(SkillType.MINING),
    SECOND_SMELT(SkillType.SMELTING),
    BLEED(SkillType.SWORDS),
    COUNTER_ATTACK(SkillType.SWORDS),
    FAST_FOOD(SkillType.TAMING),
    GORE(SkillType.TAMING),
    WOODCUTTING_DOUBLE_DROPS(SkillType.WOODCUTTING),
    ;


    private SkillType skill;

    private PassiveAbility(SkillType skill) {
        this.skill = skill;
    }

    public SkillType getSkill() {
        return skill;
    }
}
