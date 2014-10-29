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
package com.ozd.touche.cheat.base;

/**
 * Represents a hit in the touchable cheating area. Wrapper for the index of the
 * cell and the time it touched (milliseconds).
 *
 * @author Seyfülislam Özdemir
 */
public class Hit {

    private final int cell;
    private final long time;

    public Hit(int cell) {
        this.cell = cell;
        this.time = System.currentTimeMillis();
    }

    /**
     *
     * @return the index of the cell for Grid and the direction for Grid.
     */
    public int getCell() {
        return this.cell;
    }

    /**
     *
     * @return the time (milliseconds) that the touch is made.
     */
    public long getTime() {
        return this.time;
    }

}
