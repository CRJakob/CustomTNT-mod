
package net.enderstudios.instanttnt.item;

@TntModElements.ModElement.Tag
public class TntDiscItem extends TntModElements.ModElement {

	@ObjectHolder("tnt:tnt_disc")
	public static final Item block = null;

	public TntDiscItem(TntModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}

	public static class MusicDiscItemCustom extends MusicDiscItem {

		public MusicDiscItemCustom() {
			super(0, (net.minecraft.util.SoundEvent) ForgeRegistries.SOUND_EVENTS.getValue(new ResourceLocation("entity.creeper.primed")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("tnt_disc");
		}

	}

}
