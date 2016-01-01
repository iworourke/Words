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
    
    /**
     * Default constructor.
     */
    public DictionaryEntry() {
        word = new Word();
    }
    
    /**
     * Constructor.
     * @param word Word object used to initialize this instance.
     */
    public DictionaryEntry(Word word) {
        this.word = new Word(word);
    }
    
    /**
     * Constructor used to make copies of DictionaryEntry objects.
     * @param d the dictionary entry to be copied. 
     */
    public DictionaryEntry(DictionaryEntry d) {
        this.word = d.getWord();
    }
    
    /**
     * Getter for the word attribute.
     * @return the word attribute.
     */
    public Word getWord() {
        return word;
    }
    
    /**
     * Setter for the word attribute
     * @param w new value for the word attribute.
     */
    public void setWord(Word w) {
        word = new Word(w);
    }
    
    /**
     * Builds and returns a string representation of the word that can be used
     * to create a textual representation of the word in a dictionary text file.
     * @return A string representation of this word's contextual and phonetic 
     * spellings.
     */
    public String getStringRepresentation() {
        String str = "";
        str = str.concat(word.getConventionalSpelling().toUpperCase() + " " + 
                word.getPhoneticRepresentation().toString());
        return str;
    }

    /**
     * Indicates whether some object is equal to 'this' DictionaryEntry object.
     * @param other the reference object with which to compare.
     * @return true if this DictionaryEntry is the same as the 'other' argument; false
     * otherwise.
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
     * Used to create an ordering of DictionaryEntry objects.
     * @param o DictionaryEntry object with which to compare this instance.
     * @return an integer <0, =0, xor >0 depending on whether this instance
     * comes before, at, or after (respectively) the index of the other 
     * DictionaryEntry object.
     */
    @Override
    public int compareTo(DictionaryEntry o) {
        return this.getWord().compareTo(o.getWord());
    }
}
