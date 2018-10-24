
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

    public void insertFromFile() throws IOException {
        FileReader fileR = new FileReader("dictionaries.txt");
        BufferedReader reader = new BufferedReader(fileR);

        String line;
        while ((line = reader.readLine()) != null) {
            String[] word_line = line.split("\t");
            String target = word_line[0];
            String type = word_line[1];
            String pronun = word_line[2];
            String explain = word_line[3];
            Word word = new Word(target, explain, type, pronun);
            Dictionary.list.add(word);
        }
    }

    public boolean dictionaryLookup(ArrayList<Integer> listIndex) {
        System.out.print("Enter word you want to translate: ");
        String target = inp.nextLine();
        for (Word word : Dictionary.list) {
            if (word.getWord_target().equals(target)) {
                System.out.println("English\t\tVietnamese");
                System.out.println(word.toString());
                return true;
            }
            if (word.getWord_target().startsWith(target)) {
                listIndex.add(Dictionary.list.indexOf(word));
            }
        }
        return false;
    }

    public void insert(Word newWord) {
        Dictionary.list.add(newWord);
        exportToFile();
    }
    public boolean exist(String word){
        if(Gui.allList.contains(word)) 
            return true;
        else 
            return false;
    }
    public void update(Word old_word, Word new_word) {
        for (Word word : Dictionary.list) {
            if (word.equals(old_word)) {
                old_word.setWord_target(new_word.getWord_target());
                old_word.setWord_explain(new_word.getWord_explain());
                old_word.setType(new_word.getType());
                old_word.setPronun(new_word.getPronun());
                exportToFile();
                return;
            }
        }
    }

    public void delete(Word word) {
        int index = Dictionary.list.indexOf(word);
        Dictionary.list.remove(index);
        exportToFile();
    }

    public void exportToFile() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("dictionaries.txt"));
            for (Word word : Dictionary.list) {
                String line = word.getWord_target() + "\t" + word.getType() + "\t" + word.getPronun() + "\t" + word.getWord_explain() + "\n";
                writer.write(line);
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}
