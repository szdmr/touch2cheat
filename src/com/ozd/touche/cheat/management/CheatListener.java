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

/**
 * This is the interface that should be implemented by the class which is going
 * to take action when a cheat is successfully activated.
 *
 * @author Seyfülislam Özdemir
 */
public interface CheatListener {

    /**
     * At most one cheat can be activated for a single touch.
     *
     * @param cheatName is the name of the cheat that is activated.
     *
     */
    public void cheatActivated(String cheatName);
}
