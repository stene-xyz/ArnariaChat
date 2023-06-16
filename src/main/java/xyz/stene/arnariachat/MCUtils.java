/*
 * Arnaria Chat V1.0.1
 * Copyright (C) 2023 Johnny Stene
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package xyz.stene.arnariachat;

import net.minecraft.util.math.BlockPos;

public class MCUtils {
    public static double getCoorinateDistance(BlockPos pos1, BlockPos pos2) {
        double x = Math.abs(pos1.getX() - pos2.getX());
        double y = Math.abs(pos1.getY() - pos2.getY());
        double z = Math.abs(pos1.getZ() - pos2.getZ());
        return x + y + z;
    }
}
