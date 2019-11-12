package net.minecraft.world.storage.loot.conditions;

import com.google.common.collect.Lists;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootContext;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.ValidationResults;

public class Alternative implements ILootCondition {
   private final ILootCondition[] conditions;
   private final Predicate<LootContext> field_215963_b;

   private Alternative(ILootCondition[] conditionsIn) {
      this.conditions = conditionsIn;
      this.field_215963_b = LootConditionManager.or(conditionsIn);
   }

   public final boolean test(LootContext p_test_1_) {
      return this.field_215963_b.test(p_test_1_);
   }

   public void func_215856_a(ValidationResults p_215856_1_, Function<ResourceLocation, LootTable> p_215856_2_, Set<ResourceLocation> p_215856_3_, LootParameterSet p_215856_4_) {
      ILootCondition.super.func_215856_a(p_215856_1_, p_215856_2_, p_215856_3_, p_215856_4_);

      for(int i = 0; i < this.conditions.length; ++i) {
         this.conditions[i].func_215856_a(p_215856_1_.descend(".term[" + i + "]"), p_215856_2_, p_215856_3_, p_215856_4_);
      }

   }

   public static Alternative.Builder builder(ILootCondition.IBuilder... buildersIn) {
      return new Alternative.Builder(buildersIn);
   }

   public static class Builder implements ILootCondition.IBuilder {
      private final List<ILootCondition> conditions = Lists.newArrayList();

      public Builder(ILootCondition.IBuilder... buildersIn) {
         for(ILootCondition.IBuilder ilootcondition$ibuilder : buildersIn) {
            this.conditions.add(ilootcondition$ibuilder.build());
         }

      }

      public Alternative.Builder alternative(ILootCondition.IBuilder builderIn) {
         this.conditions.add(builderIn.build());
         return this;
      }

      public ILootCondition build() {
         return new Alternative(this.conditions.toArray(new ILootCondition[0]));
      }
   }

   public static class Serializer extends ILootCondition.AbstractSerializer<Alternative> {
      public Serializer() {
         super(new ResourceLocation("alternative"), Alternative.class);
      }

      public void serialize(JsonObject json, Alternative value, JsonSerializationContext context) {
         json.add("terms", context.serialize(value.conditions));
      }

      public Alternative deserialize(JsonObject json, JsonDeserializationContext context) {
         ILootCondition[] ailootcondition = JSONUtils.deserializeClass(json, "terms", context, ILootCondition[].class);
         return new Alternative(ailootcondition);
      }
   }
}