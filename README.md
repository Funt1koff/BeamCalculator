# BeamCalculator
## Description :
This microservice is designed for design engineers in the field of construction and space technology. It allows you to quickly and conveniently solve the simplest problems in the field of material resistance.

In other words, this microservice solves the problem of a statically definable beam. Displays diagrams of transverse forces and bending moments.

The application is provided with information about the beam (length, cross-sectional area, moments of inertia), loads (concentrated, distributed), boundary conditions (fastening on two supports or complete fastening).

At the output, the user receives graphs of transverse forces and bending moments.

## What is the resistance of materials?
Resistance of materials is a branch of mechanics, a discipline
that is studied in educational institutions with a technical focus. 
The resistance of materials has a specific calculation technique that requires analytical thinking and spatial imagination, 
therefore, with its help, it is possible to solve problems that theoretical mechanics cannot cope with.

### Which beams does the application solve?
#### 1) Simple beams on two supports
*![Which beams does the application solve?](http://sopromat.xyz/static/lectures/2161/balka.PNG)
#### 2) Cantilever beams
*![Which beams does the application solve?](http://sopromat.xyz/static/lectures/2161/cantilever-beam.PNG)

### Types of load
#### 1) Concentrated force (F)
The simplest load. Has an application coordinate and a value.
*![Concentrated force(F)](https://isopromat.ru/wp-content/uploads/is-1172.png)
#### 2) Concentrated moment (m)
The simplest a couple of forces. Has an application coordinate and a value.
*![Concentrated moment (m)](https://isopromat.ru/wp-content/uploads/is-1169.png)
#### 3) Distributed rectangular load (q)
The force is set as a load per unit length. It has a start coordinate and an end coordinate. 
The formulas calculate the equivalent concentrated force and the coordinate of the pressure center.
*![Distributed rectangular load (m)](https://isopromat.ru/wp-content/uploads/is-1175.png)
#### 3) Distributed triangular load (q)
The force is set as a load per unit length. It has a start coordinate and an end coordinate.
The formulas calculate the equivalent concentrated force and the coordinate of the pressure center.
*![Distributed rectangular load (m)](https://www.teoretmeh.ru/Stattest/c9_05.gif)

## Author
#### Sergey Funtikov. Java engeiner.
