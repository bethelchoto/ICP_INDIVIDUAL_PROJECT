# ICP_INDIVIDUAL_PROJECT
The program uses HashMap to store the values read from the airports, inputs and routes files; 
because the hashmap is more efficient for searching, they have a time complexity of O(1). 
It takes the start and destination and stores those values as an ArrayList. 
The program then converts ArrayList values into strings and uses those values to search if the Routes class has the given start and destination location. 
If the solution is found, it then writes to the output file by the writeToFile method defined inside the Node class.
The WriteInFile is used to take the inputs; the user specifies the start and the destination location by giving the city and country for start and destination, 
then the method will then write to the file and save it as input.csv
The Node class is used with the search class to check if the given node is in the parent node; if so, it will be looped over, searching for all successor states,
which are nodes that are reachable from the given parent node.
Search class contains ArrayList and HashSet as its datatypes. It will be appending values into the frontier and looping over them,
checking if the current node is the goal node; if not, it will continue to loop until the goal state is found. It then writes the found solution.
The Node class will then print the solution. 
A buffered reader was used to read CSV files and store the contents in a hashmap. Use a breadth-first search algorithm to search for the optimal path and return it.
However, suppose an A-star algorithm replaces the breadth-first search algorithm. In that case,
the program will be more efficient in finding the optimal path between the start destination and the final solution. 
