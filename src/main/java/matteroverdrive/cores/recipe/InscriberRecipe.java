package matteroverdrive.cores.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.*;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.collection.DefaultedList;
import net.minecraft.world.World;

public class InscriberRecipe implements Recipe<SimpleInventory> {
    private final Identifier id;
    private final ItemStack output;
    private final DefaultedList<Ingredient> recipeItems;
    private final Integer maxProgress;

    public InscriberRecipe(Identifier id,ItemStack output,DefaultedList<Ingredient> recipeItems,Integer tick){
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.maxProgress = tick;


    }

    @Override
    public boolean matches(SimpleInventory inventory, World world) {
        if (recipeItems.get(0).test(inventory.getStack(0))){
            return recipeItems.get(1).test(inventory.getStack(1));
        }
        return false;
    }

    @Override
    public ItemStack craft(SimpleInventory inventory) {
        return output;
    }

    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput() {
        return output.copy();
    }

    @Override
    public Identifier getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public Integer getTick(){
        return maxProgress;
    }



    public static class Type implements RecipeType<InscriberRecipe> {
        private Type() {
        }

        public static final Type INSTANCE = new Type();
        public static final String ID = "inscriber";
    }

    public static class Serializer implements RecipeSerializer<InscriberRecipe>{

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "inscriber";

        @Override
        public InscriberRecipe read(Identifier id, JsonObject json) {
            ItemStack output = ShapedRecipe.outputFromJson(JsonHelper.getObject(json,"output"));
            JsonArray ingredients = JsonHelper.getArray(json,"ingredients");
            Integer tick = JsonHelper.getInt(json,"tick");
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(2,Ingredient.EMPTY);
            for(int i = 0; i < inputs.size(); i++){
                inputs.set(i,Ingredient.fromJson(ingredients.get(i)));
            }
            return new InscriberRecipe(id,output,inputs,tick);
        }

        @Override
        public InscriberRecipe read(Identifier id, PacketByteBuf buf) {
            DefaultedList<Ingredient> inputs = DefaultedList.ofSize(buf.readInt(),Ingredient.EMPTY);
            for(int i = 0; i < inputs.size(); i++){
                inputs.set(i,Ingredient.fromPacket(buf));
            }
            ItemStack output = buf.readItemStack();
            Integer tick = buf.readInt();
            return new InscriberRecipe(id,output,inputs,tick);
        }

        @Override
        public void write(PacketByteBuf buf, InscriberRecipe recipe) {
            buf.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()){
                ing.write(buf);
            }
            buf.writeItemStack(recipe.getOutput());
        }
    }
}
