package bjk.learn.java.barancev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Collections {

  public static void main(String[] args) {

//    String[] langs = new String[4];
    String[] langs = {"Java","C#","Python","Javascript"};
    List<String> languages = new ArrayList<String>();
//    List<String> languages = Arrays.asList("Java","C#","Python","Javascript");
    languages.add("Java");
    languages.add("Python");
    languages.add("C#");
    languages.add("Javascript");

    for (String language :
            languages) {
      System.out.println(language);
    }
    System.out.println();

//    for (int i = 0; i < languages.size(); i++) {
//      System.out.println(languages.get(i));
//    }

//    langs[0]="Java";
//    langs[1]="C#";
//    langs[2]="Python";
//    langs[3]="Javascript";

    for (int i = 0; i < langs.length; i++) {
      System.out.println("Я хочу выучить "+langs[i]);
    }


  }
}
