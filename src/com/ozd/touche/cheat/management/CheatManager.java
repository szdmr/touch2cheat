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

import com.ozd.touche.canvas.CheatCanvas;
import com.ozd.touche.cheat.base.CheatContainer;
import java.util.ArrayList;

/**
 * This is the one class that you should take care of all the things. Initialize
 * this with a canvas and a list of cheats prepared, and you are set.
 *
 * @author Seyfülislam Özdemir
 */
public class CheatManager {

    private final ArrayList<CheatListener> listeners;
    private final CheatCanvas canvas;
    private final CheatContainer cheats;
    private final HitManager hits;
    private final int timeOut;

    /**
     *
     * @param canvas is the area that holds the dimensions, position and the
     * model of your touchable cheating area.
     * @param cheats is a subclass of ArrayList containing a series of cheats.
     * You should add your cheats to the list. They are all checked after each
     * touch.
     * @param timeOut is the time (in milliseconds) that the touches made in the
     * touchable area becomes invalid. Set it to 0 if you don't want timeout
     * functionality.
     */
    public CheatManager(CheatCanvas canvas, CheatContainer cheats, int timeOut) {
        listeners = new ArrayList<>();
        this.canvas = canvas;
        this.cheats = cheats;
        this.timeOut = timeOut;
        hits = new HitManager(this.timeOut);
    }

    /**
     * Adds a listener which is invoked if a cheat gets activated.
     *
     * @param listener is a listener implementing CheatListener interface.
     */
    public void addListener(CheatListener listener) {
        if (listener == null) {
            return;
        }
        listeners.add(listener);
    }

    /**
     * Remove a listener to stop it from getting called after touch.
     *
     * @param listener is a listener implementing CheatListener interface.
     */
    public void removeListener(CheatListener listener) {
        if (listener == null) {
            return;
        }
        listeners.remove(listener);
    }

    /**
     * This is the method that you should forward all of the touches made to
     * your screen. You can filter the ones that made in the cheating area to
     * avoid the out of bound touches to reset the touch buffer of the manager
     * or forward all touches * (recommended) to this method in your game loop.
     *
     * @param x is the x position of the point touched by user.
     * @param y is the x position of the point touched by user.
     */
    public void click(int x, int y) {
        int cell = this.canvas.touch(x, y);
        hits.hit(cell);

        int[] input = hits.getHits();

        String s = cheats.check(input);

        if (s != null) {
            notifyListeners(s);
            hits.clear();
        }
    }

    private void notifyListeners(String name) {
        for (CheatListener l : listeners) {
            l.cheatActivated(name);
        }
    }

}
