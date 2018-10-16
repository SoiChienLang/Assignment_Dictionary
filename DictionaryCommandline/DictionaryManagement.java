
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SoisChiensBinhs
 */
public class DictionaryManagement {
    Scanner inp = new Scanner(System.in);
    public void insertFromFile() throws IOException{
        FileReader fileR = new FileReader("dictionaries.txt");
        BufferedReader reader = new BufferedReader(fileR);
        
        String line;
        while((line = reader.readLine()) != null){
            String []word_line = line.split("\t");
            String target = word_line[0];
            String explain = word_line[3];
            Word word = new Word(target, explain);
            Dictionary.list.add(new Word(target, explain));
        }
    }
    public boolean dictionaryLookup(ArrayList<Integer> listIndex){
        System.out.print("Enter word you want to translate: ");
        String target = inp.nextLine();
        for(Word word: Dictionary.list){
            if(word.getWord_target().equals(target)){
                System.out.println("English\t\tVietnamese");
                System.out.println(word.toString());
                return true;
            }
            if(word.getWord_target().startsWith(target))
                listIndex.add(Dictionary.list.indexOf(word));
        }
        return false;
    }
    public void insert(){
        System.out.print("Write target word: ");
        String target = inp.nextLine();
        System.out.print("Write explain of that word: ");
        String explain = inp.nextLine();
        Word word = new Word(target, explain);
        Dictionary.list.add(word);
        System.out.println("Added Success!");
    }
    public void update(){
        System.out.print("Write the word which you want to update: ");
        String target = inp.nextLine();
        for(Word word: Dictionary.list){
            if(target.equals(word.getWord_target())){
                System.out.print("Change word to: ");
                String change_word = inp.nextLine();
                System.out.print("Change explain to: ");
                String change_explain = inp.nextLine();
                word.setWord_target(change_word);
                word.setWord_explain(change_explain);
                System.out.println("Changed Success!");
                return;
            }
        }
        System.out.println("Don't find the word!");
        System.out.print("Do you want to continue: Y/N ?");
        String choise = inp.nextLine();
        if(choise.equals("Y")|| choise.equals("y"))
            update();
        else
            return;
    }
    public void delete(){
        System.out.println("Write the word which you want to delete");
        String target = inp.nextLine();
        for(Word word: Dictionary.list){
            if(target.equals(word.getWord_target())){
                Dictionary.list.remove(word);
                System.out.println("Remove Success!");
                return;
            }
        }
        System.out.println("Don't find the word!");
        System.out.print("Do you want to continue: Y/N?");
        String choise = inp.nextLine();
        if(choise.equals("Y") || choise.equals("y"))
            delete();
        else 
            return;
    }
    public void exportToFile() throws IOException{
        BufferedWriter writer = new BufferedWriter(new FileWriter("dictionaries.txt"));
        for(Word word: Dictionary.list){
            String line = word.getWord_target() + "\t" + "default" + "\t" + "default" + "\t" + word.getWord_explain() + "\n";
            writer.write(line);
        }
        writer.close();
    }
}
