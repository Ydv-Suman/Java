/**
   Date:10/30/2024
   Course: CSCI2073-44355-fall 2024
   Description: This program RobertWorld class simulates a simple setup with two
                stack of blocks, each block have label and color. It uses method like 
                move, discard, and grab color to  modify the output. This program commands 
                from file and preocess them accordingly. Finally it make an method called 
                finalOutput that will print out output well-formatted way.

        Oh my honor, I have neither given nor received unauthorized help while
   completing this assignment.
   Name: Suman Yadav
   CWID: 30158478
 */
import java.io.*;
import java.util.*;
/*
 * The robotWorld class represent two stack (piles) of blocks
 * modify it through differnt commands based on labels, and colors
 * 
 */
public class RobotWorld{
    private StackInt<Block> pile1;
    private StackInt<Block> pile2;
    private StringBuilder strBuilder;
    private String blocks;

    /*
     * Constructs a RobotWorld with specified blocks
     * The blocks are initialized into two pile(pile1, pile2) based on the input string are seperated by comma
     * @ param blocks A string representing the blocks, formatted as pile1, pile2
     * each pile is formatted as labels, and color in alternating way
     * uses delimiter to seperate pile1, and pile2
     */
    public RobotWorld(String blocks){
        pile1 = new LinkedStack<>();
        pile2 = new LinkedStack<>();
        this.strBuilder = new StringBuilder();
        this.blocks = blocks;
        Scanner scan = new Scanner(this.blocks);
        scan.useDelimiter(",");
        String pile_1 = scan.next();
        String pile_2 = scan.next();
        for(int i = 0; i<pile_1.length(); i = i+2){
            String label = pile_1.substring(i, i+1);
            String color = pile_1.substring(i+1,i+2);
            pile1.push(new Block(label, color));
        }
        for(int i = 0; i<pile_2.length(); i = i+2){
            String label = pile_2.substring(i, i+1);
            String color = pile_2.substring(i+1, i+2);
            pile2.push(new Block(label, color));
        }
        scan.close();

    }

    /*
     * process commands from a specified file
     * @ filename The name of file containing commands.
     * each line in file contains commands followed by an  element
     * after executing the actions, it appends a newline to the string builder
     * @ return A string representing final output of piles after executing all commands in formatted ways
     * @ throws IOException if error occured during handling the file.
     */
    public String commands(String filename){
        Scanner scan;
        try {
            scan = new Scanner(new File(filename));
            while(scan.hasNextLine()){
            String eachLine = scan.nextLine();
            Scanner in = new Scanner(eachLine);
            String action = in.next();
            String element = in.next();
            if (action.equals("move")){
                move(element);
                finalOutput();
                this.strBuilder.append("\n");
            }
            else if(action.equals("discard")){
                discard(element);
                finalOutput();
                this.strBuilder.append("\n");
            }
            else{
                grab_color(element);
                finalOutput();
                this.strBuilder.append("\n");
            }

            in.close();
        }
        scan.close();
        }
        catch (IOException e){
            e.getMessage();
        }
        return this.strBuilder.toString().trim();
    }
    
    /* 
     * it moves a block with specified label from one pile to another pile
     * it searches for the blocks in both piles
     * it only search in pile2 if not found in pile 1
     * if found, it put to another pile(from pile1 to pile2 and vice versa) and search stops
     * rest of the blocks fromwhich block id moved, is restored in original format
     * @ param label the label of the block to be moved.
    */
    public void move(String label){
        StackInt<Block> tempStack = new LinkedStack<>();
        boolean label_Found = false;
        while(!pile1.empty()){
            Block temp = pile1.pop();
            if(temp.getLabel().equals(label)){
                pile2.push(temp);
                label_Found = true;
                while(!tempStack.empty()){
                    pile1.push(tempStack.pop());
                }
            }
            else{
                tempStack.push(temp);
            }       
        }
        while(!tempStack.empty()){
            pile1.push(tempStack.pop());
        }

        if (!label_Found){
            while(!pile2.empty()){
                Block temp = pile2.pop();
                if(temp.getLabel().equals(label)){
                    pile1.push(temp);
                    while(!tempStack.empty()){
                        pile2.push(tempStack.pop());
                    }
                }
                else{
                    tempStack.push(temp);
                }       
            }
        while(!tempStack.empty()){
            pile2.push(tempStack.pop());
        }
        }
    }

    /* 
     * it discards a block with specified label from one pile to another pile
     * it searches for the blocks in both piles
     * if the block is found in either pile, it is discarded from pile and search stops
     * rest of the blocks from with block is discarded, is restored in original format except discarded block
     * @ param label the label of the block to be discarded.
    */
    public void discard(String label){
        StackInt<Block>tempStack = new LinkedStack<>();
        boolean label_Found = false;
        while(!pile1.empty()){
            Block temp = pile1.pop();
            if(temp.getLabel().equals(label)){
                label_Found = true;
                while(!tempStack.empty()){
                    pile1.push(tempStack.pop());
                }
            }
            else{
                tempStack.push(temp);
            }       
        }
        while(!tempStack.empty()){
            pile1.push(tempStack.pop());
        }
        if (!label_Found){
            while(!pile2.empty()){
                Block temp = pile2.pop();
                if(temp.getLabel().equals(label)){
                    while(!tempStack.empty()){
                        pile2.push(tempStack.pop());
                    }
                }
                else{
                tempStack.push(temp);
                }       
            }
        while(!tempStack.empty()){
            pile2.push(tempStack.pop());
        }
        }
    }

    /*
     * it grabs  the first-found block of color C
     * it searches for the specified color in both pile even it is found in first pile
     * then it removes the found block
     * if not found in either pile action is terminatted
     * @ param color The color of the blocked to grabbed
     */
    public void grab_color(String color){
        StackInt<Block>tempStack = new LinkedStack<>();
        while(!pile1.empty()){
            Block temp = pile1.pop();
            if(temp.getColor().equals(color)){
                while(!tempStack.empty()){
                    pile1.push(tempStack.pop());
                }
                break;
            }
            else{
                tempStack.push(temp);
            }       
        }
        while(!tempStack.empty()){
            pile1.push(tempStack.pop());
        }
        while(!pile2.empty()){
            Block temp = pile2.pop();
            if(temp.getColor().equals(color)){
                while(!tempStack.empty()){
                    pile2.push(tempStack.pop());
                }
                break;
            }
            else{
                tempStack.push(temp);
            }       
            }
        while(!tempStack.empty()){
            pile2.push(tempStack.pop());
        }

    }

    /* 
     * it generates and returns the final output representing the current blocks of piles
     * output includes pile and blocks in it,  adjoint with another pile
     * after each of the commands is performmed like move, discard, and grab color
     * it uses string builder to contains blocks of each file
     * it is formatted using [] around aech of the piles
     * @ return a string representing final output of robot world, including th eblocs in each pile
    */
    public void finalOutput(){
    StackInt<Block> tempStack = new LinkedStack<>();
    this.strBuilder.append("PILE 1: [");
    while(!pile1.empty()){
        Block temp = pile1.pop();
        this.strBuilder.append(temp.toString());
        this.strBuilder.append(" ");
        tempStack.push(temp);
    }
    while(!tempStack.empty()){
        pile1.push(tempStack.pop());
    }
    strBuilder.replace(this.strBuilder.length() - 1, this.strBuilder.length(), "");
    this.strBuilder.append("] PILE 2: [");
    while(!pile2.empty()){
        Block temp = pile2.pop();
        this.strBuilder.append(temp.toString());
        this.strBuilder.append(" ");
        tempStack.push(temp);
    }
    while(!tempStack.empty()){
        pile2.push(tempStack.pop());
    }
    strBuilder.replace(this.strBuilder.length() - 1, this.strBuilder.length(), "");
    this.strBuilder.append("]");
} 
}