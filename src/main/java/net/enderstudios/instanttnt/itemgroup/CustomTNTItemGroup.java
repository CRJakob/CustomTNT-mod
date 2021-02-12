
package net.enderstudios.instanttnt.itemgroup;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemGroup;

import net.enderstudios.instanttnt.block.InstantTNTBlock;
import net.enderstudios.instanttnt.TntModElements;

@TntModElements.ModElement.Tag
public class CustomTNTItemGroup extends TntModElements.ModElement {
	public CustomTNTItemGroup(TntModElements instance) {
		super(instance, 6);
	}

	@Override
	public void initElements() {
		tab = new ItemGroup("tabcustom_tnt") {
			@OnlyIn(Dist.CLIENT)
			@Override
			public ItemStack createIcon() {
				return new ItemStack(InstantTNTBlock.block, (int) (1));
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return false;
			}
		};
	}
	public static ItemGroup tab;
}
