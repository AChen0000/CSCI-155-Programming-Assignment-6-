/*
Name: Ann C
Course: C155
Assignment: Programming Assignment 6
Purpose: This program calculates the great circle distance
between two points on Earth. The program repeats until
the user enters "end".
*/

import java.util.Scanner;

public class LocationDistance {
public static void main(String[] args) {

      Scanner input = new Scanner(System.in);

      double radius = 6371.01;
      while (true) {
          // question for first location degrees
          System.out.print("Enter point 1 (latitude and longitude) in degrees or type end: ");
          String first = input.nextLine();

          // stop loop when end is entered
          if (first.equalsIgnoreCase("end")) {
              System.out.println("It has ended! Bye!~");
              break;
          }

          // remove comma and split numbers
          first = first.replace(",", "");
          String[] p1 = first.split(" ");

          double lat1 = Double.parseDouble(p1[0]);
          double lon1 = Double.parseDouble(p1[1]);
          // for second degrees 
          System.out.print("Enter point 2 (latitude and longitude) in degrees: ");
          String second = input.nextLine();

          second = second.replace(",", "");
          String[] p2 = second.split(" ");

          double lat2 = Double.parseDouble(p2[0]);
          double lon2 = Double.parseDouble(p2[1]);

          // convert to radians
          lat1 = Math.toRadians(lat1);
          lon1 = Math.toRadians(lon1);
          lat2 = Math.toRadians(lat2);
          lon2 = Math.toRadians(lon2);

          // calculate distances 
          double d = radius * Math.acos(
                  Math.sin(lat1) * Math.sin(lat2)
                  + Math.cos(lat1) * Math.cos(lat2) * Math.cos(lon1 - lon2)
          );

          System.out.printf("The distance between the two points is %.4f km\n\n", d);
      }

      input.close();
  }
}
