public class URLComponent {
    //component
    private final String componentString;
    //valid component
    private final boolean validity;


    //constructor
    URLComponent(String componentString, boolean validity){
        this.componentString = componentString;
        this.validity = validity;
    }

    public String getComponentString() {
        return componentString;
    }

    public boolean isValidity() {
        return validity;
    }

}
