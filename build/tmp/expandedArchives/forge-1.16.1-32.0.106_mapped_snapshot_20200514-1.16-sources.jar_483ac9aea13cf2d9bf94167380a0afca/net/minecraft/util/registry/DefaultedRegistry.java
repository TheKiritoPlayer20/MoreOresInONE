package net.minecraft.util.registry;

import com.mojang.serialization.Lifecycle;
import java.util.Random;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;

public class DefaultedRegistry<T> extends SimpleRegistry<T> {
   /** The key of the default value. */
   private final ResourceLocation defaultValueKey;
   /** The default value for this registry, retrurned in the place of a null value. */
   private T defaultValue;

   public DefaultedRegistry(String p_i232506_1_, RegistryKey<Registry<T>> p_i232506_2_, Lifecycle p_i232506_3_) {
      super(p_i232506_2_, p_i232506_3_);
      this.defaultValueKey = new ResourceLocation(p_i232506_1_);
   }

   public <V extends T> V register(int id, RegistryKey<T> name, V instance) {
      if (this.defaultValueKey.equals(name.func_240901_a_())) {
         this.defaultValue = (T)instance;
      }

      return super.register(id, name, instance);
   }

   /**
    * Gets the integer ID we use to identify the given object.
    */
   public int getId(@Nullable T value) {
      int i = super.getId(value);
      return i == -1 ? super.getId(this.defaultValue) : i;
   }

   /**
    * Gets the name we use to identify the given object.
    */
   @Nonnull
   public ResourceLocation getKey(T value) {
      ResourceLocation resourcelocation = super.getKey(value);
      return resourcelocation == null ? this.defaultValueKey : resourcelocation;
   }

   @Nonnull
   public T getOrDefault(@Nullable ResourceLocation name) {
      T t = super.getOrDefault(name);
      return (T)(t == null ? this.defaultValue : t);
   }

   @Nonnull
   public T getByValue(int value) {
      T t = super.getByValue(value);
      return (T)(t == null ? this.defaultValue : t);
   }

   @Nonnull
   public T getRandom(Random random) {
      T t = super.getRandom(random);
      return (T)(t == null ? this.defaultValue : t);
   }

   public ResourceLocation getDefaultKey() {
      return this.defaultValueKey;
   }
}