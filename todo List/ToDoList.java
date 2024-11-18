import java.util.Scanner;
public class ToDoList{
    
    public static void main(String[] args){
        final int numberOfTask = 100;
        String[] task = new String[numberOfTask];
        int taskCount = 0;
        Scanner input = new Scanner(System.in); 
        while(true){
            // displayig options for ToDoList
            System.out.println("ToDoList option:");
            System.out.println("Hello");
            System.out.println("----------------");
            System.out.println("1. Add Task");
            System.out.println("2. Remove Task");
            System.out.println("3. Update Task");
            System.out.println("4. View Task");
            System.out.println("5. Exit");

            // Asking for user input(Choice)
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1: // adding tasks
                    String userResponse;
                    do{
                        System.out.print("Enter a task: ");
                        task[taskCount] = input.nextLine();
                        taskCount++;
                        System.out.print("Do you want to add more tasks(y/n): ");
                        userResponse = input.nextLine();
                    }
                    while (userResponse.equalsIgnoreCase("y"));
                    break;
            
                case 2: // asks user to remove any specific task number
                    String removeTaskConfirm;
                    do{
                        System.out.print("Enter task number to be removed: ");
                        int removeTask = input.nextInt();
                        input.nextLine();
                        if (removeTask >= 0 && removeTask <= taskCount){
                            for(int i = removeTask-1; i < taskCount;i++){
                                task[i] = task[i+1];
                            }
                            task[taskCount-1] = null;
                            taskCount--;
                            System.out.println("Task removed successfully.");
                        }
                        else{
                            System.out.println("Invalid task number.");
                        }
                    System.out.print("Do you want to remove more task(y/n): ");
                    removeTaskConfirm = input.nextLine();
                    }
                    while(removeTaskConfirm.equalsIgnoreCase("y"));
                    
                    break;

                case 3: // asks user to update any specific task number
                    String updateTaskConfirm;
                    do{
                        System.out.print("Enter the number that needs to be updated: ");
                        int updateTask = input.nextInt();
                        input.nextLine();
                        if (updateTask >= 0 && updateTask <= taskCount){
                            System.out.print("Enter new task: ");
                            task[updateTask-1] = input.nextLine();
                            System.out.println("Task Updated successfully");
                        }
                        else{
                            System.out.println("Invalid task Number.");
                        }
                        System.out.print("Do you want to update more tasks(y/n): ");
                        updateTaskConfirm = input.nextLine();
                    }
                    while(updateTaskConfirm.equalsIgnoreCase("y"));
                    break;

                case 4: // display all the to od list
                    System.out.print("\nTasks\n");
                    System.out.print("------\n\n");
                    if(taskCount == 0){
                        System.out.println("No task added");
                    }
                    for (int i = 0; i<taskCount; i++){
                        System.out.println(i+1 + ". " + task[i]);
                    }
                    System.out.println("\n");
                    break;
                
                case 5: // exiting
                    System.out.println("Done");
                    input.close();
                    return;

                default: // asks use to enter valid task options
                    System.out.println("Invalid choice. Enter a valid choice: ");
                    break;
            } // end switch
        } // end while5
    } // end main
} // end class