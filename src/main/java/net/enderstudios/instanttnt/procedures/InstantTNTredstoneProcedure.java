package net.enderstudios.instanttnt.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.world.Explosion;
import net.minecraft.entity.Entity;

import net.enderstudios.instanttnt.world.InstantTNTTimerGameRule;
import net.enderstudios.instanttnt.world.InstantTNTStrengthGameRule;
import net.enderstudios.instanttnt.TntModElements;
import net.enderstudios.instanttnt.TntMod;

import java.util.Map;

@TntModElements.ModElement.Tag
public class InstantTNTredstoneProcedure extends TntModElements.ModElement {
	public InstantTNTredstoneProcedure(TntModElements instance) {
		super(instance, 5);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				TntMod.LOGGER.warn("Failed to load dependency entity for procedure InstantTNTredstone!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				TntMod.LOGGER.warn("Failed to load dependency x for procedure InstantTNTredstone!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				TntMod.LOGGER.warn("Failed to load dependency y for procedure InstantTNTredstone!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				TntMod.LOGGER.warn("Failed to load dependency z for procedure InstantTNTredstone!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				TntMod.LOGGER.warn("Failed to load dependency world for procedure InstantTNTredstone!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		entity.setNoGravity((false));
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private IWorld world;
			public void start(IWorld world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if (world instanceof World && !((World) world).isRemote) {
					((World) world).createExplosion(null, (int) x, (int) y, (int) z,
							(float) ((world instanceof World) ? ((World) world).getGameRules().getInt(InstantTNTStrengthGameRule.gamerule) : 0),
							Explosion.Mode.DESTROY);
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, (int) (((world instanceof World) ? ((World) world).getGameRules().getInt(InstantTNTTimerGameRule.gamerule) : 0) * 20));
	}
}
