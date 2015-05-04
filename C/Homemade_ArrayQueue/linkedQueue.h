/**
 * Header file for linkedQueue.c
 *
 * @author Kristy Carrion
 * @version 2/21/2014
 */

/* Returns a pointer to a Node object */
static Node* newNode(int data, Node* node);

/* Deletes all dynamically allocated memory associated with given node. */
static void deleteNode(Node* ptr);

/* Function will add the given int to the end of the given Queue. */
static void linkedQueueEnqueue(int toAdd, Queue* queue);

/* This function will return the first element in the given Queue. */
static Node* linkedQueuePeek(Queue* queue);

/* This function will remove the first element from the queue, and free any
 * memory associated with the Node containing the first item. */
static void linkedQueueDequeue(Queue* queue);

/* This function will return the size of the given Queue. */
static int linkedQueueSize(Queue* queue);

/* This function will print the contents of the given Queue to the screen. */
static void linkedQueuePrint(Queue* queue);

/* This method will initialize the given Queue object to a LinkedQueue. */
static void newLinkedQueue(Queue* queue);

/* This method will free any dynamically allocated memory associated with the
 * given queue and set all pointers to NULL. */
static void deleteLinkedQueue(Queue* node);
