package com.dreamtea.wild_blocks.utils;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.state.property.EnumProperty;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.math.Direction;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final DirectionProperty ROTATION =  DirectionProperty.of("rotation", Direction.NORTH, Direction.SOUTH,  Direction.EAST, Direction.WEST);
    public static final EnumProperty<HorizontalFacing> DIRECTION = EnumProperty.of("direction", HorizontalFacing.class);

    public enum HorizontalFacing implements StringIdentifiable {
        X,
        Z;
        @Override
        public String asString() {
            return this.name().toLowerCase();
        }
         public static HorizontalFacing fromAxis(Direction.Axis axis){
            if(axis.isHorizontal()){
                if(axis == Direction.Axis.X){
                    return X;
                }
                if(axis == Direction.Axis.Z){
                    return Z;
                }
            }
            return null;
         }

         public static HorizontalFacing fromDirection(Direction direction){
            return fromAxis(direction.getAxis());
         }
         public static HorizontalFacing flip(HorizontalFacing orig){
            if(orig == X) {
                return Z;
            }
            if(orig ==Z) {
                return X;
            }
            return null;
         }
    }
}
