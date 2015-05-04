/**
 * Queue.h
 * Defines a Queue
 *
 * @author Kristy Carrion
 *
 * @version 2/21/14
 */
/**Typdefs the scruct Queue to Queue */
typedef struct Queue Queue;

struct Queue {
    /**References data associated with Queue implementation */
    void* privateData;

    /**Adds the given value to the Queue given */
    void (*enqueue)(Queue* queue, int value);

    /**Returns the first value in the given Queue */
    int (*peek)(Queue* queue);

    /**Removes an element from the given queue */
    void (*dequeue)(Queue*  queue);

    /**Determines the size of the given Queue */
    int (*size)(Queue* queue);

    /**Prints the Queue given to the screen */
    void (*print)(Queue* queue);
};
