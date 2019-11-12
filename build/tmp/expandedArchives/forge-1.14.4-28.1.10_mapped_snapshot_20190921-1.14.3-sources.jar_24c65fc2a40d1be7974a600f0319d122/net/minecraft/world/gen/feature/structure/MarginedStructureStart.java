package net.minecraft.world.gen.feature.structure;

import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.biome.Biome;

public abstract class MarginedStructureStart extends StructureStart {
   public MarginedStructureStart(Structure<?> structureIn, int chunkX, int chunkZ, Biome biomeIn, MutableBoundingBox boundsIn, int referenceIn, long seed) {
      super(structureIn, chunkX, chunkZ, biomeIn, boundsIn, referenceIn, seed);
   }

   protected void recalculateStructureSize() {
      super.recalculateStructureSize();
      int i = 12;
      this.bounds.minX -= 12;
      this.bounds.minY -= 12;
      this.bounds.minZ -= 12;
      this.bounds.maxX += 12;
      this.bounds.maxY += 12;
      this.bounds.maxZ += 12;
   }
}