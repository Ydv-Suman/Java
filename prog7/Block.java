/*
 * it represent a block class with label and color
 * this class encapsulates the properties of block and color
 * and provide method to access it
 */
public class Block {
    private String label;
    private String color;

    /*
     * constructs a new block with the arguments label and color
     * @param label as the label of block
     * @param color as the color of block
     */
    public Block(String label, String color){
        this.label = label;
        this.color = color;
    }

    /**
    * Returns the label of the block.
    * @return the label of the block
    */
    public String getLabel(){
        return this.label;
    }

    /**
    * Returns the color of the block.
    * @return the color of the block
    */
    public String getColor(){
        return this.color;
    }

    /**
    * Returns a string representation of the block, which includes
    * the label followed by the color.
    * @return a string representation of the block
    */
    @Override
    public String toString(){
        return String.format("%s%s", getLabel(), getColor());
    }
}