/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

/**
 *
 * @author Tarlach
 */

import java.util.Scanner;

public class GameOfLife 
{ 
    public static void main(String[] args) 
    { 
        int X = 15, Y = 15, Counter = 1;
  
        // Intiliazing the grid. 
        int[][] grid = { 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, 
            { 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, 
            { 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0  }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0  }, 
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0  }, 
            { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0  }, 
            { 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0  }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }, 
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  },
            { 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  },
            { 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0  },
            { 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0  },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0  },
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0  }
        }; 
  
        // Displaying the grid 
        
        System.out.println("Original Generation"); 
        for (int i = 0; i < X; i++) 
        { 
            for (int j = 0; j < Y; j++) 
            { 
                if (grid[i][j] == 0) 
                    System.out.print("O "); 
                else
                    System.out.print("X "); 
            } 
            System.out.println(); 
        } 
        System.out.println(); 
        
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of generations: ");
        while (!input.hasNextInt()) {
            input.next();
            System.out.print("Please enter a number: ");
        }

        int NumGen = input.nextInt();
        input.close();
        System.out.println();

        nextGeneration(grid, X, Y, NumGen, Counter);
    }
  
    // Function to print next generation 
    
   
    static void nextGeneration(int grid[][], int X, int Y, int NumGen, int Counter) 
    {
      
        int[][] future = new int[X][Y]; 
        if(NumGen == 0){}
        else{
            
        for (int l = 1; l < X - 1; l++) 
        { 
            for (int m = 1; m < Y - 1; m++) 
            {
                int aliveNeighbours = 0; 
                for (int i = -1; i <= 1; i++) 
                    for (int j = -1; j <= 1; j++) 
                        aliveNeighbours += grid[l + i][m + j]; 
   
                aliveNeighbours -= grid[l][m]; 
  
                // Underpopulation 
                if ((grid[l][m] == 1) && (aliveNeighbours < 2)) 
                    future[l][m] = 0; 
  
                // Overpopulation
                else if ((grid[l][m] == 1) && (aliveNeighbours > 3)) 
                    future[l][m] = 0; 
  
                // Creation of Life 
                else if ((grid[l][m] == 0) && (aliveNeighbours == 3)) 
                    future[l][m] = 1; 
  
                // Survival
                else
                    future[l][m] = grid[l][m]; 
            } 
        } 
      
        System.out.println("Generation - " + Counter); 
       
  
        for (int i = 0; i < X; i++) 
        {   
            for (int j = 0; j < Y; j++) 
            { 
                if (future[i][j] == 0) 
                    System.out.print("O "); 
                else
                    System.out.print("X "); 
            } 
            System.out.println();
            
        }
         System.out.println();
            nextGeneration(future, X, Y,NumGen - 1, Counter + 1);
            
        }  
    }
} 
