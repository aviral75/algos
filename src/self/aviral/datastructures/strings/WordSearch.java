package self.aviral.datastructures.strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import self.aviral.datastructures.strings.Trie.TrieNode;

public class WordSearch {
	public int m, n;
    public int[] dx = {-1, 1, 0, 0};
    public int[] dy = {0, 0, -1, 1};
    public List<String> findWords(char[][] board, String[] words) {
        List<String> list = new ArrayList<>();
        if(board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) return list;
        Trie tree = new Trie();
        for(String word : words){
            tree.insert(word);
        }
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                dfs(set, board, visited, i, j, tree.getRoot());
            }
        }
        list.addAll(set);
        return list;
    }
    public void dfs(Set<String> list, char[][] board, boolean[][] visited, int x, int y, TrieNode root){
        if(root.word != null){
            list.add(root.word);
        }
        
        if(x < 0 || x >= m || y < 0 || y >= n || visited[x][y] || root.children[board[x][y]-'a']==null) return;
        root = root.children[board[x][y]-'a'];
        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            visited[x][y] = true;
            dfs(list, board, visited, nx, ny, root);
            visited[x][y] = false;
        }
    }
    
 public static void main(String[] args) {
	 char[][] board = {
			 {'o','a','a','n'},
			 {'e','t','a','e'},
			 {'i','h','k','r'},
			 {'i','f','l','v'}
			 };
	 String[] words = new String[] {"oath","pea","eat","rain"};
	 
	 new WordSearch().findWords(board, words).stream().forEach(e->System.out.println(e));
	        
	        
}
}
