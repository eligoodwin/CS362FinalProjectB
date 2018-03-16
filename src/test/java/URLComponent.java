public class URLComponent {
    //component
    private final String componentString;
    //valid component
    private final boolean valid;

    //constructor
    URLComponent(String componentString, boolean validity){
        this.componentString = componentString;
        this.valid = validity;
    }

    public String getComponentString() {
        return this.componentString;
    }

    public boolean isValid() {
        return this.valid;
    }

}
