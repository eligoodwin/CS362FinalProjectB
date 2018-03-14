

import junit.framework.TestCase;

import java.net.URL;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {

    // /components of the url
    private URLComponent[] scheme;
    private void makeSchemeComponents(){
        scheme = new URLComponent[10];
        scheme[0] = new URLComponent("HTTP", true);
        scheme[1] = new URLComponent("https", true);
        scheme[2] = new URLComponent("ftp", true);
        scheme[3] = new URLComponent("mailto", true);
        scheme[4] = new URLComponent("file", true);
        scheme[5] = new URLComponent("data", true);
        scheme[6] = new URLComponent("irc", true);
        scheme[7] = new URLComponent("+http", true);
        scheme[8] = new URLComponent("1ftp", false);
        scheme[9] = new URLComponent("ht*tp", false);
    }

    private URLComponent[] authority;
    private void makeAuthorityComponents(){
        authority = new URLComponent[10];
        authority[0] = new URLComponent("bobdole:iambobdole@google.com", true);
        authority[1] = new URLComponent("Google.com", true);
        authority[2] = new URLComponent("Yahoo.org", true);
        authority[3] = new URLComponent("Myspace.gov", true);
        authority[4] = new URLComponent("Facebook.ru", true);
        authority[5] = new URLComponent("192.126.11.01:80", true);
        authority[6] = new URLComponent("Amazon.uk.co", true);
        authority[7] = new URLComponent("nevergonna@giveyouup.net",false);
        authority[8] = new URLComponent("%%^$%%.net:!!!!", false);
        authority[9] = new URLComponent("bobdole////iambobdole@google.com", false);
    }

    private URLComponent[] path;
    private void makePathComponents() {
        path = new URLComponent[10];
        path[0] = new URLComponent("", true);
    }

    private URLComponent[] query;
    private void makeQueryComponents(){
        query = new URLComponent[10];
        query[0] = new URLComponent("", true);

    }

    private URLComponent[] fragment;
    private void makeFragmentComponent(){
        fragment = new URLComponent[10];
        fragment[0] = new URLComponent("", true);
    }

    //make all the components
    public void makeAllComponents(){
        makeSchemeComponents();
        makeAuthorityComponents();
        makePathComponents();
        makeQueryComponents();
        makeFragmentComponent();
    }

    //test if the components together make a valid url
    public boolean validComponentCheck(int schemeIndex, int authorityIndex, int pathIndex, int queryIndex, int fragmentIndex){
        return scheme[schemeIndex].isValid() &&
                authority[authorityIndex].isValid() &&
                path[pathIndex].isValid() &&
                query[queryIndex].isValid() &&
                fragment[fragmentIndex].isValid();
    }


    //construct the url string from the desired components
    public String constructURL(int schemeIndex, int authorityIndex, int pathIndex, int queryIndex, int fragmentIndex){
        String testURL = scheme[schemeIndex] + "://" + authority[authorityIndex] + "/";
        //if the other indexes are not empty append them to the string
        if(pathIndex > 0){
            testURL += path[pathIndex];
        }
        if(queryIndex > 0){
            testURL += "?" + query[queryIndex];
        }
        if(fragmentIndex > 0){
            testURL += fragment[fragmentIndex];
        }
        return testURL;
    }


    public UrlValidatorTest(String testName) {
      super(testName);
   }

   
   
   public void testManualTest()
   {
//You can use this function to implement your manual testing	   
	   
   }
   
   
   public void testYourFirstPartition()
   {
	 //You can use this function to implement your First Partition testing	   

   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to 
   
   public void testIsValid()
   {
	   //You can use this function for programming based testing

   }
   


}
