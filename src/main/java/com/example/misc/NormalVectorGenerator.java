package com.example.misc;

import net.minecraft.util.math.Vec3d;

public class NormalVectorGenerator {

    public static Vec3d rotateAroundAxis(Vec3d axis, double angle) {
        Vec3d perpendicularVector = generatePerpendicularVector(axis);
        return rotateAroundAxis(perpendicularVector, axis, angle);
    }

    public static Vec3d rotateAroundAxis(Vec3d vec, Vec3d axis, double angle) {
        double cosTheta = Math.cos(Math.toRadians(angle));
        double sinTheta = Math.sin(Math.toRadians(angle));

        double x = vec.x;
        double y = vec.y;
        double z = vec.z;

        double u_x = axis.x;
        double u_y = axis.y;
        double u_z = axis.z;

        double unitX = (x * (cosTheta + u_x * u_x * (1 - cosTheta)) +
                        y * (u_x * u_y * (1 - cosTheta) - u_z * sinTheta) +
                        z * (u_x * u_z * (1 - cosTheta) + u_y * sinTheta));

        double unitY = (x * (u_y * u_x * (1 - cosTheta) + u_z * sinTheta) +
                y * (cosTheta + u_y * u_y * (1 - cosTheta)) +
                z * (u_y * u_z * (1 - cosTheta) - u_x * sinTheta));

        double unitZ = (x * (u_z * u_x * (1 - cosTheta) - u_y * sinTheta) +
                y * (u_z * u_y * (1 - cosTheta) + u_x * sinTheta) +
                z * (cosTheta + u_z * u_z * (1 - cosTheta)));

        double length = getLength(unitX,unitY,unitZ);

        return new Vec3d(unitX/length,unitY/length,unitZ/length);
    }

    public static Vec3d generatePerpendicularVector(Vec3d axis) {
        Vec3d randomVec = axis.crossProduct(new Vec3d(1, 0, 0));
        if (randomVec.lengthSquared() == 0) {
            randomVec = axis.crossProduct(new Vec3d(0, 1, 0));
        }
        return randomVec.normalize();
    }

    private static double getLength(double x,double y,double z){
        return Math.sqrt(
                x * x +
                y * y +
                z * z );
    }
}
