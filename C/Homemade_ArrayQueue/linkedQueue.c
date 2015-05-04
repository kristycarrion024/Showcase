#include "Malloc.h"
#include "queue.h"

/* Defines the struct node. */
typedef Node Node;

/* Struct that defines a node. */
struct Node {
    int data;
    struct Node* next;
}

/* Defines key elements for the Linked Queue. */
typedef struct LinkedQueue {
    struct *Node head;
    struct *Node tail;
    int size; 
}

/**
 * Creates a new node object.
 * 
 * @return Pointer to a node object
 */
static Node* newNode(int data, Node* next) {
   node_t* newN;
   newN = Malloc(sizeof(Node));

   newN->data = data;
   newN->next = next;

   return newN;
}

/**
 * Deletes all dynamically allocated memory associated with given node. 
 * 
 * @param Node* a pointer to a node that is to be deleted
 */
static void deleteNode(Node* ptr) {
    free(ptr); 
}

/**
 * Function will add the given int to the end of the given Queue.
 *
 * @param int adds to the end of the queue.
 */
static void linkedQueueEnqueue(int toAdd, Queue* queue) {
    LinkedQueue* linked = ((LinkedQueue*) queue->privateData);
    Node* temp              = newNode(toAdd, NULL);
    linked->tail->next = temp;
    linked->tail       = temp; 
    linked->size += 1;
}

/**
 * This function will return the first element in the given Queue.
 *
 * @return Node* pointer to the first element in the given queue.
 */
static Node* linkedQueuePeek(Queue* queue) {
    LinkedQueue* linked = ((LinkedQueue*) queue->privateData);
    return linked->head;
}

/**
 * This function will remove the first element from the queue, and free any
 * memory associated with the Node containing the first item. 
 */
static void linkedQueueDequeue(Queue* queue) {
   LinkedQueue* linked = ((LinkedQueue*) queue->privateData);
   // IF SOMETHING IS WRONG HERE THIS IS IT
   Node* temp    = linked->head->next;
   linked->head  = &temp;
   free(temp);
   linked->size -= 1;
}

/* This functiopn will return the size of the given Queue. */
static int linkedQueueSize(Queue* queue) {
    LinkedQueue* linked = ((LinkedQueue*) queue->privateData);
    return linked->size;
}

/* This function will print the contents of the given Queue to the screen. */
static void linkedQueuePrint(Queue* queue) {
    LinkedQueue* linked = ((LinkedQueue*) queue->privateData);
    Node* temp = linked->tail;
    if(temp != NULL) {
        printf("[ ");
        while(temp != NULL) {
            if(temp->next != NULL) {
                printf(" %d ,", temp->data);
                temp = temp->next;
            }
            else
                printf(" %d ", temp->data);
                printf(" ]");
        }
    }
    else
        fprintf(STDERR, "[ ]");
}

/**
 * This method will initialize the given Queue object to a LinkedQueue.
 */
static void newLinkedQueue(Queue* queue) {
    LinkedQueue* temp = (LinkedQueue*) Malloc(sizeof(LinkedQueue));
    temp->data        = (Node*) Malloc(sizeof(Node));
    temp->next        = NULL;
    temp->size        = 0;

    queue->privateData = temp;
    queue->enqueue     = linkedQueueEnqueue;
    queue->peek        = linkedQueuePeek;
    queue->dequeue     = linkedQueueDequeue;
    queue->size        = linkedQueueSize;
    queue->print       = linkedQueuePrint;
}

/**
 * This method will free any dynamically allocated memory associated with the
 * given queue and set all pointers to NULL. 
 *
 * @return void
 */
static void deleteLinkedQueue(Queue* queue) {
    Node* temp = queue->head;
    int i;
    for(i = 0; i < queue->size; i++) {
        if(temp->next != NULL) {
            Node* tempy = temp->next;
            free(temp);
            temp        = tempy;
        }
        else
            fprintf(STDERR, "%s", "Queue is already empty");
    }
}
