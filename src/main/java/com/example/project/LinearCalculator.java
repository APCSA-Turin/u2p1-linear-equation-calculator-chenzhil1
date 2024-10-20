package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    int x1 = 0;
    int x2 = 0;
    int y1 = 0;
    int y2 = 0;


    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coord1, String coord2){ // <--add 2 string parameters to this constructor
        if(coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf("(") + 2).equals("-")) {
            x1 = Integer.parseInt((coord1.substring(coord1.indexOf("(") + 2, coord1.indexOf(",")))) * -1;

        }
        else{
            x1 = Integer.parseInt((coord1.substring(coord1.indexOf("(") + 1, coord1.indexOf(","))));

        }  
        if(coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf("(") + 2).equals("-")) {
            x2 = Integer.parseInt((coord2.substring(coord2.indexOf("(") + 2, coord2.indexOf(",")))) * -1;

        }
        else {
            x2 = Integer.parseInt((coord2.substring(coord2.indexOf("(") + 1, coord2.indexOf(",")))); 

        }
        if(coord1.substring(coord1.indexOf(",") + 1, coord1.indexOf(",") + 2).equals("-")) {
            y1 = Integer.parseInt((coord1.substring(coord1.indexOf(",") + 2, coord1.indexOf(")")))) * -1;

        }
        else {
            y1 = Integer.parseInt((coord1.substring(coord1.indexOf(",") + 1, coord1.indexOf(")"))));

        }
        if(coord2.substring(coord2.indexOf(",") + 1, coord2.indexOf(",") + 2).equals("-")) {
            y2 = Integer.parseInt((coord2.substring(coord2.indexOf(",") + 2, coord2.indexOf(")")))) * -1;

        }
        else {
            y2 = Integer.parseInt((coord2.substring(coord2.indexOf(",") + 1, coord2.indexOf(")"))));
        }

    }

    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){
        return x1;
    
    }
    public int getY1(){
        return y1;
    
    }
    public int getX2(){
        return x2;
    
    }
    public int getY2(){
        return y2;

    }

    public void setX1(int x){
        this.x1 = x;

    }
    public void setY1(int y){
        this.y1 = y;

    }
    public void setX2(int x){
        this.x2 = x;

    }
    public void setY2(int y){
        this.y2 = y;

    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double xDistance = x2 - x1;
        double yDistance = y2 - y1;
        double distance = Math.sqrt(Math.pow(xDistance, 2) + Math.pow(yDistance, 2));
        return roundedToHundredth(distance);
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double yInt = y1 - (slope() * x1); 
        if(slope() == -999.99) {
            yInt = -999.99;
        }
        return roundedToHundredth(yInt) ;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double xDistance = x2 - x1;
        double yDistance = y2 - y1;

        if(!(xDistance == 0)){
            double slope = (double) yDistance / (double) xDistance;
            return roundedToHundredth(slope);

        }
        else {
            return -999.99;
        }

    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if(slope() == -999.99){
            return "undefined";
        }
        if(!(yInt() == 0)){
            if(slope() == 0){
                String equation = "y=" + yInt();
                return equation;

            }
            if(yInt() < 0) {
                String equation = "y=" + slope() + "x" + yInt();
                return equation;
            }
            else{
                String equation = "y=" + slope() + "x+" + yInt();
                return equation;
            }


        }
        else{
            String equation = "y=" + slope() + "x";
            return equation;
        }

    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        double rounded = Math.round(x * 100) / (double) 100;
        return rounded;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: ";
        str += "\nThe slope of this line is: ";
        str += "\nThe y-intercept of the line is: ";
        str += "\nThe distance between the two points is: ";
 
        return str;
    }



}