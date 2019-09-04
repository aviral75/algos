package self.aviral.datastructures.strings;

public class Trie {
	class TrieNode{
        public TrieNode[] children;
        public String word;
        public TrieNode(){
        	this.children=new TrieNode[26];
            this.word = null;
        }
        
        @Override
        public String toString() {
        	return word;
        }
    }
    
       private  TrieNode root;
        public Trie(){
            root = new TrieNode();
        }
        public void insert(String word){
            TrieNode node = root;
            for(char c : word.toCharArray()){
                if(node.children[c-'a']==null){
                    node.children[c-'a']=new TrieNode();
                }
                node = node.children[c-'a'];
            }
            node.word = word;
        }
        
        public TrieNode getRoot() {
        	return root;
        }
    
}
