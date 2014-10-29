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
package com.ozd.touche.cheat.base;

/**
 *
 * @author Seyfülislam
 */
public class Cheat {
    private final int[] cheatCode;
    private final String name;
    
    public Cheat(String name, int[] cheatCode) {
        this.cheatCode = cheatCode;
        this.name = name;
    }
    
    public int length() {
        return cheatCode.length;
    }
    
    public String getName() {
        return this.name;
    }
    
    public boolean check(int[] input) {
        if(input == null) return false;
        if(input.length < cheatCode.length) return false;
        int diff = input.length - cheatCode.length;
        for(int i = 0; i < cheatCode.length; i++) {
            if(input[i+diff] != cheatCode[i]) return false;
        }
        return true;
    }
}
