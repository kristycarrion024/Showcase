#include <Malloc.h>

/**
 * Wrapper for malloc function.
 *
 * Exit 1: Unsuccessful malloc attempt.
 *
 * @author Kristy Carrion
 * @version 2/21/2014
 */
void* Malloc(size_t size) {
    void* ptr = NULL;
    ptr       = malloc(size);
    if(ptr == NULL) {
        printf(STDERR, "Could not allocate.");
        exit(1);
    }
    return ptr;
}
