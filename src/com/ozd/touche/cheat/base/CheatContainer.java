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

import java.util.ArrayList;

/**
 * Extends ArrayList of type Cheat and implements a method to check for an
 * enabled cheat.
 *
 * @author Seyfülislam Özdemir
 */
public class CheatContainer extends ArrayList<Cheat> {

    /**
     *
     * @param input is the points that the user touched.
     * @return name of the activated cheat. null if no cheats are activated.
     */
    public String check(int[] input) {

        for (Cheat cheat : this) {
            if (cheat.check(input)) {
                return cheat.getName();
            }
        }
        return null;
    }

}
