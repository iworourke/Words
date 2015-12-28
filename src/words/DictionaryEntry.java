/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package words;
/**
 * Dictionary Entry object contains only a word instance, but I expect this to
 * change over time. 
 * @author iworourke
 */
public class DictionaryEntry implements Comparable<DictionaryEntry> {
    
    private Word word;
    
    public DictionaryEntry() {
        word = new Word();
    }
    
    public DictionaryEntry(Word word) {
        this.word = new Word(word);
    }
    
    public DictionaryEntry(DictionaryEntry d) {
        this.word = d.getWord();
    }
    
    public Word getWord() {
        return word;
    }
    
    public void setWord(Word w) {
        word = new Word(w);
    }
    
    /**
     * 
     * @return 
     */
    public String getStringRepresentation() {
        String str = "";
        str = str.concat(word.getConventionalSpelling().toUpperCase() + " " + 
                word.getPhoneticRepresentation().toString());
        return str;
    }

    /**
     * 
     * @param other
     * @return 
     */    
    @Override public boolean equals(Object other) {
        boolean answer = false;
        if (other instanceof DictionaryEntry) {
            Word w1 = this.word;
            Word w2 = ((DictionaryEntry)other).getWord();
            if (w1.equals(w2)) {
                answer = true;
            }
        }
        return answer;
    }

    /**
     * 
     * @param o
     * @return 
     */
    @Override
    public int compareTo(DictionaryEntry o) {
        return this.getWord().compareTo(o.getWord());
    }
}
