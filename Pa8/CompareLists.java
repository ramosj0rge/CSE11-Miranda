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

  public int compare(Point first, Point other){
    if(first.y < other.y){return -1;}
    else if(first.y > other.y) {return 1;}
    else if(first.x < other.x){return -1;}
    else if(first.x > other.x) {return 1;}
    else{return 0;}
  }
}

class PointDistanceCompare implements Comparator<Point>{
  Point origin = new Point(0,0);

  public int compare(Point o1, Point o2) {
    if(o1.distance(origin) < o2.distance(origin)){
      return -1; // return -1 if first point is closer
    }
    else if(o1.distance(origin) > o2.distance(origin)){
      return 1; //return 1 if first point is farther
    }
    else{return 0;}//return 0 if both distance are same
  }
}

class StringCompare implements Comparator<String>{
  public int compare(String o1, String o2) {
    if(o1.compareTo(o2) < 0){
      return -1;
    }
    else if (o1.compareTo(o2) > 0){
      return 1;
    }
    
    return 0;
  }
}

class StringLengthCompare implements Comparator<String>{
  public int compare(String o1, String o2){
    if(o1.length() < o2.length()){
      return -1;
    }
    else if(o1.length() > o2.length()){
      return 1;
    }
    else{
      return 0;
    }
  }
}

class BooleanCompare implements Comparator<Boolean>{
  public int compare(Boolean o1, Boolean o2) {
    if(o1 == true && o2 == false){
      return 1;
    }
    else if(o1 == false && o2 == true){
      return -1;
    }
    return 0;
  }

}

class CompareLists<E>{
  static <E> E minimum(List<E> list, Comparator<E> c) {
    if (list.size() == 0) {
      return null;
    }
    E min = list.get(0);
    for (int i = 0; i < list.size(); i++) {
      if (c.compare(list.get(i), min) < 0) {
        min = list.get(i);
      } 
    }
    return min;
  }

  static <E> E minimum(E[] over, Comparator<E> c){
    if(over.length == 0){
      return null;
    }
    E small = over[0];
    for(int i = 0; i < over.length; i++){
      if(c.compare(over[i], small) < 0){
        small = over[i];
      }
    }
    return small;
  }
  
  static <E> List<E> greaterThan(List<E> list, Comparator<E> c, E element){
    List<E> newlist = new ArrayList<>();
    for(int i = 0; i < list.size(); i++){
      if(c.compare(list.get(i), element) > 0){
        newlist.add(list.get(i));
      }
    }
    return newlist;
  }

  static <E> boolean inOrder(List<E> list, Comparator<E> c){
    boolean order = true;
    if(list.contains(null)){
      throw new IllegalArgumentException("null value in list");
    }
    else if(list.size() <= 1){
      return order;
    }
    else{
      for(int i = 0; i < list.size(); i++){
        if(c.compare(list.get(i), list.get((i) - 1)) < 0){
          order = false;
          break;
        }
      }
    }
    return order;
  }
  static <E> boolean inOrder(E[] overlist, Comparator<E> c){
    boolean order = true;
    /* if(overlist.length <= 1){
      return order;
    } */

    for(int i = 0; i < overlist.length; i++){
      if(overlist[i] == null){
        throw new IllegalArgumentException("null value in list");
      }
      else if(c.compare(overlist[i], overlist[i-1]) < 0){
        order = false;
        break;
      }
    }
    return order;
  }
  static <E> List<E> merge(Comparator<E> c, List<E> firstList, List<E> secondList) throws IllegalAccessException{
    if(firstList.contains(null)){
      throw new IllegalArgumentException("null value in list");
    }
    if(secondList.contains(null)){
      throw new IllegalAccessException("null value in list");
    }
    List<E> newList = new ArrayList<>();
    for(int i = 0; i < firstList.size(); i++){
      newList.add(firstList.get(i));
    }
    for(int i = 0; i < secondList.size(); i++){
      newList.add(secondList.get(i));
    }
    newList.sort(c);
    return newList;

  }

}

class Testing{
  
  void testPointCompare(Tester t){

    PointCompare comparingPoints = new PointCompare();
    Point point1 = new Point(2,2);
    Point point2 = new Point(10,10);
    Point point3 = new Point(5,5);

    t.checkExpect(comparingPoints.compare(point2, point1), 1);
    t.checkExpect(comparingPoints.compare(point2, point2), 0);
    t.checkExpect(comparingPoints.compare(point1, point1), 0);
    t.checkExpect(comparingPoints.compare(point3, point1), 1);


  }

  void testPointDistanceCompare(Tester t){
    PointDistanceCompare comparingDistance = new PointDistanceCompare();
    Point point1 = new Point(2,1);
    Point point2 = new Point(10,10);
    Point point3 = new Point(5,4);

    t.checkExpect(comparingDistance.compare(point1, point2), -1);
    t.checkExpect(comparingDistance.compare(point1, point1), 0);
    t.checkExpect(comparingDistance.compare(point3, point2), 1);
    t.checkExpect(comparingDistance.compare(point3, point1), -1);
  }

  void testStringCompare(Tester t){
    StringCompare comparingStrings = new StringCompare();

    String smallstring = "I'm tired";
    String mediumstring = "The Beatles are good";
    String longstring = "I want to play videogames at this moment";
    t.checkExpect(comparingStrings.compare(smallstring, longstring), 1);
    t.checkExpect(comparingStrings.compare(smallstring, smallstring), 0);
    t.checkExpect(comparingStrings.compare(longstring,longstring), 0);
    t.checkExpect(comparingStrings.compare(mediumstring, mediumstring), 0);


  }
  void testStringLengthCompare(Tester t){
    StringLengthCompare compareLength = new StringLengthCompare();

    String smallstring = "Hey Jude";
    String mediumstring = "I want to hold your hand";
    String longstring = "Sgt. Pepper's Lonely Hearts Club Band (remastered)";
    t.checkExpect(compareLength.compare(smallstring, longstring), -1);
    t.checkExpect(compareLength.compare(smallstring, smallstring), 0);
    t.checkExpect(compareLength.compare(longstring,longstring), 0);
    t.checkExpect(compareLength.compare(longstring, mediumstring), 1);

  }
  
  void testBooleanCompare(Tester t){
    BooleanCompare boolcompare = new BooleanCompare();

    t.checkExpect(boolcompare.compare(false, true), -1);
    t.checkExpect(boolcompare.compare(true, true), 0);
    t.checkExpect(boolcompare.compare(true, false), 1);
    t.checkExpect(boolcompare.compare(false, false), 0);

  }

}

