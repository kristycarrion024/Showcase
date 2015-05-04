/**
 * This file will contain a concrete array-based realization of a Queue.
 *
 * @author Kristy Carrion
 *
 * @version 02/21/2014
 */

#include <stdio.h>
#include <stdlib.h>
#include "arrayQueue.h"
#include "q"

//
typedef enum 
{
    INITIAL_CAPACITY = 10,
    RESIZE_FACTOR = 2
} initials;

//
typedef struct ArrayQueue 
{
    int* data;
    int capacity;
    int size;
} ArrayQueue;

/**
 * This function will add a given int to the end of the give Queue.
 *
 * @param quePntr a pointer to a Queue struct
 * @param addition int that you are adding to the queue
 */
static void arrayQueueEnqueue(Queue* quePntr, int addition)
{
    ArrayQueue* array = ((ArrayQueue*) quePntr -> privateData);
       
    if (array -> size == array -> capacity)
    {
        int newCapacity = array -> capacity * RESIZE_FACTOR;
        ArrayQueue aQStruct;
        aQStruct -> data = (int*) Malloc(sizeof(int) * newCapacity);
        aQStruct -> capacity = newCapacity;
        aQStruct -> size = array -> size;
        array -> data = aQStruct;
    }

    (array -> data)[array -> size] = addition;
    int plus = array -> size;
    array -> size = (plus + 1);
}

/**
 * This function will return the first element in the given Queue.
 *
 * @param quePntr a pointer to a Queue struct
 */
static int arrayQueuePeek(Queue* quePntr)
{
    return ((int*)(quePntr -> privateData))[0];
}

/**
 * This function will remove the first element of the given Queue.
 *
 * @param quePntr a pointer to a Queue struct 
 */
static void arrayQueueDequeue(Queue* quePntr)
{
    ArrayQueue* array = ((ArrayQueue*) quePntr -> privateData);
    int i = 0;
       
    for (int i = 0; i < array -> size; i++)
    {
        (array -> data)[i] = (array -> data)[i + 1];
    }

    if (array -> size != 0)
    {
        int minus = array -> size;
        array -> size = (minus - 1);
    }
}

/**
 * This function will return the size of the given Queue.
 *
 * @param quePntr a pointer to a Queue struct
 */
static int arrayQueueSize(Queue* quePntr)
{
    ArrayQueue* array = ((ArrayQueue*) quePntr -> privateData);
    return array -> size;
}

/**
 * This function will print the contents of the given Queue to the screen.
 *
 * @param quePntr a pointer to a Queue struct 
 */
static void arrayQueuePrint(Queue* quePntr)
{
    ArrayQueue* array = ((ArrayQueue*) quePntr -> privateData);

    printf("[")

    for (int i = 0; i < array -> size; i++)
    {
        if (i + 1 == array -> size)
        {
            printf("%d", (array -> data)[i]);
        }
        else
        {
            printf("%d, ", (array -> data)[i]);
        }
    }

    printf("]\n");
}

/**
 * This function will initialize the given Queue to an ArrayQueue.
 *
 * @param quePntr a pointer to a Queue struct
 */
void newArrayQueue(Queue* quePntr) 
{
    // creating/initializing an ArrayQueue
    ArrayQueue aQStruct;
    aQStruct -> data = (int*) Malloc(sizeof(int) * INITIAL_CAPACITY);
    aQStruct -> capacity = INITIAL_CAPACITY;
    aQStruct -> size = 0;

    // initializing pointers
    quePntr -> privateData = aQStruct;
    quePntr -> enqueue = newArrayQueueEnqueue;
    quePntr -> peek = arrayQueuePeek;
    quePntr -> dequeue = arrayQueueDequeue;
    quePntr -> size = arrayQueueSize;
    quePntr -> print = arrayQueuePrint;
}

/**
 * This function will free any dynamically allocated memory associated with the 
 * given Queue and set all pointers to NULL.
 *
 * @param quePntr a pointer to a Queue struct 
 */
void deleteArrayQueue(Queue* quePntr) 
{
    free(quePntr -> data);
    quePntr -> enqueue = NULL;
    quePntr -> peek = NULL;
    quePntr -> dequeue = NULL;
    quePntr -> size = NULL;
    quePntr -> print = NULL;
}
