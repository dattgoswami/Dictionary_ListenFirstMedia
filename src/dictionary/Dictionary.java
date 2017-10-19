package dictionary;

import java.util.*;

public class Dictionary {
	
	public HashMap<String, DictEntry> dictMap;
		
	public Dictionary(){
		this.dictMap = new HashMap<>();
	}
	// this method adds the word and its meaning
	public void addWord_Meaning(String word, String meaning){
		if(!dictMap.containsKey(word)){
			//we create the object of the DictEntry which stores the word and its meaning
			DictEntry newEntry = new DictEntry(word,meaning);
			//we add the word and its DictEntry (data object) in the HashMap object of this class
			dictMap.put(word,newEntry);
		}
	}
	// this method adds the word and its synonym (adding one synonym at a time)
	public void addSynonym(String word, String synonym){
		if(dictMap.containsKey(word)){
			dictMap.get(word).getSynonyms().add(synonym);
		}
		
	}
	// this method displays the meaning of each word
	public String viewMeaning(String word){
		if(!dictMap.containsKey(word)){
			System.out.println("Word is not in dictionary");
			return null;
		}
		else{
			return dictMap.get(word).meaning;
		}
	}
	
	public ArrayList<String> viewSynonym(String word){
		if(this.dictMap == null && this.dictMap.size() <0)
			return null;
		
		ArrayList<String> display = new ArrayList<>();
		
		getSynonymRecur(word,display);
		display.remove(word);
		return display;
		
				
	}
	
	// get the synonyms of the given word by checking transitive and commutative relations
	public ArrayList<String> getSynonymRecur(String word, ArrayList<String> display){
		// check if the word is there in the dictionary
		if(this.dictMap.containsKey(word)){
			HashSet<String> temp = this.dictMap.get(word).synonyms;
			for(String str : temp){
				// if synonym is not there in display list add it and then recurrse inside
				if(!display.contains(str)){
					display.add(str);
					getSynonymRecur(str,display);
				}
			}
			
		}
		
		// word is not there as a key in dictionary traverse each words synonym set store the synonym in display list
		
			for(String str : this.dictMap.keySet()){
				HashSet<String> tempSet = this.dictMap.get(str).synonyms;
				// check word in synonym set
				if(tempSet.contains(word)){
					ArrayList<String> tempList = new ArrayList<>(tempSet);
					// remove the given word from list
					tempList.remove(word);
					tempList.add(str);
					for(String str2 : tempList){
						if(!display.contains(str2)){
							display.add(str2);
							getSynonymRecur(str2,display);
						}
					}
				}
			
		}
			return display;
	}
	
	//public static void main(String[] args) {
		
		// for testing while creating the dictionary
		
		/*Dictionary dict = new Dictionary();
		
		dict.addWord_Meaning("beautiful", "pleasing the senses or mind aesthetically");
		dict.addSynonym("beautiful","gorgeous");
		dict.addSynonym("beautiful","pretty");
		dict.addSynonym("beautiful","handsome");
		dict.addSynonym("beautiful","good-looking");
		dict.addSynonym("beautiful","alluring");
		dict.addSynonym("beautiful","preprossessing");	
		
		dict.addWord_Meaning("gorgeous","very attractive");
		dict.addSynonym("gorgeous","lovely");
		
		System.out.println("Meaning");
		String means = dict.viewMeaning("beautiful");
		System.out.println(means);
		System.out.println("Synonyms");
		
		ArrayList<String> temp = dict.viewSynonym("beautiful");
		System.out.println(temp);*/
		
	//}
}


class DictEntry{
	/*key = word e.g. beautiful
	 *meaning = meaning of the word
	 *synonyms = contains all the synonyms for the current word
	 *it has the getter and setter methods for all the variables
	 */
	public String key; 
	public String meaning;
	public HashSet<String> synonyms;

	public DictEntry(){
		
	}
	
	public DictEntry(String key, String meaning){
		this.key = key;
		this.meaning = meaning;
		this.synonyms = new HashSet<>();
	}
	
	public DictEntry(String key, String meaning, HashSet<String> synonyms){
		this.key = key;
		this.meaning = meaning;
		this.synonyms = synonyms;
	}
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getMeaning() {
		return meaning;
	}
	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}
	public HashSet<String> getSynonyms() {
		return synonyms;
	}
	public void setSynonyms(HashSet<String> synonyms) {
		this.synonyms = synonyms;
	}
	
}
