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
 * Represents a single cheat. Only a wrapper for the code and the name.
 *
 * @author Seyfülislam Özdemir
 */
public class Cheat {

    private final int[] cheatCode;
    private final String name;

    /**
     *
     * @param name is the name of the cheat. It is forwarded to listeners when
     * this cheat is activated.
     * @param cheatCode is the code of the cheat. (the cell numbers for Grid and
     * the directions for DPad.)
     */
    public Cheat(String name, int[] cheatCode) {
        this.cheatCode = cheatCode;
        this.name = name;
    }

    /**
     *
     * @return the length of the cheat code
     */
    public int length() {
        return cheatCode.length;
    }

    /**
     *
     * @return name of the cheat
     */
    public String getName() {
        return this.name;
    }

    /**
     * Do not call this method directly. Or call. It has no effect.
     *
     * @param input is the points that the user touched.
     * @return if the input enables the cheat.
     */
    protected boolean check(int[] input) {
        if (input == null) {
            return false;
        }
        if (input.length < cheatCode.length) {
            return false;
        }
        int diff = input.length - cheatCode.length;
        for (int i = 0; i < cheatCode.length; i++) {
            if (input[i + diff] != cheatCode[i]) {
                return false;
            }
        }
        return true;
    }
}
