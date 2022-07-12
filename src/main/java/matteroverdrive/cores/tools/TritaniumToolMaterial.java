package matteroverdrive.cores.tools;

import matteroverdrive.common.events.MOContent;
import matteroverdrive.common.events.MainGroupReg;
import net.minecraft.item.ToolMaterial;
import net.minecraft.recipe.Ingredient;

public class TritaniumToolMaterial implements ToolMaterial {

    public static final TritaniumToolMaterial INSTANCE = new TritaniumToolMaterial();
    @Override
    public int getDurability() {
        return 3122;
    }

    @Override
    public float getMiningSpeedMultiplier() {
        return 8.0F;
    }

    @Override
    public float getAttackDamage() {
        return 3.0F;
    }

    @Override
    public int getMiningLevel() {
        return 3;
    }

    @Override
    public int getEnchantability() {
        return 15;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return Ingredient.ofItems(MOContent.tritanium_ingot);
    }
}
