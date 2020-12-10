package net.ddns.jhonnystene.arnariachat;

import net.minecraft.util.math.BlockPos;

public class MCUtils {
    public static double getCoorinateDistance(BlockPos pos1, BlockPos pos2) {
        double x = Math.abs(pos1.getX() - pos2.getX());
        double y = Math.abs(pos1.getY() - pos2.getY());
        double z = Math.abs(pos1.getZ() - pos2.getZ());
        return x + y + z;
    }
}
