
class TrieNode{

    TrieNode [] children;
    char ch;
    boolean endOfWord;
    int prefixCount;

    public TrieNode(char ch){
         children = new TrieNode[26];
         endOfWord=false;
         this.ch=ch;
    }

}

class MyTrie{
    TrieNode root;
    MyTrie(){
        root = new TrieNode('-');
    }

    void insert(String word){

        var cur=root;
        for(int i=0;i<word.length();i++){

             var currChar = word.charAt(i);
             var insertIndex = currChar-'a';
             if(cur.children[insertIndex]==null){
                  cur.children[insertIndex]= new TrieNode(currChar);
             }
             cur.prefixCount++;
             cur = cur.children[insertIndex];

        }
        cur.endOfWord = true;
        cur.prefixCount++;

    }

    boolean search(String key){
        var cur = root;
        int count=0;
        for(int i=0;i<key.length();i++){
            var currChar = key.charAt(i);
            var searchIndex = currChar-'a';

            if(cur.children[searchIndex]!=null){
                count++;
            }

            cur = cur.children[searchIndex];
        }
        return count==key.length()?true:false;
    }

    int startsWith(String prefix){

        var cur = root;
        int count=0;
        for(int i=0;i<prefix.length();i++){
            var currChar = prefix.charAt(i);
            var searchIndex = currChar-'a';



            cur = cur.children[searchIndex];
        }
        return  cur.prefixCount;
    }
}
public class TrieDemo {

    public static void testInsertSearch()
    {
        MyTrie myTrie = new MyTrie();
        myTrie.insert("meraj");
        if(myTrie.search("meraj")==true){
            System.out.println("Test testInsertSearch ran successfully");

        }else{
            System.out.println("Test testInsertSearch failed :(");
        }

    }

    public static void test1StartsWithCount()
    {
        MyTrie myTrie = new MyTrie();
        myTrie.insert("meraj");

        if( myTrie.startsWith("me")==1 ){
            System.out.println("Test test1StartsWithCount ran successfully");

        }else{
            System.out.println("Test test1StartsWithCount failed :(");
        }

    }

    public static void test2StartsWithCount()
    {
        MyTrie myTrie = new MyTrie();
        myTrie.insert("meraj");
        myTrie.insert("me");

        if( myTrie.startsWith("me")==2 ){
            System.out.println("Test test2StartsWithCount ran successfully");

        }else{
            System.out.println("Test test2StartsWithCount failed :(");
        }

    }



    public static void main(String args[]){


         testInsertSearch();
         test1StartsWithCount();
         test2StartsWithCount();
    }
}
