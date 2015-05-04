/*
 * This is a header file that is made to conduct the c file associated with
 * this program. It creates phototypes, as well as structs of which are
 * typedefs so that they may be easily referenced by the associated c file.
 *
 * AUTHOR: Kristy Carrion
 * DATE:   1/27/2013
 */
#include <stdio.h>
#include <stdlib.h>
#include <strings.h>
/*
 * This struct is a typedef(address_t) which defines a part of a person's
 * contact information.
 */
typedef struct
{
    char *zip;
    char *street_address;
    char *city;
    char *state;
} address_t;
/*
 * This struct is a typedef(person_t) which defines the second part of a
 * person's contact information.
 */
typedef struct
{
    char        *phone;
    char        *first_name;
    char        *last_name;
    address_t   *address;
} person_t;
/*
 * This function acts as a set up for the parts of the index variable.
 */
void init_person_array(person_t index[]);
/*
 * This is a helper function that sets the given char array to zero, by
 * looping over each element and setting equal to zero.
 */
void zero_array(char array[], int size);
/*
 * This function parses the given file, grabs all the seven needed variables
 * that define a person given on a single line, of which cannot excced 100
 * chars, and then initializes them into the array for a single person.
 * 
 * The function uses regualr expressions in order to achieve this. It assumes
 * that each indivdual's pieces of information are seperated by commas, and
 * come in a certain order.
 */
int parse_file(FILE *file_in, person_t data[]);
/*
 * This function uses insertion sort in order to sort the array data based
 * on the person's last name.
 */
void sort(person_t data[], int size);
/*
 * This function works as the writer in the program. It writes all of the
 * contacts into a given file, making sure to separate each individual contact
 * line by line as well as each element of a person by a comma.
 * It prints them in the format: 
 *     <first name, last name, address, city, state, zipcode, phone number>
 */
void write_to_file(FILE *out_file, person_t *data, int size);
/*
 * This function is a usage message called whenever an error along the
 * lines of not having enough arguments when you run the program or
 * if the arguments are not valid.
 * 
 * It prints with the format:
 *      "Usage: "./a.out" <input file> <output file>, filename"
 */
void usage(char filename[]);
/*
 * This function acts as a helper method to help ensure that all space
 * allocated by an array is released / freeded from memory.
 * Essentially doing the clean up.
 */
void free_array(person_t *data);
/*
 * This is the main function acting as the "driver" for the program.
 * It checks to make sure the correct arg parameters were passed to it,
 * and if they are not correct it will call usage.
 * 
 * It also creates the array in which a person's contact information goes
 * into. It then goes onto call the necessary steps in order to make sure
 * that the contacts are sorted, and printed into the given file name.
 * 
 * This function is the brains of the operation, making sure everything is
 * done correctly, without fail!
 */
int main(int argc, char *argv[]);
