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
package com.ozd.touche.cheat.management;

import com.ozd.touche.cheat.base.Hit;
import java.util.ArrayList;

/**
 *
 * @author Seyfülislam Özdemir
 */
public class HitManager {

    private final ArrayList<Hit> hits;
    private final int timeOut;

    /**
     * 
     * @param timeOut is the desired timeout in milliseconds. Set it to 0 if you 
     * want no timeouts and only want to check for bounds.
     */
    protected HitManager(int timeOut) {
        hits = new ArrayList<>();
        this.timeOut = timeOut;
    }

    /** This method processes new touch according to the following rules: 
     * <br>
     * If cell is -1, all hits are cleared as the touch is out of bounds of cheating area.
     * <br>
     * Else it holds the cell index in a List.
     * <br>
     * Before returning, it clears all the timed out touches if timeOut is not set to 0 
     * during initialization.
     * 
     * @param cell is the cell index returned by the CheatCanvas.
     */
    protected void hit(int cell) {
        if (cell == -1) {
            hits.clear();
            return;
        }
        hits.add(new Hit(cell));
        if (timeOut != 0) {
            long t = System.currentTimeMillis();
            while (t - hits.get(0).getTime() > timeOut) {
                hits.remove(0);
            }
        }
    }

    /**
     * 
     * @return the array of the indexes of the valid touches.
     */
    public int[] getHits() {
        int[] hitArray = new int[hits.size()];
        for (int i = 0; i < hits.size(); i++) {
            hitArray[i] = hits.get(i).getCell();
        }
        return hitArray;
    }
    
    /**
     * Clears the inputs.
     */
    protected void clear() {
        this.hits.clear();
    }
}
