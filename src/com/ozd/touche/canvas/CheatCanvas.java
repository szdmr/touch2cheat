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
package com.ozd.touche.canvas;

import com.ozd.touche.canvas.model.CheatCanvasModel;

/**
 *
 * @author Seyfülislam
 */
public class CheatCanvas {
    
    private final int originX;
    private final int originY;
    private final int width;
    private final int height;
    private final int minX;
    private final int minY;
    private final int maxX;
    private final int maxY;
    private final CheatCanvasModel model;
    
    
    public CheatCanvas(int originX, int originY, int width, int height, CheatCanvasModel model) {
        this.originX = originX;
        this.originY = originY;
        this.width = width;
        this.height = height;
        this.minX = originX;
        this.minY = originY;
        this.maxX = this.minX + width;
        this.maxY = this.minY + height;
        this.model = model;
    }
    
    public int touch(int posX, int posY) {
        float x = (float)posX;
        float y = (float)posY;
        
        x = (x-originX)/width;
        y = (y-originY)/width;
        return this.model.touch(x, y);
    }
    
    
    
    

}
