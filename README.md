touch2cheat
===========

Library to embed cheats to games on touchscreen devices lacking a physical keyboard. 

### Current Features
* Two Modes of Cheat Area Abstraction
  * D-Pad (4-direction area to touch)
  * Grid (NxM touchable areas)
* Relative or absolute positioning of the canvas
* Time limitation for cheats
* Easy to use
  * Add library to your project
  * Forward your touch events to the library's manager
  * (Sample code is below)

###  Possible Features
* Gesture support
* Cheat Recorder - Creator GUI
* ANY RECOMMENDATIONS HERE

=========================
## How to Use

#### Basic Classes
* com.ozd.touche.cheat.base.<b>Cheat</b>: Basic class to contain a single cheat along with its name
* com.ozd.touche.cheat.base.<b>CheatContainar</b>: Class where you should add all your <b>Cheat</b>'s
* com.ozd.touche.canvas.<b>CheatCanvas</b>: Class that represenets a portion of area
* com.ozd.touche.canvas.<b>CheatCanvasModel</b>: Parent class of DPad and Grid, for generalization
* com.ozd.touche.canvas.<b>DPad</b>: Class to simulate the canvas as DPad
* com.ozd.touche.canvas.<b>Grid</b>: Class to simulate the canvas as a grid of buttons
* com.ozd.touche.cheat.management.<b>CheatManager</b>: The class which you should interact in your main game loop
* com.ozd.touche.cheat.management.<b>CheatListener</b>: A listener interface which has methods that forwards the name of the cheat when a cheat succeeds 


#### Example code For DPad
First we create a cheat container and some cheats (we have some statics here for four directions. Then we add the cheats to container. Lastly we create a CheatCanvasModel with type DPad that we'll use later.
```
CheatContainer dpadContainer = new CheatContainer();
Cheat dpadCheat1 = new Cheat("hanouken", new int[] {DPad.DPAD_LEFT, DPad.DPAD_RIGHT, DPad.DPAD_LEFT, DPad.DPAD_RIGHT});
Cheat dpadCheat2 = new Cheat("dropcar", new int[] {DPad.DPAD_LEFT, DPad.DPAD_DOWN, DPad.DPAD_UP});
dpadContainer.add(dpadCheat1);
dpadContainer.add(dpadCheat2);

CheatCanvasModel dpad = new DPad();
```

#### Example code for Grid
Same applies here. This time we don't have statics for directions as we don't have directions here but portions and we don't have limitations. (You may wish to add pixel-wide precision for your cheats, and thats OK.)

The array given to a cheat contains numbers of areas

0 | 1 | 2 | 3<br/>
4 | 5 | 6 | 7

This is an example for a grid of 4x2.
```
CheatContainer gridCheatsContainer = new CheatContainer();
Cheat gridCheat1 = new Cheat("hanouken", new int[] {1, 2, 1, 22});
Cheat gridCheat2 = new Cheat("dropcar", new int[] {0, 14, 39});
gridCheatsContainer.add(dpadCheat1);
gridCheatsContainer.add(dpadCheat2);

int COLUMNS = 5;
int ROWS = 8;
CheatCanvasModel grid = new Grid(COLUMNS, ROWS);
```

Our next job is to create a canvas.
#### Creating a Canvas
Here we give our grid or dpad as an argument. We have four other parameters, which are 
* <b>originX</b>: Origin of the canvas. If you want to forward your touch events directly, you should give the exact position. If you want to calculate the position of the touch event before sending it to CheatManager, then you should use 0.
* <b>originY</b>: Same applies here.
* <b>width</b>: Width of the canvas.
* <b>heightY</b>: Height of the canvas.

Lets create canvas now.
```
CheatCanvas dpadCanvas = new CheatCanvas(0, 0, 200, 200, dpad);
```

#### Creating the CheatManager
The last parameter is the timeout, which is in milliseconds, which is the time after when a touch is invalid.
```
CheatManager dpadManager = new CheatManager(dpadCanvas, dpadCheatsContainer, 0);
```

#### Listening for Events
Now the manager is set. We need to listen for cheats. (Though we don't send any inputs to the manager, which we'll do in next part.)
The manager notifies all listeners with the cheat's name.
```
public class AwesomeListener implements CheatListener {
  @Override
  public void cheatActivated(String cheatName) {
      if("hanouken".equals(cheatName)) System.out.println("Holy crap!");
      else if("dropcar".equals(cheatName)) System.out.println("This ain't no fast, though.");
  }
}
```
We need to create an instance of our AwesomeListener and add it to the CheatManager as a listener.
```
AwesomeListener dPadListener = new AwesomeListener();
dpadManager.addListener(dPadListener);
```

#### Final: Forwarding Touch Events to CheatManager
All we need to do is to forward touch positions to the framework. For example, if you want to use it with Swing's mouse listener, 
```
@Override
public void mouseClicked(MouseEvent e) {
    dpadManager.click(e.getPoint().x, e.getPoint().y);
}
```
Or if you wish to use LibGDX, 
```
@Override
public boolean touchDown (int x, int y, int pointer, int button) {
  dpadManager.click(x, y);
}
```

## Licensing
Copyright 2014 Seyfülislam Özdemir. Licensed under the Apache License, Version 2.0. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0

## Author(s)
* Seyfülislam Özdemir
* You?

Contact me for anything related to this project.
