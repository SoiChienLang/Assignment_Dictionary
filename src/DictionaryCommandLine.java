
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SoisChiensBinhs
 */
public class DictionaryCommandLine {
    Scanner inp = new Scanner(System.in);
    DictionaryManagement dicman = new DictionaryManagement();
    public DictionaryCommandLine() {
        dicman = new DictionaryManagement();
        try {
            dicman.insertFromFile();
        } catch (IOException ex) {
            Logger.getLogger(DictionaryCommandLine.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    static public ArrayList<Word> dictionarySeacher(String search){
        ArrayList<Word> listSearch = new ArrayList<>();
        for(int i = 0 ; i < Dictionary.list.size(); i++){
            Word word = Dictionary.list.get(i);
            if(word.getWord_target().startsWith(search)){
                listSearch.add(word);
            }
        }
        return listSearch;
    }
    public ArrayList<String> init(){
        ArrayList<String> listAll = new ArrayList<>();
        for(int i = 0 ; i < Dictionary.list.size() ; i++){
            listAll.add(Dictionary.list.get(i).getWord_target());
        }
        return listAll;
    }
}
