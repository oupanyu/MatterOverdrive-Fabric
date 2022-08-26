package matteroverdrive.cores.recipe;


import matteroverdrive.MatterOverdrive;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModRecipe {
    public static void registerRecipes(){
        Registry.register(Registry.RECIPE_SERIALIZER,new Identifier(MatterOverdrive.monamespace,InscriberRecipe.Serializer.ID),
                InscriberRecipe.Serializer.INSTANCE);
        Registry.register(Registry.RECIPE_TYPE,new Identifier(MatterOverdrive.monamespace,InscriberRecipe.Type.ID),
                InscriberRecipe.Type.INSTANCE);

    }
}
