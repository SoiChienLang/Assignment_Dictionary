
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
public class DictionaryCommandLine {
    Scanner inp = new Scanner(System.in);
    DictionaryManagement dicman = new DictionaryManagement();
    public DictionaryCommandLine() throws IOException {
        dicman.insertFromFile();
    }
    
    
    public void showAllWord(){
        System.out.println("No \t English \t\t | Vietnamese");
        int no = 1;
        for(Word word: Dictionary.list){
            System.out.println(no + "\t|" + word.getWord_target() + "\t\t|" + word.getWord_explain() + "\n");
            no++;        
        }
    }
    public void dictionarySeacher(){
        ArrayList<Integer> listIndex = new ArrayList<>();
        boolean finded = dicman.dictionaryLookup(listIndex);
        if(!finded && listIndex.size() > 0){
            System.out.println("List word: ");
            for(int i = 0 ; i < listIndex.size(); i++){
                System.out.println((i + 1) + ": " + Dictionary.list.get(listIndex.get(i)).getWord_target());
            }
            System.out.print("Choise your word: ");
            
            int choise = 0;
            try {
                choise = inp.nextInt();
            } catch (Exception e) {
                System.out.println("Error choise! ReEnter");
                dictionarySeacher();
            }
            System.out.println("English\t\tVietnamese");
            System.out.println(Dictionary.list.get(listIndex.get(choise - 1)).toString());
        }
        else if(listIndex.size() == 0 && !finded){
            System.out.println("The word is not exist!");
            return;
        }
            
    }
    public void dictionaryAdvanced() throws IOException{
        System.out.println("Menu choise: ");
        System.out.println("1: Translate.");
        System.out.println("2: Insert word.");
        System.out.println("3: Delete word.");
        System.out.println("4: Update word.");
        System.out.println("5: Show all word.");
        System.out.println("6: Quit.");
        System.out.print("Please your choise: ");
        String choise = inp.nextLine();
        String choises = "Y";
        switch(choise){
            case "1":
                while("Y".equals(choises)||"y".equals(choises)){
                    dictionarySeacher();
                    System.out.print("Do you want to continue: Y/N?");
                    inp = new Scanner(System.in);
                    choises = inp.nextLine();
                }
                dictionaryAdvanced();
                break;
            case "2":
                while("Y".equals(choises)||"y".equals(choises)){
                    dicman.insert();
                    System.out.print("Do you want to continue: Y/N?");
                    choises = inp.nextLine();
                }
                dictionaryAdvanced();
                break;
            case "3":
                while("Y".equals(choises)||"y".equals(choises)){
                    dicman.delete();
                    System.out.print("Do you want to continue: Y/N?");
                    choises = inp.nextLine();
                }
                dictionaryAdvanced();
                break;
            case "4":
                while("Y".equals(choises)||"y".equals(choises)){
                    dicman.update();
                    System.out.print("Do you want to continue: Y/N?");
                    choises = inp.nextLine();
                }
                dictionaryAdvanced();
                break;
            case "5":
                showAllWord();
                dictionaryAdvanced();
                break;
            case "6":
                System.exit(0);
                break;
        }
    }
}
