Timely-Like-Water-Ripple-Effect
===============================

Check out my blog for a more detailed explaination and screenshots:
http://cloudninedev.tumblr.com/post/88748549418/timely-like-water-ripple-effect-on-android


WORKING:

STEP 1: Photoshop

You first create the ripple on Photoshop. Use a Bevel Emboss effect to get the desired 3D effect.

STEP 2: Animate

Create the desired ripple animation in your res/anim folder. The animation is named ripplescale.xml in my project

STEP 3: Code

* A touch listener has been used to detect the x and y co-ordinates of so that the ripple can be shown.
* A image view is added to the view dynamically and animated.
