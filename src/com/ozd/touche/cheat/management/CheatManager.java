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
package com.ozd.touche.cheat.management;

import com.ozd.touche.canvas.CheatCanvas;
import com.ozd.touche.cheat.base.Cheat;
import com.ozd.touche.cheat.base.CheatContainer;
import java.util.ArrayList;

/**
 *
 * @author Seyfülislam
 */
public class CheatManager {
    
    ArrayList<CheatListener> listeners;
    CheatCanvas canvas;
    CheatContainer cheats;
    HitManager hits;
    int timeOut;
    
    public CheatManager(CheatCanvas canvas, CheatContainer cheats, int timeOut) {
        listeners = new ArrayList<>();
        hits = new HitManager(timeOut);
        this.canvas = canvas;
        this.cheats = cheats;
        this.timeOut = timeOut;
    }
    
    public void addListener(CheatListener listener) {
        if (listener == null) {
            return;
        }
        listeners.add(listener);
    }
    
    public void removeListener(CheatListener listener) {
        if (listener == null) {
            return;
        }
        listeners.remove(listener);
    }
    
    public void click(int x, int y) {
        int cell = this.canvas.touch(x, y);
        hits.hit(cell);
        
        int[] input = hits.getHits();
        
        for (Cheat cheat : cheats) {
            if (cheat.check(input)) {
                notifyListeners(cheat.getName());
                hits.clear();
            }
        }
    }
    
    private void notifyListeners(String name) {
        for (CheatListener l : listeners) {
            l.cheatActivated(name);
        }
    }
    
}
