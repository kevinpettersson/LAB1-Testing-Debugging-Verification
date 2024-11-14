package ex1;
import java.util.*;
import java.util.function.IntBinaryOperator;

public class Set {
  private ArrayList<Integer> a;

  public Set() {
    a = new ArrayList<Integer>();
  }


  public int[] toArray() {
    int[] ia = new int[a.size()];
    for (int i = 0; i < ia.length; i++) {
      ia[i] = a.get(i);
    }
    return ia;
  }

  public void insert(int x) {
    for (int i = 0; i < a.size(); i++) {
      if(!a.contains(x)){
        if (a.get(i) > x) {
          a.add(i, x);
          break;
      }
      } else {
        if (a.get(i) == x) {
          break;
        }
      }
    }
    if (!a.contains(x)) {
      a.add(x);
    }
  }

  public boolean member(int x) {
    for (int i = 0; i < a.size(); i++) {
      if (a.get(i) > x) {
        return false;
      } else {
        if (a.get(i) == x) {
          return true;
        }
      }
    }
    return false;
  }

  public void intersect(Set s) {
    for(int i = 0; i < a.size();) {
      if (s.a.contains(a.get(i))){
        i++;
      } else{
        a.remove(a.get(i));
      }
    }
  }

  // Try with:
  //   (a, b) -> a + b;
  //   (a, b) -> a - b;
  public boolean distinctClosed(IntBinaryOperator f) {
    if(a.size() <= 1){
      return true;
    }
    int vi,vj;
    for (int i = 0; i < a.size(); i++) {
      for (int j = 0; j < a.size(); j++) {
        vi = a.get(i);
        vj = a.get(j);
        if(vi != vj){
          if (!(member(f.applyAsInt(vi, vj)))) return false;
        }
      }
    }
    return true;
  }
}
