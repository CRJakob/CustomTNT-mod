package net.enderstudios.instanttnt.world;

import net.minecraftforge.fml.common.ObfuscationReflectionHelper;

import net.minecraft.world.GameRules;

import net.enderstudios.instanttnt.TntModElements;

import java.lang.reflect.Method;

@TntModElements.ModElement.Tag
public class InstantTNTTimerGameRule extends TntModElements.ModElement {
	public static final GameRules.RuleKey<GameRules.IntegerValue> gamerule = GameRules.register("instantTNTTimer", GameRules.Category.MISC,
			create(0));
	public InstantTNTTimerGameRule(TntModElements instance) {
		super(instance, 2);
	}

	public static GameRules.RuleType<GameRules.IntegerValue> create(int defaultValue) {
		try {
			Method createGameruleMethod = ObfuscationReflectionHelper.findMethod(GameRules.IntegerValue.class, "func_223564_a", int.class);
			createGameruleMethod.setAccessible(true);
			return (GameRules.RuleType<GameRules.IntegerValue>) createGameruleMethod.invoke(null, defaultValue);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
