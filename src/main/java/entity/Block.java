package entity;
/*
 * The Block class that holds the current user
 * and the user that the current user want to block
 */

public class Block {
    /*
     * @param
     * currName: A String of the name of current user. ,
     * blockName: A String of the name of the user that current user want to block.
     */
    private String currName;
    private String blockName;

    // Getter functions

    /*
     *  Getter for the username of current user
     *  @return the username of the current user
     */

    public String getCurrName() {
        return currName;
    }

    /*
     *  Getter for the username of the user that the current user want to block
     *  @return the username of the user that the current user want to block
     */

    public String getBlockName() {
        return blockName;
    }

    // Setter functions

    /**
     * sets a new current user
     * @param currName: name of new current user
     */

    public void setCurrName(String currName) {
        this.currName = currName;
    }

    /**
     * sets a new user that the current user want to block
     * @param blockName: name of new user that the current user want to block
     */

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}