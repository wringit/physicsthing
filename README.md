# Physics (gravity) engine
This was meant to be a "fun" project that I worked on after taking high school physics, but I ended up not touching it for a while. I came back to it recently, and so far that it does is create objects and have them attract each other. You can add objects by running the jar, but you can also add them programmatically in PhysObjects.java. For example: 
```java
medium.addBody(new PhysObj(20,1000,40,50,50)); // Creates a physics object with 20 kilograms (?) of mass, 50 pixels wide and 50 tall, at (1000,4)
```


## To do in future
- So far, although the attraction works well at first and the program can tell exactly when objects touch, the gravity gets very weird once they touch, and my code for collisions isn't working (as intended) so far. 
- Right now, I'm using AWT for graphics, but the animation is horrible, so I might change that later.