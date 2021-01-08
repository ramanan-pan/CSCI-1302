package cs1302.interfaces.impl;

import cs1302.interfaces.contract.Styleable;

/**
 * This class representes a <i>super fancy</i> message.
 *
 */
public class SuperFancy implements Styleable {

    private String message;
    private boolean styled;
    private Styleable.State state;

    /**
     * Constructs a new {@code SuperFancy} object with a specified
     * message.
     * {@code SuperFancy} objects are initially unstyled.
     * @param msg the message to store in the object.
     */
    public SuperFancy(String msg) {
        message = msg;
        styled = false;
        state = Styleable.State.UNSTYLED;
    } // Secret

    public void style() {
        styled = true;
        state = Styleable.State.STYLED;
    } // style

    public void unstyle() {
        styled = false;
        state = Styleable.State.UNSTYLED;
    } // unstyle

    /**
     * Returns a {@code String} containing information about this object.
     *
     * @return the about information
     */
    public String getAbout() {
        return "A styled SuperFancy object contains characters that alternate" +
            " between upper and lowercase.";
    } // getAbout

    /**
     * Returns a {@code String} representation of this {@code SuperFancy}
     * object, consistent with {@link cs1302.interfaces.contract.Styleable}.
     * @return the {@code String} value of this object
     */
    public String toString() {
        String content = "";
        if(styled) {
            // Alternate upper and lower case for each letter
            for(int i = 0; i < message.length(); i++) {
                if(i % 2 == 0) {
                    content += Character.toUpperCase(message.charAt(i));
                } else {
                    content += Character.toLowerCase(message.charAt(i));
                } // if
            } // for
            content = "*** " + content + " ***";
        } else {
            content = message;
        } // if
        return String.format("Super Fancy(%s)", content);
    } // toString
    @Override
    public Styleable.State getState() {
        return this.state;
    } // getState

} // SuperFancy
