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
 * Parent class for different canvas models.
 *
 * @author Seyfülislam Özdemir
 */
public abstract class CheatCanvasModel {

    /**
     * You better not call this function directly.
     *
     * @param posX x position of the point user touched.
     * @param posY y position of the point user touched.
     * @return the index of the cell for Grid or the direction for the DPad.
     */
    protected abstract int touch(float posX, float posY);

}
