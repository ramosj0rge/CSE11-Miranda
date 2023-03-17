import tester.*;
import java.util.List;
import java.util.Arrays;
import java.util.Comparator;
import java.util.ArrayList;

class Point {
  int x, y;
  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
  double distance(Point other) {
    return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
  }
}

class PointCompare implements Comparator<Point>{
  Point first;
  Point other;

  PointCompare(Point first, Point other){
    this.first = first;
    this.other = other;
  }

  public int compare(Point first, Point other){
    if(first.y < other.y){
      return -1; //if y  is less than other y
    }
    else if(first.y == other.y){
      if(first.x < other.x){
        return -2; // if y are the same but x is less than other x
      }
      else if(first.x == other.x){
        return 0; //if both y and x are the same
      }
      else{
        return 2; //if y is the same but x is greater
      }
    }
    return 1; //if y is greater
  }
}

class PointDistanceCompare implements Comparator<Point>{
  
}

