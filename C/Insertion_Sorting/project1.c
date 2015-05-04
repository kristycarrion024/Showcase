/*
 * This c program takes a given set of person information and sorts it using
 * the insertion sort algorithm to organize the given information by last name.
 *
 * The program then prints out the newly organized information to the 
 * designated file. The format for running the program is as directed by the
 * usage function. 
 *          i.e: Usage: <input file> <output file>
 *
 * It also assumes that a line defines a person's information, of which are all
 * separated by six commas, totaling to seven fields of personal information.
 * The program also makes the assumption that no line can be greater than a
 * 100 char length.
 *
 * AUTHOR: Kristy Carrion
 * DATE: 1/27/2013
 */
#include "project1.h"
#define DATA_RECORD_MEMBERS   7
#define NUM_PEOPLE          100
#define MAX_RECORD_SIZE     100
#define CHAR_LENGTH         50
#define NUM_ARGS            0
#define NUM_ARGS_A          1
#define NUM_ARGS_B          2
#define NUM_ARGS_C          3

void init_person_array(person_t index[])
{
    int i = 0;
    for (i = 0; i < NUM_PEOPLE; i++)
    {
        index[i].first_name = calloc(CHAR_LENGTH, sizeof(char));
        zero_array(index[i].first_name, CHAR_LENGTH); 

        index[i].last_name = calloc(CHAR_LENGTH, sizeof(char));
        zero_array(index[i].last_name, CHAR_LENGTH);

        index[i].address = malloc(sizeof(address_t));

        index[i].address->street_address = calloc(CHAR_LENGTH, sizeof(char));
        zero_array(index[i].address->street_address, CHAR_LENGTH);

        index[i].address->city = calloc(CHAR_LENGTH, sizeof(char));
        zero_array(index[i].address->city, CHAR_LENGTH);

        index[i].address->state = calloc(CHAR_LENGTH, sizeof(char));
        zero_array(index[i].address->state, CHAR_LENGTH);

        index[i].phone = calloc(CHAR_LENGTH, sizeof(char));
        zero_array(index[i].phone, CHAR_LENGTH);

        index[i].address->zip = calloc(CHAR_LENGTH, sizeof(char));
        zero_array(index[i].address->zip, CHAR_LENGTH);
    }
}

void zero_array(char array[], int size)
{
    int i = 0;
    for (i = 0; i < size; i++)
    {
        array[i] = 0;
    }
}

int parse_file(FILE *file_in, person_t data[])
{
    int i = 0;
    char *line = calloc(MAX_RECORD_SIZE, sizeof(char));
    zero_array(line, MAX_RECORD_SIZE);
    while (((fgets(line, MAX_RECORD_SIZE, file_in) != NULL)))
    {
        sscanf(line, " %[^,],%[^,],%[^,],%[^,],%[^,],%[^,],%s", 
                data[i].first_name, 
                data[i].last_name, 
                data[i].address->street_address, 
                data[i].address->city, 
                data[i].address->state, 
                data[i].address->zip, 
                data[i].phone);
               i++;
    }
    free(line);
    return i;
}

void sort(person_t data[], int size)
{
    int i   = 0;
    int j   = 0;
    int min = 0;
    for (i = 0; i < size - 1; i++)
    {
        min = i;
        for(j = i + 1; j < size; j++)
        {
            int compare = strcasecmp(data[j].last_name, data[min].last_name);
            if(compare < 0)
            {
                min = j;
            }
            else if (compare == 0)
            {
                if(strcasecmp(data[j].first_name, data[min].first_name) < 0)
                {
                    min = j;
                }
            }
        }
        if (min != i )
        {
            person_t temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }
}

void write_to_file(FILE *out_file, person_t *data, int size)
{
    int i = 0;
    for (i = 0; i < size; i++)
    {
       fprintf(out_file, "%s,%s,%s,%s,%s,%s,%s\n", 
               data[i].first_name,
               data[i].last_name,
               data[i].address->street_address,
               data[i].address->city,
               data[i].address->state,
               data[i].address->zip,
               data[i].phone);
    }
}

void free_array(person_t *data)
{
    int i = 0;
    for (i = 0; i < NUM_PEOPLE; i++)
    {
        free(data[i].first_name);
        free(data[i].last_name);
        free(data[i].address->street_address);
        free(data[i].address->city);
        free(data[i].address->state);
        free(data[i].phone);
        free(data[i].address->zip);
        free(data[i].address);
    }
    free(data);
}

void usage(char filename[])
{
    printf("Usage: %s <input file> <output file>\n", filename);
    exit(1);
}

int main(int argc, char *argv[])
{
    if (argc != NUM_ARGS_C)
    {
        usage(argv[NUM_ARGS]);
    }
    person_t *data = calloc(NUM_PEOPLE, sizeof(person_t));
    init_person_array(data);
    FILE *file_in = fopen (argv[NUM_ARGS_A], "r");
    if (file_in == NULL)
    {
        fprintf(stderr,"ERROR: Could not open %s for reading.\n", 
                 argv[NUM_ARGS_A]);
        usage(argv[NUM_ARGS]);
    }
    FILE *file_out = fopen(argv[NUM_ARGS_B], "w");
    if (file_out == NULL)
    {
        fprintf(stderr, "ERROR: Could not open %s for writing.\n", 
                 argv[NUM_ARGS_B]);
        usage(argv[NUM_ARGS]);
    }
    int array_size = parse_file(file_in, data);
    fclose(file_in);
    sort(data, array_size);
    write_to_file(file_out, data, array_size);
    fclose(file_out);
    free_array(data);
    return 0;
}
