

import junit.framework.TestCase;
import org.junit.Test;

import java.beans.Transient;
import java.net.URL;

//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!

public class UrlValidatorTest extends TestCase {
    private UrlValidator theValidator;
    // /components of the url
    private static URLComponent[] scheme;

    private void makeSchemeComponents() {
        scheme = new URLComponent[10];
        scheme[0] = new URLComponent("http", true);
        scheme[1] = new URLComponent("https", true);
        scheme[2] = new URLComponent("ftp", true);
        scheme[3] = new URLComponent("mailto", true);
        scheme[4] = new URLComponent("file", true);
        scheme[5] = new URLComponent("data", true);
        scheme[6] = new URLComponent("irc", true);
        scheme[7] = new URLComponent("+http", false);
        scheme[8] = new URLComponent("1ftp", false);
        scheme[9] = new URLComponent("ht*tp", false);
    }

    private static URLComponent[] authority;

    private void makeAuthorityComponents() {
        authority = new URLComponent[10];
        authority[0] = new URLComponent("bobdole:iambobdole@google.com", true);
        authority[1] = new URLComponent("Google.com", true);
        authority[2] = new URLComponent("Yahoo.org", true);
        authority[3] = new URLComponent("Myspace.gov", true);
        authority[4] = new URLComponent("Facebook.ru", true);
        authority[5] = new URLComponent("192.126.11.01:80", true);
        authority[6] = new URLComponent("Amazon.uk.co", true);
        authority[7] = new URLComponent("nevergonna@giveyouup.net", false);
        authority[8] = new URLComponent("%%^$%%.net:!!!!", false);
        authority[9] = new URLComponent("bobdole////iambobdole@google.com", false);
    }

    private static URLComponent[] path;

    private void makePathComponents() {
        path = new URLComponent[10];
        path[0] = new URLComponent("", true);
        path[1] = new URLComponent("questions/1547891", true);
        path[2] = new URLComponent("wiki/Main_Page", true);
        path[3] = new URLComponent("en/about", true);
        path[4] = new URLComponent("groups", true);
        path[5] = new URLComponent("Theme-Park/Tickets", true);
        path[6] = new URLComponent("categories/13/dresses.html", true);
        path[7] = new URLComponent("/;aasjdk@[]ahk  :;", false);
        path[8] = new URLComponent("Hello world example here {}", false);
        path[9] = new URLComponent("{{{}}}|||^|^", false);
    }

    private static URLComponent[] query;

    private void makeQueryComponents() {
        query = new URLComponent[10];
        query[0] = new URLComponent("", true);
        query[1] = new URLComponent("q=stephen+hawking", true);
        query[2] = new URLComponent("search_in_description=1&q=lace+top", true);
        query[3] = new URLComponent("title=Hello_World", true);
        query[4] = new URLComponent("field1=value1", true);
        query[5] = new URLComponent("q=hello", true);
        query[6] = new URLComponent("q=2+2", true);
        query[7] = new URLComponent(": / @ **** [][]”” abaa ", false);
        query[8] = new URLComponent(";search@trueValue", false);
        query[9] = new URLComponent("/{{}}|||^^", false);

    }

    private static URLComponent[] fragment;

    private void makeFragmentComponent() {
        fragment = new URLComponent[10];
        fragment[0] = new URLComponent("", true);
        fragment[1] = new URLComponent("#menu", true);
        fragment[2] = new URLComponent("#twist", true);
        fragment[3] = new URLComponent("#thisismylifenow", true);
        fragment[4] = new URLComponent("#welcome", true);
        fragment[5] = new URLComponent("#finalthoughts", true);
        fragment[6] = new URLComponent("#thefirstnoel", true);
        fragment[7] = new URLComponent("//welcome", false);
        fragment[8] = new URLComponent("!!!thefifthnoel", false);
        fragment[9] = new URLComponent("...ergo....", false);
    }

    //make all the components
    private void makeAllComponents() {
        makeSchemeComponents();
        makeAuthorityComponents();
        makePathComponents();
        makeQueryComponents();
        makeFragmentComponent();
    }

    //test if the components together make a valid url
    public boolean validComponentCheck(int schemeIndex, int authorityIndex, int pathIndex, int queryIndex, int fragmentIndex) {
        return scheme[schemeIndex].isValid() &&
                authority[authorityIndex].isValid() &&
                path[pathIndex].isValid() &&
                query[queryIndex].isValid() &&
                fragment[fragmentIndex].isValid();
    }


    //construct the url string from the desired components
    public String constructURL(int schemeIndex, int authorityIndex, int pathIndex, int queryIndex, int fragmentIndex) {
        String testURL = scheme[schemeIndex].getComponentString() + "://" + authority[authorityIndex].getComponentString() + "/";
        //if the other indexes are not empty append them to the string
        if (pathIndex > 0) {
            testURL += path[pathIndex].getComponentString();
        }
        if (queryIndex > 0) {
            testURL += "?" + query[queryIndex].getComponentString();
        }
        if (fragmentIndex > 0) {
            testURL += fragment[fragmentIndex].getComponentString();
        }
        return testURL;
    }


    public UrlValidatorTest(String testName) {
        super(testName);
    }


    public void testManualTest() {
//You can use this function to implement your manual testing	   

    }


    public void testYourFirstPartition() {
        //You can use this function to implement your First Partition testing

    }

    public void testYourSecondPartition() {
        //You can use this function to implement your Second Partition testing

    }
    //You need to create more test cases for your Partitions if you need to

    public void testIsValid() {
        theValidator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        final int arrayLength = 10;
        //You can use this function for programming based testing
        makeAllComponents();
        int failCount = 0;
        int testCount = 0;
        //gross
        for (int a = 0; a < arrayLength; ++a) {
            for (int b = 0; b < arrayLength; ++b) {
                for (int c = 0; c < arrayLength; ++c) {
                    for (int d = 0; d < arrayLength; ++d) {
                        for (int e = 0; e < arrayLength; ++e) {
                            boolean expectedValidity = validComponentCheck(a, b, c, d, e);
                            String generatedUrl = constructURL(a, b, c, d, e);
                            boolean observeredValidity = theValidator.isValid(generatedUrl);
                            if (expectedValidity != observeredValidity) {
                                ++failCount;
                                System.out.printf("ERROR: \turl: %s\n" +
                                        "\texpected validity: %b\n" +
                                        "\tobserved validity: %b\n", generatedUrl, expectedValidity, observeredValidity
                                );
                                System.out.printf("iteration: %d scheme: %d authority: %d path: %d query: %d fragment: %d\n", testCount, a, b, c, d, e);
                            }
                            ++testCount;
                        }
                    }
                }
            }
        }
        if(failCount == 0) {
            System.out.printf("TOTAL TESTS: %d. ALL TESTS PASSED\n", testCount);
        }
        else{
            System.out.printf("TOTAL TESTS: %d. TESTS FAILED: %d\n", testCount, failCount);
        }
    }


    public void testScheme(){
        makeAllComponents();
        theValidator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        int failCount = 0;
        for(int i = 0; i < scheme.length; ++i){
            boolean result = theValidator.isValidScheme(scheme[i].getComponentString());
            if(result != scheme[i].isValid()){
                ++failCount;
                System.out.printf("ERROR: scheme: %s expected: %b observed: %b\n", scheme[i].getComponentString(), scheme[i].isValid(),result);
            }
        }

        if(failCount > 0){
            System.out.printf("ERROR COUNT: %d", failCount);
        }
        else{
            System.out.println("All cases passed");
        }
    }

    public void testAuthority(){
        makeAllComponents();
        theValidator = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
        int failCount = 0;

        for(int i = 0; i < authority.length; ++i){

            String testString = authority[i].getComponentString() + "/";
            System.out.println(testString);
            boolean result = theValidator.isValidAuthority(testString);
            if(result != authority[i].isValid()){
                ++failCount;
                System.out.printf("ERROR: scheme: %s expected: %b observed: %b\n", authority[i].getComponentString(), authority[i].isValid(), result);
            }
        }

        if(failCount > 0){
            System.out.printf("ERROR COUNT: %d", failCount);
        }
        else{
            System.out.println("All cases passed");
        }
    }


}
   



