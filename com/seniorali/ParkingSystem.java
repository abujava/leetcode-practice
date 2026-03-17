package com.seniorali;

/**
 * This class is not documented :(
 *
 * @author Muhammad Muminov
 * @since 4/22/2024
 */

class ParkingSystem {
    private int[] park;

    public ParkingSystem(int big, int medium, int small) {
        park = new int[]{big, medium, small};
    }

    public boolean addCar(int carType) {
        if (park[carType - 1] > 0) {
            park[carType - 1]--;
            return true;
        }
        return false;
    }
}
