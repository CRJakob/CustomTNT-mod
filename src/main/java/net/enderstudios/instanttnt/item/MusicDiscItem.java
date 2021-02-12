
package net.enderstudios.instanttnt.item;

import net.minecraftforge.registries.ObjectHolder;

import net.minecraft.util.ResourceLocation;
import net.minecraft.item.Rarity;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;

import net.enderstudios.instanttnt.TntModElements;

@TntModElements.ModElement.Tag
public class MusicDiscItem extends TntModElements.ModElement {
	@ObjectHolder("tnt:music_disc")
	public static final Item block = null;
	public MusicDiscItem(TntModElements instance) {
		super(instance, 7);
	}

	@Override
	public void initElements() {
		elements.items.add(() -> new MusicDiscItemCustom());
	}
	public static class MusicDiscItemCustom extends MusicDiscItem {
		public MusicDiscItemCustom() {
			super(0, TntModElements.sounds.get(new ResourceLocation("tnt:revenge")),
					new Item.Properties().group(ItemGroup.MISC).maxStackSize(1).rarity(Rarity.RARE));
			setRegistryName("music_disc");
		}
	}
}
