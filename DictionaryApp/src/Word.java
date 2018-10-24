
import sun.print.PathGraphics;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author SoisChiensBinhs
 */
public class Word {
    private String word_target;
    private String word_explain;
    private String type;
    private String pronun;

    public Word(String word_target, String word_explain, String type, String pronun) {
        this.word_target = word_target;
        this.word_explain = word_explain;
        this.type = type;
        this.pronun = pronun;
    }
    
    public Word(){
        this.word_target = null;
        this.word_explain = null;
        this.type = null;
        this.pronun = null;
    }
    public String getWord_target() {
        return word_target;
    }

    public void setWord_target(String word_target) {
        this.word_target = word_target;
    }

    public String getWord_explain() {
        return word_explain;
    }

    public void setWord_explain(String word_explain) {
        this.word_explain = word_explain;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPronun() {
        return pronun;
    }

    public void setPronun(String pronun) {
        this.pronun = pronun;
    }
    
    @Override
    public String toString() {
        return this.word_target + "\t\t" + this.word_explain;
    }
    
}
