# Physics (gravity) engine
This was meant to be a "fun" project that I worked on after taking high school physics, but I ended up not touching it for a while. I came back to it recently, and so far that it does is create objects and have them attract each other. In order to add/remove objects, you need to just add them to the "world" in PhysObjects.java. For example:
```java
medium.addBody(new PhysObj(20,1000,40,50,50));
```


## To do in future
- So far, although the attraction works well at first and the program can tell exactly when objects touch, the gravity gets a bit weird once they touch, and my code for collisions isn't working so far.
- Right now, I'm using AWT for graphics, but the animation is horrible, so I might change that later.
- This program is a little bit unusable right now, so I should fix that later (UI, build instructions, etc.)