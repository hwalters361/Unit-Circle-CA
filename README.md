# Unit Circle CA
This repository contains files for my Unit Circle CA

DrawAndExplainUnitCircle just draws a unit circle in Drawing Panel

UnitCircleQuiz is a quiz class that tests the user on different trig functions
about the unit circle. The questions ask for the user to input the correct ratio to different trig functions. At the end, the program tells the user which trig functions to restudy based off their answers.

In order for the program to work:

1. Download all files and open them in your preferred IDE. 
2. Open DrawingPanel.java, and compile the file. A bunch of janky class files will appear. Ignore these and move on.
3. Run DrawingPanelTest.java. If a window appears with a circle in the middle, the drawing panel class is working correctly
4. Compile UnitCircleQuiz.java so that the UnitCircleQuiz.class file will appear
5. Run UnitCircleQuizTest.java to play the quiz.
6. Run DrawAndExplainUnitCircle.java to draw a labeled unit circle and to study for the quiz

NOTES ON PLAYING THE QUIZ
- trig ratios sin, cos, tan have no radicals in the denominator. Their cosecant, secant, and cotangent counterparts do have radicals in the denominator

- Wrap parenthesis around numbers which are radicalized. For example, radical three should appear as (3)

	o For example, cos(135) would equal -(2)/2 but sec(135) equals -2/(2)
	
- Some values are simplified to whole numbers. For example, csc(30) = 2, not 2/1.

- Negatives are always first in the ratio. They go before everything. The answer -1/2 is valid but 1/-2 is invalid.

- All answers should be ratios. No decimals!

My explanations for the values used are in written notes which I submitted to schoology.

We were also required show how we use the teaching tool. Using the DrawAndExplainUnitCirlce.java file, you can see all values of the unit circle. The file explains that x values of the coordinates correspond to cosine values and that y value coordinates correspond to sine values. Using the unit circle illustration, you can go to the labeled degree, choose either the x or y value for cosine or sine repsectively and solve for the problems below. For tan values, you would divide the sine value by the cosine value. For csc, sec, and cot values you would multiply the sine or cosine value by it's reciprocol.

**However, it is important to note that the main focus for this proect isn't the DrawAndExplainUnitCircle.java, it is UnitCircleTest.java. That is the main teaching tool to aid in memorization of the unit circle**

a. sin(60°)

To solve this problem, you would use the unit circle illustration and take the y coordinate point for the angle 60º.
By doing so, you would find the correct answer 1/2
https://imgur.com/iwRM87Z

f. cos(540°)

To solve this problem, you would use the unit circle illustration and take the x coordinate point for the angle at 180º, which is 540 - 360.
You can see from the illustration that the correct answer would be -1, since it is in the -1 position on the coordinate plane. Unfortunately this point is unlabeled.

b. cos(225°)

To solve this problem, you would use the unit circle illustration and take the x coordinate point for the angle 225º.
By doing so, you would find the correct answer √2/2
https://imgur.com/gNnNshF

g. tan(-450°)

To solve this problem, you would use the unit circle illustration and take the x and y coordinate points for the angle 270º.
You would find this out by adding 360º to 450º to get -90º, then subracting 90º from 360º to get 270º.
After that you would take the x and y coordinates of 270º, and knowing that tan = sin/cos and that x = cos and y = sin you would divide y/x, getting the tangent value.
You can see from the illustration that the correct answer would be 0, since it is 0/1 and the x,y coordinates for the point 270º are (0,1) position on the coordinate plane. Unfortunately this point is unlabeled, but the values can be deduced from the illustration.

c. sin(300°)

To solve this problem, you would use the unit circle illustration and take the y coordinate point for the angle 300º.
By doing so, you would find the correct answer -1/2
https://imgur.com/WUrQHBI

h. sec(390°)

To solve this problem, you would subtract 360 from 390 to get 30º, find the cosine x value using the unit circle illustration for 30º, then multiply that value by it's reciprocol to find the correct answer that is 2/√3

d. tan(315°)

i. csc(-120°)

e. sin(-135°)

j. cot(210°)
