/*
 * Copyright 2014 Seyfülislam.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.ozd.touche.canvas.model;

/**
 *
 * @author Seyfülislam
 */
public class DPad extends CheatCanvasModel {
    
    private static final float P1X = 0f;
    private static final float P1Y = 0.5f;
    private static final float P2X = 1f;
    private static final float P2Y = 0.5f;
    private static final float P3X = 0.5f;
    private static final float P3Y = 0f;
    private static final float P4X = 0.5f;
    private static final float P4Y = 1f;
    
    public static final int DPAD_LEFT = 0;
    public static final int DPAD_RIGHT = 1;
    public static final int DPAD_DOWN = 2;
    public static final int DPAD_UP = 3;
    

    @Override
    public int touch(float posX, float posY) {
        float left = calculateLeft(posX, posY);
        float right = calculateRight(posX, posY);
        float down = calculateDown(posX, posY);
        float up = calculateUp(posX, posY);
        
        int current = DPAD_LEFT;
        float currentVal = left;
        if(right < currentVal) {
            current = DPAD_RIGHT;
            currentVal = right;
        }
        if(down < currentVal) {
            current = DPAD_DOWN;
            currentVal = down;
        }
        if(up < currentVal) {
            current = DPAD_UP;
        }
        return current;
    }
    
    private float calculateLeft(float x, float y) {
        return (float)Math.sqrt(Math.pow(x-P1X, 2) + Math.pow(y-P1Y, 2));
    }
    private float calculateRight(float x, float y) {
        return (float)Math.sqrt(Math.pow(x-P2X, 2) + Math.pow(y-P2Y, 2));
    }
    private float calculateDown(float x, float y) {
        return (float)Math.sqrt(Math.pow(x-P3X, 2) + Math.pow(y-P3Y, 2));
    }
    private float calculateUp(float x, float y) {
        return (float)Math.sqrt(Math.pow(x-P4X, 2) + Math.pow(y-P4Y, 2));
    }
    
}
