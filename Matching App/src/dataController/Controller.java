/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dataController;

import helper.Helper;
import java.util.*;

/**
 *
 * @author Sai Lin Htet
 */
public class Controller {
    public static List<String[]> findvalueFromArr(List<String[]> List, String field, String target,Integer[] range) {

        List<String[]> found = new ArrayList<String[]>();
        int index = Helper.fieldToIndex(field);
        for (int i = 0; i < List.size(); i++) {
            String[] arr = List.get(i);
            if(range.length>0){
                try {
                    if(range[0]<= Integer.parseInt(arr[index]) && range[1]>= Integer.parseInt(arr[index])){
                found.add(List.get(i));
                }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }
            
            if (!(target.isEmpty()) && arr[index].equalsIgnoreCase(target)) {
                found.add(List.get(i));
            }
        }
        return found;
    }
    public static ArrayList<String> getRecord(List<String[]> list, String id) {
    for (String[] row : list) {
        if (id.equals(row[0])) {
            String[] parts = row[1].split("\\|", -1);
            return new ArrayList<>(Arrays.asList(parts));
        }
    }
    return new ArrayList<>();
}
    public static String getNewId(List<String[]> List) {
        try {
            String id = List.get(List.size() - 1)[0] ;
           int integer= Integer.parseInt(id);
            return String.valueOf(integer+1);
        } catch (NumberFormatException e) {
            return "1";
        }
    }
    public static String[] getArrRecord(String text) {
       return text.split("|",-1);
    }
}
