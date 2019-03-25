/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author manan
 */
public class ArraySearch {
    int i;
public int searchArray(long arr[],long id){
    for( i=0;i<arr.length;i++){
        if(arr[i]==id)
            break;
    }
    return i;
}
}
