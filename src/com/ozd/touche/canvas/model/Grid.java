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
public class Grid extends CheatCanvasModel {

    public final int columns;
    public final int rows;
    private final float barWidth;
    private final float barHeight;

    public Grid(int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.barWidth = 1.0f / columns;
        this.barHeight = 1.0f / rows;
    }

    @Override
    public int touch(float posX, float posY) {
        if (posX < 0) {
            return -1;
        }
        if (posY < 0) {
            return -1;
        }
        if (posX >= 1) {
            return -1;
        }
        if (posY >= 1) {
            return -1;
        }

        int row = (int) (posY / barHeight);
        int column = (int) (posX / barWidth);
        
        return row * columns + column;
    }

}
