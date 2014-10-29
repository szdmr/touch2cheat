/*
 * Copyright 2014 Seyfülislam Özdemir.
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
package com.ozd.touche.canvas;

/**
 * This class represents the the touchable area of the screen.
 *
 * @author Seyfülislam Özdemir
 * @see CheatCanvasModel
 */
public class CheatCanvas {

    private final int originX;
    private final int originY;
    private final int width;
    private final int height;
    private final CheatCanvasModel model;

    /**
     *
     * @param originX represents the x-axis location of origin of the
     * cheat-enabled area in the actual screen.
     * @param originY represents the y-axis location of origin of the
     * cheat-enabled area in the actual screen.
     * @param width represents the width of the cheat-enabled area.
     * @param height represents the height of the cheat-enabled area.
     * @param model is the model that you want your cheat-enabled area to be.
     * @see CheatCanvasModel
     * @throws IllegalArgumentException when model is null.
     */
    public CheatCanvas(int originX, int originY, int width, int height, CheatCanvasModel model) {
        if (model == null) {
            throw new IllegalArgumentException("Canvas model cannot be null.");
        }
        this.originX = originX;
        this.originY = originY;
        this.width = width;
        this.height = height;
        this.model = model;
    }

    /**
     * This method is not recommended to be called directly.
     *
     * @param posX is the position of the touched point on the X axis.
     * @param posY is the position of the touched point on the Y axis.
     * @return resulting cell or direction depending on the model. -1 if it is
     * out of bounds.
     */
    public int touch(int posX, int posY) {
        float x = (float) posX;
        float y = (float) posY;

        x = (x - originX) / width;
        y = (y - originY) / height;
        return this.model.touch(x, y);
    }
}
